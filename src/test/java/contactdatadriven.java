


import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class contactdatadriven {

	public static void main(String[] args) throws IOException {
		
		final WebDriver d;
		FileInputStream file=new FileInputStream("src\\test\\resources\\contact.properties");
		Properties p=new Properties();
		p.load(file);
		String browser=p.getProperty("Browser");
		String url=p.getProperty("URL");
		String user=p.getProperty("UserName");
		String pass=p.getProperty("Password");
		String last=p.getProperty("LastName");
		if(browser.equals("Chrome")) {
			d=new ChromeDriver();
		}else if(browser.equals("Edge")) {
			d=new EdgeDriver();
		}else {
			d=new FirefoxDriver();
		}
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		d.get(url);
		d.findElement(By.name("user_name")).sendKeys(user);
		d.findElement(By.name("user_password")).sendKeys(pass);
		d.findElement(By.id("submitButton")).click();
		
		FileInputStream excel=new FileInputStream("src\\test\\resources\\Contact.xlsx");
		Workbook wb=WorkbookFactory.create(excel);
		Sheet r = wb.getSheet("Sheet1");
		Row row1 = r.getRow(3);
		Cell cell1 = row1.getCell(0);
		String data1 = cell1.getStringCellValue();
		System.out.println(data1);
		
		
		Row row2 = r.getRow(3);
		Cell cell2 = row2.getCell(1);
		String data2 = cell2.getStringCellValue();
		System.out.println(data2);
		
		d.findElement(By.xpath("//a[text()='Contacts']")).click();
		d.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		d.findElement(By.name("lastname")).sendKeys(last);
		WebElement dropdown = d.findElement(By.name("leadsource"));
		Select s=new Select(dropdown);
		s.selectByVisibleText("Self Generated");
		d.findElement(By.id("jscal_trigger_birthday")).click();
		d.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
		WebElement drop = d.findElement(By.name("assigned_group_id"));
		Select s1=new Select(drop);
		s1.selectByVisibleText("Support Group");
		d.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		WebElement signout = d.findElement(By.xpath("(//td[@class='small'])[2]"));
		Actions a=new Actions(d);
		a.moveToElement(signout).perform();
		d.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}
}
