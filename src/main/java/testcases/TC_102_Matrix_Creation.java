package testcases;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import pages.SaabHomePage;
import wrappers.ProjectWrapp;

public class TC_102_Matrix_Creation  extends ProjectWrapp
{
@BeforeClass(groups={"common"})
public void setDatag() {
	testCaseName="TC102 Matrix Creation";

	testDescription="Matrix Creation - Sequential Auth Single slab-Modification";	
	browserName="Chrome";
	dataSheetName="SaabCIBDev";
	category="Sanity";
	authors="Boopathi";
	testKeyword="TC102";
	LogoutStatus=true;
	usertype="CIBUser";

}

@Test(groups={"sanity"},dataProvider="fetch")
public void MatrixCreationNoCheck(String casename,String GroupID ,String Username,String Password,String Otp,String groupName,String corpid,String fromAccno,String moduleName,String Accno,String Submodulename,String functiondropdown,String authtype,String auth1,String auth2,String FromAmount,String ToAmount,String data18,String data19,String data20,String data21) throws Exception{	
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
	.SequentialParallelmatrixCreation(fromAccno, moduleName, Accno, Submodulename, functiondropdown, authtype)
	.accessRightsAmount(FromAmount,ToAmount)
	/*.addslab("1", "0","AND","1","1","1","0")
	.addRound()
	.addslab("2", "2","OR","2","3","2","1")
	.addRound()
	.addslab("3", "4","ONLY","3","5","3","2")*/
.saveMatrix()
.clickDatelinemenu()
.verifyAdminbuzz(auth1,auth2, "Authorization Matrix Configuration Creation Request")
.logout(true,usertype);	


		
	//AuthUsername="sridhar03";
	//getrefnumer="DT-26195534";
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
	.clickAdmin()
	.locateframe()
.authorization()

	.clickMatrixPage()
	.clickMatrixAssignCorporatePage(groupName)
	.clickAccessRights(corpid)
	
	.matrixCreationFilter(fromAccno,moduleName)
	.matrixResult(Accno, Submodulename)

.verifyMatrixPresent(functiondropdown,authtype)
.clickConfigurelink(functiondropdown,authtype)
	.clickViewMatrix()
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

