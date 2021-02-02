package testcases;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import pages.SaabHomePage;
import wrappers.ProjectWrapp;

public class TC40_Local_Transfer_Pay_Later  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC40 Local Transfer Pay Later";

		testDescription="Local Transfer Pay Later";
		browserName="Chrome";
		dataSheetName="SaabCIBDev";
		category="Sanity";
		authors="Boopathi";
		testKeyword="TC40";
		LogoutStatus=true;
		usertype="CIBUser";

	}

	@Test(groups={"sanity"},dataProvider="fetch")

	public void localPayLater(String casename,String GroupID ,String Username,String Password,String Otp,String accno,String transfertype,String fromCompany,String fromacc,String ToBeneficiary,String currency,String amount,String Purpose,String foryouracc,String auth1,String auth2,String frequency,String timesofday,String data3,String data4,String data5) throws Exception{
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
.clickVendorPayments()
.paymentTab(transfertype, fromCompany, fromacc,ToBeneficiary)
.enterFundCurrencydetails(currency, amount)
//.enterLocalOtherCurrencydetails(currency, amount)
//.vendorPayments_Payment_OtherSabbAcc(currency, amount,"Tomorrow","Pay Later", frequency, timesofday,Purpose,foryouracc);
	.vendorPayments_Payment_OtherSabbAcc("Tomorrow","Pay Later", frequency, timesofday,Purpose,foryouracc)
	.otphandling("click",prop.getProperty("Addbeneficiary.confirm.xpath"), null,null)
	.otphandling("enter",prop.getProperty("Newdepost.otpenter.xpath"),Otp,null)
	.otphandling("click",prop.getProperty("click.confirmbutton.xpath"), null,null)
//	.otphandling("verify",prop.getProperty("verify.previousinterimSucess.xpath"), null,"successfully")
	.otphandling("getrefno",prop.getProperty("getref.number.beneficiary.xpath"), null,null)
	.navigatePaymentReportPage()
	.clickPaymentReports()
//	.OwnPaymentStatus(prop.getProperty("localtransfer.xpath"), "Pending Authorization","Pending Authorization","Tomorrow")
	.OwnPaymentFundTransferStatus(prop.getProperty("localtransfer.xpath"), "Pending Authorization","Pending Authorization","Tomorrow")
	
	/*	.clickpaymentdatelinemenu()
	.datelinefilter("paymentdd.selecttype.xpath","Local Transfer Request","payment.status.xpath","Pending", getrefnumer, "Pending")
	.verifypaymentbuzz(auth1,auth2)
	*/.logout(true,usertype);

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
.navigatepaymentDateline()
.datelinefilter("paymentdd.selecttype.xpath","Local Transfer Request","payment.status.xpath","Pending", getrefnumer, "Pending")
//.authorizationLocalTransfer()
.authorization_FundTransfer()
.datelinefilter("paymentdd.selecttype.xpath","Local Transfer Request","payment.status.xpath","Accepted", getrefnumer, "Accepted")
.navigatepayreport()
.clickPaymentReports()
.OwnPaymentFundTransferStatus(prop.getProperty("localtransfer.xpath"), "Success","Success","Tomorrow")
//.OwnPaymentStatus(prop.getProperty("localtransfer.xpath"), "Success","Success","Tomorrow")
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
