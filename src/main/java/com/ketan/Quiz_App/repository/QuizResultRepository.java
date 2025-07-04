package com.ketan.Quiz_App.repository;

import com.ketan.Quiz_App.model.QuizResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizResultRepository extends JpaRepository<QuizResult,Long> {

    //find res by player name, ordered by completion date desc
    List<QuizResult> findByPlayerNameOrderByCompletedAtDesc(String playerName);

    //get all res ordered by score desc and completion date desc
    @Query("SELECT qr FROM QuizResult qr ORDER BY qr.score DESC, qr.completedAt DESC")
    List<QuizResult> findTopScores();

    //get top 10 scores
    @Query(value = "SELECT * FROM quiz_results ORDER BY score DESC, completed_at DESC LIMIT 10", nativeQuery = true)
    List<QuizResult> findTop10Scored();

    //find results by cat ordered by score desc
    List<QuizResult> findByCategoryOrderByScoreDesc(String category);
}
