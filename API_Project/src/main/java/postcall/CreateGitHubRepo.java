package postcall;



import static org.hamcrest.CoreMatchers.equalTo;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
public class CreateGitHubRepo {
	public static String baseUri = "https://api.github.com";
	

	@Test(priority = 1)
	public void createBoard() {
		RestAssured.baseURI = baseUri;
		String bearerToken = "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";
	    given().
		
	   	header("Content-Type","application/json").
	   	header("Authorization","Bearer"+bearerToken).
	   	body("{\r\n"
	   			+ "    \"name\":\"API-Repo\",\r\n"
	   			+ "    \"description\" : \"git repo created by post call through postman\"\r\n"
	   			+ "}").
		when().
		post("/user/repos").
		then().
		assertThat().statusCode(201).and().
		contentType(ContentType.JSON).
		body("name",equalTo("API-Repo"));
		System.out.println("create trello board");
	}
}
