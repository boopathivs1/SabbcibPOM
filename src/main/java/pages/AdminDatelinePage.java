package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class AdminDatelinePage extends ProjectWrapp{
	public  AdminDatelinePage (RemoteWebDriver driver, ExtentTest test){
	this.driver = driver;
		this.test = test;
	//	if(!verifyTitle("Corporate Customer Banking  ")){
		//	reportStep("This is not Corporate Customer Banking", "FAIL");
	//	}
	}
	public AdminDatelinePage authorization() throws InterruptedException{
		authorizeRequest();
			
		//	authorizefromDatelineRequest();
			defaultcontent();
			Thread.sleep(20000);

			return this;
		}

	
	public AdminDatelinePage authorizationDateline() throws InterruptedException{
		//authorizeRequest();
			
			authorizefromDatelineRequest();
			defaultcontent();
			Thread.sleep(20000);

			return this;
		}

	
	public AdminDatelinePage datelinefilter(String filtertype,String filtervalue,String filterstatustype,String FilterStatusvalue,String refno,String status) throws InterruptedException{
		Thread.sleep(15000);
		locateFrame("icanvas");

	FilterSelectVerification(filtertype,filtervalue,filterstatustype,FilterStatusvalue, refno,status);
return this;
	}

	public Userspage clickUsersPage() throws InterruptedException{
	Thread.sleep(4000);
		defaultcontent();
		clickByXpathExplict(prop.getProperty("Click.UserMenu.xpath"));
		//locateFrame("icanvas");
		return new Userspage(driver, test);
		
	}

public AdminDatelinePage locateframe(){	
	locateFrame("icanvas");
return this;
}
	public MatrixPage clickMatrixPage() throws InterruptedException{
		Thread.sleep(4000);
			defaultcontent();
			clickByXpathExplict(prop.getProperty("Click.Matrix.Menu.xpath"));
			//locateFrame("icanvas");
			return new MatrixPage(driver, test);
			
		}
		
		
	
	
	
		
	
	
	
	
	public AdminDatelinePage verifyAdminbuzz(String auth1,String auth2,String datelinekeyword) throws InterruptedException{
		Thread.sleep(3000);
		
		AdminDatelinePageBuzz(auth1, auth2,datelinekeyword);
		return this;
	}

	
	
	

}
