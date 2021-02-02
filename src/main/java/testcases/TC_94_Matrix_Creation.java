package testcases;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import pages.SaabHomePage;
import wrappers.ProjectWrapp;

public class TC_94_Matrix_Creation  extends ProjectWrapp
{
@BeforeClass(groups={"common"})
public void setDatag() {
	testCaseName="TC94 Matrix Creation";

	testDescription="Matrix Creation - Sequential Auth Single slab";	
	browserName="Chrome";
	dataSheetName="SaabCIBDev";
	category="Sanity";
	authors="Boopathi";
	testKeyword="TC94";
	LogoutStatus=true;
	usertype="CIBUser";

}

@Test(groups={"sanity"},dataProvider="fetch")
public void MatrixCreationNoCheck(String casename,String GroupID ,String Username,String Password,String Otp,String groupName,String corpid,String fromAccno,String moduleName,String Accno,String Submodulename,String functiondropdown,String authtype,String auth1,String fromAmount,String ToAmount,String user1,String user2,String user3,String user4,String User5) throws Exception{	
	
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
	.accessRightsAmount(fromAmount,ToAmount)
//	.addslabUser(leftAddicon, leftuser, Operator, rightAddicon, rightuser, operatornum,"user1","user2")
	.addslabUserSearch("1","AND","1","1",user1,user2)
//	.addslabUser("1", "1","AND","1","2","1")
	.addRound()
//	.addslabUser("2", "3","OR","2","4","2")
//.addslabUserSearch(leftAddicon, Operator, rightAddicon, operatornum, firstuser, SecUser)
.addslabUserSearch("2","OR","2","2",user3,user4)

//	.addslabUserSearch("2", "1","OR","2","1","2","sridhar05","Sridhar07")


	.addRound()
	//.addslabUser("3", "5","ONLY","3","6","3")
	
	.addslabUserSearch("3","ONLY","3","3",User5,user1)

//.addslabUserSearch("3", "1","ONLY","3","1","3","Sridhar09","null")
.saveMatrix()
.clickDatelinemenu()
.verifyAdminbuzz(auth1,auth1, "Authorization Matrix Configuration Creation Request")

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
.authorization()

	.clickMatrixPage()
	.clickMatrixAssignCorporatePage(groupName)
	.clickAccessRights(corpid)
	
	.matrixCreationFilter(fromAccno,moduleName)
	
	.matrixResult(Accno, Submodulename)

.verifyMatrixPresent(functiondropdown,authtype)
.clickConfigurelink(functiondropdown,authtype)
	.clickViewMatrix().logout(LogoutStatus,usertype);
	
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
