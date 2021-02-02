package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class SaabCorporateAdminHomePage extends ProjectWrapp{
	public  SaabCorporateAdminHomePage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}

	public SaabCorporateAdminHomePage enterUsernameID(String Username){
		String userid= Username;   
		userid = userid.replaceAll("[^a-zA-Z0-9]", " ");  
		
		String usernamevalue = userid .replaceAll("\\s", "");
		
		enterByXpathExplict(prop.getProperty("Enter.Username.xpath"),usernamevalue);
		return this;
	}
	
	
	public SaabCorporateAdminHomePage enterPassword(String Password){
		enterByXpathExplict(prop.getProperty("Enter.Password.xpath"),Password);
		return this;

	}

	public SaabCorporateRequestPage clickLoginButtonFinal(){
		clickByXpathExplict(prop.getProperty("corporate.admin.click.login.button.xpath"));
		return new SaabCorporateRequestPage(driver, test);
	}
		
	
	
	
	
	
}