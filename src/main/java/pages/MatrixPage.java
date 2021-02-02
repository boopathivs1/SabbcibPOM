package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class MatrixPage extends ProjectWrapp{
	public  MatrixPage (RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
			this.test = test;
		//	if(!verifyTitle("Corporate Customer Banking  ")){
			//	reportStep("This is not Corporate Customer Banking", "FAIL");
		//	}
		}
	

	
	
	public MatrixPage clickMatrixAssignCorporatePage(String groupname) throws InterruptedException{
		Thread.sleep(4000);
		locateFrame("icanvas");
			
			clickByXpathExplict("(.//h4[text()='"+groupname+"']//following::span[text()='Assign Corporates'])[1]");			
			
			
			return this;
			
		}
	
	
	
	
public MatrixPage	verifyMatrixPresent(String transtype,String Authtype)
{	

	VerifyElementPresent(".//a[@class='chosen-single']/span[text()='"+transtype+"']//following::a[@class='chosen-single']/span[text()='"+Authtype+"']", "Matrix has been created", "Matrix has not been created");	
	return this;	
}	

public MatrixPage	clickConfigurelink(String functionType,String Authtype)
{	

clickByXpathExplict(".//a[@class='chosen-single']/span[text()='"+functionType+"']//following::div[@id='matrixFunctions_0__authType_chosen']//a[@class='chosen-single']/span[text()='"+Authtype+"']//following::button[@id='btnConfigure']");

return this;
}	

public MatrixPage	clickViewMatrix() throws InterruptedException
{	
	
clickByXpathExplict(prop.getProperty("click.matrix.preview.button.xpath"));
Thread.sleep(6000);
reportStep("Matrix Preview button has been clicked sucessfully","PASS");

return this;
}
public MatrixPage	verifyMatrixNotPresent(String transtype,String Authtype)
{	
	Boolean s=VerifyElementpresentreturn("(.//a[@class='chosen-single']/span[text()='"+transtype+"']//following::a[@class='chosen-single']/span[text()='"+Authtype+"']//following::button[@id='btnConfigure']//following::button[@id='btnDelFunction'])[1]");
	
if(s){
	reportStep("Matrix  has not been deleted successfully","FAIL");
}
else{
	reportStep("Matrix  has been deleted successfully", "PASS");
	
}
//	VerifyElementnotPresent("(.//a[@class='chosen-single']/span[text()='"+transtype+"']//following::a[@class='chosen-single']/span[text()='"+Authtype+"']//following::button[@id='btnConfigure']//following::button[@id='btnDelFunction'])[1]", "Matrix has been deleted Successfully","Matrix has not  been deleted Successfully");
return this;	
}	
	
	public MatrixPage clickAccessRights(String corpid) throws InterruptedException{
		Thread.sleep(4000);
		
		
		clickByXpathExplict(prop.getProperty("click.key.choose.xpath"));

		clickByXpathExplict(prop.getProperty("click.corp.admin.id.xpath"));
		//clickByXpathExplict(".//div[@id='key_chosen']");

		//clickByXpathExplict(".//li[text()='Corporate ID']");
		clickByXpathExplict(prop.getProperty("click.corp.status.id.xpath"));
		clickByXpathExplict(prop.getProperty("click.corp.active.xpath"));
		enterByXpathExplict(prop.getProperty("enter.corpid.search.xpath"),corpid);
		
		clickByXpathExplict(prop.getProperty("Click.corp.filter.xpath"));
		//clickByXpathExplict(".//div[@id='statusid_chosen']");
		
//		clickByXpathExplict(".//li[text()='Active']");
	//	enterByXpathExplict(".//input[@id='searchval']",corpid);
		
	return this;	
	}
	
	
	public Userspage RemoveNoCheckmatrixCreation(String transtype,String Authtype) throws InterruptedException{
		
		
		clickByXpathExplict("(.//a[@class='chosen-single']/span[text()='"+transtype+"']//following::a[@class='chosen-single']/span[text()='"+Authtype+"']//following::button[@id='btnConfigure']//following::button[@id='btnDelFunction'])[1]");
		
		
//		clickByXpathExplict("(.//span[text()='Own Account Transfer -Transfer Within Bank']//following::button[@id='btnDelFunction'])[1]");
		return new Userspage(driver, test);
			
		}
	
	public MatrixPage matrixCreationFilter(String companyName,String ModuleName) throws InterruptedException{
		
		clickByXpathExplict("(.//h4[text()='"+companyName+"']//following::span[text()='Access Rights'])[1]");
		clickByXpathExplict("(.//span[text()='"+ModuleName+"']/following::span[text()='Matrix'])[1]");
return this;
	
	}	
	
	public Userspage matrixCreation(String CorpName,String ModuleName,String Accno,String SubModuleName,String Functiondropdown,String AuthType) throws InterruptedException{
	


		clickByXpathExplict("(.//h4[text()='"+CorpName+"']//following::span[text()='Access Rights'])[1]");
		clickByXpathExplict("(.//span[text()='"+ModuleName+"']/following::span[text()='Matrix'])[1]");
		dropdownSelection(prop.getProperty("function.matrix.accid.choose.xpath"),Accno);
		Boolean b=VerifyElementpresentreturn(prop.getProperty("click.close.suggestionmatrix.xpath"));
		
		if(b){
		int a=elementListReturn(prop.getProperty("click.close.suggestionmatrix.xpath")).size();
		for (int i = 0; i <a; i++) {
		int j=1;
		clickByXpath("(.//a[@class='search-choice-close'])["+j+"]");
		}
		}
		Thread.sleep(2000);
		
		pageloading();
			dropdownSelection(prop.getProperty("function.matrix.submodule.choose.xpath"),SubModuleName);
		clickByXpathExplict(prop.getProperty("click.update.matrix.xpath"));
		Thread.sleep(3000);
		
		scrolltoelementJs(prop.getProperty("click.functionid.matrix.xpath"));
dropdownSelection(prop.getProperty("click.functionid.matrix.xpath"), Functiondropdown);
Thread.sleep(3000);	
dropdownSelection(prop.getProperty("click.authtype.matrix.xpath"),AuthType);
Thread.sleep(3000);
	clickByXpathExplict(prop.getProperty("click.buttconfigure.xpath"));	
	return new Userspage(driver, test);
			
		}
	
	
	public Userspage adminmatrixCreation(String CorpName,String ModuleName,String Accno,String SubModuleName,String Functiondropdown,String AuthType) throws InterruptedException{
		clickByXpathExplict("(.//h4[text()='"+CorpName+"']//following::span[text()='Access Rights'])[1]");
		clickByXpathExplict("(.//span[text()='"+ModuleName+"']/following::span[text()='Matrix'])[1]");
	//	dropdownSelection(prop.getProperty("function.matrix.accid.choose.xpath"),Accno);
		Boolean b=VerifyElementpresentreturn(prop.getProperty("click.close.suggestionmatrix.xpath"));
		
		if(b){
		int a=elementListReturn(prop.getProperty("click.close.suggestionmatrix.xpath")).size();
		for (int i = 0; i <a; i++) {
		int j=1;
		clickByXpath("(.//a[@class='search-choice-close'])["+j+"]");
		}
		}
			dropdownSelection(prop.getProperty("function.matrix.submodule.choose.xpath"),SubModuleName);
		clickByXpathExplict(prop.getProperty("click.update.matrix.xpath"));
	
		scrolltoelementJs(prop.getProperty("click.functionid.matrix.xpath"));
		pageScroll();
		Thread.sleep(4000);	
		
		pageScroll();
		Thread.sleep(4000);	
		
dropdownSelection(prop.getProperty("click.functionid.matrix.xpath"), Functiondropdown);
	dropdownSelection(prop.getProperty("click.authtype.matrix.xpath"),AuthType);
	clickByXpathExplict(prop.getProperty("click.buttconfigure.xpath"));	
	return new Userspage(driver, test);
			
		}
	
	
	public MatrixPage matrixResult(String Accno,String SubModuleName) throws InterruptedException{
	dropdownSelection(prop.getProperty("function.matrix.accid.choose.xpath"),Accno);
	Boolean b=VerifyElementpresentreturn(prop.getProperty("click.close.suggestionmatrix.xpath"));
	if(b){
	int a=elementListReturn(prop.getProperty("click.close.suggestionmatrix.xpath")).size();
	for (int i = 0; i <a; i++) {
	int j=1;
	clickByXpath("(.//a[@class='search-choice-close'])["+j+"]");
	}
	}
	
	
		dropdownSelection(prop.getProperty("function.matrix.submodule.choose.xpath"),SubModuleName);
	
		clickByXpathExplict(prop.getProperty("click.update.matrix.xpath"));
	
return this;	
}
	public MatrixPage adminmatrixResult(String Accno,String SubModuleName) throws InterruptedException{
		//dropdownSelection(prop.getProperty("function.matrix.accid.choose.xpath"),Accno);
		Boolean b=VerifyElementpresentreturn(prop.getProperty("click.close.suggestionmatrix.xpath"));
		if(b){
		int a=elementListReturn(prop.getProperty("click.close.suggestionmatrix.xpath")).size();
		for (int i = 0; i <a; i++) {
		int j=1;
		clickByXpath("(.//a[@class='search-choice-close'])["+j+"]");
		}
		}
		
		
			dropdownSelection(prop.getProperty("function.matrix.submodule.choose.xpath"),SubModuleName);
		
			clickByXpathExplict(prop.getProperty("click.update.matrix.xpath"));
		
	return this;	
	}
	
	public MatrixPage SequentialParallelmatrixCreation(String CorpName,String ModuleName,String Accno,String SubModuleName,String Functiondropdown,String AuthType) throws InterruptedException{
		clickByXpathExplict("(.//h4[text()='"+CorpName+"']//following::span[text()='Access Rights'])[1]");
		clickByXpathExplict("(.//span[text()='"+ModuleName+"']/following::span[text()='Matrix'])[1]");
		dropdownSelection(prop.getProperty("function.matrix.accid.choose.xpath"),Accno);
		Boolean b=VerifyElementpresentreturn(prop.getProperty("click.close.suggestionmatrix.xpath"));
		if(b){
		int a=elementListReturn(prop.getProperty("click.close.suggestionmatrix.xpath")).size();
		for (int i = 0; i <a; i++) {
		int j=1;
		clickByXpath("(.//a[@class='search-choice-close'])["+j+"]");
		}
		}
		
		
			dropdownSelection(prop.getProperty("function.matrix.submodule.choose.xpath"),SubModuleName);
		clickByXpathExplict(prop.getProperty("click.update.matrix.xpath"));
		Thread.sleep(2000);
//		scrolltoelementJs(prop.getProperty("click.functionid.matrix.xpath"));
		
		pageScroll400();
pageloading();
dropdownSelection(prop.getProperty("click.functionid.matrix.xpath"), Functiondropdown);
Thread.sleep(3000);
	dropdownSelection(prop.getProperty("click.authtype.matrix.xpath"),AuthType);
	clickByXpathExplict(prop.getProperty("click.buttconfigure.xpath"));	
	return this;	
		}

	public MatrixPage accessRightsAmount(String fromAmount,String ToAmount) throws InterruptedException{
		String fromAmoNum=regvalue(fromAmount);
		String toAmonum=regvalue(ToAmount);
		Thread.sleep(8000);
		scrolltoelementJs(prop.getProperty("enter.sequential.from.amount.one.xpath"));
		MouseHoverByXpathExplict(prop.getProperty("enter.sequential.from.amount.one.xpath"));
		enterByXpathExplict(prop.getProperty("enter.sequential.from.amount.one.xpath"),fromAmoNum);
		Thread.sleep(8000);
		scrolltoelementJs(prop.getProperty("enter.sequential.from.amount.two.xpath"));
		MouseHoverByXpathExplict(prop.getProperty("enter.sequential.from.amount.two.xpath"));
		enterByXpathExplict(prop.getProperty("enter.sequential.from.amount.two.xpath"),toAmonum);

return this;
	}
	
	public MatrixPage accessRightsAmountAddslab(String fromAmount,String ToAmount) throws InterruptedException{
		pageScroll();
		String fromAmoNum=regvalue(fromAmount);
		String toAmonum=regvalue(ToAmount);
		Thread.sleep(8000);
		enterByXpathExplict(prop.getProperty("enter.sequential.from.amount.three.xpath"),fromAmoNum);
		Thread.sleep(2000);
		enterByXpathExplict(prop.getProperty("enter.sequential.from.amount.four.xpath"),toAmonum);

return this;
	}
		
	
	public MatrixPage clickAddSlab() throws InterruptedException{
		Thread.sleep(8000);
		clickByXpathExplict(".//button[contains(@class,'addslab')]");
		Thread.sleep(8000);
	return this;
	}
	
	
	
	



	
	
	
	public MatrixPage addslabUser(String leftAddicon,String leftuser,String Operator,String rightAddicon,String rightuser,String operatornum) throws InterruptedException{
if(Operator.equalsIgnoreCase("ONLY")){
	clickByXpathExplict("(.//button[contains(@class,'btnleftcorporateuser')])["+leftAddicon+"]");
	Thread.sleep(3000);	
//	clickByXpathExplict(".//input[@id='slabDetails0.matrixRoundDetails"+MatricRoundNum+".leftRoundUsers"+leftuser+".checked']");

//	clickByXpathExplict("(.//input[@value='true'])["+leftuser+"]");	

clickByXpathExplict("(.//div[@id='leftuser']//input[@value='true'])["+leftuser+"]");	
	Thread.sleep(3000);
	clickByXpathExplict(".//button[contains(@class,'assignleftuser')]");
	Thread.sleep(10000);
	clickByXpathExplict("(.//span[text()='"+Operator+"'])["+operatornum+"]");

}
		else{

		clickByXpathExplict("(.//button[contains(@class,'btnleftcorporateuser')])["+leftAddicon+"]");
		Thread.sleep(6000);	
//		clickByXpathExplict(".//input[@id='slabDetails0.matrixRoundDetails"+MatricRoundNum+".leftRoundUsers"+leftuser+".checked']");
//		clickByXpathExplict("(.//input[@value='true'])["+leftuser+"]");	

		clickByXpathExplict("(.//div[@id='leftuser']//input[@value='true'])["+leftuser+"]");	

		Thread.sleep(2000);		
		clickByXpathExplict(".//button[contains(@class,'assignleftuser')]");
		//		clickByXpathExplict(".//span[text()='"+Operator+"']");
Thread.sleep(8000);		
	
				clickByXpathExplict("(.//button[contains(@class,'btnrightcorporateuser')])["+rightAddicon+"]");
		Thread.sleep(8000);		
		
//		clickByXpathExplict("(.//input[@value='true'])["+rightuser+"]");	

		clickByXpathExplict("(.//div[@id='rightuser']//input[@value='true'])["+rightuser+"]");	

//		clickByXpathExplict(".//input[@id='slabDetails0.matrixRoundDetails"+MatricRoundNum+".rightRoundUsers"+rightuser+".checked']");
				Thread.sleep(2000);
				clickByXpathExplict(".//button[contains(@class,'assignrightuser')]");
				//Thread.sleep(2000);		

				Thread.sleep(4000);		
				clickByXpathExplict("(.//span[text()='"+Operator+"'])["+operatornum+"]");

				Thread.sleep(6000);
		}
		return this;
	}	
	
	public MatrixPage addslabUserSearch(String leftAddicon,String Operator,String rightAddicon,String operatornum,String firstuser,String SecUser) throws InterruptedException{
if(Operator.equalsIgnoreCase("ONLY")){
	clickByXpathExplict("(.//button[contains(@class,'btnleftcorporateuser')])["+leftAddicon+"]");
	Thread.sleep(8000);	
//	clickByXpathExplict(".//input[@id='slabDetails0.matrixRoundDetails"+MatricRoundNum+".leftRoundUsers"+leftuser+".checked']");

//	clickByXpathExplict("(.//input[@value='true'])["+leftuser+"]");	
	enterByXpathExplict("(.//input[@type='search'])[1]",firstuser);
	clickByXpathExplict("(.//div[@id='leftuser']//input[@value='true'])[1]");
//clickByXpathExplict("(.//div[@id='leftuser']//input[@value='true'])["+leftuser+"]");	
	Thread.sleep(3000);
	clickByXpathExplict(".//button[contains(@class,'assignleftuser')]");
	Thread.sleep(15000);
	clickByXpathExplict("(.//span[text()='"+Operator+"'])["+operatornum+"]");

}
		else{

		clickByXpathExplict("(.//button[contains(@class,'btnleftcorporateuser')])["+leftAddicon+"]");
		Thread.sleep(8000);	
//		clickByXpathExplict(".//input[@id='slabDetails0.matrixRoundDetails"+MatricRoundNum+".leftRoundUsers"+leftuser+".checked']");
//		clickByXpathExplict("(.//input[@value='true'])["+leftuser+"]");	
enterByXpathExplict("(.//input[@type='search'])[1]",firstuser);
//		clickByXpathExplict("(.//div[@id='leftuser']//input[@value='true'])["+leftuser+"]");	
		clickByXpathExplict("(.//div[@id='leftuser']//input[@value='true'])[1]");
		Thread.sleep(2000);		
		clickByXpathExplict(".//button[contains(@class,'assignleftuser')]");
		//		clickByXpathExplict(".//span[text()='"+Operator+"']");
Thread.sleep(8000);		
	
				clickByXpathExplict("(.//button[contains(@class,'btnrightcorporateuser')])["+rightAddicon+"]");
		Thread.sleep(8000);		
		enterByXpathExplict("(.//input[@type='search'])[2]",SecUser);		
//		clickByXpathExplict("(.//input[@value='true'])["+rightuser+"]");	
		Thread.sleep(8000);	
		clickByXpathExplict("(.//div[@id='rightuser']//input[@value='true'])[1]");	
//		clickByXpathExplict("(.//div[@id='rightuser']//input[@value='true'])["+rightuser+"]");	

//		clickByXpathExplict(".//input[@id='slabDetails0.matrixRoundDetails"+MatricRoundNum+".rightRoundUsers"+rightuser+".checked']");
				Thread.sleep(4000);
				clickByXpathExplict(".//button[contains(@class,'assignrightuser')]");
				//Thread.sleep(2000);		

				Thread.sleep(15000);		
				clickByXpathExplict("(.//span[text()='"+Operator+"'])["+operatornum+"]");

				Thread.sleep(6000);
		}
		return this;
	}	
	public MatrixPage addMultislabUserSearch(String leftAddicon,String leftuser,String Operator,String rightAddicon,String rightuser,String operatornum,String firstuser,String SecUser) throws InterruptedException{
if(Operator.equalsIgnoreCase("ONLY")){
	clickByXpathExplict("(.//button[contains(@class,'btnleftcorporateuser')])["+leftAddicon+"]");
	Thread.sleep(8000);	
//	clickByXpathExplict(".//input[@id='slabDetails0.matrixRoundDetails"+MatricRoundNum+".leftRoundUsers"+leftuser+".checked']");

//	clickByXpathExplict("(.//input[@value='true'])["+leftuser+"]");	
	enterByXpathExplict("(.//input[@type='search'])[1]",firstuser);
clickByXpathExplict("(.//div[@id='leftuser']//input[@value='true'])["+leftuser+"]");	
	Thread.sleep(3000);
	clickByXpathExplict(".//button[contains(@class,'assignleftuser')]");
	Thread.sleep(15000);
	clickByXpathExplict("(.//span[text()='"+Operator+"'])["+operatornum+"]");

}
		else{

		clickByXpathExplict("(.//button[contains(@class,'btnleftcorporateuser')])["+leftAddicon+"]");
		Thread.sleep(8000);	
//		clickByXpathExplict(".//input[@id='slabDetails0.matrixRoundDetails"+MatricRoundNum+".leftRoundUsers"+leftuser+".checked']");
//		clickByXpathExplict("(.//input[@value='true'])["+leftuser+"]");	
enterByXpathExplict("(.//input[@type='search'])[1]",firstuser);
		clickByXpathExplict("(.//div[@id='leftuser']//input[@value='true'])["+leftuser+"]");	

		Thread.sleep(2000);		
		clickByXpathExplict(".//button[contains(@class,'assignleftuser')]");
		//		clickByXpathExplict(".//span[text()='"+Operator+"']");
Thread.sleep(8000);		
	
				clickByXpathExplict("(.//button[contains(@class,'btnrightcorporateuser')])["+rightAddicon+"]");
		Thread.sleep(8000);		
		enterByXpathExplict("(.//input[@type='search'])[2]",SecUser);		
//		clickByXpathExplict("(.//input[@value='true'])["+rightuser+"]");	
		Thread.sleep(8000);	
		clickByXpathExplict("(.//div[@id='rightuser']//input[@value='true'])["+rightuser+"]");	

//		clickByXpathExplict(".//input[@id='slabDetails0.matrixRoundDetails"+MatricRoundNum+".rightRoundUsers"+rightuser+".checked']");
				Thread.sleep(4000);
				clickByXpathExplict(".//button[contains(@class,'assignrightuser')]");
				//Thread.sleep(2000);		

				Thread.sleep(15000);		
				clickByXpathExplict("(.//span[text()='"+Operator+"'])["+operatornum+"]");

				Thread.sleep(6000);
		}
		return this;
	}	
	
	public MatrixPage addslab(String leftAddicon,String leftuser,String Operator,String rightAddicon,String rightuser,String operatornum,String MatricRoundNum) throws InterruptedException{
if(Operator.equalsIgnoreCase("ONLY")){
	Thread.sleep(8000);
	scrolltoelementJs("(.//button[contains(@class,'btnleftcorporateuser')])["+leftAddicon+"]");
	Thread.sleep(3000);
		clickByXpathExplict("(.//button[contains(@class,'btnleftcorporateuser')])["+leftAddicon+"]");
	Thread.sleep(13000);	
//	scrolltoelementJs(".//input[@id='slabDetails0.matrixRoundDetails"+MatricRoundNum+".leftRoundUsers"+leftuser+".checked']");
	Thread.sleep(3000);
//	 clickJs(".//input[@id='slabDetails0.matrixRoundDetails"+MatricRoundNum+".leftRoundUsers"+leftuser+".checked']");
MouseHoverByXpathExplict(".//input[@id='slabDetails0.matrixRoundDetails"+MatricRoundNum+".leftRoundUsers"+leftuser+".checked']");

	clickByXpathExplict(".//input[@id='slabDetails0.matrixRoundDetails"+MatricRoundNum+".leftRoundUsers"+leftuser+".checked']");
	Thread.sleep(10000);
	scrolltoelementJs(".//button[contains(@class,'assignleftuser')]");
	Thread.sleep(3000);

	clickByXpathExplict(".//button[contains(@class,'assignleftuser')]");
	Thread.sleep(5000);
	scrolltoelementJs("(.//span[text()='"+Operator+"'])["+operatornum+"]");
	Thread.sleep(3000);
	clickByXpathExplict("(.//span[text()='"+Operator+"'])["+operatornum+"]");
	Thread.sleep(5000);
	
}
		else{
			Thread.sleep(3000);
		clickByXpathExplict("(.//button[contains(@class,'btnleftcorporateuser')])["+leftAddicon+"]");
		Thread.sleep(6000);	
scrolltoelementJs(".//input[@id='slabDetails0.matrixRoundDetails"+MatricRoundNum+".leftRoundUsers"+leftuser+".checked']");
Thread.sleep(3000);	
clickByXpathExplict(".//input[@id='slabDetails0.matrixRoundDetails"+MatricRoundNum+".leftRoundUsers"+leftuser+".checked']");
		Thread.sleep(6000);		
		scrolltoelementJs(".//button[contains(@class,'assignleftuser')]");
		Thread.sleep(3000);
		clickByXpathExplict(".//button[contains(@class,'assignleftuser')]");
Thread.sleep(3000);		
	
//clickJs("(.//button[contains(@class,'btnrightcorporateuser')])["+rightAddicon+"]");
				clickByXpathExplict("(.//button[contains(@class,'btnrightcorporateuser')])["+rightAddicon+"]");
		Thread.sleep(4000);		
		scrolltoelementJs(".//input[@id='slabDetails0.matrixRoundDetails"+MatricRoundNum+".rightRoundUsers"+rightuser+".checked']");
		Thread.sleep(3000);		
	
//		clickJs(".//input[@id='slabDetails0.matrixRoundDetails"+MatricRoundNum+".rightRoundUsers"+rightuser+".checked']");

		clickByXpathExplict(".//input[@id='slabDetails0.matrixRoundDetails"+MatricRoundNum+".rightRoundUsers"+rightuser+".checked']");
				Thread.sleep(4000);
				scrolltoelementJs(".//button[contains(@class,'assignrightuser')]");
				Thread.sleep(3000);
				clickByXpathExplict(".//button[contains(@class,'assignrightuser')]");

				//Thread.sleep(2000);		

				Thread.sleep(4000);		
				scrolltoelementJs("(.//span[text()='"+Operator+"'])["+operatornum+"]");
				Thread.sleep(3000);
				clickByXpathExplict("(.//span[text()='"+Operator+"'])["+operatornum+"]");

				Thread.sleep(6000);
		}
		return this;
	}

	
	public MatrixPage addMultislab(String leftAddicon,String leftuser,String Operator,String rightAddicon,String rightuser,String operatornum,String MatricRoundNum) throws InterruptedException{
		if(Operator.equalsIgnoreCase("ONLY")){
			Thread.sleep(3000);	
			clickByXpathExplict("(.//button[contains(@class,'btnleftcorporateuser')])["+leftAddicon+"]");
			Thread.sleep(6000);		
			scrolltoelementJs(".//input[@id='slabDetails1.matrixRoundDetails"+MatricRoundNum+".leftRoundUsers"+leftuser+".checked']");
			Thread.sleep(2000);
			MouseHoverByXpathExplict(".//input[@id='slabDetails1.matrixRoundDetails"+MatricRoundNum+".leftRoundUsers"+leftuser+".checked']");
			clickByXpathExplict(".//input[@id='slabDetails1.matrixRoundDetails"+MatricRoundNum+".leftRoundUsers"+leftuser+".checked']");
			Thread.sleep(8000);	
			scrolltoelementJs(".//button[contains(@class,'assignleftuser')]");
			Thread.sleep(2000);
			MouseHoverByXpathExplict(".//button[contains(@class,'assignleftuser')]");
			clickByXpathExplict(".//button[contains(@class,'assignleftuser')]");
			Thread.sleep(6000);		
scrolltoelementJs("(.//span[text()='"+Operator+"'])["+operatornum+"]");
Thread.sleep(2000);			
mouseOverByXpath("(.//span[text()='"+Operator+"'])["+operatornum+"]");
clickByXpathExplict("(.//span[text()='"+Operator+"'])["+operatornum+"]");
			Thread.sleep(6000);
		}
				else{
					Thread.sleep(2000);
					scrolltoelementJs("(.//button[contains(@class,'btnleftcorporateuser')])["+leftAddicon+"]");
					Thread.sleep(3000);
					
					mouseOverByXpath("(.//button[contains(@class,'btnleftcorporateuser')])["+leftAddicon+"]");
					clickByXpathExplict("(.//button[contains(@class,'btnleftcorporateuser')])["+leftAddicon+"]");
				Thread.sleep(7000);		
				scrolltoelementJs(".//input[@id='slabDetails1.matrixRoundDetails"+MatricRoundNum+".leftRoundUsers"+leftuser+".checked']");
				Thread.sleep(3000);
				MouseHoverByXpathExplict(".//input[@id='slabDetails1.matrixRoundDetails"+MatricRoundNum+".leftRoundUsers"+leftuser+".checked']");
				clickByXpathExplict(".//input[@id='slabDetails1.matrixRoundDetails"+MatricRoundNum+".leftRoundUsers"+leftuser+".checked']");
				Thread.sleep(8000);		
				clickByXpathExplict(".//button[contains(@class,'assignleftuser')]");
				//		clickByXpathExplict(".//span[text()='"+Operator+"']");
		Thread.sleep(10000);		
		clickByXpathExplict("(.//button[contains(@class,'btnrightcorporateuser')])["+rightAddicon+"]");
	    Thread.sleep(5000);		
	    scrolltoelementJs(".//input[@id='slabDetails1.matrixRoundDetails"+MatricRoundNum+".rightRoundUsers"+rightuser+".checked']");
	    Thread.sleep(4000);
	    
	    mouseOverByXpath(".//input[@id='slabDetails1.matrixRoundDetails"+MatricRoundNum+".rightRoundUsers"+rightuser+".checked']");
	    clickByXpathExplict(".//input[@id='slabDetails1.matrixRoundDetails"+MatricRoundNum+".rightRoundUsers"+rightuser+".checked']");
		Thread.sleep(4000);
		MouseHoverByXpathExplict(".//button[contains(@class,'assignrightuser')]");

	    clickByXpathExplict(".//button[contains(@class,'assignrightuser')]");
						//Thread.sleep(2000);		

		Thread.sleep(6000);		
MouseHoverByXpathExplict("(.//span[text()='"+Operator+"'])["+operatornum+"]");
		clickByXpathExplict("(.//span[text()='"+Operator+"'])["+operatornum+"]");
						Thread.sleep(10000);
				}
				return this;
			}


	
	
	
	
	
	public MatrixPage addmultislabUser(String leftAddicon,String leftuser,String Operator,String rightAddicon,String rightuser,String operatornum) throws InterruptedException{
		if(Operator.equalsIgnoreCase("ONLY")){
			clickByXpathExplict("(.//button[contains(@class,'btnleftcorporateuser')])["+leftAddicon+"]");
			Thread.sleep(3000);	
//			clickByXpathExplict(".//input[@id='slabDetails0.matrixRoundDetails"+MatricRoundNum+".leftRoundUsers"+leftuser+".checked']");

//			clickByXpathExplict("(.//input[@value='true'])["+leftuser+"]");	

		clickByXpathExplict("(.//div[@id='leftuser']//input[@value='true'])["+leftuser+"]");	
			Thread.sleep(3000);
			clickByXpathExplict(".//button[contains(@class,'assignleftuser')]");
			Thread.sleep(3000);
			clickByXpathExplict("(.//span[text()='"+Operator+"'])["+operatornum+"]");

		}
				else{

				clickByXpathExplict("(.//button[contains(@class,'btnleftcorporateuser')])["+leftAddicon+"]");
				Thread.sleep(6000);	
//				clickByXpathExplict(".//input[@id='slabDetails0.matrixRoundDetails"+MatricRoundNum+".leftRoundUsers"+leftuser+".checked']");
//				clickByXpathExplict("(.//input[@value='true'])["+leftuser+"]");	

				clickByXpathExplict("(.//div[@id='leftuser']//input[@value='true'])["+leftuser+"]");	

				Thread.sleep(2000);		
				clickByXpathExplict(".//button[contains(@class,'assignleftuser')]");
				//		clickByXpathExplict(".//span[text()='"+Operator+"']");
		Thread.sleep(8000);		
			
						clickByXpathExplict("(.//button[contains(@class,'btnrightcorporateuser')])["+rightAddicon+"]");
				Thread.sleep(8000);		
				
//				clickByXpathExplict("(.//input[@value='true'])["+rightuser+"]");	

				clickByXpathExplict("(.//div[@id='rightuser']//input[@value='true'])["+rightuser+"]");	

//				clickByXpathExplict(".//input[@id='slabDetails0.matrixRoundDetails"+MatricRoundNum+".rightRoundUsers"+rightuser+".checked']");
						Thread.sleep(2000);
						clickByXpathExplict(".//button[contains(@class,'assignrightuser')]");
						//Thread.sleep(2000);		

						Thread.sleep(4000);		
						clickByXpathExplict("(.//span[text()='"+Operator+"'])["+operatornum+"]");

						Thread.sleep(6000);
				}
				return this;
			}	
			

	
	
	
	
	
	
	
	
	
	
	
	
	
	
public MatrixPage addRound() throws InterruptedException {
	Thread.sleep(6000);
clickByXpathExplict("(.//button[contains(@class,'addround')])[1]");
Thread.sleep(8000);
return this;
}
public MatrixPage multiSlabAddRound() throws InterruptedException {
	Thread.sleep(6000);
clickByXpathExplict("(.//button[contains(@class,'addround')])[2]");
Thread.sleep(8000);
return this;
}





public Userspage saveMatrix() throws InterruptedException {
	Thread.sleep(15000);
	pageScroll();
	Thread.sleep(4000);
	
	Thread.sleep(2000);
	
	clickByXpathExplict(prop.getProperty("click.matrix.preview.button.xpath"));
	reportStep("Screenshot has taken  for Matrix preview page","PASS");
	pageScroll();
	Thread.sleep(4000);
	
	
	clickByXpathExplict(prop.getProperty("click.close.preview.popup.xpath"));
	
//	clickByXpathExplict("(.//button[@class='close'])[3]");
	Thread.sleep(10000);
	
clickByXpathExplict(prop.getProperty("click.save.matrix.button.xpath"));

Thread.sleep(15000);

return new Userspage(driver, test);
}	
	
	public Userspage multipleMatrixCreation() throws InterruptedException{
		
		clickByXpathExplict("(.//h4[text()='SASABB242003333']//following::span[text()='Access Rights'])[1]");
		clickByXpathExplict("(.//span[text()='Payments Module']/following::span[text()='Matrix'])[1]");		
		dropdownSelection(".//div[@id='accountId_chosen']","SASABB242003333080");

			int a=elementListReturn(".//a[@class='search-choice-close']").size();
for (int i = 0; i <a; i++) {
	int j=i+1;
	clickByXpath("(.//a[@class='search-choice-close'])["+j+"]");
}
String file = "Transfer Within Bank,Transfer to other banks,Standing Instruction";

String[] array = file.split(",");
				for (int i = 0; i < array.length; i++) {
				dropdownSelection(".//div[@id='submod_chosen']",array[i]);	
			}
		
			
		
		clickByXpathExplict(".//button[@id='btnupdateModule']");

		
		
		String transfertypes = "Local Transfers (SARIE) -Transfer to other banks,Own Account Transfer -Transfer Within Bank,Other SABB Accounts -Transfer Within Bank";

String[] transtypearray = transfertypes.split(",");
	
for (int i = 0; i < transtypearray.length; i++) {
	

//dropdownSelection(".//div[@id='matrixFunctions_0__functionId_chosen']", "Own Account Transfer -Transfer Within Bank");
//	dropdownSelection(".//div[@id='matrixFunctions_0__authType_chosen']", "NO_CHECK");
//	clickByXpathExplict("(.//button[@id='btnConfigure'])[1]");	


	dropdownSelection(".//div[@id='matrixFunctions_"+i+"__functionId_chosen']", transtypearray[i]);
	dropdownSelection(".//div[@id='matrixFunctions_"+i+"__authType_chosen']", "NO_CHECK");
//	int j=i+1;
	clickByXpathExplict(".//a[@class='chosen-single']/span[text()='"+transtypearray[i]+"']//following::div[@id='matrixFunctions_"+i+"__authType_chosen']//a[@class='chosen-single']/span[text()='NO_CHECK']//following::button[@id='btnConfigure'][1]");
	clickByXpathExplict(prop.getProperty("Matrix.Addfunction.xpath"));

	pageScroll();
	
	
}
			return new Userspage(driver, test);
			
		}
	
	
}
