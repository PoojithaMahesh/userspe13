package com.jsp.usere13.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.usere13.dto.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
