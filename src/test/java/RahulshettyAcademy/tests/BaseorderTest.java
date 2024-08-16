package RahulshettyAcademy.tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import RahulshettyAcademy.Testcomponenets.BaseTest;
import RahulshettyAcademy.pageobject.CartPage;
import RahulshettyAcademy.pageobject.CheckoutPage;
import RahulshettyAcademy.pageobject.ConfirmationPage;
import RahulshettyAcademy.pageobject.Landingpage;
import RahulshettyAcademy.pageobject.OrdersPage;
import RahulshettyAcademy.pageobject.Productcatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseorderTest extends BaseTest {
	String productName = "ZARA COAT 3";

	@Test(dataProvider="getDataprovider",groups={"purchase"})
	public void Testcase(HashMap<String,String> input) throws IOException, InterruptedException
	{
		Productcatalogue pc = 	lp.LoginpageApplication(input.get("email"),input.get("password"));
		List<WebElement> products = pc.getproductlist();
		pc.Addproducttocart(input.get("productName"));
		CartPage cp=pc.goToCartpage();
		Boolean match =cp.verifyproductDisplay(input.get("productName"));
        Assert.assertTrue(match);
        CheckoutPage cpk= cp.gotoCheckoutpage();
         cpk.SelectCountryName("India");
         ConfirmationPage cngp= cpk.SubmitOrder();
        String confirmMessage=  cngp.confirmationpages();

		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		

	}
	//
	@Test(dependsOnMethods= {"Testcase"})
	public void OrderHistoryTest()
	{

		Productcatalogue pc = 	lp.LoginpageApplication("Nitishreddyseerapu@gmail.com","Npr@0611");
		OrdersPage op=pc.OrdersHistoryPage();
		Assert.assertTrue(op.OrderHistoryproductname(productName));
	
	}

	@DataProvider
	public Object[][] getDataprovider() throws IOException
	{
		
		
		List<HashMap<String,String>> data=getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\RahulshettyAcademy\\JsonData\\Dataread.json");
		return new Object[][]  {{data.get(0)},{data.get(1)}};
		
//		HashMap<String,String> map=new HashMap<String,String>();
//		map.put("email","Nitishreddyseerapu@gmail.com");
//		map.put("password","Npr@0611");
//		map.put("productName","ZARA COAT 3");
//		HashMap<String,String> map1=new HashMap<String,String>();
//		map1.put("email","shetty@gmail.com");
//		map1.put("password","Iamking@000");
//		map1.put("productName","ZARA COAT 3");

//		
//		return new Object[][]  {{map},{map1}};
//		//return new Object[][] {{"Nitishreddyseerapu@gmail.com","Npr@0611","ZARA COAT 3"},{"shetty@gmail.com","Iamking@000","ADIDAS ORIGINAL"}};
	}

	

}
