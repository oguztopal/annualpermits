package com.oguztopal.annualpermit.controller.advice;

import com.oguztopal.annualpermit.dto.ExceptionResponse;
import com.oguztopal.annualpermit.exception.AnnualPermitException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
@Slf4j
public class AnnualPermitExceptionHandler {

	@ExceptionHandler(AnnualPermitException.class)
	public ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, WebRequest request) {
		log.error("AnnualPermitExceptionHandler Error. path ={} ", request.getContextPath());
		ExceptionResponse customResponse = new ExceptionResponse();
		customResponse.setMessage(ex.getMessage() != null ? ex.getMessage() : "");
		customResponse.setTimestamp(LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(customResponse);
	}

}
