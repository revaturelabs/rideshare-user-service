package com.revature.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

@RestControllerAdvice
public class HttpExceptionAdvice {

	@ExceptionHandler(HttpClientErrorException.class)
	public HttpStatus handleClientError(HttpClientErrorException e) {
		return e.getStatusCode();
	}
}
