package com.example.numtoword.exception;

public class NumToWordException extends Exception{

	private static final long serialVersionUID = 1L;

	public NumToWordException()  {
		super();
	}
	
	public NumToWordException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public NumToWordException(String message){
		super(message);
	}
	
	public NumToWordException(Throwable cause){
		super(cause);
	}

}
