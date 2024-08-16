package RahulshettyAcademy.Abstractclass;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import RahulshettyAcademy.pageobject.CartPage;
import RahulshettyAcademy.pageobject.OrdersPage;





public class Abstractcomponents {

	
	
	WebDriver driver;
	public Abstractcomponents(WebDriver driver)
	{
		//super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	
	@FindBy(xpath="//button[@routerlink='/dashboard/cart']")
	WebElement cartHeader;
	
	///dashboard/myorders
	@FindBy(xpath="//button[@routerlink='/dashboard/myorders']")
	WebElement OrdersHistory;
	
	public void ElemetstoAppear(By FindBy)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		wait.until(ExpectedConditions.visibilityOfElementLocated(FindBy));
		
		
	}
	public void WebElemetstoAppear(WebElement FindBy)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		wait.until(ExpectedConditions.visibilityOf(FindBy));
		
		
	}
	public void WaitForElementtoDisappear(WebElement ele) throws InterruptedException
	{
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		//wait.until(ExpectedConditions.invisibilityOf(ele));
		Thread.sleep(3000);
        

	}
	public CartPage  goToCartpage()
	{
		cartHeader.click();
		CartPage cp=new CartPage(driver);
		return cp;	
	}
	public OrdersPage OrdersHistoryPage()
	{
		OrdersHistory.click();
		OrdersPage op=new OrdersPage(driver);
		return op;
		
		
	}
	
	
		
		
	}
	

	
	
	
	
	


