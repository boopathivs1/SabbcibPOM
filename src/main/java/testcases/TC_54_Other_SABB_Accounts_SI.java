package testcases;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import pages.SaabHomePage;
import wrappers.ProjectWrapp;

public class TC_54_Other_SABB_Accounts_SI  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC54 Other SABB Accounts SI";
		testDescription="Other SABB Accounts Standing Instruction - (Paylater Update)";
		browserName="Chrome";
		dataSheetName="SaabCIBDev";
		category="Sanity";
		authors="Boopathi";
		testKeyword="TC54";
		LogoutStatus=true;
		usertype="CIBUser";

	}

	@Test(groups={"sanity"},dataProvider="fetch")

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

.fillSIPayLaterToPayNow("Pay Later",foryouracc,currencytype,amount,"null","null")
//.fillSIPayLaterToPayNow("Pay Later","test","SAR","40","Weekly","null")

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

//	.datelinefilter("paymentdd.selecttype.xpath","Own Account Transfer Request","payment.status.xpath","Pending", getrefnumer, "Pending")
	.authorization()
	//.datelinefilter("paymentdd.selecttype.xpath","Own Account Transfer Request","payment.status.xpath","Accepted", getrefnumer, "Accepted")
	
	
	.navigatevendorPaymentspage()
	
	.clickStandInstruction()
	.SIfilter(fromCompany, fromacc, transfertype)
	//.verifyaccNoUpate("Pay Later")
	.verifyaccNoUpateonly("Pay Later")
	.PayLaterUpdateVerify(foryouracc, amount)


//.PayLaterUpdate("Pay Later","Pay Later",foryouracc,amount)
//	.navigatePaymentReportPage()
.navigateStatpage()
//	.clickPaymentReports()
//	.PaymentStatus(prop.getProperty("othersaab.acc.payreports.xpath"), "Success","Success","Tomorrow")
//	.navigateStatementpage()
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

