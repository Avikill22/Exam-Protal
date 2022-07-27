package com.exam.examportal.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.exam.examportal.entity.portal.Category;
import com.exam.examportal.entity.portal.Quiz;
import com.exam.examportal.service.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {

	@Autowired
	private QuizService quizService;
	
	@PostMapping("/")
	public ResponseEntity<Quiz> add(@RequestBody Quiz quiz){
		return ResponseEntity.ok(this.quizService.addQuiz(quiz));
	}
	
	@GetMapping("/")
	public ResponseEntity<Set<Quiz>> getQuizzes(){
		
		return ResponseEntity.ok(this.quizService.getQuizzes());
	}
	
	@GetMapping("/{quizId}")
	public ResponseEntity<Quiz> getQuiz(@PathVariable Long quizId){
		return new ResponseEntity<Quiz> (this.quizService.getQuiz(quizId),HttpStatus.OK);
	}
	
	@PutMapping("/")
	public ResponseEntity<Quiz> updateQuiz(@RequestBody Quiz quiz){
		return new ResponseEntity<> (this.quizService.updateQuiz(quiz),HttpStatus.OK);
	}
	
	@DeleteMapping("/{quizId}")
	public void deleteQuiz(@PathVariable Long quizId){
		this.quizService.deleteQuiz(quizId);
	}
	
	@GetMapping("/category/{cid}")
	public ResponseEntity<?> getQuizzesOfCategory(@PathVariable("cid") Long cid){
		Category category = new Category();
		category.setCid(cid);
		return new ResponseEntity<>(this.quizService.getQuizzesOfCategory(category),HttpStatus.OK);
	}
	
	@GetMapping("/category/active/{cid}")
	public ResponseEntity<?> getActiveQuizzesOfCategory(@PathVariable("cid") Long cid){
		
		return new ResponseEntity<>(this.quizService.getActiveQuizzesOfCategory(cid,true),HttpStatus.OK);
		
	}
	
	@GetMapping("/active")
	public ResponseEntity<?> getActiveQuizzes(){
		
		return new ResponseEntity<>(this.quizService.getActiveQuizzes(true),HttpStatus.OK);
		
	}
	
	
}
