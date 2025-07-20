package demo;
import static io.restassured.RestAssured.given;

import java.util.List;

import POJO.API;
import POJO.GetCourse;
import io.restassured.path.json.JsonPath;

public class OAuthTest {
	
public static void main(String[] args) {
	
	String response= given()
	.formParams("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
	.formParams("client_secret","erZOWM9g3UtwNRj340YYaK_W")
	.formParams("grant_type","client_credentials")
	.formParams("scope","trust")
	.when().log().all()
	.post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token").asString();

System.out.println(response);
JsonPath jsonpath = new JsonPath(response);
String accessToken = jsonpath.getString("access_token");
	 
GetCourse gc=  given()
.queryParams("access_token", accessToken)
	 .when().log().all()
	 .get("https://rahulshettyacademy.com/oauthapi/getCourseDetails").as(GetCourse.class);
	
	System.out.println(gc.getLinkedIn());
	System.out.println(gc.getLinkedIn());
	System.out.println(gc.getLinkedIn());
	
	System.out.println(gc.getInstructor());
	System.out.println(gc.getCourses().getApi().get(1).getCourseTitle());
	
	List<API> apiCourses = gc.getCourses().getApi();
	for(int i=0; i<apiCourses.size();i++)
	{
	  if(apiCourses.get(i).getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing"))
			 {
		      apiCourses.get(i).getPrice(); 
		      gc.getCourses().getMobile().get(1).getCourseTitle();
             }
     
     }
  }
}