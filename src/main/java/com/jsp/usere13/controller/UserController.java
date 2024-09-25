package com.jsp.usere13.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.usere13.dao.UserDao;
import com.jsp.usere13.dto.User;
import com.jsp.usere13.service.UserService;
import com.jsp.usere13.util.ResponseStructure;

@RestController
public class UserController {
	@Autowired
	private  UserService service;

	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user) {
		return service.saveUser(user);
	}
	
	@GetMapping("/find")
	public ResponseEntity<ResponseStructure<User>> findUser(@RequestParam  int userId) {
		return service.find(userId);
	}
	
	
	
	
	
	
}
