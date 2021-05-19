package org.com.services;

import java.util.List;

import org.com.model.LoginUser;
import org.com.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

	public User addUser(User user);
	public boolean loginChecks(LoginUser loginUser);
	public List<User> getAllUsers();
}
