package RahulshettyAcademy.pageobject;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RahulshettyAcademy.Abstractclass.Abstractcomponents;


public class Productcatalogue extends Abstractcomponents{
	WebDriver driver;
	
	public Productcatalogue(WebDriver driver)
	{
	super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);	
	}
	


@FindBy(xpath="//div[contains(@class, 'mb-3')]")
List<WebElement> products;

@FindBy(css=".ng-animating")
WebElement spinner;

By ProductsBy=By.cssSelector(".mb-3 .card");
By Productname=By.xpath("//div/h5/b");
By CartAdded=By.cssSelector(".btn.w-10.rounded");
By toastmessage=By.cssSelector("#toast-container");


public List<WebElement> getproductlist()

{
	ElemetstoAppear(ProductsBy);
	return products;
}


public WebElement getproductByName(String productName)
{
	WebElement prod = getproductlist().stream()
	.filter(product -> product.findElement(Productname).getText().equals(productName))
	.findFirst().orElse(null);
	return prod;
}
public void  Addproducttocart(String productName) throws InterruptedException
{
	WebElement prod=getproductByName(productName);
	prod.findElement(CartAdded).click();
	ElemetstoAppear(toastmessage);
	WaitForElementtoDisappear(spinner);
	
	
}



}
