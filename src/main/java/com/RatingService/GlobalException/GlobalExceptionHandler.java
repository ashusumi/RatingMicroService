package com.RatingService.GlobalException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFound.class)
	public ResponseEntity<ApiResponse> handleExceptionWhenNotFound(ResourceNotFound found){
		String message=found.getMessage();
		ApiResponse apiResponse=ApiResponse.builder().message(message).success(false).status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponse);
	}
}
