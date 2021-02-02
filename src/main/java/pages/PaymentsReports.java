package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class PaymentsReports  extends ProjectWrapp{
	public  PaymentsReports(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
			this.test = test;
		//	if(!verifyTitle("Corporate Customer Banking  ")){
			//	reportStep("This is not Corporate Customer Banking", "FAIL");
		//	}
		}
	
	
	public PaymentsReports clickPaymentReports(){
		defaultcontent();
		clickByXpath(prop.getProperty("click.paymentreport.xpath"));
		return this;
	}

	public PaymentsReports clickSadadPaymentReports(){
		defaultcontent();
		clickByXpath(prop.getProperty("click.sadadpayment.reports.xpath"));
		return this;
	}

	public PaymentsReports clickSadadPayemntHistory(){
		defaultcontent();
		clickByXpath(prop.getProperty("Sadad.paymenthistory.xpath"));
		return this;
	}
	
	public PaymentsReports sadadPaymentReports(String corpid,String Accid) throws InterruptedException{
		locateFrame("icanvas");
		Thread.sleep(3000);
		dropdownSelection(prop.getProperty("corpid.transferhistory.xpath"),corpid);
		Thread.sleep(3000);
		dropdownSelection(prop.getProperty("fromacc.transferhistory.choosen.xpath"),Accid);
//	clickByXpathExplict(prop.getProperty("click.calendar.iconone.xpath"));
//	clickByXpathExplict(prop.getProperty("Paymentreport.thisfromcalendar.year.xpath"));
	Thread.sleep(3000);
//clickByXpathExplict(prop.getProperty("select.calendar.Janmonth.xpath"));
Thread.sleep(3000);

enterByXpathExplict("(.//input[contains(@class,'ws-date')])[1]","01/01/2020");


//clickByXpathExplict(prop.getProperty("calendar.janday.xpath"));

clickByXpathExplict(prop.getProperty("click.secclandar.icon.xpath"));
clickByXpathExplict(prop.getProperty("click.todaytwo.calendar.anotherindex.xpath"));


//clickByXpathExplict(prop.getProperty("click.filter.button.req.xpath"));


clickByXpathExplict(prop.getProperty("sadad.filter.payreports.buttons.xpath"));



VerifyElementPresent(prop.getProperty("sadad.payment.reports.xpath"),"Sadad payment reports has been displaying","Sadad payment reports has not sbeen displaying");
	
	
	return this;	
	}
	
	public Paymentdateline PaymentStatus(String RequestType,String RequestStatusValue,String status,String day) throws InterruptedException{
		locateFrame("icanvas");
		clickByXpathExplict(prop.getProperty("click.calendar.iconone.xpath"));
		Thread.sleep(3000);
		clickByXpathExplict(prop.getProperty("click.todaycalo.xpath"));
		Thread.sleep(3000);
		
		clickByXpathExplict(prop.getProperty("click.secclandar.icon.xpath"));
		
		if(day=="Today")
		{
		
		
		Thread.sleep(6000);
//		clickByXpathExplict(".//label[text()='To']//following::button[text()='Today']");
		
		clickByXpathExplict(prop.getProperty("paymentreport.today.calendar.type.xpath"));
		
		
		Thread.sleep(6000);
		
		
		//.//div[@id='transactionSubType_chosen']
		//??LABEL.PAYMENT.Own Account Transfer_en_US??
		}
		
		else if (day=="Tomorrow") {

			Thread.sleep(3000);
			
			clickByXpathExplict(prop.getProperty("Paymentreport.tomorrow.year.xpath"));
			Thread.sleep(3000);
			

	clickByXpathExplict(prop.getProperty("select.calendar.month.xpath"));
	
	Thread.sleep(3000);

	clickByXpathExplict(prop.getProperty("select.calendar.days.xpath"));
			

			
		}
		
		
		clickByXpathExplict(prop.getProperty("paymentreport.morebutton.xpath"));
		Thread.sleep(6000);
		
		
		
		
		
		
		dropdownSelection(".//div[@id='transactionSubType_chosen']",RequestType);
Thread.sleep(6000);

dropdownSelection(".//div[@id='status_chosen']",RequestStatusValue);
		
	//	selectVisibileTextByXPath(".//select[@id='transactionSubType']",RequestType);
		Thread.sleep(6000);
//.//div[@id='status_chosen']
		//Pending Authorization
		//selectVisibileTextByXPath(".//select[@id='status']",RequestStatusValue);
		//Thread.sleep(6000);
		
		
		clickByXpathExplict(prop.getProperty("click.filter.button.req.xpath"));
	//getrefnumer="OWN19672";
	
	Thread.sleep(8000);
	pageScroll400();
	//enable
	Thread.sleep(6000);


//	enable below case if working
	verifyTextlistcontainXpath(".//table[@id='data']//tr//td[6]",getrefnumer);
Thread.sleep(4000);



scrolltoelementJs(".//table[@id='data']//tr//td[contains(text(),'"+RequestStatusValue+"')]");

Thread.sleep(6000);



verifyTextMatchlistByXpath(".//table[@id='data']//tr//td[contains(text(),'"+RequestStatusValue+"')]",status);


//verifyTextMatchlistByXpath("(.//p[text()='"+RequestStatusValue+"'])",status);
		//pageScroll400();
	
defaultcontent();
		return new Paymentdateline(driver, test);
			}
	
	

	public Paymentdateline OwnPaymentStatusCheck(String RequestType,String RequestStatusValue,String status,String day) throws InterruptedException{
		locateFrame("icanvas");
		clickByXpathExplict(prop.getProperty("click.calendar.iconone.xpath"));
		Thread.sleep(3000);
		clickByXpathExplict(prop.getProperty("click.todaycalo.xpath"));
		Thread.sleep(3000);
		
		clickByXpathExplict(prop.getProperty("click.secclandar.icon.xpath"));
		
		if(day=="Today")
		{
		
		
	//	Thread.sleep(6000);
//		clickByXpathExplict(".//label[text()='To']//following::button[text()='Today']");
	clickByXpathExplict(prop.getProperty("click.day.ownacc.payreport.xpath"));

	//	clickByXpathExplict(prop.getProperty("paymentreport.today.calendar.type.xpath"));
	//	Thread.sleep(6000);
		}
				else if (day=="Tomorrow") {
			Thread.sleep(3000);
			clickByXpathExplict(prop.getProperty("click.day.ownacc.payreport.xpath"));
		//	Thread.sleep(3000);
//				clickByXpathExplict(prop.getProperty("select.calendar.month.xpath"));
	Thread.sleep(3000);
	//clickByXpathExplict(prop.getProperty("select.calendar.to.days.xpath"));
					}
		clickByXpathExplict(prop.getProperty("paymentreport.morebutton.xpath"));
	//	Thread.sleep(6000);
		dropdownSelection(".//div[@id='transactionSubType_chosen']",RequestType);
//Thread.sleep(6000);
dropdownSelection(".//div[@id='status_chosen']",RequestStatusValue);
		
//		Thread.sleep(6000);
		clickByXpathExplict(prop.getProperty("click.filter.button.req.xpath"));
	//getrefnumer="OWN19672";
		
	//Thread.sleep(8000);
	pageScroll400();
	//enable
//	Thread.sleep(6000);


//	enable below case if working

	verifyTextlistcontainXpath(".//table[@id='data']//tr//td[14]",getrefnumer);
Thread.sleep(2000);
scrolltoelementJs(".//table[@id='data']//tr//td[contains(text(),'"+RequestStatusValue+"')]");
//Thread.sleep(6000);
verifyTextMatchlistByXpath(".//table[@id='data']//tr//td[contains(text(),'"+RequestStatusValue+"')]",status);

defaultcontent();
		return new Paymentdateline(driver, test);
			}
	
	
	
	
	
	
			
	public Paymentdateline OwnPaymentFundTransferStatus(String RequestType,String RequestStatusValue,String status,String day) throws InterruptedException{
		locateFrame("icanvas");
		clickByXpathExplict(prop.getProperty("click.calendar.iconone.xpath"));
		Thread.sleep(1000);
		clickByXpathExplict(prop.getProperty("click.todaycalo.xpath"));
		Thread.sleep(1000);
		
		clickByXpathExplict(prop.getProperty("click.secclandar.icon.xpath"));
		
		if(day=="Today")
		{
		
		
		Thread.sleep(1000);
		clickByXpathExplict("((.//button[contains(@class,'checked-value')])[2]//following::td/button)[3]");
		
//		clickByXpathExplict(prop.getProperty("click.to.fundtrans.todate.Payreport.xpath"));
		Thread.sleep(6000);
		}
				else if (day=="Tomorrow") {
			//Thread.sleep(3000);
//			clickByXpathExplict(prop.getProperty("Paymentreport.tomorrow.year.xpath"));
			//Thread.sleep(3000);
//				clickByXpathExplict(prop.getProperty("select.calendar.month.xpath"));
	//Thread.sleep(3000);
//	clickByXpathExplict(prop.getProperty("click.to.fundtrans.todate.Payreport.xpath"));
	
					clickByXpathExplict("((.//button[contains(@class,'checked-value')])[2]//following::td/button)[3]");

				
				}
		clickByXpathExplict(prop.getProperty("paymentreport.morebutton.xpath"));
		Thread.sleep(1000);
		dropdownSelection(".//div[@id='transactionSubType_chosen']",RequestType);
Thread.sleep(1000);
dropdownSelection(".//div[@id='status_chosen']",RequestStatusValue);
		
		//Thread.sleep(6000);
		clickByXpathExplict(prop.getProperty("click.filter.button.req.xpath"));
	//getrefnumer="OWN19672";
		
//Thread.sleep(8000);
	pageScroll400();
	//enable
	Thread.sleep(1000);


//	enable below case if working

	verifyTextlistcontainXpath(".//table[@id='data']//tr//td[14]",getrefnumer);
Thread.sleep(1000);
scrolltoelementJs(".//table[@id='data']//tr//td[contains(text(),'"+RequestStatusValue+"')]");
Thread.sleep(1000);
verifyTextMatchlistByXpath(".//table[@id='data']//tr//td[contains(text(),'"+RequestStatusValue+"')]",status);

defaultcontent();
		return new Paymentdateline(driver, test);
			}

	public Paymentdateline OwnPaymentStatus(String RequestType,String RequestStatusValue,String status,String day) throws InterruptedException{
		locateFrame("icanvas");
		clickByXpathExplict(prop.getProperty("click.calendar.iconone.xpath"));
		Thread.sleep(3000);
		clickByXpathExplict(prop.getProperty("click.todaycalo.xpath"));
		Thread.sleep(3000);
		
		clickByXpathExplict(prop.getProperty("click.secclandar.icon.xpath"));
		
		if(day=="Today")
		{
		
		
		Thread.sleep(6000);
//		clickByXpathExplict(".//label[text()='To']//following::button[text()='Today']");
		
		clickByXpathExplict(prop.getProperty("paymentreport.today.calendar.type.xpath"));
		Thread.sleep(6000);
		}
				else if (day=="Tomorrow") {
			Thread.sleep(3000);
			clickByXpathExplict(prop.getProperty("Paymentreport.tomorrow.year.xpath"));
			Thread.sleep(3000);
				clickByXpathExplict(prop.getProperty("select.calendar.month.xpath"));
	Thread.sleep(3000);
	clickByXpathExplict(prop.getProperty("select.calendar.days.xpath"));
					}
		clickByXpathExplict(prop.getProperty("paymentreport.morebutton.xpath"));
		Thread.sleep(6000);
		dropdownSelection(".//div[@id='transactionSubType_chosen']",RequestType);
Thread.sleep(6000);
dropdownSelection(".//div[@id='status_chosen']",RequestStatusValue);
		
		Thread.sleep(6000);
		clickByXpathExplict(prop.getProperty("click.filter.button.req.xpath"));
	//getrefnumer="OWN19672";
		
	Thread.sleep(8000);
	pageScroll400();
	//enable
	Thread.sleep(6000);


//	enable below case if working

	verifyTextlistcontainXpath(".//table[@id='data']//tr//td[14]",getrefnumer);
Thread.sleep(4000);
scrolltoelementJs(".//table[@id='data']//tr//td[contains(text(),'"+RequestStatusValue+"')]");
Thread.sleep(6000);
verifyTextMatchlistByXpath(".//table[@id='data']//tr//td[contains(text(),'"+RequestStatusValue+"')]",status);

defaultcontent();
		return new Paymentdateline(driver, test);
			}

	
	
	
	public Paymentdateline sadadPaymentStatus(String RequestType,String RequestStatusValue,String status,String day) throws InterruptedException{
		locateFrame("icanvas");
		clickByXpathExplict(prop.getProperty("click.calendar.iconone.xpath"));
		Thread.sleep(3000);
		clickByXpathExplict(prop.getProperty("click.todaycalo.xpath"));
		Thread.sleep(3000);
		
		clickByXpathExplict(prop.getProperty("click.secclandar.icon.xpath"));
		
		if(day=="Today")
		{
		
		
		Thread.sleep(6000);

		clickByXpathExplict(prop.getProperty("paymentreport.today.calendar.type.xpath"));
		Thread.sleep(6000);
			}
		else if (day=="Tomorrow") {
			Thread.sleep(3000);
			clickByXpathExplict(prop.getProperty("Paymentreport.tomorrow.year.xpath"));
			Thread.sleep(3000);
	clickByXpathExplict(prop.getProperty("select.calendar.month.xpath"));
	Thread.sleep(3000);
	clickByXpathExplict(prop.getProperty("select.calendar.days.xpath"));	
		}		
		clickByXpathExplict(prop.getProperty("paymentreport.morebutton.xpath"));
		Thread.sleep(6000);
		
		dropdownSelection(prop.getProperty("sadad.paymenttype.choosen.xpath"),RequestType);
Thread.sleep(6000);

dropdownSelection(".//div[@id='status_chosen']",RequestStatusValue);
		
		Thread.sleep(6000);

		clickByXpathExplict(prop.getProperty("click.filter.button.req.xpath"));
		
	Thread.sleep(8000);
	pageScroll400();
	Thread.sleep(6000);

//	verifyTextlistcontainXpath(prop.getProperty("sadad.billpay.ref.xpath"),getrefnumer);
	
Thread.sleep(4000);
scrolltoelementJs(".//table[@id='data']//tr//td[contains(text(),'"+RequestStatusValue+"')]");

Thread.sleep(6000);


verifyTextMatchlistByXpath(".//table[@id='data']//tr//td[contains(text(),'"+RequestStatusValue+"')]",status);




//verifyTextMatchlistByXpath("(.//p[text()='"+RequestStatusValue+"'])",status);
		//pageScroll400();
	
defaultcontent();
		return new Paymentdateline(driver, test);
			}
			

	
	
	
	public PaymentsReports PaymentStatusReport() throws InterruptedException{
		locateFrame("icanvas");
		
		
	//	clickByXpathExplict(prop.getProperty("click.calendar.icon.xpath"));
		Thread.sleep(3000);
	//	clickByXpathExplict("(.//button[text()='Clear'])[1]");
		Thread.sleep(3000);	
		enterByXpathExplict("(.//input[contains(@class,'ws-date')])[1]","01/01/2020");

		
//		clickByXpathExplict(prop.getProperty("select.twentyyear.xpath"));
	//	Thread.sleep(8000);

//clickByXpathExplict(prop.getProperty("select.calendar.Janmonth.xpath"));

Thread.sleep(3000);

//clickByXpathExplict(prop.getProperty("select.requeststatus.jan.fromddate.xpath"));
		
		
		
	//	clickByXpathExplict(prop.getProperty("click.today.calendar.xpath"));
		Thread.sleep(3000);
		clickByXpathExplict(prop.getProperty("click.tocalendar.icon.xpath"));
		Thread.sleep(3000);
		clickByXpathExplict("(.//button[text()='Today'])");
		
//		clickByXpathExplict(prop.getProperty("click.todaytwo.calendar.xpath"));
		Thread.sleep(6000);
		return this;	
	}
	
	public PaymentsReports PaymentStatustype(String RequestType,String RequestStatusValue,String status) throws InterruptedException{
		pageScrollup();
		clickByXpathExplict(prop.getProperty("paymentreport.morebutton.xpath"));
		Thread.sleep(6000);
dropdownSelection(".//div[@id='transactionSubType_chosen']",RequestType);
Thread.sleep(6000);
dropdownSelection(".//div[@id='status_chosen']",RequestStatusValue);
		Thread.sleep(6000);
		clickByXpathExplict(prop.getProperty("click.filter.button.req.xpath"));
		Thread.sleep(8000);
	pageScroll400();
	Thread.sleep(6000);
Thread.sleep(4000);
scrolltoelementJs(".//table[@id='data']//tr//td[contains(text(),'"+RequestStatusValue+"')]");
Thread.sleep(6000);
verifyTextMatchlistByXpath(".//table[@id='data']//tr//td[contains(text(),'"+RequestStatusValue+"')]",status);
	return this;
			}

	public PaymentsReports sadadPayStatus(String day) throws InterruptedException{
		locateFrame("icanvas");
	//	clickByXpathExplict(prop.getProperty("click.calendar.iconone.xpath"));
		Thread.sleep(3000);
//		clickByXpathExplict(prop.getProperty("click.todaycalo.xpath"));
	//	Thread.sleep(3000);
	
		

		enterByXpathExplict("(.//input[contains(@class,'ws-date')])[1]","01/01/2020");


			
		
		
//		clickByXpathExplict(prop.getProperty("Paymentreport.thisfromcalendar.year.xpath"));
		Thread.sleep(3000);
//	clickByXpathExplict(prop.getProperty("select.calendar.Janmonth.xpath"));
	Thread.sleep(3000);
//	clickByXpathExplict(prop.getProperty("calendar.janday.xpath"));

	//clickByXpathExplict(prop.getProperty("click.secclandar.icon.xpath"));
	//clickByXpathExplict(prop.getProperty("click.todaytwo.calendar.xpath"));

		
		
		
		
		clickByXpathExplict(prop.getProperty("click.secclandar.icon.xpath"));
		
		if(day=="Today")
		{
		
		
		Thread.sleep(6000);

		clickByXpathExplict(prop.getProperty("paymentreport.today.calendar.type.xpath"));
		
		
		Thread.sleep(6000);
		
			}
		
		else if (day=="Tomorrow") {

			Thread.sleep(3000);
			
	//		clickByXpathExplict(prop.getProperty("Paymentreport.tomorrow.year.xpath"));
			Thread.sleep(3000);
//	clickByXpathExplict(prop.getProperty("select.calendar.month.xpath"));
	Thread.sleep(3000);
	clickByXpathExplict(prop.getProperty("select.calendar.days.xpath"));	
		}		
		
		
		return this;
			}
			
	public PaymentsReports sadadPayStatusvalue(String RequestType,String RequestStatusValue,String status) throws InterruptedException{

		clickByXpathExplict(prop.getProperty("paymentreport.morebutton.xpath"));
		Thread.sleep(6000);

		dropdownSelection(prop.getProperty("sadad.paymenttype.choosen.xpath"),RequestType);
Thread.sleep(6000);

dropdownSelection(".//div[@id='status_chosen']",RequestStatusValue);
		
	//	selectVisibileTextByXPath(".//select[@id='transactionSubType']",RequestType);
		Thread.sleep(6000);
//.//div[@id='status_chosen']
		//Pending Authorization
		//selectVisibileTextByXPath(".//select[@id='status']",RequestStatusValue);
		//Thread.sleep(6000);
		
		
		clickByXpathExplict(prop.getProperty("click.filter.button.req.xpath"));
	//getrefnumer="OWN19672";

//	verifyTextContainsByXpath("(.//p[text()='"+RequestStatusValue+"'])[1]",status);
	Thread.sleep(8000);
	pageScroll400();
	//enable
	Thread.sleep(6000);

//	verifyTextlistcontainXpath(prop.getProperty("sadad.paymentref.number.xpath"),getrefnumer);
	
Thread.sleep(4000);



scrolltoelementJs(".//table[@id='data']//tr//td[contains(text(),'"+RequestStatusValue+"')]");

Thread.sleep(6000);


verifyTextMatchlistByXpath(".//table[@id='data']//tr//td[contains(text(),'"+RequestStatusValue+"')]",status);




//verifyTextMatchlistByXpath("(.//p[text()='"+RequestStatusValue+"'])",status);
		//pageScroll400();
	pageScrollup();
//defaultcontent();
	
 
	
return this;	
}
}