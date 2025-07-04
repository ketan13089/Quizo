package com.ketan.Quiz_App.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "questions")
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Question is required")
    @Column(columnDefinition = "TEXT")
    private String questionText;

    @NotBlank(message = "Option A is required")
    private String optionA;

    @NotBlank(message = "Option B is required")
    private String optionB;

    @NotBlank(message = "Option C is required")
    private String optionC;

    @NotBlank(message = "Option D is required")
    private String optionD;

    @NotBlank(message = "Correct Answer is required")
    private String correctAnswer;

    private String difficulty;
    private String category;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public @NotBlank(message = "Question is required") String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(@NotBlank(message = "Question is required") String questionText) {
        this.questionText = questionText;
    }

    public @NotBlank(message = "Option A is required") String getOptionA() {
        return optionA;
    }

    public void setOptionA(@NotBlank(message = "Option A is required") String optionA) {
        this.optionA = optionA;
    }

    public @NotBlank(message = "Option B is required") String getOptionB() {
        return optionB;
    }

    public void setOptionB(@NotBlank(message = "Option B is required") String optionB) {
        this.optionB = optionB;
    }

    public @NotBlank(message = "Option C is required") String getOptionC() {
        return optionC;
    }

    public void setOptionC(@NotBlank(message = "Option C is required") String optionC) {
        this.optionC = optionC;
    }

    public @NotBlank(message = "Option D is required") String getOptionD() {
        return optionD;
    }

    public void setOptionD(@NotBlank(message = "Option D is required") String optionD) {
        this.optionD = optionD;
    }

    public @NotBlank(message = "Correct Answer is required") String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(@NotBlank(message = "Correct Answer is required") String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
