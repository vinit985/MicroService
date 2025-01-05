package com.lcwd.hotel.exception;

public class ResourceNotFoundException extends RuntimeException {

	
	public ResourceNotFoundException()
	{
		super("Resource not found exception for hotel service");
	}
	
	public ResourceNotFoundException(String msg)
	{
		super(msg);
	}
}
