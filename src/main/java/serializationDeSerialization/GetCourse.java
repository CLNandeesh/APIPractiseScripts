package serializationDeSerialization;

import java.util.List;


/*{
	  "instructor": "appu",
	  "url": "www.google.com",
	  "courses": {
	    "web": [
	      {
	        "courseTitle": "selenium",
	        "price": 50
	      },
	      {
	        "courseTitle": "cyPress",
	        "price": 90
	      }
	    ],
	    "api": [
	      {
	        "courseTitle": "soapUI",
	        "price": 60
	      },
	      {
	        "courseTitle": "restassured",
	        "price": 30
	      }
	    ]
	  },
	  "linkdin": "appu@linkdin"
	}
*/

public class GetCourse {
	
	
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Courses getCourses() {
		return courses;
	}
	public void setCourses(Courses courses) {
		this.courses = courses;
	}
	public String getLinkdin() {
		return linkdin;
	}
	public void setLinkdin(String linkdin) {
		this.linkdin = linkdin;
	}
	private String instructor;
	private String url;
	private Courses courses;
	private String linkdin;
	

}
