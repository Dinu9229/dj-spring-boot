package com.Springboot.tutorial.Error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.Springboot.tutorial.Entity.ErrorMessage;

@ControllerAdvice
public class RestControllerExceptionHandler extends Exception {
	
	@ExceptionHandler(DepartmentNotFoundException.class)
	public ResponseEntity<ErrorMessage> exceptionHandler(DepartmentNotFoundException exception, WebRequest webRequest){
		
		ErrorMessage error=new ErrorMessage(HttpStatus.NOT_FOUND,exception.getMessage());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request){
		
		ErrorMessage errorMessage=new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
	}
}
