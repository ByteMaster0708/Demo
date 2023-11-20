package POMDemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateOpportPOM {

	
	@FindBy(name="potentialname")
	WebElement OppoNameTF;
	
	@FindBy(id="related_to_type")
	WebElement RelatedDropDown;
	

	@FindBy(xpath="(//img[@align=\"absmiddle\"])[3]")
	WebElement SelectPlusBTN;
	

	@FindBy(id="(//a[text()='Audumbar Daingade'])[1]")
	WebElement SelectContact;
}
