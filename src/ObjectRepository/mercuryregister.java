package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Utils.Constant;

public class mercuryregister {

	private static WebElement element = null;
	
	public static WebElement textBox_UserName() {
		
		By Locator = By.id("email");
		element = Constant.driver.findElement(Locator);
		return element;
	
	}
	
	
	public static WebElement textBox_ConfirmPassword() {
		
		By Locator = By.name("confirmPassword");
		element = Constant.driver.findElement(Locator);
		return element;
	
	}
	
	
	public static WebElement textBox_Password() {
		
		By Locator = By.name("password");
		element = Constant.driver.findElement(Locator);
		return element;
	
	}
	
	public static WebElement button_Submit() {
		
		By Locator = By.name("register");
		element = Constant.driver.findElement(Locator);
		return element;
	
	}
}
