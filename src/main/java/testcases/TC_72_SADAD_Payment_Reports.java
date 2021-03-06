package testcases;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import pages.SaabHomePage;
import wrappers.ProjectWrapp;

public class TC_72_SADAD_Payment_Reports  extends ProjectWrapp
{
@BeforeClass(groups={"common"})
public void setDatag() {
	testCaseName="TC72 SADAD Payment Reports";

	testDescription="SADAD Payment Reports";	
	browserName="Chrome";
	dataSheetName="SaabCIBDev";
	category="Sanity";
	authors="Boopathi";
	testKeyword="TC72";
	LogoutStatus=true;
	usertype="CIBUser";

}

@Test(groups={"sanity"},dataProvider="fetch")
public void SADADPaymentReports(String casename,String GroupID ,String Username,String Password,String Otp,String accno,String corpno,String categoryselect,String billcomp,String plan,String billaccnum,String amount,String auth1,String auth2,String data1,String datas2,String datas3,String datas4,String data6,String dataf4,String datasf6) throws Exception{	
	
	try{
	new	SaabHomePage(driver,test)
	.enterGroupID(GroupID)
	.enterUsernameID(Username)
	.clickLoginButton()
	.enterPassword(Password)
	.clickSecureimage()
	.clickLoginButtonFinal()
	.submitTokenXpath(Otp)
	.clickSadadMenu()
	.navigatePaymentReportPage()
		.clickSadadPaymentReports()	
		.sadadPayStatus("Today")
		.sadadPayStatusvalue("One Time Payment", "Pending Authorization","Pending Authorization")
		.sadadPayStatusvalue("One Time Payment", "Success","Success").logout(LogoutStatus,usertype);
	
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

	
