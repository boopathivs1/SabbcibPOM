package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class PaymentsPage  extends ProjectWrapp{
	public  PaymentsPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
			this.test = test;
		//	if(!verifyTitle("Corporate Customer Banking  ")){
			//	reportStep("This is not Corporate Customer Banking", "FAIL");
		//	}
		}
	
	
	public PaymentsReports navigatePayreport(){
		return new PaymentsReports(driver, test);

	}
	
	public OwnAccount clickOwnAccount() throws InterruptedException{

		clickByXpathExplict(prop.getProperty("click.ownacc.menu.xpath"));
//		clickByXpathExplict(".//p[contains(text(),'Own Accounts')]");
return new OwnAccount(driver, test);
	}

	
	public vendorpaymentsPage clickfundtransermenu() throws InterruptedException{

		clickByXpathExplict(prop.getProperty("click.fundtransfer.menu.xpath"));
//		clickByXpathExplict(".//p[contains(text(),'Own Accounts')]");
return new vendorpaymentsPage(driver, test);
	}
	
	public vendorpaymentsPage clickVendorPayments() throws InterruptedException{
defaultcontent();
		//clickByXpathExplict(prop.getProperty("click.vendorpayments.xpath"));
		clickByXpathExplict(prop.getProperty("click.fundtransfer.menu.xpath"));
		
		
		
//		clickByXpathExplict(".//p[contains(text(),'Own Accounts')]");
return new vendorpaymentsPage(driver, test);
	}	
	
	public StandingPageInstruction clickStandInstruction() throws InterruptedException{
defaultcontent();
		clickByXpathExplict(prop.getProperty("click.standinstruction.xpath"));
//		clickByXpathExplict(".//p[contains(text(),'Own Accounts')]");
return new StandingPageInstruction(driver, test);
	}		
	
	
	
	
	public WpsTransferPage clickWPStransferMenu() throws InterruptedException{
		defaultcontent();
				clickByXpathExplict(prop.getProperty("click.wpstransfer.xpath"));
//				clickByXpathExplict(".//p[contains(text(),'Own Accounts')]");
								
		return new WpsTransferPage(driver, test);
			}	
	
	
	
	public Paymentdateline navigatepaymentDateline() throws InterruptedException{
return new Paymentdateline(driver, test);
	}
	
	
	
}
