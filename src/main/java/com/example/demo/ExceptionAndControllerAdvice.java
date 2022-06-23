package com.example.demo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice

public class ExceptionAndControllerAdvice {
	@ExceptionHandler(UserNotFoundException.class)
	@ResponseStatus(value=HttpStatus.CONFLICT)
	public @ResponseBody ExceptionUser handleException(final UserNotFoundException e,final HttpServletRequest r) {
		ExceptionUser error=new ExceptionUser();
		error.setErrorMessage(e.getMessage());
		error.CallerURI(r.getRequestURI());
		return error;
	}
	

}
