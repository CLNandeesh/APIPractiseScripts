package libraryAPI;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;





public class AddBook {

	
	@Test(dataProvider="getData")
	public void addBook(Object... d)
	{
		RestAssured.baseURI="http://216.10.245.166";
		
		RequestSpecification spec=given().contentType(ContentType.JSON)
		.body(Payload.addBookPayload(d[0].toString(),d[1].toString()));
		
		
		Response res=spec.when().post("/Library/Addbook.php");
		
		
		res.then().assertThat().statusCode(200);
		res.then().assertThat().body("Msg",equalTo("successfully added"));
	}
	
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data=new Object[2][2];
		
		
		data[0][0]="kgf1";
		data[0][1]="700";
		
		data[1][0]="kgf2";
		data[1][1]="800";
		
		
		return data;
	}
}
