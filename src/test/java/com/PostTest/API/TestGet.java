package com.PostTest.API;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestGet {

String endpoint = "https://mern-backend-8881.herokuapp.com/products";
	
	@Test
	public void testStatusCode() {
		Response response = RestAssured.get(endpoint);
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
	}
	
	@Test
	public void testName() {
		given().get(endpoint).then().statusCode(200).body("name[31]", equalTo("NVIDIA"));
	}
	
	@Test
	public void testCategory() {
		given().get(endpoint).then().statusCode(200).body("category[31]", equalTo("VGA"));
	}
	
	@Test
	public void testPrice() {
		given().get(endpoint).then().statusCode(200).body("price[31]", equalTo(5000000));
	}
}
