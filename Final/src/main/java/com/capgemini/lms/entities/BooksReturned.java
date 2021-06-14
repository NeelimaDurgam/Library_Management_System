package com.capgemini.lms.entities;


import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Column;
@Entity(name="booksreturned")
@Table(name="booksreturned")
public class BooksReturned {
	@Id
	@Column(name = "Book_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@OneToOne(fetch = FetchType.EAGER)
	private Users users;
	@OneToMany(fetch = FetchType.LAZY)
	private List<Books> books;
	@Column(name = "Returned_Date")
	private String returnedDate;
	@Column(name = "Delayed_Days")
	private String delayed_Days;
	@Column(name = "Penalty")
	private String penalty;
	@Column(name = "Penalty_Status")
	private String penalty_Status;
	public BooksReturned() {
		
	}
	public BooksReturned(int id,Users users,List<Books> books,String returnedDate, String delayed_Days, String penalty,String penalty_Status) {
		super();
		this.id = id;
		this.users = users;
		this.books = books;
		this.returnedDate = returnedDate;
		this.delayed_Days = delayed_Days;
		this.penalty = penalty;
		this.penalty_Status = penalty_Status;
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
	public List<Books> getBooks() {
		return books;
	}
	public void setBooks(List<Books> books) {
		this.books = books;
	}
	public String getReturnedDate() {
		return returnedDate;
	}
	public void setReturnedDate(String returnedDate) {
		this.returnedDate = returnedDate;
	}
	public String getDelayed_Days() {
		return delayed_Days;
	}
	public void setDelayed_Days(String delayed_Days) {
		this.delayed_Days = delayed_Days;
	}
	public String getPenalty() {
		return penalty;
	}
	public void setPenalty(String penalty) {
		this.penalty = penalty;
	}
	public String getPenalty_Status() {
		return penalty_Status;
	}
	public void setPenalty_Status(String penalty_Status) {
		this.penalty_Status = penalty_Status;
	}
}
