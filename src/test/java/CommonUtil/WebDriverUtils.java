package CommonUtil;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtils {
	
	public void maximize(WebDriver d)
	{
		d.manage().window().maximize();
	
	}

	public void minimize(WebDriver d)
	{
		
		d.manage().window().minimize();	
	}
	public void implicitwait(WebDriver d)
	{
	d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	public void Handledropdown(WebElement elementname,String Data)
	{
	Select s = new Select(elementname);
	s.selectByVisibleText(Data);
	}
	
	public void Selectbyvalue(WebElement elementname,String Data)
	{
	Select s = new Select(elementname);
	s.selectByValue(Data);
	}
	public void Handledropdown(WebElement elementname,int indexnumber)
	{
	Select s = new Select(elementname);
	s.selectByIndex(indexnumber);	
	}
	
	public void Clickaction(WebDriver d, WebElement elementname)
	{
     Actions a = new Actions(d);
     a.click(elementname).perform();
		
	}
	
	public void Movetoelementaction(WebDriver d, WebElement elementname)
	{
     Actions a = new Actions(d);
     a.moveToElement(elementname).perform();	
	}
	
	public void Sendkeysaction(WebDriver d, WebElement elementname)
	{
     Actions a = new Actions(d);
     a.sendKeys(elementname).perform();	
	}
	
	
	public void takescreenshot(WebDriver d) throws IOException {
		LocalDateTime dt=LocalDateTime.now();
		String timedate = dt.toString().replace(':','-');
		TakesScreenshot ts=(TakesScreenshot)d;
		File n = ts.getScreenshotAs(OutputType.FILE);
		File destination=new File("./pics/vtiger"+timedate+".png");
		FileUtils.copyFile(n, destination);
	}
	public void scrolling(WebDriver d)
	{
		JavascriptExecutor js=(JavascriptExecutor)d;
		js.executeScript("window.scrollBy(0,800)");
	}
	
	public void SwitchtoWoindowTOChild(WebDriver d,String Child)
	{

		Set<String> ids = d.getWindowHandles();
		System.out.println(ids);
		
		for(String e:ids) {
		      String c = d.switchTo().window(e).getCurrentUrl();
		      System.out.println(c);
		      
		      String ChildURL =Child;	
		      if(c.contains(ChildURL))
		      {
		    	  break;
		      }
	
		}
	}
		
		
		public void SwitchtoWoindowTOParent(WebDriver d,String parent)
		{

			Set<String> ids = d.getWindowHandles();
			System.out.println(ids);
			
			for(String e:ids) {
			      String c = d.switchTo().window(e).getCurrentUrl();
			      System.out.println(c);
			      
			  
			String parentURL =parent;
			      if(c.contains(parentURL))
			      {
			    	  break;
			      }
		}
	 }
	

}
