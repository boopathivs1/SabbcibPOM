package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class Transfer_History extends ProjectWrapp{
	public  Transfer_History(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
			this.test = test;
		//	if(!verifyTitle("Corporate Customer Banking  ")){
			//	reportStep("This is not Corporate Customer Banking", "FAIL");
		//	}
		}
	
	

	public Transfer_History transferHistoryMenu() throws InterruptedException{
		clickByXpathExplict(prop.getProperty("click.transferhistory.xpath"));
		
	
	
	return this;
	
	}
	public Transfer_History transferHistorychecking(String corpid,String fromacc) throws InterruptedException{
		locateFrame("icanvas");
		
		
		dropdownSelection(prop.getProperty("corpid.transferhistory.xpath"),corpid);
		Thread.sleep(1000);

		dropdownSelection(prop.getProperty("fromacc.transferhistory.choosen.xpath"),fromacc);
		
		Thread.sleep(1000);	
//		clickByXpathExplict(prop.getProperty("click.calendar.icon.xpath"));
		Thread.sleep(3000);
	//	clickByXpathExplict("(.//button[text()='Clear'])[1]");
		Thread.sleep(3000);	
		
		
		enterByXpathExplict("(.//input[contains(@class,'ws-date')])[1]","01/01/2020");
		
//		clickByXpathExplict(prop.getProperty("select.twentyyear.xpath"));
		Thread.sleep(8000);

//clickByXpathExplict(prop.getProperty("select.calendar.Janmonth.xpath"));

Thread.sleep(3000);

//clickByXpathExplict(prop.getProperty("select.requeststatus.jan.fromddate.xpath"));
		
		
		
	//	clickByXpathExplict(prop.getProperty("click.today.calendar.xpath"));
		Thread.sleep(3000);
		clickByXpathExplict(prop.getProperty("click.tocalendar.icon.xpath"));
		Thread.sleep(3000);
		clickByXpathExplict(prop.getProperty("click.todaytwo.calendar.anotherindex.xpath"));
			
		clickByXpathExplict(prop.getProperty("transfer.history.filter.xpath"));
		Thread.sleep(6000);

	VerifyElementPresent(prop.getProperty("transfer.history.table.data.xpath"),"Transfer history has displaying","Transfer history has not displaying");
		
	
	
		Thread.sleep(6000);
		return this;	
	}
	
	
	public Transfer_History transfer_History_verify(String corpid,String fromacc,String fromdate) throws InterruptedException{
		locateFrame("icanvas");
		
		
		dropdownSelection(prop.getProperty("corpid.transferhistory.xpath"),corpid);
		Thread.sleep(1000);

		dropdownSelection(prop.getProperty("fromacc.transferhistory.choosen.xpath"),fromacc);
		
		Thread.sleep(1000);	
//		clickByXpathExplict(prop.getProperty("click.calendar.icon.xpath"));
		Thread.sleep(3000);
	//	clickByXpathExplict("(.//button[text()='Clear'])[1]");
		Thread.sleep(3000);	
		
		
		enterByXpathExplict("(.//input[contains(@class,'ws-date')])[1]",fromdate);
		
//		clickByXpathExplict(prop.getProperty("select.twentyyear.xpath"));
		Thread.sleep(8000);

//clickByXpathExplict(prop.getProperty("select.calendar.Janmonth.xpath"));

Thread.sleep(3000);

//clickByXpathExplict(prop.getProperty("select.requeststatus.jan.fromddate.xpath"));
		
		
		
	//	clickByXpathExplict(prop.getProperty("click.today.calendar.xpath"));
		Thread.sleep(3000);
		clickByXpathExplict(prop.getProperty("click.tocalendar.icon.xpath"));
		Thread.sleep(3000);
		clickByXpathExplict(prop.getProperty("click.todaytwo.calendar.anotherindex.xpath"));
			
		clickByXpathExplict(prop.getProperty("transfer.history.filter.xpath"));
		Thread.sleep(6000);

	VerifyElementPresent(prop.getProperty("transfer.history.table.data.xpath"),"Transfer history has displaying","Transfer history has not displaying");
		
	
	
		Thread.sleep(6000);
		return this;	
	}

	

}
