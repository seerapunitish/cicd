package SeleniumGrid;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Nodes {

	
	@Test
	public void node1() throws MalformedURLException, URISyntaxException
	{
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setBrowserName("chrome");
		WebDriver driver=new RemoteWebDriver(new URI("http://192.168.22.126:4444").toURL(),dc);
		driver.get("https://www.jenkins.io/doc/book/platform-information/support-policy-java/");
		
	}
	
	
}
