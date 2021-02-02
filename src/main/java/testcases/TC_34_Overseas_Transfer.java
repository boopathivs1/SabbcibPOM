package testcases;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import pages.SaabHomePage;
import wrappers.ProjectWrapp;

public class TC_34_Overseas_Transfer  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC34_Edit Beneficiary- Overseas Transfer";

		testDescription="Edit Beneficiary - Overseas Transfer";
		browserName="Chrome";
		dataSheetName="SaabCIBDev";
		category="Sanity";
		authors="Boopathi";
		testKeyword="TC34";
		LogoutStatus=true;
		usertype="CIBUser";

	}

	@Test(groups={"sanity"},dataProvider="fetch")

		public void editBeneficiaryOverseasTransfer(String casename,String GroupID ,String Username,String Password,String Otp,String CorpValue,String TransferValue,
				String overseasBeneficiaryname,String overseasBeneficiaryaddress,	String country,	String city,String branch,String currency,String IBANno,String purposeoftransfer,String remarks,String foryouracc,String auth1,String auth2,String data1,String data4) throws Exception{

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
.accPaginationVerify(IBANno)
.editBeneficiaryaccNopresent(IBANno)

.submitEditbeneficiaryoverseas(purposeoftransfer)
//.addbeneficiarylink()
//.addbeneficiaryform(CorpValue,TransferValue)
//.addbeneficiaryOtherSabbAcc(sabbacc, TransferPurpose, Remarks)
.otphandling("click",prop.getProperty("click.confirmbutton.xpath"), null,null)
.otphandling("enter",prop.getProperty("Newdepost.otpenter.xpath"),Otp,null)
.otphandling("click",prop.getProperty("click.confirmbutton.xpath"), null,null)
//.otphandling("verify",prop.getProperty("verify.previousinterimSucess.xpath"), null,"request initiated successfully")
.otphandling("getrefno",prop.getProperty("getref.number.beneficiary.xpath"), null,null)
.otphandlingNavigationPayDATELINE()
/*.clickpaymentdatelinemenu()
.datelinefilter("paymentdd.selecttype.xpath","Beneficiary Maintenance Request","payment.status.xpath","Pending", getrefnumer, "Pending")
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
.datelinefilter("paymentdd.selecttype.xpath","Beneficiary Maintenance Request","payment.status.xpath","Pending", getrefnumer, "Pending")
//.authorization()
.authorizationfromDateline()

.datelinefilter("paymentdd.selecttype.xpath","Beneficiary Maintenance Request","payment.status.xpath","Accepted", getrefnumer, "Accepted")
.navigatevendorPaymentspage()

.clickVendorPayments()
.clickBeneficiaryMenu()
//.verifyBeneficiaryaccNopresent("1234567");
//.verifyBeneficiaryaccNopresent(CorpValue,TransferValue,saabaccno);
.addBeneficiaryFilter(CorpValue,TransferValue)
.clickPayeeCode()
.accPaginationVerify(IBANno)
.editBeneficiaryaccpresent(IBANno)
.verifyeditedaccDetailsverify(IBANno,purposeoftransfer).logout(LogoutStatus,usertype);
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
};



/*
.logout(true);






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
.verifyBeneficiaryaccpresent(IBANno);

*/





