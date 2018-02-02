package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Utils.Constant;

public class mercurysignon {

	private static WebElement element = null;
	
	public static WebElement textBox_UserName() {
		
		By Locator = By.name("userName");
		element = Constant.driver.findElement(Locator);
		return element;
	
	}
	
	
	public static WebElement textBox_Password() {
		
		By Locator = By.name("password");
		element = Constant.driver.findElement(Locator);
		return element;
	
	}
	
	public static WebElement button_Submit() {
		
		By Locator = By.name("login");
		element = Constant.driver.findElement(Locator);
		return element;
	
	}
}
