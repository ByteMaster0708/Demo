package POMRough;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import CommonUtil.ExcelUtils;
import CommonUtil.Fileutils;
import CommonUtil.JavaUtils;
import CommonUtil.WebDriverUtils;
import POMDemo.CreateOrgPOMPage;
import POMDemo.VtigerHomePage;
import POMDemo.VtigerLogOutPage;
import POMDemo.VtigerLoginpage;


public class CreateOrgAllProperties {
	
	@Test

	public  void VtigerAll() throws IOException, InterruptedException{
		
		final WebDriver d;
		
		Fileutils futils=new Fileutils();
		WebDriverUtils wutils =new WebDriverUtils();
		ExcelUtils eutils=new ExcelUtils();
		JavaUtils jutils = new JavaUtils();
		
		
		String browser = futils.getdatafrompropertyfiles("browser");
		String url= futils.getdatafrompropertyfiles("url");
		String user= futils.getdatafrompropertyfiles("username");
		String pass= futils.getdatafrompropertyfiles("passward");
		//String Assigned = futils.getdatafrompropertyfiles("Assignedto");
		//String gmail = futils.getdatafrompropertyfiles("gmail");
		//futils.getdatafrompropertyfiles(pass)
		
		if(browser.equals("Chrome")) {
			d=new ChromeDriver();
		}else if(browser.equals("Firefox")) {
			d=new FirefoxDriver();
		}else {
			d=new EdgeDriver();
		}
		
         d.get(url);
		wutils.maximize(d);
		wutils.implicitwait(d);
		
		
		
		//To read data from excel file
		
                String orgname = eutils.getDatafromExcelFile("Sheet1", 0, 1);
                String Email = eutils.getDatafromExcelFile("Sheet1", 6, 1);
 
				String Group = eutils.getDatafromExcelFile("Sheet1",1,1);
//				String Industry= eutils.getDatafromExcelFile("Sheet1", 2, 1);
				
				
				
		VtigerLoginpage vt=new VtigerLoginpage();
		
		PageFactory.initElements(d, vt);
		vt.getusernametf().sendKeys(user);
	    vt.getPasstf().sendKeys(pass);
		vt.getLoginButtontf().click();
		
		VtigerHomePage vhome=new VtigerHomePage();
		PageFactory.initElements(d, vhome);
		vhome.getOrglink().click();;
		vhome.getImage().click();
		
		
		Thread.sleep(2000);
		
		
		CreateOrgPOMPage cop=new CreateOrgPOMPage();
		PageFactory.initElements(d, cop);
	    cop.getOrgname().sendKeys(orgname+jutils.getRandomNUmber());
		cop.getEmailTF().sendKeys(Email);
		cop.getAssign1().click();
		wutils.Handledropdown(cop.getAssign2(),Group);
		Thread.sleep(2000);
		cop.getSavebutton().click();
		Thread.sleep(3000);
		
		
		VtigerLogOutPage log= new VtigerLogOutPage();
		
       wutils.Movetoelementaction(d,log.getSign1());
		wutils.Clickaction(d,log.getSign2());
		
	}
}