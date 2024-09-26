package com.jsp.usere13.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.usere13.dao.UserDao;
import com.jsp.usere13.dto.User;
import com.jsp.usere13.exception.UserIdNotFoundException;
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
			throw new UserIdNotFoundException("Sorry failed to fetch the data");
			}
	}

	public ResponseEntity<ResponseStructure<User>> updateUser(int userId, User user) {
		User dbUser=dao.updateUser(userId,user);
		if(dbUser!=null) {
//			user data updated successfully
			
			ResponseStructure<User> structure=new ResponseStructure<>();
			structure.setMessage("Data updated successfully");
			structure.setHttpStatus(HttpStatus.OK.value());
			structure.setData(dbUser);
			
		    return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.OK);
			
		}else {
//			user id is not present
			
			throw new UserIdNotFoundException("Sorry failed to update the Data");
		}
		
	}

	public ResponseEntity<ResponseStructure<User>> deleteUser(int userId) {
	User dbUser=dao.deleteUser(userId);
	if(dbUser!=null) {
//		user data updated successfully
		
		ResponseStructure<User> structure=new ResponseStructure<>();
		structure.setMessage("Data deleted successfully");
		structure.setHttpStatus(HttpStatus.FORBIDDEN.value());
		structure.setData(dbUser);
		
	    return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.FORBIDDEN);
		
	}else {
//		user id is not present
		
		throw new UserIdNotFoundException("Sorry failed to delete the Data");
	}
	}

	public ResponseEntity<ResponseStructure<List<User>>> findAllUser() {
		List<User> list=dao.findAll();
		ResponseStructure<List<User>> structure=new ResponseStructure<>();
		structure.setMessage("Data fetched successfully");
		structure.setHttpStatus(HttpStatus.FOUND.value());
		structure.setData(list);
		
	    return new ResponseEntity<ResponseStructure<List<User>>>(structure,HttpStatus.FOUND);
		
	}

	public ResponseEntity<ResponseStructure<User>> findByName(String name) {
		User dbUser=dao.findByName(name);
		if(dbUser!=null) {
			ResponseStructure<User> structure=new ResponseStructure<>();
			structure.setMessage("Data fetched successfully");
			structure.setHttpStatus(HttpStatus.FOUND.value());
			structure.setData(dbUser);
			
		    return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.FOUND);
		}else {
			return null;
//			pleaase raise userNameNotFoundException
			
		}
	}

	
}
