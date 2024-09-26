package com.jsp.usere13.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.usere13.dto.User;

public interface UserRepo extends JpaRepository<User, Integer>{
    @Query("select u from User u where u.name=?1")
	Optional<User> findByName(String name);
    
    

}
