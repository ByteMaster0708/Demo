package TestNG1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Try1 {
	@Test(priority=1,invocationCount=2)

	public void facebook()
	{
		
	WebDriver d=new ChromeDriver();
	d.get("https://www.facebook.com/");
	}
	
	@Test(priority=3)
	public void Zomato()
	{
		
	WebDriver d=new ChromeDriver();
	d.get("https://www.zomato.com/");
	}
	
	@Test(priority=2)
	public void Swiggy()
	{
	WebDriver d=new ChromeDriver();
	d.get("https://www.swiggy.com/");
	}

}
