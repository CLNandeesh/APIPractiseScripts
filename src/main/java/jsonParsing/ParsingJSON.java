package jsonParsing;

import io.restassured.path.json.JsonPath;

public class ParsingJSON {

	public static String payLoad() {
		String s = "{\r\n" + "\r\n" + "\"dashboard\": {\r\n" + "\r\n" + "\"purchaseAmount\": 910,\r\n" + "\r\n"
				+ "\"website\": \"rahulshettyacademy.com\"\r\n" + "\r\n" + "},\r\n" + "\r\n" + "\"courses\": [\r\n"
				+ "\r\n" + "{\r\n" + "\r\n" + "\"title\": \"Selenium Python\",\r\n" + "\r\n" + "\"price\": 50,\r\n"
				+ "\r\n" + "\"copies\": 6\r\n" + "\r\n" + "},\r\n" + "\r\n" + "{\r\n" + "\r\n"
				+ "\"title\": \"Cypress\",\r\n" + "\r\n" + "\"price\": 40,\r\n" + "\r\n" + "\"copies\": 4\r\n" + "\r\n"
				+ "},\r\n" + "\r\n" + "{\r\n" + "\r\n" + "\"title\": \"RPA\",\r\n" + "\r\n" + "\"price\": 45,\r\n"
				+ "\r\n" + "\"copies\": 10\r\n" + "\r\n" + "}\r\n" + "\r\n" + "]\r\n" + "\r\n" + "}";

		return s;

	}

	/*
	 * 1. Print No of courses returned by API
	 * 
	 * 2.Print Purchase Amount
	 * 
	 * 3. Print Title of the first course
	 * 
	 * 4. Print All course titles and their respective Prices
	 * 
	 * 5. Print no of copies sold by RPA Course
	 * 
	 * 6. Verify if Sum of all Course prices matches with Purchase Amount
	 * 
	 */

	public static void main(String[] args) {

		JsonPath j = new JsonPath(payLoad());

		// 1. Print No of courses returned by API
		int size = j.getInt("courses.size()");

		System.out.println("No of courses: " + size);

		System.out.println("**********");

		// 2.Print Purchase Amount

		int purchaseAmount = j.getInt("dashboard.purchaseAmount");
		System.out.println("PurchaseAmount is:" + purchaseAmount);

		System.out.println("**********");

		// 3. Print Title of the first course
		String title = j.getString("courses[0].title");
		System.out.println("Title is: " + title);

		System.out.println("**********");

		// 4. Print All course titles and their respective Prices
		for (int i = 0; i < size; i++) {
			String t = j.getString("courses[" + i + "].title");
			int price = j.getInt("courses[" + i + "].price");
			System.out.println("Title is: " + t + " and Price is: " + price);

		}

		System.out.println("**********");
		// 5. Print no of copies sold by RPA Course
		for (int i = 0; i < size; i++) {
			String t = j.getString("courses[" + i + "].title");
			if (t.equalsIgnoreCase("RPA")) {
				int price = j.getInt("courses[" + i + "].price");
				System.out.println("Title is: " + t + " and Price is: " + price);
				break;
			}

		}

		System.out.println("**********");

		// 6. Verify if Sum of all Course prices matches with Purchase Amount
		int sum = 0;
		int price;
		int copies;
		int newPrice;
		for (int i = 0; i < size; i++) {
			price = j.getInt("courses[" + i + "].price");
			copies = j.getInt("courses[" + i + "].copies");
			newPrice = price * copies;
			sum = sum + newPrice;

		}

		System.out.println("Expected purchase amount price: " + purchaseAmount);
		System.out.println("Actual purchase amount price: " + sum);

	}

}
