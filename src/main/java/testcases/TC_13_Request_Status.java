package testcases;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import pages.RequestsStatus;
import pages.SaabHomePage;
import wrappers.ProjectWrapp;

public class TC_13_Request_Status   extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC13_Request Status";

		testDescription="Request Status	";
		browserName="Chrome";
		dataSheetName="SaabCIBDev";
		category="Regression";
		authors="Boopathi";
		testKeyword="TC13";
		LogoutStatus=true;
		usertype="CIBUser";

	}
//enable all status
	@Test(groups={"sanity"},dataProvider="fetch")
	public void verifyRequestStatus(String casename,String GroupID ,String Username,String Password,String Otp,String Filterresult,String Data2,String Data3,String Data4,String Data5,String Data6,String data7,String data8,String data9,String data10,String data11,String data12,String data13,String data14,String data15,String data16) throws Exception  {
try{	
		new	SaabHomePage(driver,test)
		.enterGroupID(GroupID)
		.enterUsernameID(Username)
		.clickLoginButton()
		.enterPassword(Password)
		.clickSecureimage()
		.clickLoginButtonFinal()
		.submitTokenXpath(Otp)
		.AccountRequestPage()	
		.RequestMenu()
		.clickRequestStatus()
		
	//.RequestStatusChecking(prop.getProperty("RequestPage.status.type.xpath"),prop.getProperty("RequestPage.status.value.xpath"),"Active");	
		
	//	.RequestStatusVerify("New Deposit Request","Active","Active")	
	//	.RequestStatusVerify("New Deposit Request","Pending","Pending")	

		.RequestStatusVerifyFromToDate("New Deposit Request","Active","Active",true)	
		.RequestStatusVerifyFromToDate("New Deposit Request","Pending","Pending",false)

		.RequestStatusVerifyFromToDate("Interim Statement","Active","Active",false)
		.RequestStatusVerifyFromToDate("Previous Month Statement","Active","Active",false)
		.RequestStatusVerifyFromToDate("Interim Statement","Pending","Pending",false)
		.RequestStatusVerifyFromToDate("Update Maturity Instruction","Active","Active",false)
		.RequestStatusVerifyFromToDate("Update Maturity Instruction","Pending","Pending",false)

	//	.RequestStatusVerify("Interim Statement","Active","Active")

	//	.RequestStatusVerify("Interim Statement","Pending","Pending")

	//	.RequestStatusVerify("Previous Month Statement","Pending","Pending")	
	//	.RequestStatusVerify("Update Maturity Instruction","Active","Active")
	//	.RequestStatusVerify("Update Maturity Instruction","Pending","Pending")
	//	.RequestStatusVerify("Previous Month Statement","Active","Active");

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

