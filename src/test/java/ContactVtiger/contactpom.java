package ContactVtiger;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class contactpom {

	@FindBy(name="user_name")
	private WebElement nametf;
	
	@FindBy(name="user_password")
	private WebElement passtf;
	
	@FindBy(id="submitButton")
	private WebElement logintf;
	
	@FindBy(name="firstname")
	private WebElement firstNametf ;

	@FindBy(name="lastname")
	private WebElement lastNametf;
	

	public WebElement getNametf() {
		return nametf;
	}

	public WebElement getPasstf() {
		return passtf;
	}

	public WebElement getLogintf() {
		return logintf;
	}

	public WebElement getFirstNametf() {
		return firstNametf;
	}

	public WebElement getLastNametf() {
		return lastNametf;
	}

	

	
	public void Login(String name,String pass,String login,String first, String last,String phone,String mobile,String title,String department,String email) {
		nametf.sendKeys(name);
		passtf.sendKeys(pass);
		logintf.sendKeys(login);
		firstNametf.sendKeys(first);
		lastNametf.sendKeys(last);
		
	}
	
	
}