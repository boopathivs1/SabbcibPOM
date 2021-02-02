package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class Paymentdateline extends ProjectWrapp{
	public  Paymentdateline(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
			this.test = test;
		//	if(!verifyTitle("Corporate Customer Banking  ")){
			//	reportStep("This is not Corporate Customer Banking", "FAIL");
		//	}
		}

	
	
	public Paymentdateline clickpaymentdatelinemenu() throws InterruptedException{
		clickByXpath(prop.getProperty("click.payment.dateline.menu.xpath"));
		//FilterVerification("click.payment.dateline.menu.xpath",prop.getProperty("Click.RequestStatusPending.Value.Xpath"),getrefnumer,"Pending"); 
		return this;
	}

	public Paymentdateline datelinefilter(String filtertype,String filtervalue,String filterstatustype,String FilterStatusvalue,String refno,String status) throws InterruptedException{
		Thread.sleep(8000);
		locateFrame("icanvas");

	FilterSelectVerification(filtertype,filtervalue,filterstatustype,FilterStatusvalue, refno,status);
return this;
	}

	
	public Paymentdateline locatingframe() throws InterruptedException{
		Thread.sleep(15000);
		locateFrame("icanvas");
return this;
	}
	public PaymentsReports navigatepayreport(){
		
		return new PaymentsReports(driver, test);	
	}
	public MOIReportsPage navigatemoipayreport(){
		
		return new MOIReportsPage(driver, test);	
	}
	
	
public Paymentdateline verifypaymentbuzz(String auth1,String auth2) throws InterruptedException{
	Thread.sleep(3000);
	
	clickBuzz(auth1,auth2);
	return this;
}

public Paymentdateline authorization() throws InterruptedException{
authorizeRequest();
	
//	authorizefromDatelineRequest();
	defaultcontent();
	Thread.sleep(4000);
	return this;
}
	



public Paymentdateline authorization_FundTransfer() throws InterruptedException{
//authorizeRequest();
authorizeRequest_fundTrans();

	
//	authorizefromDatelineRequest();
	defaultcontent();
	Thread.sleep(4000);
	return this;
}



public Paymentdateline authorizationLocalTransfer() throws InterruptedException{
authorizeRequestLocalTransfer();
	
//	authorizefromDatelineRequest();
	defaultcontent();
	Thread.sleep(4000);
	return this;
}





public Paymentdateline authorizationfromDateline() throws InterruptedException{
	Thread.sleep(3000);

	//authorizeRequest();
	
	authorizefromDatelineRequest();
	defaultcontent();
	Thread.sleep(5000);

	return this;
}
	
	
public StatementPage navigateStatementpage(){
	
	return new StatementPage(driver, test);
}
	
	

public PaymentsPage navigatevendorPaymentspage(){
	
	return new PaymentsPage(driver, test);
}
	
	
	
	
}