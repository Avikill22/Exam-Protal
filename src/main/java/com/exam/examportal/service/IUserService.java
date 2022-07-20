package com.exam.examportal.service;

import java.util.Set;
import com.exam.examportal.entity.User;
import com.exam.examportal.entity.UserRole;

public interface IUserService {
	//creating user
	public User createUser(User user,Set<UserRole> userRoles) throws Exception;

	//public ResponseEntity<User> updateUserInfotmationUsingId(Long userId, User user);

}
