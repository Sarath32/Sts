package com.api.crud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class customerexception extends RuntimeException {

	public customerexception (String message){
		
		super(message);
		
	}
	
	
}
