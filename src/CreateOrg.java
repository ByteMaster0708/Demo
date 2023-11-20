package Assignments;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateOrg {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		WebDriver d=new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		d.get("http://localhost:8888/index.php?action=Login&module=Users");
		d.findElement(By.name("user_name")).sendKeys("admin");
		d.findElement(By.name("user_password")).sendKeys("admin");
		d.findElement(By.id("submitButton")).click();
		
		d.findElement(By.xpath("(//a[text()='Contacts'])[1]")).click();
		d.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		d.findElement(By.xpath("(//img[@align='absmiddle'])[3]")).click();
		Set<String> ids = d.getWindowHandles();
		System.out.println(ids);
		
		for(String allid:ids)
		{
			d.switchTo().window(allid).getTitle();
			
		}
		
		

		d.findElement(By.id("search_txt")).sendKeys("CaptainAmerica");
		d.findElement(By.name("search")).click();
		Thread.sleep(2000);
		d.findElement(By.xpath("//a[text()='CaptainAmerica']")).click();
		

	}

}
