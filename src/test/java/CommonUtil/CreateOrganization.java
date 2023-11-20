package CommonUtil;
import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateOrganization {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
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
		String orgname = eutils.getDatafromExcelFile("Sheet1",0,1);
		String Group = eutils.getDatafromExcelFile("Sheet1",1,1);
		String Industry= eutils.getDatafromExcelFile("Sheet1", 2, 1);

		
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
		
		d.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		d.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		d.findElement(By.name("accountname")).sendKeys(orgname);
		
		 
		  WebElement box = d.findElement(By.name("notify_owner"));
		  wutils.Clickaction(d, box);
//	    
  
//	   

		d.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
		Thread.sleep(2000);
		
	    WebElement Dropdown = d.findElement(By.name("assigned_group_id"));
		  //  wutils.Handledropdown(Dropdown, 1);
		    wutils.Handledropdown(Dropdown,Group );
		    
		    
		    WebElement industries = d.findElement(By.name("industry"));
		    wutils.Handledropdown(industries, Industry);
		        
 	
		d.switchTo().alert().accept();
		Thread.sleep(2000);
		WebElement c = d.findElement(By.xpath("(//td[@class='small'])[2]"));
	     wutils.Movetoelementaction(d, c);
	
	     
		Thread.sleep(2000);
    	d.findElement(By.xpath("//a[text()='Sign Out']")).click();
    	
	}

}
