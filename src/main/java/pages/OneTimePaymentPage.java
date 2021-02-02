package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import net.bytebuddy.implementation.bind.MethodDelegationBinder.AmbiguityResolver;
import wrappers.ProjectWrapp;

public class OneTimePaymentPage extends ProjectWrapp{
	public  OneTimePaymentPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
			this.test = test;
		//	if(!verifyTitle("Corporate Customer Banking  ")){
			//	reportStep("This is not Corporate Customer Banking", "FAIL");
		//	}
		}



	public OtP_Page oneTimePay(String corpbill,String accnumber,String category,String billcomp,String plan,String billacnum,String amount) throws InterruptedException{
		locateFrame("icanvas");

		dropdownSelection(prop.getProperty("select.corpaddbill.xpath"),corpbill);
		Thread.sleep(4000);

		dropdownSelection(prop.getProperty("acc.choose.onetime.pay.xpath"),accnumber);
		Thread.sleep(4000);
		dropdownSelection(prop.getProperty("select.categorychoose.xpath"),category);
		Thread.sleep(10000);
		
		
		dropdownSelection(prop.getProperty("select.billercomp.xpath"),billcomp);
		Thread.sleep(4000);
		
		if(plan.equalsIgnoreCase("Postpaid")){
		dropdownSelection(prop.getProperty("select.billerpan.xpath"),plan);
		}
		
		
		String billAccount= billacnum;   
		billAccount = billAccount.replaceAll("[^a-zA-Z0-9]", " ");  
		
		String billnumber = billAccount .replaceAll("\\s", "");

		
		
		enterByXpathExplict(prop.getProperty("enter.biller.acc.xpath"),billnumber);
		String amn= amount;   
		amn = amn.replaceAll("[^a-zA-Z0-9]", " ");  
		
		String totalamt = amn .replaceAll("\\s", "");

		
		
		dropdownSelection(prop.getProperty("payamount.selectdrop.xpath"),totalamt);
		clickByXpathExplict(prop.getProperty("onetime.paynow.button.xpath"));
		
		return new OtP_Page(driver, test);
		
	}
	public Paymentdateline navigatePaymentDateline() throws InterruptedException{
		return new Paymentdateline(driver, test);
			}
}
