package com.capgemini.lms.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import java.time.LocalDate;
import java.util.Date;
@Entity
@Table(name = "suggested_books")
public class SuggestedBooks {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@OneToOne (fetch = FetchType.EAGER)
    //@JoinColumn(name="UserId")
	private Users users;
	@Column(name = "title")
	private String title;
	@Column(name = "subject")
	private String subject;
	@Column(name = "author")
	private String author;
	@Column(name = "publications")
	private String publications;
	@Column(name = "description")
	private String description;
	@Column(name = "suggested_date")
	private String suggested_date;
	@Column(name = "status")
	private String status;
	
	
	public SuggestedBooks() {
		
	}
	
	public SuggestedBooks(int id,Users users, String title, String subject, String author, String publications,
			String description, String suggested_date, String status) {
		super();
		this.id = id;
		this.users = users;
		this.title = title;
		this.subject = subject;
		this.author = author;
		this.publications = publications;
		this.description = description;
		this.suggested_date = suggested_date;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublications() {
		return publications;
	}
	public void setPublications(String publications) {
		this.publications = publications;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSuggested_date() {
		return suggested_date;
	}
	public void setSuggested_date(String suggested_date) {
		this.suggested_date = suggested_date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
