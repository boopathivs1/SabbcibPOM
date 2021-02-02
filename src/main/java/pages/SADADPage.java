package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;


public class SADADPage extends ProjectWrapp{
	public  SADADPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
			this.test = test;
		//	if(!verifyTitle("Corporate Customer Banking  ")){
			//	reportStep("This is not Corporate Customer Banking", "FAIL");
		//	}
		}

	
	public SADADPage clickAddManegBills() throws InterruptedException{
		clickByXpathExplict(prop.getProperty("click.addManageBillsMenu.xpath"));
return this;
	}

	public SADADPage clickBillInquiry() throws InterruptedException{
		clickByXpathExplict(prop.getProperty("Click.bill.inquiry.xpath"));
return this;
	}
	
	
	
	
	public SADADPage billInquiryFilter(String CorporateName) throws InterruptedException{
		locateFrame("icanvas");

	dropdownSelection(prop.getProperty("select.corpaddbill.xpath"),CorporateName);
Thread.sleep(2000);
	clickByXpathExplict(prop.getProperty("tag.filter.xpath"));
	
		return this;		
	
	}
	
	
	public SADADPage billInquirySingleMultiFilter(String CorporateName,String Category,String billcompany) throws InterruptedException{
		locateFrame("icanvas");

	dropdownSelection(prop.getProperty("select.corpaddbill.xpath"),CorporateName);
	Thread.sleep(4000);	
	dropdownSelection(prop.getProperty("select.categorychoose.xpath"),Category);
	Thread.sleep(4000);
	dropdownSelection(prop.getProperty("select.billercomp.xpath"),billcompany);

	Thread.sleep(10000);
	clickByXpathExplict(prop.getProperty("tag.filter.xpath"));
	
	Thread.sleep(10000);
	
	pageScrollup();
		return this;		
	
	}
	
	public OtP_Page billInquiryFormSubmit(String amount,String CorporateName,String accno,String CheckboxOptions) throws InterruptedException{
		
		Thread.sleep(8000);
		
		
		clickJs(prop.getProperty("click.billinquiry.form.checkbox.xpath"));
		
		if("multicheckbox".equalsIgnoreCase(CheckboxOptions)){
			clickJs(prop.getProperty("click.billinquiry.form.checkbox2.xpath"));
				
		}
		
		clickByXpathExplict(prop.getProperty("click.billinquiry.submit.button.xpath"));
				
		String amt= amount;   
		amt = amt.replaceAll("[^a-zA-Z0-9]", " ");  
		String totalamount = amt .replaceAll("\\s", "");
		
		
	enterByXpathExplict(prop.getProperty("enter.billinquiry.amountone.xpath"),totalamount);
		Thread.sleep(4000);

		if("multicheckbox".equalsIgnoreCase(CheckboxOptions)){
			enterByXpathExplict(prop.getProperty("enter.billinquiry.amounttwo.xpath"),totalamount);
				
		}

		
		dropdownSelection(prop.getProperty("select.corpaddbill.xpath"),CorporateName);
	
		Thread.sleep(8000);
		dropdownSelection(prop.getProperty("acc.choose.onetime.pay.xpath"),accno);

		Thread.sleep(15000);
		clickByXpathExplict(prop.getProperty("click.fillbeneficiary.submit.xpath"));
	//	clickByXpathExplict(prop.getProperty("click.confirmbutton.xpath"));
		
		
		return new OtP_Page(driver, test);		
		
		}
		
	
	
	
	
	
	
	
	
	public OneTimePaymentPage clickOneTimePaymentMenu() throws InterruptedException{
		clickByXpathExplict(prop.getProperty("click.onetimepayment.xpath"));
return new OneTimePaymentPage(driver, test);
	}
	
	

public Paymentdateline navigatepaymentDateline() throws InterruptedException{
return new Paymentdateline(driver, test);
	}
	
	
	public OtP_Page editManageBills(String nickname,String updatenickname) throws InterruptedException{
		for(int i=1;i<100;i++){
boolean a=VerifyElementpresentreturn(".//div[@id='summaryContent']//li//p//strong[text()='"+nickname+"']//following::span[text()='Actions']");
	if(a){
		Thread.sleep(6000);
		
		clickByXpathExplict(".//div[@id='summaryContent']//li//p//strong[text()='"+nickname+"']//following::span[text()='Actions']");
		
		Thread.sleep(6000);
		clickByXpathExplict(".//div[@id='summaryContent']//li//p//strong[text()='"+nickname+"']//following::span[text()='Actions']//following::li/a[@id='edit']");
Thread.sleep(4000);
enterByXpathExplict(prop.getProperty("edit.addbiller.nickname.xpath"),updatenickname);	

pageScroll400();
		Thread.sleep(4000);
	//verifyTextByXpathExplicitwait(".//table[contains(@class,'cust_table')]//tr//td[1]","testingbeneficiary");
		clickByXpathExplict(prop.getProperty("click.submitotp.button.xpath"));

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


	
	public OtP_Page deleteManageBills(String nickname) throws InterruptedException{
		for(int i=1;i<100;i++){
boolean a=VerifyElementpresentreturn(".//div[@id='summaryContent']//li//p//strong[text()='"+nickname+"']//following::span[text()='Actions']");
	if(a){
		Thread.sleep(2000);
		clickByXpathExplict(".//div[@id='summaryContent']//li//p//strong[text()='"+nickname+"']//following::span[text()='Actions']");
Thread.sleep(1000);
		clickByXpathExplict(".//div[@id='summaryContent']//li//p//strong[text()='"+nickname+"']//following::span[text()='Actions']//following::li//a[contains(text(),'Delete')]");
		pageScroll400();
		Thread.sleep(2000);
	//verifyTextByXpathExplicitwait(".//table[contains(@class,'cust_table')]//tr//td[1]","testingbeneficiary");

		

		
		break;
}
else {
	int c=i+1;
	reportStep("trying to find account number in another page number", "INFO");
	clickByXpathExplict(".//ul[@class='pagination']//a[text()='"+c+"']");
	Thread.sleep(1000);
}
		}
	
	return new OtP_Page(driver, test);
}

	
	
	
	public SADADPage clickAddBillsLink() throws InterruptedException{
		locateFrame("icanvas");
boolean a=VerifyElementpresentreturn(prop.getProperty("click.addBill.link.xpath"));
		clickByXpathExplict(prop.getProperty("click.addBill.link.xpath"));
return this;
	}
	
	public OtP_Page fillAddBills(String corpbill,String category,String billcomp,String plan,String billacnum,String nickname) throws InterruptedException{
		
		dropdownSelection(prop.getProperty("select.corpaddbill.xpath"),corpbill);
//		Thread.sleep(4000);
		dropdownSelection(prop.getProperty("select.categorychoose.xpath"),category);
	//	Thread.sleep(4000);
		
		
		dropdownSelection(prop.getProperty("select.billercomp.xpath"),billcomp);
		//Thread.sleep(4000);
		
		if(plan.equalsIgnoreCase("Postpaid")){
		dropdownSelection(prop.getProperty("select.billerpan.xpath"),plan);
		}
		else if(plan.equalsIgnoreCase("Prepaid")){
			dropdownSelection(prop.getProperty("select.billerpan.xpath"),plan);
			
		}
		
		
		
		
		
		String billAccount= billacnum;   
		billAccount = billAccount.replaceAll("[^a-zA-Z0-9]", " ");  
		
		String billnumber = billAccount .replaceAll("\\s", "");

		
		
		enterByXpathExplict(prop.getProperty("enter.biller.acc.xpath"),billnumber);
		enterByXpathExplict(prop.getProperty("enter.biller.nickname.xpath"),nickname);
		clickByXpathExplict(prop.getProperty("click.submitotp.button.xpath"));
		
		Boolean a=VerifyElementpresentreturn(prop.getProperty("addbiller.server.error.xpath"));
		booleanResult(a, "Add biller server Error has been occuring");	
		
		
		return new OtP_Page(driver, test);
	}
	
	
		public SADADPage addMangebillsFilter(String corpvalue,String category,String billcomp) throws InterruptedException{
		
			locateFrame("icanvas");
pageloading();
			dropdownSelection(prop.getProperty("select.corpaddbill.xpath"),corpvalue);
			Thread.sleep(6000);
			dropdownSelection(prop.getProperty("select.categorychoose.xpath"),category);
			Thread.sleep(6000);
			dropdownSelection(prop.getProperty("select.billercomp.xpath"),billcomp);
			Thread.sleep(6000);

			clickByXpathExplict(prop.getProperty("tag.filter.xpath"));
				
			Thread.sleep(6000);

		

		return this;
	}
		public OtP_Page verifyDeleteBiller(String nickname) throws InterruptedException{
			
			
			for(int i=1;i<100;i++){
	boolean a=VerifyElementpresentreturn(".//div[@id='summaryContent']//li//p//strong[text()='"+nickname+"']//following::span[text()='Actions']");
	if(a){
		reportStep("Biller deatils has been diplaying in this page", "FAIL");
		break;
	}
	else {
		int c=i+1;
		reportStep(""+nickname+""+ "Biller details has not  diplaying in this page", "PASS");

		reportStep("trying to find account number in another page number", "INFO");
		boolean b=VerifyElementpresentreturn(".//ul[@class='pagination']//a[text()='"+c+"']");
		if(b){
		clickByXpathExplict(".//ul[@class='pagination']//a[text()='"+c+"']");
		Thread.sleep(4000);
		}
		else {
			reportStep("Biller details has not diplaying in this page  deleted sucessfully", "PASS");
			break;
		}
	}
	}
	return new OtP_Page(driver, test);
	}


		public SADADPage verifyaddedBiller(String nickname) throws InterruptedException{
			Thread.sleep(1000);

			
	//		String userid= accno;   
		//	userid = userid.replaceAll("[^a-zA-Z0-9]", " ");  
			
		//	String usernamevalue = userid .replaceAll("\\s", "");
			
			
			for(int i=1;i<100;i++){
				
				
//to locate acc number				.//div[@id='summaryContent']//li//p[2]//strong[text()='0123456789']
	boolean a=VerifyElementpresentreturn(".//div[@id='summaryContent']//li//p//strong[text()='"+nickname+"']");

	if(a){
		reportStep("Nickname has present in this page", "PASS");

		break;
	}
	else {
		int c=i+1;
		reportStep("trying to find account number in another page number", "INFO");
		clickByXpathExplict(".//ul[@class='pagination']//a[text()='"+c+"']");
		Thread.sleep(3000);
	}
	}
	return new SADADPage(driver, test);
	}

		
		public PaymentsReports navigatePaymentReportPage(){
			
			return new PaymentsReports(driver, test);
		}

	
	
		
}
