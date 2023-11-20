package POMDemo;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import CommonUtil.ExcelUtils;
import CommonUtil.Fileutils;
import CommonUtil.WebDriverUtils;

public class ContactBase {

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
		
		
		//TO read data from excel file
		
		String fstname = eutils.getDatafromExcelFile("Sheet1", 3, 1);
		String lastname = eutils.getDatafromExcelFile("Sheet1", 4, 1);
		String group = eutils.getDatafromExcelFile("Sheet1", 1, 1);
		 String orgname = eutils.getDatafromExcelFile("Sheet1", 0, 1);
		
		
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
		
		
		//This type of data for all creation is in same home page
		
		
		VtigerHomePage page= new VtigerHomePage();
		PageFactory.initElements(d, page);
		page.getContactlink().click();
		page.getCreateContactbtn().click();
		
		//POM created class separate for fill Create Contact
		CreateContactPOMPage ct=new CreateContactPOMPage();
		PageFactory.initElements(d, ct);
		ct.getFirstnametf().sendKeys(fstname);
		ct.getLastnametf().sendKeys(lastname);
		ct.getAssigntoClick().click();
		
		wutils.Handledropdown(ct.getDropdownAssign(), group);
		Thread.sleep(2000);
		
		ct.getSelectORGname().click();
		Set<String> ids = d.getWindowHandles();
		//System.out.println(ids);
		
		
		for(String allids:ids)
		{
			String allURL = d.switchTo().window(allids).getCurrentUrl();
			System.out.println(allURL);
			
			//String parentURL = "http://localhost:8888/index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing";

		}
		
		ct.getSearchTextFrame().sendKeys(orgname);
		ct.getSearchButtonFrame().click();
		Thread.sleep(2000);
		ct.getFinalSelectOrgName().click();
		Thread.sleep(2000);
		//ct.getSavebtn().click();

		//To transfer contolr from child to parent
		
		for(String allids:ids)
		{
			String allURL = d.switchTo().window(allids).getCurrentUrl();
			System.out.println(allURL);
			
			String parentURL = "http://localhost:8888/index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing";

			
			if (allURL.contains(parentURL))
			{
				//d.close();
			}
			d.close();
		}
		
		CreateOrgPOMPage pg=new CreateOrgPOMPage();
		PageFactory.initElements(d, pg);
		pg.getSavebutton().click();
		
		
	//d.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		
		
		Thread.sleep(2000);
		//Created separate class for LogOutPage
		VtigerLogOutPage log=new VtigerLogOutPage();
		PageFactory.initElements(d, log);
		wutils.Movetoelementaction(d,log.getSign1());
		wutils.Clickaction(d, log.getSign2());
		
		
		
		
		
		
	}
	

}
