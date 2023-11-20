package POMRough;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

import org.apache.commons.compress.compressors.FileNameUtil;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TakeScreenShot {

	public static void main(String[] args) throws IOException {
		
		WebDriver d=new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		d.get("http://localhost:8888/index.php?action=Login&module=Users");
		d.findElement(By.name("user_name")).sendKeys("admin");
		d.findElement(By.name("user_password")).sendKeys("admin");
		d.findElement(By.id("submitButton")).click();
		d.findElement(By.xpath("//a[text()='Contacts']")).click();
		d.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		d.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();
		
		LocalDateTime dt=LocalDateTime.now();
		String timedate = dt.toString().replace(':','-');
		TakesScreenshot ts=(TakesScreenshot)d;
		
		File n = ts.getScreenshotAs(OutputType.FILE);
		File destination=new File("./pics/vtiger"+timedate+".png");
		
		FileUtils.copyFile(n, destination);
		
	}
}