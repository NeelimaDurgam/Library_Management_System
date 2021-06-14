package com.capgemini.lms.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "feedback")
public class Feedback {
	
	@Id
	@Column(name = "id")
	private int id;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userid")
	private Users user;
	
	@Column(name = "feedback_date")
	private String feedbackDate;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "rating")
	private String rating;
	
	@Column(name = "comments")
	private String comments;
	
	
	
	public Feedback() {
	}
	
	public Feedback(int id, Users user, String feedbackDate, String description, String rating, String comments) {
		this.id = id;
		this.user = user;
		this.feedbackDate = feedbackDate;
		this.description = description;
		this.rating = rating;
		this.comments = comments;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public String getFeedbackDate() {
		return feedbackDate;
	}
	public void setFeedbackDate(String feedbackDate) {
		this.feedbackDate = feedbackDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
}