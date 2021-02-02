package testcases;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import pages.SaabHomePage;
import wrappers.ProjectWrapp;

public class TC_20_Update_Maturity_Instruction   extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC_20_Update Maturity Instruction";

		testDescription="Update Maturity Instruction with Maturity option -Add or withdraw funds on maturity.";
		browserName="Chrome";
		dataSheetName="SaabCIBDev";
		category="Sanity";
		authors="Boopathi";
		testKeyword="TC20";
		LogoutStatus=true;
		usertype="CIBUser";

	}

	@Test(groups={"sanity"},dataProvider="fetch")
	public void updateMaturity(String casename,String GroupID ,String Username,String Password,String Otp,String accno,String fromcomp,String sourceAccno,String Profiletransferto,String auth1,String auth2,String curencyvalue,String amount,String data1,String data2,String data3,String data4,String data5,String data6,String data7,String data8) throws Exception{
		
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
		//acc
	.verifystatementpage(accno)
	.statementpageBalance()
	.Requestoptions()
	.clickupdateMaturity()
	//acc
		.UpdateMaturityMenu(fromcomp,sourceAccno)
.UpdateMaturityoptions("Add or withdraw",Profiletransferto)

.otpSubmit("update maturity")
.clickRequestStatus()
//.RequestStatusChecking("New Deposit Request","Pending","Pending")
.RequestStatusChecking("Update Maturity Instruction","Pending","Pending")
/*
		.defaultContentFrame()
		.clickdatelinemenu()
		.verifyBuzz(prop.getProperty("Click.updatematurity.Value.Xpath"),auth1,auth2)
	*/	.logoutApplication();

				
		getnewurl();

//	getnewurl();
	//geturl("https://sabbcorpdev.sabb.com/Corporate/");
	new	SaabHomePage(driver,test)
		.enterGroupID(GroupID)
		.enterUsernameID(auth1)
		.clickLoginButton()
		.enterPassword(Password)
		.clickSecureimage()
		.clickLoginButtonFinal()
		.submitTokenXpath(Otp)
	//	.verifybellicon()
		.clickAccountMenu()
		//.clickFilterAuthorizeButton(Filterresult)
		//. AuthorizeReferencenum("Update Maturity Instruction Request")
		.AuthorizeReferenceno(prop.getProperty("Click.updatematurity.Value.Xpath"))
		
		.defaultContentFram()//remove this method while verify active status
/*
		.RequestMenu()
		.clickRequestStatus()
.RequestStatusverify("Update Maturity Instruction","Active","Active")
.defaultContentFrame()*/
.clickStatementMenu()
//acc
.verifystatementpage(accno)
.finalstatementpageBalance()
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

