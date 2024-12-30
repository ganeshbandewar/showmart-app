package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import feign.FeignException;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(value=InvalidMonthException.class)
	public ResponseEntity<String> invalidmonthexception(InvalidMonthException e){
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.FORBIDDEN);
	}
//	@ExceptionHandler(value=FeignException.class)
//	public ResponseEntity<String> ffexception(FeignException e){
//		return new ResponseEntity<String>("ok",HttpStatus.NOT_FOUND);
//	}
	
	
	@ExceptionHandler(value=MyCustomException.class)
	public ResponseEntity<String> mycustomeexception(MyCustomException e){
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	
	
	
	
	@ExceptionHandler(value=Exception.class)
	public ResponseEntity<String> onlyException(Exception e){
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
	}
}
