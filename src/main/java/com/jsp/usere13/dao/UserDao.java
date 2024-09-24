package com.jsp.usere13.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.usere13.dto.User;
import com.jsp.usere13.repo.UserRepo;

@Repository
public class UserDao {
    @Autowired
	private UserRepo repo;
	
	public void saveUser(User user) {
		repo.save(user);
	}
	
	
	
	
	
	
	
}
