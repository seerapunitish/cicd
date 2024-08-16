package rahulshettyacademyStepDefinition;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import RahulshettyAcademy.Testcomponenets.BaseTest;
import RahulshettyAcademy.pageobject.CartPage;
import RahulshettyAcademy.pageobject.CheckoutPage;
import RahulshettyAcademy.pageobject.ConfirmationPage;
import RahulshettyAcademy.pageobject.Landingpage;
import RahulshettyAcademy.pageobject.Productcatalogue;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition extends BaseTest {
	public Landingpage lp;
	public Productcatalogue pc;
	public CheckoutPage cpk;
	public CartPage cp;
	public String Productname;
	public ConfirmationPage cngp;

@Given("User Login on Landing Page.")
public void user_login_on_landing_page() throws IOException {
    // Write code here that turns the phrase above into concrete actions
    
	lp=GetWebsite();
}
	@Given("^User login with (.+) and (.+)$")
	public void login_with_username_and_password(String Username,String Password)
	{
		 pc=lp.LoginpageApplication(Username,Password);
	}

	@When("^I added (.+) to Cart$")
	public void when_i_added_productname_to_the_cart(String Productname) throws InterruptedException
	{
		List<WebElement> products = pc.getproductlist();
		pc.Addproducttocart(Productname);
		cp=pc.goToCartpage();
	}
	@And("^checkout (.+) and submit the Order$")
	public void checkout_productname_and_submit_the_Order(String Productname)
	{
		Boolean match =cp.verifyproductDisplay(Productname);
        Assert.assertTrue(match);
        cpk= cp.gotoCheckoutpage();
         cpk.SelectCountryName("India");
         cngp= cpk.SubmitOrder();
	}
	@Then("{string} message should be Displayed on Confirmation Page")
	public void message_should_be_Displayed_on_Confirmation_Page(String str)
	{
		 String confirmMessage=  cngp.confirmationpages();

			Assert.assertTrue(confirmMessage.equalsIgnoreCase(str));
	}
	@Then("{string} is Displayed")
	public void Error_message_is_Displayed(String str1)
	{
		Assert.assertEquals(str1,lp.ErrorMessageText());
	}

}
