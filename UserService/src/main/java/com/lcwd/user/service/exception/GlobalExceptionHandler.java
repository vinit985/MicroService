package com.lcwd.user.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.lcwd.user.service.payload.ApiResponse;

//It provides global exception handling, model attribute population, and binding enhancements across all @RestController components. This annotation allows you to centralize error handling and manage exceptions in a clean and consistent way.
 @RestControllerAdvice   
public class GlobalExceptionHandler {

//	 It will invoke below method if ResourceNotFound class is invoked
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourceNotFoundException ex)
	{
		String message = ex.getMessage();
		ApiResponse response =  new ApiResponse(message,true,HttpStatus.NOT_FOUND);
		return new ResponseEntity<ApiResponse>(response,HttpStatus.NOT_FOUND);
	}
}
