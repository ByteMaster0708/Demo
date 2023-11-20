package POMDemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VtigerLogOutPage {

	

	@FindBy(xpath="(//td[@valign='bottom'])[2]")
	private WebElement Sign1;
	

	@FindBy(xpath=("//a[text()='Sign Out']"))
	private WebElement Sign2;


	public WebElement getSign1() {
		return Sign1;
	}


	public WebElement getSign2() {
		return Sign2;
	}
}
