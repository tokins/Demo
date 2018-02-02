package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Utils.Constant;

public class mercurywelcome {
	
	private static WebElement element = null;
	
	public static WebElement link_Flight() {
		
		By Locator = By.linkText("Flights");
		element = Constant.driver.findElement(Locator);
		return element;
		
	}
	
	public static WebElement link_Home() {
		
		By Locator = By.xpath("/html/body/div[1]/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[1]/td[2]/font/a");
		element = Constant.driver.findElement(Locator);
		return element;
	
	}
	
	public static WebElement link_Register() {
		
		By Locator = By.xpath("/html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[2]/a");
		element = Constant.driver.findElement(Locator);
		return element;
	
	}
	
	public static WebElement link_SignOff() {
		
		By Locator = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[1]/a");
		element = Constant.driver.findElement(Locator);
		return element;
	
	}	
	
}
