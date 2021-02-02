package testcases;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import pages.SaabHomePage;
import wrappers.ProjectWrapp;

public class TC_22_Interim_Statement  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC22 Interim Statement";

		testDescription="Interim Statement";
		browserName="Chrome";
		dataSheetName="SaabCIBDev";
		category="Sanity";
		authors="Boopathi";
		testKeyword="TC22";
		LogoutStatus=true;
		usertype="CIBUser";

	}

	@Test(groups={"sanity"},dataProvider="fetch")
	public void InterimStatement(String casename,String GroupID ,String Username,String Password,String Otp,String accno,String fromcorp,String sourceAccno,String Profiletransferto,String auth1,String auth2,String curencyvalue,String amount,String data1,String data2,String data3,String data4,String data5,String data6,String data7,String data8) throws Exception{
try{
		new	SaabHomePage(driver,test)
	.enterGroupID(GroupID)
	.enterUsernameID(Username)
	.clickLoginButton()
	.enterPassword(Password)
	.clickSecureimage()
	.clickLoginButtonFinal()
	.submitTokenXpath(Otp)
	.clickAccount()
	.clickStatementMenu()
	.verifystatementpage(accno)
	.statementpageBalance()
	.Requestopt()
	.interimRequestMenu()
	.interimAndPreviousMonthform("interim month",fromcorp,sourceAccno)

	.otpSubmit("interim month")
.clickRequestStatus()
		
	.RequestStatusChecking("Interim Statement","Pending","Pending")
/*		.defaultContentFrame()
		.clickdatelinemenu()
		.verifyBuzz(prop.getProperty("Click.interim.Value.Xpath"),auth1,auth2)
	*/	.logoutApplication();
		
		
				getnewurl();
	new	SaabHomePage(driver,test)
		.enterGroupID(GroupID)
		.enterUsernameID(auth1)
		.clickLoginButton()
		.enterPassword(Password)
		.clickSecureimage()
		.clickLoginButtonFinal()
		.submitTokenXpath(Otp)
		//.verifybellicon()
		.clickAccountMenu()
		.AuthorizeReferenceno(prop.getProperty("Click.interim.Value.Xpath"))
		.RequestMenu()
		.clickRequestStatus()
	.RequestStatusverify("Interim Statement","Active","Active")	
	.defaultContentFrame()
	.clickStatementMenu()
	.verifystatementpage(accno)
	.finalstatementpageBalance()
	.logout(LogoutStatus,usertype);
	loginfoSuccess(testCaseName,testDescription);
	
}

catch (Exception e) {

logout(LogoutStatus,usertype);
throw new Exception();

// TODO: handle exception
}

}
}

