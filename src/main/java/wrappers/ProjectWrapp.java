package wrappers;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utils.DataInputProvider;
import utils.Dataproviders;

public class ProjectWrapp extends GenericWrappers{
//browerstack
	public static final String USERNAME ="vayanaautomation1";
	 public static final String AUTOMATE_KEY ="WGKy1waWi18dcYnPD8eC";
	
	public static final String URL =  "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";


	
	public String browserName;
	public String dataSheetName;

	@BeforeSuite(groups={"common"})
	public void beforeSuite() throws IOException{
		//del();
		String os = System.getProperty("os.name").toLowerCase();

		startResult();
	}

	
    
	
	@BeforeTest(groups={"common"})
	public void beforeTest(){
		loadObjects();
	}
	
	
		
	//browserstack
	
	
	/*
	 @BeforeMethod(groups={"common"})
	 public void openSTM() throws Exception {
		 	test = startTestCase(testCaseName, testDescription);
		 			test.assignCategory(category);
		 			test.assignAuthor(authors);
			
		
	 			 DesiredCapabilities capability = new DesiredCapabilities();		 			 
		 			 capability.setCapability("os", "Windows");
		 			 capability.setCapability("os_version", "10");
		 			capability.setCapability("browser", "Chrome");
		 			capability.setCapability("browser_version", "latest");
		 			//capability.setCapability("resolution", "1920x1080");
		 			capability.setCapability("project", "ChromeExecution");
		 			capability.setCapability("name",testCaseName);
		 			capability.setCapability("browserstack.selenium_version", "3.141.59");

		 			capability.setCapability("browserstack.local", "true");
		*/	 		

 /*			
		 			DesiredCapabilities capability = new DesiredCapabilities();
		 			capability.setCapability("os", "Windows");
		 			capability.setCapability("os_version", "10");
		 			capability.setCapability("browser", "Edge");
		 			capability.setCapability("browser_version", "85.0 beta");
		 			capability.setCapability("browserstack.local", "true");
*/
/*
		 			DesiredCapabilities capability = new DesiredCapabilities();
		 			capability.setCapability("os", "Windows");
		 			capability.setCapability("os_version", "10");
		 			capability.setCapability("browserstack.local", "true");

		 			capability.setCapability("browser", "Firefox");
		 			capability.setCapability("browser_version", "latest");
	*/	 			
/*
		 			DesiredCapabilities capability = new DesiredCapabilities();
		 			capability.setCapability("os", "Windows");
		 			capability.setCapability("os_version", "10");
		 			capability.setCapability("browserstack.local", "true");

		 			capability.setCapability("browser", "IE");
		 			capability.setCapability("browser_version", "11.0");
		 			
 			
		 			
		 			
		 			
		 			
	*/	 			
		 			
		 			/*
		 			DesiredCapabilities capability = new DesiredCapabilities();
		 			capability.setCapability("os", "Windows");
		 			capability.setCapability("os_version", "10");
		 			capability.setCapability("browserstack.local", "true");		 			
		 			capability.setCapability("browser", "IE");
		 			capability.setCapability("browser_version", "11.0");
		 			
		 			
		 			*/
		 			
		 			
		
		 /*			
		 			
		 			 URL browserStackUrl = new URL(URL);
		 			 driver = new RemoteWebDriver (browserStackUrl, capability);

		 			 
		 			 
		 			 

getnewurl();

					driver.manage().window().maximize();

		 			
 			driver.manage().timeouts().implicitlyWait(160,TimeUnit.SECONDS);
		   			Thread.sleep(4000);
		 			
		   			Thread.sleep(10000);

	 	
		 	}	
*/
	 

		 
		@BeforeMethod(groups={"common"})
	public void beforeMethods() throws IOException{
			test = startTestCase(testCaseName, testDescription);
			test.assignCategory(category);
			test.assignAuthor(authors);
		invokeApp(browserName);
		loginfoStart(testCaseName, testDescription);
//		  JavascriptExecutor js = (JavascriptExecutor)driver;
//String a=js.executeScript("return document.readyState").toString();


		}


	@AfterSuite(groups={"common"})
	public void afterSuite() throws Exception{

		endResult();
	
		//zip();
	}

	@AfterTest(groups={"common"})
	public void afterTest(){
		unloadObjects();
	}
	
	
	
	
	
	
	
	
	
	
	
	@AfterMethod(groups={"common"})
	public void afterMethod() throws InterruptedException{
	//	defaultcontent();
//logout(LogoutStatus,usertype);	
		endTestcase();
//	closeAllBrowsers();
	closeBrowser();
//	reportStep("Application has logged out Successfully", "PASS");

	

	
	
	}

	
	
	
	
	
	
	
	
	
	
	@DataProvider(name="fetch")
	public Object[][] getDataExcel() throws IOException{
		return Dataproviders.geta("./data/"+dataSheetName+".xlsx",testKeyword);		
	}	
	
public void logout(Boolean status,String usertype) throws InterruptedException{

//	Thread.sleep(20000);
//	defaultcontent();
	
	defaultcontent_without_load();
	
	if(status&&usertype.equalsIgnoreCase("CIBUser")){
	//Thread.sleep(8000);
//	defaultcontent();
	clickByXpathExplict(prop.getProperty("Click.Logout.xpath"));
//doubleclickByXpathExplict(prop.getProperty("Click.Logout.xpath"));	
Thread.sleep(1000);
	clickByXpathExplict(prop.getProperty("Click.Logout.yesButton.xpath"));	
	Thread.sleep(10000);	
//	try {
//readytimes();
//		//		readywithtime(xpathVal);
//		readystate();
//		jqueryload();
//	} catch (InterruptedException e1) {
//	}

reportStep("Application  has been loggout sucessfully ","PASS");	
	
	
	}
else if(status&&usertype.equalsIgnoreCase("CIBAdmin")){
//	Thread.sleep(8000);
	//defaultcontent();
	clickByXpathExplict(prop.getProperty("cibadmin.logout.profile.xpath"));
//doubleclickByXpathExplict(prop.getProperty("Click.Logout.xpath"));	
Thread.sleep(4000);
	clickByXpathExplict(prop.getProperty("cibadmin.logoutbutton.profile.xpath"));	
	Thread.sleep(15000);

//	try {
//		readytimes();
//				//		readywithtime(xpathVal);
//				readystate();
//				jqueryload();
//			} catch (InterruptedException e1) {
//			}
}
	
	
}
	
	
	}