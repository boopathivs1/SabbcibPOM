package testcases;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import pages.SaabHomePage;
import pages.StatementPage;
import wrappers.ProjectWrapp;

public class TC_04_Account_Mini_Statement  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC04 -Account Statement - Mini Statement";

		testDescription="Account Statement - Mini Statement";
		browserName="Chrome";
		dataSheetName="SaabCIBDev";
		category="Regression";
		authors="Boopathi";
		testKeyword="TC04";
		LogoutStatus=true;
		usertype="CIBUser";

	}

	@Test(groups={"sanity"},dataProvider="fetch")
	public void miniStat(String casename,String GroupID ,String Username,String Password,String Otp,String StatAccno,String Data2,String Data3,String Data4,String Data5,String Data6,String data7,String data8,String data9,String data10,String data11,String data12,String data13,String data14,String data15,String data16) throws Exception{

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
		//acc
		.verifystatementpage(StatAccno)
		.statementTabVerify("Mini Statement")

			
		//.defaultcontent()
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

