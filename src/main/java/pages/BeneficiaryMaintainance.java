package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

import freemarker.core.ReturnInstruction.Return;
import wrappers.ProjectWrapp;

public class BeneficiaryMaintainance extends ProjectWrapp{
	public  BeneficiaryMaintainance(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
			this.test = test;
		//	if(!verifyTitle("Corporate Customer Banking  ")){
			//	reportStep("This is not Corporate Customer Banking", "FAIL");
		}
	
	public BeneficiaryMaintainance addbeneficiarylink() throws InterruptedException{
		//locateFrame("icanvas");

		clickByXpathExplict(prop.getProperty("click.addbeneficiary.link.xpath"));
return this;
	}

	public BeneficiaryMaintainance addbeneficiaryform(String CorpValue,String Transfervalue) throws InterruptedException{
Thread.sleep(3000);
dropdownSelection(prop.getProperty("AddBeneficiary.corpindex.xpath"), CorpValue);
dropdownSelection(prop.getProperty("AddBeneficiaryTranser.xpath"), Transfervalue);


return this;
	}

	
	
	
	
	
	
	
	
	public OtP_Page addbeneficiaryOtherSabbAcc(String Sabbacc,String TransferPurpose,String Remarks) throws InterruptedException{
Thread.sleep(3000);
String userid=Sabbacc;   
userid = userid.replaceAll("[^a-zA-Z0-9]", " ");  
String acc = userid .replaceAll("\\s", "");
enterByXpathExplict(prop.getProperty("enter.othersabbAcc.xpath"),acc);

pageScroll();
scrolltoelementJs(prop.getProperty("Addbeneficiary.submit.xpath"));
enterByXpathExplict(prop.getProperty("enter.othersabbAcc.remarks.xpath"),Remarks);


dropdownSelection(prop.getProperty("purposeOfTranser.xpath"), TransferPurpose);
Thread.sleep(3000);

clickByXpathExplict(prop.getProperty("Addbeneficiary.submit.xpath"));


//Boolean a=VerifyElementpresentreturn(prop.getProperty("beneficiary.error.xpath"));
//booleanResult(a, "Account number has exists already");	

return new OtP_Page(driver, test);
	}

	public OtP_Page addbeneficiaryLocalbAcc(String name,String SabbLocalacc,String TransferPurpose,String Remarks) throws InterruptedException{
Thread.sleep(3000);
//String userid=Sabbacc;   
//userid = userid.replaceAll("[^a-zA-Z0-9]", " ");  
//String acc = userid .replaceAll("\\s", "");



enterByXpathExplict(prop.getProperty("AddLocalBeneficiary.name.xpath"),name);

enterByXpathExplict(prop.getProperty("localbenenumber.xpath"),SabbLocalacc);

scrolltoelementJs(prop.getProperty("Addbeneficiary.submit.xpath"));
Thread.sleep(6000);
dropdownSelection(prop.getProperty("purposeOfTranser.xpath"), TransferPurpose);
enterByXpathExplict(prop.getProperty("enter.othersabbAcc.remarks.xpath"),Remarks);
clickByXpathExplict(prop.getProperty("Addbeneficiary.submit.xpath"));


//Boolean a=VerifyElementpresentreturn(prop.getProperty("beneficiary.error.xpath"));
//booleanResult(a, "Account number has exists already");	
return new OtP_Page(driver, test);
	}

	
	
	public OtP_Page addBeneficiaryOverseasAcc(String name,String address,String country,String city,String branch,String currency,String IBAN,String TransferPurpose,String Remarks,String forBeneficiary) throws InterruptedException{
		Thread.sleep(3000);
		String userid=IBAN;   
		userid = userid.replaceAll("[^a-zA-Z0-9]", " ");  
		String acc = userid .replaceAll("\\s", "");

		Thread.sleep(10000);

		enterByXpathExplict(prop.getProperty("AddLocalBeneficiary.name.xpath"),name);

		enterByXpathExplict(prop.getProperty("AddBeneficiary.addressline.xpath"),address);
		
				pageScroll();						
						Thread.sleep(4000);
					dropdownSelection(prop.getProperty("country.dropdown.xpath"),country);
						Thread.sleep(4000);

						dropdownSelection(prop.getProperty("city.dd.overseas.xpath"),city);
						//overseas.bank.name.xpath
						enterByXpathExplict(prop.getProperty("overseas.bank.name.xpath"),branch);

						enterByXpathExplict(prop.getProperty("overeaes.bank.adress.xpath"),address);

												
						pageScroll400();
						
						//.//input[@id='bankAddressLine1']
					//	dropdownSelection(prop.getProperty("overseas.branch.xpath"),branch);
						Thread.sleep(4000);
						
						dropdownSelection(prop.getProperty("currency.overseas.id.xpath"),currency);
						

						enterByXpathExplict(prop.getProperty("overseas.iban.xpath"),acc);
						dropdownSelection(prop.getProperty("purposeOfTranser.xpath"), TransferPurpose);
Thread.sleep(2000);
	//	enterByXpathExplict(prop.getProperty("enter.othersabbAcc.xpath"),SabbLocalacc);
		//dropdownSelection(prop.getProperty("purposeOfTranser.xpath"), TransferPurpose);
scrolltoelementJs(prop.getProperty("Addbeneficiary.submit.xpath"));
Thread.sleep(2000);
enterByXpathExplict(prop.getProperty("enter.othersabbAcc.remarks.xpath"),Remarks);
						enterByXpathExplict(prop.getProperty("for.beneficiary.overseas.xpath"),forBeneficiary);

		
		clickByXpathExplict(prop.getProperty("Addbeneficiary.submit.xpath"));
pageScroll();

//Boolean a=VerifyElementpresentreturn(prop.getProperty("beneficiary.error.xpath"));
//booleanResult(a, "Account number has exists already");	
		return new OtP_Page(driver, test);
			}

	
	
	public BeneficiaryMaintainance addBeneficiaryFilter(String corpvalue,String tranfervalue) throws InterruptedException{
		
		
		
	
		
	dropdownSelection(prop.getProperty("Addbeneficiary.corpid.xpath"),corpvalue);
	pageloading();
	
	dropdownSelection(prop.getProperty("Addbeneficiary.bankAccType.xpath"),tranfervalue);
clickByXpathExplict(prop.getProperty("Addbeneficiary.filter.xpath"));

	
	return this;
	}
	
	
	public BeneficiaryMaintainance clickPayeeCode() throws InterruptedException{
		//Thread.sleep(25000);	
		//clickByXpathExplict(".//small[text()='Payee Code']");
		//Thread.sleep(25000);
		clickByXpathExplict(".//small[text()='Payee Code']");
		clickByXpathExplict(".//small[text()='Payee Code']");

			
			return this;
			}	
	public OtP_Page verifyBeneficiaryaccpresent(String accno) throws InterruptedException{
		Thread.sleep(8000);

		
		String userid= accno;   
		userid = userid.replaceAll("[^a-zA-Z0-9]", " ");  
		
		String usernamevalue = userid .replaceAll("\\s", "");
		
		//5 pages count we can make upto 100 
		for(int i=1;i<8;i++){
			try {
				//	readywithtime(xpathVal);
					readystate();
					jqueryload();
				} catch (InterruptedException e1) {
				}
	Thread.sleep(4000);
	boolean a=driver.getPageSource().contains(accno);

			
//boolean a=VerifyElementpresentreturn(".//table[contains(@class,'cust_table')]//td//small[text()='"+usernamevalue+"']");

if(a){
	reportStep("account number has present in this page", "PASS");

	break;
}
else {
	int c=i+1;
	reportStep("trying to find account number in another page number", "INFO");

	
	boolean pagintion=VerifyElementpresentreturn(".//ul[@class='pagination']//a[text()='"+c+"']");
if(pagintion){
	clickByXpathExplict(".//ul[@class='pagination']//a[text()='"+c+"']");	

	if(c==7){
		reportStep("Account number has not Matched in this List","FAIL");
		
	}


}
else {
	reportStep("Account number has not Matched in this List","FAIL");
	break;
}

	
	
	
//	clickByXpathExplict(".//ul[@class='pagination']//a[text()='"+c+"']");
	Thread.sleep(4000);
}
}
return new OtP_Page(driver, test);
}

	
	public BeneficiaryMaintainance editBeneficiaryaccpresent(String accno) throws InterruptedException{
		Thread.sleep(4000);

		
		String userid= accno;   
		userid = userid.replaceAll("[^a-zA-Z0-9]", " ");  
		
		String usernamevalue = userid .replaceAll("\\s", "");
		
		
		for(int i=1;i<5;i++){
boolean a=VerifyElementpresentreturn(".//table[contains(@class,'cust_table')]//td//small[text()='"+usernamevalue+"']");

if(a){
	reportStep("account number has present in this page", "PASS");

	break;
}
else {
	int c=i+1;
	

	boolean pagintion=VerifyElementpresentreturn(".//ul[@class='pagination']//a[text()='"+c+"']");
	if(pagintion){
		clickByXpathExplict(".//ul[@class='pagination']//a[text()='"+c+"']");	
		if(c==5){
			reportStep("Account number has not Matched in this List","FAIL");
			
		}
	}
	else {
		reportStep("Account number has not Matched in this List","FAIL");
		break;
	}


	
	Thread.sleep(4000);
}
}
return this;
}

	
	
public BeneficiaryMaintainance verifyeditedaccDetailsverify(String sabbaccno,String purpose) throws InterruptedException{	
	WebDriverWait wait= new WebDriverWait(driver, 60);

//	List <WebElement>  element=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(.//table[contains(@class,'cust_table')]//td[2])")));
	
	List <WebElement>  element=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(prop.getProperty("overeseas.accno.coloumn.xpath"))));
	Thread.sleep(8000);
	for (WebElement webElement : element) {
	String cate=webElement.getText();
	}		
	for(int i=0;i<element.size();i++){
		Thread.sleep(1000);		
		String refnumber=element.get(i).getText();
			if(refnumber.equalsIgnoreCase(sabbaccno)){
		int j=i+1;
		//doubleclickByXpathExplict("(.//table[contains(@class,'cust_table')]//td[1]//a[1])["+j+"]");	
			clickByXpathExplict("(.//table[contains(@class,'cust_table')]//td[1]//a[1])["+j+"]");				
				//Thread.sleep(4000);
			//	clickByXpathExplict("(.//table[contains(@class,'cust_table')]//td[1])["+j+"]");				
				Thread.sleep(4000);
				verifyTextByXpathExplicitwait(prop.getProperty("purpose.verify.overseasbeneficiary.xpath"),purpose);
				Thread.sleep(4000);
		clickByXpathExplict(prop.getProperty("click.close.button.beneficiar.xpath"));				
	break;
		}
			
	}
return this;	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public OtP_Page verifyBeneficiaryAccNotpresent(String accno) throws InterruptedException{
		
		
		for(int i=1;i<100;i++){
boolean a=VerifyElementpresentreturn(".//table[contains(@class,'cust_table')]//td//small[text()='"+accno+"']");
reportStep("account number has present in this page", "PASS");
if(a){
	reportStep("Beneficiary  has diplaying in this page", "FAIL");
	break;
}
else {
	int c=i+1;
	reportStep("+accno+"+ "  has not  diplaying in this page", "PASS");

	reportStep("trying to find account number in another page number", "INFO");
	boolean b=VerifyElementpresentreturn(".//ul[@class='pagination']//a[text()='"+c+"']");
	if(b){
	clickByXpathExplict(".//ul[@class='pagination']//a[text()='"+c+"']");
	Thread.sleep(4000);
	}
	else {
		reportStep("Beneficiary Account number has not diplaying in this page", "PASS");
		break;
	}
}
}
return new OtP_Page(driver, test);
}

	
	
	
	
	
public OtP_Page verifyelementBeneficiaryNotpresent(String accno) throws InterruptedException{
		
	
	verifyTextlistnotcontainXpath(".//table[contains(@class,'cust_table')]//td[2]",accno);
	
	/*
	
verifyTextlistcontainXpath(prop.getProperty("getrefnumber.enter.xpath"),getrefnumer);
	Thread.sleep(10000);


	//verifyTextMatchlistByXpath("(.//p[text()='"+RequestStatusValue+"'])",status);

	
	
	
	
	
	
	
	
	
	
	
	
		
		for(int i=1;i<4;i++){
boolean a=VerifyElementpresentreturn(".//table[contains(@class,'cust_table')]//td//small[text()='"+accno+"']");
reportStep("account number has present in this page", "PASS");
if(a){
	reportStep("Beneficiary  has diplaying in this page", "FAIL");
	break;
}
else {
	int c=i+1;
	reportStep("+accno+"+ "  has not  diplaying in this page", "PASS");

	reportStep("trying to find account number in another page number", "INFO");
	boolean b=VerifyElementpresentreturn(".//ul[@class='pagination']//a[text()='"+c+"']");
	if(b){
	clickByXpathExplict(".//ul[@class='pagination']//a[text()='"+c+"']");
	Thread.sleep(4000);
	}
	else {
		reportStep("Beneficiary Account number has not diplaying in this page", "PASS");
		break;
	}
}
}

*/
return new OtP_Page(driver, test);
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public BeneficiaryMaintainance editBeneficiaryaccNopresent(String accno) throws InterruptedException{
		try {
			//	readywithtime(xpathVal);
				readystate();
				jqueryload();
			} catch (InterruptedException e1) {
			}
			
			
			
			Thread.sleep(5000);
			
		//String acc=accno.toString();
		for(int i=1;i<10;i++){
//boolean a=VerifyElementpresentreturn(".//table[contains(@class,'cust_table')]//td//small[text()='"+accno+"']");
//boolean a=VerifyElementpresentreturn(".//table[contains(@class,'cust_table')]//td//small[text()='"+accno+"']");
boolean a=driver.getPageSource().contains(accno);



	if(a){
		Thread.sleep(6000);
		clickByXpathExplict("(.//table[contains(@class,'cust_table')]//td//small[text()='"+accno+"']//following::td//button)[1]");
Thread.sleep(4000);
		clickByXpathExplict("(.//table[contains(@class,'cust_table')]//td//small[text()='"+accno+"']//following::td//button//following::a[contains(text(),'Edit')])[1]");
		pageScroll400();
	//	Thread.sleep(4000);
	//verifyTextByXpathExplicitwait(".//table[contains(@class,'cust_table')]//tr//td[1]","testingbeneficiary");
	break;
}
else {
	int c=i+1;
	reportStep("trying to find account number in another page number", "INFO");
//	clickByXpathExplict(".//ul[@class='pagination']//a[text()='"+c+"']");
	Thread.sleep(4000);
	
	
	boolean pagintion=VerifyElementpresentreturn(".//ul[@class='pagination']//a[text()='"+c+"']");
if(pagintion){
	clickByXpathExplict(".//ul[@class='pagination']//a[text()='"+c+"']");	
	if(c==9){
		reportStep("Account number has not Matched in this List","FAIL");
		
	}
}
else {
	reportStep("Account number has not Matched in this List","FAIL");
	break;
}

	
	
}
		}
	
	return this;
}

	public BeneficiaryMaintainance accPaginationVerify(String accno) throws InterruptedException{
		
	
//		String acc=accno.toString();
		
		for (int i = 1; i < 5; i++) {
			Thread.sleep(5000);
				
			try {
			//	readywithtime(xpathVal);
				readystate();
				jqueryload();
			} catch (InterruptedException e1) {
			}
			
			Thread.sleep(5000);
			
			
//			boolean accnumb=VerifyElementpresentreturn(".//table[contains(@class,'cust_table')]//td//small[text()='"+accno+"']");
Boolean accnumb=driver.getPageSource().contains(accno);
		if(accnumb){
			
		break;
	}
		else {
		
			reportStep("trying to find account number in another page number", "INFO");
			int c=i+1;
			
				boolean pagintion=VerifyElementpresentreturn(".//ul[@class='pagination']//a[text()='"+c+"']");
				if(pagintion){
					clickByXpathExplict(".//ul[@class='pagination']//a[text()='"+c+"']");
					scrolltoelementJs(".//ul[@class='pagination']//a[text()='"+c+"']");
					if(c==5){
						reportStep("Account number has not Matched in this List","FAIL");
						
					}
					
				}
				else {
					reportStep("Account number has not Matched in this List","FAIL");
					break;
				}

				
				
				
		
	//			clickByXpathExplict(".//ul[@class='pagination']//a[text()='"+c+"']");
				Thread.sleep(4000);

		}
		
		}	
		return this;
	}

	
	public BeneficiaryMaintainance deleteaccVerify(String accno) throws InterruptedException{
		for (int i = 1; i < 5; i++) {
			
		
		if(driver.getPageSource().contains(accno)){
			boolean a=VerifyElementpresentreturn(".//table[contains(@class,'cust_table')]//td//small[text()='"+accno+"']");
		//	reportStep("account number has present in this page", "PASS");
			if(a){
				reportStep("Beneficiary  accno has diplaying in this page", "FAIL");
				break;
			}

		
	}
		else {
				int c=i+1;
				reportStep("trying to find account number in another page number", "INFO");
				boolean pagination=VerifyElementpresentreturn(".//ul[@class='pagination']//a[text()='"+c+"']");
				if(pagination){
				
				clickByXpathExplict(".//ul[@class='pagination']//a[text()='"+c+"']");
				Thread.sleep(4000);
if(c==4){
	reportStep("Account number haS deleted", "PASS");
	
}

				}

				else{
					reportStep("Account number haS deleted", "PASS");

				}
				
				
		}




		
		}	
		return this;
	}
	
	
	
	public BeneficiaryMaintainance editBeneficiaryverify(String accno,String editpurposexpath,String purpose) throws InterruptedException{	
	List<String>a1=new ArrayList<String>();
	WebDriverWait wait= new WebDriverWait(driver, 60);
	List <WebElement>  element=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//table[contains(@class,'cust_table')]//following::tr/td[2]/small")));
	Thread.sleep(8000);
	for (WebElement webElement : element) {
	String cate=webElement.getText();
	a1.add(cate);
	}	
	
for(int i=1;i<10;i++){
int verify=	verifyedit(editpurposexpath,purpose,accno,element);
if(verify==1){
	break;
}
else{
	boolean pagintion=VerifyElementpresentreturn(".//ul[@class='pagination']//a[@aria-label='Next']']");
if(pagintion){
	clickByXpathExplict(".//ul[@class='pagination']//a[@aria-label='Next']");	
	
	if(i==9){
		reportStep("Account number has not Matched in this List","FAIL");
		
	}
	
}
else {
	reportStep("Account number has not Matched in this List","FAIL");
	break;
}


}
	
}
	
	
	
	//	
//	///pagination
//	boolean pagintion=VerifyElementpresentreturn(".//ul[@class='pagination']//a[text()='"+c+"']']");
////pagination
//
//	if(refnumber.contains(accno)){
//
//	clicklistByxpathExplicitwait("(.//table[contains(@class,'cust_table')]//tr/following::td/small/a)["+j+"]");
//			Thread.sleep(15000);
//					verifyTextByXpathExplicitwait(prop.getProperty(editpurposexpath),purpose);			
////			verifyTextByXpathExplicitwait(".//td[text()='Umra']",purpose);
//		clickByXpathExplict(prop.getProperty("click.close.button.beneficiar.xpath"));		
//	k=1;
//		break;
//		}
//		}
//
///*	
//	 if (pagintion) {
//		reportStep("trying to find account number in another page number", "INFO");
//		clickByXpathExplict(".//ul[@class='pagination']//a[text()='"+c+"']");
//	}
//*/
		
	
	
	
	return this;
	}	

	
	
	
public int verifyedit(String editpurposexpath,String purpose,String accno,List<WebElement> element) throws InterruptedException{	

	int k=0;
	
	for(int i=0;i<element.size();i++){

	String refnumber=element.get(i).getText();
	
	int j=i+1;
	
//pagination

	if(refnumber.contains(accno)){
	clicklistByxpathExplicitwait("(.//table[contains(@class,'cust_table')]//tr/following::td/small/a)["+j+"]");
			Thread.sleep(15000);
					verifyTextByXpathExplicitwait(prop.getProperty(editpurposexpath),purpose);			
//			verifyTextByXpathExplicitwait(".//td[text()='Umra']",purpose);
		clickByXpathExplict(prop.getProperty("click.close.button.beneficiar.xpath"));		
	k=1;
		break;
		}

}
return k;	
}
	
	
	
	
	
	public OtP_Page verifyUpdatedBeneficiaryacc(String accno,String editName) throws InterruptedException{
		
		
		for(int i=1;i<4;i++){
boolean a=VerifyElementpresentreturn(".//table[contains(@class,'cust_table')]//td//small[text()='"+accno+"']");
reportStep("account number has present in this page", "PASS");

if(a){

	//verifyTextByXpathExplicitwait(".//table[contains(@class,'cust_table')]//tr//td/small[text()='"+accno+"']//preceding::tr/following::td/small/a",editName);		

	
	clickByXpathExplict("(.//table[contains(@class,'cust_table')]//tr//td/small[text()='"+accno+"']//preceding::tr/following::td/small/a)[1]");
	
	
	verifyTextByXpathExplicitwait(".//td[text()='Umra']","Umra");
	
clickByXpathExplict(".//button[text()='Close']");
	
	break;
}
else {
	int c=i+1;
	reportStep("trying to find account number in another page number", "INFO");
	clickByXpathExplict(".//ul[@class='pagination']//a[text()='"+c+"']");
	Thread.sleep(4000);
}

}
return new OtP_Page(driver, test);
}
	
	
	
	
	
	
	
	
	public OtP_Page submitEditbeneficiaryoverseas(String purpose) throws InterruptedException{

	enterByXpathExplict(prop.getProperty("editbeneficiary.address.overseas.xpath"),"Makkah Al-Mukaramah Street ,saudhi arabia");

//	enterByXpathExplict(prop.getProperty("add.otherpupose.overseas.xpath"),"testing");
				
				
	//enterByXpathExplict(prop.getProperty("beneficiary.edit.name.xpath"), editname);
		dropdownSelection(prop.getProperty("click.edit.purpose.overseas.xpath"),purpose);	
		Thread.sleep(4000);
clickByXpathExplict(prop.getProperty("beneficiary.edit.submit.xpath"));
	

return new OtP_Page(driver, test);
	}

	
	public OtP_Page submitEditbeneficiary(String purpose) throws InterruptedException{

		
		
	//enterByXpathExplict(prop.getProperty("beneficiary.edit.name.xpath"), editname);
		dropdownSelection(prop.getProperty("click.edit.purpose.overseas.xpath"),purpose);	
		Thread.sleep(4000);
clickByXpathExplict(prop.getProperty("beneficiary.edit.submit.xpath"));
	

return new OtP_Page(driver, test);
	}
	
	public OtP_Page submitLocalEditbeneficiary(String purpose,String forbeneficiary) throws InterruptedException{

		
		//enterByXpathExplict(prop.getProperty("click.edit.purpose.overseas.xpath"), editname);
		
			dropdownSelection(prop.getProperty("click.edit.purpose.overseas.xpath"),purpose);	
			enterByXpathExplict(prop.getProperty("enter.local.forbeneficiary.xpath"),forbeneficiary);
			
					
			clickByXpathExplict(prop.getProperty("beneficiary.edit.submit.xpath"));
		

	return new OtP_Page(driver, test);
		}
	
	

public OtP_Page verifydeleteBeneficiary(String accno) throws InterruptedException{
	boolean a=driver.getPageSource().contains(accno);

	
//boolean a=VerifyElementpresentreturn(".//table[contains(@class,'cust_table')]//td//small[text()='"+accno+"']");
if(a){
reportStep("Accounnt number has not deleted Successfully ", "FAIL");
}
else {
	reportStep("Accounnt number has deleted Successfully ", "PASS");
}

	
	
	return new OtP_Page(driver, test);
}

	
	
	
	
	public OtP_Page deleteBeneficiaryaccNopresent(String accno) throws InterruptedException{

		
		for(int i=1;i<10;i++){
//boolean a=VerifyElementpresentreturn(".//table[contains(@class,'cust_table')]//td//small[text()='"+accno+"']");
			try {
			//	readywithtime(xpathVal);
				readystate();
				jqueryload();
			} catch (InterruptedException e1) {
			}
Thread.sleep(4000);
boolean a=driver.getPageSource().contains(accno);

if(a){
		clickByXpathExplict("(.//table[contains(@class,'cust_table')]//td//small[text()='"+accno+"']//following::td//button)[1]");
		clickByXpathExplict("(.//table[contains(@class,'cust_table')]//td//small[text()='"+accno+"']//following::td//button//following::a)[2]");
	break;
}
	
	else{
		
		
		
		boolean pagintion=VerifyElementpresentreturn(prop.getProperty("delete.beneficiary.pagination.xpath"));
	if(pagintion){
		clickByXpathExplict(prop.getProperty("delete.beneficiary.pagination.xpath"));	
		
		if(i==8){
			reportStep("Account number has not Matched in this List","FAIL");
			
		}
	}
	else {
		reportStep("Account number has not Matched in this List","FAIL");
		break;
	}


}

		}
	return new OtP_Page(driver, test);
}
	


















	public OtP_Page verifybeneficiaryAcc(String accno) throws InterruptedException{

		
		for(int i=1;i<100;i++){
boolean a=VerifyElementpresentreturn(".//table[contains(@class,'cust_table')]//td//small[text()='"+accno+"']");
	if(a){
		
		verifyTextByXpathExplicitwait(".//table[contains(@class,'cust_table')]//td//small[text()='"+accno+"']",accno);
	break;
}
	
	else{
		boolean pagintion=VerifyElementpresentreturn(".//ul[@class='pagination']//a[@aria-label='Next']']");
	if(pagintion){
		clickByXpathExplict(".//ul[@class='pagination']//a[@aria-label='Next']");	
	}
	else {
		reportStep("Account number has not Matched in this List","FAIL");
		break;
	}


}

		}
	return new OtP_Page(driver, test);
}














}
	