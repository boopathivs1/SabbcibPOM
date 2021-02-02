package pages;

import org.apache.xerces.util.SynchronizedSymbolTable;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class SabbLoginPage extends ProjectWrapp{
	public  SabbLoginPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}
	
public SabbLoginPage enterPassword(String Password) throws InterruptedException{
//	Thread.sleep(4000);
		enterByXpathExplict(prop.getProperty("Enter.Password.xpath"),Password);
		return this;
	}
	
	public SabbLoginPage clickSecureimage() throws InterruptedException{
		Thread.sleep(2000);
		//clickByXpathExplict(prop.getProperty("Click.Secureimagesecoption.xpath"));
		
		
		clickJs(prop.getProperty("Click.Secureimagesecoption.xpath"));
		
		return this;
	}
	public OtP_Page clickLoginButtonFinal() throws InterruptedException{
		pageScroll400();
		//Thread.sleep(2000);
		

	//	scrolltoelementJs(prop.getProperty("Click.loginButtonFinal.xpath"));
	//	Thread.sleep(4000);
		
		clickByXpathwait(prop.getProperty("Click.loginButtonFinal.xpath"));
		try {
			readytimes();
			readystate();
			jqueryload();
		} catch (InterruptedException e1) {
		}
		Boolean a=driver.getPageSource().contains("OTP");

//		Boolean a=VerifyElementpresentreturn(prop.getProperty("Enter.token.xpath"));

		if(!a){
			Boolean b=VerifyElementWARNreturn(prop.getProperty("previos.session.verify.xpath"));
			LogoutbooleanResult(b, "Your Previous Session is still active. Try after 5 minutes");	
		}
		
		
	//	Thread.sleep(3000);
		
		return new OtP_Page(driver,test);
	}
	
		
	public SabbLoginPage clickLoginButtonFail(){
		clickByXpathExplict(prop.getProperty("Click.loginButtonFinal.xpath"));
		return this;
	}		
		
			
	
	
	
			
			

}
