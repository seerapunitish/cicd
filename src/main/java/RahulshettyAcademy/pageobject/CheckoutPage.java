package RahulshettyAcademy.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import RahulshettyAcademy.Abstractclass.Abstractcomponents;

public class CheckoutPage extends Abstractcomponents {
WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
//	a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
@FindBy(css="[placeholder='Select Country']")
WebElement SelectCountry;


//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
By wait=By.cssSelector(".ta-results");

@FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
WebElement SelectSecificCountry;


@FindBy(css=".action__submit")
WebElement ActionSubmit;
		


public void SelectCountryName(String Countryname)
{
	Actions a=new Actions(driver);
	a.sendKeys(SelectCountry, Countryname).build().perform();
	ElemetstoAppear(wait);
	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));

	SelectSecificCountry.click();
}
public ConfirmationPage SubmitOrder()
{
	ActionSubmit.click();
	ConfirmationPage cngp=new ConfirmationPage(driver);
	return cngp;
}


}
