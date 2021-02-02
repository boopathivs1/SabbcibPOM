package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class SabbDashboard extends ProjectWrapp{
	public  SabbDashboard (RemoteWebDriver driver, ExtentTest test){
	this.driver = driver;
		this.test = test;
//		if(!verifyTitle("Corporate Customer Banking")){
//			reportStep("This is not Corporate Customer Banking", "FAIL");
//		}
	}
	

public DateLine clickAccountMenu() throws InterruptedException{
	//Thread.sleep(20000);
	

	clickByXpathExplict(prop.getProperty("Click.AccountMenu.xpath"));
	//locateFrame("icanvas");
	return new DateLine(driver, test);
	
}

public Alfairs_Page clickAlfairs() throws InterruptedException{
	//Thread.sleep(20000);
	
	clickByXpathExplict(prop.getProperty("click.alfairs.xpath"));
	//locateFrame("icanvas");
	return new Alfairs_Page(driver, test);
	
}

public AdminDatelinePage clickAdmin(){
	clickByXpathExplict(prop.getProperty("Click.Adminmodule.Menu.xpath"));
	//locateFrame("icanvas");
	
	
	
	return new AdminDatelinePage(driver, test);
	
}
//




public MOI clickMoiMenu(){
	
	
	clickByXpathExplict(prop.getProperty("click.moi.menu.xpath"));
	
	
	//locateFrame("icanvas");
	return new MOI(driver, test);
	
}



public SabbDashboard verifybellicon() throws InterruptedException{
	
	
	Thread.sleep(4000);
	
	clickByXpathExplict(prop.getProperty("click.user.notify.xpath"));
	
	
	Thread.sleep(6000);
	

	
//belliconFail(".//p[contains(text(),'"+getrefnumer+"')]");
	clickByXpathExplict(prop.getProperty("click.buttonclosepopup.xpath"));
	
	Thread.sleep(6000);

	return this;
	
}



public DateLine clickAccount(){
	clickByXpathExplict(prop.getProperty("Click.AccountMenu.xpath"));
	return new DateLine(driver, test);
	
}

public NewDepositRequestpage clickAccountDeposit(){
	clickByXpathExplict(prop.getProperty("Click.AccountMenu.xpath"));
	return new NewDepositRequestpage(driver, test);
	
}

public RequestsStatus AccountRequestPage(){
	clickByXpathExplict(prop.getProperty("Click.AccountMenu.xpath"));
	return new RequestsStatus(driver, test);
	
}

public AdminDateline clickAdminMenu(){
	clickByXpathExplict(prop.getProperty("Click.Admin.Menu.xpath"));
	//locateFrame("icanvas");
	return new AdminDateline(driver, test);
}

public PaymentsPage clickpaymentMenu(){
	clickByXpathExplict(prop.getProperty("Click.payment.Menu.xpath"));
	//locateFrame("icanvas");
	return new PaymentsPage(driver, test);
}






public SADADPage clickSadadMenu(){
	clickByXpathExplict(prop.getProperty("Click.sadad.menu.xpath"));
	//locateFrame("icanvas");
	return new SADADPage(driver, test);
}




public Transfer_History clickpaymentMenuTransferPage(){
	clickByXpathExplict(prop.getProperty("Click.payment.Menu.xpath"));
	//locateFrame("icanvas");
	return new Transfer_History(driver, test);

}






}

