package com.mockaroo_tdc;

import static io.restassured.RestAssured.given;
import io.restassured.response.Response;

public class ExtractJsonMockaroo {

	public static String host = "https://my.api.mockaroo.com/data-driven?key=1c5af660";
	public String first_name;
	public String last_name;
	
	public static Response jsonMockaroo() {
		
		Response response =
				 given()
			    .when()
			    .get(host)
			    .then()
			    .statusCode(200)
			    .extract().
		         response();
		   	
		System.out.println(response.asString());
		
		return response;
	}
	
}
