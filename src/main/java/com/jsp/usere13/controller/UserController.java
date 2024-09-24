package com.jsp.usere13.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.usere13.dao.UserDao;
import com.jsp.usere13.dto.User;

@RestController
public class UserController {
	@Autowired
	private UserDao userDao;

	@RequestMapping("/save")
	public void saveUser(@RequestBody User user) {
		userDao.saveUser(user);
	}
}
