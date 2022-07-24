package com.exam.examportal.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.examportal.entity.portal.Question;
import com.exam.examportal.entity.portal.Quiz;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Long> {

	Set<Question> findByQuiz(Quiz quiz);

}
