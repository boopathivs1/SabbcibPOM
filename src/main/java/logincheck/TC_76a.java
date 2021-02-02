package logincheck;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import pages.SaabHomePage;
import wrappers.ProjectWrapp;

public class TC_76a  extends ProjectWrapp
{
@BeforeClass(groups={"common"})
public void setDatag() {
	testCaseName="TC76";

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
	.submitTokenXpath(Otp);
	}catch (Exception e) {

	logout(LogoutStatus,usertype);
throw new Exception();
	
	// TODO: handle exception
}

}
}
