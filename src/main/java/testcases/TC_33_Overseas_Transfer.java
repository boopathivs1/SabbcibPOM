package testcases;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import pages.SaabHomePage;
import wrappers.ProjectWrapp;

public class TC_33_Overseas_Transfer  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC33-Overseas Transfer";

		testDescription="Create Beneficiary - Overseas Transfer";
		browserName="Chrome";
		dataSheetName="SaabCIBDev";
		category="Sanity";
		authors="Boopathi";
		testKeyword="TC33";
		LogoutStatus=true;
		usertype="CIBUser";

	}

	@Test(groups={"sanity"},dataProvider="fetch")

	public void createBeneficiaryOverseasTransfer(String casename,String GroupID ,String Username,String Password,
			String Otp,String CorpValue,String TransferValue,
			String overseasBeneficiaryname,String overseasBeneficiaryaddress,	String country,	String city,String branch,
			String currency,String IBAN,String purposeoftransfer,String remarks,String foryouracc,String auth1,String auth2,String data1,String data4) throws Exception{

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
.addbeneficiarylink()
.addbeneficiaryform(CorpValue,TransferValue)
.addBeneficiaryOverseasAcc(overseasBeneficiaryname,overseasBeneficiaryaddress, country, city, branch, currency, IBAN, purposeoftransfer, remarks,foryouracc)
//.addbeneficiaryOtherSabbAcc(sabbacc, TransferPurpose, Remarks)
.otphandling("click",prop.getProperty("click.confirmbutton.xpath"), null,null)
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
.addBeneficiaryFilter(CorpValue,TransferValue)
.clickPayeeCode()
.accPaginationVerify(IBAN)
.verifyBeneficiaryaccpresent(IBAN)
.logout(LogoutStatus,usertype);



//////
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
.verifyBeneficiaryaccpresent(IBAN)
.logout(LogoutStatus,usertype);

loginfoSuccess(testCaseName,testDescription);
}




catch (Exception e) {
	logfailed(testCaseName,testDescription);
	log.error(e);
logout(LogoutStatus,usertype);
throw new Exception();

//TODO: handle exception
}





}}	
