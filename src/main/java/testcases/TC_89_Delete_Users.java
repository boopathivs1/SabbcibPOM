package testcases;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import pages.SaabHomePage;
import wrappers.ProjectWrapp;

public class TC_89_Delete_Users  extends ProjectWrapp
{
@BeforeClass(groups={"common"})
public void setDatag() {
	testCaseName="TC89 Delete Users";

	testDescription="Delete Users";	
	browserName="Chrome";
	dataSheetName="SaabCIBDev";
	category="Sanity";
	authors="Boopathi";
	testKeyword="TC89";
	LogoutStatus=true;
	usertype="CIBUser";

	
	
}


@Test(groups={"sanity"},dataProvider="fetch")
public void deleteUser(String casename,String GroupID ,String Username,String Password,String Otp,String userid,String auth1,String auth2,String groupname,String Country,String City,String corporateChannels,String idIssuingCountry,String idtype,String PassportNumber,String Securitychoosen,String TransactionSecurityChoosen,String datas,String dataa,String daatss,String data2) throws Exception{
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
	.clickUsersDeleteLink()
	.clickDatelinemenu()
	.verifyAdminbuzz(auth1,auth2, "Corporate User Profile Deletion Request")
	
	.logout(true,usertype);	

	AuthUsername=auth1;
		
//	getrefnumer="DT-26238425";
//	AuthUsername="sridhar03";
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
	//.authorization()
	.authorizationDateline()
	.datelinefilter("paymentdd.selecttype.xpath","Corporate User Profile Request","payment.status.xpath","Accepted", getrefnumer, "Accepted")


.clickUsersPage()	
	.clickAssignUsers("(.//h4[text()='"+groupname+"']//following::span[text()='Assign Users'])[1]")
	.createUsersFilter("UserId","Active",userid,"true")
	.deleteuserVerify("(.//strong[contains(text(),'User ID')]/following::span[text()='"+userid+"']//following::button/span[2])[1]","Deleted User id has been deleted sucessfully","Deleted User id has not not been deleted successfully")
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
