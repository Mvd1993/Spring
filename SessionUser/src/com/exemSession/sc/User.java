package com.exemSession.sc;
public class User {
	 
	   public String userName;
	   private int post;
	   private String country;
	    
	   public User(String userName, String country, int post)  {
	       this.userName= userName;
	       this.country= country;
	       this.post= post;
	   }
	 
	   public int getPost() {
	       return post;
	   }
	 
	   public void setPost(int post) {
	       this.post = post;
	   }
	 
	   public String getCountry() {
	       return country;
	   }
	 
	   public void setCountry(String country) {
	       this.country = country;
	   }
	 
	   public void setUserName(String userName) {
	       this.userName = userName;
	   }
	 
	   public User(String userName) {
	       this.userName = userName;
	   }
	 
	   public String getUserName() {
	       return this.userName;
	   }
	}