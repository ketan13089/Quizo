package com.ketan.Quiz_App.repository;

import com.ketan.Quiz_App.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Long> {

    //find que by category
    List<Question> findByCategory(String category);

    //find by difficulty
    List<Question> findByDifficulty(String difficulty);

    //find by cat and diff
    List<Question> findByCategoryAndDifficulty(String category, String Difficulty);

    //get random que
    @Query(value = "Select * FROM questions ORDER BY RANDOM() LIMIT :limit", nativeQuery = true)
    List<Question> findRandomQuestions(@Param("limit") int limit);

    //get random que by cat
    @Query(value = "Select * FROM questions WHERE category = :category ORDER BY RANDOM() LIMIT :limit", nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(@Param("category") String category, @Param("limit") int limit);

    //get random que by diff
    @Query(value = "Select * FROM questions WHERE difficulty = :difficulty ORDER BY RANDOM() LIMIT :limit", nativeQuery = true)
    List<Question> findRandomQuestionsByDifficulty(@Param("difficulty") String difficulty, @Param("limit") int limit);


    //get all distinct cat
    @Query(value = "Select DISTINCT q.category FROM Question q")
    List<String> findAllCategories();

    //get all distinct diff
    @Query(value = "Select DISTINCT q.difficulty FROM Question q")
    List<String> findAllDifficulties();

}
