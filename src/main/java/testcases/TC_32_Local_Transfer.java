package testcases;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import pages.SaabHomePage;
import wrappers.ProjectWrapp;

public class TC_32_Local_Transfer extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC32 Delete Beneficiary - Local Transfer";

		testDescription="Delete Beneficiary - Local Transfer (SARIE)";
		browserName="Chrome";
		dataSheetName="SaabCIBDev";
		category="Sanity";
		authors="Boopathi";
		testKeyword="TC32";
		LogoutStatus=true;
		usertype="CIBUser";

	}

	@Test(groups={"sanity"},dataProvider="fetch")

		public void deleteBeneficiaryLocalTransfer(String casename,String GroupID ,String Username,String Password,String Otp,String CorpValue,String TransferValue,String localbenename,String IbanNo,String TransferPurpose,String Remarks,String auth1,String auth2,String data1,String data4,String data5,String data6,String data7,String data8,String data10,String data11) throws Exception{
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
.clickVendorPayments()
.clickBeneficiaryMenu()
.addBeneficiaryFilter(CorpValue,TransferValue)
.clickPayeeCode()
.deleteBeneficiaryaccNopresent(IbanNo)
//.verifyelementBeneficiaryNotpresent(saabaccno)
//.verifyBeneficiaryAccNotpresent(saabaccno)
.otphandling("click",prop.getProperty("Addbeneficiary.confirm.xpath"), null,null)

.otphandling("enter",prop.getProperty("Newdepost.otpenter.xpath"),Otp,null)
.otphandling("click",prop.getProperty("click.confirmbutton.xpath"), null,null)
//.otphandling("verify",prop.getProperty("verify.previousinterimSucess.xpath"), null,"request initiated successfully")
.otphandling("getrefno",prop.getProperty("getref.number.beneficiary.xpath"), null,null)
//.otphandlingNavigation()
.otphandlingNavigationPayDATELINE()
/*
.clickpaymentdatelinemenu()
.datelinefilter("paymentdd.selecttype.xpath","Beneficiary Maintenance Request","payment.status.xpath","Pending", getrefnumer, "Pending")
.verifypaymentbuzz(auth1,auth2)
*/.logout(true,usertype);


AuthUsername=auth1;
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
.datelinefilter("paymentdd.selecttype.xpath","Beneficiary Maintenance Request","payment.status.xpath","Pending", getrefnumer, "Pending")
//.authorization()
.authorizationfromDateline()

.datelinefilter("paymentdd.selecttype.xpath","Beneficiary Maintenance Request","payment.status.xpath","Accepted", getrefnumer, "Accepted")
.navigatevendorPaymentspage()

.clickVendorPayments()
.clickBeneficiaryMenu()
.addBeneficiaryFilter(CorpValue,TransferValue)
.clickPayeeCode()
//.verifyBeneficiaryAccNotpresent(saabaccno);

//.verifyelementBeneficiaryNotpresent(IbanNo);
//.verifyelementBeneficiaryNotpresent(saabaccno);
//.verifyelementBeneficiaryNotpresent(saabaccno);

//.deleteBeneficiaryaccNopresent(IbanNo);

.verifydeleteBeneficiary(IbanNo).logout(LogoutStatus,usertype);
/*
getnewurl();
new	SaabHomePage(driver,test)
.enterGroupID(GroupID)
.enterUsernameID(Username)
.clickLoginButton()
.enterPassword(Password)
.clickSecureimage()
.clickLoginButtonFinal()
.submitTokenXpath(Otp)
.clickpaymentMenu()
.clickVendorPayments()
.clickBeneficiaryMenu()
.addBeneficiaryFilter(CorpValue,TransferValue)
.clickPayeeCode()
.verifyBeneficiaryaccpresent(IbanNo)
.logout(LogoutStatus,usertype);
*/
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