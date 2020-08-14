package libraryAPI;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AddBookWithHashMap {
	
	
	@Test()
	public void addBook()
	{
		RestAssured.baseURI="http://216.10.245.166";
		
		//Hash Map
		HashMap<String , String> map=new HashMap<String , String>();
		
		map.put("name","Appium Automation with Java");
		map.put("isbn","kgf22");
		map.put("aisle","123");
		map.put("author","NCL");
		
		
		RequestSpecification spec=given().contentType(ContentType.JSON)
		.body(map);
		
		
		Response res=spec.when().post("/Library/Addbook.php");
		
		
		res.then().assertThat().statusCode(200);
		res.then().assertThat().body("Msg",equalTo("successfully added"));
	}
	

}
