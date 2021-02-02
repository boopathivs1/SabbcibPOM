package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import freemarker.core.ReturnInstruction.Return;
import wrappers.ProjectWrapp;

public class StatementPage extends ProjectWrapp{
	public  StatementPage (RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
			this.test = test;
			if(!verifyTitle("Corporate Customer Banking")){
			
				reportStep("This is not Corporate Customer Banking", "FAIL");
			}
		}
	public StatementPage  verifystatementpage(String statAccno) throws InterruptedException{
		locateFrame("icanvas");	
//		Thread.sleep(3000);

	//	clickByXpathExplict(prop.getProperty("Click.Menu.Statement.xpath"));
		clickByXpathExplict(prop.getProperty("Click.Statement.Account.dropdown.xpath"));
		//Thread.sleep(3000);
		clickByXpathExplict(".//li[contains(@class,'active-result')][contains(text(),'"+statAccno+"')]");	

//		clickByXpathExplict(".//li[contains(@class,'active-result')][contains(text(),'"+statAccno+"')]");	
		VerifyElementPresent(prop.getProperty("verify.StatementPage.result.xpath"),"Statement details has been displaying" ,"Statement details has not been displaying");
//defaultcontent();		
return this;
	}	
	
	public NewDepositRequestpage  statementpageBalance() throws InterruptedException{
		Thread.sleep(2000);
StatementBalanceAmount=getTextByXpath(prop.getProperty("statement.pages.balance.xpath"));
defaultcontent();
		return new NewDepositRequestpage(driver, test);
	}
	
	
	
	public StatementPage  finalstatementpageBalance() throws InterruptedException{
//		Thread.sleep(4000);
		finalBalanceAmount=getTextByXpath(prop.getProperty("statement.pages.balance.xpath"));
		defaultcontent();
	//	comparevalues(StatementBalanceAmount, finalBalanceAmount,"Balance has deducted properly","Balance has not deducted properly");
		
		return this;
		
			}
		
		
public	StatementPage getbalanceamnt() throws InterruptedException{
	Thread.sleep(5000);

	
	StatementBalanceAmount=getTextByXpath("(.//span[contains(@class,'lead')]/span)[2]");

defaultcontent();

		return this;
	}


public StatementPage switchdefaultcontent(){

defaultcontent();
return this; 
}



public SabbDashboard clicktooltip(){
	clickByXpathExplict(prop.getProperty("click.home.tooltip.xpath"));
return new SabbDashboard(driver, test); 
}


	public StatementPage  dowmloadMailoptionsExcel(String options,String Accno) throws InterruptedException{
		Thread.sleep(5000);

		
		locateFrame("icanvas");	

		clickByXpathExplict(prop.getProperty("Click.Statement.Account.dropdown.xpath"));
//		clickByXpathExplict(".//li[contains(@class,'active-result')][text()='SASABB242003333001 - SAR - Current']");		

		clickByXpathExplict(".//li[contains(@class,'active-result')][contains(text(),'"+Accno+"')]");		
		
		
		Thread.sleep(12000);
		if(options.equalsIgnoreCase("Mail")){
	pageScroll();
	Thread.sleep(6000);
	
	
	
	clickByXpathExplict(prop.getProperty("click.mail.send.xpath"));

		}
		else if (options.equalsIgnoreCase("DownloadFiles")) {
			pageScroll();
	
	Thread.sleep(16000);
			clickByXpathExplict(prop.getProperty("click.download.btn.xpath"));
			clickByXpathExplict(prop.getProperty("click.pdf.xpath"));
			pageScroll();
			Thread.sleep(16000);
			clickByXpathExplict(prop.getProperty("click.download.btn.xpath"));
			clickByXpathExplict(prop.getProperty("click.xlsx.xpath"));
		}
		defaultcontent();
	return this;
	}
	
	

	public StatementPage  statementTabVerify(String statement) throws InterruptedException{
		if(statement.contains("Mini Statement")){
			//clickByXpath(".//ul[contains(@class,'nav-tabs')]//li/a[contains(text(),'Mini Statement')]");
	//		Thread.sleep(20000);
			//verifybyAttributesPreselectxpath("(.//ul[contains(@class,'nav-tabs')]//li)[1]", "class", "active","Mini statement tab is now active","Mini statement tab is not active");
			verifybyAttributesPreselectxpath(prop.getProperty("Statement.VerifyMiniStatement.Tab.xpath"), "class", "active","Mini statement tab is now active","Mini statement tab is not active");
			
			
			
			
		}
		else if (statement.contains("Current Month")) {
			
//			Thread.sleep(15000);
			
			//Statement.VerifycurrentMonth.Tab.xpath
			
			clickByXpathExplict(prop.getProperty("Statement.clickcurrentMonth.Tab.xpath"));
		//	Thread.sleep(20000);
			
//			clickByXpath(".//ul[contains(@class,'nav-tabs')]//li/a[contains(text(),'Current Month')]");
//			verifybyAttributesPreselectxpath("(.//ul[contains(@class,'nav-tabs')]//li)[2]", "class", "active","Current Month tab is now active","Current Month tab is not active");

			verifybyAttributesPreselectxpath(prop.getProperty("Statement.VerifycurrentMonth.Tab.xpath"), "class", "active","Current Month tab is now active","Current Month tab is not active");
			
			
			
		}
		else if (statement.contains("Previous Month")) {
			//Thread.sleep(15000);			
			clickByXpathExplict(prop.getProperty("click.previousmonth.xpath"));
		Thread.sleep(5000);
			verifybyAttributesPreselectxpath(prop.getProperty("verify.previousmonth.tab.xpath"), "class", "active","Previous Month tab is now active","Previous Month tab is not active");

		}			
			
		else if (statement.contains("Last Three Month")) {
clickByXpathExplict(prop.getProperty("click.LastThreemonth.xpath"));

			verifybyAttributesPreselectxpath(prop.getProperty("verify.LastThreemonth.tab.xpath"), "class", "active","Previous Month tab is now active","Previous Month tab is not active");
		}			
		else if (statement.contains("More")) {
			
			clickByXpathExplict(prop.getProperty("click.morebutton.xpath"));
			
			verifybyAttributesPreselectxpath(prop.getProperty("verify.morelink.active.xpath"), "class", "active","More tab is now active","More tab is not active");
			enterByXpathExplict(prop.getProperty("enter.fromamount.xpath"),"10");
			enterByXpathExplict(prop.getProperty("enter.toamount.xpath"),"1000");
			enterByXpathExplict(prop.getProperty("enter.fromDate.xpath"),"01/11/2020");

enterByXpathExplict(prop.getProperty("enter.toDate.xpath"),"08/01/2021");
clickByXpath(prop.getProperty("click.morefilter.button.xpath"));

		VerifyElementPresent(prop.getProperty("verify.filterresult.xpath"), "Filter Working Properly in statement page", "Filter Working not  Properly in statement page");	
		
		}
		return this;

}}
