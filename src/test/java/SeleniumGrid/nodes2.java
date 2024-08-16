package SeleniumGrid;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import com.github.dockerjava.api.model.Capability;

public class nodes2 {
	
	@Test
	public void edgedriver() throws MalformedURLException, URISyntaxException
	{
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"MicrosoftEdge");
		//dc.setBrowserName("MicrosoftEdge");
		WebDriver driver=new RemoteWebDriver(new URI("http://192.168.22.126:4444").toURL(),dc);
		driver.get("https://www.jenkins.io/doc/book/platform-information/support-policy-java/");
	}

}
