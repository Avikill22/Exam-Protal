package com.exam.examportal.entity;

public class JwtResponse {
	String token;

	public JwtResponse(){
		
	}
	public JwtResponse(String token) {
		this.token = token;
	}
	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}
	
	
}
