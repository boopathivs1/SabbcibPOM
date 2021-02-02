package testcases;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import pages.SaabHomePage;
import wrappers.ProjectWrapp;

public class TC_23_Previous_Month_Statement  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC23 Previous Month Statement";

		testDescription="Previous Month Statement";
		browserName="Chrome";
		dataSheetName="SaabCIBDev";
		category="Sanity";
		authors="Boopathi";
		testKeyword="TC23";
		LogoutStatus=true;
		usertype="CIBUser";

	}

	@Test(groups={"sanity"},dataProvider="fetch")
	//public void FilterPositiveCase(String casename,String GroupID ,String Username,String Password,String Otp,String Filterresult,String Data2,String Data3,String Data4,String Data5,String Data6) throws Exception{
	
		public void previousMonthStatement(String casename,String GroupID ,String Username,String Password,String Otp,String accno,String fromcomp,String sourceAccno,String Profiletransferto,String auth1,String auth2,String curencyvalue,String amount,String data1,String data2,String data3,String data4,String data5,String data6,String data7,String data8) throws Exception{
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

//.verifystatementpage()
.statementpageBalance()
.Requestopt()
.previousStatementMenu()
.interimAndPreviousMonthform("Previous Month",fromcomp,sourceAccno)

.otpSubmit("Previous Month")
.clickRequestStatus()
	
.RequestStatusChecking("Previous Month Statement","Pending","Pending")
/*	.defaultContentFrame()
	.clickdatelinemenu()
	.verifyBuzz(prop.getProperty("Click.previous.Value.Xpath"),auth1,auth2)
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
	.AuthorizeReferenceno(prop.getProperty("Click.previous.Value.Xpath"))
	.RequestMenu()
	.clickRequestStatus()
.RequestStatusverify("Previous Month Statement","Active","Active")	
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



		
