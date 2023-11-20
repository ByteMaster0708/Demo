package POMDemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateProdctPOMPage {

	
	
	@FindBy(xpath="//input[@name='productname']")
	private WebElement ProductNameTF;
	
	@FindBy(xpath="(//input[@name='assigntype'])[2]")
	WebElement AssignClick;
	
	@FindBy(xpath="(//select[@class='small'])[7]")
	WebElement DropDownAssign;
	

	@FindBy(xpath="(//input[@class='crmbutton small save'])[2]")
	private WebElement ProductSavebtn;

	public WebElement getProductNameTF() {
		return ProductNameTF;
	}

	public WebElement getAssignClick() {
		return AssignClick;
	}

	public WebElement getDropDownAssign() {
		return DropDownAssign;
	}


	public WebElement getProductSavebtn() {
		return ProductSavebtn;
	}
	
	
	
	
	
}
