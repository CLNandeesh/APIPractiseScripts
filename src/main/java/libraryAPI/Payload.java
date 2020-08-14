package libraryAPI;

public class Payload {
	
	public static String addBookPayload(String isbn,String aisle)
	{
		
		String p="{\r\n" + 
				"\r\n" + 
				"\"name\":\"Learn Appium Automation with Java\",\r\n" + 
				"\"isbn\":\""+isbn+"\",\r\n" + 
				"\"aisle\":\""+aisle+"\",\r\n" + 
				"\"author\":\"John foee\"\r\n" + 
				"}";
		
		return p;
	}

}
