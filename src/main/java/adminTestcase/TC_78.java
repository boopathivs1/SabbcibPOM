package adminTestcase;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import pages.SaabCorporateAdminHomePage;
import pages.SaabHomePage;
import wrappers.ProjectWrapp;

public class TC_78  extends ProjectWrapp
{
@BeforeClass(groups={"common"})
public void setDatag() {
	testCaseName="TC78";
	testDescription="update expiry date from admin application";	
	browserName="Chrome";
	dataSheetName="SaabCIBDev";
	category="Sanity";
	authors="Boopathi";
	testKeyword="TC78";
	LogoutStatus=true;
	usertype="CIBAdmin";

}

@Test(groups={"sanity"},dataProvider="fetch")
public void updateExpiryDate(String casename,String Username,String Password,String groupid,String userid,String auth1,String auth2,String data1,String data2,String data3,String data4,String data5,String data6,String data7,String data8,String data9,String data10,String data11,String data12,String data13,String data14) throws Exception{	

	getnewurl("https://sabbcorpdev.sabb.com/CorporateAdmin/");
	new SaabCorporateAdminHomePage(driver, test)
	.enterUsernameID(Username)
.enterPassword(Password)
.clickLoginButtonFinal()
.clickUsersmenu()
.filterGroup()
.verifyGroupIdpresent(".//strong[contains(text(),'Group ID')]/following::span[text()='"+groupid+"']","groupid","(.//strong[contains(text(),'Group ID')]/following::span[text()='"+groupid+"']//following::button/span[2])[1]")
.corporateUsersFilter("User Id","Active",userid,"true")
.verifyGroupIdpresent(".//strong[contains(text(),'User ID')]/following::span[text()='"+userid+"']","groupid","(.//strong[contains(text(),'User ID')]/following::span[text()='"+userid+"']//following::button/span[2])[1]")
.clickUsersEditLink(userid)
.updateExpiry()
.clicksaabCorporateRequestPage()
.filterRequestFromAdminDateline("Corporate User Profile Request","Pending for Authorization")
.verifyAdminbuzz(auth1,auth2, "Corporate User Profile Updation Request")
//.logout(true);
.logout(true,usertype);	

		
	//getrefnumer="DT-26109658";
	
	//AuthUsername="12904661";
	AuthUsername=auth1;

	
	getnewurl("https://sabbcorpdev.sabb.com/CorporateAdmin/");
	new SaabCorporateAdminHomePage(driver, test)
	.enterUsernameID(AuthUsername)
	.enterPassword(Password)
	.clickLoginButtonFinal()
	
	.filterRequestFromAdminDateline("Corporate User Profile Request","Pending for Authorization")
	.authorization()
	.filterRequestFromAdminDateline("Corporate User Profile Request","Accepted")
	.verifyDatelineRequestADMINLogin("Accepted")

	
	.clickUsersmenu()
	.filterGroup()
	.verifyGroupIdpresent(".//strong[contains(text(),'Group ID')]/following::span[text()='"+groupid+"']","groupid","(.//strong[contains(text(),'Group ID')]/following::span[text()='"+groupid+"']//following::button/span[2])[1]")
	.corporateUsersFilter("User Id","Active",userid,"true")
	.verifyGroupIdpresent(".//strong[contains(text(),'User ID')]/following::span[text()='"+userid+"']","groupid","(.//strong[contains(text(),'User ID')]/following::span[text()='"+userid+"']//following::button/span[text()='Assign Corporates'])[1]");
	
		
}}