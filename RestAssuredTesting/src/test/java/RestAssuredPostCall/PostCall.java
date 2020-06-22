package RestAssuredPostCall;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostCall {
	
	
	@Test
	public void postCall1() {
		
		RestAssured.baseURI="http://restapi.demoqa.com/customer/";
		
		RequestSpecification request=	RestAssured.given();
		
		JSONObject obj=new JSONObject();
		obj.put("FirstName", "postmanman");
		obj.put("LastName", "manman");
		obj.put("UserName", "postmanseriesman");
		obj.put("Password", "poastmanman");
		obj.put("Email", "poatman112@gmail.com");
		
		request.header("Content-Type","application/json");   //attach the header
		request.body(obj.toJSONString());      //attach body to the request
		
		Response response=request.request(Method.POST,"register");
		
		int j=response.getStatusCode();
		System.out.println(j);
		//Assert.assertEquals(201, j);
		
		System.out.println(response.asString());
		
		String code=response.jsonPath().get("SuccessCode").toString();
				
		System.out.println(code);
		
		//get call
		
//		RestAssured.baseURI="http://restapi.demoqa.com/customer/register/";
//		
//		RequestSpecification connectioncreate=RestAssured.given();
//		
//		Response response2=connectioncreate.request(Method.GET,"hendrysenaww");
//		
//		System.out.println(response2.asString());
//		System.out.println(response2.getStatusCode());
		
	}

}
