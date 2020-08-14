package googlePlaceAPI;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class ValidationsTest {
	
	@Test
	public void validations()
	{
        RestAssured.baseURI="https://rahulshettyacademy.com";
		
		
		RequestSpecification spec=given().queryParam("Key","qaclick123").headers("Content-Type","application/json")
		.body(Payloads.addPlacePayload());
		
		Response res=spec.when().post("/maps/api/place/add/json");
		
		
		//To validate status code,body content,header content,cookie content
		res.then().assertThat().statusCode(200);
		res.then().assertThat().body("scope",equalTo("APP"));
		res.then().assertThat().header("Server","Apache/2.4.18 (Ubuntu)");
		
		//res.then().assertThat().cookie("", "");
		
		
		//to check res has this key
		System.out.println(ValidationUtils.jasonHasKey(res.asString(), "reference"));
		
		//To get value for a key
		System.out.println(ValidationUtils.getJsonKeyValue(res.asString(),"place_id" ));
		
		//To check specific key is null
		System.out.println(ValidationUtils.keyValueIsNull(res.asString(), "reference"));
		
		//To get value for a key
		
		System.out.println(ValidationUtils.getValueFoKey(res.asString(), "place_id"));
		
		
	}

}
