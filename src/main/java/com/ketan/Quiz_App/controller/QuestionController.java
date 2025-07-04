package com.ketan.Quiz_App.controller;

import com.ketan.Quiz_App.model.Question;
import com.ketan.Quiz_App.service.QuestionService;
import com.ketan.Quiz_App.service.QuizService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admin/questions")
@CrossOrigin(origins = "https://localhost:3000")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    //get all que
    @GetMapping
    public ResponseEntity<List<Question>> getAllQuestions(){
        return ResponseEntity.ok(questionService.getAllQuestions());
    }

    //get que by id
    @GetMapping("/{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable Long id){
        Optional<Question> question = questionService.getQuestionById(id);

        return question.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //create que
    @PostMapping
    public ResponseEntity<Question> createQuestion(@Valid @RequestBody Question question){
        Question savedQuestion = questionService.saveQuestion(question);
        return ResponseEntity.ok(savedQuestion);
    }

    //update new que
    @PostMapping("/{id}")
    public ResponseEntity<Question> updateQuestion(@PathVariable Long id,
                                                   @Valid @RequestBody Question questionDetails){

        Question updatedQuestion = questionService.updateQuesttion(id,questionDetails);

        return updatedQuestion != null ? ResponseEntity.ok(updatedQuestion)
                : ResponseEntity.notFound().build();

    }

    //delete que
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable Long id){
        boolean delted = questionService.deleteQuestion(id);

        return delted ? ResponseEntity.ok().build()
                : ResponseEntity.notFound().build();
    }

    //delete leaderboard
    @DeleteMapping("/leaderboard")
    public ResponseEntity<Void> deleteLeaderboard(){
        questionService.deleteAllQuizResult();
        return ResponseEntity.ok().build();
    }

    //get by cat
    @GetMapping("/categor/{category}")
    public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category){
        return ResponseEntity.ok(questionService.getQuestionByCategory(category));
    }

    //get by diffi
    @GetMapping("/difficulty/{difficulty}")
    public ResponseEntity<List<Question>> getQuestionByDifficulty(@PathVariable String difficulty){
        return ResponseEntity.ok(questionService.getQuestionByDifficulty(difficulty));
    }
}

