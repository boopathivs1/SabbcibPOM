package testcases;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import pages.SaabHomePage;
import wrappers.ProjectWrapp;

public class TC_69_SADAD_Bill_Inquiry  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC69 SADAD Bill Inquiry Payment";

		testDescription="SADAD Bill Inquiry and Payment (Singe BIll Selection)";
		browserName="Chrome";
		dataSheetName="SaabCIBDev";
		category="Sanity";
		authors="Boopathi";
		testKeyword="TC69";
		LogoutStatus=true;
		usertype="CIBUser";

	}

	@Test(groups={"sanity"},dataProvider="fetch")

	public void billInquirySingleSelection(String casename,String GroupID ,String Username,String Password,String Otp,String accno,
			String amount,String corpno,String fromaccnum,String auth1,String auth2,String categorybill,String billcompany,String datas3,String datas4,
			String data6,String dataf4,String dataf4d,String data6j,String dataf4p,String dataf4dgk) throws Exception{	
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
	
		.clickSadadMenu()
.clickBillInquiry()
//. billInquiryFilter(corpno)

.billInquirySingleMultiFilter(corpno,categorybill, billcompany)
.billInquiryFormSubmit(amount,corpno,fromaccnum,"null")
.otphandling("click",prop.getProperty("Addbeneficiary.confirm.xpath"), null,null)
.otphandling("enter",prop.getProperty("Newdepost.otpenter.xpath"),Otp,null)
.otphandling("click",prop.getProperty("click.confirmbutton.xpath"), null,null)
//.otphandling("verify",prop.getProperty("verify.previousinterimSucess.xpath"), null,"successfully")
.otphandling("getrefno",prop.getProperty("getref.number.beneficiary.xpath"), null,null)


.navigatePaymentReportPage()
//	.navigatePaymentReportPage()
	.clickSadadPaymentReports()	
.sadadPaymentStatus("BillInquiry and Payment", "Pending Authorization","Pending Authorization","Today")
/*.clickpaymentdatelinemenu()
.datelinefilter("paymentdd.selecttype.xpath","BillInquiry and Payment Request","payment.status.xpath","Pending", getrefnumer, "Pending")
.verifypaymentbuzz(auth1,auth2)
*/
.logout(true,usertype);	
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
.clickSadadMenu()
.navigatepaymentDateline()
.datelinefilter("paymentdd.selecttype.xpath","BillInquiry and Payment Request","payment.status.xpath","Pending", getrefnumer, "Pending")
.authorization()
.datelinefilter("paymentdd.selecttype.xpath","BillInquiry and Payment Request","payment.status.xpath","Accepted", getrefnumer, "Accepted")
.navigatepayreport()
.clickSadadPaymentReports()
.sadadPaymentStatus("BillInquiry and Payment", "Success","Success","Today")
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
