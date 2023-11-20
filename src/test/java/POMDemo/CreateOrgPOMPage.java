package POMDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateOrgPOMPage {

	


	public WebElement getAssign1() {
		return Assign1;
	}


	public WebElement getAssign2() {
		return Assign2;
	}
	
	
	@FindBy(xpath="(//input[@class='detailedViewTextBox'])[1]")
	private WebElement  Orgname;


	public WebElement getEmailTF() {
		return EmailTF;
	}


	@FindBy(id="email1")
	private WebElement EmailTF;

	public WebElement getOrgname() {
		return Orgname;
	}


	@FindBy(xpath=("(//input[@name='assigntype'])[2]"))
	private WebElement Assign1;
	

	@FindBy(name=("assigned_group_id"))
	private WebElement Assign2;
	
	
@FindBy(xpath="(//input[@title='Save [Alt+S]'])[2]")
 private WebElement savebutton;

	public WebElement getSavebutton() {
	return savebutton;
}


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
