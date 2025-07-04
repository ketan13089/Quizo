package com.ketan.Quiz_App.controller;

import com.ketan.Quiz_App.model.Question;
import com.ketan.Quiz_App.model.QuizResult;
import com.ketan.Quiz_App.model.QuizSubmissionRequest;
import com.ketan.Quiz_App.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quiz")
@CrossOrigin(origins = "https://localhost:3000")
public class QuizController {

    @Autowired
    private QuizService quizService;

    //get random questions
    @GetMapping("/questions")
    public ResponseEntity<List<Question>> getQuizQuestions(
            @RequestParam(defaultValue = "10") int count,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String difficulty){

        List<Question> questions;

        if(category != null && !category.isEmpty()){
            questions = quizService.getRandomQuestionsByCategory(category,count);
        }else if(difficulty != null && !difficulty.isEmpty()){
            questions = quizService.getRandomQuestionsByDifficulty(difficulty,count);
        }else{
            questions = quizService.getRandomQuestions(count);
        }

        return ResponseEntity.ok(questions);
    }

    //submit quiz answers
    @PostMapping("/submit")
    public ResponseEntity<QuizResult> submitQuiz(@RequestBody QuizSubmissionRequest request){
        List<Question> questions = quizService.getRandomQuestions(request.getAnswers().size());

        //calc score
        int score = quizService.calculateScores(questions,request.getAnswers());

        //save res
        QuizResult result = quizService.saveQuizResult(
                request.getPlayerName(),
                score,
                questions.size(),
                request.getDifficulty(),
                request.getCategory()
        );

        return ResponseEntity.ok(result);
    }

    //get cats
    @GetMapping("/categories")
    public ResponseEntity<List<String>> getCategories(){
        return ResponseEntity.ok(quizService.getAllCategories());
    }

    //get diffis
    @GetMapping("/difficulties")
    public ResponseEntity<List<String>> getDifficulties(){
        return ResponseEntity.ok(quizService.getAllDifficulties());
    }

    //get leaderboard
    @GetMapping("/leaderboard")
    public ResponseEntity<List<QuizResult>> getLeaderBoard(){
        return ResponseEntity.ok(quizService.getLeaderBoard());
    }



    //get player history
    @GetMapping("/history/{playerName}")
    public ResponseEntity<List<QuizResult>> getPlayerHistory(@PathVariable String playerName){
        return ResponseEntity.ok(quizService.getPlayerHistory(playerName));
    }

    //quizSubmissionRequest class in ./models



}
