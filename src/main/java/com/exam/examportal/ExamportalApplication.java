package com.exam.examportal;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.exam.examportal.entity.Role;
import com.exam.examportal.entity.User;
import com.exam.examportal.entity.UserRole;
import com.exam.examportal.service.IUserService;

@SpringBootApplication
public class ExamportalApplication implements CommandLineRunner {
	
	@Autowired
	private IUserService userService;

	public static void main(String[] args){
		SpringApplication.run(ExamportalApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception{
//		System.out.println("Starting code");
//		User user = new User();
//		user.setFirstName("Shubhi");
//		user.setLastName("Dey");
//		user.setUserName("Shubhi22@");
//		user.setPassword("ShubhiBorsha22!");
//		user.setEmail("shubhiborsha@gmail.com");
//		user.setProfile("default.png");
//		
//		Role role1 = new Role();
//		role1.setRoleName("Admin");
//		role1.setRoleId(44L);
//		Role role2 = new Role();
//		role2.setRoleName("Teacher");
//		role2.setRoleId(40L);
//		
//		Set<UserRole> userRoleSet = new HashSet<>();
//		UserRole userRole = new UserRole();
//		userRole.setUser(user);
//		userRole.setRole(role1);
//		UserRole userRole1 = new UserRole();
//		userRole1.setUser(user);
//		userRole1.setRole(role2);
//		userRoleSet.add(userRole);
//		userRoleSet.add(userRole1);
//		
//		User userLocal = this.userService.createUser(user, userRoleSet);
//		System.out.println(userLocal.getUserName());
	}

}
