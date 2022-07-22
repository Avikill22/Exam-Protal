package com.exam.examportal.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.examportal.entity.Role;
import com.exam.examportal.entity.User;
import com.exam.examportal.entity.UserRole;
import com.exam.examportal.repository.UserRepository;
import com.exam.examportal.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService userService;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@PostMapping("/")
	public User createUser(@RequestBody User user) throws Exception {
		
		user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
		Role role1 = new Role();
		role1.setRoleId(23L);
		role1.setRoleName("Student");
		Set<UserRole> userRoles = new HashSet<>();
		UserRole userrole1 = new UserRole();
		userrole1.setRole(role1);
		userrole1.setUser(user);
		userRoles.add(userrole1);
		return this.userService.createUser(user, userRoles);
	}
	
	@GetMapping("/{username}")
	public User userInformation(@PathVariable String username) {
		return userRepository.findByUserName(username);
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable Long userId){
		this.userRepository.deleteById(userId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
//	@PutMapping("/{userId}")
//	public ResponseEntity<User> updateUserInformation(@PathVariable Long userId, @RequestBody User user){
//		return this.userService.updateUserInfotmationUsingId(userId,user);
//	}
}
