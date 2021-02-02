package testcases;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import pages.SaabHomePage;
import wrappers.ProjectWrapp;

public class TC_65a_SADAD_ADD_Biller  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC65a SADAD - ADD Biller";

		testDescription="SADAD - ADD Biller";
		browserName="Chrome";
		dataSheetName="SaabCIBDev";
		category="Sanity";
		authors="Boopathi";
		testKeyword="TC65a";
		LogoutStatus=true;
		usertype="CIBUser";

	}

	@Test(groups={"sanity"},dataProvider="fetch")


		public void sadadAddBiller(String casename,String GroupID ,String Username,String Password,String Otp,String CorpBillname,String Categoryname,
				String billcomp,String plan,	String BillAccNo,	String NickName,String data1,String data2,String data3,String data4,String data5,String data6,String data7,String data8,String data10,String data11) throws Exception{
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
.clickAddBillsLink()
.fillAddBills(CorpBillname,Categoryname,billcomp,plan,BillAccNo,NickName)
.otphandling("click",prop.getProperty("click.confirmbutton.xpath"), null,null)
.otphandling("enter",prop.getProperty("Newdepost.otpenter.xpath"),Otp,null)
.otphandling("click",prop.getProperty("click.confirmbutton.xpath"), null,null)
//.verifyServerError()
.otphandling("getrefno",prop.getProperty("getref.number.beneficiary.xpath"), null,null)

//.otphandling("verify",prop.getProperty("addbiller.verify.submit.xpath"), null,"Successfully")
//.NavigationSADADpage()
//.clickAddManegBills()
//.addMangebillsFilter(CorpBillname,Categoryname,billcomp)
//.verifyaddedBiller(NickName)
.logout(LogoutStatus,usertype);
		

//		getrefnumer="DT-28072937";

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
