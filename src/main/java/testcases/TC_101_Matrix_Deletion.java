package testcases;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import pages.SaabHomePage;
import wrappers.ProjectWrapp;

public class TC_101_Matrix_Deletion  extends ProjectWrapp
{
@BeforeClass(groups={"common"})
public void setDatag() {
	testCaseName="TC101 Matrix Deletion";

	testDescription="Matrix Deletion - Parallel Auth";	
	browserName="Chrome";
	dataSheetName="SaabCIBDev";
	category="Sanity";
	authors="Boopathi";
	testKeyword="TC101";
	LogoutStatus=true;
	usertype="CIBUser";
}

@Test(groups={"sanity"},dataProvider="fetch")
	public void MatrixCreationNoCheck(String casename,String GroupID ,String Username,String Password,
			String Otp,String groupName,String corpid,String fromAccno,String moduleName,
			String functiondropdown,String authtype,String auth1,String auth2,String accno,
			String submodulename,String data18,String data19,String data20,String data21,String data22,String data23) throws Exception{	
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
.matrixCreationFilter(fromAccno,moduleName)
.matrixResult(accno, submodulename)
	
	.RemoveNoCheckmatrixCreation(functiondropdown,authtype)
	
.clickDatelinemenu()
.verifyAdminbuzz(auth1,auth2, "Authorization Matrix Configuration Deletion Request")


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
	.clickAdmin()
	.locateframe()
//.datelinefilter("paymentdd.selecttype.xpath","Corporate User Profile Request","payment.status.xpath","Pending", getrefnumer, "Pending")
	.authorization()
//	.datelinefilter("paymentdd.selecttype.xpath","Corporate User Profile Request","payment.status.xpath","Accepted", getrefnumer, "Accepted")

	.clickMatrixPage()
	.clickMatrixAssignCorporatePage(groupName)
	.clickAccessRights(corpid)
	.matrixCreationFilter(fromAccno,moduleName)
	.matrixResult(accno, submodulename)
	
.verifyMatrixNotPresent(functiondropdown,authtype)
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

