package com.example.exception;

public class InvalidMonthException extends RuntimeException {

	public InvalidMonthException(String msg) {
		super(msg);
	}
}
