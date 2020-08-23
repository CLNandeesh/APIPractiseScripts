package serializationDeSerialization;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BelkLoginTest {
	
	
	@Test
	public void belkLoginTest()
	{
		RestAssured.baseURI="https://belk-as-dev.iaproducts.ai";
		
		
		//.expect().defaultParser(Parser.JSON)
		
		RequestSpecification req=given().header("Content-Type","application/json")
        .body(DataBuild.belkLoginPayload());
		
		
		BelkLoginResponsePayload res=req.when().post("/api/users/login")
				                     .as(BelkLoginResponsePayload.class);
		
		System.out.println(res.getMessage());
		System.out.println(res.getData().getUserData().getEmail());

		BelkLoginPayload b=new BelkLoginPayload();

		Assert.assertEquals(res.getData().getUserData().getEmail(), b.getEmail());
		
		//String response=res.then().assertThat().statusCode(200).extract().response().asString();
		
		//System.out.println(response);
	}

}
