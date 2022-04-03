package basic.rest.getcall;

import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
public class VerifyResponseTest {

	public static String baseUri = "https://api.trello.com";
	
	
	@Test(priority = 1)
	public void verifyResponseBody() {
		RestAssured.baseURI = baseUri;
	    given().
		param("key", "d5930f898d46c87dc59316a609ca916c").
		param("token","49aa524fe09cea4503a0aea1d391ed90b871f437147b768a63d876147aa74e0b").
		when().
		get("/1/boards/6yqzaBqG").
		then().
		assertThat().statusCode(200).and().
		contentType(ContentType.JSON).and().
	    body("name", equalTo("postman Testing 1"));
		System.out.println("verify response body");
	}
	
	@Test(priority = 2)
	public void verifyResponseHeader() {
		RestAssured.baseURI = baseUri;
		given().
		param("key", "d5930f898d46c87dc59316a609ca916c").
		param("token","49aa524fe09cea4503a0aea1d391ed90b871f437147b768a63d876147aa74e0b").
		when().
		get("/1/boards/6yqzaBqG").
		then().
		assertThat().statusCode(200).and().
		contentType(ContentType.JSON).and().
	   header("Referrer-Policy", "strict-origin-when-cross-origin").and().
	   header("X-Trello-Environment","Production"); 
		System.out.println("verify response header");
	}
}
