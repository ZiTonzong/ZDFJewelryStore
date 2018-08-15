package com.ZDF.exception;

public class UserIsNotLoginException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3987352796003738205L;
	
    public UserIsNotLoginException() {
        super();
    }

    
    public UserIsNotLoginException(String message) {
        super(message);
    }
}
