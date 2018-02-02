package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Utils.Constant;

public class mercurypurchase2 {

	
	private static WebElement element = null;
	
	public static WebElement label_Message() {
		
		By Locator = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[3]/td/p/font/b/font[2]");
		element = Constant.driver.findElement(Locator);
		return element;
	
	}
	
	public static WebElement label_ConfirmationNumber() {
		
		By Locator = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[5]/td/table/tbody/tr[1]/td/table/tbody/tr/td[1]/b/font/font/b/font[1]");
		element = Constant.driver.findElement(Locator);
		return element;
	
	}

}
