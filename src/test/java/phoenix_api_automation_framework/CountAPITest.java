package phoenix_api_automation_framework;

import static io.restassured.RestAssured.*;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.constants.Roles;
import com.utils.Authtoken_generator;
import com.utils.ConfigManager;
import com.utils.SpecUtil;

import io.restassured.module.jsv.JsonSchemaValidator;

public class CountAPITest {

	@Test(description="to verify countAPI", groups= {"api","regression","smoke"})
	public void verifyCountAPI()
	{
		given().spec(SpecUtil.requestspecwithAuth(Roles.FD))
		.when().get("/dashboard/count")
		.then()
		.spec(SpecUtil.responsespec())
		.body("message", Matchers.equalTo("Success"))
		.body("data", Matchers.notNullValue())
		.body("data.label", Matchers.everyItem(Matchers.notNullValue()))
		.body("data.count", Matchers.everyItem(Matchers.greaterThanOrEqualTo(0)))
		.body("data.key",Matchers.containsInAnyOrder("created_today","pending_for_delivery", "pending_fst_assignment"))
		.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("response_schema/count_api_schema.json"));

	}

	
	@Test(description="to verify CountAPI with missing token", groups= {"api","negative","regression","smoke"})
	public void missingtoken_countAPI()
	{
		
		given().spec(SpecUtil.requestspecwithMissingAuth())
		.when().get("/dashboard/count")
		.then().spec(SpecUtil.responsespec(401));
	}
	
	
}
