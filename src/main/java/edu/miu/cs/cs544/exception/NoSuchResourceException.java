package edu.miu.cs.cs544.exception;

public class NoSuchResourceException extends RuntimeException {


	public NoSuchResourceException(String message, Long id) {
		super(message + " : " + id);
	}

	public NoSuchResourceException(String message, Throwable cause) {
		super(message + " " + cause.getMessage());
	}

	public NoSuchResourceException(String message, Object object) {
		super(message + " " + object.getClass());
	}

}
