package TestNG1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class try3 {
	@Test
	public void Login()
	{
		System.out.println("LoginPage");
		Assert.assertEquals("Pune", "Deccan");
	
	}
	@Test(dependsOnMethods="Login")
	public void Home()
	{
		
		System.out.println("HomePage");
	}
	
	@Test(dependsOnMethods="Login")
	public void Logout()
	{
		
	System.out.println("Logout");
	}
	
}
