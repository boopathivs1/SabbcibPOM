package testcases;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import pages.SaabHomePage;
import wrappers.ProjectWrapp;

public class TC_84_DeAssign_Corporates  extends ProjectWrapp
{
@BeforeClass(groups={"common"})
public void setDatag() {
	testCaseName="TC84 De-Assign Corporates";

	testDescription="De-Assign Corporates";	
	browserName="Chrome";
	dataSheetName="SaabCIBDev";
	category="Sanity";
	authors="Boopathi";
	testKeyword="TC84";
	LogoutStatus=true;
	usertype="CIBUser";

}

@Test(groups={"sanity"},dataProvider="fetch")
public void SADADPaymentReports(String casename,String GroupID ,String Username,String Password,String Otp,String userid,String auth1,String auth2,String groupname,String data1,String data11,String data12,String data13,String data14,String data15,String data16,String data17,String data18,String data19,String data20,String data21) throws Exception{	
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
		.createUsersFilter("UserId","Active",userid,"true")
		.verifyeditUserIdpresent(userid,"(.//strong[contains(text(),'User ID')]/following::span[text()='"+userid+"']//following::button/span[text()='Assign Corporates'])[1]")
.getCorporateid()
		.clickNewAssignCorporate()
		.chooseOptionsAssignCorporate()
	//	.chooseOptionsAssignCorporate()
		.submitAssignCorporate()
	.clickDatelinemenu()
	//.datelinefilter("paymentdd.selecttype.xpath","User Corporate Request","payment.status.xpath","Pending", getrefnumer, "Pending")

	.verifyAdminbuzz(auth1,auth2, "User Corporate Assign Request")
	//.logout(true);
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
	.datelinefilter("paymentdd.selecttype.xpath","User Corporate Request","payment.status.xpath","Pending", getrefnumer, "Pending")
	.authorization()
	.datelinefilter("paymentdd.selecttype.xpath","User Corporate Request","payment.status.xpath","Accepted", getrefnumer, "Accepted")
.clickUsersPage()	
.clickAssignUsers("(.//h4[text()='"+groupname+"']//following::span[text()='Assign Users'])[1]")
	.createUsersFilter("UserId","Active",userid,"true")
	.verifyeditUserIdpresent(userid,"(.//strong[contains(text(),'User ID')]/following::span[text()='"+userid+"']//following::button/span[text()='Assign Corporates'])[1]")
	.verifyCorporateDeAssigned().logout(LogoutStatus,usertype);
	
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
