package testcases;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import pages.SaabHomePage;
import wrappers.ProjectWrapp;

public class TC_99_Matrix_Creation  extends ProjectWrapp
{
@BeforeClass(groups={"common"})
public void setDatag() {
	testCaseName="TC99 Matrix Creation";

	testDescription="Matrix Creation - Parallel Auth Multiple slab";	
	browserName="Chrome";
	dataSheetName="SaabCIBDev";
	category="Sanity";
	authors="Boopathi";
	testKeyword="TC99";
	LogoutStatus=true;
	usertype="CIBUser";

}

@Test(groups={"sanity"},dataProvider="fetch")
public void MatrixCreationNoCheck(String casename,String GroupID ,String Username,String Password,String Otp,String groupName,String corpid,String fromAccno,String moduleName,String Accno,String Submodulename,String functiondropdown,String authtype,String auth1,String fromAmount,String ToAmount,String user1,String user2,String user3,String user4,String user5) throws Exception{	
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
	//.matrixCreationFilter(fromAccno,moduleName)

	.SequentialParallelmatrixCreation(fromAccno, moduleName, Accno, Submodulename, functiondropdown, authtype)
	.clickAddSlab()
	//.accessRightsAmount("2000","3000")
	.accessRightsAmountAddslab(fromAmount,ToAmount)
	.addMultislabUserSearch("4","1","AND","4","1","4",user1,user2)
	.multiSlabAddRound()
	.addMultislabUserSearch("5","1","OR","5","1","5",user3,user4)

	.multiSlabAddRound()
	.addMultislabUserSearch("6","1","ONLY","6","1","6",user5,user1)
.saveMatrix()
.clickDatelinemenu()
.verifyAdminbuzz(auth1,auth1, "Authorization Matrix Configuration Creation Request")

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
