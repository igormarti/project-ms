package com.imr.hruser.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imr.hruser.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);
}
