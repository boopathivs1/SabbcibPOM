package testcases;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import pages.SaabHomePage;
import wrappers.ProjectWrapp;

public class TC_31_Local_Transfer  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC31-Local Transfer";

		testDescription="Edit Beneficiary - Local Transfer (SARIE)";
		browserName="Chrome";
		dataSheetName="SaabCIBDev";
		category="Sanity";
		authors="Boopathi";
		testKeyword="TC31";
		LogoutStatus=true;
		usertype="CIBUser";

	}

	@Test(groups={"sanity"},dataProvider="fetch")

//	public void FilterPositiveCase(String casename,String GroupID ,String Username,String Password,String Otp,String CorpValue,String TransferValue,String acc,String TransferPurpose,String Remarks,String auth1,String auth2,String saabaccno,String editbeneficiarName,String data5,String data6,String data7,String data8,String data10,String data11,String data12) throws Exception{
		public void editBeneficiaryLocalTransfer(String casename,String GroupID ,String Username,String Password,String Otp,String CorpValue,String TransferValue,String localbenename,String IbanNo,String TransferPurpose,String Remarks,String auth1,String auth2,String forbeneficiary,String data4,String data5,String data6,String data7,String data8,String data10,String data11) throws Exception{

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
.editBeneficiaryaccNopresent(IbanNo)
//.submitEditbeneficiary(TransferPurpose)


.submitLocalEditbeneficiary(TransferPurpose,forbeneficiary)
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
//.verifyBeneficiaryaccNopresent("1234567");
//.verifyBeneficiaryaccNopresent(CorpValue,TransferValue,saabaccno);
.addBeneficiaryFilter(CorpValue,TransferValue)
.clickPayeeCode()
//.verifyUpdatedBeneficiaryacc(saabaccno,editbeneficiarName)
.editBeneficiaryverify(IbanNo,"purpose.verify.localbeneficiary.xpath",TransferPurpose)

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
.verifyBeneficiaryaccpresent(IbanNo);



*/


.logout(LogoutStatus,usertype);
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

