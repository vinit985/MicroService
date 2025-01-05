package com.lcwd.user.service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.user.service.entity.User;
import com.lcwd.user.service.services.UserService;

@RestController
@RequestMapping(value="users")
public class UserController {

	@Autowired
	private UserService userService;
	
//	 create
	@PostMapping()
	public ResponseEntity<User> createUser(@RequestBody User user)
	{
		User user1 = userService.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
	}
//	getAllusers
	@GetMapping()
	public ResponseEntity<List<User>> getAllUser()
	{
		List<User> user = userService.getAllUser();
		return ResponseEntity.ok(user);
	}
//	getOneUsers
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") String id)
	{
		User user1 = userService.getUserById(id);
		return ResponseEntity.ok(user1);
	}
}
