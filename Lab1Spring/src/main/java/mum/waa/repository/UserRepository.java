package mum.waa.repository;

import java.util.HashMap;

import mum.waa.model.User;

public class UserRepository {
	HashMap<String, User> users = new HashMap<String, User>();
	
	public UserRepository() {
		User user1 = new User();
		user1.setUsername("Dipen");
		user1.setPassword("nepal");
		
		User user2 = new User();
		user2.setUsername("Sanjay");
		user2.setPassword("test");
		
		users.put("Dipen", user1);
		users.put("Sanjay", user2);
	}
	
	public boolean validateUser(User user)
	{
		if(users.containsKey(user.getUsername()))
		{	
			User currentUser = users.get(user.getUsername());
			if(currentUser.getPassword().equals(user.getPassword()))
				return true;
		}
		
		return false;
	}
}
