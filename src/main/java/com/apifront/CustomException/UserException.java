package com.apifront.CustomException;

public class UserException extends Exception{
	public UserException(String message) {
        super(message);
    }
	public UserException(String message,Exception e) {
        super(e.getMessage());
    }
}
