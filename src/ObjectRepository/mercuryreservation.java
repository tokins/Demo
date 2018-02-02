package ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Utils.Constant;

public class mercuryreservation {

	private static WebElement element = null;
	
	public static WebElement rdbutton_TripType(String type) {
	
		
		List<WebElement> Radio = Constant.driver.findElements(By.name("tripType"));	
		System.out.println(Radio.size());
		
		for(int i=0; i < Radio.size();i++){
			
			//System.out.println(Radio.get(i).getAttribute("value"));
			
			if (type.equalsIgnoreCase(Radio.get(i).getAttribute("value"))) {
				System.out.println("Radiobutton selected " + type);
				element = Radio.get(i);
				return element;
			}		
		}
		
		return element;
	}
	
	public static void dropdown_Passengers(String value) {
		
		By Locator = By.name("passCount");
		element = Constant.driver.findElement(Locator);
		Select select = new Select(element);
		select.selectByValue(value);
		
	}
	
	public static void dropdown_DepartingFrom(String value) {
		
		By Locator = By.name("fromPort");
		element = Constant.driver.findElement(Locator);
		Select select = new Select(element);
		select.selectByValue(value);
		
	}
	
	public static void dropdown_DepartingMonth(String value) {
		
		By Locator = By.name("fromMonth");
		element = Constant.driver.findElement(Locator);
		Select select = new Select(element);
		select.selectByVisibleText(value);
		
	}	
	
	public static void dropdown_DepartingDay(String value) {
		
		By Locator = By.name("fromDay");
		element = Constant.driver.findElement(Locator);
		Select select = new Select(element);
		select.selectByValue(value);
		
	}	
	
	public static void dropdown_ArrivingTo(String value) {
		
		By Locator = By.name("toPort");
		element = Constant.driver.findElement(Locator);
		Select select = new Select(element);
		select.selectByValue(value);
		
	}
	
	public static void dropdown_ArrivingMonth(String value) {
		
		By Locator = By.name("toMonth");
		element = Constant.driver.findElement(Locator);
		Select select = new Select(element);
		select.selectByVisibleText(value);
		
	}	
	
	public static void dropdown_ArrivingDay(String value) {
		
		By Locator = By.name("toDay");
		element = Constant.driver.findElement(Locator);
		Select select = new Select(element);
		select.selectByValue(value);
		
	}	
	
	public static WebElement rdbutton_ServiceClass(String type) {
	
		
		List<WebElement> Radio = Constant.driver.findElements(By.name("servClass"));	
		System.out.println(Radio.size());
		
		for(int i=0; i < Radio.size();i++){
			
			System.out.println(Radio.get(i).getAttribute("value"));
			
			if (type.equalsIgnoreCase(Radio.get(i).getAttribute("value"))) {
				System.out.println("Radiobutton selected " + type);
				element = Radio.get(i);
				return element;
			}		
		}
		
		return element;
	}
	
	public static void dropdown_Airline(String value) {
		
		By Locator = By.name("airline");
		element = Constant.driver.findElement(Locator);
		Select select = new Select(element);
		select.selectByValue(value);
		
	}	
	
	public static WebElement button_Continue() {
		
		By Locator = By.name("findFlights");
		element = Constant.driver.findElement(Locator);
		return element;
		
	}	
}
