package mum.waa.service;

import java.util.Map;

import mum.waa.model.Product;
import mum.waa.model.User;

public interface Userservice {
	public boolean authenticate(User user);
	public User getUserById(String username);
	public Map<String,User> getAllUsers();
	public boolean addUser(User user);
	public boolean deleteUser(String username);
	public boolean updateUser(User user);
}
