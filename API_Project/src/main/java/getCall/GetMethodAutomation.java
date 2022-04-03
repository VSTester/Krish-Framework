package getCall;

import static org.hamcrest.CoreMatchers.equalTo;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class GetMethodAutomation {

	public static String baseUri = "https://api.trello.com";

	public void firstGetRequest() {

		RestAssured.baseURI = baseUri;
	Response res=	given().
		param("key", "d5930f898d46c87dc59316a609ca916c").
		param("token","49aa524fe09cea4503a0aea1d391ed90b871f437147b768a63d876147aa74e0b").
		when().
		get("/1/boards/6yqzaBqG").
		then().
		assertThat().statusCode(200).and().
		contentType(ContentType.JSON).and().
	    body("name", equalTo("postman Testing 1")).extract().response();
	System.out.println("This is my first automation get request");
	System.out.println(res.asString());


	}

	public static void main(String[] args) {
		GetMethodAutomation getMethod = new GetMethodAutomation();
		getMethod.firstGetRequest();

	}


}
