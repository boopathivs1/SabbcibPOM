package testcases;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import pages.SaabHomePage;
import wrappers.ProjectWrapp;

public class TC_92_Matrix_Creation  extends ProjectWrapp
{
@BeforeClass(groups={"common"})
public void setDatag() {
	testCaseName="TC92 Matrix Creation";

	testDescription="Matrix Creation No Check";	
	browserName="Chrome";
	dataSheetName="SaabCIBDev";
	category="Sanity";
	authors="Boopathi";
	testKeyword="TC92";
	LogoutStatus=true;
	usertype="CIBUser";

}

@Test(groups={"sanity"},dataProvider="fetch")
public void MatrixCreationNoCheck(String casename,String GroupID ,String Username,String Password,String Otp,String groupName,String corpid,String fromAccno,String moduleName,String Accno,String Submodulename,String functiondropdown,String authtype,String auth1,String auth2,String data16,String data17,String data18,String data19,String data20,String data21) throws Exception{	
	
	try{
	new SaabHomePage(driver, test)
	.enterGroupID(GroupID)
	.enterUsernameID(Username)
	.clickLoginButton()
	.enterPassword(Password)
	.clickSecureimage()
	.clickLoginButtonFinal()
	.submitTokenXpath(Otp)
	.clickAdmin()
	.clickMatrixPage()
	.clickMatrixAssignCorporatePage(groupName)
	.clickAccessRights(corpid)
	.matrixCreation(fromAccno,moduleName,Accno,Submodulename,functiondropdown,authtype)
.clickDatelinemenu()
.verifyAdminbuzz(auth1,auth2, "Authorization Matrix Configuration Creation Request")

.logout(true,usertype);	
	AuthUsername=auth1;


		
	//AuthUsername="sridhar03";
	//getrefnumer="DT-26195534";
	
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
	.clickAdmin()
	.locateframe()
//.datelinefilter("paymentdd.selecttype.xpath","Corporate User Profile Request","payment.status.xpath","Pending", getrefnumer, "Pending")
.authorization()
//	.datelinefilter("paymentdd.selecttype.xpath","Corporate User Profile Request","payment.status.xpath","Accepted", getrefnumer, "Accepted")

	.clickMatrixPage()
	.clickMatrixAssignCorporatePage(groupName)
	.clickAccessRights(corpid)
	
	.matrixCreationFilter(fromAccno,moduleName)
	.matrixResult(Accno,Submodulename)


.verifyMatrixPresent(functiondropdown,authtype)
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

	
