package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class vendorpaymentsPage  extends ProjectWrapp{
	public  vendorpaymentsPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
			this.test = test;
		//	if(!verifyTitle("Corporate Customer Banking  ")){
			//	reportStep("This is not Corporate Customer Banking", "FAIL");
		}
	public BeneficiaryMaintainance clickBeneficiaryMenu() throws InterruptedException{
Thread.sleep(6000);
		locateFrame("icanvas");

		clickByXpathExplict(prop.getProperty("click.Beneficiary.Maintainance.menu.xath"));
return new BeneficiaryMaintainance(driver, test);
	}
	
	public vendorpaymentsPage paymentTab(String Transfertype,String fromCompany,String fromacc,String toBeneficiary) throws InterruptedException{
		locateFrame("icanvas");
		pageloading();
		dropdownSelection(prop.getProperty("Payment.transfertype.xpath"),Transfertype);
		pageloading();
		dropdownSelection(prop.getProperty("fromcompany.type.xpath"),fromCompany);
		pageloading();
		dropdownSelection(prop.getProperty("fromacc.type.xpath"),fromacc);
		Thread.sleep(1000);
		pageScroll400();
		Thread.sleep(2000);

		String toBenefy= toBeneficiary;   
		toBenefy = toBenefy.replaceAll("[^a-zA-Z0-9]", " ");  
		
		String Benfyval = toBenefy .replaceAll("\\s", "");
		
		Thread.sleep(2000);	
		dropdownSelection(prop.getProperty("toacc.type.xpath"),Benfyval);
		Thread.sleep(1000);
		
		
		return this;
	}

	public vendorpaymentsPage enterLocalOtherCurrencydetails(String currency,String amount) throws InterruptedException{
		pageScroll1400(prop.getProperty("currenyIdchoose.xpath"));
		//Thread.sleep(3000);

		dropdownSelectionindex(prop.getProperty("currenyIdchoose.xpath"),currency,9);
//Thread.sleep(6000);
enterByXpathExplict(prop.getProperty("owntransfer.currencyamount.xpath"), amount);

return this;
	}
	
	public vendorpaymentsPage enterFundCurrencydetails(String currency,String amount) throws InterruptedException{
		
		try {
		readytimes();
			readystate();
			jqueryload();
		} catch (InterruptedException e1) {
		}
		
		pageScroll1400(prop.getProperty("currenyIdchoose.xpath"));
		//Thread.sleep(3000);

		clickByXpathExplict(prop.getProperty("currenyIdchoose.xpath"));

		clickByXpathExplict(prop.getProperty("click.fundtransfer.other.currency.xpath"));
		
		
		//Thread.sleep(6000);
enterByXpathExplict(prop.getProperty("owntransfer.currencyamount.xpath"), amount);

return this;
	}
	
	
	
	
	public vendorpaymentsPage chargesPaiddetails(String chargespaid) throws InterruptedException{
	dropdownSelection(prop.getProperty("chargespaid.dropdown.overseas.xpath"), chargespaid);
	
	
	
return this;
	}
	
	public vendorpaymentsPage enterOverseasCurrencydetails(String currency,String amount) throws InterruptedException{
		
		
		
	//	Thread.sleep(3000);
		pageScroll1400(prop.getProperty("currenyIdchoose.xpath"));
//pageScroll400();	
scrolltoelementJs(prop.getProperty("owntransfer.overseascurrencyamount.xpath"));
		clickByXpathExplict(prop.getProperty("owntransfer.overseascurrencyamount.xpath"));

	//	enterByXpathExplict(prop.getProperty("owntransfer.overseascurrencyamount.xpath"), amount);
		Thread.sleep(2000);
		clickByXpathExplict(prop.getProperty("currenyIdchoose.xpath"));
		Thread.sleep(2000);

		clickByXpathExplict(prop.getProperty("click.fundtransfer.other.currency.xpath"));
//Thread.sleep(6000);
enterByXpathExplict(prop.getProperty("owntransfer.overseascurrencyamount.xpath"), amount);
	return this;	
	}
	
	
	
	
	public OtP_Page vendorPayments_Payment_OtherSabbAcc(String paydate,String Payday,String frequency,String timesofpay,String Transferpurpose,String remarks) throws InterruptedException{


Thread.sleep(1000);

clickByXpathExplict(prop.getProperty("click.calendaricon.xpath"));


if(paydate.equalsIgnoreCase("Today")){
		
		
	
	
	clickByXpathExplict(prop.getProperty("click.fundtrans.currentdate.xpath"));
	Thread.sleep(3000);

//verifyPageSourceText("to be processed");
	verifyPageSourceText("Holiday");
	verifyPageSourceText("cut off");
	
	
//		clickByXpathExplict(prop.getProperty("clicktoday.reports.button.xpath"));
}else if (paydate.equalsIgnoreCase("Tomorrow")) {
	//Thread.sleep(4000);


//			clickByXpathExplict(prop.getProperty("select.twentyyear.xpath"));
//			Thread.sleep(8000);

//	clickByXpathExplict(prop.getProperty("select.calendar.month.xpath"));
	
	Thread.sleep(1000);

	clickByXpathExplict(prop.getProperty("select.calendar.days.xpath"));
	Thread.sleep(3000);
	//verifyPageSourceText("processed");
	verifyPageSourceText("Holiday");
	verifyPageSourceText("cut off");

}

enterByXpathExplict(prop.getProperty("enter.othersabbAcc.remarks.xpath"),remarks);


Thread.sleep(3000);
dropdownSelection(prop.getProperty("transferpayment.purpose.xpath"),Transferpurpose);
//Thread.sleep(3000);

if(Payday.equalsIgnoreCase("Pay Now")){
		
clickByXpathExplict(prop.getProperty("Vendor.paynow.button.xpath"));
//Boolean a=VerifyElementpresentreturn(prop.getProperty("transaction.cutoff.verify.xpath"));

//verifyPageSourceText("processed");
verifyPageSourceText("Holiday");
verifyPageSourceText("cut off");


}else if (Payday.equalsIgnoreCase("Pay Later")) {
	clickByXpathExplict(prop.getProperty("Vendor.payLater.button.xpath"));
//	Boolean a=VerifyElementpresentreturn(prop.getProperty("transaction.cutoff.verify.xpath"));

	Thread.sleep(3000);
	//verifyPageSourceText("processed");
	verifyPageSourceText("Holiday");
	verifyPageSourceText("cut off");
	

}



if(Payday.equalsIgnoreCase("Repeat")){

	Thread.sleep(4000);
	clickByXpathExplict(prop.getProperty("Vendor.Repeat.xpath"));
//	verifyPageSourceText("processed");
	verifyPageSourceText("Holiday");
	verifyPageSourceText("cut off");
		
	//pageScroll400();
	Thread.sleep(2000);
//	pageScroll();
	
	scrolltoelementJs(prop.getProperty("enter.timespay.xpath"));
	//Thread.sleep(4000);
	
	dropdownSelection(prop.getProperty("click.frequency.payments.button.xpath"),frequency);
//selectVisibileTextByXPath(".//select[@id='frequencyId']","Daily");
	Thread.sleep(3000);
	enterByXpathExplict(prop.getProperty("enter.timespay.xpath"),timesofpay);
clickByXpathExplict(prop.getProperty("click.repeatsubmit.button.xpath"));

//Thread.sleep(10000);
}


//WebElement element = driver.findElement(By.cssSelector("div.form-group:nth-child(1) div.checkinput_pos label.checkinput"));
//.//span[contains(text(),'I confirm that')]	
//label.checkinput
//.//label[@class='checkinput']
//(.//label[@class='checkinput']//span)[2]

//clickByXpathExplict(".//label[@class='checkinput']");


pageScroll();
Thread.sleep(4000);

/*
WebElement element = driver.findElement(By.xpath("//*[@id='isTermsAccepted1']"));

JavascriptExecutor jse = (JavascriptExecutor)driver;
jse.executeScript("arguments[0].click();", element);
*/

//clickJswait(prop.getProperty("click.terms.checkbox.accept.xpath"));
clickJs(prop.getProperty("click.terms.checkbox.accept.xpath"));

return new OtP_Page(driver, test);



}
	

}