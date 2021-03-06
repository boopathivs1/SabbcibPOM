package testcases;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import pages.SaabHomePage;
import wrappers.ProjectWrapp;

public class TC_74_MOI_Refund  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC74 MOI_Refund";

		testDescription="MOI - Government Services (Refund)";
		browserName="Chrome";
		dataSheetName="SaabCIBDev";
		category="Sanity";
		authors="Boopathi";
		testKeyword="TC74";
		LogoutStatus=true;
		usertype="CIBUser";

	}

	@Test(groups={"sanity"},dataProvider="fetch")

		public void moiRefund(String casename,String GroupID ,String Username,String Password,
				String Otp,String accno,
				String TransType,String moiservices,String servicetype,String corporate,String moiAccount,
				String citizenid,String auth1,String auth2,String currency,String IBANno,String purposeoftransfer,
				String remarks,String foryouracc,String data,String data1) throws Exception{

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
.clickMoiMenu()
.clickMoigovernmentServicesMenu()
.moiRefundFormFill(TransType,moiservices,servicetype,corporate,moiAccount,citizenid)
.otphandling("click",prop.getProperty("click.confirmbutton.xpath"), null,null)
.otphandling("enter",prop.getProperty("Newdepost.otpenter.xpath"),Otp,null)
.otphandling("click",prop.getProperty("click.confirmbutton.xpath"), null,null)
//.otphandling("verify",prop.getProperty("verify.submit.sucess.xpath"), null,"request initiated successfully")
.otphandling("getrefno",prop.getProperty("getref.number.beneficiary.xpath"), null,null)
.otphandlingNavigation()
.clickmoireportslink()
.MoiPaymentStatus("MOI Refund", "Pending Authorization","Pending Authorization","Today")
/*.clickpaymentdatelinemenu()
.datelinefilter("paymentdd.selecttype.xpath","MOI Refund Request","payment.status.xpath","Pending", getrefnumer, "Pending")
.verifypaymentbuzz(auth1,auth2)*/
//.logout(true);
.logout(true,usertype);	

//AuthUsername="sridhar03";
//getrefnumer="DT-26090860";
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
/*.verifybellicon()*/
.clickMoiMenu()
//.clickpaymentMenu()
.navigatepaymentDateline()
.datelinefilter("paymentdd.selecttype.xpath","MOI Refund Request","payment.status.xpath","Pending", getrefnumer, "Pending")
.authorization()
//.authorizationfromDateline()
.datelinefilter("paymentdd.selecttype.xpath","MOI Refund Request","payment.status.xpath","Accepted", getrefnumer, "Accepted")


/*
.navigatemoipayreport()
.clickmoireportslink()
.MoiPaymentStatus("MOI Refund","Success","Success","Today")
*/
.navigateStatementpage()
.switchdefaultcontent()
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
