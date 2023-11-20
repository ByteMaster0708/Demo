package TestNG1;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class CreateORG {

	@Test
	public  void Login()
	{
		WebDriver d=new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		d.get("http://localhost:8888/index.php?action=Login&module=Users");
		d.findElement(By.name("user_name")).sendKeys("admin");
		d.findElement(By.name("user_password")).sendKeys("admin");
		d.findElement(By.id("submitButton")).click();
	     
		
		
	}
	
}