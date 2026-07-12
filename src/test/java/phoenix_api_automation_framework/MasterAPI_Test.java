package phoenix_api_automation_framework;

import com.constants.Roles;
import com.utils.Authtoken_generator;
import com.utils.ConfigManager;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.*;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class MasterAPI_Test {

	@Test
	public void verifymasterAPI()
	{
             given().baseUri(ConfigManager.getProperty("BASEURI")).header("Authorization",Authtoken_generator.getToken(Roles.FD))
             .contentType(ContentType.JSON)
             .when().post("master")
             .then().statusCode(200).log().body()
             .body("message", Matchers.equalTo("Success"))
             .time(Matchers.lessThan(1500L))
             .body("data", Matchers.notNullValue())
             .body("data", Matchers.hasKey("mst_oem"))
             .body("$",Matchers.hasKey("message"))
             .body("data.mst_oem.size()", Matchers.greaterThan(0))
             .body("data.mst_oem.id",Matchers.everyItem(Matchers.notNullValue()))
             .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("response_schema/master_api_schema.json"));    
		
	}
}
