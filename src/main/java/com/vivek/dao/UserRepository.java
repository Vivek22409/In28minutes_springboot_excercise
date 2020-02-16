package com.vivek.dao;

import java.util.List;

import com.vivek.model.User;

public interface UserRepository {
	
	public String addUser(User usr); 
	public String updateUser(User usr);
	public User getUser(int id);
	public User deleteUser(int id);	
	public List<User> getUserList();	

}
