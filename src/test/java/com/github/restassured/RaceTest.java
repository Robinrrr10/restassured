package com.github.restassured;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.github.restassured.entities.UserResponse;

/**
 * Unit test for simple App.
 */
public class RaceTest {
   
	RaceUtil raceUtil = new RaceUtil();
	
	@Test
	public void checkHealthAPI() {
		String endPoint = "/race/v1/base/health";
		raceUtil.hitGetUrl(endPoint);
	}
	
	@Test
	public void loginWithValidCredential() throws JsonMappingException, JsonProcessingException {
		String email = "abc@gmail.com";
		String password = "12345";
		UserResponse userResponse = raceUtil.login(email, password);
		Assert.assertEquals(userResponse.getStatus().getStatusCode(), 1001);
		Assert.assertEquals(userResponse.getUserEntry().getName(), "Kumar");
	}
}
