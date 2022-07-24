package com.exam.examportal.entity.portal;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "quiz")
public class Quiz {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long qid;
	
	private String title;
	
	private String description;
	
	private String maxMarks;
	
	private String numberOfQuestions;
	
	private boolean active = false;
	
	@ManyToOne(fetch= FetchType.EAGER)
	private Category category;
	
	@OneToMany(mappedBy="quiz",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Question> questions = new HashSet<>();
	
	public Quiz() {
		
	}

	/**
	 * @param qid
	 * @param title
	 * @param description
	 * @param maxMarks
	 * @param numberOfQuestions
	 * @param active
	 */
	public Quiz(Long qid, String title, String description, String maxMarks, String numberOfQuestions, boolean active) {
		super();
		this.qid = qid;
		this.title = title;
		this.description = description;
		this.maxMarks = maxMarks;
		this.numberOfQuestions = numberOfQuestions;
		this.active = active;
	}

	/**
	 * @return the qid
	 */
	public Long getQid() {
		return qid;
	}

	/**
	 * @param qid the qid to set
	 */
	public void setQid(Long qid) {
		this.qid = qid;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the maxMarks
	 */
	public String getMaxMarks() {
		return maxMarks;
	}

	/**
	 * @param maxMarks the maxMarks to set
	 */
	public void setMaxMarks(String maxMarks) {
		this.maxMarks = maxMarks;
	}

	/**
	 * @return the numberOfQuestions
	 */
	public String getNumberOfQuestions() {
		return numberOfQuestions;
	}

	/**
	 * @param numberOfQuestions the numberOfQuestions to set
	 */
	public void setNumberOfQuestions(String numberOfQuestions) {
		this.numberOfQuestions = numberOfQuestions;
	}

	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * @return the category
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(Category category) {
		this.category = category;
	}
}
