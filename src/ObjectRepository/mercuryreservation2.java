package ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Utils.Constant;

public class mercuryreservation2 {
	
	
	private static WebElement element = null;
	

	public static WebElement rdbutton_DepartSelected(String type) {
	
		
		List<WebElement> Radio = Constant.driver.findElements(By.name("outFlight"));	
		System.out.println(Radio.size());
		
		for(int i=0; i < Radio.size();i++){
			
			System.out.println(Radio.get(i).getAttribute("value"));
			
			if (Radio.get(i).getAttribute("value").contains(type)) {
				System.out.println("Radiobutton selected " + type);
				element = Radio.get(i);
				return element;
			}		
		}
		
		return element;
	}
	
	public static WebElement rdbutton_ReturnSelected(String type) {
	
		
		List<WebElement> Radio = Constant.driver.findElements(By.name("inFlight"));	
		System.out.println(Radio.size());
		
		for(int i=0; i < Radio.size();i++){
			
			System.out.println(Radio.get(i).getAttribute("value"));
			
			if (Radio.get(i).getAttribute("value").contains(type)) {
				System.out.println("Radiobutton selected " + type);
				element = Radio.get(i);
				return element;
			}		
		}
		
		return element;
	}
	
	public static WebElement button_Continue() {
		
		By Locator = By.name("reserveFlights");
		element = Constant.driver.findElement(Locator);
		return element;
		
	}

}
