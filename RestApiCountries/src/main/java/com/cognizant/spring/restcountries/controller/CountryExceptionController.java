package com.cognizant.spring.restcountries.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cognizant.spring.restcountries.exception.CountryNotFoundException;
import com.cognizant.spring.restcountries.exception.ErrorResponse;



@RestControllerAdvice
public class CountryExceptionController {

	
	@ResponseStatus(code=HttpStatus.NOT_FOUND)
	@ExceptionHandler({CountryNotFoundException.class})
	public ErrorResponse handleExceptionCountryNotFound(Exception ex, HttpServletRequest request) {
		return new ErrorResponse(new Date(), HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase(), ex.getMessage(), request.getRequestURI());
	}
	
	
	
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	@ExceptionHandler({Exception.class})
	public ErrorResponse handleExceptionValidation1(Exception ex, HttpServletRequest request) {
		return new ErrorResponse(new Date(), HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase(), "Country code should be 2 characters", request.getRequestURI());
	}
	
	
	
	
	
}
