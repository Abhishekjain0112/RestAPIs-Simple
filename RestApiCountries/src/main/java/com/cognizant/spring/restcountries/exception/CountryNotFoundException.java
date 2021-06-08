package com.cognizant.spring.restcountries.exception;


public class CountryNotFoundException extends RuntimeException  {

		public CountryNotFoundException(String msg) {
			super(msg);
		}

}
