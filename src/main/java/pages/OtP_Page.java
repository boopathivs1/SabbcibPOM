package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class OtP_Page extends ProjectWrapp{
	public  OtP_Page(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}


	public SabbDashboard submitTokenXpath(String token) throws InterruptedException{
	//	Thread.sleep(1000);
		enterByXpathExplict(prop.getProperty("Enter.token.xpath"),token);
	//	Thread.sleep(1000);
		clickByXpathExplict(prop.getProperty("click.submitButton.xpath"));
		log.info("Otp has been submitted");

		
		return new SabbDashboard(driver, test);
	}
		
	public	OtP_Page otpSubmission(String referenceNum) throws InterruptedException{
		Thread.sleep(5000);
		
		pageScroll();
		clickByXpathExplict(".//button[text()='Submit']");
		pageScroll();

		clickByXpathExplict(".//button[text()='Confirm']");
		
		enterByXpathExplict(".//input[@id='txtOTP']","777777");
		
		
		clickByXpathExplict(".//button[text()='Confirm']");
		
		pageScrollup();
		Thread.sleep(2000);
		
		if(referenceNum.equalsIgnoreCase("interim month")||referenceNum.equalsIgnoreCase("Previous month")){
			verifyTextContainsByXpath("(.//div[contains(@class,'alert-success')]//p)[1]", "Request initiated successfully");
			
			String input=ReturnXpathtext("(.//div[contains(@class,'alert-success')]//span)[2]");
		
		    String[] splitArray = input.split("\\s+");
		
getrefnumer=splitArray[2];
			
		}
		else if (referenceNum.equalsIgnoreCase("New Deposit Request")) {
			verifyTextContainsByXpath("(.//div[contains(@class,'alert-success')]//span)[2]", "Deposit request initiated successfully ");
			getrefnumer=ReturnXpathtext("(.//div[contains(@class,'alert-success')]//span)[3]");
			
		}
		else if (referenceNum.equalsIgnoreCase("update maturity")) {
			verifyTextContainsByXpath("(.//div[contains(@class,'alert-success')]//p)", "Deposit request initiated successfully ");
			getrefnumer=ReturnXpathtext("(.//div[contains(@class,'alert-success')]//b)");


		}
		
		ReferenceNo(getrefnumer,"Deposit Reference Number is");
	
		defaultcontent();
		
		logout(true,usertype);

		
	return this;	
	}
		

	public	RequestsStatus otpSubmit(String menuname) throws InterruptedException{
		//Thread.sleep(8000);
		
	//	pageScroll();
		scrolltoelementJs(prop.getProperty("click.submitotp.button.xpath"));
		
		clickByXpathExplict(prop.getProperty("click.submitotp.button.xpath"));
		//pageScroll();
	//	Thread.sleep(8000);
		scrolltoelementJs(prop.getProperty("click.confirmbutton.xpath"));
	//	Thread.sleep(4000);
		clickByXpathExplict(prop.getProperty("click.confirmbutton.xpath"));
		
		enterByXpathExplict(prop.getProperty("Newdepost.otpenter.xpath"),"777777");
		
		
		clickByXpathExplict(prop.getProperty("click.confirmbutton.xpath"));
		
		pageScrollup();
		Thread.sleep(2000);
		
		if(menuname.equalsIgnoreCase("interim month")||menuname.equalsIgnoreCase("Previous month")){
		//	verifyTextContainsByXpath(prop.getProperty("verify.previousinterimSucess.xpath"), "Request initiated successfully");
		//	Thread.sleep(6000);
			String input=ReturnXpathtext("(.//div[contains(@class,'alert-success')]//span)[2]");
		    String[] splitArray = input.split("\\s+");

getrefnumer=splitArray[2];
		}
		else if (menuname.equalsIgnoreCase("New Deposit Request")) {
	//		verifyTextContainsByXpath("(.//div[contains(@class,'alert-success')]//span)[2]", "Deposit request initiated successfully ");
//		Thread.sleep(6000);
			getrefnumer=ReturnXpathtext("(.//div[contains(@class,'alert-success')]//span)[3]");
		}
		else if (menuname.equalsIgnoreCase("update maturity")) {
		verifyTextContainsByXpath("(.//div[contains(@class,'alert-success')]//p)", "request initiated successfully ");
	//	Thread.sleep(6000);
		
		getrefnumer=ReturnXpathtext("(.//div[contains(@class,'alert-success')]//b)");
		}
		ReferenceNo(getrefnumer," Reference Number is");
		
		defaultcontent();
		
//		logout(true);

		
	return new RequestsStatus(driver, test);
	}

	
	
	
	public OtP_Page fillOtp(String otp) throws InterruptedException{
		
		Thread.sleep(4000);
		clickByXpath(prop.getProperty("click.confirm.button.xpath"));	
		if(otp.equalsIgnoreCase("OwnAccountOtpSubmit")){
		enterByXpathExplict((prop.getProperty("enter.otp.xpath")),otpcode);
		clickByXpath(prop.getProperty("click.finalconfirm.button.xpath"));
		}
		return this;
	}
	
	
	public OtP_Page otphandling(String actions,String xpath,String entertext,String verifymsg) throws InterruptedException{
		Thread.sleep(4000);
		if(actions.equalsIgnoreCase("click")){
			
			clickByXpathExplict(xpath);
//			Thread.sleep(3000);
		}
		else if(actions.equalsIgnoreCase("enter")){
			enterByXpathExplict(xpath,entertext);
		}
		else if (actions.equalsIgnoreCase("verify")) {
	verifyTextContainsByXpath(xpath,verifymsg);
	//		verifyTextByXpathExplicitwait(xpath, verifymsg);
			
		}
		else if (actions.equalsIgnoreCase("getrefno")) {
			getrefnumer=ReturnXpathtext(xpath);
			
		}
		
		return this;
	}
	
	public OtP_Page verifyServerError(){
	Boolean a=VerifyElementpresentreturn(prop.getProperty("addbiller.server.error.xpath"));
	booleanResult(a, "Add biller server Error has been occuring");	
	
	return this;
	}
	public SADADPage NavigationSADADpage(){
		defaultcontent();
	return new SADADPage(driver, test);
	
	}

	
	public MOIReportsPage otphandlingNavigation(){
		defaultcontent();
	return new MOIReportsPage(driver, test);
	
	}

	public Paymentdateline otphandlingNavigationPayDATELINE(){
		defaultcontent();
	return new Paymentdateline(driver, test);
	
	}	
	
	
	public WpsTransferPage NavigationWPS(){
	//	defaultcontent();
	return new WpsTransferPage(driver, test);
	
	}
	
	public PaymentsReports verifysucessmsg(){	
	verifyTextContainsByXpath(prop.getProperty("verify.submit.sucess.xpath"),"request initiated successfully");
	getrefnumer=getTextByXpath(prop.getProperty("getrefnumber.xpath"));
	
	defaultcontent();
return new PaymentsReports(driver, test);	
	}
	
	
public PaymentsReports navigatePaymentReportPage(){
	
	return new PaymentsReports(driver, test);
}
	
public StatementPage navigateStatementpage(){
	return new StatementPage(driver, test);
}
	
public StatementPage navigateStatpage(){
defaultcontent();
	return new StatementPage(driver, test);
}	

}
