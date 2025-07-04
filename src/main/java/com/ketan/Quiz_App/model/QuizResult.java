package com.ketan.Quiz_App.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "quiz_results")
//@Data
//@Builder
//@AllArgsConstructor
public class QuizResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String playerName;
    private int score;
    private int totalQuestions;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public LocalDateTime getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(LocalDateTime completedAt) {
        this.completedAt = completedAt;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    private LocalDateTime completedAt;
    private String difficulty;
    private String category;


    public QuizResult(){
        this.completedAt = LocalDateTime.now();
    }


    public QuizResult(String playerName, int score, int totalQuestions, String difficulty, String category) {

        this.playerName = playerName;
        this.score = score;
        this.totalQuestions = totalQuestions;

        this.difficulty = difficulty;
        this.category = category;
    }

    @PrePersist
    public void setCompletionTime(){
        this.completedAt = LocalDateTime.now();
    }
}
