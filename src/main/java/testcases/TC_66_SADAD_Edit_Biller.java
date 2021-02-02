package testcases;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import pages.SaabHomePage;
import wrappers.ProjectWrapp;

public class TC_66_SADAD_Edit_Biller  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC66 SADAD - Edit Biller";

		testDescription="SADAD - Edit Biller";
		browserName="Chrome";
		dataSheetName="SaabCIBDev";
		category="Sanity";
		authors="Boopathi";
		testKeyword="TC66";
		LogoutStatus=true;
		usertype="CIBUser";

	}

	@Test(groups={"sanity"},dataProvider="fetch")

		public void sadadEditBiller(String casename,String GroupID ,String Username,String Password,String Otp,String CorpBillname,String Category,
				String billcomp,String NickName,String updatenickname,String data2,String data3,String data4,String data5,String data6,String data7,String data8,String data10,String data11,String data12,String data14) throws Exception{

		
	try{	
		new	SaabHomePage(driver,test)
.enterGroupID(GroupID)
.enterUsernameID(Username)
.clickLoginButton()
.enterPassword(Password)
.clickSecureimage()
.clickLoginButtonFinal()
.submitTokenXpath(Otp)
.clickSadadMenu()
.clickAddManegBills()
.addMangebillsFilter(CorpBillname,Category,billcomp)

.editManageBills(NickName,updatenickname)
.otphandling("click",prop.getProperty("click.confirmbutton.xpath"), null,null)
.otphandling("enter",prop.getProperty("Newdepost.otpenter.xpath"),Otp,null)
.otphandling("click",prop.getProperty("click.confirmbutton.xpath"), null,null)
.verifyServerError()
.otphandling("getrefno",prop.getProperty("getref.number.beneficiary.xpath"), null,null)
//.otphandling("verify",prop.getProperty("addbiller.verify.submit.xpath"), null,"Successfully")
//.NavigationSADADpage()
//.clickAddManegBills()
//.addMangebillsFilter(CorpBillname,Category,billcomp)

//.verifyaddedBiller(updatenickname)
.logout(LogoutStatus,usertype);
		
		AuthUsername="sridhar05";
		getnewurl();
		new	SaabHomePage(driver,test)
		.enterGroupID(GroupID)
		.enterUsernameID(AuthUsername)
		.clickLoginButton()
		.enterPassword(Password)
		.clickSecureimage()
		.clickLoginButtonFinal()
		.submitTokenXpath(Otp)
//		.verifybellicon()
		.clickSadadMenu()
//		.clickpaymentMenu()
		.navigatepaymentDateline()

	//.locatingframe()   //remove this method one filter issue clear

		.datelinefilter("paymentdd.selecttype.xpath","Biller Management Request","payment.status.xpath","Pending", getrefnumer, "Pending")
		.authorization()
		.datelinefilter("paymentdd.selecttype.xpath","Biller Management Request","payment.status.xpath","Accepted", getrefnumer, "Accepted")
		.navigatevendorPaymentspage()


		
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