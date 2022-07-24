package com.exam.examportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exam.examportal.config.JwtUtils;
import com.exam.examportal.entity.JwtRequest;
import com.exam.examportal.entity.JwtResponse;
import com.exam.examportal.helper.UserNotFoundException;
import com.exam.examportal.service.util.UserSecurityServiceImpl;

@RestController
public class AuthenticateController {
	@Autowired
	private AuthenticationManager authenticationManager;	

	@Autowired
	private UserSecurityServiceImpl userDetailService;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
			
		}catch(DisabledException e) {
			throw new Exception("User Disabled" + e.getMessage());
		}catch(BadCredentialsException e) {
			throw new Exception("Invalid Credential" + e.getMessage());
		}
	}
	
	@PostMapping("/generate-token")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception{
		try {
			authenticate(jwtRequest.getUsername(),jwtRequest.getPassword());
		}catch(Exception e) {
			throw new Exception("user not found");
		}
		UserDetails userdetails = this.userDetailService.loadUserByUsername(jwtRequest.getUsername());
		
		String token = this.jwtUtils.generateToken(userdetails);
		return ResponseEntity.ok(new JwtResponse(token));
	}
}
