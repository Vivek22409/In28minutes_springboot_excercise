package com.vivek.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vivek.dao.UserRepository;
import com.vivek.model.User;

@Service
public class UserService {	
	
	@Autowired
	private UserRepository userRepo;
	
	
	public String addUser(User usr) {
		return userRepo.addUser(usr);
	}
	
	public String updateUser(User usr) {
		return userRepo.updateUser(usr);
	}

	public User getUser(int id) {
		return userRepo.getUser(id);
	}
	
	public User deleteUser(int id) {
		return userRepo.deleteUser(id);
	}
	
	public List<User> getUserList() {
		return userRepo.getUserList();
	}
}
