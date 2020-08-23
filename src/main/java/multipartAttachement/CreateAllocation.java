package multipartAttachement;

import static io.restassured.RestAssured.*;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CreateAllocation {

	@Test
	public void createAllocation() {
		RestAssured.baseURI = "https://joann-allocation.impactanalytics.co";
		Response response = given().log().all().header("Content-Type", "multipart/form-data").header("Authorization",
				"Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MTExLCJuYW1lIjoiTmFuZGVlc2ggQ0wiLCJ1c2VybmFtZSI6Im5hbmRlZXNoLmNsQGltcGFjdGFuYWx5dGljcy5jbyIsImVtYWlsIjoibmFuZGVlc2guY2xAaW1wYWN0YW5hbHl0aWNzLmNvIiwicGFzc3dvcmRfaGFzaCI6ImVhYjE3M2EwMzAzNGExOWRhOWI4OTBlMzg5NmRhYzVkMWJhNGVjN2M5Mzc4OWRjMjI0Nzg0MzJkZGI1YzQ0ODAyM2E4MzEwNzYwMjk4ZTBkNGIzNjJlZGQ2OTAzZDNiNjI2NWFhOTFiZmM3MzliNzcwNWI3MWY5MDhkYmNiMmRjIiwic2FsdCI6IiQyYiQxMCRNaW9HeXhrOW5GTUx2Q3JFajFIQzd1IiwiYWN0aXZlIjp0cnVlLCJjcmVhdGVkYXQiOiIyMDIwLTAxLTI4VDEwOjU2OjE2LjI5OVoiLCJ1cGRhdGVkYXQiOiIyMDIwLTA1LTA1VDA2OjQ3OjI0LjI2MFoiLCJhZG1pbiI6dHJ1ZSwiaXNfZm9yZ2V0X3Bhc3N3b3JkIjpmYWxzZSwiaWF0IjoxNTk3NTUwNDAyLCJleHAiOjE1OTc1ODY0MDJ9.zfZ4eByc-0QT9IKVMI1YkWeCIasBlrP6uXI76CPTF0w")
				
				
			    .multiPart("file", new File("1 artc.xlsx"))
			    
			  /*  .formParam("name", "Raffel_1")
			    
			 
					.formParam("mmName", "A. Chicatelli").formParam("programName", "BCTW1 Wilton Summer FW13")
					.formParam("push", "INITIAL").formParam("toBeLinked", false).formParam("toBeOverridden", true)
					.formParam("comments", "my comment")*/
					
					
			    .multiPart("name", "Raffel_1")
				.multiPart("mmName", "A. Chicatelli").multiPart("programName", "BCTW1 Wilton Summer FW13")
				.multiPart("push", "INITIAL").multiPart("toBeLinked", false).multiPart("toBeOverridden", true)
				.multiPart("comments", "my comment")
				
				
				.when().log().all().post("/allocation");

		response.then().assertThat().statusCode(201);
		System.out.println(response);

	}
}
