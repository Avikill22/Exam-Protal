package com.exam.examportal.service;

import java.util.List;
import java.util.Set;

import com.exam.examportal.entity.portal.Category;
import com.exam.examportal.entity.portal.Quiz;

public interface QuizService {

	public Quiz addQuiz(Quiz quiz);
	public Quiz updateQuiz(Quiz quiz);
	public Set<Quiz> getQuizzes();
	public Quiz getQuiz(Long quizId);
	public void deleteQuiz(Long quizId);
	public List<Quiz> getQuizzesOfCategory(Category category);
	public List<Quiz> getActiveQuizzes(Boolean b);
	public List<Quiz> getActiveQuizzesOfCategory(Long cid,Boolean b);
}
