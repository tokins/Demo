package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Utils.Constant;

public class mercurypurchase {
	
	private static WebElement element = null;
	
	public static WebElement label_TotalPrice() {
		
		By Locator = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td/table/tbody/tr[9]/td[2]/font/b");
		element = Constant.driver.findElement(Locator);
		return element;
	
	}	

	public static WebElement button_SecurePurchase() {
		
		By Locator = By.name("buyFlights");
		element = Constant.driver.findElement(Locator);
		return element;
	
	}
	
	
	
	
	
	
	
	
	
	
	

}
