package phoenix_api_automation_framework;

import static io.restassured.RestAssured.*;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.constants.Roles;
import com.utils.Authtoken_generator;
import com.utils.ConfigManager;

import io.restassured.module.jsv.JsonSchemaValidator;

public class CountAPITest {

	@Test
	public void verifyCountAPI()
	{
		given().baseUri(ConfigManager.getProperty("BASEURI")).header("Authorization",Authtoken_generator.getToken(Roles.FD))
		.when().get("/dashboard/count")
		.then().statusCode(200).log().body()
		.body("message", Matchers.equalTo("Success"))
		.body("data", Matchers.notNullValue())
		.body("data.label", Matchers.everyItem(Matchers.notNullValue()))
		.time(Matchers.lessThan(1500L))
		.body("data.count", Matchers.everyItem(Matchers.greaterThanOrEqualTo(0)))
		.body("data.key",Matchers.containsInAnyOrder("created_today","pending_for_delivery", "pending_fst_assignment"))
		.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("response_schema/count_api_schema.json"));

	}

	
	@Test
	public void missingtoken_countAPI()
	{
		
		given().baseUri(ConfigManager.getProperty("BASEURI")).header("Authorization","")
		.when().get("/dashboard/count")
		.then().statusCode(401);
	}
	
	
}
