package POMDemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VtigerLoginpage {

	@FindBy(name="user_name")
	private WebElement usernametf;
	
	@FindBy(name="user_password")
	private WebElement passtf;
	
	@FindBy(id="submitButton")
	private WebElement LoginButtontf;
	



	public WebElement getusernametf() {
		return usernametf;
	}

	public WebElement getPasstf() {
		return passtf;
	}
	
	public WebElement getLoginButtontf() {
		return LoginButtontf;
	}













}