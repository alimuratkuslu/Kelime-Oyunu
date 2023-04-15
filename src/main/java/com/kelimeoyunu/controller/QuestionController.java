package com.kelimeoyunu.controller;

import com.kelimeoyunu.dto.PlayerResponse;
import com.kelimeoyunu.dto.QuestionResponse;
import com.kelimeoyunu.dto.SavePlayerRequest;
import com.kelimeoyunu.dto.SaveQuestionRequest;
import com.kelimeoyunu.model.Player;
import com.kelimeoyunu.model.Question;
import com.kelimeoyunu.service.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/question")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable Integer id){
        return ResponseEntity.ok(questionService.getQuestionById(id));
    }

    @GetMapping
    public ResponseEntity<List<Question>> getAllQuestions(){
        return ResponseEntity.ok(questionService.getAllQuestions());
    }

    @PostMapping
    public ResponseEntity<QuestionResponse> saveQuestion(@RequestBody SaveQuestionRequest request){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(questionService.saveQuestion(request));
    }

    @GetMapping("/randomQuestion")
    public ResponseEntity<Question> pickRandomQuestion(){
        return ResponseEntity.ok(questionService.pickRandomQuestion());
    }

    @GetMapping("/randomQuestions")
    public ResponseEntity<List<Question>> getRandomQuestions(){
        return ResponseEntity.ok(questionService.pickQuestions());
    }

    @GetMapping("/revealCharacter")
    public ResponseEntity<String> revealCharacter(@RequestParam String answer){
        return ResponseEntity.ok(questionService.revealCharacter(answer));
    }
}
