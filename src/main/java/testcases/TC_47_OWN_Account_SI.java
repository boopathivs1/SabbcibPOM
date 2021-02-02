package testcases;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import pages.SaabHomePage;
import wrappers.ProjectWrapp;

public class TC_47_OWN_Account_SI  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC47 OWN Account SI";
		testDescription="OWN Account Standing Instruction - (Repeat Update)";
		browserName="Chrome";
		dataSheetName="SaabCIBDev";
		category="Sanity";
		authors="Boopathi";
		testKeyword="TC47";
		LogoutStatus=true;
		usertype="CIBUser";

	}

	@Test(groups={"sanity"},dataProvider="fetch")

//	public void OtherSaabPayLater(String casename,String GroupID ,String Username,String Password,String Otp,String accno,String statementacc,String fromCompany,String fromacc,String transfertype,String currency,String amount,String Purpose,String foryouracc,String auth1,String auth2,String frequency,String timesofday,String data3,String data4,String data5) throws Exception{
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
.editStandpageIntrction("Repeat")

//.editStandIntrction("Repeat")
.fillSIPayLaterToPayNow("RepeatUpdate",foryouracc,currencytype,amount,frequency,RepeatSkipcount)




		.otphandling("click",prop.getProperty("Addbeneficiary.confirm.xpath"), null,null)
		.otphandling("enter",prop.getProperty("Newdepost.otpenter.xpath"),Otp,null)
		.otphandling("click",prop.getProperty("click.confirmbutton.xpath"), null,null)
		//.otphandling("verify",prop.getProperty("verify.previousinterimSucess.xpath"), null,"successfully")
		.otphandling("getrefno",prop.getProperty("getref.number.beneficiary.xpath"), null,null)
		.otphandlingNavigationPayDATELINE()


		
/*		
		.clickpaymentdatelinemenu()
.locatingframe()   //remove this method one filter issue clear

		
//		.datelinefilter("paymentdd.selecttype.xpath","Within Sabb Account Transfer Request","payment.status.xpath","Pending", getrefnumer, "Pending")
		.verifypaymentbuzz(auth1,auth2)
	*/	.logout(true,usertype);



	//	AuthUsername="sridhar03";
		//	getrefnumer="STANDING_INSTRUCTION-20017";		
		//	SIrefnumer="124812B603510076";
	//SkippedCount="1";
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
	/*
	.locatingframe()   //remove this method one filter issue clear

//	.datelinefilter("paymentdd.selecttype.xpath","Within Sabb Account Transfer Request","payment.status.xpath","Pending", getrefnumer, "Pending")
	.authorization()
	//.datelinefilter("paymentdd.selecttype.xpath","Within Sabb Account Transfer Request","payment.status.xpath","Accepted", getrefnumer, "Accepted")
*/
	.navigatevendorPaymentspage()

	.clickStandInstruction()
	.SIfilter(fromCompany, fromacc, transfertype)
//	.verifyaccNoUpate("Repeat")
	.verifyaccNoUpateonly("Repeat")

	
.skipVerify("Repeat",foryouracc,amount,RepeatSkipcount,"Repeat")
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

