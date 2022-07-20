package com.exam.examportal.service.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.exam.examportal.entity.User;
import com.exam.examportal.repository.UserRepository;

@Service
public class UserSecurityServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = this.userRepository.findByUserName(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("Invalid Credential user not found...");
		}
		return user;
	}

}
