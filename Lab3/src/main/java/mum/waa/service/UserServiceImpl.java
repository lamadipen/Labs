package mum.waa.service;

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

}
