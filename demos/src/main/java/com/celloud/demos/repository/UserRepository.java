package com.celloud.demos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.celloud.demos.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	public User findByUsernameAndPassword(String username, String password);
}
