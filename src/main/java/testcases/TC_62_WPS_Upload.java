package testcases;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import pages.SaabHomePage;
import wrappers.ProjectWrapp;

public class TC_62_WPS_Upload  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC62 WPS Upload";

		testDescription="WPS Upload - Using XLS File";
		browserName="Chrome";
		dataSheetName="SaabCIBDev";
		category="Sanity";
		authors="Boopathi";
		testKeyword="TC62";
		LogoutStatus=true;
		usertype="CIBUser";

	}

		
	
	
	
	
	@Test(groups={"sanity"},dataProvider="fetch")

	public void wpsUploadXLSFile(String casename,String GroupID ,String Username,String Password,String Otp,String accno,String transfertype,String fromCompany,String fromacc,String moid,String paymenttype,String location,String Purpose,String foryouracc,String auth1,String auth2,String frequency,String timesofday,String data3,String data4,String data5) throws Exception{

//String fileLocation="D://Workspace//sabbframework//data//wps_sample.xlsx";
		
		String fileLocation="D://Automation_Workspace//SabbCIBPom//data//wps_sample.xlsx";
//String fileLocation="E://workspacegit//saabframework2.1//sabbframeworkv2.0//data//wps_sample.xlsx";
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
	.getbalanceamnt()
		.clicktooltip()
		.clickpaymentMenu()
		.clickWPStransferMenu()
		.clickfileUploadTab()
		.fillFileUploadForm(fromCompany,fromacc,moid,paymenttype,fileLocation)
		.otphandling("click",prop.getProperty("Addbeneficiary.confirm.xpath"), null,null)
		.otphandling("enter",prop.getProperty("Newdepost.otpenter.xpath"),Otp,null)
		.otphandling("click",prop.getProperty("click.confirmbutton.xpath"), null,null)
	//	.otphandling("verify",prop.getProperty("verify.previousinterimSucess.xpath"), null,"Successfully")
		.otphandling("getrefno",prop.getProperty("getref.number.beneficiary.xpath"), null,null)
	.NavigationWPS()
		.verifyfileStatusTab("Pending Authorization")
	//	.verifybuzzWPS(auth1, auth2)
		.logout(true,usertype);	

		AuthUsername=auth1;
		getnewurl();
		new	SaabHomePage(driver,test)
		.enterGroupID(GroupID)
		.enterUsernameID(AuthUsername)
		.clickLoginButton()
		.enterPassword(Password)
		.clickSecureimage()
		.clickLoginButtonFinal()
		.submitTokenXpath(Otp)
	
		
	//	.verifybellicon()
		.clickpaymentMenu()
		.clickWPStransferMenu()
	
		.clickfileStatusTab()
		.verifyfileStatusTab("Pending Authorization")
		.authorizationWPS()
		.locateframe()
//		.verifyfileStatusTab("To be Processed")
.verifyfilefilterStatusTab()
		.navigatestat()		
		.clicktooltip()
	
		
		.clickpaymentMenu()
		.clickWPStransferMenu()
	
		.clickfileStatusTab()
		.verifyfilefilterStatusTab()
		.verifyfileStatus("To be Processed")
			

	/*	
.navigatestat()
		
		.clicktooltip()
		.clickAccount()
		.clickStatementMenu()
		.verifystatementpage(accno)
		.finalstatementpageBalance();
*/





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
