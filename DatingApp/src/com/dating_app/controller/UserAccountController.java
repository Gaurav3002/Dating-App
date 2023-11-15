package com.dating_app.controller;

import com.dating_app.dao.UserAccountDAO;
import com.dating_app.dao.UserAccountDAOImpl;
import com.dating_app.model.Interest;
import com.dating_app.model.UserAccount;

public class UserAccountController {
	
//	to save the data 
	public void register(){
		UserAccountDAO dao = new UserAccountDAOImpl();
		UserAccount userAccount = new UserAccount();
		userAccount.setId(1);
		userAccount.setAge(30);
		userAccount.setCity("Austin");
		userAccount.setCountry("USA");
		userAccount.setEmail("a@b.com");
		userAccount.setGender("M");
		userAccount.setPassword("password");
		userAccount.setPhoneNumber("1234567890");
		
		Interest interest = new Interest();
		interest.setId(1);
		interest.setLikes("watching movies");
		interest.setHobbies("playing chess");
		userAccount.setInterest(interest);
		dao.save(userAccount);
		System.out.println(dao.findById(1));
	}

//	create multiple user
	private void CreatUser(UserAccountDAO dao) {
		UserAccount user1 = new UserAccount();
		user1.setId(1);
		user1.setUserName("bob");
		user1.setAge(70);
		user1.setCity("Austin");
		user1.setCountry("USA");
		user1.setEmail("a@b.com");
		user1.setGender("M");
		user1.setPassword("password");
		user1.setPhoneNumber("1234567890");
		Interest interest = new Interest();
		interest.setId(1);
		interest.setLikes("watching movies");
		interest.setHobbies("playing chess");
		user1.setInterest(interest);
		dao.save(user1);
		UserAccount user2 = new UserAccount();
		user2.setId(2);
		user2.setUserName("john");
		user2.setAge(30);
		user2.setCity("Austin");
		user2.setCountry("USA");
		user2.setEmail("a@b.com");
		user2.setGender("M");
		user2.setPassword("password");
		user2.setPhoneNumber("1234567890");
		dao.save(user2);
	}
	
	public void findMatchingUser() {
		UserAccountDAO dao = new UserAccountDAOImpl();
		CreatUser(dao);
		System.out.println(dao.findMatches(30, "Austin"));
	}
	
//	find method is used to find all the data available in thee map or we can say that in memeory
	public void findAll() {
		UserAccountDAO dao = new UserAccountDAOImpl();
		CreatUser(dao);
		dao.delete(1);
		System.out.println(dao.findAll());
	}
	
	public static void main(String[] args) {
		UserAccountController u = new UserAccountController();
//		u.register();
		u.findAll();
		
		

	}

}
