package RahulshettyAcademy.pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RahulshettyAcademy.Abstractclass.Abstractcomponents;

public class CartPage extends Abstractcomponents{
	//List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
	@FindBy(css=".cartSection h3")
	List<WebElement>cartitems;
	
	@FindBy(css=".totalRow button")
	WebElement checkout;
	
	WebDriver driver;
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	
	
	
	public Boolean verifyproductDisplay(String productName)
	{

		List<WebElement> cartProducts = cartitems;

		Boolean match = cartProducts.stream()
				.anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
		return match;
	}
	public CheckoutPage gotoCheckoutpage()
	{
		checkout.click();
		CheckoutPage cpk=new CheckoutPage(driver);
		return cpk;
	}
}
