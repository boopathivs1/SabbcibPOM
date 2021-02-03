package testcases;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import pages.SaabHomePage;
import wrappers.ProjectWrapp;

public class TC_109_Quickly_Navigation_to_Service_Requests  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC_109_Quickly_Navigation_to_Service_Requests";

		testDescription="Quickly Navigation to Service Requestst";
		browserName="Chrome";
		dataSheetName="SaabCIBDev";
		category="Regression";
		authors="Sreejith";
		testKeyword="TC109";
		LogoutStatus=true;
		usertype="CIBUser";

	//account no will change as name so use sridhar01 account only	
	}

	@Test(groups={"sanity"},dataProvider="fetch")
	public void updateTags(String casename,String GroupID ,String Username,String Password,String Otp,String accno,String ServiceReq
,String Data3,String Data4,String Data5,String Data6,String data7,String data8,String data9,String data10,String data11,String data12,String data13,String data14,String data15,String data16) throws Exception  {

		try{
		new	SaabHomePage(driver,test)
		.enterGroupID(GroupID)
		.enterUsernameID(Username)
		.clickLoginButton()
		.enterPassword(Password)
		.clickSecureimage()
		.clickLoginButtonFinal()
		.submitTokenXpath(Otp)
		.clickAccountMenu()
		.clickStatementMenu()
		.VerifyAccountStatement(accno,ServiceReq)
		
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

