package com.exam.examportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.examportal.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{

	User findByUserName(String username);

	void deleteById(Long userId);

}
