package com.stockprice.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.stockprice.payloads.ApiResponse;



@RestControllerAdvice
public class GlobalExceptionHandler extends RuntimeException {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> handleResourcetNotFoundException(ResourceNotFoundException ex){
		ApiResponse apiResponse = new ApiResponse(ex.getMessage(), false);
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
	}
}
