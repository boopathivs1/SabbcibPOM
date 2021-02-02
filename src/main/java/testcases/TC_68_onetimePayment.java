package testcases;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import pages.SaabHomePage;
import wrappers.ProjectWrapp;

public class TC_68_onetimePayment  extends ProjectWrapp
{
@BeforeClass(groups={"common"})
public void setDatag() {
	testCaseName="TC68 onetimePayment";

	testDescription="onetimePayment";	
	browserName="Chrome";
	dataSheetName="SaabCIBDev";
	category="Sanity";
	authors="Boopathi";
	testKeyword="TC68";
	LogoutStatus=true;
	usertype="CIBUser";


}
@Test(groups={"sanity"},dataProvider="fetch")
public void onetimePayment(String casename,String GroupID ,String Username,String Password,String Otp,String accno,String corpno,String fromcompany,String categoryselect,String billcomp,String plan,String billaccnum,String amount,String auth1,String auth2,String data1,String datas2,String datas3,String datas4,String data6,String dataf4) throws Exception{	
	
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
	.clickOneTimePaymentMenu()
	.oneTimePay(corpno, fromcompany, categoryselect, billcomp, plan, billaccnum, amount)
	.otphandling("click",prop.getProperty("Addbeneficiary.confirm.xpath"), null,null)
	.otphandling("enter",prop.getProperty("Newdepost.otpenter.xpath"),Otp,null)
	.otphandling("click",prop.getProperty("click.confirmbutton.xpath"), null,null)
	//.otphandling("verify",prop.getProperty("verify.previousinterimSucess.xpath"), null,"successfully")
	.otphandling("getrefno",prop.getProperty("getref.number.beneficiary.xpath"), null,null)

	
	
	
	
	
	
	.navigatePaymentReportPage()
	//	.navigatePaymentReportPage()
		.clickSadadPaymentReports()	
.sadadPaymentStatus("One Time Payment", "Pending Authorization","Pending Authorization","Today")
/*.clickpaymentdatelinemenu()
.datelinefilter("paymentdd.selecttype.xpath","One Time Payment","payment.status.xpath","Pending", getrefnumer, "Pending")
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
//	.verifybellicon()
	.clickSadadMenu()
	.navigatepaymentDateline()
	.datelinefilter("paymentdd.selecttype.xpath","One Time Payment","payment.status.xpath","Pending", getrefnumer, "Pending")
	.authorization()
	.datelinefilter("paymentdd.selecttype.xpath","One Time Payment","payment.status.xpath","Accepted", getrefnumer, "Accepted")
	/*.navigatepayreport()
	.clickSadadPaymentReports()
	.sadadPaymentStatus("One Time Payment", "Success","Success","Today")*/
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
