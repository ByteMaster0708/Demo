package TestNG1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TRY2 {

	
	
	
	
//IsEnabled gives output as Passed
	
	@Test
//	public void VtigerCRM()
//	{
//		WebDriver d=new ChromeDriver();
//		d.get("http://localhost:8888/");
//		WebElement loginbtn = d.findElement(By.id("submitButton"));
//		Assert.assertTrue(loginbtn.isEnabled());
//		System.out.println("Hello");
//		
//	}
	
	//isselected Methods gives output as Failed
	
	public void VtigerCRM()
	{
		WebDriver d=new ChromeDriver();
		d.get("http://localhost:8888/");
		
		WebElement loginbtn = d.findElement(By.id("submitButton"));
	    //Assert.assertTrue(loginbtn.isEnabled());
	   //Assert.assertTrue(loginbtn.isEnabled());
		
		Assert.assertFalse(loginbtn.isEnabled());
		Assert.assertFalse(loginbtn.isEnabled());
		System.out.println("Hello");
		
		
	}
}

