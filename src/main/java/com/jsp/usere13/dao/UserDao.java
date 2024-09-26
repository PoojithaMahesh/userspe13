package com.jsp.usere13.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.usere13.dto.User;
import com.jsp.usere13.repo.UserRepo;

@Repository
public class UserDao {
    @Autowired
	private UserRepo repo;
	
	public User saveUser(User user) {
		return repo.save(user);
	}

	public User find(int userId) {
		Optional<User> optional=repo.findById(userId);
		if(optional.isPresent()) {
//			user is present inside the optional 
			User user=optional.get();
			return user;
		}else {
//			user id is not present
			return null;
		}
	}

	public User updateUser(int userId, User user) {
//		how to update
//		first you need to check whether id is present or not
		Optional<User> optional=repo.findById(userId);
		if(optional.isPresent()) {
//			user is present so i can update the data
			
			user.setId(userId);
			return repo.save(user);
		}else {
//			user id is not present
			return null;
		}
	}

	public User deleteUser(int userId) {
		Optional<User> optional=repo.findById(userId);
		if(optional.isPresent()) {
			
//			repo.delete(null);
			repo.deleteById(userId);
			return optional.get();
		}else {
			return null;
		}
	}

	public List<User> findAll() {
		return repo.findAll();
	}

	public User findByName(String name) {
		Optional<User> optional=repo.findByName(name);
		if(optional.isPresent()) {
//			user is present in this name
		
			return  optional.get();
		}else {
//			user id is not present
			return null;
		}
	}
	
	
	
	
	
	
	
}
