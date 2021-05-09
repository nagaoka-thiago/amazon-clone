package com.nagaoka.amazonclone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nagaoka.amazonclone.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
	@Query("FROM User WHERE email = :email")
	public User findByEmail(@Param("email") String email);
}
