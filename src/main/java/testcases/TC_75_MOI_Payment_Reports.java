package testcases;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import pages.SaabHomePage;
import wrappers.ProjectWrapp;

public class TC_75_MOI_Payment_Reports  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC75 MOI Payment Reports";

		testDescription="MOI Payment Reports";
		browserName="Chrome";
		dataSheetName="SaabCIBDev";
		category="Sanity";
		authors="Boopathi";
		testKeyword="TC75";
		LogoutStatus=true;
		usertype="CIBUser";

	}

	@Test(groups={"sanity"},dataProvider="fetch")

		public void moiPaymentReports(String casename,String GroupID ,String Username,String Password,String Otp,String accno,String TransferValue,
				String overseasBeneficiaryname,String overseasBeneficiaryaddress,	String country,	String city,String branch,String currency,String IBANno,String purposeoftransfer,String remarks,String foryouracc,String auth1,String auth2,String data1,String data4) throws Exception{

	try{
		new	SaabHomePage(driver,test)
.enterGroupID(GroupID)
.enterUsernameID(Username)
.clickLoginButton()
.enterPassword(Password)
.clickSecureimage()
.clickLoginButtonFinal()
.submitTokenXpath(Otp)
.clickMoiMenu()
.clickmoireportslink()
.MOIReportCalendar()
.MoiPaymentStatustype(prop.getProperty("moi.paytype.choose.xpath"),"MOI Refund",prop.getProperty("moistatus.selection.xpath"),"Pending Authorization","Pending Authorization")
.MoiPaymentStatustype(prop.getProperty("moi.paytype.choose.xpath"),"MOI Refund",prop.getProperty("moistatus.selection.xpath"),"Success","Success")
.MoiPaymentStatustype(prop.getProperty("moi.paytype.choose.xpath"),"MOI Payment",prop.getProperty("moistatus.selection.xpath"),"Pending Authorization","Pending Authorization")
.MoiPaymentStatustype(prop.getProperty("moi.paytype.choose.xpath"),"MOI Payment",prop.getProperty("moistatus.selection.xpath"),"Success","Success")
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




