package org.com.services;

import java.util.ArrayList;

import org.com.dao.UserRepository;
import org.com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService{
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	/*
	 * public UserDetails loadUserByUsername(String username) throws
	 * UsernameNotFoundException{
	 * 
	 * return new User("siva","123",new ArrayList<>()); }
	 */
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}
	
	public User save(User user) {
		User newUser = new User();
		newUser.setUsername(user.getUsername());
		//newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		user.setPassword(bcryptEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}
}
