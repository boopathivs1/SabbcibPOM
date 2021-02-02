package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class MOI extends ProjectWrapp{
	public MOI(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}
	
	public MOIReportsPage clickmoireportslink(){
		
		clickByXpathExplict(prop.getProperty("click.moireports.link.xpath"));
return new MOIReportsPage(driver, test);
	}

public Paymentdateline navigatepaymentDateline() throws InterruptedException{
return new Paymentdateline(driver, test);
}
	
	public MOI clickMoigovernmentServicesMenu(){
		clickByXpathExplict(prop.getProperty("click.government.services.xpath"));
	//	pageloadtimeOut();
		//locateFrame("icanvas");
		return this;
		
	}

	public OtP_Page moiRefundFormFill(String TransType,String moiservices,String servicetype,String corporate,String Account,String citizenid) throws InterruptedException{
		locateFrame("icanvas");
//moitransaction.dropdown.xpath

//moiservicesid.xpath
//moi.servicetype.xpath
	//	Thread.sleep(3000);
		dropdownSelection(prop.getProperty("moitransaction.dropdown.xpath"),TransType);
		//Thread.sleep(3000);
		dropdownSelection(prop.getProperty("moiservicesid.xpath"),moiservices);
	//	Thread.sleep(3000);
		dropdownSelection(prop.getProperty("moi.servicetype.xpath"),servicetype);
		//Thread.sleep(2000);
		dropdownSelection(prop.getProperty("select.corpaddbill.xpath"),corporate);
	//	Thread.sleep(2000);
		dropdownSelection(prop.getProperty("acc.choose.onetime.pay.xpath"),Account);
//		Thread.sleep(2000);
		String citizennumber=citizenid;   
		citizennumber= citizennumber.replaceAll("[^a-zA-Z0-9]", " ");  
		String citizenvalue =citizennumber .replaceAll("\\s", "");
		enterByXpathExplict(prop.getProperty("moi.citizen.id.enter.xpath"),citizenvalue);
		Thread.sleep(4000);
		clickByXpathExplict(prop.getProperty("click.Moi.verify.button.xpath"));
	

Boolean a=VerifyElementpresentreturn(prop.getProperty("moi.refund.server.issue.xpath"));
booleanResult(a, "MOI Server Issue-L33 : ERROR DUE TECHNICAL REASON");	
		return new OtP_Page(driver, test);
		
	}
	
	public OtP_Page moiPaymentFormFill(String TransType,String moiservices,String servicetype,String corporate,String Account,String violatorid,String issuingid,String CategoryName) throws InterruptedException{
		locateFrame("icanvas");
//moitransaction.dropdown.xpath

//moiservicesid.xpath
//moi.servicetype.xpath
//	Thread.sleep(3000);
		//pageloadtimeOut();
		dropdownSelection(prop.getProperty("moitransaction.dropdown.xpath"),TransType);
	//	Thread.sleep(3000);
		dropdownSelection(prop.getProperty("moiservicesid.xpath"),moiservices);
		//Thread.sleep(3000);
		dropdownSelection(prop.getProperty("moi.servicetype.xpath"),servicetype);
//		Thread.sleep(2000);
		dropdownSelection(prop.getProperty("select.corpaddbill.xpath"),corporate);
	//	Thread.sleep(2000);
		dropdownSelection(prop.getProperty("acc.choose.onetime.pay.xpath"),Account);
		//Thread.sleep(2000);
		String citizennumber= violatorid;   
		citizennumber= citizennumber.replaceAll("[^a-zA-Z0-9]", " ");  
		String citizenvalue =citizennumber .replaceAll("\\s", "");
		enterByXpathExplict(prop.getProperty("enter.violator.xpath"),violatorid);
		//Thread.sleep(10000);
		
		dropdownSelection(prop.getProperty("select.issuing.entity.xpath"),issuingid);
		//Thread.sleep(8000);
		
		dropdownSelection(prop.getProperty("payment.select.category.xpath"),CategoryName);
		//Thread.sleep(4000);
		
		
		clickByXpathExplict(prop.getProperty("click.Moi.verify.button.xpath"));
		
		Boolean a=VerifyElementpresentreturn(prop.getProperty("moi.refund.server.issue.xpath"));
		booleanResult(a, "MOI Server Issue-L33 : ERROR DUE TECHNICAL REASON");	

		return new OtP_Page(driver, test);
		
	}
	
	
	
	
	
}
