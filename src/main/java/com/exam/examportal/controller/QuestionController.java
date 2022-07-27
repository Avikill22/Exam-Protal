package com.exam.examportal.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exam.examportal.entity.portal.Question;
import com.exam.examportal.entity.portal.Quiz;
import com.exam.examportal.service.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	private QuestionService questionservice;
	
	@GetMapping("/quiz/{quizId}")
	public ResponseEntity<Set<Question>> getQuestions(@PathVariable Long quizId,@RequestParam("questNo") String questionNo){
		Quiz quiz = new Quiz();
		quiz.setQid(quizId);
		quiz.setNumberOfQuestions(questionNo);
		return new ResponseEntity<> (this.questionservice.getQuestionOfQuiz(quiz),HttpStatus.OK);
	}
	
	@PutMapping("/{questionId}")
	public ResponseEntity<Question> updateQuestion(@RequestBody Question question){
		
		return new ResponseEntity<> (this.questionservice.updateQuestion(question),HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<Question> addQuestion(@RequestBody Question question){
		
		return new ResponseEntity<> (this.questionservice.addQuestion(question),HttpStatus.OK);
	}
	
	@GetMapping("/{questionId}")
	public ResponseEntity<Question> getQuestion(@PathVariable Long questionId){
		return new ResponseEntity<> (this.questionservice.getQuestion(questionId),HttpStatus.OK);
	}
	
	@DeleteMapping("/{questionId}")
	public void deleteQuestion(@PathVariable Long questionId) {
		this.questionservice.deleteQuestion(questionId);
	}
	
	@PostMapping("/eval-quiz")
	public ResponseEntity<?> evalQuiz(@RequestBody List<Question> questions){
		Double marksGot =  0.0;
		Integer correctAnswer = 0;
		Integer attempted = 0;
		for (Question q : questions){
			Question question = this.questionservice.get(q.getQuesId());
			if(question.getAnswer().trim().equals(q.getGivenAnswer().trim())) {
				//correct
				correctAnswer++;
				Double marksSingle = Double.parseDouble(questions.get(0).getQuiz().getMaxMarks());
				marksGot += marksSingle;
			}
			if(question.getGivenAnswer() == null || question.getGivenAnswer().trim().equals("")) {
				attempted++;
			}
		}
		Map<Object, Object> map = Map.of("marksGot", marksGot, "correctAnswer",correctAnswer,"attempted",attempted);
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
}
