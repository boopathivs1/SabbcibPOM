package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class DetailPage extends ProjectWrapp{
	public  DetailPage (RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
			this.test = test;
			if(!verifyTitle("Corporate Customer Banking")){
				reportStep("This is not Corporate Customer Banking", "FAIL");
			}
				}
	


	public DetailPage verifyDetailPage(String detailAccno) throws InterruptedException{
		locateFrame("icanvas");	
		clickByXpathExplict(prop.getProperty("Click.Statement.Account.dropdown.xpath"));
//		clickByXpathExplict(prop.getProperty(".//li[contains(@class,'active-result')][contains(text(),'"+detailAccno+"')]"));

		Thread.sleep(3000);
		clickByXpathExplict(".//li[contains(@class,'active-result')][contains(text(),'"+detailAccno+"')]");	

		
		//		Select.Statement.AccountNumber.xpath=.//li[contains(@class,'active-result')][text()='SASABB242003333001 - SAR - Current']

VerifyElementPresent(prop.getProperty("detail.content.verify.xpath"),"Details page has been displaying" ,"Details Page has not been displaying");

//Thread.sleep(20000);

defaultcontent();		
return this;
	}	
	
	
	
	
	public DetailPage	VerifyAccountStatement(String accno,String ServiceReq) throws InterruptedException
	
	{
		locateFrame("icanvas");	
		clickByXpathExplict(prop.getProperty("Click.Statement.Account.dropdown.xpath"));
		Thread.sleep(3000);
		clickByXpathExplict(".//li[contains(@class,'active-result')][contains(text(),'"+accno+"')]");	
		Thread.sleep(3000);
		clickByXpathExplict(prop.getProperty("Click.Statement.Account.ServiceReq.dropdown.xpath"));
		Thread.sleep(3000);
		
		
		clickByXpathExplict(".//li[contains(@class,'active-result')][contains(text(),'"+ServiceReq+"')]");
		
		VerifyElementPresent(prop.getProperty("verify.account.requestpage.xpath"),"Account Request page has been displaying" ,"Account Request Page has not been displaying");
		return this;
	}
	
	

	public DetailPage addNickname(String Acc,String nickname) throws InterruptedException{
		locateFrame("icanvas");	
		//add accc drop
		clickByXpathExplict(prop.getProperty("Click.Statement.Account.dropdown.xpath"));
		
		
		clickByXpathExplict(".//li[contains(@class,'active-result')][contains(text(),'"+Acc+"')]");
			//	Thread.sleep(16000);
		
	Boolean a=VerifyElementpresentreturn(prop.getProperty("click.clear.nickname.xpath"));	
			if(a){
				clickByXpathExplict(prop.getProperty("click.clear.nickname.xpath"));
				
			}
				
				
		clickByXpathExplict(prop.getProperty("button.edit.xpath"));
		
		
		
String Nickname=Data("Testsss");
enterByXpathExplict(prop.getProperty("input.edit.xpath"), nickname);
Thread.sleep(4000);

clickByXpathExplict(prop.getProperty("btn.nickname.update.xpath"));

verifyTextByXpathExplicitwait(prop.getProperty("verify.nickname.update.xpath"),nickname);

Thread.sleep(4000);

clickByXpathExplict(prop.getProperty("click.clear.nickname.xpath"));


clickByXpathExplict(prop.getProperty("button.edit.xpath"));

enterByXpathExplict(prop.getProperty("input.edit.xpath"), Acc);
clickByXpathExplict(prop.getProperty("btn.nickname.update.xpath"));

verifyTextByXpathExplicitwait(prop.getProperty("verify.nickname.update.xpath"),Acc);



return this;
	}


	public DateLine addatags(String accno) throws InterruptedException{
		locateFrame("icanvas");	
		
		clickByXpathExplict(prop.getProperty("Click.Statement.Account.dropdown.xpath"));
clickByXpathExplict(".//ul[@class='chosen-results']/li[contains(text(),'"+accno+"')]");
//Thread.sleep(15000);
		//add account drop
	datatag=	Data("testhas");
	Thread.sleep(4000);

	
Boolean a=VerifyElementpresentreturn("(.//span[contains(@class,'glyphicon-remove')])[1]");
	
if(a){	
//	Thread.sleep(4000);
	clickByXpathExplict("(.//span[contains(@class,'glyphicon-remove')])[1]");
}
	
enterByXpathExplict(prop.getProperty("enter.tagname.xpath"),datatag);

clickByXpathExplict(prop.getProperty("tagsubmit.button.xpath"));


Thread.sleep(2000);

defaultcontent();
return new DateLine(driver, test);
	}


}