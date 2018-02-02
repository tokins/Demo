package Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class testSample {

	public static WebDriver driver = null;
	
	@Parameters("browser")
	@Test
	public void testLogin(String browser) throws MalformedURLException {
		
		System.out.println(browser);
		DesiredCapabilities cap=null;
		cap = DesiredCapabilities.chrome();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.ANY);
		
		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
		driver.get("http://newtours.demoaut.com/index.php");
		driver.manage().timeouts().implicitlyWait(20L,TimeUnit.SECONDS);	
		
		driver.quit();
		
		
	}
	
	
}
