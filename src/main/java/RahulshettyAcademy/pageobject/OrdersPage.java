package RahulshettyAcademy.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import RahulshettyAcademy.Abstractclass.Abstractcomponents;

public class OrdersPage extends Abstractcomponents {
WebDriver driver;
	
	public OrdersPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		
		// TODO Auto-generated constructor stub
	}
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> Productnames;
	
	@FindBy(css=".totalRow button")
	WebElement CheckoutEle;
	
	public Boolean OrderHistoryproductname(String ProductName)
	{
		List<WebElement> Orderproductname=Productnames;
	Boolean match=	Orderproductname.stream().anyMatch(product->product.getText().equalsIgnoreCase(ProductName));
		return match;
	}

	//OrdersPage op=OrdersHistoryPage();
	public WebElement Checkoutpage()
	{
		CheckoutEle.click();
		return CheckoutEle;
		
	}
	
	
}
