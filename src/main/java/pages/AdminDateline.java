package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class AdminDateline extends ProjectWrapp{
	public  AdminDateline (RemoteWebDriver driver, ExtentTest test){
	this.driver = driver;
		this.test = test;
	//	if(!verifyTitle("Corporate Customer Banking  ")){
		//	reportStep("This is not Corporate Customer Banking", "FAIL");
	//	}
	}

	
	
	
	public AdminDateline adminFilterResultVerify(String FilterStatus) throws InterruptedException{
		locateFrame("icanvas");
		clickByXpathExplict(prop.getProperty("click.Filter.xpath"));
		clickByXpathExplict(prop.getProperty("Click.RequestType.Xpath"));
		clickByXpathExplict(prop.getProperty("Click.Account.RequestType.Value.Xpath"));
		clickByXpathExplict(prop.getProperty("Click.RequestStatus.Xpath"));
		Thread.sleep(2000);
		clickByXpathExplict(prop.getProperty("Click.RequestStatus.Value.Xpath"));
		clickByXpathExplict(prop.getProperty("Filter.button.xpath"));
	verifyTextByXpath(prop.getProperty("Filter.First.status.verifyxpath"),FilterStatus);
	pageScroll();
	verifyTextMatchlistByXpath(prop.getProperty("Filter.status.checkingAccepted.Status.xpath"),FilterStatus);
//	pageScroll400();
//	verifyTextcontainslistByXpath(prop.getProperty("Filter.Requestnumber.Status.xpath"),"DT-25573937");
	verifyTextcontainslistByXpath(prop.getProperty("Filter.DepositReferno.xpath"),"DT-25573937");

	
	
	defaultcontent();
	return this;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
