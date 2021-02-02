package testcases;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import pages.SaabHomePage;
import wrappers.ProjectWrapp;

public class TC_76_Create_New_Users  extends ProjectWrapp

{
@BeforeClass(groups={"common"})
public void setDatag() {
	testCaseName="TC76 Create New Users";

	testDescription="Create New Users";	
	browserName="Chrome";
	dataSheetName="SaabCIBDev";
	category="Sanity";
	authors="Boopathi";
	testKeyword="TC76";
	LogoutStatus=true;
	usertype="CIBUser";

}

@Test(groups={"sanity"},dataProvider="fetch")
public void createUser(String casename,String GroupID ,String Username,String Password,String Otp,String userid,String firstname,String phonenumber,String emailid,String Country,String City,String corporateChannels,String idIssuingCountry,String idtype,String PassportNumber,String Securitychoosen,String TransactionSecurityChoosen,String auth1,String auth2,String groupname,String data2) throws Exception{
	

	try{
		
		new	SaabHomePage(driver,test)
	.enterGroupID(GroupID)
	.enterUsernameID(Username)
	.clickLoginButton()
	.enterPassword(Password)
	.clickSecureimage()
	.clickLoginButtonFinal()
	.submitTokenXpath(Otp)
	.clickAdmin()
	.clickUsersPage()
	
	.clickAssignUsers("(.//h4[text()='"+groupname+"']//following::span[text()='Assign Users'])[1]")
	
	.clickCreateUsers()
	.fillCreateUsersForm(userid,firstname,phonenumber,emailid,Country,City,corporateChannels,idIssuingCountry,idtype,PassportNumber,Securitychoosen,TransactionSecurityChoosen)
	
	
	
//	.createUsersFilter("UserId","Pending for Authorization","null","false")
//	.verifyUseIdpresent(userid)

	
	.clickDatelinemenu()

	.verifyAdminbuzz(auth1,auth2, "Corporate User Profile Creation Request")

	.logout(true,usertype);	

	AuthUsername=auth1;
	
	getnewurl();
	new	SaabHomePage(driver,test)
	.enterGroupID(GroupID)
	.enterUsernameID(AuthUsername)
	.clickLoginButton()
	.enterPassword(Password)
	.clickSecureimage()
	.clickLoginButtonFinal()
	.submitTokenXpath(Otp)
//	.verifybellicon()
	.clickAdmin()
	
	.datelinefilter("paymentdd.selecttype.xpath","Corporate User Profile Request","payment.status.xpath","Pending", getrefnumer, "Pending")
//	.authorization()
	.authorizationDateline()
//	.authorizefromDatelineRequest();
	.datelinefilter("paymentdd.selecttype.xpath","Corporate User Profile Request","payment.status.xpath","Accepted", getrefnumer, "Accepted")

	
	.clickUsersPage()	
	.clickAssignUsers("(.//h4[text()='"+groupname+"']//following::span[text()='Assign Users'])[1]")
	.createUsersFilter("UserId","Active",userid,"true")
	//.verifyUserCreation("userid");
.verifyUseIdpresent(userid).logout(LogoutStatus,usertype);
	
	loginfoSuccess(testCaseName,testDescription);

	}

catch (Exception e) {
	logfailed(testCaseName,testDescription);
	log.error(e);
	logout(LogoutStatus,usertype);
throw new Exception();
	
	// TODO: handle exception
}

}
}
