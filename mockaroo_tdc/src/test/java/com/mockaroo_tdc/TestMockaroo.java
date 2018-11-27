package com.mockaroo_tdc;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class TestMockaroo {

	public WebDriver driver;
	public String baseUrl;
	
	@BeforeTest
	public void setUP() {
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		
		baseUrl = "https://www.google.com/";
	}
	
	@Test
	public void testMockaroo() throws InterruptedException {
		
		Response response = ExtractJsonMockaroo.jsonMockaroo();
		
		JsonPath pathjson = response.getBody().jsonPath();
		
		String first_name = pathjson.get("first_name");
		String last_name = pathjson.get("last_name");
		
		System.out.println(first_name);
		System.out.println(last_name);
		
		driver.get(baseUrl);
		driver.findElement(By.name("q")).sendKeys(first_name + " " +  last_name);
		
		Thread.sleep(3000);
		
	}
	
	@AfterTest
	public void tearOFF() {
	  driver.quit();
	}
}