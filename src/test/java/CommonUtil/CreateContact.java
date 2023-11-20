package CommonUtil;


import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateContact {

	public static void main(String[] args) throws IOException {
		
		final WebDriver d;
		Fileutils futils=new Fileutils();
		WebDriverUtils wutils =new WebDriverUtils();
		ExcelUtils eutils=new ExcelUtils();
		

		//To read data from properties file
		
		String browser = futils.getdatafrompropertyfiles("browser");
		String url= futils.getdatafrompropertyfiles("url");
		String user= futils.getdatafrompropertyfiles("username");
		String pass= futils.getdatafrompropertyfiles("passward");
		
		
		
		
		//To read data from excel file
		String firstname = eutils.getDatafromExcelFile("Sheet1",3,1);
		String lastname = eutils.getDatafromExcelFile("Sheet1",4,1);
		String  Group = eutils.getDatafromExcelFile("Sheet1", 1,2);		
			
		
		if(browser.equals("Chrome")) {
			d=new ChromeDriver();
		}else if(browser.equals("Edge")) {
			d=new EdgeDriver();
		}else {
			d=new FirefoxDriver();
		}
		
		wutils.maximize(d);
		wutils.implicitwait(d);
		d.get(url);
		
		d.findElement(By.name("user_name")).sendKeys(user);
		d.findElement(By.name("user_password")).sendKeys(pass);
		d.findElement(By.id("submitButton")).click();
		
		
		
		d.findElement(By.xpath("(//a[text()='Contacts'])[1]")).click();
		d.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		d.findElement(By.name("firstname")).sendKeys(firstname);
		d.findElement(By.name("lastname")).sendKeys(lastname);
		
		//d.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
		d.findElement(By.xpath("(//input[@onclick='toggleAssignType(this.value)'])[2]")).click();

		WebElement dropdown = d.findElement(By.name("assigned_group_id"));
		wutils.Handledropdown(dropdown,Group);

		d.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		WebElement signout = d.findElement(By.xpath("(//td[@class='small'])[2]"));
		wutils.Movetoelementaction(d, signout);
		d.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}
}
