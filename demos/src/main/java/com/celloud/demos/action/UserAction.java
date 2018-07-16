package com.celloud.demos.action;

import javax.annotation.Resource;
import javax.validation.constraints.Max;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.celloud.demos.exception.ValidationFailException;
import com.celloud.demos.model.User;
import com.celloud.demos.service.UserService;

@RestController
@RequestMapping("users")
public class UserAction {
	@Resource
	private UserService userService;

	@GetMapping
	public ResponseEntity<Page<User>> index(int page, int size, @Max(value = 80, message = "") int age) {

		return null;
	}

	@PostMapping
	public ResponseEntity<User> create(@RequestBody @Validated(User.Create.class) User user, Errors errors) {
		if (errors.hasFieldErrors()) {
			throw new ValidationFailException(errors);
		}
		return ResponseEntity.ok(user);
	}

	/**
	 * 修改用户信息
	 * 
	 * @param id
	 * @param user
	 * @param errors
	 * @return
	 * @author sun8wd
	 * @date 2017年9月18日 下午3:44:17
	 */
	@PutMapping("/{id}")
	public ResponseEntity<User> update(@PathVariable(required = true) Long id, @Validated(User.Update.class) User user,
			Errors errors) {
		System.out.println("updating ... ");
		if (errors.hasFieldErrors()) {
			throw new ValidationFailException(errors);
		}
		return ResponseEntity.ok(user);
	}

	@PutMapping("/{id}/password")
	public ResponseEntity<User> changePassword(@PathVariable(required = true) Long id,
			@Validated(User.Update.class) User user, Errors errors) {
		if (errors.hasFieldErrors()) {
			throw new ValidationFailException(errors);
		}
		return null;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable(required = true) Long id) {
		return ResponseEntity.ok(null);
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> find(@PathVariable(required = true) Long id) {
		return null;
	}
}