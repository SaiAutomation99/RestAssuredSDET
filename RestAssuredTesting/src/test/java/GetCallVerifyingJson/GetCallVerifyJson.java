package GetCallVerifyingJson;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetCallVerifyJson {


	@Test
	public void getCallJsonVerify() {


		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city/";

		RequestSpecification connection=RestAssured.given();
		Response response=connection.request(Method.GET,"/delhi");
		
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		System.out.println(response.body().asString());
		
		Assert.assertEquals(response.body().asString().contains("Delhi"), true);
		
		JsonPath jsonpath=new JsonPath(response.body().asString());
		String h=jsonpath.get("City").toString();
		System.out.println(h);





	}

}
