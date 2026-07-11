package phoenix_api_automation_framework;

import static io.restassured.RestAssured.*;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.constants.Roles;
import com.utils.Authtoken_generator;
import com.utils.ConfigManager;

import io.restassured.http.Header;

public class UserdetailAPI_Test {

 
	@Test
	public void userdetailAPI_Test() {
	Header auth=new Header ("Authorization",Authtoken_generator.getToken(Roles.FD));
	
	
	given().baseUri(ConfigManager.getProperty("BASEURI")).header(auth)
	.when().get("userdetails").
	then().log().body().statusCode(200).body("message",Matchers.equalTo("Success"))
	.time(Matchers.lessThan(1500L));
	
	}
 
}
