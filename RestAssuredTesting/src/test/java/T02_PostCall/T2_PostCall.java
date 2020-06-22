package T02_PostCall;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class T2_PostCall {
	
	
	@DataProvider(name = "data")
	public Object[][] dataProvider(){
		
		
		Object[][] obj=new Object[3][3];
		
		obj[0][0]="reliance";
		obj[0][1]="444";
		obj[0][2]="78";
		obj[1][0]="medee";
		obj[1][1]="906";
		obj[1][2]="55";
		obj[2][0]="trends";
		obj[2][1]="234";
		obj[2][2]="11";

return obj;
		
		
	}
	
	
	@Test(dataProvider = "data")
	public void postCall(Object obj1,Object obj2,Object obj3) {
		
		
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		
		RequestSpecification request=RestAssured.given();
		
		JSONObject json=new JSONObject();
		json.put("name", obj1.toString());
		json.put("salary", obj2.toString());
		json.put("age", obj3.toString());
		
		request.header("Content-Type","application/json");   //attach the header
		
		request.body(json.toJSONString());
		Response response=request.request(Method.POST,"/create");
		System.out.println(response.getStatusCode());
		
		System.out.println(response.body().asString());
		
		Assert.assertEquals(response.getStatusCode(), 200);

	}

}
