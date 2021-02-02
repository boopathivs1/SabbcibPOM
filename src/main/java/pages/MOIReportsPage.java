package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class MOIReportsPage  extends ProjectWrapp{
	public  MOIReportsPage (RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
			this.test = test;
		//	if(!verifyTitle("Corporate Customer Banking  ")){
			//	reportStep("This is not Corporate Customer Banking", "FAIL");
		//	}
		}
	
	public MOIReportsPage clickmoireportslink(){
		defaultcontent();
		clickByXpathExplict(prop.getProperty("click.moireports.link.xpath"));
return this;
	}
	
	
	

public StatementPage navigateStatementpage(){
	
	return new StatementPage(driver, test);
}

public MOIReportsPage MoiPaymentStatustype(String Transactiontype,String RequestType,String Transactionstatus,String RequestStatusValue,String status) throws InterruptedException{
	pageScrollup();
	clickByXpathExplict(prop.getProperty("paymentreport.morebutton.xpath"));
	Thread.sleep(6000);
dropdownSelection(Transactiontype,RequestType);
Thread.sleep(6000);
dropdownSelection(Transactionstatus,RequestStatusValue);
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

public MOIReportsPage MOIReportCalendar() throws InterruptedException{
	locateFrame("icanvas");
	
	enterByXpathExplict("(.//input[contains(@class,'ws-date')])[1]","01/01/2020");

	//clickByXpathExplict(prop.getProperty("click.calendar.icon.xpath"));
	Thread.sleep(3000);
//	clickByXpathExplict("(.//button[text()='Clear'])[1]");
	Thread.sleep(3000);	
	//clickByXpathExplict(prop.getProperty("select.twentyyear.xpath"));
	Thread.sleep(8000);

//clickByXpathExplict(prop.getProperty("select.calendar.Janmonth.xpath"));

Thread.sleep(3000);

//clickByXpathExplict(prop.getProperty("select.requeststatus.jan.fromddate.xpath"));
	
	
	
//	clickByXpathExplict(prop.getProperty("click.today.calendar.xpath"));
	Thread.sleep(3000);
	clickByXpathExplict(prop.getProperty("click.tocalendar.icon.xpath"));
	Thread.sleep(3000);
	clickByXpathExplict(prop.getProperty("click.todaytwo.calendar.anotherindex.xpath"));
	Thread.sleep(6000);
	
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
			dropdownSelection(".//div[@id='moiPaymentType_chosen']",RequestType);
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
		
	verifyTextContainsByXpath("(.//p[text()='"+RequestStatusValue+"'])[1]",status);
	Thread.sleep(8000);
	pageScroll400();
	//enable
	Thread.sleep(6000);
	//verifyTextlistcontainXpath(".//table[@id='data']//tr//td[6]",getrefnumer);
Thread.sleep(4000);
//scrolltoelementJs(".//table[@id='data']//tr//td[contains(text(),'"+RequestStatusValue+"')]");
Thread.sleep(6000);
//verifyTextMatchlistByXpath(".//table[@id='data']//tr//td[contains(text(),'"+RequestStatusValue+"')]",status);
//verifyTextMatchlistByXpath("(.//p[text()='"+RequestStatusValue+"'])",status);
		//pageScroll400();
defaultcontent();
		return new Paymentdateline(driver, test);
			}
			

public Paymentdateline MoiPaymentStatus(String RequestType,String RequestStatusValue,String status,String day) throws InterruptedException{
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
		dropdownSelection(".//div[@id='moiPaymentType_chosen']",RequestType);
Thread.sleep(6000);

dropdownSelection(".//div[@id='status_chosen']",RequestStatusValue);
	
	Thread.sleep(6000);
	clickByXpathExplict(prop.getProperty("click.filter.button.req.xpath"));
	
//verifyTextContainsByXpath(".//td[contains(text(),'"+RequestStatusValue+"')]",status);
Thread.sleep(8000);
pageScroll400();
//enable
Thread.sleep(6000);
//verifyTextlistcontainXpath(".//table[@id='data']//tr//td[10]",getrefnumer);
Thread.sleep(4000);
//scrolltoelementJs(".//table[@id='data']//tr//td[contains(text(),'"+RequestStatusValue+"')]");
Thread.sleep(6000);
//verifyTextMatchlistByXpath(".//table[@id='data']//tr//td[contains(text(),'"+RequestStatusValue+"')]",status);
//verifyTextMatchlistByXpath("(.//p[text()='"+RequestStatusValue+"'])",status);
	//pageScroll400();
Thread.sleep(10000);
defaultcontent();
	return new Paymentdateline(driver, test);
		}
	
	
	
	
}
