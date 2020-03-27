package com.revature.advice;

import org.jboss.logging.Logger;
import org.jboss.logging.Logger.Level;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.exceptions.InvalidCredentialsException;

@RestControllerAdvice
public class ExceptionHandlerAdvice {
	private static Logger logger = Logger.getLogger(ExceptionHandlerAdvice.class);
	
	
	@ExceptionHandler(HttpClientErrorException.class)
	public ResponseEntity<String> handleClientError(HttpClientErrorException e) {
		logger.log(Level.TRACE, e.getMessage(), e);
		return ResponseEntity
				.status(e.getStatusCode())
				.body(e.getMessage());
	}
	
	@ExceptionHandler(InvalidCredentialsException.class)
	public ResponseEntity<String> handleInvalidCredentials(InvalidCredentialsException e) {
		return ResponseEntity
				.status(HttpStatus.UNAUTHORIZED)
				.body("Invalid username or password");
	}
}
