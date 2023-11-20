package POMDemo;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import CommonUtil.ExcelUtils;
import CommonUtil.Fileutils;
import CommonUtil.WebDriverUtils;

public class ProductBase {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		

		final WebDriver d;
		
		Fileutils futils=new Fileutils();
		WebDriverUtils wutils =new WebDriverUtils();
		ExcelUtils eutils=new ExcelUtils();
		
		String browser = futils.getdatafrompropertyfiles("browser");
		String url= futils.getdatafrompropertyfiles("url");
		String user= futils.getdatafrompropertyfiles("username");
		String pass= futils.getdatafrompropertyfiles("passward");
		
		
		
		
		
		String productname= eutils.getDatafromExcelFile("Sheet1",7,1);
	   String Group = eutils.getDatafromExcelFile("Sheet1", 8, 1);
		
		
		
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
		
		VtigerHomePage hm=new VtigerHomePage();
		PageFactory.initElements(d, hm);		
		hm.getProductlink().click();
		hm.getCreateproduct().click();
		
		
		CreateProdctPOMPage prd=new CreateProdctPOMPage();
		PageFactory.initElements(d, prd);
		prd.getProductNameTF().sendKeys(productname);
		prd.getAssignClick().click();
		//prd.getDropDownAssign().click();
		Thread.sleep(2000);		
	    wutils.Handledropdown(prd.getDropDownAssign(), Group);
	     
		
		Thread.sleep(2000);		
		prd.getProductSavebtn().click();
		
		//Created separate class for LogOutPage
		VtigerLogOutPage log=new VtigerLogOutPage();
		PageFactory.initElements(d, log);
		wutils.Movetoelementaction(d,log.getSign1());
		wutils.Clickaction(d, log.getSign2());
		
		
	        

	}
	

}
