package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class Userspage extends ProjectWrapp{
	public  Userspage(RemoteWebDriver driver, ExtentTest test){
	this.driver = driver;
		this.test = test;
	//	if(!verifyTitle("Corporate Customer Banking  ")){
		//	reportStep("This is not Corporate Customer Banking", "FAIL");
	//	}
	}
	
	
	public Userspage clickAssignUsers(String xpath) throws InterruptedException{
		Thread.sleep(2000);

	locateFrame("icanvas");
	Thread.sleep(2000);

	clickByXpathExplict(xpath);
	return this;
	}
	public Userspage createUsersFilter(String userid,String status,String searchKeyword,String searchenable) throws InterruptedException{
	//locateFrame("icanvas");
		Thread.sleep(14000);
		
dropdownSelection(prop.getProperty("select.usersearch.xpath"),userid);
dropdownSelection(prop.getProperty("select.usersearchStatus.xpath"),status);
if(searchenable.equalsIgnoreCase("true")){
enterByXpathExplict(prop.getProperty("enter.inputsearchkeyword.xpath"),searchKeyword);
}
clickByXpathExplict(prop.getProperty("click.usersfilter.button.xpath"));

pageScroll400();
Thread.sleep(4000);
	return this;
	}
	/*
	public StandingPageInstruction editStandIntrction(String transmode) throws InterruptedException{
		for(int i=0;i<100;i++){
			
			
boolean a=VerifyElementpresentreturn("(.//strong[contains(text(),'User ID')]/following::span[1])");
	if(a){
		Thread.sleep(6000);
	
		List<WebElement>e=driver.findElements(By.xpath("(.//strong[contains(text(),'User ID')]/following::span[1])"));
		for(int j=0;j<e.size();j++){
			if(e.get(j).getText().equalsIgnoreCase("testqa1111")){
				
verifyTextByXpathExplicitwait("(.//strong[contains(text(),'User ID')]/following::span[1])["+j+"]","testqa1111");
break;	
			}
			
			
		}
		
		
		
		
		break;
}
else {
	int c=i+1;
	reportStep("trying to find account number in another page number", "INFO");
	clickByXpathExplict(".//ul[@class='pagination']//a[text()='"+c+"']");
	Thread.sleep(4000);
}

		}
	
	return this;
}
*/
	
	
	public Userspage verifyUseIdpresent(String userid) throws InterruptedException{
////edit		
		
		for(int i=1;i<100;i++){
boolean a=VerifyElementpresentreturn("(.//strong[contains(text(),'User ID')]/following::span[text()='"+userid+"'])");
reportStep("account number has present in this page", "PASS");
if(a){
	reportStep("User id  has been diplaying in this page", "PASS");
//	clickByXpathExplict("(.//strong[contains(text(),'User ID')]/following::span[text()='testqa100'])/following::button[text()='Show'][1]");
	
	break;
}
else {
	int c=i+1;
	reportStep(""+userid+" User account  has not been diplaying in this page", "INFO");

	reportStep(""+userid+" trying find account number in another page number", "INFO");
	boolean b=VerifyElementpresentreturn(".//ul[@class='pagination']//a[text()='"+c+"']");
	if(b){
	clickByXpathExplict(".//ul[@class='pagination']//a[text()='"+c+"']");
	Thread.sleep(4000);
	}
	else {
		reportStep(""+userid+" Account number has not diplaying in this page", "FAIL");
		break;
	}
}
}
return this;
}

	public Userspage verifyeditUserIdpresent(String userid,String xpath) throws InterruptedException{
	////edit		
			
			for(int i=1;i<100;i++){
				//Thread.sleep(4000);
	boolean a=VerifyElementpresentreturn("(.//strong[contains(text(),'User ID')]/following::span[text()='"+userid+"'])");
	//reportStep("account number has present in this page", "PASS");
	if(a){
		reportStep("User id  has been displaying in this page", "PASS");
		pageScroll();
		Thread.sleep(4000);
		clickByXpathExplict(xpath);
		
		break;
	}
	else {
		int c=i+1;
		reportStep(""+userid+" User account  has not been diplaying in this page", "INFO");

		reportStep(""+userid+" trying find account number in another page number", "INFO");
		boolean b=VerifyElementpresentreturn(".//ul[@class='pagination']//a[text()='"+c+"']");
		if(b){			
		clickByXpathExplict(".//ul[@class='pagination']//a[text()='"+c+"']");
		Thread.sleep(4000);
		}
		else {
			reportStep(""+userid+" Account number has not diplaying in this page", "FAIL");
			break;
		}
	}
	}
	return this;
	}
public Userspage deleteuserVerify(String xpath,String validmsg,String errormsg){
		
		VerifyElementnotPresent(xpath,validmsg,errormsg);
		return this;
	}
	
	
	
	public Userspage unlockuserDisplay(String xpath,String validmsg,String errormsg){
		
		VerifyElementnotPresent(xpath,validmsg,errormsg);
		return this;
	}
	
	public Userspage clickDeactivateuser(String userid) throws InterruptedException{

		Thread.sleep(3000);
		clickByXpathExplict("(.//strong[contains(text(),'User ID')]/following::span[text()='"+userid+"']//following::button/span[2]//following::span[text()='De-Activate'])[1]");

		Boolean a=VerifyElementpresentreturn(prop.getProperty("verify.deactivationconfirm.xpath"));		
		if(a){
			
			clickByXpathExplict(prop.getProperty("users.yes.button.xpath"));
			
			
		}
		
		return this;
	}
	
	public Userspage clickActivateuser(String userid){
		clickByXpathExplict("(.//strong[contains(text(),'User ID')]/following::span[text()='"+userid+"']//following::button/span[2]//following::span[contains(text(),'Activate')])[1]");
		return this;
	}
	
	
	
	
	
public Userspage clickunlockuser(){
		clickByXpathExplict(prop.getProperty("click.unlockuser.link.xpath"));
		return this;
	}
	
public Userspage clickUsersEditLink(String userid){
	clickByXpathExplict("(.//strong[contains(text(),'User ID')]/following::span[text()='"+userid+"']//following::span[text()='Edit'])[1]");
	
	return this;
}
public Userspage clickUsersDeleteLink(){
	clickByXpathExplict(prop.getProperty("editform.deletebutton.xpath"));
	clickByXpathExplict(prop.getProperty("users.yes.button.xpath"));
	
	
	
	return this;
}

public Userspage getCorporateid(){

	deAssigncorporateid=getTextByXpath(prop.getProperty("verify.corporateid.xpath"));
	return this;
}




	
public Userspage clickNewAssignCorporate(){
	clickByXpathExplict(prop.getProperty("click.assignnewcorporate.button.xpath"));
	
	return this;
}

public Userspage chooseOptionsAssignCorporate() throws InterruptedException{
	clickJs(prop.getProperty("click.select.assigncorporates.checkbox.xpath"));
	Thread.sleep(3000);

	clickJs(prop.getProperty("click.select.assigncorporates.checkboxone.xpath"));

	
	
	
	Thread.sleep(4000);
	
	
	return this;
}



public Userspage clickAssignAccessRights(){
	clickByXpathExplict(prop.getProperty("click.assign.access.rights.xpath"));
		return this;
}

public Userspage clickEditAssignAccessRights(){
	clickByXpathExplict(prop.getProperty("click.editlink.Assignrights.xpath"));
		return this;
}


public Userspage clickDeleteAssignAccessRights(){
	clickByXpathExplict(prop.getProperty("click.delete.assign.rights.xpath"));
	clickByXpathExplict(prop.getProperty("click.delete.yesButton.xpath"));
	
	
	
	
		return this;
}



public Userspage fillAccessRights() throws InterruptedException{
	//verifyTextByXpathExplicitwait(prop.getProperty("corporate.assign.status.xpath"),"Un-Assigned");
	clickByXpathExplict(prop.getProperty("click.edit.assignaccess.xpath"));
	clickByXpathExplict(prop.getProperty("click.selectall.assignaccess.xpath"));
	clickByXpathExplict(prop.getProperty("click.submit.button.assignaccess.xpath"));

	Thread.sleep(15000);
	return this;
}



public Userspage verifyCorporateAssigned(){
VerifyElementPresent(prop.getProperty("verify.corporate.assign.xpath"),"Corporate has been assigned to this User","Corporate has not been assigned to this User");	
	
return this;
}
public Userspage verifyCorporateDeAssigned(){

String currentCorporateid=getTextByXpath(prop.getProperty("verify.corporateid.xpath"));

verifyNottextmatches(deAssigncorporateid, currentCorporateid);
reportStep("Corporate has been deassigned","PASS");
	//VerifyElementnotPresent(prop.getProperty("verify.corporate.assign.xpath"),"Corporate has not been assigned to this User","Corporate has been assigned to this User");	
	
return this;
}








public Userspage verifyCorporateAccessAssignedStatus(String Status){
//verifyTextByXpathExplicitwait(prop.getProperty("verify.corporate.assignacess.status.xpath"),Status);

verifyTextByXpathExplicitwait(prop.getProperty("verify.corporate.assignacess.GetText.xpath"),Status);


return this;
}




public Userspage corporateSelectionoptions(){
	clickJs(prop.getProperty("click.corporateselection.checkbox.xpath"));
	//clickJs(prop.getProperty("click.corporateselection.xpath"));
	
	//clickByXpathExplict(prop.getProperty("click.corporateselection.xpath"));
	clickByXpathExplict(prop.getProperty("click.corporate.assign.xpath"));
	
	
	return this;
}





public Userspage verifyUserCreation(String text){
verifyTextByXpathExplicitwait(prop.getProperty("userid.createdId.verify.xpath"), text);
	
return this;	
}
	public Userspage clickCreateUsers(){
	clickByXpathExplict(prop.getProperty("click.createusers.link.xpath"));
	return this;
	}
	

	public Userspage fillCreateUsersForm(String userid,String firstname,String phonenumber,String emailid,String Country,String City,String corporateChannels,String idIssuingCountry,String idtype,String PassportNumber,String Securitychoosen,String TransactionSecurityChoosen) throws InterruptedException{
Thread.sleep(4000);
		enterByXpathExplict(prop.getProperty("Enter.createUsers.form.userid.xpath"),userid);
		enterByXpathExplict(prop.getProperty("Enter.createUsers.form.firstname.xpath"),firstname);
		
		String mobileno= phonenumber;   
		mobileno = mobileno.replaceAll("[^a-zA-Z0-9]", " ");  
		
		String phnum = mobileno.replaceAll("\\s", "");
		
		
		
		enterByXpathExplict(prop.getProperty("Enter.createUsers.form.telephone.xpath"),phnum);
//		enterByXpathExplict(prop.getProperty("Enter.createUsers.form.email.xpath"),emailid);		
		Thread.sleep(4000);
		dropdownSelection(prop.getProperty("Enter.createUsers.form.country.xpath"),Country);
		
		
		Thread.sleep(4000);
		pageScroll();
				enterByXpathExplict(prop.getProperty("Enter.createUsers.form.email.xpath"),emailid);		
				Thread.sleep(4000);

				
		
	//	pageScroll();
		//Thread.sleep(8000);
	//	dropdowncitySelection(prop.getProperty("Enter.createUsers.form.city.xpath"),City);
		//dropdownSelection(prop.getProperty("Enter.createUsers.form.city.xpath"),City);
		//enterByXpathExplict(prop.getProperty("Enter.createUsers.form.email.xpath"),"testk@mailinator.com");		
	
		enterByXpathExplict(prop.getProperty("Enter.createUsers.form.designation.xpath"),"testk");		
		Thread.sleep(4000);

		dropdownSelection(prop.getProperty("Enter.createUsers.form.city.xpath"),City);

		dropdownSelection(prop.getProperty("Enter.createUsers.form.corporatechannels.xpath"),corporateChannels);
		clickByXpathExplict(prop.getProperty("click.calendar.icon.xpath"));
		clickByXpathExplict(prop.getProperty("click.today.calendar.xpath"));
		pageScroll400();
		Thread.sleep(10000);

		pageScroll400();
		Thread.sleep(4000);

		
	
	//	dropdownSelectionindex(prop.getProperty("id.issuing.idtype.xpath"),idtype,2);

		String userpassport= PassportNumber;   
		userpassport = userpassport.replaceAll("[^a-zA-Z0-9]", " ");  
		
		String userPassportNum = userpassport .replaceAll("\\s", "");
		
		
		enterByXpathExplict(prop.getProperty("passport.id.number.xpath"),userPassportNum);		
		Thread.sleep(4000);
		
		dropdownSelectionindex(prop.getProperty("id.issuing.country.xpath"),idIssuingCountry,2);
		Thread.sleep(4000);	
		dropdownSelectionindex(prop.getProperty("id.issuing.idtype.xpath"),idtype,2);
		
		Thread.sleep(4000);
		
		dropdownSelection(prop.getProperty("login.security.choosen.xpath"),Securitychoosen);
		Thread.sleep(4000);
		dropdownSelectionindex(prop.getProperty("transaction.security.choosen.xpath"),TransactionSecurityChoosen, 2);
		
	//	dropdownSelection(prop.getProperty("transaction.security.choosen.xpath"),TransactionSecurityChoosen);
		clickByXpathExplict(prop.getProperty("button.create.button.xpath"));
		
		
				
				
		return this;
	}
	

	public Userspage submitAssignCorporate(){
	clickByXpathExplict(prop.getProperty("button.create.button.xpath"));
	return this;
	}
	
	public Userspage filleditUsersForm(String firstname,String Country,String City,String CorporateChannels,String idIssuingCountry,String idType,String idNumber,String LoginSecurityChoosen,String TransactionSecurityChoosen) throws InterruptedException{
		
	//	enterByXpathExplict(prop.getProperty("Enter.createUsers.form.userid.xpath"),"testk");
		enterByXpathExplict(prop.getProperty("Enter.createUsers.form.firstname.xpath"),firstname);
	//	enterByXpathExplict(prop.getProperty("Enter.createUsers.form.telephone.xpath"),"123412341216");
		//enterByXpathExplict(prop.getProperty("Enter.createUsers.form.email.xpath"),"testk@mailinator.com");		
		dropdownSelection(prop.getProperty("Enter.createUsers.form.country.xpath"),Country);
		//enterByXpathExplict(prop.getProperty("Enter.createUsers.form.email.xpath"),"testk@mailinator.com");		
	
		enterByXpathExplict(prop.getProperty("Enter.createUsers.form.designation.xpath"),"testk");		
	
		
		dropdownSelection(prop.getProperty("Enter.createUsers.form.city.xpath"),City);
		
	//	dropdownSelection(prop.getProperty("Enter.createUsers.form.corporatechannels.xpath"),CorporateChannels);
	Thread.sleep(4000);
	//	clickByXpathExplict(prop.getProperty("click.calendar.icon.xpath"));
	//	clickByXpathExplict(prop.getProperty("click.today.calendar.xpath"));
	//	Thread.sleep(2000);
pageScroll();
Thread.sleep(4000);

String userpassport=idNumber;   
userpassport = userpassport.replaceAll("[^a-zA-Z0-9]", " ");  

String userPassportNum = userpassport .replaceAll("\\s", "");


		
		enterByXpathExplict(prop.getProperty("passport.id.number.xpath"),userPassportNum);		

		
		dropdownSelectionindex(prop.getProperty("id.issuing.country.xpath"),idIssuingCountry,2);
		Thread.sleep(4000);	
		dropdownSelectionindex(prop.getProperty("id.issuing.idtype.xpath"),idType,2);

		
//		dropdownSelection(prop.getProperty("id.issuing.country.xpath"),idIssuingCountry);
//		dropdownSelection(prop.getProperty("id.issuing.idtype.xpath"),idType);

		dropdownSelection(prop.getProperty("login.security.choosen.xpath"),LoginSecurityChoosen);
	//	dropdownSelection(prop.getProperty("transaction.security.choosen.xpath"),TransactionSecurityChoosen);

		dropdownSelectionindex(prop.getProperty("transaction.security.choosen.xpath"),TransactionSecurityChoosen, 2);
		
		clickByXpathExplict(prop.getProperty("click.edituser.update.button.xpath"));
		
		Thread.sleep(10000);
				
				
		return this;
	}
	public Userspage editUsersFormByAttribute(String firstname,String phonenumber,String emailid,String passportnumber) throws InterruptedException{
		AttributesVerifyxpath(prop.getProperty("Enter.createUsers.form.firstname.xpath"),"value",firstname);
		
		
		String userph=phonenumber;   
		userph = userph.replaceAll("[^a-zA-Z0-9]", " ");  
		
		String phno = userph .replaceAll("\\s", "");
		
		
		AttributesVerifyxpath(prop.getProperty("Enter.createUsers.form.telephone.xpath"),"value",phno);
		
		AttributesVerifyxpath(prop.getProperty("Enter.createUsers.form.email.xpath"),"value",emailid);
		
	
	//	AttributesVerifyxpath(prop.getProperty("Enter.createUsers.form.country.xpath"), value,"Saudi Arabia");
	//	AttributesVerifyxpath(prop.getProperty("Enter.createUsers.form.city.xpath"), value,"ALKHOBAR");
		
		AttributesVerifyxpath(prop.getProperty("Enter.createUsers.form.designation.xpath"),"value","testk");

	//	AttributesVerifyxpath(prop.getProperty("Enter.createUsers.form.corporatechannels.xpath"),value,"testk");
	
	//	AttributesVerifyxpath(prop.getProperty("id.issuing.country.xpath"), value,"Saudi Arabia");
	//	AttributesVerifyxpath(prop.getProperty("id.issuing.idtype.xpath"), value,"PASSPORT");
	
		pageScroll();
		String userpassPort=passportnumber;   
		userpassPort = userpassPort.replaceAll("[^a-zA-Z0-9]", " ");  
		
		String passportnum = userpassPort .replaceAll("\\s", "");
		

		AttributesVerifyxpath(prop.getProperty("passport.id.number.xpath"),"value",passportnum);

//		AttributesVerifyxpath(prop.getProperty("login.security.choosen.xpath"), value,"Soft Token");
	
	//	AttributesVerifyxpath(prop.getProperty("id.issuing.country.xpath"), value,"Saudi Arabia");
//		AttributesVerifyxpath(prop.getProperty("id.issuing.idtype.xpath"), value,"PASSPORT");

		
	//	AttributesVerifyxpath(prop.getProperty("transaction.security.choosen.xpath"), value,"Soft Token");
			
		return this;
	}

	public AdminDatelinePage clickDatelinemenu() throws InterruptedException{

		defaultcontent();
		Thread.sleep(4000);
		clickByXpathExplict(prop.getProperty("click.payment.dateline.menu.xpath"));
		locateFrame("icanvas");

	
	
	return new AdminDatelinePage(driver, test);
	}
}

