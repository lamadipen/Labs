package com.corejsf;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserRepo {
	private List<User> userList;
	
	public UserRepo() {
		userList = new ArrayList<>();
		userList.add(new User("John", "Doe"));
		userList.add(new User("Harry", "Potter"));
	}

	public List<User> getUserList() {
		return userList;
	}
	
	public void addUser(User user){
		userList.add(user);
	}
}
