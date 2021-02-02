package testcases;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import pages.SaabHomePage;
import wrappers.ProjectWrapp;

public class TC_77_Edit_Users  extends ProjectWrapp
{
@BeforeClass(groups={"common"})
public void setDatag() {
	testCaseName="TC77 Edit Users";

	testDescription="Edit Users";	
	browserName="Chrome";
	dataSheetName="SaabCIBDev";
	category="Sanity";
	authors="Boopathi";
	testKeyword="TC77";
	LogoutStatus=true;
	usertype="CIBUser";

}


@Test(groups={"sanity"},dataProvider="fetch")
public void editUser(String casename,String GroupID ,String Username,String Password,String Otp,String userid,String firstname,String phonenumber,String emailid,String Country,String City,String corporateChannels,String idIssuingCountry,String idtype,String PassportNumber,String Securitychoosen,String TransactionSecurityChoosen,String auth1,String auth2,String groupname,String data2) throws Exception{
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
	.verifyeditUserIdpresent(userid,"(.//strong[contains(text(),'User ID')]/following::span[text()='"+userid+"']//following::button/span[2])[1]")

	.clickUsersEditLink(userid)
	.filleditUsersForm(firstname, Country, City, corporateChannels, idIssuingCountry, idtype, PassportNumber,Securitychoosen, TransactionSecurityChoosen)
	.createUsersFilter("UserId","Active",userid,"true")//
	.verifyUseIdpresent(userid)
	.clickDatelinemenu()
	.verifyAdminbuzz(auth1,auth2, "Corporate User Profile Updation Request")
	//.logout(true);

	.logout(true,usertype);	

	AuthUsername=auth1;
//getrefnumer="DT-29112961";
	getnewurl();
	new	SaabHomePage(driver,test)
	.enterGroupID(GroupID)
	.enterUsernameID(AuthUsername)
	.clickLoginButton()
	.enterPassword(Password)
	.clickSecureimage()
	.clickLoginButtonFinal()
	.submitTokenXpath(Otp)
	//.verifybellicon()
	.clickAdmin()
	
	
	.datelinefilter("paymentdd.selecttype.xpath","Corporate User Profile Request","payment.status.xpath","Pending", getrefnumer, "Pending")
//	.authorization()
	.authorizationDateline()

	.datelinefilter("paymentdd.selecttype.xpath","Corporate User Profile Request","payment.status.xpath","Accepted", getrefnumer, "Accepted")


.clickUsersPage()	
	.clickAssignUsers("(.//h4[text()='"+groupname+"']//following::span[text()='Assign Users'])[1]")
	.createUsersFilter("UserId","Active",userid,"true")
	//.verifyUserCreation("userid");
	.verifyeditUserIdpresent(userid,"(.//strong[contains(text(),'User ID')]/following::span[text()='"+userid+"']//following::button/span[2])[1]")

	.clickUsersEditLink(userid)
	.editUsersFormByAttribute(firstname, phonenumber, emailid, PassportNumber).logout(LogoutStatus,usertype);
	
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











