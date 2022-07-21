package com.exam.examportal.helper;

public class UserNotFoundException extends Exception {
    private String username;

    public UserNotFoundException(String username){
        super("The user with username" + username+ "was not found");

    }

    public String getUsername(){
        return username;
    }
    
    public void printStackTrace() {
    	System.out.println("User not found " + this.username);
    }


}