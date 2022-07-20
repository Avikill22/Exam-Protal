package com.exam.examportal.service.util;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.examportal.entity.User;
import com.exam.examportal.entity.UserRole;
import com.exam.examportal.repository.RoleRepository;
import com.exam.examportal.repository.UserRepository;
import com.exam.examportal.service.IUserService;

@Service
public class UserService implements IUserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public User createUser(User user,Set<UserRole> userRoles) throws Exception {
		User localUser = userRepository.findByUserName(user.getUserName());
		if(localUser != null) {
			System.out.print("User is already present!");
			throw new Exception("User already present!");
		}else {
			for(UserRole ur : userRoles) {
				roleRepository.save(ur.getRole());
			}
			user.getUserRole().addAll(userRoles);
			localUser  = this.userRepository.save(user);
		}
		return localUser;
	}
}
