package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class SaabCorporateRequestPage extends ProjectWrapp{
	public  SaabCorporateRequestPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}
	
	
	public CorporateAdminUsersPage clickUsersmenu(){
		defaultcontent();
		clickByXpathExplict(prop.getProperty("click.users.menu.xpath"));
		clickByXpathExplict(prop.getProperty("click.usersSubmenu.xpath"));
		return new CorporateAdminUsersPage(driver,test);
	}
	
	
	public SaabCorporateRequestPage filterRequestFromAdminDateline(String selectType,String status) throws InterruptedException{
		locateFrame("icanvas");
Thread.sleep(8000);
		dropdownSelection(prop.getProperty("paymentdd.selecttype.xpath"),selectType);
		
dropdownSelection(prop.getProperty("payment.status.xpath"),status);
clickByXpathExplict(prop.getProperty("click.filter.admindeateline.xpath"));

Thread.sleep(4000);
		return this;
	}
	
	
	public SaabCorporateRequestPage verifyDatelineRequestADMINLogin(String ReferenceNumStatus) throws InterruptedException{
	
	verifyTextlistcontainXpath(prop.getProperty("Filter.DepositReferno.xpath"),getrefnumer);
	if(ReferenceNumStatus.equalsIgnoreCase("Accepted")){
	verifyTextcontainslistByXpath(prop.getProperty("Filter.status.checkingAccepted.Status.xpath"),ReferenceNumStatus);
//	verifyTextcontainslistByXpath(prop.getProperty("Filter.status.checkingAccepted.Status.xpath"),ReferenceNumStatus);
	
		int a=getSizeByXpath(prop.getProperty("Filter.status.checkingAccepted.Status.xpath"));
	
		verifyTextsizecontainslistByXpath(prop.getProperty("Filter.status.checkingAccepted.Status.xpath"),a);
	}
	
	
		
		return this;
	}
	public SaabCorporateRequestPage authorization() throws InterruptedException{
//		authorizeRequest();
		CorporateAdminAuthorizeRequest();
//			authorizefromDatelineRequest();
			defaultcontent();
			Thread.sleep(20000);

			return this;
		}

	
	
	public SaabCorporateRequestPage datelineAuthorization() throws InterruptedException{
//		authorizeRequest();
	//	CorporateAdminAuthorizeRequest();
	authorizefromDatelineRequest();
			defaultcontent();
			Thread.sleep(20000);

			return this;
		}

	public SaabCorporateRequestPage datelinefromAuthorization() throws InterruptedException{
//		authorizeRequest();
	//	CorporateAdminAuthorizeRequest();
	authorizefromDatelineRequest();
			defaultcontent();
			Thread.sleep(20000);

			return this;
		}

	
	
	
	
	
	public SaabCorporateRequestPage verifyAdminbuzz(String auth1,String auth2,String datelinekeyword) throws InterruptedException{
		Thread.sleep(3000);
		
		String userid1= auth1;   
		userid1 = userid1.replaceAll("[^a-zA-Z0-9]", " ");  	
		String usernamevalue1 = userid1 .replaceAll("\\s", "");
	
		String userid2= auth2;   
		userid2 = userid2.replaceAll("[^a-zA-Z0-9]", " ");  
		
		String usernamevalue2 = userid2 .replaceAll("\\s", "");
	
	
		AdminDatelinePageBuzz(usernamevalue1,usernamevalue2,datelinekeyword);
		return this;
	}
	
	
	
	public SaabCorporateRequestPage admin_datelineAuthorization() throws InterruptedException{
//		authorizeRequest();
	//	CorporateAdminAuthorizeRequest();
	authorizefromDatelineRequest_admin();
			defaultcontent();
			Thread.sleep(20000);

			return this;
		}

	
}
