package com.exam.examportal;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.exam.examportal.entity.Role;
import com.exam.examportal.entity.User;
import com.exam.examportal.entity.UserRole;
import com.exam.examportal.service.IUserService;

@SpringBootApplication
public class ExamportalApplication implements CommandLineRunner {
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args){
		SpringApplication.run(ExamportalApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception{
//		System.out.println("Starting code");
//		User user = new User();
//		user.setFirstName("Shubhangini");
//		user.setLastName("Dey");
//		user.setUserName("Shubhi25M");
//		user.setPassword(bCryptPasswordEncoder.encode("ShubhiBorsha22!"));
//		user.setEmail("shubhiborsha@gmail.com");
//		user.setProfile("de.png");
//		Role role1 = new Role();
//		role1.setRoleName("Admin");
//		role1.setRoleId(14L);
//		Set<UserRole> userRoleSet = new HashSet<>();
//		UserRole userRole = new UserRole();
//		userRole.setUser(user);
//		userRole.setRole(role1);
//		userRoleSet.add(userRole);
//		
//		User userLocal = this.userService.createUser(user, userRoleSet);
//		System.out.println(userLocal.getUserName());
	}

}
