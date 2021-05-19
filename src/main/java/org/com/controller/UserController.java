package org.com.controller;

import java.util.List;

import org.com.model.LoginUser;
import org.com.model.User;
import org.com.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	@Autowired
	UserService userService;
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/adduser")
	public  User addUser(@RequestBody User user) {
		
		return userService.addUser(user);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/loginuser")
	public boolean loginCheck(@RequestBody LoginUser loginUser) {
		System.out.println(loginUser.getFirstName()+ " "+loginUser.getPassword());
		return userService.loginChecks(loginUser);
	}
	
	@GetMapping("/getallusers")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<User> getUsersAll() {
		System.out.println("wel... ");
		return userService.getAllUsers();
	}
	
}
