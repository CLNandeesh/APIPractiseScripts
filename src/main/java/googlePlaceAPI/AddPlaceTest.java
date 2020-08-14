package googlePlaceAPI;

import io.restassured.RestAssured;
import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class AddPlaceTest {

	@Test
	public void addPlace() {
		RestAssured.baseURI = "https://rahulshettyacademy.com";

		RequestSpecification spec = given().log().all().queryParam("Key", "qaclick123")
				.headers("Content-Type", "application/json").body(Payloads.addPlacePayload());

		Response res = spec.when().log().all().post("/maps/api/place/add/json");

		// To print response
		System.out.println(res.asString());

		// to print header and body
		System.out.println(res.getBody().asString());
		System.out.println(res.getHeaders());

		// to print server name in header
		System.out.println(res.getHeader("Server"));

		// to print response
		System.out.println(res.then().extract().response().asString());

	}

}
