package rest.basic.testing;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PostRequest {
	
	@Test
	public void validateResponse() {

		RestAssured.baseURI = "https://maps.googleapis.com";
		given().
		param("location", "-33.8670522,151.1957362").
		param("radius", "1500").
		param("type", "restaurant").
		param("keyword", "cruise").
		param("key", "AIzaSyCqGe8BAZ2yesZ804_6yCJt3NchtsG08Xo").
		
		when().
		get("/maps/api/place/nearbysearch/json").
		
		then().assertThat().statusCode(200).and().
		contentType(ContentType.JSON).and().
		body("results[1].name", equalTo("Australian Cruise Group Circular Quay")).and().
		header("server", "scaffolding on HTTPServer2");
		System.out.println("Request is executed sucessfully");
	}

}
