package com.jsp.usere13.dao;

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
	
	
	
	
	
	
	
}
