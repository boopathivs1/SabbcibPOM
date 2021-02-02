package testcases;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import pages.SaabHomePage;
import wrappers.ProjectWrapp;

public class TC_88_Activate_User  extends ProjectWrapp
{
@BeforeClass(groups={"common"})
public void setDatag() {
	testCaseName="TC88 Activate User";

	testDescription="Activate User";	
	browserName="Chrome";
	dataSheetName="SaabCIBDev";
	category="Sanity";
	authors="Boopathi";
	testKeyword="TC88";
	LogoutStatus=true;
	usertype="CIBUser";

}

@Test(groups={"sanity"},dataProvider="fetch")
public void activateUser(String casename,String GroupID ,String Username,String Password,String Otp,String userid,String auth1,String auth2,String groupname,String data1,String data11,String data12,String data13,String data14,String data15,String data16,String data17,String data18,String data19,String data20,String data21) throws Exception{	
	try{
	
	new SaabHomePage(driver, test)
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
		.createUsersFilter("UserId","De-Active",userid,"true")
		.verifyeditUserIdpresent(userid,"(.//strong[contains(text(),'User ID')]/following::span[text()='"+userid+"']//following::button/span[2])[1]")
.clickActivateuser(userid)
.clickDatelinemenu()
.verifyAdminbuzz(auth1,auth2, "Corporate User Profile Activation Request")

.logout(true,usertype);	

	AuthUsername=auth1;

		
	//AuthUsername="sridhar03";
	//getrefnumer="DT-26167383";
	
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
	.authorization()
	.datelinefilter("paymentdd.selecttype.xpath","Corporate User Profile Request","payment.status.xpath","Accepted", getrefnumer, "Accepted")
.clickUsersPage()	
.clickAssignUsers("(.//h4[text()='"+groupname+"']//following::span[text()='Assign Users'])[1]")
	.createUsersFilter("UserId","Active",userid,"true")
	
	.verifyeditUserIdpresent(userid,"(.//strong[contains(text(),'User ID')]/following::span[text()='"+userid+"']//following::button/span[2])[1]")
.logout(LogoutStatus,usertype);
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
