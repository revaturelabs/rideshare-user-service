package com.revature.advice;

import org.jboss.logging.Logger;
import org.jboss.logging.Logger.Level;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

@RestControllerAdvice
public class HttpExceptionAdvice {
	private static Logger logger = Logger.getLogger(HttpExceptionAdvice.class);
	
	@ExceptionHandler(HttpClientErrorException.class)
	public HttpStatus handleClientError(HttpClientErrorException e) {
		logger.log(Level.TRACE, e.getMessage(), e);
		return e.getStatusCode();
	}
}
