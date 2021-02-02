package testcases;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import pages.SaabHomePage;
import wrappers.ProjectWrapp;

public class TC_73_MOI_Payment  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC73 MOI Payment";

		testDescription="MOI - Government Services (Payment)";
		browserName="Chrome";
		dataSheetName="SaabCIBDev";
		category="Sanity";
		authors="Boopathi";
		testKeyword="TC73";
		LogoutStatus=true;
		usertype="CIBUser";

	}

	@Test(groups={"sanity"},dataProvider="fetch")

		public void moiPayment(String casename,String GroupID ,String Username,String Password,
				String Otp,String accno,
				String TransType,String moiservices,String servicetype,String corporate,String moiAccount,
				String violatorid,String issuingentity,String category,String auth1,String auth2,String currency,String data4,String purposeoftransfer,String data11,String datass) throws Exception{

//		getrefnumer="DT-26172501";	

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
.moiPaymentFormFill(TransType, moiservices, servicetype, corporate,moiAccount, violatorid, issuingentity, category)
.otphandling("click",prop.getProperty("click.confirmbutton.xpath"), null,null)
.otphandling("enter",prop.getProperty("Newdepost.otpenter.xpath"),Otp,null)
.otphandling("click",prop.getProperty("click.confirmbutton.xpath"), null,null)
//.otphandling("verify",prop.getProperty("verify.submit.sucess.xpath"), null,"request initiated successfully")
.otphandling("getrefno",prop.getProperty("getref.number.beneficiary.xpath"), null,null)
.otphandlingNavigation()



.clickmoireportslink()

.MoiPaymentStatus("MOI Payment", "Pending Authorization","Pending Authorization","Today")
/*.clickpaymentdatelinemenu()
.datelinefilter("paymentdd.selecttype.xpath","MOI Payment Request","payment.status.xpath","Pending", getrefnumer, "Pending")
.verifypaymentbuzz(auth1,auth2)*/
//.logout(true);
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
.clickMoiMenu()
//.clickpaymentMenu()
.navigatepaymentDateline()
.datelinefilter("paymentdd.selecttype.xpath","MOI Payment Request","payment.status.xpath","Pending", getrefnumer, "Pending")
.authorization()
//.authorizationfromDateline()
.datelinefilter("paymentdd.selecttype.xpath","MOI Payment Request","payment.status.xpath","Accepted", getrefnumer, "Accepted")
/*.navigatemoipayreport()
.clickmoireportslink()
.MoiPaymentStatus("MOI Payment","Success","Success","Today")*/
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
