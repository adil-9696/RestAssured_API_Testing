package phoenix_api_automation_framework;

import static io.restassured.RestAssured.*;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.utils.ConfigManager;

import Pojo_classes_automation_framework.logincred;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class LoginAPITest {

	
	@Test
	public void loginTest() {
		
		logincred reqbody=new logincred("iamfd","password");
		
		given().baseUri(ConfigManager.getProperty("BASEURI"))
		.contentType(ContentType.JSON)
		.body(reqbody).log().body()
		.when().post("login")
		.then().statusCode(200).time(Matchers.lessThan(1500L))
		.log().body().body("message", Matchers.equalTo("Success"))
		.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("response_schema/login_response_schema.json"));
		
		
	}
	
}
