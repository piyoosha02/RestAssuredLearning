package rest.basic.testing;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;


public class PostRequest {
	
	@Test
	public void validateResponse() {

		RestAssured.baseURI = "https://maps.googleapis.com";
		given().
		queryParam("key", "AIzaSyCqGe8BAZ2yesZ804_6yCJt3NchtsG08Xo").
		body("{\r\n" + 
				"  \"location\": {\r\n" + 
				"    \"lat\": -33.8669710,\r\n" + 
				"    \"lng\": 151.1958750\r\n" + 
				"  },\r\n" + 
				"  \"accuracy\": 50,\r\n" + 
				"  \"name\": \"Google Shoes!\",\r\n" + 
				"  \"phone_number\": \"(02) 9374 4000\",\r\n" + 
				"  \"address\": \"48 Pirrama Road, Pyrmont, NSW 2009, Australia\",\r\n" + 
				"  \"types\": [\"shoe_store\"],\r\n" + 
				"  \"website\": \"http://www.google.com.au/\",\r\n" + 
				"  \"language\": \"en-AU\"\r\n" + 
				"}").
		
		when().
		post("maps/api/place/add/json").
		
		then().assertThat().statusCode(200).and().body("scope", equalTo("APP"));
		System.out.println("Request is executed sucessfully");
		
//		and().
//		contentType(ContentType.JSON).and().
//		body("results[1].name", equalTo("Australian Cruise Group Circular Quay")).and().
//		header("server", "scaffolding on HTTPServer2");
//		System.out.println("Request is executed sucessfully");
	}

}
