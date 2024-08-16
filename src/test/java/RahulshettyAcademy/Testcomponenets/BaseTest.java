package RahulshettyAcademy.Testcomponenets;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import RahulshettyAcademy.pageobject.Landingpage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest { 
	public WebDriver driver;
	public Landingpage lp;
	
	
	public WebDriver InitializeDriver() throws IOException
	{
		
		//Properties Class-Create a package in Main,Create one package in the main create one file with properties Extension then using properties class in java you are able to parse the file and extract the all global parameters value
		Properties prop=new Properties();
		
		//System.getProperty("user.dir")
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\RahulshettyAcademy\\resources\\GlobalData.properties");
		prop.load(fis);
		String Browsername=System.getProperty("browser")!=null ? System.getProperty("browser") :prop.getProperty("browser");
		//String Browsername=prop.getProperty("browser");
		if(Browsername.contains("chrome"))
		{
			ChromeOptions option=new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			if(Browsername.contains("headless"))
			{
			option.addArguments("headless");
			}
			 driver = new ChromeDriver(option);
			 driver.manage().window().setSize(new Dimension(1440,900));//Fit to FullScreen
		}
		else
			if(Browsername.equalsIgnoreCase("Edge"))
		{
			System.setProperty("webdriver.edge.driver","C:\\Users\\SNITISH\\Downloads\\edgedriver_win64\\msedgedriver.exe");
			 driver=new EdgeDriver();
		}
		
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
		
	}
	
	@BeforeMethod(alwaysRun=true)
	public Landingpage GetWebsite() throws IOException
	{
	
		 driver=InitializeDriver();
	lp = new Landingpage(driver);
		lp.goTo();
		return lp;
			
	}
	 public List<HashMap<String, String>> getJsonDataToMap(String filepath) throws IOException
	 {
		 //	Read json to String
		String jsonContent= FileUtils.readFileToString(new File(filepath),StandardCharsets.UTF_8);
		 //Convert String to HashMap we have to import Jackson Databind to pom
		 ObjectMapper mapper=new ObjectMapper();
		
		 List<HashMap<String,String>> data =mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){});
		 return data;
	 }
	@AfterMethod(alwaysRun=true)
	public void Teardown()
	{
	driver.quit();	
	}
	
	
	public String getScreenshot(String TestcaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File file=new File(System.getProperty("user.dir")+"//reports//"+TestcaseName+".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir")+"//reports//"+TestcaseName+".png";
	
		
	}
}
