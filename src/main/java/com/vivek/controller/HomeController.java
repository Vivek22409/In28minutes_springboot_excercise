package com.vivek.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.vivek.exception.UserNotFoundException;
import com.vivek.model.User;
import com.vivek.service.UserService;

@RestController
public class HomeController {
	
	@Autowired
	private UserService usrService;
	
	@GetMapping("/api/welcome")
	public String message(String message) {
		return "hello";
	}
	
	@GetMapping("/api/users/{id}")
	public User getUser(@PathVariable String id) {
		int identity = Integer.parseInt(id);
		User usr = usrService.getUser(identity);
		if(usr==null)
			throw new UserNotFoundException("id-"+id);
		return usrService.getUser(identity);		
	}
	
	@GetMapping("/api/users")
	public List<User> getUsers() {
		return usrService.getUserList();		
	} 
	
	@PostMapping("/api/user")
	public ResponseEntity<Object> saveUser(@RequestBody User usr) {
		usrService.addUser(usr);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
		buildAndExpand(usr.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

}
