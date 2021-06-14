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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@Entity  
@Table(name = "issued")
public class BooksIssued {
	
		    @Id
			@GeneratedValue(strategy = GenerationType.AUTO)
			private int issueId;
		    @OneToOne(fetch = FetchType.EAGER)
			private Users users;
	        @Column(name = "issue_date")
			private String issueDate;
			@Column(name = "quantity")
			private String quantity;
			@Column(name = "due_date")
			private String dueDate;
			@OneToMany(targetEntity=Books.class,cascade=CascadeType.ALL)
			@JoinColumn(name = "issueId",referencedColumnName="issueId")
			private List<Books> books;
			public BooksIssued() {
				super();
				
			}
			
			
			
			
			public BooksIssued(int issueId , Users users, List<Books> books, String issueDate, String quantity, String dueDate) {
				super();
				this.issueId = issueId;
				this.users = users;
				this.books = books;
				this.issueDate = issueDate;
				this.quantity = quantity;
				this.dueDate = dueDate;
			}
			public int getIssueId() {
				return issueId;
			}
			public void setIssueId(int issueId) {
				this.issueId = issueId;
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

			public String getIssueDate() {
				return issueDate;
			}
			public void setIssueDate(String issueDate) {
				this.issueDate = issueDate;
			}
			public String getQuantity() {
				return quantity;
			}
			public void setQuantity(String quantity) {
				this.quantity = quantity;
			}
			public String getDueDate() {
				return dueDate;
			}
			public void setDueDate(String dueDate) {
				this.dueDate = dueDate;
			}




			
			
			
		   /*public String toString() {
				
			return "BooksIssued [issue_id=" + issueId + ", users=" + users + ",books=" +books+",issue_date="+issueDate+",quantity =" +quantity+",due_date = "+dueDate+ "]";
						
			}*/
	}

			
			
		
		




