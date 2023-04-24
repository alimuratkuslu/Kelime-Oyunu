import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { TextField, Button, Typography, Grid } from '@material-ui/core';

function Game() {
  const [name, setName] = useState('');
  const [gameStarted, setGameStarted] = useState(false);
  const [gameEnded, setGameEnded] = useState(false);
  const [timer, setTimer] = useState(5 * 60); 
  const [currentQuestion, setCurrentQuestion] = useState(0);
  const [questions, setQuestions] = useState([]);
  const [question, setQuestion] = useState(null);
  const [userAnswer, setUserAnswer] = useState("");
  const [player, setPlayer] = useState(null);
  const [displayedAnswer, setDisplayedAnswer] = useState('');
  const [revealedAnswer, setRevealedAnswer] = useState('');
  const [negativePoint, setNegativePoint] = useState(0);
  const [numCharactersRevealed, setNumCharactersRevealed] = useState(0);

  const handleNameChange = (event) => {
    setName(event.target.value);
  };

  const handleStartGame = async () => {
    const response = await axios.post('/player', { name });
    console.log(response.data);
    setGameStarted(true);
    setPlayer(response.data);
    setDisplayedAnswer("_".repeat(questions[currentQuestion].answer.length));
    setRevealedAnswer("");
  };

  const handleAnswerSubmit = async () => {
    
    if (userAnswer === questions[currentQuestion].answer) {
      const newPoints = player.points + questions[currentQuestion].point;
      setPlayer({ ...player, points: newPoints });
      await setCurrentQuestion(currentQuestion + 1);

      if (currentQuestion + 1 < questions.length) {
        setQuestion(questions[currentQuestion + 1]);
        setDisplayedAnswer(
          questions[currentQuestion + 1].answer
            .split('')
            .map((char) => (char === ' ' ? ' ' : '_'))
            .join('')
        );
      }
      else {
        setGameEnded(true);
      } 
    }
    else if (revealedAnswer !== "") {
      const revealedChars = revealedAnswer.split('');
      const newDisplayedAnswer = displayedAnswer.split('').map((char, index) => {
        if (revealedChars.includes(questions[currentQuestion].answer.charAt(index))) {
          return questions[currentQuestion].answer.charAt(index);
        } else {
          return char;
        }
      }).join('');
      setDisplayedAnswer(newDisplayedAnswer);
      setRevealedAnswer(newDisplayedAnswer);
    }
    setUserAnswer("");
  };

  useEffect(() => {

    const fetchQuestions = async () => {
      const questionData = await fetch('/question/randomQuestions');
      const questionJson = await questionData.json();
      console.log(questionJson);
      setQuestions(questionJson);
    };
    fetchQuestions();

    const timerInterval = setInterval(() => {
      setTimer((prevTimer) => prevTimer - 1);
    }, 1000);

    return () => {
      clearInterval(timerInterval);
    };

  }, []);

  const handleRevealCharacter = async () => {
    try {
      const answer = questions[currentQuestion].answer;
      const numCharactersRevealed = displayedAnswer.split('').filter((char) => char !== '_').length;

      if (numCharactersRevealed < answer.length) {

        const hiddenCharIndices = answer.split('').map((char, index) => {
          if (displayedAnswer.charAt(index) === '_') {
            return index;
          }
          return -1;
        }).filter(index => index >= 0);
      
        if (hiddenCharIndices.length > 0) { // Check if there are hidden characters to reveal
          const indexToReveal = hiddenCharIndices[Math.floor(Math.random() * hiddenCharIndices.length)];
          const charToReveal = answer.charAt(indexToReveal);
      
          const newDisplayedAnswer = displayedAnswer.split('').map((char, index) => {
            if (index === indexToReveal) {
              return charToReveal;
            }
            return char;
          }).join('');
      
          setDisplayedAnswer(newDisplayedAnswer);
          setNumCharactersRevealed((prevNumCharactersRevealed) => prevNumCharactersRevealed + 1);
          setNegativePoint((prevNegativePoint) => prevNegativePoint + 1);
          setPlayer((prevPlayer) => ({
            ...prevPlayer,
            points: prevPlayer.points - 100,
          }));
        }
      }
    } catch (error) {
      console.error(error);
    }
  };


  const minutes = Math.floor(timer / 60);
  const seconds = timer % 60;
  const paddedSeconds = seconds.toString().padStart(2, '0');

  if (!gameStarted) {
    return (
      <div className='app1'>
        <Typography variant='h1'> Yeni Oyun</Typography>
          <Typography variant='h6' style={{marginRight: '20px'}}> İsminizi Girin: </Typography>
          <TextField label='İsim' type='text' variant='outlined' id='name' value={name} onChange={handleNameChange} inputProps={{ style: { fontSize: 15, color: 'white' } }}
            InputLabelProps={{ style: { fontSize: 15, color: "GrayText" } }}
          />
        <Button variant='outlined' onClick={handleStartGame} color='primary'>İlerle</Button>
      </div>
    );
  }
  else {

  }

  return (
    <div className='app'>
      <div style={{ display: 'flex', flexDirection: 'column', justifyContent: 'center', alignItems: 'center'}}>
        <p style={{fontSize: '50px'}}>{displayedAnswer.split('').map((char, index) => {
            if (char === '_') {
              return <span key={index} style={{marginRight: '5px'}}>{char}</span>
            } else {
              return <span key={index} style={{marginRight: '5px'}}>{char}</span>
            }
          })}
        </p>
        {currentQuestion < questions.length && (
          <Button variant='outlined' onClick={handleRevealCharacter}> Harf Al </Button>
        )}
        {gameEnded && (
          <>
            <Grid container spacing={2}>
              <Grid item xs={12}>
                <Typography variant="h5">Toplam Puan: {player.points}</Typography>
              </Grid>
              <Grid item xs={12}>
                <Typography variant="body1">Toplam Alınan Harf: {negativePoint}</Typography>
              </Grid>
            </Grid>
          </>
        )}
      </div>
      <div style={{ display: 'flex', flexDirection: 'column', justifyContent: 'center', alignItems: 'center', paddingLeft: '200px'}}>
        <p>Kalan Süre: {minutes}:{paddedSeconds}</p>
        {currentQuestion < questions.length && (
          <>
            <div className='question-section'>
              <h2>Soru {currentQuestion + 1}</h2>
              <br />
              <Typography variant='body1' style={{ fontSize: '20px'}}>{questions[currentQuestion].description}</Typography>
            </div>
            <br />
            <div className='answer-section'>
              <TextField
                label='Cevap'
                variant='outlined'
                type="text"
                name={currentQuestion}
                value={userAnswer}
                color='primary'
                InputProps={{
                  style: { color: userAnswer ? 'white' : 'initial' },
                }}
                onChange={(event) => setUserAnswer(event.target.value)}
              />
              <br />
              <Button variant='outlined' color='primary' onClick={handleAnswerSubmit}>Cevapla</Button>
            </div>
            <br />
            <div className='score-section'>
              <Grid container spacing={2}>
                <Grid item xs={12}>
                  <Typography variant="h5">Oyuncu ismi: {player.name}</Typography>
                </Grid>
                <Grid item xs={12}>
                  <Typography variant="body1">Puan: {player.points}</Typography>
                </Grid>
              </Grid>
            </div>
          </>
        )}
      </div>
    </div>
  );
}   

export default Game;