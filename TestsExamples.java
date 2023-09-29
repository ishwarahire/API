package tests;

import org.hamcrest.Matcher.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.ResponseAwareMatcher.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.*;
import java.net.http.HttpRequest.BodyPublisher;


public class TestsExamples 
{	
	@Test
	public void test_1()
	{	
		Response responce= get("https://reqres.in/api/users?page=2");
		
		System.out.println(responce.getStatusCode());
		System.out.println(responce.getTime());	
		System.out.println(responce.getBody().asString());
		System.out.println(responce.getStatusLine());
		System.out.println(responce.getHeader("content-type"));
		
		int statusCode=responce.getStatusCode();
		Assert.assertEquals(statusCode, 200);	
	}
	@Test
	public void test_2()
	{	
		baseURI = "https://reqres.in/api";
		   given().
		   get("/users?page=2").
		   then().
		   statusCode(200).
		   body("data[1].id",equalTo(8)).
		   log().all();		
	}
	}
