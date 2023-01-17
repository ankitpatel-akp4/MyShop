package com.myshop.exception;


import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import io.jsonwebtoken.MalformedJwtException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(UserException.class)
	public ResponseEntity<ErrorDetails> userExceptionHandler(UserException e, WebRequest wr){
		ErrorDetails ed = new ErrorDetails(e.getMessage(), wr.getDescription(false), LocalDateTime.now());
		return new ResponseEntity<>(ed,HttpStatus.BAD_GATEWAY);
	}
	
	
	@ExceptionHandler(EmailException.class)
	public ResponseEntity<ErrorDetails> emailExceptionHandler(EmailException e, WebRequest wr){
		ErrorDetails ed = new ErrorDetails(e.getMessage(), wr.getDescription(false), LocalDateTime.now());
		return new ResponseEntity<>(ed,HttpStatus.BAD_GATEWAY);
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDetails> handleMethodArgumentNotValidException(
			MethodArgumentNotValidException exception) {
		ErrorDetails err = new ErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage("invalid argument");
		err.setDetails(exception.getBindingResult().getFieldError().getDefaultMessage());
		
		return new ResponseEntity<ErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<ErrorDetails> handleNoHandlerFoundException(NoHandlerFoundException nfe,
			WebRequest req) {
		
		ErrorDetails err = new ErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(nfe.getMessage());
		err.setDetails(req.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}


	
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> exceptionHandler(Exception e,WebRequest req){
		
		ErrorDetails err = new ErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setDetails(req.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(err, HttpStatus.BAD_REQUEST);
		
	}
}
