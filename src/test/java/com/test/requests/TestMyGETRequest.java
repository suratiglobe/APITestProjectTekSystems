package com.test.requests;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class TestMyGETRequest {
		
	@Test	
	public void validateStatusResponseWithValidCountryName() {
		
		String url = "https://restcountries.eu/rest/v2/name/Canada";
		
		Response response = given().get(url);	 
		Assert.assertEquals(response.statusCode(), 200);
	}
	
	@Test	
	public void validateStatusResponseWithInValidCountryName() {
		
		String url = "https://restcountries.eu/rest/v2/name/hulefia";
		
		Response response = given().get(url);	 
		Assert.assertEquals(response.statusCode(), 404);
	}
		
	@Test	
	public void validateStatusResponseWithValidCountryCode() {
		
		String url = "https://restcountries.eu/rest/v2/alpha/US";
		
		Response response = given().get(url);	 
		Assert.assertEquals(response.statusCode(), 200);
	}
	
	@Test	
	public void validateStatusResponseWithInValidCountryCode() {
		
		String url = "https://restcountries.eu/rest/v2/alpha/USMD";
		
		Response response = given().get(url);	 
		Assert.assertEquals(response.statusCode(), 400);
	}
	
	@Test	
	public void validateCapitalCityForValidCountryName() {
		
		String url = "https://restcountries.eu/rest/v2/name/Australia";
		
		Response response = given().get(url);	 
		Assert.assertEquals(response.jsonPath().get("capital").toString().replaceAll("\\p{P}",""), "Canberra");
	}
	
	@Test	
	public void validateCapitalCityIsNullForInValidCountryName() {
		
		String url = "https://restcountries.eu/rest/v2/name/lugetiva";
		
		Response response = given().get(url);	 
		Assert.assertNull(response.jsonPath().get("capital"));
	}	
	
	@Test	
	public void validateCapitalCityForValidCountryCode() {
		
		String url = "https://restcountries.eu/rest/v2/alpha/IND";
		
		Response response = given().get(url);	 
		Assert.assertEquals(response.jsonPath().get("capital").toString().replaceAll("\\p{P}",""), "New Delhi");
	}
	
	@Test	
	public void validateCapitalCityIsNullForInValidCountryCode() {
		
		String url = "https://restcountries.eu/rest/v2/alpha/";
		
		Response response = given().get(url);	 
		Assert.assertNull(response.jsonPath().get("capital"));
	}	
}
