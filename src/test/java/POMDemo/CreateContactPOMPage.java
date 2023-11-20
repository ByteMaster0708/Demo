package POMDemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateContactPOMPage {

	@FindBy(name="firstname")
	private WebElement  firstnametf;
	
	@FindBy(name="lastname")
	private WebElement  lastnametf;
	
	@FindBy(xpath="(//input[@name='assigntype'])[2]")
	WebElement assigntoClick;
	
	@FindBy(name="assigned_group_id")
	WebElement dropdownAssign;

	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement savebtn;
	

	public WebElement getSelectORGname() {
		return SelectORGname;
	}


	public WebElement getSearchTextFrame() {
		return SearchTextFrame;
	}


	public WebElement getSearchButtonFrame() {
		return SearchButtonFrame;
	}


	public WebElement getFinalSelectOrgName() {
		return FinalSelectOrgName;
	}

	@FindBy(xpath="(//img[@align='absmiddle'])[3]")
	private WebElement SelectORGname;
	

	@FindBy(id="search_txt")
	private WebElement SearchTextFrame;
	
	@FindBy(name="search")
	private WebElement SearchButtonFrame;
	
	@FindBy(xpath="//a[text()='CaptainAmerica']")
	private WebElement FinalSelectOrgName;
	
	
	
	public WebElement getSavebtn() {
		return savebtn;
	}

	
	public WebElement getAssigntoClick() {
		return assigntoClick;
	}

	public WebElement getDropdownAssign() {
		return dropdownAssign;
	}

	public WebElement getFirstnametf() {
		return firstnametf;
	}

	public WebElement getLastnametf() {
		return lastnametf;
	}


	
	
}
