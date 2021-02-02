package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class EstatPage extends ProjectWrapp{
	public  EstatPage (RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
			this.test = test;
			if(!verifyTitle("Corporate Customer Banking")){
				reportStep("This is not Corporate Customer Banking", "FAIL");
			}
				}
	


	
	public EstatPage  verifystatementpage(String statAccno,String month) throws InterruptedException{
		locateFrame("icanvas");	
//		Thread.sleep(3000);

	//	clickByXpathExplict(prop.getProperty("Click.Menu.Statement.xpath"));
		clickByXpathExplict(prop.getProperty("Click.Statement.Account.dropdown.xpath"));
		//Thread.sleep(3000);
		clickByXpathExplict(".//li[contains(@class,'active-result')][contains(text(),'"+statAccno+"')]");	

//		clickByXpathExplict(".//li[contains(@class,'active-result')][contains(text(),'"+statAccno+"')]");	
	
		dropdownSelection(prop.getProperty("click.estatmonthselection.xpath"), month);

Thread.sleep(6000);
Boolean a=driver.getPageSource().contains("No Statements");
if(a){
reportStep("Estatement has been displaying","FAIL");
}
else{
	reportStep("Estatement has been displaying","PASS");
}

//		VerifyElementPresent(prop.getProperty("verify.StatementPage.result.xpath"),"Statement details has been displaying" ,"Statement details has not been displaying");
//defaultcontent();		
return this;
	}	
}