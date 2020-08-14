package googlePlaceAPI;

public class Payloads {
	
	public static String addPlacePayload()
	{
		String p="{\r\n" + 
				"  \"location\": {\r\n" + 
				"    \"lat\": -38.383494,\r\n" + 
				"    \"lng\": 33.427362\r\n" + 
				"  },\r\n" + 
				"  \"accuracy\": 50,\r\n" + 
				"  \"name\": \"Kat Mansion\",\r\n" + 
				"  \"phone_number\": \"(+91) 983 893 3937\",\r\n" + 
				"  \"address\": \"29, side layout, cohen 09\",\r\n" + 
				"  \"types\": [\r\n" + 
				"    \"shoe park\",\r\n" + 
				"    \"shop\"\r\n" + 
				"  ],\r\n" + "  \"website\": \"http://google.com\",\r\n" + 
				"  \"language\": \"French-IN\"\r\n" + 
				"}";
		
		return p;
	}
	
	
	public static String deletePlace(String place)
	{
		String p="{\r\n" + 
				"    \"place_id\":\""+place+"\"\r\n" + 
				"}\r\n" + 
				" ";
		return p;
	}

}
