package com.capgemini.lms.entities;

    import javax.persistence.Column;
	import javax.persistence.Entity;
    import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
    import javax.persistence.Table;


	@Entity
	@Table(name = "books")
	public class Books{
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int bookid;
		@Column(name = "title")
		private String title;
		@Column(name= "subject")
		private String subject;
		@Column(name = "publisher")
		private String publisher;
		@Column(name = "published_year")
		private int published_year;
		@Column(name = "isbn_code")
		private String isbn_code;
		@Column(name = "quantity")
		private int quantity;
		@Column(name = "book_cost")
		private double book_cost;
		@Column(name = "shelf_details")
		private String shelf_details;
	   @Column(name="author")
		private String author;
		
        public Books() {
        	
        }
		
		public Books(int bookid, String title, String subject, String publisher, int published_year,
				String isbn_code, int quantity, double book_cost, String shelf_details, String author) {
			super();
			this.bookid = bookid;
			this.title = title;
			this.subject = subject;
			this.publisher = publisher;
			this.published_year = published_year;
			this.isbn_code = isbn_code;
			this.quantity = quantity;
			this.book_cost = book_cost;
			this.shelf_details = shelf_details;
			this.author = author;
		}
		public int getBookid() {
			return bookid;
		}
		public void setBookid(int bookid) {
			this.bookid = bookid;
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
		
		public String getPublisher() {
			return publisher;
		}
		public void setPublisher(String publisher) {
			this.publisher = publisher;
		}
		public int getPublished_year() {
			return published_year;
		}
		public void setPublished_year(int published_year) {
			this.published_year = published_year;
		}
		public String getIsbn_code() {
			return isbn_code;
		}
		public void setIsbn_code(String isbn_code) {
			this.isbn_code = isbn_code;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public double getBook_cost() {
			return book_cost;
		}
		public void setBook_cost(double book_cost) {
			this.book_cost = book_cost;
		}
		public String getShelf_details() {
			return shelf_details;
		}
		public void setShelf_details(String shelf_details) {
			this.shelf_details = shelf_details;
		}
		public String getAuthor() {
			return author;
		}
		public void setAuthor(String author) {
			this.author=author;
			
		}
		
	}


