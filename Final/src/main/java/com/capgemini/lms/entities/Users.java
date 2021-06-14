package com.capgemini.lms.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity(name="users")
@Table(name = "users")
public class Users {
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userid;
	@Column(name = "password")
	private String password;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "mobileno")
	private String mobileno;
	@Column(name = "email")
	private String email;
	@Column(name = "date_of_birth")
	private String date_of_birth;
	@Column(name = "subscription_date")
	private String subscription_date;
	@Column(name = "sub_expire_date")
	private String sub_expire_date;
	@Column(name = "subscription_status")
	private String subscription_status;
	
	
	public Users() {
		super();
	}


	public Users(int userid, String password, String firstName, String lastName, String mobileno, String email,
			String date_of_birth, String subscription_date, String sub_expire_date, String subscription_status) {
		super();
		this.userid = userid;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileno = mobileno;
		this.email = email;
		this.date_of_birth = date_of_birth;
		this.subscription_date = subscription_date;
		this.sub_expire_date = sub_expire_date;
		this.subscription_status = subscription_status;
	}


	public int getUserid() {
		return userid;
	}


	public void setUserid(int userid) {
		this.userid = userid;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getMobileno() {
		return mobileno;
	}


	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getDate_of_birth() {
		return date_of_birth;
	}


	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}


	public String getSubscription_date() {
		return subscription_date;
	}


	public void setSubscription_date(String subscription_date) {
		this.subscription_date = subscription_date;
	}


	public String getSub_expire_date() {
		return sub_expire_date;
	}


	public void setSub_expire_date(String sub_expire_date) {
		this.sub_expire_date = sub_expire_date;
	}


	public String getSubscription_status() {
		return subscription_status;
	}


	public void setSubscription_status(String subscription_status) {
		this.subscription_status = subscription_status;
	}


	@Override
	public String toString() {
		return "Users [userid=" + userid + ", password=" + password + ", firstName=" + firstName + ", lastName="
				+ lastName + ", mobileno=" + mobileno + ", email=" + email + ", date_of_birth=" + date_of_birth
				+ ", subscription_date=" + subscription_date + ", sub_expire_date=" + sub_expire_date
				+ ", subscription_status=" + subscription_status + "]";
	}


	}
	
