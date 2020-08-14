package googlePlaceAPI;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

public class EtoETest {

	String place;

	@BeforeClass
	public void beforeClass() {
		RestAssured.baseURI = "https://rahulshettyacademy.com";
	}

	@Test
	public void addPlace() throws InterruptedException {
		Response res = given().queryParam("key", "qaclick123").contentType(ContentType.JSON)
				.body(Payloads.addPlacePayload()).when().post("/maps/api/place/add/json");

		// Validations body content and status code
		res.then().assertThat().statusCode(200);
		res.then().assertThat().body("status", equalTo("OK"));

		// Send res as string and key to get values
		place = ValidationUtils.getJsonKeyValue(res.asString(), "place_id");

		System.out.println("Place ID: " + place);

	}

	@Test(dependsOnMethods = { "addPlace" })
	public void deletePlace() throws InterruptedException {
		Response res = given().queryParam("key", "qaclick123").contentType(ContentType.JSON)
				.body(Payloads.deletePlace(place)).when().post("/maps/api/place/delete/json");

		// Validations body content and status code
		res.then().assertThat().body("status", equalTo("OK"));
		res.then().assertThat().statusCode(200);

	}

	@Test(dependsOnMethods = { "deletePlace" })
	public void getPlace() {
		Response res = given().queryParam("key", "qaclick123").queryParam("place_id", place).when()
				.get("/maps/api/place/get/json");

		// Validations body content and status code
		res.then().assertThat().body("msg", equalTo("Get operation failed, looks like place_id  doesn't exists"));
		res.then().assertThat().statusCode(404);

	}

}
