package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class OwnAccount  extends ProjectWrapp{
	public  OwnAccount(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
			this.test = test;
		//	if(!verifyTitle("Corporate Customer Banking  ")){
			//	reportStep("This is not Corporate Customer Banking", "FAIL");
		//	}
		}
	public OtP_Page ownTranserpage(String paydate,String payday,String fromcomp,String sourceaccno,String tocomp,String toAccno,String currency,String amount,String frequency,String timesofpay) throws InterruptedException{
		locateFrame("icanvas");

//		"Today","Pay Now",fromcomp,sourceAccno,Tocomp,toAccno,currency,amount);
		
		
												
dropdownSelection(prop.getProperty("owntransfer.fromcorp.xpath"),fromcomp);
//Thread.sleep(3000);
dropdownSelection(prop.getProperty("owntransfer.fromaccount.xpath"),sourceaccno);
//Thread.sleep(10000);
//dropdownSelection(".//div[@id='toCorp_chosen']",tocomp);

dropdownSelectionindex(prop.getProperty("owntransfer.tocorpchoosen.xpath"),tocomp,8);


//dropdownSelectionindex(".//div[@id='toCorp_chosen']",toAccno,17);

//Thread.sleep(10000);
//dropdownSelection(".//div[@id='toAccount_chosen']",toAccno);

dropdownSelectionindex(prop.getProperty("owntransfer.tocorpaccount.xpath"),toAccno,2);

//Thread.sleep(10000);
//dropdownSelection(".//div[@id='amountCurrencyId_chosen']",currency);
//dropdownSelectionindex(prop.getProperty("owntransfer.currencytype.xpath"),currency,14);
//(.//li[contains(@class,'active-result')][contains(text(),'SAR')])[16]

//enable below foe currency selection
//clickByXpathExplict(prop.getProperty("owntransfer.currencytype.xpath"));
//clickByXpathExplict(prop.getProperty("click.currency.drpdown.ownacc.xpath"));

//Thread.sleep(6000);
enterByXpathExplict(prop.getProperty("owntransfer.currencyamount.xpath"), amount);

//Thread.sleep(10000);

clickByXpathExplict(prop.getProperty("click.calendaricon.xpath"));

//Thread.sleep(8000);

if(paydate.equalsIgnoreCase("Today")){
	//	Thread.sleep(6000);
		
		clickByXpathExplict(prop.getProperty("clicktoday.reports.button.xpath"));

		
		

//enterByXpathExplict(".//input[@id='remarks']","ownaccount paynow remarks");
	
//	clickByXpathExplict(prop.getProperty("today.calendary.buttonone.xpath"));

//	clickByXpathExplict(".//button[text()='Today']");
}else if (paydate.equalsIgnoreCase("Tomorrow")) {
//	Thread.sleep(10000);


//			clickByXpathExplict(prop.getProperty("select.twentyyear.xpath"));
	//		Thread.sleep(8000);

	//clickByXpathExplict(prop.getProperty("select.calendar.month.xpath"));
	
//	Thread.sleep(3000);

	clickByXpathExplict(prop.getProperty("select.calendar.days.xpath"));
	}

enterByXpathExplict(prop.getProperty("enter.remarks.ownacc.xpath"),"ownaccount");


if(payday.equalsIgnoreCase("Pay Now")){
		
clickByXpathExplict(prop.getProperty("click.paynow.button.xpath"));

}else if (payday.equalsIgnoreCase("Pay Later")) {
	clickByXpathExplict(prop.getProperty("click.paylater.xpath"));
}
if(payday.equalsIgnoreCase("Repeat")){
	
	
	clickByXpathExplict(prop.getProperty("click.repeat.button.xpath"));
	Thread.sleep(3000);
	dropdownSelection(prop.getProperty("click.frequency.button.xpath"),frequency);
//selectVisibileTextByXPath(".//select[@id='frequencyId']","Daily");
	Thread.sleep(3000);
	enterByXpathExplict(prop.getProperty("enter.timespay.xpath"),timesofpay);
clickByXpathExplict(prop.getProperty("click.repeatsubmit.button.xpath"));


}



return new OtP_Page(driver, test);



}}