package mum.waa.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import mum.waa.model.Product;
import mum.waa.model.User;

@Repository
public class UserRepositoryImpl implements UserRepository{
	HashMap<String, User> users = new HashMap<String, User>();
	
	public UserRepositoryImpl() {
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

	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		users.put(user.getUsername(),user);
		return true;
	}

	@Override
	public boolean deleteUser(String username) {
		users.remove(username);
		return true;
	}

	@Override
	public boolean updateUser(User user) {
		users.replace(user.getUsername(), user);
		return true;
	}

	@Override
	public User getUserById(String username) {
		// TODO Auto-generated method stub
		return users.get(username);
	}

	@Override
	public Map<String,User> getAllUsers() {
		// TODO Auto-generated method stub
		return users;
	}
}
