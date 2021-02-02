package testcases;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import pages.SaabHomePage;
import wrappers.ProjectWrapp;

public class TC_48_OWN_Account_SI  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC48 OWN Account SI";
		testDescription="OWN Account Standing Instruction - (Repeat to SKIP)";
		browserName="Chrome";
		dataSheetName="SaabCIBDev";
		category="Sanity";
		authors="Boopathi";
		testKeyword="TC48";
		LogoutStatus=true;
		usertype="CIBUser";

	}
	@Test(groups={"sanity"},dataProvider="fetch")
	public void OtherSaabPayLater(String casename,String GroupID ,String Username,String Password,String Otp,
			String accno,String fromCompany,String fromacc,String transfertype,String foryouracc,String currencytype,
			String amount,String auth1,String auth2,String frequency,
			String RepeatSkipcount,String timesofday,String data3,String data4,String data5,String data6) throws Exception{

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
//.editStandIntrction("Repeat")
.editStandpageIntrction("Repeat")

.fillSIPayLaterToPayNow("RepeatToSKIP",foryouracc,currencytype,amount,frequency,RepeatSkipcount)

		.otphandling("click",prop.getProperty("Addbeneficiary.confirm.xpath"), null,null)
		.otphandling("enter",prop.getProperty("Newdepost.otpenter.xpath"),Otp,null)
		.otphandling("click",prop.getProperty("click.confirmbutton.xpath"), null,null)
		//.otphandling("verify",prop.getProperty("verify.previousinterimSucess.xpath"), null,"successfully")
		.otphandling("getrefno",prop.getProperty("getref.number.beneficiary.xpath"), null,null)
		
		.otphandlingNavigationPayDATELINE()
		/*.clickpaymentdatelinemenu()

		
		//		.navigatePaymentReportPage()
	//	.clickPaymentReports()
		//.PaymentStatus(prop.getProperty("othersaab.acc.payreports.xpath"), "Pending Authorization","Pending Authorization","Tomorrow")
		//.clickpaymentdatelinemenu()
.locatingframe()   //remove this method one filter issue clear
//		.datelinefilter("paymentdd.selecttype.xpath","Within Sabb Account Transfer Request","payment.status.xpath","Pending", getrefnumer, "Pending")
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

	//.datelinefilter("paymentdd.selecttype.xpath","Within Sabb Account Transfer Request","payment.status.xpath","Pending", getrefnumer, "Pending")
	.authorization()
//	.datelinefilter("paymentdd.selecttype.xpath","Within Sabb Account Transfer Request","payment.status.xpath","Accepted", getrefnumer, "Accepted")

	.navigatevendorPaymentspage()

	.clickStandInstruction()
	.SIfilter(fromCompany, fromacc, transfertype)
	.verifyaccNoUpateonly("Repeat")

	
//	.verifyaccNoUpate("Repeat")

	.skipVerify("Repeat",foryouracc,amount,"null","Skip")
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

