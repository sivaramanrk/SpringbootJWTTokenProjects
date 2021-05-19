package org.com.servicesimpl;


import java.util.List;

import org.com.dao.UserRepository;
import org.com.model.LoginUser;
import org.com.model.User;
import org.com.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class UserServiceImpl implements UserService{
	 
	@Autowired
	UserRepository userRepostory;

	@Override
	public User addUser(User user) {
		
		return userRepostory.save(user);
	}

	@Override
	public boolean loginChecks(LoginUser loginUser) {
		User user = userRepostory.findusernameandpassword(loginUser.getFirstName(), loginUser.getPassword());
		
		boolean status = false;
		if(user!=null) {
			if(user.getFirstName().equals(loginUser.getFirstName()) && user.getPassword().equals(loginUser.getPassword())) {
				status=true;
			}
		}
	
		return status;
	}

	@Override
	public List<User> getAllUsers() {
		
		return userRepostory.findAll();
	}

	
}
