package com.exam.examportal.service.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.examportal.entity.portal.Category;
import com.exam.examportal.entity.portal.Quiz;
import com.exam.examportal.repository.QuizRepository;
import com.exam.examportal.service.QuizService;

@Service
public class QuizServiceImpl implements QuizService{

	
	@Autowired
	private QuizRepository quizRepository;
	
	@Override
	public Quiz addQuiz(Quiz quiz) {
		
		return this.quizRepository.save(quiz);
	}

	@Override
	public Quiz updateQuiz(Quiz quiz) {
		return this.quizRepository.save(quiz);
	}

	@Override
	public Set<Quiz> getQuizzes() {
		
		return new HashSet<>(this.quizRepository.findAll());
	}

	@Override
	public Quiz getQuiz(Long quizId) {
		
		return this.quizRepository.findById(quizId).get();
	}

	@Override
	public void deleteQuiz(Long quizId) {
		this.quizRepository.deleteById(quizId);
	}

	@Override
	public List<Quiz> getQuizzesOfCategory(Category category) {
		
		return this.quizRepository.findByCategory(category);
	}

	@Override
	public List<Quiz> getActiveQuizzes(Boolean b) {
		
		return this.quizRepository.findByActive(b);
		
	}

	@Override
	public List<Quiz> getActiveQuizzesOfCategory(Long cid, Boolean b) {
		
		Category category = new Category();
		category.setCid(cid);
		
		return this.quizRepository.findByCategoryAndActive(category, b);
	}

}
