package com.jsp.usere13.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.usere13.dao.UserDao;
import com.jsp.usere13.dto.User;
import com.jsp.usere13.util.ResponseStructure;

@Service
public class UserService {
	
	@Autowired
	private UserDao dao;

	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
		User dbUser=dao.saveUser(user);
		
		ResponseStructure<User> structure=new ResponseStructure<>();
		structure.setMessage("User data saved successfully");
		structure.setHttpStatus(HttpStatus.CREATED.value());
		structure.setData(dbUser);
		
		return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<User>> find(int userId) {
		User dbUser=dao.find(userId);
		if(dbUser!=null) {
//			user id is present
			
			ResponseStructure<User> structure=new ResponseStructure<>();
			structure.setMessage("User data fetched successfully");
			structure.setHttpStatus(HttpStatus.FOUND.value());
			structure.setData(dbUser);
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.FOUND);
			
		}else {
//			user is not present
			ResponseStructure<User>  structure=new ResponseStructure<>();
			structure.setMessage("User id is not present");
			structure.setHttpStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(null);
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.NOT_FOUND);
		}
	}

	
}
