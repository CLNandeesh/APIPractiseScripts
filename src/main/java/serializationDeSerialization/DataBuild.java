package serializationDeSerialization;

import java.util.ArrayList;
import java.util.List;

public class DataBuild {

	public static BelkLoginPayload belkLoginPayload() {
		BelkLoginPayload p = new BelkLoginPayload();

		p.setEmail("admin@ia.com");
		p.setPassword("admin");

		return p;
	}

	public static GetCourse getCourse() {
		
		GetCourse p = new GetCourse();

		//Main pojo class
		p.setInstructor("appu");
		p.setLinkdin("appu@linkdin");
		p.setUrl("www.google.com");

		
		
		Web[] web = new Web[2];

		web[0].setCourseTitle("Selenium");
		web[0].setPrice(50);

		web[1].setCourseTitle("Cypress");
		web[1].setPrice(90);

		API[] api = new API[2];

		api[0].setCourseTitle("RestAssured");
		api[0].setPrice(20);

		api[1].setCourseTitle("Soap");
		api[1].setPrice(30);

		List<API> a = new ArrayList<API>();

		Courses c = new Courses();
		c.setWeb(web);
		c.setApi(api);
		
		
		
		p.setCourses(c);

		return p;
	}

}
