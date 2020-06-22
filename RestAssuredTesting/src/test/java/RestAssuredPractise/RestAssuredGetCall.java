package RestAssuredPractise;

import java.util.Iterator;
import java.util.LinkedHashMap;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
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
		
		String temperature=res.jsonPath().get("Temperature").toString();
		System.out.println(temperature);
		
		Headers j=res.getHeaders();
		String headername=j.get("Server").toString();
		System.out.println("headername--------------"+headername);
		LinkedHashMap<String, String> q=new LinkedHashMap<String, String>();
		
		Iterator<Header> l=j.iterator();
		while(l.hasNext()) {
			
			
			Header k=l.next();
			String[] m=k.toString().split("=");
			q.put(m[0], m[1]);
			
		}
		
		System.out.println(q);
		
	}

}
