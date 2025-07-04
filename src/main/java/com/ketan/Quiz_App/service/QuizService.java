package com.ketan.Quiz_App.service;

import com.ketan.Quiz_App.model.Question;
import com.ketan.Quiz_App.model.QuizResult;
import com.ketan.Quiz_App.repository.QuestionRepository;
import com.ketan.Quiz_App.repository.QuizResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class QuizService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuizResultRepository quizResultRepository;

    //get random que
    public List<Question> getRandomQuestions(int count){
        return questionRepository.findRandomQuestions(count);
    }

    //get random que by cat
    public List<Question> getRandomQuestionsByCategory(String category, int count){
        return questionRepository.findRandomQuestionsByCategory(category,count);
    }

    //get random que by diff
    public List<Question> getRandomQuestionsByDifficulty(String difficulty, int count){
        return questionRepository.findRandomQuestionsByDifficulty(difficulty,count);
    }

    //calc score based on ans
    public int calculateScores(List<Question> questions, Map<Long,String> answers){
        int score = 0;

        for(Question question : questions){
            String userAnswer = answers.get(question.getId());

            if(userAnswer != null && userAnswer.equalsIgnoreCase(question.getCorrectAnswer())){
                score++;
            }
        }
        return score;
    }

    //save quiz res
    public QuizResult saveQuizResult(String playerName, int score, int totalQuestions, String difficulty, String category){
        QuizResult result = new QuizResult(playerName,score,totalQuestions,difficulty,category);

        return quizResultRepository.save(result);
    }

    //get all cat
    public List<String> getAllCategories(){
        return questionRepository.findAllCategories();
    }

    //get all difficulties
    public List<String> getAllDifficulties(){
        return questionRepository.findAllDifficulties();
    }

    //get top 10
    public List<QuizResult> getLeaderBoard(){
        return quizResultRepository.findTop10Scored();
    }

    //get player quiz history ordered by completed date desc
    public List<QuizResult> getPlayerHistory(String playerName){
        return quizResultRepository.findByPlayerNameOrderByCompletedAtDesc(playerName);
    }


}
