package rest.basic.testing;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class GetRequestSampl {
	
	 // navigate to "https://developers.google.com/places/web-service/search"
		//https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=-33.8670522,151.1957362&radius=1500&type=restaurant&keyword=cruise&key=AIzaSyCqGe8BAZ2yesZ804_6yCJt3NchtsG08Xo
		//API Key = AIzaSyCqGe8BAZ2yesZ804_6yCJt3NchtsG08Xo
		
	static String baseURI = "https://maps.googleapis.com"; //Base URI
	
	public static void main(String[] args) {

		RestAssured.baseURI = baseURI;
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
		body("results[1].name", equalTo("Australian Cruise Group Circular Quay"));
		System.out.println("Request is executed sucessfully");
	}

}
