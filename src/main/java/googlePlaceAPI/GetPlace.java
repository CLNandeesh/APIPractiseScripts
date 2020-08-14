package googlePlaceAPI;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetPlace {

	@Test
	public void getPlace() {

		RestAssured.baseURI = "https://rahulshettyacademy.com";

		Response res = given().log().all().queryParam("place_id", "0b46f43a2857ed50c858567136c0b253")
				.queryParam("key", "qaclick123").when().log().all().get("/maps/api/place/get/json");

		// Validations body content and status code
		res.then().assertThat().body("msg", equalTo("Get operation failed, looks like place_id  doesn't exists"));
		res.then().assertThat().statusCode(404);

	}

}
