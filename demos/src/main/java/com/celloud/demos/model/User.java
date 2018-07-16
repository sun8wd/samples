package com.celloud.demos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import javax.validation.groups.Default;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

@Entity
public class User {
	@Id
	@GeneratedValue
	@Null(groups = { Create.class })
	private Long id;
	@NotBlank(groups = { Login.class, Create.class }, message = "用户名不能为空!")
	@Length(min = 6, max = 40, groups = { Create.class })
	@Column(nullable = false)
	private String username;
	@NotBlank(groups = { Login.class, ChangePassword.class, Create.class })
	@Length(min = 8, max = 20, groups = { ChangePassword.class, Create.class })
	@Column(nullable = false)
	private String password;
	@Pattern(regexp = "[1]{1}[0-9]{10}", groups = { Update.class, Create.class })
	private String phone;
	@Email(groups = { Update.class, Create.class })
	private String email;
	@Min(value = 18, groups = { Update.class, Create.class })
	@Max(value = 80, groups = { Update.class, Create.class })
	private Integer age;
	@URL
	private String homepage;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public static interface Login extends Default {
	}

	public static interface ChangePassword extends Default {
	}

	public static interface Update extends Default {
	}

	public static interface Create extends Default {
	}
}
