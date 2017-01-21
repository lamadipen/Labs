package mum.waa.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mum.waa.model.User;
import mum.waa.repository.UserRepository;

@Service
public class UserServiceImpl implements Userservice{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public boolean authenticate(User user) {
		// TODO Auto-generated method stub
		return userRepository.validateUser(user);
	}

	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.addUser(user);
	}

	@Override
	public boolean deleteUser(String username) {
		// TODO Auto-generated method stub
		return userRepository.deleteUser(username);
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.updateUser(user);
	}

	@Override
	public User getUserById(String username) {
		// TODO Auto-generated method stub
		return userRepository.getUserById(username);
	}

	@Override
	public Map<String, User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.getAllUsers();
	}

}
