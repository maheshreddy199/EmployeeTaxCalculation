package com.tasks.in.exceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalValidation {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> handlerException(MethodArgumentNotValidException ex){
		Map<String, String> errors = new HashMap<>();
		List<ObjectError> errorList = ex.getBindingResult().getAllErrors();
		errorList.forEach((error) ->{
			
			String fieldError = error.getCode();
			String errorMessage = error.getDefaultMessage();
			
			errors.put(fieldError, errorMessage);
		});
		
		return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
	}
		
	
}
