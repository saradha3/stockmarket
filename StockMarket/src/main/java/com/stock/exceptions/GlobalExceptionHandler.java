package com.stock.exceptions;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.stock.payloads.ApiResponse;


@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ApiResponse> handleConstraintViolationException(ConstraintViolationException ex){
		
		String message = "";
		Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();
		for(ConstraintViolation<?> constraintViolation : constraintViolations) {
			message += constraintViolation.getMessage();
		}
		ApiResponse apiResponse = new ApiResponse(message,false);
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public ResponseEntity<ApiResponse> handleSQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException ex){
		ApiResponse apiResponse = new ApiResponse(ex.getMessage(), false);
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.BAD_REQUEST);
	}

}
