package com.exam.examportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.examportal.entity.portal.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz,Long> {

}
