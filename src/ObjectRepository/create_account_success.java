package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Utils.Constant;

public class create_account_success {

	private static WebElement element = null;
	
	public static WebElement label_Success() {
		
		By Locator = By.xpath("/html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[3]/a/font/b");
		element = Constant.driver.findElement(Locator);
		return element;
	
	}
	
	public static WebElement link_SignIn() {
		
		By Locator = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[2]/font/a[1]");
		element = Constant.driver.findElement(Locator);
		return element;
	
	}
	
	
	
	
	
}
