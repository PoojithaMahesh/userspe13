package com.jsp.usere13.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jsp.usere13.util.ResponseStructure;
@RestControllerAdvice
public class UserExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> handleUserIdNotFoundException(UserIdNotFoundException exception){
		ResponseStructure<String> structure=new ResponseStructure<>();
		structure.setMessage("Sorry user Id is not present");
		structure.setHttpStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	
	
	
	
	
	
	
	
	
	
}
