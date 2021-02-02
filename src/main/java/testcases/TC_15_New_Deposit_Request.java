package testcases;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import pages.SaabHomePage;
import wrappers.ProjectWrapp;

public class TC_15_New_Deposit_Request   extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC15";

		testDescription="New Deposit Request [Commoditiy investment Account] with Maturity option -Reinvestment of investment amount only";
		browserName="Chrome";
		dataSheetName="SaabCIBDev";
		category="Sanity";
		authors="Boopathi";
		testKeyword="TC15";
		LogoutStatus=true;
		usertype="CIBUser";

	}

	@Test(groups={"sanity"},dataProvider="fetch")
	public void newdeposit(String casename,String GroupID ,String Username,String Password,String Otp,String accno,String fromcomp,String sourceAccno,String fromacc,String auth1,String auth2,String curencyvalue,String amount,String data1,String data2,String data3,String data4,String data5,String data6,String data7,String data8) throws Exception{
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
	//acc
	.fullencashprofit(fromcomp,sourceAccno,curencyvalue,amount)
	//acc
	.maturityOptionsNewDepositReinvestment("Add or withdraw funds on maturity",fromacc)
	.otpSubmit("New Deposit Request")
.clickRequestStatus()
		
	.RequestStatusChecking("New Deposit Request","Pending","Pending")
	/*	
	.defaultContentFrame()
		.clickdatelinemenu()
		.verifyBuzz(prop.getProperty("Click.RequestType.Value.Xpath"),auth1,auth2)
		*/.logoutApplication();

				getnewurl();
	new	SaabHomePage(driver,test)
		.enterGroupID(GroupID)
		.enterUsernameID(auth1)
		.clickLoginButton()
		.enterPassword(Password)
		.clickSecureimage()
		.clickLoginButtonFinal()
		.submitTokenXpath(Otp)
//		.verifybellicon()
		.clickAccountMenu()
		.AuthorizeReferenceno(prop.getProperty("Click.RequestType.Value.Xpath"))
		.defaultContentFram()//remove this method while verify active status
/*
		.RequestMenu()
		.clickRequestStatus()
	.RequestStatusverify("New Deposit Request","Active","Active")	
	.defaultContentFrame()
	*/.clickStatementMenu()
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

