package POMDemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VtigerHomePage {
	
	
	
	//This is for Organization
	@FindBy(xpath="(//a[text()='Organizations'])[1]")
	private WebElement orglink;
	
	@FindBy(xpath="//img[@title='Create Organization...']")
	private	WebElement img;

	public WebElement getOrglink() {
		return orglink;
	}

	public WebElement getImage() {
		return img;
	}
	
	
	//This is for CreateContact
	
	@FindBy(xpath="(//a[text()='Contacts'])[1]")
	private WebElement Contactlink;
	
	@FindBy(xpath="//img[@alt='Create Contact...']")
	private WebElement CreateContactbtn;

	public WebElement getContactlink() {
		return Contactlink;
	}

	public WebElement getCreateContactbtn() {
		return CreateContactbtn;
	}
	
	
	//This is for CreateProduct

	@FindBy(xpath="//a[text()='Products']")
	private WebElement productlink;
	
	@FindBy(xpath="//img[@alt='Create Product...']")
	private WebElement Createproduct;

	public WebElement getProductlink() {
		return productlink;
	}

	public WebElement getCreateproduct() {
		return Createproduct;
	}

	
	//This is for CreateProduct

	@FindBy(xpath="(//a[text()='Opportunities'])[1]")
	WebElement OrgLink;
	
	@FindBy(xpath="//img[@alt='Create Opportunity...']")
	WebElement CreateOpportunity;

	public WebElement getImg() {
		return img;
	}

	public WebElement getOrgLink() {
		return OrgLink;
	}

	public WebElement getCreateOpportunity() {
		return CreateOpportunity;
	}
	
	
}
