package com.bottega.bellegro.bidder.infra;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestAdvice {



	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ResponseError> errorHandler(RuntimeException e) {
		return ResponseEntity.ok(new ResponseError());
	}

	private class ResponseError {

	}
}
