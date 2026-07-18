package phoenix_api_automation_framework;

import com.constants.Roles;
import com.utils.Authtoken_generator;
import com.utils.ConfigManager;
import com.utils.SpecUtil;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.*;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class MasterAPI_Test {

	@Test(description="to verify MasterAPI", groups= {"api","regression","smoke"})
	public void verifymasterAPI()
	{
             given().spec(SpecUtil.requestspecwithAuth(Roles.FD))
             .when().post("master")
             .then()
             .spec(SpecUtil.responsespec())
             .body("message", Matchers.equalTo("Success"))
             .body("data", Matchers.notNullValue())
             .body("data", Matchers.hasKey("mst_oem"))
             .body("$",Matchers.hasKey("message"))
             .body("data.mst_oem.size()", Matchers.greaterThan(0))
             .body("data.mst_oem.id",Matchers.everyItem(Matchers.notNullValue()))
             .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("response_schema/master_api_schema.json"));    
		
	}
}
