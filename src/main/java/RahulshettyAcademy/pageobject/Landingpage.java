package RahulshettyAcademy.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RahulshettyAcademy.Abstractclass.Abstractcomponents;

public class Landingpage extends Abstractcomponents{
	
	WebDriver driver;
	
	public Landingpage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
		
	}
	
	@FindBy(id="userEmail")
	WebElement Emailid;
	
	
	@FindBy(id="userPassword")
	WebElement PasswordElement;
	
	@FindBy(id="login")
	WebElement Submit;
	@FindBy(css="[class*='flyInOut']")
	WebElement ErrorMessage;
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	public String ErrorMessageText()
	{
		WebElemetstoAppear(ErrorMessage);
		return ErrorMessage.getText();
		
	}
	
	public Productcatalogue LoginpageApplication(String user,String pass)
	{
		Emailid.sendKeys(user);
		PasswordElement.sendKeys(pass);
		Submit.click();
		Productcatalogue pc = new Productcatalogue(driver);
		return pc;
	}
	
	
	

}
