package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class Alfairs_Page extends ProjectWrapp{
	public  Alfairs_Page (RemoteWebDriver driver, ExtentTest test){
	this.driver = driver;
		this.test = test;
	//	if(!verifyTitle("Corporate Customer Banking  ")){
		//	reportStep("This is not Corporate Customer Banking", "FAIL");
	//	}
	}

	

public Alfairs_Page fillAlfairs(String accno) throws InterruptedException{
	//Thread.sleep(20000);

	locateFrame("icanvas");
	
	dropdownSelection(prop.getProperty("select.corpaddbill.xpath"),accno);
	clickByXpathExplict(prop.getProperty("submit.estat.xpath"));

	
	clickJsWaitLess(prop.getProperty("submit.estat.checkbox.xpath"));
	
	//clickByXpathExplict(prop.getProperty("submit.estat.checkbox.xpath"));
	
	
	clickByXpathExplict(prop.getProperty("submit.estat.ok.xpath"));
//	clickJsWaitLess(prop.getProperty("submit.estat.ok.xpath"));
windowhandlesindex(1);	

	

Boolean a=VerifyElementpresentreturn(prop.getProperty("verify.table.data.alfair.xpath"));
	
	if(a){
		reportStep("Biller Details has not been displaying","FAIL");
	}
	else{
			reportStep("Biller Details has been displaying","PASS");
	}
	
	
	
windowclose();
windowhandlesindex(0);

clickByXpathExplict(prop.getProperty("click.tooltip.dashboard.xpath"));
	
	return this;
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}