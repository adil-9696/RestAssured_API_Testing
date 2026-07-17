package phoenix_api_automation_framework;

import static io.restassured.RestAssured.*;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utils.ConfigManager;
import com.utils.SpecUtil;

import Pojo_classes_automation_framework.logincred;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class LoginAPITest {
	logincred reqbody;

	@BeforeMethod(description = "create payload for LoginAPI", groups = { "api", "regression", "smoke" })
	public void setup() {
		reqbody = new logincred("iamfd", "password");
	}

	@Test
	public void loginTest() {

		given().spec(SpecUtil.requestspec(reqbody)).when().post("login").then().spec(SpecUtil.responsespec())
				.body("message", Matchers.equalTo("Success"))
				.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("response_schema/login_response_schema.json"));

	}

}
