package GetCallVerifyicationJson2;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class GetCallVerifcation {
	
	
	@Test
	public void testData() {
		
		String h="{\"menu\": {  \r\n" + 
				"  \"id\": \"file\",  \r\n" + 
				"  \"value\": \"File\",  \r\n" + 
				"  \"popup\": {  \r\n" + 
				"    \"menuitem\": [  \r\n" + 
				"      {\"value\": \"New\", \"onclick\": \"CreateDoc()\"},  \r\n" + 
				"      {\"value\": \"Open\", \"onclick\": \"OpenDoc()\"},  \r\n" + 
				"      {\"value\": \"Save\", \"onclick\": \"SaveDoc()\"}  \r\n" + 
				"    ]  \r\n" + 
				"  }  \r\n" + 
				"}}";
		
		
		JsonPath path=new JsonPath(h);
		String name=path.get("menu.id").toString();
		System.out.println(name);
		
	List<Object> obj	=path.getList("menu.popup.menuitem.value");
	System.out.println(obj.size());
	for (int i = 0; i < obj.size(); i++) {
		
		System.out.println(obj.get(i));
		
	}		
		String m=path.get("menu.popup.menuitem.value").toString();
		System.out.println(m);	
	}
	
		 
	}


