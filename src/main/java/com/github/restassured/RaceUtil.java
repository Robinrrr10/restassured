package com.github.restassured;

import org.testng.Assert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.restassured.entities.UserEntry;
import com.github.restassured.entities.UserResponse;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class RaceUtil {
	
	private String host = "http://localhost:8080";
	
    public void hitGetUrl(String endPoint)
    {
      Response response = RestAssured.get(host + endPoint);
      System.out.println("Status code:" + response.getStatusCode());
      Assert.assertEquals(response.getStatusCode(), 200);
      System.out.println("Response body is: "+response.getBody().asString());
      Assert.assertEquals(response.getBody().asString(), "Working");
    }
    
    public UserResponse login(String email, String password) throws JsonMappingException, JsonProcessingException {
    	UserEntry userEntry = new UserEntry();
    	userEntry.setEmail(email);
    	userEntry.setPassword(password);
    	RestAssured.baseURI = host;
    	RequestSpecification request = RestAssured.given();
    	request.header("Content-Type", "application/json");
    	request.body(userEntry);
    	Response response = request.post("/race/v1/user/login");
    	System.out.println("statusCode: "+response.getStatusCode());
    	String stringBody = response.getBody().asString();
    	System.out.println("Body :"+stringBody);
    	ObjectMapper objectMapper = new ObjectMapper();
    	UserResponse  userResponse = objectMapper.readValue(stringBody, UserResponse.class);
    	return userResponse;
    }
}
