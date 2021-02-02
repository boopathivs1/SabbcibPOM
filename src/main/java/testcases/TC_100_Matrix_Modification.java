package testcases;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import pages.SaabHomePage;
import wrappers.ProjectWrapp;

public class TC_100_Matrix_Modification  extends ProjectWrapp
{
@BeforeClass(groups={"common"})
public void setDatag() {
	testCaseName="TC100_Matrix Modification";

	testDescription="Matrix Modification - Parallel Auth  Multiple slab";	
	browserName="Chrome";
	dataSheetName="SaabCIBDev";
	category="Sanity";
	authors="Boopathi";
	testKeyword="TC100";
	LogoutStatus=true;
	usertype="CIBUser";

}

@Test(groups={"sanity"},dataProvider="fetch")
public void MatrixCreationNoCheck(String casename,String GroupID ,String Username,String Password,String Otp,String groupName,String corpid,String fromAccno,String moduleName,String Accno,String Submodulename,String functiondropdown,String authtype,String auth1,String auth2,String fromamtFirstSlab,String toamtFirstSlab,String fromAmtSecSlab,String toAmtSeclab,String data20,String data21) throws Exception{	
	
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
	//.clickAddSlab()
	.accessRightsAmount(fromamtFirstSlab,toamtFirstSlab)
	.accessRightsAmountAddslab(fromAmtSecSlab,toAmtSeclab)
//	.addMultislab("4", "0","AND","4","3","4","0")
//	.multiSlabAddRound()
//	.addMultislab("5","1","OR", "5","4","5","1")
//	.multiSlabAddRound()
//s	.addMultislab("6","2","ONLY", "6", "5", "6","2")

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

	//.verifybellicon()
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

