package POMRough;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import CommonUtil.ExcelUtils;
import CommonUtil.Fileutils;
import CommonUtil.WebDriverUtils;
import POMDemo.CreateContactPOMPage;
import POMDemo.CreateOrgPOMPage;
import POMDemo.VtigerHomePage;
import POMDemo.VtigerLogOutPage;
import POMDemo.VtigerLoginpage;



public class CreateContactAllOpertation {

	public static void main(String[] args) throws IOException, InterruptedException {
		

		final WebDriver d;
		
		
		Fileutils futils=new Fileutils();
		WebDriverUtils wutils =new WebDriverUtils();
		ExcelUtils eutils=new ExcelUtils();
		
		
		String browser = futils.getdatafrompropertyfiles("browser");
		String url= futils.getdatafrompropertyfiles("url");
		String user= futils.getdatafrompropertyfiles("username");
		String pass= futils.getdatafrompropertyfiles("passward");
		
		
		
		
		if (browser.equalsIgnoreCase("Chrome")) {
			d=new ChromeDriver();
		} else if(browser.equalsIgnoreCase("Edge")) {

			d=new EdgeDriver();
		}
		else
		{
			d=new FirefoxDriver();
		}
		
		
		d.get(url);
		wutils.maximize(d);
		wutils.implicitwait(d);
		
		//Created separate class for Login Page
		VtigerLoginpage  login=new VtigerLoginpage();
		PageFactory.initElements(d, login);
		login.getusernametf().sendKeys(user);;
		login.getPasstf().sendKeys(pass);
		login.getLoginButtontf().click();
		
		
		

		//TO read data from excel file
		String fstname = eutils.getDatafromExcelFile("Sheet1", 3, 1);
		String lastname = eutils.getDatafromExcelFile("Sheet1", 4, 1);
		String group = eutils.getDatafromExcelFile("Sheet1", 1, 1);
		 String orgname = eutils.getDatafromExcelFile("Sheet1", 0, 1);
			
		 String ParentURL = eutils.getDatafromExcelFile("Sheet1", 9, 1);
		 String ChildURL = eutils.getDatafromExcelFile("Sheet1", 10, 1);
		
	
		
		VtigerHomePage page= new VtigerHomePage();
		PageFactory.initElements(d, page);
		page.getContactlink().click();
		page.getCreateContactbtn().click();
		
		//POM created class separate for fill Create Contact
		CreateContactPOMPage ct=new CreateContactPOMPage();
		PageFactory.initElements(d, ct);
		ct.getFirstnametf().sendKeys(fstname);
		ct.getLastnametf().sendKeys(lastname);
		
		
		d.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();


		//to transfer the control from child to parent
		wutils.SwitchtoWoindowTOChild(d, ChildURL);
	  ct.getSearchTextFrame().sendKeys(orgname);
		ct.getSearchButtonFrame().click();
		Thread.sleep(2000);
		ct.getFinalSelectOrgName().click();
		Thread.sleep(2000);
		
	
	//to transfer the control from parent to child
     wutils.SwitchtoWoindowTOParent(d, ParentURL);
		
		ct.getAssigntoClick().click();
		wutils.Handledropdown(ct.getDropdownAssign(), group);
		Thread.sleep(2000);
		
  		LocalDateTime dt=LocalDateTime.now();
		String timedate = dt.toString().replace(':','-');
		TakesScreenshot ts=(TakesScreenshot)d;
		File n = ts.getScreenshotAs(OutputType.FILE);
		File destination=new File("./pics/vtiger"+timedate+".png");
		FileUtils.copyFile(n, destination);
		
		
		
	        Thread.sleep(2000);
		     wutils.scrolling(d);
		     
          ////File uploading 
		     
		         Thread.sleep(2000);
				wutils.scrolling(d);
				Thread.sleep(3000);
			     WebElement org = d.findElement(By.xpath("//input[@name='imagename']"));
			     wutils.Movetoelementaction(d, org);
			     wutils.Clickaction(d, org);
			     Runtime.getRuntime().exec("C:\\Users\\PC.DESKTOP-Q8L0TS6\\Desktop\\PomAuto.exe");
		     
	
			     CreateOrgPOMPage pg=new CreateOrgPOMPage();
			PageFactory.initElements(d, pg);
			pg.getSavebutton().click();
			
			
			Thread.sleep(2000);
			//Created separate class for LogOutPage
			VtigerLogOutPage log=new VtigerLogOutPage();
			PageFactory.initElements(d, log);
			wutils.Movetoelementaction(d,log.getSign1());
			wutils.Clickaction(d, log.getSign2());	
	}
}