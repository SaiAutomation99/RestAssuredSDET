package RestAssuredPractise;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredGetCall {


	@Test
	public void getCall() {

		//	http://restapi.demoqa.com/utilities/weather/city/



		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city/";

		RequestSpecification  requestsepecifcation=	RestAssured.given();
		Response res=	requestsepecifcation.request(Method.GET, "Hyderabad");
		System.out.println(res.asString());

		JSONObject json=new JSONObject();

		System.out.println(res.getStatusCode());



	}

}
