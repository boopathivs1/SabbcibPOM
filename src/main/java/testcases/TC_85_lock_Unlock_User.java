package testcases;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import pages.SaabHomePage;
import wrappers.ProjectWrapp;

public class TC_85_lock_Unlock_User  extends ProjectWrapp

{
@BeforeClass(groups={"common"})
public void setDatag() {
	testCaseName="TC85 lock and Unlock User";

	testDescription="lock and Unlock User";	
	browserName="Chrome";
	dataSheetName="SaabCIBDev";
	category="Sanity";
	authors="Boopathi";
	testKeyword="TC85";
	LogoutStatus=true;
	usertype="CIBUser";

}

@Test(groups={"sanity"},dataProvider="fetch")
public void lockUnlockUser(String casename,String GroupID ,String userid,String Password,String otp,String username2,String Password2,String auth1,String auth2,String groupname,String data1,String data11,String data12,String data13,String data14,String data15,String data16,String data17,String data18,String data19,String data20) throws Exception{	
	try{
	for(int i=0;i<1;i++){
	new	SaabHomePage(driver,test)
	.enterGroupID(GroupID)
	.enterUsernameID(userid)
	.clickLoginButton()
	.enterPassword(Password)
	.clickSecureimage()
	.clickLoginButtonFail();
	
	}
	new SaabHomePage(driver, test)
	.enterGroupID(GroupID)
	.enterUsernameID(username2)
	.clickLoginButton()
	.enterPassword(Password2)
	.clickSecureimage()
	.clickLoginButtonFinal()
	.submitTokenXpath(otp)
	.clickAdmin()
	.clickUsersPage()
	.clickAssignUsers("(.//h4[text()='"+groupname+"']//following::span[text()='Assign Users'])[1]")
		.createUsersFilter("UserLocked","Active",userid,"true")
		.verifyeditUserIdpresent(userid,"(.//strong[contains(text(),'User ID')]/following::span[text()='"+userid+"']//following::button/span[2])[1]")
.clickunlockuser()
.clickDatelinemenu()
.verifyAdminbuzz(auth1,auth2, "Corporate User Profile UnLock Request")

.logout(true,usertype);	


	
	AuthUsername=auth1;

	getnewurl();
	new	SaabHomePage(driver,test)
	.enterGroupID(GroupID)
	.enterUsernameID(AuthUsername)
	.clickLoginButton()
	.enterPassword(Password2)
	.clickSecureimage()
	.clickLoginButtonFinal()
	.submitTokenXpath(otp)
//	.verifybellicon()
	.clickAdmin()
	.datelinefilter("paymentdd.selecttype.xpath","Corporate User Profile Request","payment.status.xpath","Pending", getrefnumer, "Pending")
	.authorization()
	.datelinefilter("paymentdd.selecttype.xpath","Corporate User Profile Request","payment.status.xpath","Accepted", getrefnumer, "Accepted")
.clickUsersPage()	
.clickAssignUsers("(.//h4[text()='"+groupname+"']//following::span[text()='Assign Users'])[1]")
	.createUsersFilter("UserId","Active",userid,"true")
	
	.verifyeditUserIdpresent(userid,"(.//strong[contains(text(),'User ID')]/following::span[text()='"+userid+"']//following::button/span[2])[1]")
	.unlockuserDisplay(prop.getProperty("click.unlockuser.link.xpath"),"Unlock user options has displaying in this page","Unlock user options has not displaying in this page").logout(LogoutStatus,usertype);
	
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
