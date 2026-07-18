package phoenix_api_automation_framework;

import static io.restassured.RestAssured.*;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.constants.Roles;
import com.utils.Authtoken_generator;
import com.utils.ConfigManager;
import com.utils.SpecUtil;

import io.restassured.http.Header;

public class UserdetailAPI_Test {

	@Test(description = "to verify Userdetail API", groups = { "api", "regression", "smoke" })
	public void userdetailAPI_Test() {

		given().spec(SpecUtil.requestspecwithAuth(Roles.FD))

				.when().get("userdetails").then().spec(SpecUtil.responsespec())
				.body("message", Matchers.equalTo("Success"));

	}

}
