package com.vivek.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.vivek.dao.UserRepository;
import com.vivek.model.User;

@Repository
public class UserRepositoryImpl implements UserRepository{
	
	private static ArrayList<User> usrLst = new ArrayList<User>();
	
	static {
		usrLst.add(new User(100,"vivek", "vivek@nag.com"));
		usrLst.add(new User(101,"amit", "amit@nag.com"));
		usrLst.add(new User(102,"rahul", "rahul@nag.com"));
	}

	@Override
	public String addUser(User usr) {
		usrLst.add(usr);
		return "Success";
	}

	@Override
	public String updateUser(User usr) {
		for(User user:usrLst) {
			if(user.getId()==usr.getId()) {
				user.setId(usr.getId());
				user.setName(usr.getName());
				user.setEmailId(usr.getEmailId());
			}
				
		}
		return "Success";
	}

	@Override
	public User getUser(int id) {
		for(User usr:usrLst) {
			if(usr.getId()==id)
				return usr;
		}
		return null;
	}

	@Override
	public String deleteUser(int id) {
		for(User user:usrLst) {
			if(user.getId()==id) {
				usrLst.remove(user);
			}
				
		}
		return "Success";
	}

	@Override
	public List<User> getUserList() {
		return usrLst;		
	}

}
