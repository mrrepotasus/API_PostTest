package com.PostTest.API;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class TestPost {
//	postTest 21
	@Test
	public void testPost() {
		//https://reqres.in/api/users
		JSONObject request = new JSONObject();
		request.put("name","NVIDIA");
		request.put("category", "VGA");
		request.put("price", 5000000);
		System.out.println(request.toJSONString());
		
		given().header("Content-Type","application/json")
		.contentType(ContentType.JSON).accept(ContentType.JSON)
		.body(request.toJSONString()).when().post("https://mern-backend-8881.herokuapp.com/products")
		.then().statusCode(200).log().all();
	}
	
}