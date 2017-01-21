package mum.waa.repository;

import java.util.List;
import java.util.Map;

import mum.waa.model.User;

public interface UserRepository {
	public boolean validateUser(User user);
	public User getUserById(String username);
	public Map<String,User> getAllUsers();
	public boolean addUser(User user);
	public boolean deleteUser(String username);
	public boolean updateUser(User user);
}
