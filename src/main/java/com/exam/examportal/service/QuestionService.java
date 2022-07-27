package com.exam.examportal.service;

import java.util.List;
import java.util.Set;

import com.exam.examportal.entity.portal.Question;
import com.exam.examportal.entity.portal.Quiz;

public interface QuestionService {

	public Question addQuestion(Question question);
	public Question updateQuestion(Question question);
	public Set<Question> getQuestions();
	public Question getQuestion(Long questionId);
	public Set<Question> getQuestionOfQuiz(Quiz quiz);
	public void deleteQuestion(Long questionId);
	public Question get(Long questionId);
}
