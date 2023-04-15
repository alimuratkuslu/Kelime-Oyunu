package com.kelimeoyunu.service;

import com.kelimeoyunu.dto.PlayerResponse;
import com.kelimeoyunu.dto.QuestionResponse;
import com.kelimeoyunu.dto.SavePlayerRequest;
import com.kelimeoyunu.dto.SaveQuestionRequest;
import com.kelimeoyunu.model.Player;
import com.kelimeoyunu.model.Question;
import com.kelimeoyunu.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Question getQuestionById(Integer id){
        Question question = questionRepository.findById(id).orElseThrow(RuntimeException::new);

        return question;
    }

    public List<Question> getAllQuestions(){
        List<Question> questions = new ArrayList<>();
        questionRepository.findAll().forEach(questions::add);

        return questions;
    }

    public Question pickRandomQuestion(){
        List<Question> questions = getAllQuestions();
        int size = questions.size();

        Random random = new Random();
        int randomIndex = random.nextInt(size);

        Question randomQuestion = questions.get(randomIndex);

        return randomQuestion;
    }

    private Set<Integer> revealedIndices = new HashSet<>();

    public String revealCharacter(String answer){
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        int revealIndex;
        do {
            revealIndex = random.nextInt(answer.length());
        } while (revealedIndices.contains(revealIndex));

        for (int i = 0; i < answer.length(); i++) {
            if (i == revealIndex) {
                sb.append(answer.charAt(i));
                revealedIndices.add(i);
            } else if (revealedIndices.contains(i)) {
                sb.append(answer.charAt(i));
            } else {
                sb.append('_');
            }
        }

        return sb.toString();
    }

    public List<List<Question>> groupQuestions(){
        List<Question> questions = getAllQuestions();

        List<Question> fourLetterQuestions = new ArrayList<>();
        List<Question> fiveLetterQuestions = new ArrayList<>();
        List<Question> sixLetterQuestions = new ArrayList<>();
        List<Question> sevenLetterQuestions = new ArrayList<>();
        List<Question> eightLetterQuestions = new ArrayList<>();
        List<Question> nineLetterQuestions = new ArrayList<>();
        List<Question> tenLetterQuestions = new ArrayList<>();

        for (int i = 0; i < questions.size(); i++) {
            if (questions.get(i).getAnswer().length() == 4){
                fourLetterQuestions.add(questions.get(i));
            } else if (questions.get(i).getAnswer().length() == 5) {
                fiveLetterQuestions.add(questions.get(i));
            }
            else if (questions.get(i).getAnswer().length() == 6) {
                sixLetterQuestions.add(questions.get(i));
            }
            else if (questions.get(i).getAnswer().length() == 7) {
                sevenLetterQuestions.add(questions.get(i));
            }
            else if (questions.get(i).getAnswer().length() == 8) {
                eightLetterQuestions.add(questions.get(i));
            }
            else if (questions.get(i).getAnswer().length() == 9) {
                nineLetterQuestions.add(questions.get(i));
            }
            else if (questions.get(i).getAnswer().length() == 10) {
                tenLetterQuestions.add(questions.get(i));
            }
        }

        List<List<Question>> result = new ArrayList<>();

        result.add(fourLetterQuestions);
        result.add(fiveLetterQuestions);
        result.add(sixLetterQuestions);
        result.add(sevenLetterQuestions);
        result.add(eightLetterQuestions);
        result.add(nineLetterQuestions);
        result.add(tenLetterQuestions);

        return result;

    }

    public List<Question> pickQuestions(){
        List<List<Question>> questions = groupQuestions();

        List<Question> results = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < questions.size(); i++) {
            List<Question> group = questions.get(i);
            for (int j = 0; j < 2 && !group.isEmpty(); j++) {
                int index = random.nextInt(group.size());
                results.add(group.get(index));
                group.remove(index);
            }
        }

        for (int i = 0; i < results.size(); i++) {
            System.out.println(results.get(i).getDescription() + "       " + results.get(i).getAnswer());
        }

        return results;
    }

    public QuestionResponse saveQuestion(SaveQuestionRequest request){

        Integer questionPoint = request.getAnswer().length() * 100;

        Question question = Question.builder()
                .description(request.getDescription())
                .answer(request.getAnswer())
                .point(questionPoint)
                .build();

        Question fromDB = questionRepository.save(question);

        return QuestionResponse.builder()
                .description(fromDB.getDescription())
                .answer(fromDB.getAnswer())
                .point(fromDB.getPoint())
                .build();
    }
}
