package pages;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class SaabHomePage extends ProjectWrapp{
	public  SaabHomePage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
		

	}
	
	public SaabHomePage verifyLoginFail(){
		verifyTextByXpathExplicitwait(prop.getProperty("login.fail.message.xpath"),"Unable to login, please verify that your  User ID and Password is correct.");

				return this;
			}	
	public SaabHomePage enterGroupID(String GroupId) throws InterruptedException{

		
//		Boolean a=VerifyElementpresentreturn(prop.getProperty("Enter.Group.xpath"));
		Boolean a=driver.getPageSource().contains("Login");
		
		if(a){
			
		}

		else{
			
			getnewurl();
//			Thread.sleep(20000);
			//Boolean b=VerifyElementpresentreturn(prop.getProperty("Enter.Group.xpath"));
			Boolean b=driver.getPageSource().contains("Login");
			
			
			booleanLogoutNoElementResult(b,"Login page has displaying Blank Page");
			
		}
	
		
			
//Boolean a=VerifyElementpresentreturn(prop.getProperty("Enter.Group.xpath"));
//
//booleanLogoutNoElementResult(a,"Login page has displaying Blank Page");
		enterByXpathExplict(prop.getProperty("Enter.Group.xpath"),GroupId);
		return this;
	}
	
	public SaabHomePage enterUsernameID(String Username){
		String userid= Username;   
		userid = userid.replaceAll("[^a-zA-Z0-9]", " ");  
		
		String usernamevalue = userid .replaceAll("\\s", "");
		
		enterByXpathExplict(prop.getProperty("Enter.Username.xpath"),usernamevalue);
		return this;
	}
	
	public SabbLoginPage clickLoginButton(){
		clickByXpathExplict(prop.getProperty("click.loginButton.xpath"));
		return new SabbLoginPage(driver,test);
	}
		
	public SaabHomePage invalidLogin(){
		clickByXpathExplict(prop.getProperty("click.loginButton.xpath"));
		return this;
	}
	
	
	public SaabHomePage verifyError(String loginerror){
		verifyTextContainsByXpath(prop.getProperty("verify.login.error.xpath"),loginerror);
		
				return this;
	}
	
}
