package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class RequestsStatus  extends ProjectWrapp{
	public  RequestsStatus(RemoteWebDriver driver, ExtentTest test){
	this.driver = driver;
		this.test = test;
	//	if(!verifyTitle("Corporate Customer Banking  ")){
		//	reportStep("This is not Corporate Customer Banking", "FAIL");
	//	}
	}

	public RequestsStatus RequestMenu() throws InterruptedException{
		clickByXpathExplict(prop.getProperty("click.requestmenus.xpath"));
return this;
	}
	

	public RequestsStatus logoutApplication() throws InterruptedException{
	logout(true,usertype);
return this;
	}
	
	public DateLine defaultContentFram(){
		defaultcontent();
	
		return new DateLine(driver, test);
	}
	

	
	
	public RequestsStatus UpdateMaturityMenu(String FromCompany,String SourceAcno) throws InterruptedException{
		//clickByXpathExplict(".//a[contains(text(),'Update Maturity')]");
		locateFrame("icanvas");


		
	//	String userid= Username;   
//		userid = userid.replaceAll("[^a-zA-Z0-9]", " ");  
		
	//	String usernamevalue = userid .replaceAll("\\s", "");
		
clickByXpathExplict(prop.getProperty("click.fromcompanyupdate.xpath"));

clickByXpathExplict(".//li[contains(@class,'active-result')][contains(text(),'"+FromCompany+"')]");
//Thread.sleep(4000);
clickByXpathExplict(prop.getProperty("click.fromacc.update.xpath"));
//Thread.sleep(4000);

clickByXpathExplict(".//li[contains(text(),'"+SourceAcno+"')]");
	
		
return this;
	}
	
	
	
	
	
	
	
	

public	OtP_Page UpdateMaturityoptions(String maturityopt,String Profiletransfer) throws InterruptedException{
	//Thread.sleep(15000);
	pageScroll();
	clickByXpathExplict(prop.getProperty("click.maturity.dropdown.xpath"));
//	Thread.sleep(6000);
	if(maturityopt.contains("Renew total balance")){
		//Renew total balance (Principal + Profit) for a new term

		clickByXpathExplict(prop.getProperty("click.renew.balancedd.xpath"));
		//Renew total balance (Principal + Profit) for a new term
	//	Thread.sleep(6000);
		clickByXpathExplict(prop.getProperty("click.renewterm.choosen.xpath"));
//		Thread.sleep(6000);

		clickByXpathExplict(prop.getProperty("click.renewtermMonth.choosen.xpath"));
		
}else if(maturityopt.contains("Renew the balance only"))	{
//	Thread.sleep(6000);

	
	
	clickByXpathExplict(prop.getProperty("click.renewbalance.choosen.xpath"));
//	Thread.sleep(6000);

	clickByXpathExplict(prop.getProperty("click.renewbalanceterm.choosen.xpath"));
//	Thread.sleep(6000);

	clickByXpathExplict(prop.getProperty("click.renewMonth.choosen.xpath"));
pageScroll400();	
//	Thread.sleep(6000);
	dropdownSelection(prop.getProperty("Accprofit.trasfer.xpath"),Profiletransfer);
	
	
//dropdownSelection(prop.getProperty("Accprofit.trasfer.xpath"),Profiletransfer);
	
}	
else if(maturityopt.contains("Add or withdraw"))	{
	//Add or withdraw funds on maturity
	
	

	clickByXpathExplict(prop.getProperty("AddorWithdraw.funds.xpath"));
	enterByXpathExplict(prop.getProperty("AddorWithdraw.Amount.xpath"),"40");
pageScroll400();
//	Thread.sleep(6000);

//dropdownSelection(prop.getProperty("AddOrWithdraw.profiletreansfer.xpath"),Profiletransfer);
Thread.sleep(6000);
selectVisibileTextByXPath(prop.getProperty("withdraw.newterm.xpath"),"1 Month");
	
}
else if(maturityopt.contains("Withdraw the total balance"))	{
pageScroll400();
//	Thread.sleep(8000);

	
	
clickByXpathExplict(prop.getProperty("click.donotrenew.choosen.xpath"));
//Thread.sleep(4000);
	
	//clickByXpathExplict(".//div[@id='enchashProfitTransferAccountUUID_chosen']");
	//clickByXpathExplict("(.//li[contains(@class,'active-result')][text()='SASABB242003333001 - CA - SAR'])[2]");

dropdownSelection(prop.getProperty("click.donot.renew.transfer.xpath"),Profiletransfer);
pageScroll400();
}
	
else	{
reportStep("deposit Maturity has not matched","FAIL");
}	
	//Thread.sleep(6000);
return new OtP_Page(driver, test);	
}

	
	
	
	
	
	
	
	
	
	
	
	
public RequestsStatus previousStatementMenu() throws InterruptedException{
		
		clickByXpathExplict(prop.getProperty("click.previous.month.statement.xpath"));
		locateFrame("icanvas");
		
	return this;
	
	}	
	public RequestsStatus interimRequestMenu() throws InterruptedException{
	

		clickByXpathExplict(prop.getProperty("click.interim.menu.xpath"));

	
//	clickByXpathExplict(".//ul[@id='request_menu']//a[contains(text(),'Interim')]");
	locateFrame("icanvas");

	return this;

	}
	public OtP_Page interimAndPreviousMonthform(String formname,String fromcorp,String fromacc) throws InterruptedException{

clickByXpathExplict(prop.getProperty("interim.previous.fromcorp.xpath"));
clickByXpathExplict(".//li[contains(text(),'"+fromcorp+"')]");
//Thread.sleep(6000);
clickByXpathExplict(prop.getProperty("interim.previous.fromacc.xpath"));
Thread.sleep(2000);

clickByXpathExplict(".//li[contains(text(),'"+fromacc+"')]");


if(formname.equalsIgnoreCase("Previous Month")){
	
//	Thread.sleep(6000);
	
clickByXpathExplict(prop.getProperty("click.calendaricon.xpath"));
//Thread.sleep(6000);
clickByXpathExplict(prop.getProperty("click.todaycalendar.xpath"));

}

	return new OtP_Page(driver, test);
	}

	
	
public RequestsStatus clickRequestStatusFromDateLine() throws InterruptedException{
		
		clickByXpathExplict("(.//nav[@class='singlelist']//li/a)[9]");

		return this;
		}
	
	
	public RequestsStatus clickRequestStatus() throws InterruptedException{
		
		clickByXpathExplict(prop.getProperty("Click.Requeststatus.Menu.xpath"));

		return this;
		}

	
	public RequestsStatus verifyRequestStatus() throws InterruptedException{
//Thread.sleep(10000);
//		clickByXpathExplict(".//div[@id='requestId_chosen']");
locateFrame("icanvas");
//Thread.sleep(10000);
	clickByXpathExplict("//*[@id='requestId_chosen']");
				Thread.sleep(3000);
				
				
	//RequestPage.status.type.xpath=			
		clickByXpathExplict(".//ul[@class='chosen-results']/li[text()='New Deposit Request']");
		Thread.sleep(3000);
clickByXpathExplict("(.//button[@class='ws-popover-opener']/span)[1]");
		Thread.sleep(3000);
		clickByXpathExplict("(.//button[text()='Today'])[1]");
		Thread.sleep(3000);
		clickByXpathExplict("(.//button[@class='ws-popover-opener']/span)[2]");
		Thread.sleep(3000);
		clickByXpathExplict("(.//button[text()='Today'])[2]");
	//	Thread.sleep(6000);
		clickByXpathExplict(".//button[text()='More']");
enterByXpathExplict(".//input[@id='referenceNumber']",getrefnumer);
clickByXpathExplict(".//div[@id='statusId_chosen']");
clickByXpathExplict(".//ul[@class='chosen-results']//li[text()='Active']");
clickByXpathExplict(".//button[@id='filter']");
verifyTextMatchlistByXpath(prop.getProperty(".//li[@class='list-group-item']//div[contains(@class,'text-right')]/p"),"Active");
//pageScroll400();
verifyTextcontainslistByXpath(".//li[@class='list-group-item']//p[@class='prime']/span[2]",getrefnumer);
return this;
	}
	
	public RequestsStatus RequestStatusChecking(String RequestType,String RequestStatusValue,String status) throws InterruptedException{
	//	Thread.sleep(4000);
		locateFrame("icanvas");
	//	Thread.sleep(4000);
			clickByXpathExplict("//*[@id='requestId_chosen']");
		//				Thread.sleep(3000);
						
						
						clickByXpathExplict(".//ul[@class='chosen-results']/li[text()='"+RequestType+"']");		
			//	Thread.sleep(3000);
		clickByXpathExplict("(.//button[@class='ws-popover-opener']/span)[1]");
			//	Thread.sleep(3000);
				clickByXpathExplict("(.//button[text()='Today'])[1]");
			//	Thread.sleep(3000);
				clickByXpathExplict("(.//button[@class='ws-popover-opener']/span)[2]");
			//	Thread.sleep(3000);
				clickByXpathExplict("(.//button[text()='Today'])[2]");
		//		Thread.sleep(6000);
				clickByXpathExplict(".//button[text()='More']");
		enterByXpathExplict(".//input[@id='referenceNumber']",getrefnumer);
		clickByXpathExplict(".//div[@id='statusId_chosen']");
	
		clickByXpathExplict(".//ul[@class='chosen-results']/li[text()='"+RequestStatusValue+"']");
		clickByXpathExplict(".//button[@id='filter']");
	//Thread.sleep(8000);
	
//	verifyTextContainsByXpath("(.//p[text()='"+RequestStatusValue+"'])[1]",status);
	//Thread.sleep(4000);

//	verifyTextcontainslistByXpath(".//li[@class='list-group-item']//p[@class='prime']/span[2]",getrefnumer);
	//Thread.sleep(4000);

	//	verifyTextMatchlistByXpath("(.//p[text()='"+RequestStatusValue+"'])",status);
		pageScroll400();
		return this;
			}
			
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public DateLine RequestStatusverify(String RequestType,String RequestStatusValue,String status) throws InterruptedException{
	
		
		Thread.sleep(4000);
//				clickByXpathExplict(".//div[@id='requestId_chosen']");
		locateFrame("icanvas");
		Thread.sleep(4000);
		
		
		clickByXpathExplict(prop.getProperty("click.dateline.icon.xpath"));
		
		
						Thread.sleep(3000);
						
//RequestPage.status.type.xpath			
		
						
						
		clickByXpathExplict(".//ul[@class='chosen-results']/li[text()='"+RequestType+"']");		
				Thread.sleep(3000);
				

				
		clickByXpathExplict(prop.getProperty("click.calendaricon.xpath"));
				Thread.sleep(3000);

						
				
				
				clickByXpathExplict(prop.getProperty("click.todaycalo.xpath"));
				Thread.sleep(3000);
				clickByXpathExplict(prop.getProperty("click.secclandar.icon.xpath"));
				Thread.sleep(3000);
				clickByXpathExplict(prop.getProperty("click.today.calendarsec.xpath"));
				Thread.sleep(6000);
				
				
				
				
				clickByXpathExplict(prop.getProperty("click.moreone.button.xpath"));
				
				Thread.sleep(6000);

				enterByXpathExplict(prop.getProperty("enter.refernum.filter.xpath"),getrefnumer);
		clickByXpathExplict(prop.getProperty("click.statuschoosen.xpath"));
	
	clickByXpathExplict(".//ul[@class='chosen-results']/li[text()='"+RequestStatusValue+"']");
	//	clickByXpathExplict(RequestStatusValue);
		
		
		clickByXpathExplict(prop.getProperty("tag.filter.xpath"));
	Thread.sleep(8000);
	
//	verifyTextContainsByXpath("(.//p[text()='"+RequestStatusValue+"'])[1]",status);
//	Thread.sleep(10000);
	
	
//verifyTextlistcontainXpath(prop.getProperty("getrefnumber.enter.xpath"),getrefnumer);
//Thread.sleep(10000);


//verifyTextMatchlistByXpath("(.//p[text()='"+RequestStatusValue+"'])",status);
		pageScroll400();
	
		
		return new DateLine(driver, test);
			}
			

	
	
	
	
	public RequestsStatus  defaultContentFrame(){
		defaultcontent();
	
		return this;
	}
	
	public DateLine clickdatelinemenu(){
		clickByXpathExplict(prop.getProperty("click.dateline.xpath"));
		
	return new DateLine(driver, test);
	}
	
	public RequestsStatus RequestStatusVerifyFromToDate(String RequestType,String RequestStatusValue,String status,Boolean condition) throws InterruptedException{
		Thread.sleep(4000);
		locateFrame("icanvas");
	Thread.sleep(4000);
			clickByXpathExplict(prop.getProperty("click.requestid.choosen.xpath"));
						Thread.sleep(2000);						
						clickByXpathExplict(".//ul[@class='chosen-results']/li[text()='"+RequestType+"']");			
if(condition){		
			//	Thread.sleep(3000);
//		clickByXpathExplict(prop.getProperty("click.calendar.icon.xpath"));
			Thread.sleep(3000);
			//	Thread.sleep(3000);	
//				clickByXpathExplict(prop.getProperty("select.twentyyear.xpath"));
	//			Thread.sleep(2000);
//		clickByXpathExplict(prop.getProperty("select.calendar.Janmonth.xpath"));
		Thread.sleep(2000);
	//	clickByXpathExplict(prop.getProperty("select.requeststatus.jan.fromddate.xpath"));
		
		enterByXpathExplict(prop.getProperty("enter.date.reqstat.xpath"),"01/01/2020");
		
		
		Thread.sleep(3000);
				clickByXpathExplict(prop.getProperty("click.tocalendar.icon.xpath"));
				Thread.sleep(2000);
				clickByXpathExplict(prop.getProperty("click.todaytwo.calendar.anotherindex.xpath"));
				Thread.sleep(2000);			
	}				
				clickByXpathExplict(prop.getProperty("click.more.button.xpath"));
		clickByXpathExplict(prop.getProperty("click.statusid.choosen"));	
		clickByXpathExplict(".//ul[@class='chosen-results']/li[text()='"+RequestStatusValue+"']");
		clickByXpathExplict(prop.getProperty("click.filter.button.req.xpath"));
	//Thread.sleep(8000);	
	verifyTextContainsByXpath("(.//p[text()='"+RequestStatusValue+"'])[1]",status);
//	Thread.sleep(4000);
	Thread.sleep(5000);
		verifyTextMatchlistByXpath("(.//p[text()='"+RequestStatusValue+"'])[1]",status);
		defaultcontent();
		return this;
			}
			

	
	
	
	public RequestsStatus RequestStatusVerify(String RequestType,String RequestStatusValue,String status) throws InterruptedException{
		Thread.sleep(4000);
//				clickByXpathExplict(".//div[@id='requestId_chosen']");
		locateFrame("icanvas");
		Thread.sleep(4000);
			clickByXpathExplict(prop.getProperty("click.requestid.choosen.xpath"));
						Thread.sleep(3000);
						
//RequestPage.status.type.xpath			
						
						clickByXpathExplict(".//ul[@class='chosen-results']/li[text()='"+RequestType+"']");		
			//	clickByXpathExplict(RequestType);
				Thread.sleep(3000);
		clickByXpathExplict(prop.getProperty("click.calendar.icon.xpath"));
				Thread.sleep(3000);
				clickByXpathExplict(prop.getProperty("click.today.calendar.xpath"));
				Thread.sleep(3000);
				clickByXpathExplict(prop.getProperty("click.tocalendar.icon.xpath"));
				Thread.sleep(3000);
				clickByXpathExplict(prop.getProperty("click.todaytwo.calendar.xpath"));
				Thread.sleep(6000);
				clickByXpathExplict(prop.getProperty("click.more.button.xpath"));
		//enterByXpathExplict(".//input[@id='referenceNumber']",getrefnumer);
		clickByXpathExplict(prop.getProperty("click.statusid.choosen"));
	
		clickByXpathExplict(".//ul[@class='chosen-results']/li[text()='"+RequestStatusValue+"']");
	//	clickByXpathExplict(RequestStatusValue);
		clickByXpathExplict(prop.getProperty("click.filter.button.req.xpath"));
	Thread.sleep(8000);
	
	verifyTextContainsByXpath("(.//p[text()='"+RequestStatusValue+"'])[1]",status);
	Thread.sleep(4000);

//	verifyTextcontainslistByXpath(".//li[@class='list-group-item']//p[@class='prime']/span[2]",getrefnumer);
	Thread.sleep(4000);

		verifyTextMatchlistByXpath("(.//p[text()='"+RequestStatusValue+"'])[1]",status);
		
		
		defaultcontent();
		return this;
			}
			
	
	
	

}
