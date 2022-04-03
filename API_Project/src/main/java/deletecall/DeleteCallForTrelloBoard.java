package deletecall;


import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
public class DeleteCallForTrelloBoard {

	public static String baseUri = "https://api.trello.com";
	public String id ;
	public String boardName;
	
	
	@Test(priority = 1)
	public void createBoard() {
		RestAssured.baseURI = baseUri;
		String boardName = "Automation Rest Board"+(int)Math.random()*100;
	   Response res= given().
		queryParam("key", "d5930f898d46c87dc59316a609ca916c").
		queryParam("token","49aa524fe09cea4503a0aea1d391ed90b871f437147b768a63d876147aa74e0b").
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
		boardName = path.get("name");
	    id = path.get("id");
		System.out.println("id :"+path.get("id"));
		System.out.println("name :"+path.get("name"));
		System.out.println("create board");
	}
	
	
	@Test(priority = 2,dependsOnMethods = "createBoard")
	public void deleteBoard() {
		RestAssured.baseURI = baseUri;
		 System.out.println(id +" "+ boardName );

	              	given().
					queryParam("key", "d5930f898d46c87dc59316a609ca916c").
					queryParam("token","49aa524fe09cea4503a0aea1d391ed90b871f437147b768a63d876147aa74e0b").
					queryParam("name", boardName).
				   	header("Content-Type","application/json").
					when().
					delete("/1/boards/"+id).
					then().
					assertThat().statusCode(200).and().
					contentType(ContentType.JSON);
	                System.out.println("delete board "+ id + boardName );
		
	}
}
