package testcases;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import pages.OtP_Page;
import pages.SaabHomePage;
import wrappers.ProjectWrapp;

public class TC_45_OWN_Account_SI  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC45 OWN Account SI";
		testDescription="OWN Account Standing Instruction - (Paylater to PayNow)";
		browserName="Chrome";
		dataSheetName="SaabCIBDev";
		category="Sanity";
		authors="Boopathi";
		testKeyword="TC45";
		LogoutStatus=true;
		usertype="CIBUser";

	}

	@Test(groups={"sanity"},dataProvider="fetch")

//	public void OtherSaabPayLater(String casename,String GroupID ,String Username,String Password,String Otp,String accno,String statementacc,String fromCompany,String fromacc,String transfertype,String currency,String amount,String Purpose,String foryouracc,String auth1,String auth2,String frequency,String timesofday,String data3,String data4,String data5) throws Exception{
		public void OtherSaabPayLater(String casename,String GroupID ,String Username,String Password,String Otp,
				String accno,String fromCompany,String fromacc,String transfertype,String foryouracc,String currencytype,
				String amount,String auth1,String auth2,String frequency,
				String data1,String timesofday,String data3,String data4,String data5,String data6) throws Exception{

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
.clickStandInstruction()
.SIfilter(fromCompany, fromacc, transfertype)
//.editStandIntrction("Pay Later")
.editStandpageIntrction("Pay Later")
//.fillSIPayLaterToPayNow("Pay Now","test","SAR","100","Weekly","4")
.fillSIPayLaterToPayNow("Pay Now",foryouracc,currencytype,amount,"null","null")

	.otphandling("click",prop.getProperty("Addbeneficiary.confirm.xpath"), null,null)
	.otphandling("enter",prop.getProperty("Newdepost.otpenter.xpath"),Otp,null)
	.otphandling("click",prop.getProperty("click.confirmbutton.xpath"), null,null)
	//.otphandling("verify",prop.getProperty("verify.previousinterimSucess.xpath"), null,"successfully")
	.otphandling("getrefno",prop.getProperty("getref.number.beneficiary.xpath"), null,null)
	
	.otphandlingNavigationPayDATELINE()
	/*	.clickpaymentdatelinemenu()
		.locatingframe()   //remove this method one filter issue clear

		
		//	.datelinefilter("paymentdd.selecttype.xpath","Own Account Transfer Request","payment.status.xpath","Pending", getrefnumer, "Pending")
	.verifypaymentbuzz(auth1,auth2)
*/	.logout(true,usertype);
		
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

.locatingframe()   //remove this method one filter issue clear
//.datelinefilter("paymentdd.selecttype.xpath","Own Account Transfer Request","payment.status.xpath","Pending", getrefnumer, "Pending")
.authorization()
//.datelinefilter("paymentdd.selecttype.xpath","Own Account Transfer Request","payment.status.xpath","Accepted", getrefnumer, "Accepted")
.navigatevendorPaymentspage()

.clickStandInstruction()
.SIfilter(fromCompany, fromacc, transfertype)

//.PayLaterToPayNow("Pay Later")
.PayLaterToPayNowCheck("Pay Later")
//navigatePaymentReportPage()
//.clickPaymentReports()
//.PaymentStatus(prop.getProperty("own.acc.payreports.xpath"), "Success","Success","Tomorrow")
.navigateStatpage()
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