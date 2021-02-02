package testcases;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import pages.SaabHomePage;
import wrappers.ProjectWrapp;

public class TC_64_Payment_Reports  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC64 Payment Reports";

		testDescription="Payment Reports";
		browserName="Chrome";
		dataSheetName="SaabCIBDev";
		category="Sanity";
		authors="Boopathi";
		testKeyword="TC64";
		LogoutStatus=true;
		usertype="CIBUser";

	}

	@Test(groups={"sanity"},dataProvider="fetch")

	public void overseasRepeat(String casename,String GroupID ,String Username,String Password,String Otp,String accno,String transfertype,String fromCompany,String fromacc,String ToBeneficiary,String currency,String amount,String Purpose,String foryouracc,String auth1,String auth2,String frequency,String timesofday,String data3,String data4,String data5) throws Exception{
	
		try{
		new	SaabHomePage(driver,test)
		.enterGroupID(GroupID)
		.enterUsernameID(Username)
		.clickLoginButton()
		.enterPassword(Password)
		.clickSecureimage()
		.clickLoginButtonFinal()
		.submitTokenXpath(Otp)
		.clickpaymentMenu()
		.navigatepaymentDateline()
		.navigatepayreport()
		.clickPaymentReports()
//.PaymentStatusReport(prop.getProperty("Payment.wps.dd.xpath"),"Pending Authorization","Pending Authorization","Tomorrow")
.PaymentStatusReport()
.PaymentStatustype(prop.getProperty("overseas.acc.type.xpath"), "Pending Authorization","Pending Authorization")
.PaymentStatustype(prop.getProperty("overseas.acc.type.xpath"), "Success","Success")
.PaymentStatustype(prop.getProperty("localtransfer.xpath"), "Pending Authorization","Pending Authorization")
.PaymentStatustype(prop.getProperty("localtransfer.xpath"), "Success","Success")
.PaymentStatustype(prop.getProperty("Payment.wps.dd.xpath"),"Pending Authorization","Pending Authorization")
.PaymentStatustype(prop.getProperty("Payment.wps.dd.xpath"), "Success","Success")
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

	