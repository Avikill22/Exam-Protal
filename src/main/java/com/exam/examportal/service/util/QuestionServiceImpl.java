package com.exam.examportal.service.util;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.examportal.entity.portal.Question;
import com.exam.examportal.entity.portal.Quiz;
import com.exam.examportal.repository.QuestionRepository;
import com.exam.examportal.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {
	
	@Autowired
	private QuestionRepository questionRepository;

	@Override
	public Question addQuestion(Question question) {
		
		return this.questionRepository.save(question);
		
	}

	@Override
	public Question updateQuestion(Question question) {
		
		return this.questionRepository.save(question);
		
	}

	@Override
	public Set<Question> getQuestions() {
		
		return new HashSet<>(this.questionRepository.findAll());
	}

	@Override
	public Question getQuestion(Long questionId) {
		
		return this.questionRepository.getById(questionId);
		
	}

	@Override
	public Set<Question> getQuestionOfQuiz(Quiz quiz) {
		Long noOfQuestions = Long.parseLong(quiz.getNumberOfQuestions());
		Set<Question> setOfQuestions = this.questionRepository.findByQuiz(quiz);
		List<Question> limitedSetofQustions  = new LinkedList<Question>();
		Long i = 0L;
		for(Question question : setOfQuestions) {
			if(i>=noOfQuestions) {
				break;
			}
			limitedSetofQustions.add(question);
			i++;
		}
		return new HashSet<Question>(limitedSetofQustions); 
	}

	@Override
	public void deleteQuestion(Long questionId) {
		Question question = new Question();
		question.setQuesId(questionId);
		this.questionRepository.delete(question);
		
	}

	@Override
	public Question get(Long questionId) {
		// TODO Auto-generated method stub
		return this.questionRepository.findById(questionId).get();
	}

}
