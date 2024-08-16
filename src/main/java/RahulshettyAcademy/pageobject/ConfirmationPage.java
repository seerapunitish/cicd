package RahulshettyAcademy.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import RahulshettyAcademy.Abstractclass.Abstractcomponents;

public class ConfirmationPage extends Abstractcomponents {
WebDriver driver;
@FindBy(css=".hero-primary")
WebElement Confirmation;

	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		
		// TODO Auto-generated constructor stub
		
		
		//String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();

	//	Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}
	
	public String confirmationpages()
	{
		return Confirmation.getText();
		 
	}
	
	
}


