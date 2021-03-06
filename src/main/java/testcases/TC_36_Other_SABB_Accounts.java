package testcases;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import pages.SaabHomePage;
import wrappers.ProjectWrapp;

public class TC_36_Other_SABB_Accounts  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC36 Other SABB Accounts_Pay Now";

		testDescription="Other SABB Accounts_Pay Now";
		browserName="Chrome";
		dataSheetName="SaabCIBDev";
		category="Sanity";
		authors="Boopathi";
		testKeyword="TC36";
		LogoutStatus=true;
		usertype="CIBUser";

	}
//need to set up payment in admin login all days
	@Test(groups={"sanity"},dataProvider="fetch")

	public void otherSABBAccounts_PayNow(String casename,String GroupID ,String Username,String Password,String Otp,String accno,String transfertype,String fromCompany,String fromacc,String ToBeneficiary,String currency,String amount,String Purpose,String foryouracc,String auth1,String auth2,String frequency,String timesofday,String data3,String data4,String data5) throws Exception{
	
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

//.navigatePayreport()


.clickVendorPayments()
.paymentTab(transfertype, fromCompany, fromacc,ToBeneficiary)
.enterFundCurrencydetails(currency, amount)

.vendorPayments_Payment_OtherSabbAcc("Today","Pay Now", frequency, timesofday,Purpose,foryouracc)
.otphandling("click",prop.getProperty("Addbeneficiary.confirm.xpath"), null,null)
.otphandling("enter",prop.getProperty("Newdepost.otpenter.xpath"),Otp,null)
.otphandling("click",prop.getProperty("click.confirmbutton.xpath"), null,null)
.otphandling("getrefno",prop.getProperty("getref.number.beneficiary.xpath"), null,null)
		
	
	.navigatePaymentReportPage()

	.clickPaymentReports()
	.OwnPaymentFundTransferStatus(prop.getProperty("othersaab.acc.payreports.xpath"), "Pending Authorization","Pending Authorization","Tomorrow")
	
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
//.verifybellicon()
.clickpaymentMenu()
//
//.navigatePayreport()
//

.navigatepaymentDateline()
.datelinefilter("paymentdd.selecttype.xpath","Within Sabb Account Transfer Request","payment.status.xpath","Pending", getrefnumer, "Pending")
//.authorization()
.authorization_FundTransfer()
.datelinefilter("paymentdd.selecttype.xpath","Within Sabb Account Transfer Request","payment.status.xpath","Accepted", getrefnumer, "Accepted")
.navigatepayreport()

.clickPaymentReports()
.OwnPaymentFundTransferStatus(prop.getProperty("othersaab.acc.payreports.xpath"), "Success","Success","Tomorrow")
//.OwnPaymentStatus(prop.getProperty("othersaab.acc.payreports.xpath"), "Success","Success","Tomorrow")
.navigateStatementpage()
.clicktooltip()
.clickAccount()
.clickStatementMenu()


.verifystatementpage(accno)
.finalstatementpageBalance().logout(LogoutStatus,usertype);
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









/*
.clickOwnAccount()
//String fromcomp,String sourceAccno,String Tocomp,String toAccno,String currency,String amount,
//String auth1,String auth2,String data1,String data2,String data3,String data4,String data5,String data6,String data7) throws Exception{
.ownTranserpage("Today","Pay Now",fromcomp,sourceAccno,Tocomp,toAccno,currency,amount,frequency,timesofpay)
.fillOtp("OwnAccountOtpSubmit")
.verifysucessmsg()
.clickPaymentReports()
//own.acc.payreports.xpath
.PaymentStatus(prop.getProperty("own.acc.payreports.xpath"), "Pending Authorization","Pending Authorization","Today")
//.PaymentStatus("Own Account Transfer","Pending Authorization","Pending Authorization")
.clickpaymentdatelinemenu()
//.datelinefilter("paymentdd.selecttype.xpath","Own Account Transfer Request","payment.status.xpath","Pending", getrefnumer, "Pending")


.datelinefilter("paymentdd.selecttype.xpath","Own Account Transfer Request","payment.status.xpath","Pending", getrefnumer, "Pending")
.verifypaymentbuzz(auth1,auth2)

.logout(true);

getnewurl();
new	SaabHomePage(driver,test)
.enterGroupID(GroupID)
.enterUsernameID(AuthUsername)
.clickLoginButton()
.enterPassword(Password)
.clickSecureimage()
.clickLoginButtonFinal()
.submitTokenXpath(Otp)
.verifybellicon()
.clickpaymentMenu()
.navigatepaymentDateline()
.datelinefilter("paymentdd.selecttype.xpath","Own Account Transfer Request","payment.status.xpath","Pending", getrefnumer, "Pending")
.authorization()
.datelinefilter("paymentdd.selecttype.xpath","Own Account Transfer Request","payment.status.xpath","Accepted", getrefnumer, "Accepted")
.navigatepayreport()
.clickPaymentReports()
//.PaymentStatus("Own Account Transfer", "Pending Authorization","Pending")

.PaymentStatus(prop.getProperty("own.acc.payreports.xpath"), "Success","Success","Today")

.navigateStatementpage()
.clicktooltip()
.clickAccount()
.clickStatementMenu()
.verifystatementpage(accno)
.finalstatementpageBalance();



*/
