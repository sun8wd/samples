package com.celloud.demos.action;

import javax.annotation.Resource;

import org.hibernate.validator.constraints.Length;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.celloud.demos.model.User;
import com.celloud.demos.service.UserService;

@RestController
@Validated
public class LoginAction {
	@Resource
	private UserService userService;

	@PostMapping("login")
	public ResponseEntity<User> login(@RequestBody @Validated(User.Login.class) User user, Errors errors) {
		System.out.println("login:" + user.getUsername() + "=======" + user.getPassword());
		return ResponseEntity.ok(user);
	}

	@PostMapping("login2")
	public ResponseEntity<User> login(@Length(min = 5, max = 20, message = "用户名长度在5-20之间") String username,
			@RequestParam(required = true) String password) {
		System.out.println("login2:" + username + "=======" + password);
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		return ResponseEntity.ok(user);
	}

	@PostMapping("login3")
	public ResponseEntity<User> login2(@RequestBody @Validated(User.Login.class) User user, Errors errors) {
		System.out.println("login:" + user.getUsername() + "=======" + user.getPassword());
		return ResponseEntity.ok(user);
	}
}
