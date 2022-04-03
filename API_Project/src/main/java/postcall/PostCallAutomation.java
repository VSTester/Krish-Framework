package postcall;



import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
public class PostCallAutomation {
	public static String baseUri = "https://api.trello.com";
	
	
	@Test(priority = 1)
	public void createBoard() {
		RestAssured.baseURI = baseUri;
		String boardName = "Automation Rest Board"+(int)Math.random()*100;
	   Response res= given().
		queryParam("key", "d5930f898d46c87dc59316a609ca916c").
		queryParam("token","49aa524fe09cea4503a0aea1d391ed90b871f437147b768a63d876147aa74e0b").
		queryParam("name", boardName).
	   	header("Content-Type","application/json").
		when().
		post("/1/boards").
		then().
		assertThat().statusCode(200).and().
		contentType(ContentType.JSON).
		body("name",equalTo(boardName)).extract().response();
		System.out.println("create trello board");
		String jsonResponse = res.asString();
		JsonPath path = new JsonPath(jsonResponse);
		//System.out.println(res.asPrettyString());
		System.out.println("id :"+path.get("id"));
		System.out.println("name :"+path.get("name"));
	}
}
