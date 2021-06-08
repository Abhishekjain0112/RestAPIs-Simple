package com.cognizant.spring.restcountries.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.naming.ContextNotEmptyException;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cognizant.spring.restcountries.exception.CountryNotFoundException;
import com.cognizant.spring.restcountries.model.Country;

@RestController
public class CountryController {

	List<Country> countires = new ArrayList<>();
	
	@PostConstruct
	public void  init() {		
		countires.add(new Country("IN", "India"));
		countires.add(new Country("US", "United States"));
		countires.add(new Country("JP", "Japan"));
		countires.add(new Country("DE", "Germany"));
		}
	
	
	@GetMapping("/country")
	public Country getCountryIndia() {
		return new Country("IN", "India");
	}
	
	@GetMapping("/countries")
	public List<Country> getCountries() {

          return  countires;
	}
	
	@GetMapping("/countries/{code}")
	
	public Country getCountry(@PathVariable String code) {
		
		Optional<Country> opt=countires.stream().filter(c-> c.getCode().equalsIgnoreCase(code)).findAny();
		Country cun=null;
		if(opt.isPresent())
		cun= opt.get();
		else 
			throw new CountryNotFoundException("Country Not Found!");
	return cun;
		
	}
	
	@PutMapping("/country/add")
	public Country addCountry(@RequestBody @Valid Country country) {
		countires.add(country); 
		return country;
	}
	
	@DeleteMapping("/country/{code}")
	public Country delet(@PathVariable String code) {
		
		Optional<Country> opt=countires.stream().filter(c-> c.getCode().equalsIgnoreCase(code)).findAny();
		Country cun=null;
		if(opt.isPresent()) {
		cun= opt.get();
		countires.remove(cun);
		}
		else 
			throw new CountryNotFoundException("Country Not Found!");
	return cun;
		
	}	
	
	
	
	
}
