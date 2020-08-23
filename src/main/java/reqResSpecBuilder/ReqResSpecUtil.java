package reqResSpecBuilder;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class ReqResSpecUtil {

	public static RequestSpecification requestSpecBuilder() {
		RequestSpecification reqSpec = new RequestSpecBuilder().setContentType(ContentType.JSON)

				.addQueryParam("Key", "qaclick123").build();

		return reqSpec;
	}

	public static ResponseSpecification responseSpecBuilder() {
		ResponseSpecification resSpec = new ResponseSpecBuilder().expectStatusCode(200)
				.expectContentType(ContentType.JSON).expectHeader("Server", "Apache/2.4.18 (Ubuntu)").build();

		return resSpec;
	}

}
