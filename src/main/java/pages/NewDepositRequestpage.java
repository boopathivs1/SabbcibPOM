package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class NewDepositRequestpage extends ProjectWrapp{
	public  NewDepositRequestpage (RemoteWebDriver driver, ExtentTest test){
	this.driver = driver;
		this.test = test;
	//	if(!verifyTitle("Corporate Customer Banking  ")){
		//	reportStep("This is not Corporate Customer Banking", "FAIL");
	//	}
	}
	

	public NewDepositRequestpage Requestoptions() throws InterruptedException{
		clickByXpathExplict(prop.getProperty("click.requestmenus.xpath"));
return this;
	}
	
	
	public RequestsStatus Requestopt() throws InterruptedException{
		clickByXpathExplict(prop.getProperty("click.requestmenus.xpath"));
return new RequestsStatus(driver, test);
	}
	
	
	public RequestsStatus clickupdateMaturity() throws InterruptedException{
		clickByXpathExplict(prop.getProperty("click.requestmenusUpdate.maturity.xpath"));
	
	
			return new RequestsStatus(driver, test);
	}
	
	
	
			
			
	public NewDepositRequestpage fullencashprofit(String fromcomp,String fromacc,String currencyvalue,String amount) throws InterruptedException{
		//clickByXpathExplict("(.//nav[@class='singlelist']//li/a)[5]");
		clickByXpathExplict(prop.getProperty("NewDepositMenu.xpath"));
		
		

		
		
		locateFrame("icanvas");
		clickByXpathExplict(prop.getProperty("click.fromcompany.xpath"));
		
	//	.//li[contains(@class,'active-result')][contains(text(),'"+statAccno+"')]

//		Thread.sleep(5000);

		clickByXpathExplict(".//li[contains(@class,'active-result')][contains(text(),'"+fromcomp+"')]");

	//	Thread.sleep(10000);

	clickByXpathExplict(prop.getProperty("click.fromAcc.xpath"));
//	Thread.sleep(5000);

	clickByXpathExplict(".//li[contains(@class,'active-result')][contains(text(),'"+fromacc+"')]");

		//clickByXpathExplict(".//span[text()='Select Deposit Type']");
		//clickByXpathExplict(".//div[@id='depositType_chosen']");

	//	Thread.sleep(10000);
		clickByXpathExplict(prop.getProperty("NewDeposittypechoosen.xpath"));
		//Thread.sleep(10000);
		
	
		clickByXpathExplict(prop.getProperty("commoditytype.xpath"));
	//	Thread.sleep(2000);
		
//		clickByXpathExplict(".//button[text()='Close']");
//		Thread.sleep(2000);
		
	//	clickByXpathExplict("(.//div[@class='checkinput_pos'])[1]");
	//	clickByXpathExplict("(.//div[@class='checkinput_pos'])[2]");
	//	clickByXpathExplict("(.//div[@class='checkinput_pos'])[3]");

		
//		WebElement element=driver.findElement(By.xpath("/html[@class='ng-scope']/body[@class='layout-default']/main[@class='container']/form[@class='form-horizontal ng-pristine ng-valid ng-valid-required']/div[@class='row ng-scope']/div[@class='col-md-7']/div[@class='panel panel-default ng-scope']/div[@class='panel-body'][1]/div[@class='list-permission'][1]/div[@class='checkbox'][1]/label"));
//		Actions act= new Actions(driver);
//		act.moveToElement(element).click().build().perform();
//		
Thread.sleep(6000);
		WebElement element = driver.findElement(By.cssSelector(".form-group:nth-child(4) .checkinput"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", element);
		WebElement element1 = driver.findElement(By.cssSelector(".form-group:nth-child(5) .checkinput"));
		JavascriptExecutor jse1 = (JavascriptExecutor)driver;
		jse1.executeScript("arguments[0].click();", element1);
		WebElement element2 = driver.findElement(By.cssSelector(".form-group:nth-child(6) .checkinput"));
		JavascriptExecutor jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("arguments[0].click();", element2);
		pageScroll400();
//		Thread.sleep(6000);
		//clickByXpathExplict(prop.getProperty("currencytype.xpath"));
		Thread.sleep(1000);

		
		scrolltoelementJs(prop.getProperty("currencytype.xpath"));
		
		dropdownSelection(prop.getProperty("currencytype.xpath"),"USD");
		
//		Thread.sleep(8000);
				clickByXpathExplict(prop.getProperty("click.productrate.xpath"));
		
		enterByXpathExplict(prop.getProperty("click.ws.xpath"),amount);
	//	Thread.sleep(3000);
//		pageScroll400();
		
		pageScroll();
				return this;
	
	}
	

public	OtP_Page maturityOptionsNewDepositReinvestment(String maturityopt,String accno) throws InterruptedException{
//	Thread.sleep(8000);
	clickByXpathExplict(prop.getProperty("click.maturity.choosen.xpath"));
//	Thread.sleep(10000);
	
	if(maturityopt.contains("Reinvestment of investment")){
		
//		Thread.sleep(25000);
	clickByXpathExplict(prop.getProperty("click.reinvest.xpath"));
}else if(maturityopt.contains("Renew total balance"))	{
	clickByXpathExplict(prop.getProperty("click.renewtotal.xpath"));
}
else if(maturityopt.contains("Add or withdraw"))	{
//	Thread.sleep(6000);
	
	clickByXpathExplict(prop.getProperty("click.addorwithdraw.xpath"));
	enterByXpathExplict(prop.getProperty("enter.addamount.xpath"),"25000");
}
else if(maturityopt.contains("Full encashment of investment"))	{
pageScroll400();
	//Thread.sleep(8000);
clickByXpathExplict(prop.getProperty("full.encash.xpath"));
//Thread.sleep(4000);
	clickByXpathExplict(prop.getProperty("encash.transferl.xpath"));
	//clickByXpathExplict("(.//li[contains(@class,'active-result')][text()='SASABB242003333001 - CA - SAR'])[2]");
	//Thread.sleep(6000);

	clickByXpathExplict("(.//li[contains(@class,'active-result')][contains(text(),'"+accno+"')])[2]");

	pageScroll400();
	
/*
		
			
			clickByXpathExplict(".//div[@id='enchashProfitTransferAccountUUID_chosen']");

			.//div[@id='enchashProfitTransferAccountUUID_chosen']	
	
	*/
	
	
	
}
	
else	{
reportStep("deposit Maturity has not matched","FAIL");
}	
	//Thread.sleep(6000);
return new OtP_Page(driver, test);	
}

	public NewDepositRequestpage clickFilterAuthorizeButton(String FilterStatus){
		clickByXpathExplict(prop.getProperty("click.Filter.xpath"));
		clickByXpathExplict(prop.getProperty("Click.RequestType.Xpath"));
		clickByXpathExplict(prop.getProperty("Click.RequestType.Value.Xpath"));
		clickByXpathExplict(prop.getProperty("Click.RequestStatus.Xpath"));
		clickByXpathExplict(prop.getProperty("Click.RequestStatusPending.Value.Xpath"));
		clickByXpathExplict(prop.getProperty("Filter.button.xpath"));
	List<String>refno=new ArrayList<>();
	
	
	List<WebElement>a=driver.findElements(By.xpath(".//ul[contains(@class,'dateline')]//a[contains(@class,'dtln-info')]"));

	//List<WebElement>a=driver.findElements(By.xpath(".//div[@class='row']/a"));
	for(int i=0;i<a.size();i++){
		String reference=a.get(i).getAttribute("onclick");
	refno.add(reference);
	}
	
	for(int i=0;i<a.size();i++){
			
			if(a.get(i).getAttribute("onclick").contains("6999835")){
				clickByXpathExplict("(.//a[text()='Authorize'])["+i+"]");				
enterByXpathExplict(".//textarea[@id='comment']", "just testing");
enterByXpathExplict(".//input[@id='txtOTP']", "777777");
clickByXpathExplict(".//button[@id='btn2FAValidate']");				
			
			}
			
		}
		
		
		
		defaultcontent();
		return this;
	
	}
	
	
	
	
	
	
	
	
}
