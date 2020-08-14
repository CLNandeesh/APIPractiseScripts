package libraryAPI;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AddBookWithStaticJson {

	@Test
	public void main() throws IOException {

		RestAssured.baseURI = "http://216.10.245.166";

		RequestSpecification spec = given().log().all().contentType(ContentType.JSON)
				.body(Utils.staticJsonReader("./src\\main\\java\\libraryAPI\\addBook.json"));

		Response res = spec.when().log().all().post("/Library/Addbook.php");

		res.then().assertThat().statusCode(200);
		res.then().assertThat().body("Msg", equalTo("successfully added"));

	}

}
