package com.ketan.Quiz_App.service;

import com.ketan.Quiz_App.model.Question;
import com.ketan.Quiz_App.repository.QuestionRepository;
import com.ketan.Quiz_App.repository.QuizResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuizResultRepository quizResultRepository;

    //get all que
    public List<Question> getAllQuestions(){
        return questionRepository.findAll();
    }

    //get que by id
    public Optional<Question> getQuestionById(Long id){
        return questionRepository.findById(id);
    }

    //save new question
    public Question saveQuestion(Question question){
        return questionRepository.save(question);
    }

    //update que
    public Question updateQuesttion(Long id, Question questionDetails){
        Optional<Question> optionalQuestion = questionRepository.findById(id);

        if(optionalQuestion.isPresent()){
            Question question = optionalQuestion.get();
            question.setQuestionText(questionDetails.getQuestionText());
            question.setOptionA(questionDetails.getOptionA());
            question.setOptionB(questionDetails.getOptionB());
            question.setOptionC(questionDetails.getOptionC());
            question.setOptionD(questionDetails.getOptionD());
            question.setCorrectAnswer(questionDetails.getCorrectAnswer());
            question.setDifficulty(questionDetails.getDifficulty());
            question.setCategory(questionDetails.getCategory());

            return questionRepository.save(question);
        }
        return null;
    }

    //delete que
    public boolean deleteQuestion(Long id){
        if(questionRepository.existsById(id)){
            questionRepository.deleteById(id);
            return true;
        }
        return false;
    }

    //get que by cat
    public List<Question> getQuestionByCategory(String category){
        return questionRepository.findByCategory(category);
    }

    //get que by difficulty
    public List<Question> getQuestionByDifficulty(String difficulty){
        return questionRepository.findByDifficulty(difficulty);
    }

    //delete leaderboard
    public void deleteAllQuizResult() {
        quizResultRepository.deleteAll();
    }
}
