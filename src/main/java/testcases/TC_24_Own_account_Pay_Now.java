package testcases;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import pages.SaabHomePage;
import wrappers.ProjectWrapp;

public class TC_24_Own_account_Pay_Now  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC24 Own account_Pay Now";

		testDescription="Own account_Pay Now";
		browserName="Chrome";
		dataSheetName="SaabCIBDev";
		category="Sanity";
		authors="Boopathi";
		testKeyword="TC24";
		LogoutStatus=true;
		usertype="CIBUser";

	}

	@Test(groups={"sanity"},dataProvider="fetch")

	public void ownaccount_PayNow(String casename,String GroupID ,String Username,String Password,String Otp,String accno,String fromcomp,String sourceAccno,String Tocomp,String toAccno,String currency,String amount,String auth1,String auth2,String frequency,String timesofpay,String data3,String data4,String data5,String data6,String data7) throws Exception{

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
.clickOwnAccount()
.ownTranserpage("Today","Pay Now",fromcomp,sourceAccno,Tocomp,toAccno,currency,amount,frequency,timesofpay)
.fillOtp("OwnAccountOtpSubmit")
.verifysucessmsg()
.clickPaymentReports()
//own.acc.payreports.xpath
//.OwnPaymentStatus(prop.getProperty("own.acc.payreports.xpath"), "Pending Authorization","Pending Authorization","Today")
.OwnPaymentStatusCheck(prop.getProperty("own.acc.payreports.xpath"), "Pending Authorization","Pending Authorization","Today")

/*
.clickpaymentdatelinemenu()


.datelinefilter("paymentdd.selecttype.xpath","Own Account Transfer Request","payment.status.xpath","Pending", getrefnumer, "Pending")
.verifypaymentbuzz(auth1,auth2)
*/
.logout(true,usertype);

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
.clickpaymentMenu()
.navigatepaymentDateline()
.datelinefilter("paymentdd.selecttype.xpath","Own Account Transfer Request","payment.status.xpath","Pending", getrefnumer, "Pending")
.authorization()
.datelinefilter("paymentdd.selecttype.xpath","Own Account Transfer Request","payment.status.xpath","Accepted", getrefnumer, "Accepted")
.navigatepayreport()
.clickPaymentReports()
//.PaymentStatus("Own Account Transfer", "Pending Authorization","Pending")

//.OwnPaymentStatus(prop.getProperty("own.acc.payreports.xpath"), "Success","Success","Today")

.OwnPaymentStatusCheck(prop.getProperty("own.acc.payreports.xpath"), "Success","Success","Today")


.navigateStatementpage()
.clicktooltip()
.clickAccount()
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

