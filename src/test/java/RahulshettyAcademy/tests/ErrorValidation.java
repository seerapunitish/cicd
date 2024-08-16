package RahulshettyAcademy.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import RahulshettyAcademy.Testcomponenets.BaseTest;
import RahulshettyAcademy.pageobject.CartPage;
import RahulshettyAcademy.pageobject.CheckoutPage;
import RahulshettyAcademy.pageobject.ConfirmationPage;
import RahulshettyAcademy.pageobject.Landingpage;
import RahulshettyAcademy.pageobject.Productcatalogue;

public class ErrorValidation extends BaseTest{
	
	
	//
	
	@Test                              
	public void ErrorLoginTestcase() throws IOException, InterruptedException
	{
		
		//String productName = "ZARA COAT 3";
		
	
       
		lp.LoginpageApplication("Nitishreddyseerapu@gmail.com", "Npr061");
		Assert.assertEquals("Incorrect email or password.",lp.ErrorMessageText());

	
	}
	@Test
	public void ErrorValidationTestcase() throws IOException, InterruptedException
	{
		
		String productName = "ZARA COAT 3";
		
	
       
		Productcatalogue pc = 	lp.LoginpageApplication("Nitishreddyseerapu@gmail.com", "Npr@0611");
		List<WebElement> products = pc.getproductlist();
		pc.Addproducttocart(productName);
		CartPage cp=pc.goToCartpage();
		Boolean match =cp.verifyproductDisplay("Zara coat 33");
        Assert.assertFalse(match);
        CheckoutPage cpk= cp.gotoCheckoutpage();
         cpk.SelectCountryName("India");
         ConfirmationPage cngp= cpk.SubmitOrder();
        String confirmMessage=  cngp.confirmationpages();

		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		

	}

	
}
