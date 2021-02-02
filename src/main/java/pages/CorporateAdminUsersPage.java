package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class CorporateAdminUsersPage extends ProjectWrapp{
	public CorporateAdminUsersPage(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		
	}

	

	public CorporateAdminUsersPage filterGroup() throws InterruptedException{
		
		locateFrame("icanvas");

		dropdownSelection(prop.getProperty("select.corporate.admin.groupid.xpath"),"Group ID");
				enterByXpathExplict(prop.getProperty("enter.groupid.corporate.xpath"),"CLAYFINQA");
				clickByXpathExplict(prop.getProperty("click.corporate.groupfilteradmin.xpath"));
				
				
				
				//clickByXpathExplict(prop.getProperty("click.users.menu.xpath"));
				//clickByXpathExplict(prop.getProperty("click.usersSubmenu.xpath"));
				return this;
			}
			


		public CorporateAdminUsersPage verifyGroupIdpresent(String elementpresent,String groupid,String xpath) throws InterruptedException{
		////edit		
				
				for(int i=1;i<100;i++){
		boolean a=VerifyElementpresentreturn(elementpresent);
		reportStep("account number has present in this page", "PASS");
		if(a){
			reportStep(""+groupid+" has been diplaying in this page", "PASS");
			clickByXpathExplict(xpath);
			
			break;
		}
		else {
			int c=i+1;
			reportStep(""+groupid+" User account  has not been diplaying in this page", "INFO");

			reportStep(""+groupid+" trying find account number in another page number", "INFO");
			boolean b=VerifyElementpresentreturn(".//ul[@class='pagination']//a[text()='"+c+"']");
			if(b){
			clickByXpathExplict(".//ul[@class='pagination']//a[text()='"+c+"']");
			Thread.sleep(4000);
			}
			else {
				reportStep(""+groupid+" Account number has not diplaying in this page", "FAIL");
				break;
			}
		}
		}
		return this;
		}
		public CorporateAdminUsersPage updateExpiryid(){
			
			
			return this;
		}


		
		public CorporateAdminUsersPage clickUsersEditLink(String userid){
			clickByXpathExplict("(.//strong[contains(text(),'User ID')]/following::span[text()='"+userid+"']//following::span[text()='Edit'])[1]");
			
			return this;
		}
		
		public CorporateAdminUsersPage updateExpiry() throws InterruptedException{
			Thread.sleep(6000);
			clickByXpathExplict(prop.getProperty("click.calendar.icon.expirydate.xpath"));
			Thread.sleep(8000);
			//clickByXpathExplict(prop.getProperty("click.calendar.year.expiry.xpath"));
			Thread.sleep(2000);
			//clickByXpathExplict(prop.getProperty("click.calendar.icon.expirymonth.xpath"));
			Thread.sleep(2000);
			clickByXpathExplict(prop.getProperty("click.calendar.icon.expiryupdatedate.xpath"));
Thread.sleep(4000);
			clickByXpathExplict(prop.getProperty("click.admin.edit.expirysubmit.xpath"));

			Thread.sleep(15000);
			
			
			return this;
		}
		
		public SaabCorporateRequestPage  clicksaabCorporateRequestPage(){
		defaultcontent();
		
		clickByXpathExplict(prop.getProperty("click.saabCorporate.AdminRequest.page.xpath"));

		return new SaabCorporateRequestPage(driver, test);
		}

		public CorporateAdminUsersPage corporateUsersFilter(String userid,String status,String searchKeyword,String searchenable) throws InterruptedException{
//		locateFrame("icanvas");
		dropdownSelection(prop.getProperty("select.usersearch.xpath"),userid);
		dropdownSelection(prop.getProperty("select.usersearchStatus.xpath"),status);
		if(searchenable.equalsIgnoreCase("true")){
		enterByXpathExplict(prop.getProperty("enter.inputsearchkeyword.xpath"),searchKeyword);
		}
		clickByXpathExplict(prop.getProperty("click.filter.user.adminlog.xpath"));
		
			return this;
			}

		
		
		
		

}




