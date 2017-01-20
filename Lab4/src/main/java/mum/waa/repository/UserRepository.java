package mum.waa.repository;

import mum.waa.model.User;

public interface UserRepository {
	public boolean validateUser(User user);
}
