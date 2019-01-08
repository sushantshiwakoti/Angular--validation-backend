package com.sushant.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {
	@Id
	private String id;
	@NotBlank(message = "Please Enter an Email")
	@Email(message = "Please enter valid Email")
	private String email;
	@NotBlank(message = "Please Enter  Name")
	private String name;
	@NotBlank(message = "Please Enter  UserName")
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@NotBlank(message = "Please Enter Password")
	private String password;
	@NotBlank(message = "Please Enter  Age")
	private String age;
	@NotBlank(message = "Please Enter  PhoneNumber")
	private String phonenumber;

	public User() {
		super();

	}

	public User(String id, String email, String name,String username ,String password, String age, String phonenumber) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.username=username;
		this.password = password;
		this.age = age;
		this.phonenumber = phonenumber;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", name=" + name + ", username=" + username + ", password="
				+ password + ", age=" + age + ", phonenumber=" + phonenumber + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

}
