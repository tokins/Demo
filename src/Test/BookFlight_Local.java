package Test;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.Logs;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



import ObjectRepository.create_account_success;
import ObjectRepository.mercurypurchase;
import ObjectRepository.mercurypurchase2;
import ObjectRepository.mercuryregister;
import ObjectRepository.mercuryreservation;
import ObjectRepository.mercuryreservation2;
import ObjectRepository.mercurysignon;
import ObjectRepository.mercurywelcome;
import Utils.Constant;
import Utils.ExcelUtil;

public class BookFlight_Local {
	
	public static WebDriver driver = null;
	//public static ExcelUtil excelUtil = null;
	final String User = "Tester";
	final String Password = "tester@123";	
	
	private static Logger Log = Logger.getLogger(Logs.class.getName());
	
	@Parameters("browser")
	@Test
	public void LaunchBrowser(String Browser) throws Exception {
		
		DOMConfigurator.configure("log4j.xml");
		
		if (Browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", Constant.Path_Chromedriver);
			driver = new ChromeDriver();
		  } else if (Browser.equalsIgnoreCase("iexplore")) {
			  System.setProperty("webdriver.ie.driver", Constant.Path_IEdriver);
			  driver = new InternetExplorerDriver();
		  } else if (Browser.equalsIgnoreCase("firefox")) {
			  System.setProperty("webdriver.gecko.driver", Constant.Path_Geckodriver);
			  driver =new FirefoxDriver();
		  } else if (Browser.equalsIgnoreCase("edge")) {
			  System.setProperty("webdriver.ie.driver", Constant.Path_Edgedriver);
			  driver = new InternetExplorerDriver();
		  }
		
		
		Log.info("New driver instantiated for " + Browser);		
		driver.get(Constant.url);
		Log.info("Web application launched");
		driver.manage().timeouts().implicitlyWait(20L,TimeUnit.SECONDS);	
		Log.info("Implicit wait applied on the driver for 20 seconds");
		
		Constant.driver = driver;		
		Reporter.log("Application Lauched successfully | ");

		
		/*Initialized the excel file*/
		ExcelUtil.setExcelFile(Constant.Path_TestData, "Sheet1");
		Log.info("Open the Excel Datatable");

			
	}
	
	@Test (priority=0)
	public void Register() {
		
		mercurywelcome.link_Register().click();
		Log.info("Click Register link");
		mercuryregister.textBox_UserName().sendKeys(User);
		Log.info("Enter Username " + User);
		mercuryregister.textBox_Password().sendKeys(Password);
		Log.info("Enter Password");
		mercuryregister.textBox_ConfirmPassword().sendKeys(Password);
		Log.info("Enter Confirm Password");
		mercuryregister.button_Submit().click();
		Log.info("Click Submit button");
		String actual = create_account_success.label_Success().getText();
		Assert.assertEquals(actual, "Note: Your user name is " + User + ".");		
		Reporter.log("Registration Successful | ");
	}
	
	@Test(priority=1)
	public void SignIn() {
		
	
		create_account_success.link_SignIn().click();
		Log.info("Click Sign In link");
		mercurysignon.textBox_UserName().sendKeys(User);
		Log.info("Enter Username " + User);
		mercurysignon.textBox_Password().sendKeys(Password);
		Log.info("Enter Password");
		mercurysignon.button_Submit().click();	
		Log.info("Click Submit button");
		
		Reporter.log("SignIn Successful | ");
		
	}	
		
	@Test(priority=3)
	public void CreateFlight() throws InterruptedException {

		for (int Iteration = 1; Iteration != Constant.LastRow+1;Iteration++){
						
			Log.info("+++++++++++Start Run of " + Iteration + " Iteration+++++++++++++++");
			Constant.RowNum = Iteration;
			String Passengers = ExcelUtil.Datatable("Passengers");
			String TripType = ExcelUtil.Datatable("TripType");
			String DepartingFrom = ExcelUtil.Datatable("DepartingFrom");
			String DepartingMonth = ExcelUtil.Datatable("DepartingMonth");
			String DepartingDay = ExcelUtil.Datatable("DepartingDay");
			String ArrivingIn = ExcelUtil.Datatable("ArrivingIn");
			String ReturningMonth = ExcelUtil.Datatable("ReturningMonth");
			String ReturningDay = ExcelUtil.Datatable("ReturningDay");
			String ServiceClass = ExcelUtil.Datatable("ServiceClass");
			//String Airline = ExcelUtil.Datatable("Airline");
			String SelectedDepartAirline = ExcelUtil.Datatable("SelectedDepartAirline");
			String SelectedReturnAirline = ExcelUtil.Datatable("SelectedReturnAirline");
			
			mercurywelcome.link_Flight().click();
			Log.info("Click Flight link");
			mercuryreservation.rdbutton_TripType(TripType).click();
			Log.info("Select Trip type");
			mercuryreservation.dropdown_Passengers(Passengers);
			Log.info("Select number of Passengers");
			mercuryreservation.dropdown_DepartingFrom(DepartingFrom);
			Log.info("Select Departing From");
			mercuryreservation.dropdown_DepartingMonth(DepartingMonth);			
			mercuryreservation.dropdown_DepartingDay(DepartingDay);		
			Log.info("Select Departing date");
			mercuryreservation.dropdown_ArrivingTo(ArrivingIn);
			Log.info("Select Arriving In");
			mercuryreservation.dropdown_ArrivingMonth(ReturningMonth);
			mercuryreservation.dropdown_ArrivingDay(ReturningDay);
			Log.info("Select Arriving date");
			mercuryreservation.rdbutton_ServiceClass(ServiceClass).click();
			Log.info("Select Service class");
			mercuryreservation.button_Continue().click();
			Log.info("Click Continue button");
			mercuryreservation2.rdbutton_DepartSelected(SelectedDepartAirline).click();
			Log.info("Select Depart Airline");
			mercuryreservation2.rdbutton_ReturnSelected(SelectedReturnAirline).click();
			Log.info("Select Return Airline");
			mercuryreservation2.button_Continue().click();
			Log.info("Click Continue button");
			
			System.out.println(mercurypurchase.label_TotalPrice().getText());
			String TotalPrice = mercurypurchase.label_TotalPrice().getText();
			ExcelUtil.SetDatatable(TotalPrice,"TotalPrice");
			
			mercurypurchase.button_SecurePurchase().click();
			Log.info("Click Secure Purchase button");
			System.out.println(mercurypurchase2.label_ConfirmationNumber().getText());
			String ConfirmationNumber = mercurypurchase2.label_ConfirmationNumber().getText();
			ExcelUtil.SetDatatable(ConfirmationNumber,"ConfirmationNumber");				
					
			String actual = mercurypurchase2.label_Message().getText();
			System.out.println(actual);
			Assert.assertEquals(actual, "Your itinerary has been booked!");
			Reporter.log("Booking Flight Successful : " + ConfirmationNumber + " | ");
		
			mercurywelcome.link_Home().click();
			Log.info("Click Home link");
			Log.info("+++++++++++End of " + Iteration + " Iteration Run+++++++++++++++");
		}
			
	}
			
	@Test(priority=4)
	public void SignOff() {
		
		mercurywelcome.link_SignOff().click();
		Log.info("Click Sign Off link");
	}	
	
	@AfterTest
	public void CloseBrowser() {
		
		Constant.driver.quit();	
		Log.info("Close the browser");
	}
	
	
	

}

