package mum.waa.service;

import mum.waa.model.User;
import mum.waa.repository.UserRepository;

public class UserService {

	public boolean validateUser(User user)
	{
		UserRepository userRepo = new UserRepository();
		return userRepo.validateUser(user);
	}
}
