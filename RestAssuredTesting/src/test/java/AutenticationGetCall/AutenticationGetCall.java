package AutenticationGetCall;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AutenticationGetCall {
	
	
	@Test
	public void autenticationGetCall() {
		
		RestAssured.baseURI="http://restapi.demoqa.com/autentication/CheckForAutntication";
		
		//*****************************************************
		//basic autentication
		PreemptiveBasicAuthScheme scheme=new PreemptiveBasicAuthScheme();
		scheme.setUserName("ToolsQA");
		scheme.setPassword("TestPassword");
		
		RestAssured.authentication=scheme;
		
		//******************************************************
		RequestSpecification spec=RestAssured.given();
		
		Response response=spec.request(Method.GET,"/");
		
		int j=response.getStatusCode();
		
		
		System.out.println(j);
		System.out.println(response.body().asString());
		
		
	}
	
	
	
	

}
