package reqResSpecBuilder;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AddPlace {
	
	
	@Test
	public void addPlace() {
		
	   RestAssured.baseURI="https://rahulshettyacademy.com";	
		
       RequestSpecification req=given().spec(ReqResSpecUtil.requestSpecBuilder()).queryParam("Key","qaclick123").header("Content-Type","application/json")
       .body("{\r\n" + 
       		"  \"location\": {\r\n" + 
       		"    \"lat\": -38.383494,\r\n" + 
       		"    \"lng\": 33.427362\r\n" + 
       		"  },\r\n" + 
       		"  \"accuracy\": 50,\r\n" + 
       		"  \"name\": \"NCL Mansion\",\r\n" + 
       		"  \"phone_number\": \"(+91) 983 893 3937\",\r\n" + 
       		"  \"address\": \"29, side layout, cohen 09\",\r\n" + 
       		"  \"types\": [\r\n" + 
       		"    \"shoe park\",\r\n" + 
       		"    \"shop\"\r\n" + 
       		"  ],\r\n" + 
       		"  \"website\": \"http://google.com\",\r\n" + 
       		"  \"language\": \"French-IN\"\r\n" + 
       		"}");
       
       Response res=req.when().post("/maps/api/place/add/json");
       
       res.then().spec(ReqResSpecUtil.responseSpecBuilder());
       
       
       
       
	}

}
