package com.cognizant.spring.restcountries.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;



@ExtendWith(SpringExtension.class)
@WebMvcTest(value = CountryController.class)
class CountryControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	
	@Test
	void testGetCountry() throws Exception {

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/countries/US");
		MvcResult result = mockMvc.perform(requestBuilder)
				.andExpect(status().isOk())
				.andExpect(content().json("{\"code\":\"US\",\"name\":\"United States\"}"))
					.andReturn();	
	}
	
	

	@Test
	void testExceptional() throws Exception {

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/countries/USA");
		MvcResult result = mockMvc.perform(requestBuilder)
				.andExpect(status().isNotFound())
				.andExpect(status().reason("Country Not Found!"))
					.andReturn();	
	}	
	
	
	

}
