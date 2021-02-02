package pages;

import javax.swing.text.html.HTML.Tag;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class SummaryPage extends ProjectWrapp{
	public  SummaryPage (RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
			this.test = test;
			if(!verifyTitle("Corporate Customer Banking")){
				reportStep("This is not Corporate Customer Banking", "FAIL");
			}
		}


	public SummaryPage  verifySummaryPage() throws InterruptedException{
		
	//	Thread.sleep(8000);
		locateFrame("icanvas");	
		
VerifyElementPresent(prop.getProperty("verify.content.summary.xpath"),"Summary details has been displaying" ,"Summary details has not been displaying");
defaultcontent();	


return this;
	}	
	

	public SummaryPage  verifydetailsTag() throws InterruptedException{
		Thread.sleep(4000);
		locateFrame("icanvas");	
		
		
clickByXpathExplict(prop.getProperty("tag.edit.xpath"));
	
	enterByXpathExplict(prop.getProperty("Tag.enterxpath"),datatag);
	//Thread.sleep(6000);
	clickByXpathExplict(prop.getProperty("tag.filter.xpath"));
	
//Thread.sleep(4000);


	verifyTextContainsByXpath("(.//a[@class='viewstmt']//span)[5]",datatag);

	return this;
}
}