package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class StandingPageInstruction extends ProjectWrapp{
	public  StandingPageInstruction(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
			this.test = test;
		//	if(!verifyTitle("Corporate Customer Banking  ")){
			//	reportStep("This is not Corporate Customer Banking", "FAIL");
		//	}
		}

	
	

	
	
	
	public OtP_Page fillSIPayLaterToPayNow(String transfermodeSelection,String foryouacc,String currencytype,String amount,String frequency,String RepeatSkipcount) throws InterruptedException{
		//Thread.sleep(6000);		
		enterByXpathExplict(prop.getProperty("Si.forAcc.xpath"),foryouacc);
//Thread.sleep(6000);
dropdownSelection(prop.getProperty("currency.SI.Xpath"),currencytype);
Thread.sleep(2000);
String amt= amount;   
amt = amt.replaceAll("[^a-zA-Z0-9]", " ");  

String amtvalue = amt.replaceAll("\\s", "");

enterByXpathExplict(prop.getProperty("SI.enteramount.xpath"),amtvalue);
Thread.sleep(2000);
if("Pay Now".equalsIgnoreCase(transfermodeSelection)){

clickByXpathExplict(prop.getProperty("SI.PayNow.Fund.xpath"));

//verifyPageSourceText("processed");
verifyPageSourceText("Holiday");
verifyPageSourceText("cut off");



}
else if("Pay Later".equalsIgnoreCase(transfermodeSelection)){
//enterByXpathExplict(prop.getProperty("si.forbeneficiary.enter.xpath"),"test");
clickByXpathExplict(prop.getProperty("SI.PayLater.Fund.xpath"));
clickByXpathExplict(prop.getProperty("click.calendaricon.xpath"));

Thread.sleep(4000);
//clickByXpathExplict(prop.getProperty("select.twentyyear.xpath"));

//boolean a=VerifyElementpresentreturn(prop.getProperty("select.calendar.month.xpath"));
//
//if(a){
//clickByXpathExplict(prop.getProperty("select.calendar.month.xpath"));
//}
clickByXpathExplict(prop.getProperty("select.calendar.days.xpath"));


//verifyPageSourceText("processed");
verifyPageSourceText("Holiday");
verifyPageSourceText("cut off");


//SIpayDate=getAttributesxpath("payment.dateattribute.return.verify.xpath","value");

SIpayDate=getAttributesxpath(prop.getProperty("payment.dateattribute.return.verify.xpath"),"value");



}

else if("RepeatUpdate".equalsIgnoreCase(transfermodeSelection)){
	//enterByXpathExplict(prop.getProperty("si.forbeneficiary.enter.xpath"),"test");
	clickByXpathExplict(prop.getProperty("si.click.repeat.button.xpath"));
	clickByXpathExplict(prop.getProperty("click.calendaricon.xpath"));
	
	Thread.sleep(2000);
	clickByXpathExplict(prop.getProperty("select.calendar.days.xpath"));
//	verifyPageSourceText("processed");
	verifyPageSourceText("Holiday");
	verifyPageSourceText("cut off");


	
	
	scrolltoelementJs(prop.getProperty("numberoftimes.si.xpath"));
	Thread.sleep(1000);
dropdownSelection(prop.getProperty("si.frequency.selection.xpath"),frequency);
	//Thread.sleep(6000);
enterByXpathExplict(prop.getProperty("numberoftimes.si.xpath"),RepeatSkipcount);


SIpayDate=getAttributesxpath(prop.getProperty("si.repeat.input.update.xpath"),"value");


	}

else if("RepeatToSKIP".equalsIgnoreCase(transfermodeSelection)){

	
	clickByXpathExplict(prop.getProperty("si.click.repeat.button.xpath"));

	//	enterByXpathExplict(prop.getProperty("si.forbeneficiary.enter.xpath"),foryouacc);
//	clickByXpathExplict(prop.getProperty("si.click.repeat.skips.ok.button.xpath"));

	SkippedCount=getAttributesxpath(prop.getProperty("numberoftimes.si.xpath"),"value");

	
	
	clickByXpathExplict(prop.getProperty("si.repeat.skip.xpath"));
		
enterByXpathExplict(prop.getProperty("numberoftimes.si.xpath"),RepeatSkipcount);
//Thread.sleep(4000);

//SIpayDate=getAttributesxpath("payment.dateattribute.return.verify.xpath","value");


	}


clickByXpathExplict(prop.getProperty("click.si.update.button.xpath"));

//verifyPageSourceText("processed");
verifyPageSourceText("Holiday");
verifyPageSourceText("cut off");


return new OtP_Page(driver, test);
	}

	
	
	
	
	
	public StandingPageInstruction SIfilter(String fromcomp,String fromacc,String transfertype) throws InterruptedException{
		Thread.sleep(3000);
		locateFrame("icanvas");
	//	Thread.sleep(6000);

		dropdownSelection(prop.getProperty("click.fromcompany.xpath"),fromcomp);
	//	Thread.sleep(15000);

//		dropdownSelection(prop.getProperty("click.fromAcc.xpath"),fromacc);
		
	clickByXpathExplict(prop.getProperty("click.fromAcc.xpath"));	
		clickByXpathExplict(".//div[@id='fromAccount_chosen']//following::li[contains(@class,'active-result')][contains(text(),'"+fromacc+"')]");
		
		//Thread.sleep(15000);
		dropdownSelection(prop.getProperty("standinstruction.transfertype.xpath"),transfertype);
	//	Thread.sleep(4000);

clickByXpathExplict(prop.getProperty("tag.filter.xpath"));
//Thread.sleep(20000);

return this;
	}

	
	
	public StandingPageInstruction verifyaccNoUpate(String transmode) throws InterruptedException{
		int d=0;
		for (int i = 1; i < 20; i++) {			
			Thread.sleep(8000);
			if(driver.getPageSource().contains(SIrefnumer)){
		     break;
		}
			else {
					d=i+1;
					reportStep("trying to find account number in another page number", "INFO");
					boolean a=VerifyElementpresentreturn(".//ul[@class='pagination']//a[text()='"+d+"']");
if(a){
									clickByXpathExplict(".//ul[@class='pagination']//a[text()='"+d+"']");
					Thread.sleep(4000);
}
else{
booleanNoElementPresentResult(a,"Pagination has completed for search and no such record has found");
break;
}
}				}
		

		boolean e=VerifyElementpresentreturn("(.//p[strong='"+transmode+"']//following::span[text()='Reference Number:']/following::strong[text()='"+SIrefnumer+"']/following::button[@id='dropdownMenu1'])[1]");
		//reportStep("Reference number has present in this page", "INFO");
		if(e){
			reportStep("+"+SIrefnumer+" has diplaying in this page", "PASS");
			clickByXpathExplict("(.//p[strong='"+transmode+"']//following::span[text()='Reference Number:']/following::strong[text()='"+SIrefnumer+"']/following::button[@id='dropdownMenu1'])[1]");
			
		clickByXpathExplict("(.//p[strong='"+transmode+"']//following::span[text()='Reference Number:']/following::strong[text()='"+SIrefnumer+"']/following::button[@id='dropdownMenu1']//following::ul//a)[1]");	
		}
		else {
			reportStep(""+SIrefnumer+" has not  diplaying in this page", "FAIL");
		}
			return this;
	}

	
	public StandingPageInstruction editStandpageIntrction(String transmode) throws InterruptedException{
		try {
			readystate();
			jqueryload();
		} catch (InterruptedException e1) {
		}

		
		int d = 0;
		for (int i = 1; i < 35; i++) {
			Thread.sleep(3000);
			if(driver.getPageSource().contains(transmode)){
				break;
		}
			else {
					d=i+1;
					reportStep("trying to find account number in another page number", "INFO");			
					boolean a=VerifyElementpresentreturn(".//ul[@class='pagination']//a[text()='"+d+"']");
if(a){				
					clickByXpathExplict(".//ul[@class='pagination']//a[text()='"+d+"']");
					//Thread.sleep(4000);
}
else{
//booleanNoElementPresentResult(a,"Pagination has completed for search and no such record has found");


booleanResultFail(a,"Pagination has completed for search and no such record has found");
break;
}
						}
			}
boolean a=VerifyElementpresentreturn("(.//p[strong='"+transmode+"'])[1]");
	if(a){
		Thread.sleep(1000);
		SIrefnumer=ReturnXpathtext("(.//p[strong='"+transmode+"']//following::span[text()='Reference Number:']/following::strong)[1]");

//Thread.sleep(15000);
clickByXpathExplict("(.//p[strong='"+transmode+"']//following::span[text()='Reference Number:']/following::strong/following::button[@id='dropdownMenu1'])[1]");
//Thread.sleep(15000);
clickByXpathExplict("(.//p[strong='"+transmode+"']//following::span[text()='Reference Number:']/following::strong/following::button[@id='dropdownMenu1']//following::ul//a)[1]");
		pageScroll400();
	//	Thread.sleep(4000);
		}	
	else{
//		booleanResult(a, "Pagination has completed for search and no such record has found");		

	
		booleanResultFail(a,"Pagination has completed for search and no such record has found");
	}
	return this;
}
	
	
	public StandingPageInstruction verifyaccNoUpateonly(String transmode) throws InterruptedException{
		int d=0;
		for (int i = 1; i < 20; i++) {			
			Thread.sleep(8000);
			if(driver.getPageSource().contains(SIrefnumer)){
				reportStep( "Updated Reference number has diplaying in this page"+SIrefnumer+"", "PASS");
		     break;
		}
			else {
					d=i+1;
					reportStep("trying to find account number in another page number", "INFO");
					boolean a=VerifyElementpresentreturn(".//ul[@class='pagination']//a[text()='"+d+"']");
if(a){
									clickByXpathExplict(".//ul[@class='pagination']//a[text()='"+d+"']");
					Thread.sleep(4000);
}
else{
booleanNoElementPresentResult(a,"Pagination has completed for search and no such record has found");
//reportStep(""+SIrefnumer+" has not  diplaying in this page", "FAIL");
booleanResultFail(a,""+SIrefnumer+" has not  diplaying in this page");
break;
}
}				}
		

//		boolean e=VerifyElementpresentreturn("(.//p[strong='"+transmode+"']//following::span[text()='Reference Number:']/following::strong[text()='"+SIrefnumer+"']/following::button[@id='dropdownMenu1'])[1]");
		//reportStep("Reference number has present in this page", "INFO");
//		if(e){
//			reportStep("+"+SIrefnumer+" has diplaying in this page", "PASS");
			clickByXpathExplict("(.//p[strong='"+transmode+"']//following::span[text()='Reference Number:']/following::strong[text()='"+SIrefnumer+"']/following::button[@id='dropdownMenu1'])[1]");
			
		clickByXpathExplict("(.//p[strong='"+transmode+"']//following::span[text()='Reference Number:']/following::strong[text()='"+SIrefnumer+"']/following::button[@id='dropdownMenu1']//following::ul//a)[1]");	
//		}
//		else {
	//		reportStep(""+SIrefnumer+" has not  diplaying in this page", "FAIL");
//		}
			return this;
	}
	
	
	public StandingPageInstruction editStandIntrction(String transmode) throws InterruptedException{
			
		
		for(int i=1;i<100;i++){
boolean a=VerifyElementpresentreturn("(.//p[strong='"+transmode+"'])["+i+"]");
	if(a){
		Thread.sleep(6000);
		SIrefnumer=ReturnXpathtext("(.//p[strong='"+transmode+"']//following::span[text()='Reference Number:']/following::strong)["+i+"]");

Thread.sleep(13000);

//scrolltoelementJs("(.//p[strong='"+transmode+"']//following::span[text()='Reference Number:']/following::strong/following::button[@id='dropdownMenu1'])["+i+"]");
Thread.sleep(8000);

clickByXpathExplict("(.//p[strong='"+transmode+"']//following::span[text()='Reference Number:']/following::strong/following::button[@id='dropdownMenu1'])["+i+"]");
Thread.sleep(8000);

//scrolltoelementJs("(.//p[strong='"+transmode+"']//following::span[text()='Reference Number:']/following::strong/following::button[@id='dropdownMenu1']//following::ul//a)["+i+"]");
Thread.sleep(13000);

clickByXpathExplict("(.//p[strong='"+transmode+"']//following::span[text()='Reference Number:']/following::strong/following::button[@id='dropdownMenu1']//following::ul//a)["+i+"]");


//clickByXpathExplict("(.//p[strong='"+transmode+"']//following::span[text()='Reference Number:']/following::strong[text()='124812X571452643']/following::button[@id='dropdownMenu1']//following::ul//a)[1]");
		pageScroll400();
		Thread.sleep(4000);
	
		break;
}
else {
int c=i+1;
//	int c=d+1;
	reportStep("trying to find account number in another page number", "INFO");
	clickByXpathExplict(".//ul[@class='pagination']//a[text()='"+c+"']");
	Thread.sleep(4000);
}

		}
	
	return this;
}
	
	public OtP_Page PayLaterToPayNowCheck(String transmode) throws InterruptedException{
		try {
			readystate();
			jqueryload();
		} catch (InterruptedException e1) {
		}

		
		
		
		int d = 0;
		for (int i = 1; i < 35; i++) {
			
			Thread.sleep(3000);
			if(driver.getPageSource().contains(SIrefnumer)){
				reportStep("+"+SIrefnumer+" has diplaying in this page", "FAIL");

				break;
		}
			else {
					d=i+1;
					reportStep("trying to find account number in another page number", "INFO");
					boolean a=VerifyElementpresentreturn(".//ul[@class='pagination']//a[text()='"+d+"']");
if(a){
					
					clickByXpathExplict(".//ul[@class='pagination']//a[text()='"+d+"']");
					Thread.sleep(1000);
}
else{

booleanNoElementPresentResult(a,"Pagination has completed for search and no such record has found");
reportStep("+"+SIrefnumer+" has not  diplaying in Standing Instruction pages", "PASS");
break;
}


}			
			}

		/*
		boolean e=VerifyElementpresentreturn("(.//p[strong='"+transmode+"']//following::span[text()='Reference Number:']/following::strong[text()='"+SIrefnumer+"']/following::button[@id='dropdownMenu1'])[1]");
		//reportStep("Reference number has present in this page", "INFO");
		if(e){
			reportStep("+"+SIrefnumer+" has diplaying in this page", "FAIL");
		}
		else {
			reportStep("+"+SIrefnumer+" has not  diplaying in this page", "PASS");
		}
		
		*/
		
		
			return new OtP_Page(driver, test);
	}
	
	
public OtP_Page PayLaterToPayNow(String transmode) throws InterruptedException{

	
	
	
	
	
		for(int i=1;i<100;i++){
boolean a=VerifyElementpresentreturn("(.//p[strong='"+transmode+"']//following::span[text()='Reference Number:']/following::strong[text()='"+SIrefnumer+"']/following::button[@id='dropdownMenu1']//following::ul//a)[1]");
//reportStep("Reference number has present in this page", "INFO");
if(a){
	reportStep("Reference number  has diplaying in this page", "FAIL");
	break;
}
else {
	int c=i+1;
	reportStep("+"+SIrefnumer+" has not  diplaying in this page", "PASS");
	reportStep("trying to find account number in another page number", "INFO");
	boolean b=VerifyElementpresentreturn(".//ul[@class='pagination']//a[text()='"+c+"']");
	if(b){
		Thread.sleep(6000);

		clickByXpathExplict(".//ul[@class='pagination']//a[text()='"+c+"']");
	Thread.sleep(6000);
	}
	else {
		reportStep("Reference number has not diplaying in this page", "PASS");
		break;
	}
}
}
		return new OtP_Page(driver, test);
}

public OtP_Page PayLaterUpdateVerify(String foraccval,String amountval) throws InterruptedException{
//clickByXpathExplict("(.//p[strong='"+transmode+"']//following::span[text()='Reference Number:']/following::strong[text()='"+SIrefnumer+"']/following::button[@id='dropdownMenu1'])[1]");
//Thread.sleep(4000);

//clickByXpathExplict("(.//p[strong='"+transmode+"']//following::span[text()='Reference Number:']/following::strong[text()='"+SIrefnumer+"']/following::button[@id='dropdownMenu1']//following::ul//a)[1]");

//Thread.sleep(8000);

verifybyAttributesxpath(prop.getProperty("si.foracc.attributeval.xpath"),foraccval,"value");

String amt= amountval;   
amt = amt.replaceAll("[^a-zA-Z0-9]", " ");  

String amtvalue = amt.replaceAll("\\s", "");

verifybyAttributesxpath(prop.getProperty("si.amount.attributeval.xpath"),amtvalue,"value");
	return new OtP_Page(driver, test);

}


public OtP_Page repeatToSkip(String transmode) throws InterruptedException{
	
	for(int i=1;i<100;i++){
boolean a=VerifyElementpresentreturn("(.//p[strong='"+transmode+"']//following::span[text()='Reference Number:']/following::strong[text()='"+SIrefnumer+"']/following::button[@id='dropdownMenu1']//following::ul//a)[1]");
reportStep("Reference number has present in this page", "PASS");
if(a){
reportStep("Reference number  has diplaying in this page", "PASS");
verifyTextByXpathExplicitwait("(.//span[text()='Payment Date']//following::span[2])["+i+"]",SIpayDate);
//verifyTextByXpathExplicitwait("(.//span[text()='Payment Date']//following::strong[3])["+i+"]",TransmodeVerify);
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


public OtP_Page skipVerify(String transmode,String foraccval,String amountval,String Skipcount,String transferskipmode) throws InterruptedException{
	
	pageScroll400();
	Thread.sleep(4000);
	

//VerifyElementPresent("(.//p[strong='"+transmode+"']//following::span[text()='Reference Number:']/following::strong[text()='"+SIrefnumer+"'])",""+transmode+" option has been displaying for this reference number",""+transmode+" option has not been displaying for this reference number");


//clickByXpathExplict("(.//p[strong='"+transmode+"']//following::span[text()='Reference Number:']/following::strong[text()='"+SIrefnumer+"']/following::button[@id='dropdownMenu1'])[1]");
//Thread.sleep(4000);

//clickByXpathExplict("(.//p[strong='"+transmode+"']//following::span[text()='Reference Number:']/following::strong[text()='"+SIrefnumer+"']/following::button[@id='dropdownMenu1']//following::ul//a)[1]");

//Thread.sleep(8000);

//verifybyAttributesxpath(prop.getProperty("si.foracc.attributeval.xpath"),foraccval,"value");


String amt= amountval;   
amt = amt.replaceAll("[^a-zA-Z0-9]", " ");  

String amtvalue = amt.replaceAll("\\s", "");

//verifybyAttributesxpath(prop.getProperty("si.amount.attributeval.xpath"),amtvalue,"value");


clickByXpathExplict(prop.getProperty("si.click.repeat.button.xpath"));



String repeatcount=getAttributesxpath(prop.getProperty("numberoftimes.si.xpath"),"value");

if(transferskipmode.equalsIgnoreCase("Skip")){
	
	
	
comparevalues(SkippedCount,repeatcount,"Repeat/Skip count has updated","Repeat/Skip count has not been updated");
}
else if (transferskipmode.equalsIgnoreCase("Repeat")) {
	
	String skipnumber= Skipcount;   
	skipnumber = skipnumber.replaceAll("[^a-zA-Z0-9]", " ");  

	String skipno =skipnumber.replaceAll("\\s", "");

	verifytextmatches(skipno,repeatcount);


}

	return new OtP_Page(driver, test);

}



}

