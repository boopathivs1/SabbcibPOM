package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class WpsTransferPage extends ProjectWrapp{
	public   WpsTransferPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
			this.test = test;
		//	if(!verifyTitle("Corporate Customer Banking  ")){
			//	reportStep("This is not Corporate Customer Banking", "FAIL");
		//	}
		}

	public WpsTransferPage clickfileUploadTab() throws InterruptedException{
		locateFrame("icanvas");	
		
		Boolean a=VerifyElementpresentreturn(prop.getProperty("wps.server.error.xpath"));
		booleanResult(a, "Unable to Process your request. Please try after sometime has displaying");						
		clickByXpathExplict(prop.getProperty("click.fileupload.tab.xpath"));
//				clickByXpathExplict(".//p[contains(text(),'Own Accounts')]");
		return this;
			}	

	public WpsTransferPage clickfileStatusTab() throws InterruptedException{
		locateFrame("icanvas");	
				clickByXpathExplict(prop.getProperty("click.filestatus.tab.xpath"));
//				clickByXpathExplict(".//p[contains(text(),'Own Accounts')]");
		return this;
			}	

	
	
	
	public WpsTransferPage verifyfileStatusTab(String Status) throws InterruptedException{
	
				clickByXpathExplict(prop.getProperty("click.filestatus.tab.xpath"));
				clickByXpathExplict(prop.getProperty("click.filter.icon.xpath"));
				
			dropdownSelection(prop.getProperty("filter.type.choosen.wps.xpath"),"Reference Number");
				enterByXpathExplict(prop.getProperty("enter.wps.refnumber.xpath"),getrefnumer);
				clickByXpathExplict(prop.getProperty("tag.filter.xpath"));
//			verifyTextcontainslistByXpath(prop.getProperty("Filestatus.verify.xpath"),Status);
		
				
				verifyTextMatchlistByXpath(prop.getProperty("filestatus.verify.process.xpath"),Status);
				
//				verifyTextMatchlistByXpath(prop.getProperty("Filestatus.verify.xpath"),Status);
		return this;
			}	
	
	
	
	
	public WpsTransferPage verifyfilefilterStatusTab() throws InterruptedException{
		
		clickByXpathExplict(prop.getProperty("click.filestatus.tab.xpath"));
		clickByXpathExplict(prop.getProperty("click.filter.icon.xpath"));
		
	dropdownSelection(prop.getProperty("filter.type.choosen.wps.xpath"),"Reference Number");
		enterByXpathExplict(prop.getProperty("enter.wps.refnumber.xpath"),getrefnumer);
		clickByXpathExplict(prop.getProperty("tag.filter.xpath"));
return this;
	}	
	
	public WpsTransferPage verifyfileStatus(String Status) throws InterruptedException{
	
	verifyTextMatchlistByXpath(prop.getProperty("filestatus.verify.process.xpath"),Status);
	return this;
	}
	
	
	
	
	
	public StatementPage navigatestat(){
		defaultcontent();
		return new StatementPage(driver, test);
	}

	
	public PaymentsReports verifywpsStatus() throws InterruptedException{
		Thread.sleep(20000);
		//verifyTextMatchlistByXpath("(.//li[contains(@class,'list-group-item')]//div[contains(@class,'text-right')]/p[1])","Pending for execution");

	locateFrame("icanvas");

		verifyTextByXpathExplicitwait(prop.getProperty("verify.wps.status.xpath"),"Pending for execution");
	
	
	return new PaymentsReports(driver, test);
	}

public WpsTransferPage authorizationWPS() throws InterruptedException{
//authorizeRequest();
	
	authorizeWPS(prop.getProperty("wps.refnum.xpath"));
	defaultcontent();
	Thread.sleep(20000);
//authorizeWPSFILTER(prop.getProperty("wps.refnum.xpath"));
	return this;
	
}
public WpsTransferPage  locateframe() {
	
locateFrame("icanvas");	
return this;
}
	
public PaymentsReports verifybuzzWPS(String auth1,String auth2) throws InterruptedException{
	Thread.sleep(3000);
	
	
	clickBuzzwps(prop.getProperty("wps.refnum.xpath"), auth1, auth2);
	return new PaymentsReports(driver, test);
}
	
	
	



		








	
	
	
	
	
	
	
	
	
	
	
	
	public OtP_Page fillFileUploadForm(String fromcompany,String fromacc,String moid,String paymenttype,String filelocation) throws InterruptedException{
	//locateFrame("icanvas");	

		Thread.sleep(4000);
	
dropdownSelection(prop.getProperty("click.fromcompany.xpath"),fromcompany);	
Thread.sleep(4000);

dropdownSelection(prop.getProperty("click.fromAcc.xpath"),fromacc);	
Thread.sleep(4000);

//Thread.sleep(30000);
enterByXpathExplict(prop.getProperty("enter.filedescription.xpath"),"testing the description field");

enterByXpathExplict(prop.getProperty("moid.field.xpath"),moid);

dropdownSelection(prop.getProperty("salary.payments.type.wps.xpath"),paymenttype);	
//enterByXpathExplict(prop.getProperty("wps.upload.file.xpath"),"testing");



//clickByXpathExplict(".//span[contains(@class,'fileinput-button')]");
Thread.sleep(10000);

fileUploadByXpathExplict(".//*[@id='uploadFile']",filelocation);



Thread.sleep(10000);

clickByXpathExplict(prop.getProperty("click.submitotp.button.xpath"));


Boolean a=VerifyElementpresentreturn(prop.getProperty("wps.transaction.error.xpath"));
booleanResult(a, "Transaction cut off time has been elapsed for the day");	


clickByXpathExplict(prop.getProperty("click.submitotp.button.xpath"));
pageScroll();
return new OtP_Page(driver, test);
			}	
		
	
	
	
}
