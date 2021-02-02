package wrappers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.time.Clock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.record.PageBreakRecord.Break;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
//import org.eclipse.jetty.io.UncheckedPrintWriter;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;
import com.relevantcodes.extentreports.ExtentTest;

import pages.RequestsStatus;
import utils.Reporter;

public class GenericWrappers extends Reporter implements Wrappers {
	public RemoteWebDriver driver;
	protected static Properties prop;
	public String sUrl,primaryWindowHandle,sHubUrl,sHubPort;String url2;
	public String environment="https://";
	public List<String>Bznme=new ArrayList<String>();
    public static String getrefnumer=null;
    public static String datatag=null;
    public String StatementBalanceAmount;
    public String finalBalanceAmount;
    public static String SIrefnumer=null;
    public static String SIpayDate=null;
    public static String SkippedCount=null;
	public  static Logger log = Logger.getRootLogger();

    public static String randomdata1=null;
    public String otpcode="777777";
    public static String deAssigncorporateid=null;
   //public static WebDriverWait waits=null;
    
 //   public static int BalanceCompare;

    public static String AuthUsername=null;
    public static List<String> statuscheck=null;


	public static Boolean LogoutStatus=null;
	public static String usertype=null;
	public GenericWrappers() {
		
		Properties prop = new Properties();
		//
		try {
			prop.load(new FileInputStream(new File("./src/main/resources/config.properties")));
			
			sHubUrl = prop.getProperty("HUB");
			sHubPort = prop.getProperty("PORT");
			sUrl = prop.getProperty("URL");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		}
	
	
	public static String randomStringGeneration() throws InterruptedException {
		char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		StringBuilder sb = new StringBuilder(20);
		Random random = new Random();
		for (int i = 0; i < 8; i++) {
		    char c = chars[random.nextInt(chars.length)];
		    sb.append(c);
		}
	randomdata1 = sb.toString();
		
	
		
		return randomdata1;

	}
	
	
	public void readywithtime(String xpathVal) throws InterruptedException{
		for(int i=1;i<180;i++){
			
			 JavascriptExecutor js = (JavascriptExecutor)driver;		
		     String loadstate = js.executeScript("return document.readyState").toString();
		     
		        
		   
	if (loadstate.contains("complete")){
	Thread.sleep(1000);
	break;
	}
	else{
	Thread.sleep(1000);
	}	}

	}

	public void readytimes() throws InterruptedException{
	
		try{
		for(int i=1;i<50;i++){
			
			 JavascriptExecutor js = (JavascriptExecutor)driver;		
		     String loadstate = js.executeScript("return document.readyState").toString();
		     
		        
	if (loadstate.contains("complete")){
	Thread.sleep(1000);
	break;
	}
	else{
	Thread.sleep(1000);




	//break;
	}	}}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void readystate(){
		
		try{
	WebDriverWait wait;
	  wait = new WebDriverWait(driver,60);
//wait.until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")); 
	  wait.until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")); 
	
		}
		catch(Exception e){
		}}

	public void jqueryload() throws InterruptedException{
try{
		JavascriptExecutor js = (JavascriptExecutor) driver;
	int count =0;
	if((Boolean)js.executeScript("return window.jQuery != undefined"))
	{
		while(!(Boolean) js.executeScript("return jQuery.active == 0"))
		{ 

			Thread.sleep(1000); 
			if(count>120) 
				break;
			count++;
			} 
		}
}
catch(Exception e){
	
}
	
	}	

	
	public static String getRandomNumberString() {
	    // It will generate 6 digit random Number.
	    // from 0 to 999999
	    Random rnd = new Random();
	    int number = rnd.nextInt(999999);

	    // this will convert any number sequence into 6 character.
	    return String.format("%06d", number);
	}
	
	
	public void verifyTextMatchlistByXpath(String xpath,String Status){
		//waitForElement(xpath, 30);
	
		try {
			readywithtime(xpath);
			readystate();
			jqueryload();
		} catch (InterruptedException e1) {
		}

		WebDriverWait wait;
		try{
		List<String>a1=new ArrayList<String>();
		Thread.sleep(8000);
	 wait= new WebDriverWait(driver, 60);
List<WebElement> elem=driver.findElements(By.xpath(xpath));


Thread.sleep(6000);
for (int i = 0; i <elem.size(); i++) {
	String elestatus=elem.get(i).getText();
if(elestatus.equalsIgnoreCase(Status)){
}
else{
	throw new RuntimeException("list has not matched");
	
}
}
reportStep("Status has matched in this List", "Pass");
		}
catch (Exception e) {
	reportStep( ""+Status+"has not matched in List", "Fail");
	}
}

	
	
	
	
	
	
	
	
	public void verifyTextlistcontainXpath(String xpath,String Status){
		try {
			readywithtime(xpath);
			readystate();
			jqueryload();
		} catch (InterruptedException e1) {
		}
		
		WebDriverWait wait;
		
		
		try{
			Thread.sleep(3000);
			  	wait= new WebDriverWait(driver, 60);
			List <WebElement>  element=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
	Thread.sleep(8000);
	 for(int i=0;i<element.size();i++){
			String arrval=element.get(i).getText();
			
		   }
	
	
	
	int j=0;
	   for(int i=0;i<element.size();i++){
		String arrval=element.get(i).getText();
	
		if((arrval).equalsIgnoreCase(Status)){
			   j=1;
		   }
	   }
	        
	     
if(j==1){
	reportStep(Status+" has matched in this List", "PASS");
}else{
	reportStep(Status+" has not matched in this List", "FAIL");

}
   		}
		
		catch (Exception e) {
	    	reportStep(Status+" has not matched in this List", "FAIL");
		}
}
	
	
	public void verifyTextlistnotcontainXpath(String xpath,String Status){
		try{
			  		WebDriverWait wait= new WebDriverWait(driver, 60);
			List <WebElement>  element=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
	Thread.sleep(8000);
	 for(int i=0;i<element.size();i++){
			String arrval=element.get(i).getText();
		
		   }
	
	
	int j=0;
	   for(int i=0;i<element.size();i++){
		String arrval=element.get(i).getText();
	
		if((arrval).equalsIgnoreCase(Status)){
			   j=1;
		   }
	   }
	        
	       
if(j==0){
	reportStep(Status+" has not matched in this List", "PASS");
}else{
//	reportStep(Status+" has matched in this List", "FAIL");
throw new RuntimeException();
}
   		}
		
		catch (Exception e) {
	    	reportStep(Status+" has matched in this List", "FAIL");
		}
}
	
	
	public void verifyTextsizecontainslistByXpath(String xpath,int Status){
		try {
			readywithtime(xpath);
			readystate();
			jqueryload();
		} catch (InterruptedException e1) {
		}
		try{
		List<String>a1=new ArrayList<String>();
		WebDriverWait wait= new WebDriverWait(driver, 60);
		List <WebElement>  element=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
Thread.sleep(15000);

int a=element.size();

if(a==Status){
	
reportStep(Status+" has matched in this List", "PASS");

}
else{
	throw new RuntimeException(Status+" has not matched in this list" );	
}
		}
catch (Exception e) {
	reportStep(Status+" has not matched in this list","FAIL");
	}
}
	
	
	
	
	
	
	
	
	public void verifyTextcontainslistByXpath(String xpath,String Status){
		
		try {
			readywithtime(xpath);
			readystate();
			jqueryload();
		} catch (InterruptedException e1) {
		}
		try{
		List<String>a1=new ArrayList<String>();
		WebDriverWait wait= new WebDriverWait(driver, 60);
		List <WebElement>  element=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
Thread.sleep(15000);
		for (WebElement webElement : element) {
		String cate=webElement.getText();

		a1.add(cate);
	}
		Thread.sleep(5000);

if(a1.contains(Status)){
	
reportStep(Status+" Reference number has matched in this List", "PASS");

}
else{
	throw new RuntimeException(Status+"Reference number has not matched in this list" );	
}
		}
catch (Exception e) {
	reportStep(""+e+ "", "FAIL");
	}
}
	
	
	
	
	
	public void verifytextmatches(String a ,String b){
if(a.equalsIgnoreCase(b)) {
	reportStep(a+"Matches with the value "+b, "PASS");
	
}
	else {
		reportStep(a+"does not Matches withe value "+b, "FAIL");
	}
	}
	public void verifyNottextmatches(String a ,String b){
		if(!a.equalsIgnoreCase(b)) {
			reportStep(a+"not Matches with the value "+b, "PASS");
			
		}
			else {
				reportStep(a+" Matches withe value "+b, "FAIL");
			}
			}

	public void StatusUpdate(String msg,String status) {
		try{
			if("PASS".equalsIgnoreCase(status))
			{
				reportStep(msg, "PASS");
			}
			else {
				reportStep(msg, "FAIL");
			}
					}
		catch (Exception e) {
			reportStep("Element not found", "FAIL");
		}
	}
	public void del() throws IOException{
		try{	
		FileUtils.cleanDirectory(new File("./reports"));
		}catch(Exception ie){
			
		}
		}

	
	
	
	
	
	
	
	
	
	public void verifyTextcontainslistandSetuserid(String xpath,String Status){
		try {
			readywithtime(xpath);
			readystate();
			jqueryload();
		} catch (InterruptedException e1) {
		}
		try{
		List<String>a1=new ArrayList<String>();
		WebDriverWait wait= new WebDriverWait(driver, 80);
		List <WebElement>  element=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
Thread.sleep(4000);
		for (WebElement webElement : element) {
		String cate=webElement.getText();

		a1.add(cate);
	}	
		Thread.sleep(4000);
				
if(a1.contains(Status)){

	AuthUsername=Status;
	
reportStep(Status+"  has matched in this List", "Pass");

}
else{
	throw new RuntimeException(Status+" has not matched in this list" );	
}
		}
catch (Exception e) {
	reportStep(""+e+ "", "Fail");
	}
}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	public GenericWrappers(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test=test;
	}
	public void navigate(String url) {
		try {
			 url2=environment+url;
			System.err.println(url2);
			driver.navigate().to(url2);
		/*	for (int i = 0; i<5; i++) {
				Thread.sleep(1000);
			}*/
			reportStep("Now the page has landed with this url"+url2, "PASS");
		
		}
		catch (NoSuchWindowException e) {
			reportStep("Window was unfortunately closed"+url2, "FAIL");
		}
		catch (TimeoutException e) {
			reportStep("Timeout Exception has occured"+url2, "FAIL");
		}
		
		catch (Exception e) {
			reportStep("Now the page has not landed with this url"+url2, "FAIL");
		}
	}
	
	
	public void verifyTextContainsByXpathexplictwaitalert(String xpath, String text) throws InterruptedException{
		try {
			readywithtime(xpath);
			readystate();
			jqueryload();
		} catch (InterruptedException e1) {
		}
		try{
			WebDriverWait wait = new WebDriverWait(driver,20);
			WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			String sText = element.getText();
			
						if (sText.contains(text)){
				reportStep("The text: "+sText+" contains the value :"+text, "PASS");
			}}

		catch (Exception e) {		
				reportStep("unknown exception has occured", "FAIL");
		}
	}
	
	public void enterBycssXpathExplict(String xpathVal, String mobileNo) {
		try{
		
			Thread.sleep(6000);
			
			WebDriverWait wait = new WebDriverWait(driver,20);
			
			WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(xpathVal)));
					element.sendKeys(mobileNo);
			
			reportStep("The element with xpath: "+xpathVal+" is entered.", "PASS");
		}
			catch (Exception e) {
		
				reportStep("The data: "+xpathVal+" could not be entered in the field.Because No suchelement exception has occured :", "FAIL");

		}
	}

public void clicklistByxpathExplicitwaitindex(String xpathValue,int i) {
	try {
		readywithtime(xpathValue);
		readystate();
		jqueryload();
	} catch (InterruptedException e1) {
	}
	try {
		WebDriverWait wait= new WebDriverWait(driver, 60);
	List <WebElement> myIput=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpathValue)));
	//List <WebElement> myIput=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpathValue)));
	myIput.get(i).click();		
reportStep("The element with id: "+xpathValue+" is clicked.", "PASS");

} 
		catch (Exception e) {
		
			reportStep("The element with xpath: "+xpathValue+" could not be clicked.Because NO Such Element Exception has occured", "FAIL");
		}
}
	public String Data(String data) throws InterruptedException {
	Random r = new Random();
	int Low = 1;
	int High = 5;
	int R = r.nextInt(High-Low) + Low;			
//alphabit	
	String alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";		
	int character=(int)(Math.random()*26);	
	
	String s=alphabet.substring(character, character+1);	
	
	String bizname=data+s;
	Bznme.add(bizname);
return bizname;
	}
	
	

	
	
	
	
	
	
	public void verifyElementtwoelementpresentByXpathExplicitwait(String xpath,String xpaths,String validmsg,String errorvalid){
		try {
			WebDriverWait wait = new WebDriverWait(driver,40);
			WebElement element1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			WebElement element2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			//String sText = element.getText();
			if (element1.isDisplayed()&&element2.isDisplayed()){
				reportStep(validmsg+xpath, "PASS");
			}else{
				reportStep(errorvalid +xpath, "FAIL");
			}
		}
		catch (Exception e) {
			reportStep(errorvalid+xpath, "FAIL");

		}
	}
	
	public void verifyTextcontainsurls( String url,String text){
		try {
				if (url.contains(text)){
				reportStep("The text: "+url+" matches with the value :"+text, "PASS");
			}else{
				reportStep("The text: "+url+" did not match with the value :"+text, "FAIL");
			}
		}
		catch (Exception e) {
			reportStep("The :"+text+" could not be Matched.", "FAIL");
		}
	}
	
	


	public Boolean VerifyElementpresentreturn(String xpath) {
		try {
			readywithtime(xpath);
			readystate();
			jqueryload();
		} catch (InterruptedException e1) {
		}
		
		Boolean B=false;
		WebDriverWait wait;
		try{
			Thread.sleep(2000);
			wait = new WebDriverWait(driver,40);
			WebElement e=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
//		WebElement e  =driver.findElement(By.xpath(xpath));
		if(e.isDisplayed())
		{
			B=true;
			
			reportStep("The element with xpath: "+xpath+" is present.", "PASS");
return B;
		}
		
		else {
		
			//reportStep("The element with id: "+xpath+" is not present .", "PASS");
		}
		}
	catch (Exception e) {
		// TODO: handle exception
	

	}
		return B;
	}
	
		
	
	
	
	
public Boolean VerifyWaitElementpresentreturn(String xpath) {
	try {
		readywithtime(xpath);
		readystate();
		jqueryload();
	} catch (InterruptedException e1) {
	}
		
		Boolean B=false;
		WebDriverWait wait;
		try{
			Thread.sleep(2000);
			wait = new WebDriverWait(driver,60);
			WebElement e=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
//		WebElement e  =driver.findElement(By.xpath(xpath));
		if(e.isDisplayed())
		{
			B=true;
		
	//		reportStep("The element with xpath: "+xpath+" is present.", "PASS");
return B;
		}
		
		else {
		
			//reportStep("The element with id: "+xpath+" is not present .", "PASS");
		}
		}
	catch (Exception e) {
		// TODO: handle exception
	

	}
		return B;
	}
	
	
	
	
	public Boolean VerifyElementWARNreturn(String xpath) {
		try {
			readywithtime(xpath);
			readystate();
			jqueryload();
		} catch (InterruptedException e1) {
		}
		Boolean B=false;
		WebDriverWait wait;
		try{
			Thread.sleep(2000);

			wait = new WebDriverWait(driver,60);
			WebElement e=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
	//WebElement e  =driver.findElement(By.xpath(xpath));
		
		
		if(e.isDisplayed())
		{

			B=true;
			
			reportStep("The element with xpath: "+xpath+" is present.", "PASS");
return B;
		}
		
		else {
		
			//reportStep("The element with id: "+xpath+" is not present .", "PASS");
		}
		
		}
	catch (Exception e) {
		// TODO: handle exception
	

	}
		return B;
	}
	
	
	
	
	
	public void pageRefresh( ){
		try {
				driver.navigate().refresh();
				reportStep("Page has refresh sucessfully", "PASS");

		}
		catch (Exception e) {
			reportStep("Page has refresh sucessfully", "FAIL");
		}
	}
	
	
	
	
	public void verifybyAttributescontainsxpathvalidinvalid(String xpath, String attributes ,String compText,String validmsg,String errorvalid) throws InterruptedException {
		try {
			readywithtime(xpath);
			readystate();
			jqueryload();
		} catch (InterruptedException e1) {
		}
		
		try{
			Thread.sleep(3000);
			String sText = driver.findElementByXPath(xpath).getAttribute(attributes);
	
			if (sText.contains(compText)){
				
				reportStep(sText+ "contains the value  "+ validmsg, "PASS");
			}else{
				
				
				
				reportStep(sText+ "does not contains the value  " +errorvalid, "FAIL");
			}
		}
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+xpath+" could not be Matched.Because NO Such Element Exception has occured", "FAIL");
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+xpath+" could not be Matched.Because TimeOut Exception has occured", "FAIL");
		}
	}


	public void verifyTextnotPresentCONTAINSByXpath(String xpath, String text){
		try {
			
			
			
			String sText = driver.findElement(By.xpath(xpath)).getText();

			if (sText.contains(text)){
				reportStep(text,"FAIL");	
			}
	

			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
			
			
			
		
	}


	public void loadObjects() {
		prop = new Properties();
		try {
			prop.load(new FileInputStream(new File("./src/main/resources/object.properties")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void unloadObjects() {
		prop = null;
	}

	

	public void invokeApp(String browser) throws IOException {
						invokeApp(browser,false);
			}

	
	 

	
	public void invokeApp(String browser, boolean bRemote) {
		try {
//sabb	
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setBrowserName(browser);
			dc.setPlatform(Platform.WINDOWS);
			
			// this is for grid run
			if(bRemote)
				driver = new RemoteWebDriver(new URL("http://"+sHubUrl+":"+sHubPort+"/wd/hub"), dc);
				else{ // this is for local run
				if(browser.equalsIgnoreCase("chrome")){
					//System.setProperty("webdriver.chrome.driver", "./drivers/chromedrivers.exe");
					System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver76.exe");
					driver = new ChromeDriver();
			
				}else{
						System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
					driver = new FirefoxDriver();
			
				}
			}
		
			/*
			Dimension dime= new Dimension(3560,2680); 
			driver.manage().window().setSize(dime);
			
			*/
			
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);



driver.manage().window().maximize();
			

			url2=environment+sUrl;
  		  			Thread.sleep(1000);			
  			getnewurl();
  			Thread.sleep(2000);
  			getnewurl();
  		  	
			primaryWindowHandle = driver.getWindowHandle();		
			reportStep("The browser:" + browser + " launched successfully", "PASS");

		} catch (Exception e) {
			e.printStackTrace();
			reportStep("The browser:" + browser + " could not be launched", "FAIL");
		}
	}

	
	
		
	
	public void pageloadtimeOut(){
try{
driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS); 
	
reportStep("page has been loading", "PASS");
}
catch (Exception e) {
	reportStep("page has  not beenloading", "FAIL");
}
	}
			

public ArrayList<WebElement>arraylisting(String xpath)    {

ArrayList<WebElement>li=(ArrayList<WebElement>) driver.findElements(By.xpath(xpath));
return(li);
}
	
	
	
	
	public void pageScrollup() {
		try{
			JavascriptExecutor jse = driver;
			jse.executeScript("window.scrollBy(0,-250)", "");
	reportStep("Page has sucessfully scrolled", "PASS");

		}
		catch (Exception e) {
			reportStep("Page has not sucessfully scrolled", "FAIL");
		}
	}
	
	public void pageScroll() {
		try {
			readytimes();
			readystate();
			jqueryload();
		} catch (InterruptedException e1) {
		}
		
		try{
	JavascriptExecutor jse = driver;
	jse.executeScript("window.scrollBy(0,700)", "");
	Thread.sleep(3000);
	reportStep("Page has sucessfully scrolled", "PASS");

		}
		catch (Exception e) {
			reportStep("Page has not sucessfully scrolled", "FAIL");
		}
	}
	
	
	
public void clickJswait(String xpath){
	try {
		readywithtime(xpath);
		readystate();
		jqueryload();
	} catch (InterruptedException e1) {
	}
	WebDriverWait wait;
	try{
		Thread.sleep(2000);
		
wait = new WebDriverWait(driver,180);
WebElement element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));

JavascriptExecutor jse = (JavascriptExecutor)driver;
jse.executeScript("arguments[0].click();", element);

reportStep("The element with xpath: "+xpath+" is clicked.", "PASS");

	}


catch (Exception e) {

	reportStep("The element with xpath: "+xpath+" is clicked.", "FAIL");

}	
}

public void clickJs(String xpath){
	
	try {
		readywithtime(xpath);
		readystate();
		jqueryload();
	} catch (InterruptedException e1) {
	}
	
	
	try{
		Thread.sleep(2000);
WebElement element=driver.findElement(By.xpath(xpath));

JavascriptExecutor jse = (JavascriptExecutor)driver;
jse.executeScript("arguments[0].click();", element);

reportStep("The element with xpath: "+xpath+" is clicked.", "PASS");

	}


catch (Exception e) {

	reportStep("The element with xpath: "+xpath+" could not be clicked.", "FAIL");

}	
}



public void clickJsWaitLess(String xpath){
	
	
	try{
		Thread.sleep(2000);
WebElement element=driver.findElement(By.xpath(xpath));

JavascriptExecutor jse = (JavascriptExecutor)driver;
jse.executeScript("arguments[0].click();", element);

reportStep("The element with xpath: "+xpath+" is clicked.", "PASS");

	}


catch (Exception e) {

	reportStep("The element with xpath: "+xpath+" could not be clicked.", "FAIL");

}	
}




	public void scrolltoelementJs(String xpathtext){
		try {
			readywithtime(xpathtext);
			readystate();
			jqueryload();
		} catch (InterruptedException e1) {
		}
try{
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	Thread.sleep(2000);
	WebElement Element = driver.findElement(By.xpath(xpathtext));

	js.executeScript("arguments[0].scrollIntoView();", Element);

	

reportStep("Scroll to element: "+xpathtext+" is clicked.", "PASS");
	
	
	
	}
catch (Exception e) {

	reportStep("Unable to scroll to this element: "+xpathtext+".", "FAIL");

}
	}	
	public void MouseHoverByXpathExplict(String xpathVal) {
		try {
			readywithtime(xpathVal);
			readystate();
			jqueryload();
		} catch (InterruptedException e1) {
		}
		WebDriverWait wait;
//		waitForElement(xpathVal,60);
		try{
			Thread.sleep(2000);
			Actions actions = new Actions(driver);

			WebElement element = driver.findElement(By.xpath(xpathVal));

		    // waits until Home link is visible on the web page

		  wait = new WebDriverWait(driver, 60);
		    wait.until(ExpectedConditions.elementToBeClickable(element));
		    actions.moveToElement(element).perform();


	reportStep("The Mousehover with xpath: "+xpathVal+" is clicked.", "PASS");

		}
		
		catch (Exception e) {
			reportStep("The mousehover could not performed with this xpath: "+xpathVal+" .Because Element not found Exception has occured", "FAIL");
		}

		
	}

	
	public void pageScroll1400(String xpath) {
		try {
			readywithtime(xpath);
			readystate();
			jqueryload();
		} catch (InterruptedException e1) {
		}
		
		try{
			 JavascriptExecutor js = (JavascriptExecutor) driver;

			 WebElement Element = driver.findElement(By.xpath(xpath));

			        //This will scroll the page till the element is found		
			        js.executeScript("arguments[0].scrollIntoView();", Element);

	reportStep("Page has sucessfully scrolled", "PASS");

		}
		catch (Exception e) {
			reportStep("Page has not sucessfully scrolled", "FAIL");
		}
	}
	
	
	
	public void pageScroll400() {
		try{
	JavascriptExecutor jse = driver;
	jse.executeScript("window.scrollBy(0,400)", "");
	reportStep("Page has sucessfully scrolled", "PASS");

		}
		catch (Exception e) {
			reportStep("Page has not sucessfully scrolled", "FAIL");
		}
	}
	
	
	
	public void openwindow() {
		try{
	
	if (driver instanceof JavascriptExecutor) {
        ((JavascriptExecutor)driver).executeScript("window.open();");
        }
	reportStep("New window has opened", "PASS");

		}
		catch (Exception e) {
			reportStep("New window has not opened", "FAIL");
		}
	}
	
	public void windowhandless(int j) {
		try{
	
	
	
	
	Set<String> childwindow=driver.getWindowHandles();
	childwindow=driver.getWindowHandles();
    String[] individualHandle = new String[childwindow.size()];
    Iterator<String> it = childwindow.iterator();
    int i =0;
    while(it.hasNext())
    {
        individualHandle[i] = (String) it.next();
        i++;
    }

driver.switchTo().window(individualHandle[j]);
	
	

reportStep("New window has opened", "PASS");

	
		}
		catch (Exception e) {
			reportStep("New window has not opened", "FAIL");
		}
	}
	
	
	
	
	
	
	
	
	

	public void geturl(String url) {
		try{
	
		driver.get(url);
		driver.get(url);
		
	reportStep("Page has landed on " +url, "PASS");

		}
		catch (Exception e) {
			reportStep("Page has not landed on " +url, "FAIL");
		}
	}
	

	
	public void navigateback() {
		
	try {
		driver.navigate().back();
		reportStep("Page has navigated back sucessfully", "PASS");

	}
		catch (Exception e) {
		}
		
	}
	
	/*
	public void clickByXpathExplict(String xpathVal) {
		WebDriverWait wait;
		try{
		
			Thread.sleep(2000);

wait = new WebDriverWait(driver,80);
WebElement element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathVal)));


element.click();
			reportStep("The element with xpath: "+xpathVal+" is clicked.", "PASS");
		} 	
		catch (Exception e) {
			reportStep("The element with xpath: "+xpathVal+" could not be clicked.Because Element not found Exception has occured", "FAIL");
		}
	}
	
	*/
	
	public  void waitForElement(String objectName,int timeout) 
	{
		try{
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);

		for(int i=1;i<=timeout;i++)
		{
			
		try{

			
		Boolean a=VerifyWaitElementpresentreturn(objectName);
if(a){
break;
}
		}
		catch(InvalidSelectorException e)
		{
			
			
			waitTimeForException(1);
		}
		catch(StaleElementReferenceException e)
		{
			waitTimeForException(1);
		}
		catch(NoSuchElementException e)
		{

			waitTimeForException(1);
		}
		catch(ElementNotVisibleException e){
			waitTimeForException(1);
		}
		catch(UnreachableBrowserException e)
		{
			
		}
		catch(WebDriverException e){
			
			waitTimeForException(1);
		}
		
		if(i==timeout)
		{
		}
		}
		}
		catch(Exception e)
		{
//			stepFailed(e.toString());
		}
		finally
		{
		
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
			
  }


public void waitTimeForException(int sec)
	{
		try{
			Thread.sleep(sec*1000);
		}
		catch(Exception e)
		{
		}
	}
	
	
public void MouseHoverXpathExplict(String xpathVal) {
	try {
		readywithtime(xpathVal);
		readystate();
		jqueryload();
	} catch (InterruptedException e1) {
	}
	WebDriverWait wait;
//	waitForElement(xpathVal,60);
	try{
		Thread.sleep(2000);
		Actions actions = new Actions(driver);

		WebElement element = driver.findElement(By.xpath(xpathVal));

	    // waits until Home link is visible on the web page

	  wait = new WebDriverWait(driver, 60);
	    wait.until(ExpectedConditions.elementToBeClickable(element));
	    actions.moveToElement(element).perform();


reportStep("The Mousehover with xpath: "+xpathVal+" is clicked.", "PASS");

	}
	
	catch (Exception e) {
		reportStep("The mousehover could not performed with this xpath: "+xpathVal+" .Because Element not found Exception has occured", "FAIL");
	}

	
}




public void verifyPageSourceText(String text) {
	try {
//		readywithtime(xpathVal);
	//readystate();
		jqueryload();
	} catch (InterruptedException e1) {
	}
Boolean a=driver.getPageSource().contains(text);

booleanResult(a, "Transaction cut off time has been elapsed for the day"  +text);
}


public void pageloading() {
	try {
		readytimes();
	readystate();
		jqueryload();
	} catch (InterruptedException e1) {
	}

}

	public void clickByXpathExplict(String xpathVal) {
		
		try {
	readywithtime(xpathVal);
		readystate();
			jqueryload();
		} catch (InterruptedException e1) {
		}
		
		
		
		WebDriverWait wait;
		//waitForElement(xpathVal,2);
		try{
		
			Thread.sleep(2000);

			WebElement element = driver.findElement(By.xpath(xpathVal));

		    // waits until Home link is visible on the web page

		  wait = new WebDriverWait(driver, 100);
		    wait.until(ExpectedConditions.elementToBeClickable(element));

element.click();
			reportStep("The element with xpath: "+xpathVal+" is clicked.", "PASS");
		} 	
		catch (Exception e) {
			reportStep("The element with xpath: "+xpathVal+" could not be clicked.Because Element not found Exception has occured", "FAIL");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public String regvalue(String Accno){
		String Accnumber = null;
		try{
	String userAccNo= Accno;   
	userAccNo = userAccNo.replaceAll("[^a-zA-Z0-9]", " ");  
	Accnumber = userAccNo .replaceAll("\\s","");
		}
		
		catch (Exception e) {
			// TODO: handle exception
		}
		return Accnumber;
	}
	public void clickByXpathwait(String xpathVal) {
		
		WebDriverWait wait;
		try{
		
			
wait = new WebDriverWait(driver,60);
WebElement element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathVal)));


element.click();
			reportStep("The element with xpath: "+xpathVal+" is clicked.", "PASS");
		} 	
		catch (Exception e) {
			reportStep("The element with xpath: "+xpathVal+" could not be clicked.Because Element not found Exception has occured", "FAIL");
		}
	}
	
	
	
	
	
	
	
	
	public void waitForLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(pageLoadCondition);
    }
	
	
	
	
	
	
	
	
	
	
	
	public void doubleclickByXpathExplict(String xpathVal) {
		try{
	
			Actions action = new Actions(driver);
			WebDriverWait wait = new WebDriverWait(driver,20);
			//WebElement element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathVal)));
			WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathVal)));
			
			action.doubleClick(element).perform();
			
		
		} 
		
		
			
	
		//catch (TimeoutException e) {
			//reportStep("The element with xpath: "+xpathVal+" could not be clicked.Because TimeOut Exception has occured", "FAIL");
		//}
		
		
		catch (Exception e) {
		
		
			reportStep("The element with xpath: "+xpathVal+" could not be clicked.Because Element not found Exception has occured", "FAIL");
		}
	}
	
	
	public void locateFrame(String framename) {
		try{
			Thread.sleep(2000);
			
			driver.switchTo().frame(framename);
			
			reportStep("Frame has located", "PASS");
		} 
		catch (NoSuchFrameException e) {
			reportStep("no such frame exception", "FAIL");
		}	
		catch (Exception e) {
			reportStep(e.getMessage(), "Fail");
		}
		
	}
	
	
	
	public void locateFrameById(String xpath) {
		try{
			WebElement iframeElement = driver.findElement(By.id(xpath));
			driver.switchTo().frame(iframeElement);
			
			reportStep("Frame has located", "PASS");
		} 
		catch (NoSuchFrameException e) {
			reportStep("no such frame exception", "FAIL");
		}	
		catch (Exception e) {
			reportStep(e.getMessage(), "Fail");
		}
		
	}
	
	
	
	public void defaultcontent_without_load() {

		try{
			driver.switchTo().defaultContent();
			
			reportStep("Now switched to default content", "PASS");
		} 
		
		catch (NoSuchFrameException e) {
			reportStep("no such frame exception", "FAIL");
		}
		
		catch (Exception e) {
			reportStep(e.getMessage(), "Fail");
		}
		
		
		
	}	
	
	public void defaultcontent() {
		try {
//			readywithtime(xpathVal);
readytimes();
			readystate();
			jqueryload();
		} catch (InterruptedException e1) {
		}

		try{
			driver.switchTo().defaultContent();
			
			reportStep("Now switched to default content", "PASS");
		} 
		
		catch (NoSuchFrameException e) {
			reportStep("no such frame exception", "FAIL");
		}
		
		catch (Exception e) {
			reportStep(e.getMessage(), "Fail");
		}
		
		
		
	}
	
	
	
	
	public void verifyElementpresentByXpathExplicitwait(String xpath){
		try {
			readywithtime(xpath);
			readystate();
			jqueryload();
		} catch (InterruptedException e1) {
		}
		try {
			
			WebDriverWait wait = new WebDriverWait(driver,70);
			WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			
			//String sText = element.getText();
			if (element.isDisplayed()){
				reportStep("Element is Displayed with xpath "+xpath, "PASS");
			}else{
				reportStep("Element is not Displayed with xpath " +xpath, "FAIL");
			}
		}
		
		catch (Exception e) {
			reportStep("Element is not Displayed with xpath " +xpath, "FAIL");

		}
	}
	
	public void belliconFail(String xpath){
		try {
			
			WebDriverWait wait = new WebDriverWait(driver,40);
			WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			
			//String sText = element.getText();
			if (element.isDisplayed()){
				reportStep("Element is Displayed with xpath "+xpath, "PASS");
			}else{
				throw new RuntimeException("bell icon not display Reference number");
			}
		}
		
		catch (Exception e) {
			clickByXpathExplict(prop.getProperty("click.buttonclosepopup.xpath"));
			reportStep("Bell icon not display Reference number "+xpath, "FAIL");
			
		}
	}
	
	
	
	
	
	

	
	
	
	public void verifyElementpresentByXpathExplicitw(String xpath){
		try {
			readywithtime(xpath);
			readystate();
			jqueryload();
		} catch (InterruptedException e1) {
		}
		try {
			
			WebDriverWait wait = new WebDriverWait(driver,40);
			WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			
			//String sText = element.getText();
			if (element.isDisplayed()){
			reportStep("Element is Displayed with xpath "+xpath, "PASS");
			}else{
				reportStep("Element is not Displayed with xpath " +xpath, "FAIL");
			}
		}
		
		catch (Exception e) {
			//reportStep("Unknown Exception has occured", "FAIL");

		}
	}
	
public void loadendtimecalc(String xpath,String loadmsg) throws InterruptedException {
	int loadtime = 0;
	long servicestart=  System.currentTimeMillis();	
	//for(int k=0;k<=50;k++){
		Thread.sleep(500);
	
	//VerifyElementPresent(xpath);
	verifyElementpresentByXpathExplicitw(xpath);
//	Thread.sleep(10000);		
	
	long serviceend =  System.currentTimeMillis();
			long serviceload = serviceend - servicestart;
			float loadsec=serviceload/1000;
		//	serviceloadtime = Integer.toString((int) loadsec);	
			
		 loadtime=(int)loadsec;
			

//break;



//	}
	

	if(loadtime>10||loadtime==11)
	{
		reportStep(loadmsg+ " more than 10 seconds and actual loading time is "+loadtime , "FAIL");

		
	}
	else {
		reportStep(loadmsg+ " less than 10 seconds  and actual loadtime is " +loadtime, "PASS");

	}

}
	

	
	
	
	
	
	
	public void enterByXpathExplict(String xpathVal, String data) {
		
		try {
			readywithtime(xpathVal);
			readystate();
			jqueryload();
		} catch (InterruptedException e1) {
		}
		//waitForElement(xpathVal,2);
		WebDriverWait wait;
		try{
			Thread.sleep(2000);
			 wait = new WebDriverWait(driver,60);
			
			WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathVal)));
			element.clear();
			element.sendKeys(data);
			
			reportStep("The element with xpath: "+xpathVal+" is entered.", "PASS");
		}
		
		
		catch (Exception e) {
		
			
			//	reportStep("The data: "+xpathVal+" could not be entered in the field :"+xpathVal, "FAIL");

				reportStep("The data: "+xpathVal+" could not be entered in the field.Because No suchelement exception has occured :", "FAIL");

		}
	}

	public void fileUploadByXpathExplict(String xpathVal, String data) {
	//	WebDriverWait wait;
		try{
			Thread.sleep(2000);
			
//wait = new WebDriverWait(driver,100);
//WebElement e=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathVal)));

WebElement e=driver.findElement(By.xpath(xpathVal));

		e.sendKeys(data);
		
	
			reportStep("The element with xpath: "+xpathVal+" is entered.", "PASS");
		}
		
		
		catch (Exception e) {
		
			
			//	reportStep("The data: "+xpathVal+" could not be entered in the field :"+xpathVal, "FAIL");

				reportStep("The data: "+xpathVal+" could not be entered in the field.Because No suchelement exception has occured :", "FAIL");

		}
	}
	
	
	
	
	public void uploadfile(String xpathVal, String data) {
		try{
		
			//driver.findElement(By.xpath(xpathVal)).clear();
			WebDriverWait wait = new WebDriverWait(driver,60);
			
			WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathVal)));
			element.clear();
			element.sendKeys(data);
		//	WebElement element = driver.findElement(By.name("uploadsubmit"));
			//To input the filename along with path
			//		element.sendKeys("D:/file.txt");
			
					
			reportStep("file has been uploaded "+xpathVal +"", "PASS");
		}
		
		
		catch (Exception e) {
		
			
			//	reportStep("The data: "+xpathVal+" could not be entered in the field :"+xpathVal, "FAIL");

reportStep("file has not been uploaded "+xpathVal +"", "FAIL");
		}
	}
	
	
	
	



public void clicklistByxpath(String xpathValue) {
	try {
		List<WebElement> list=driver.findElements(By.xpath(xpathValue));
		Thread.sleep(6000);
		

		list.get(0).click();		
		
reportStep("The element with id: "+xpathValue+" is clicked.", "PASS");

} 
	
	catch (NoSuchElementException e) {
		reportStep("The element with xpath: "+xpathValue+" could not be clicked.Because NO Such Element Exception has occured", "FAIL");
	}

	catch (TimeoutException e) {
		reportStep("The element with id: "+xpathValue+" could not be clicked.Because Timeout Exception has occured", "FAIL");
	}
		catch (Exception e) {
		
			
	reportStep("The element with id: "+xpathValue+" could not be clicked.", "FAIL");
}
}

public void comparevalues(int a,int b) {
	
		if (a!=b){
			reportStep("size is not equal pass", "PASS");
		}else{
			reportStep("size is  equal failed", "FAIL");
		}
	}

public void comparevaluesGreater(int a,int b,String validmsg,String errormsg) {
	
	if (a<b){
		reportStep(validmsg, "PASS");
	}else{
		reportStep(errormsg, "FAIL");
	}
}




public void comparevaluesEqual(int a,int b,String validmsg,String errormsg) {
	
	if (a==b){
		reportStep(validmsg, "PASS");
	}else{
		reportStep(errormsg, "FAIL");
	}
}

public void verifybyAttributesPreselectxpath(String xpath, String attribute,String comptext,String validmsg,String errorvalidmsg) {
	try {
		readywithtime(xpath);
		readystate();
		jqueryload();
	} catch (InterruptedException e1) {
	}
	
	
	try{
		String sText = driver.findElementByXPath(xpath).getAttribute(attribute);
		
		
		if (sText.equalsIgnoreCase(comptext)){
			reportStep(validmsg, "PASS");
		}else{
			reportStep(errorvalidmsg, "FAIL");
		}
	}
	catch (Exception e) {
		reportStep("The "+comptext+" Value does not matched" , "FAIL");
	}
	
	
}







public void verifybyAttributesxpath(String xpath, String text) {
	try {
		readywithtime(xpath);
		readystate();
		jqueryload();
	} catch (InterruptedException e1) {
	}
	try{
		String sText = driver.findElementByXPath(xpath).getAttribute("value");
		if (sText.equalsIgnoreCase(text)){
			reportStep("The attributes value "+sText+" matches with the value :"+text, "PASS");
		}else{
			reportStep("The attributes "+sText+" did not match with the value :"+text, "FAIL");
		}
	}
	catch (NoSuchElementException e) {
		reportStep("The element with xpath: "+xpath+" could not be Matched.Because NO Such Element Exception has occured", "FAIL");
	}
	
	catch (TimeoutException e) {
		reportStep("The element with xpath: "+xpath+" could not be Matched.Because TimeOut Exception has occured", "FAIL");
	}
}


public void booleanResult(Boolean a,String b)
{
	if(a){
		reportStep(b, "WARN");
	}
	
}


public void booleanResultFail(Boolean a,String b)
{
	if(!a){
		reportStep(b, "FAIL");
	}
	
}


public void booleanLogoutNoElementResult(Boolean a,String b)
{
	if(!a){
		LogoutStatus=false;	

		reportStep(b, "WARN");
	}
	
}

public void booleanNoElementPresentResult(Boolean a,String b)
{
	if(!a){

		reportStep(b, "INFO");
	}
	
}


public void loginfoStart(String param1,String param2){
	log.info(param1+" "+param2+ "Scenario has Start Execution");

}
public void loginfoSuccess(String param1,String Param2){
	log.info(param1+ " "+Param2 + " Scenario has Executed Successfuly");

}

public void logfailed(String param1,String param2){
	log.info(param1+" "+param2+ "Scenario has been failed");

}


public void booleanNoElementResult(Boolean a,String b)
{
	if(!a){
		reportStep(b, "WARN");
	}
	
}



public void LogoutbooleanResult(Boolean a,String b)
{
	if(a){
		
		LogoutStatus=false;	

		reportStep(b, "WARN");
	}
	
}

public void verifybyAttributesxpath(String xpath, String text,String attributval) {
	try {
		readywithtime(xpath);
		readystate();
		jqueryload();
	} catch (InterruptedException e1) {
	}
	try{
		String sText = driver.findElementByXPath(xpath).getAttribute(attributval);
		if (sText.equalsIgnoreCase(text)){
			reportStep("The attributes value "+sText+" matches with the value :"+text, "PASS");
		}else{
			reportStep("The attributes "+sText+" did not match with the value :"+text, "FAIL");
		}
	}
	catch (NoSuchElementException e) {
		reportStep("The element with xpath: "+xpath+" could not be Matched.Because NO Such Element Exception has occured", "FAIL");
	}
	
	catch (TimeoutException e) {
		reportStep("The element with xpath: "+xpath+" could not be Matched.Because TimeOut Exception has occured", "FAIL");
	}
}

public String getAttributesxpath(String xpath, String text) {
	
	String sText = null;
	try{
		sText = driver.findElementByXPath(xpath).getAttribute(text);
		reportStep("The element with xpath: "+xpath+" returned attribute", "PASS");
		
	}
	
	catch (TimeoutException e) {
		reportStep("The element with xpath: "+xpath+" could not be Matched.Because TimeOut Exception has occured", "FAIL");
	}
	
	return sText;
}



public void AttributesVerifyxpath(String xpath, String value,String valtext) {
	
	String sText = null;
	try{
		sText = driver.findElementByXPath(xpath).getAttribute(value);
		reportStep("The element with xpath: "+xpath+" returned attribute", "PASS");
		
		verifytextmatches(sText, valtext);
		
		
	}
	
	catch (TimeoutException e) {
		reportStep("The element with xpath: "+xpath+" returned attribute", "FAIL");
	}
	
}



public void verifybyAttributesPresentxpath(String xpath, String attributes ,String compText) throws InterruptedException {
	try {
		readywithtime(xpath);
		readystate();
		jqueryload();
	} catch (InterruptedException e1) {
	}
	
	
	try{
		Thread.sleep(3000);
		String sText = driver.findElementByXPath(xpath).getAttribute(attributes);

		if (sText.equalsIgnoreCase("true")){
			
			reportStep("Attributes has preselected", "PASS");
		}else{
			
			
			reportStep("Attributes has not preselected", "FAIL");
		}
	}
	catch (NoSuchElementException e) {
		reportStep("The element with xpath: "+xpath+" could not be Matched.Because NO Such Element Exception has occured", "FAIL");
	}
	
	catch (TimeoutException e) {
		reportStep("The element with xpath: "+xpath+" could not be Matched.Because TimeOut Exception has occured", "FAIL");
	}
}

public void verifyxpathcontainselement(String xpath ,String compText) throws InterruptedException {
	try {
		readywithtime(xpath);
		readystate();
		jqueryload();
	} catch (InterruptedException e1) {
	}
	try{
		Thread.sleep(3000);
		String sText = xpath;

		
		if (sText.contains(compText)&&driver.findElement(By.xpath(xpath)).isDisplayed()){
			
			reportStep(sText+ "contains the value  "+compText, "PASS");
		}else{
			
			reportStep(sText+ "does not contains the value  "+compText, "FAIL");
		}
	}
	catch (NoSuchElementException e) {
		reportStep("The element with xpath: "+xpath+" could not be Matched.Because NO Such Element Exception has occured", "FAIL");
	}
	
	catch (TimeoutException e) {
		reportStep("The element with xpath: "+xpath+" could not be Matched.Because TimeOut Exception has occured", "FAIL");
	}
}

public void verifybyAttributescontainsxpath(String xpath, String attributes ,String compText) throws InterruptedException {
	try {
		readywithtime(xpath);
		readystate();
		jqueryload();
	} catch (InterruptedException e1) {
	}
	try{
		Thread.sleep(3000);
		String sText = driver.findElementByXPath(xpath).getAttribute(attributes);
		if (sText.contains(compText)){
			
			reportStep(sText+ "contains the value  "+compText, "PASS");
		}else{
		
			reportStep(sText+ "does not contains the value  "+compText, "FAIL");
		}
	}
	catch (NoSuchElementException e) {
		reportStep("The element with xpath: "+xpath+" could not be Matched.Because NO Such Element Exception has occured", "FAIL");
	}
	
	catch (TimeoutException e) {
		reportStep("The element with xpath: "+xpath+" could not be Matched.Because TimeOut Exception has occured", "FAIL");
	}
}




public void verifybycheckboxpresent(String xpath, String attributes ,String compText,String validmsg,String errormsg) throws InterruptedException {
	try{
		Thread.sleep(3000);
		String sText = driver.findElementByXPath(xpath).getAttribute(attributes);
		if (sText.equalsIgnoreCase(compText)){
			
			reportStep(validmsg+":", "PASS");
		}else{
			
			
			reportStep(errormsg+":", "FAIL");
		}
	}
	catch (NoSuchElementException e) {
		reportStep("The element with xpath: "+xpath+" could not be Matched.Because NO Such Element Exception has occured", "FAIL");
	}
	
	catch (TimeoutException e) {
		reportStep("The element with xpath: "+xpath+" could not be Matched.Because TimeOut Exception has occured", "FAIL");
	}

	catch (Exception e) {
		reportStep("unKnown Exception occur while verify", "FAIL");
	}



}







public void clicklistByxpathExplicitwaitfirst(String xpathValue) {
	try {
		readywithtime(xpathValue);
		readystate();
		jqueryload();
	} catch (InterruptedException e1) {
	}
	try {
		
		
		
		WebDriverWait wait= new WebDriverWait(driver, 30);
	
		
	//List <WebElement> myIput=(List<WebElement>) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathValue)));
	
	List <WebElement> myIput=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpathValue)));
	
	
	myIput.get(0).click();
		
		
reportStep("The element with id: "+xpathValue+" is clicked.", "PASS");

} 
	
	

	
		catch (Exception e) {
			reportStep("The element with xpath: "+xpathValue+" could not be clicked.Because NO Such Element Exception has occured", "FAIL");


}
}





public void clicklistByxpathExplicitwait(String xpathValue) {
	try {
		readywithtime(xpathValue);
		readystate();
		jqueryload();
	} catch (InterruptedException e1) {
	}
	try {
		WebDriverWait wait= new WebDriverWait(driver, 30);
	List <WebElement> myIput=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpathValue)));
	//List <WebElement> myIput=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpathValue)));
	myIput.get(0).click();		
reportStep("The element with id: "+xpathValue+" is clicked.", "PASS");

} 
		catch (Exception e) {
			reportStep("The element with xpath: "+xpathValue+" could not be clicked.Because NO Such Element Exception has occured", "FAIL");
		}
}


public void clicklistByxpathNosnap(String xpathValue) {
	try {
		List<WebElement> list=driver.findElements(By.xpath(xpathValue));
		Thread.sleep(4000);

		list.get(0).click();	

reportStep("The element with id: "+xpathValue+" is clicked.", "PASS",false);

} 
	
	catch (NoSuchElementException e) {
		reportStep("The element with xpath: "+xpathValue+" could not be clicked.Because NO Such Element Exception has occured", "FAIL",false);
	}

	catch (TimeoutException e) {
		reportStep("The element with id: "+xpathValue+" could not be clicked.Because Timeout Exception has occured", "FAIL",false);
	}
		catch (Exception e) {
	reportStep("The element with id: "+xpathValue+" could not be clicked.", "FAIL",false);
}
}


public void VerifyElementPresent(String xpath) {
	try {
		readywithtime(xpath);
		readystate();
		jqueryload();
	} catch (InterruptedException e1) {
	}
	
	WebElement e  =driver.findElement(By.xpath(xpath));
	
	
	if(e.isDisplayed())
	{
		reportStep("The element with xpath: "+xpath+" is present.", "PASS");

	}
	
	else {
		reportStep("The element with id: "+xpath+" is not present .", "PASS");

	}
	
	
}
	
public void VerifyElementEnable(String xpath) {
	
	WebElement e  =driver.findElement(By.xpath(xpath));
	
	
	if(e.isEnabled())
	{

	}
	
	else {

	}
	
	
}
	





	
	















public void VerifyElementPresent(String xpath,String validmsg,String ErrorvalidMsg) {
	//waitForElement(xpath,2);
	
	
	try {
		readywithtime(xpath);
		readystate();
		jqueryload();
	} catch (InterruptedException e1) {
	}
	try {
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		WebElement e=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		
		
	
	
	if(e.isDisplayed())
	{
		reportStep( "Element is present: " +validmsg, "PASS");

	}
	
	else {
		reportStep("Element is not present: " +ErrorvalidMsg , "FAIL");

	}
	
	
	}

	
	catch (Exception e) {
		reportStep("Element "+xpath+"not found exception has occured ", "FAIL");
	}
	
	
	
}





public void VerifyElementnotPresent(String xpath,String validmsg,String ErrorvalidMsg) {
	try {
		readywithtime(xpath);
		readystate();
		jqueryload();
	} catch (InterruptedException e1) {
	}	
	try {
	WebElement e  =driver.findElement(By.xpath(xpath));
	
	
	if(e.isDisplayed())
	{
		
		reportStep( "Element is present:" +ErrorvalidMsg, "FAIL");

	}
	
	else {
				reportStep("Element is not present" +validmsg , "PASS");

	}
	
	
	}
	catch ( TimeoutException  e) {
		reportStep("Timeout Exception has occured", "FAIL");

		// TODO: handle exception
	}
	catch ( NoSuchElementException  e) {
		reportStep(   "Element not fount" +ErrorvalidMsg , "PASS");

		// TODO: handle exception
	}
	catch ( ElementNotVisibleException  e) {
		reportStep("Element not fount" +ErrorvalidMsg , "PASS");

		// TODO: handle exception
	}
	
	
	catch (Exception e) {
		reportStep("Unknown exception occured ", "FAIL");
	}

}

/*
public void VerifyElementnotPresent(String xpath,String validmsg,String ErrorvalidMsg) {

	try{
		
WebElement e=driver.findElement(By.xpath(xpath));
	
	if(e.isDisplayed())
	{
		
		reportStep( "Element is present:" +ErrorvalidMsg, "FAIL");

	}
	
	else {
				reportStep("Element is not present" +validmsg , "PASS");

	}
	
	
	}
	
	catch (Exception e) {
		reportStep("Element has not found" +validmsg , "PASS");
	}
	
	
	
}
*/



public void VerifyElementenabledORdisabled(String xpath,String msg1,String status1,String Msg2,String Status2) {
	
	try {
		
		
		WebDriverWait wait = new WebDriverWait(driver,40);
		WebElement e=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		
		
	if(e.isEnabled())
	{
		
		reportStep( msg1+ " Element is ENABLED" , status1);

	}
	
	else if(!e.isEnabled()) {
				reportStep(Msg2+ " Element is disabled"  , Status2);

	}
	
	
	}
	catch ( TimeoutException  e) {
		reportStep("Timeout Exception has occured", "FAIL");

		// TODO: handle exception
	}
	catch ( NoSuchElementException  e) {
		reportStep(   "Element not fount"  , "FAIL");

		// TODO: handle exception
	}
	catch ( ElementNotVisibleException  e) {
		reportStep("Element not fount"  , "FAIL");

		// TODO: handle exception
	}
	
	
	catch (Exception e) {
		reportStep("Unknown exception occured ", "FAIL");
	}
	
	
	
}

















	

	public void enterById(String idValue, String data) {
		try {
			driver.findElement(By.id(idValue)).clear();
			driver.findElement(By.id(idValue)).sendKeys(data);	
			reportStep("The data: "+data+" entered successfully in field :"+idValue, "PASS");
		} 
		
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+idValue+" could not be entered.Because NO Such Element Exception has occured", "FAIL");
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+idValue+" could not be entered.Because TimeOut Exception has occured", "FAIL");
		}
		
		catch (Exception e) {
			reportStep("Unknown exception occured while entering "+data+" in the field :"+idValue, "FAIL");
		}
	}
	public void enterByIdfileupload(String idValue, String data) {
		try {
			//driver.findElement(By.id(idValue)).clear();
			driver.findElement(By.id(idValue)).sendKeys(data);	
			reportStep("The data: "+data+" entered successfully in field :"+idValue, "PASS");
		} 
		
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+idValue+" could not be entered.Because NO Such Element Exception has occured", "FAIL");
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+idValue+" could not be entered.Because TimeOut Exception has occured", "FAIL");
		}
		
		catch (Exception e) {
			reportStep("Unknown exception occured while entering "+data+" in the field :"+idValue, "FAIL");
		}
	}
	
	@Override
	public void enterByName(String nameValue, String data) {
		try {
			driver.findElement(By.name(nameValue)).clear();
			driver.findElement(By.name(nameValue)).sendKeys(data);	
			reportStep("The data: "+data+" entered successfully in field :"+nameValue, "PASS");

		}
		
		
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+nameValue+" could not be entered.Because NO Such Element Exception has occured", "FAIL");
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+nameValue+" could not be entered.Because TimeOut Exception has occured", "FAIL");
		}
		
		
		 catch (Exception e) {
			reportStep("Unknown exception occured while entering "+data+" in the field :"+nameValue, "FAIL");
		}

	}

	
	@Override
	public void enterByXpath(String xpathValue, String data) {
		try {
			driver.findElement(By.xpath(xpathValue)).clear();
			driver.findElement(By.xpath(xpathValue)).sendKeys(data);	
			reportStep("The data: "+data+" entered successfully in field :"+xpathValue, "PASS");

		} 
		
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+xpathValue+" could not be entered.Because NO Such Element Exception has occured", "FAIL");
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+xpathValue+" could not be entered.Because TimeOut Exception has occured", "FAIL");
		}
		
		
		
		catch (Exception e) {
			reportStep("Unknown exception occured while entering "+data+" in the field :"+xpathValue, "FAIL");
		}

	}

	
	@Override
	public boolean verifyTitle(String title){
		boolean bReturn = false;
		String currentUrl = null;
		String url= null;
		try{
			Thread.sleep(4000);
			
			if (driver.getTitle().equalsIgnoreCase(title)){
				
				
				currentUrl=driver.getCurrentUrl();
			 url="  "+currentUrl;
				reportStep("The title of the page matches with the value :"+title+url , "PASS");
				bReturn = true;
			}else
				reportStep("The title of the page:"+driver.getTitle()+" did not match with the value :"+title+ url, "SUCCESS");

		}
		
		catch (TimeoutException e) {
			reportStep(" while verifying the title Timeout Exception has occured"+title+ url, "FAIL");
		}
		catch (Exception e) {
			reportStep("Unknown exception occured while verifying the title"+title+ url, "FAIL");
		}
		return bReturn;
	}

	@Override
	public void verifyTextByXpath(String xpath, String text){
		try {
			readywithtime(xpath);
			readystate();
			jqueryload();
		} catch (InterruptedException e1) {
		}
		try {
			
			
			
			String sText = driver.findElement(By.xpath(xpath)).getText();
			if (sText.equalsIgnoreCase(text)){
				reportStep("The text: "+sText+" matches with the value :"+text, "PASS");
			}else{
				reportStep("The text: "+sText+" did not match with the value :"+text, "FAIL");
			}
		}
		
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+xpath+" could not be Matched.Because NO Such Element Exception has occured", "FAIL");
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+xpath+" could not be Matched.Because TimeOut Exception has occured", "FAIL");
		}
		
		
		
		catch (Exception e) {
			reportStep("Unknown exception occured while verifying the title", "FAIL");
		}
	}

	

	

	
	
	public void verifyTextByXpathExplicitwait(String xpath, String text){
		try {
			
			WebDriverWait wait = new WebDriverWait(driver,40);
			WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			
			String sText = element.getText();
			if (sText.equalsIgnoreCase(text)){
				reportStep("The text: "+sText+" matches with the value :"+text, "PASS");
			}else{
				reportStep("The text: "+sText+" did not match with the value :"+text, "FAIL");
			}
		}
		catch (Exception e) {
			reportStep("The :"+text+" could not be Matched.", "FAIL");
		}
	}
	
	
	public void verifyTextByXpathOR(String xpath1,String xpath2, String xpath1text,String xpath2text){
		String verifytextone = null;
		String verifytexttwo = null;
		try {
			
			WebDriverWait wait = new WebDriverWait(driver,40);
			WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath1)));
			
			
			WebElement element1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath2)));
		
			
			verifytextone=element.getText();
			verifytexttwo=element1.getText();
			
			 if(element.isDisplayed()&&verifytextone.contains(xpath1text)){
				 
				 reportStep("The text: "+element.getText()+" matches with the value :"+xpath1text, "PASS");
			 }
			 else if (element1.isDisplayed()&&verifytexttwo.contains(xpath2text)) {
				 reportStep("The text: "+element1.getText()+" matches with the value :"+xpath2text, "PASS");				
			}
			
		}
			 catch (Exception e) {
			reportStep("The : "+verifytextone+ "or "+verifytexttwo+ "text does not matched"  , "FAIL");
		}
	}
	
	
	
	
	
	
	
	public void verifyTextContainsByXpathexplictwait(String xpath, String text){
		try{
			WebDriverWait wait = new WebDriverWait(driver,20);
			WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			String sText = element.getText();
			
						if (sText.contains(text)){
				reportStep("The text: "+sText+" contains the value :"+text, "PASS");
			}else{
				reportStep("The text: "+sText+" did not contain the value :"+text, "FAIL");
			}
		}
		
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+xpath+" could not be Matched.Because NO Such Element Exception has occured", "FAIL");
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+xpath+" could not be Matched.Because TimeOut Exception has occured", "FAIL");
		}
		
		catch (Exception e) {
			reportStep("unknown exception has occured", "FAIL");
		}
	}
	
	public void verifyTextnumberContainsByXpathexplictwait(String xpath, String text){
		try{
			WebDriverWait wait = new WebDriverWait(driver,20);
			WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			
			String sText = element.getText();

			String veritext=sText.replaceAll("[^0-9]", "");
						if (veritext.contains(text)){
				reportStep("The text: "+veritext+" contains the value :"+text, "PASS");
			}else{
				reportStep("The text: "+veritext+" did not contain the value :"+text, "FAIL");
			}
		}
		
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+xpath+" could not be Matched.Because NO Such Element Exception has occured", "FAIL");
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+xpath+" could not be Matched.Because TimeOut Exception has occured", "FAIL");
		}
		
		catch (Exception e) {
			reportStep("unknown exception has occured", "FAIL");
		}
	}
	
	public void verifyTextContainsByXpathexplictwaitint(String xpath, String text){
		try{
			WebDriverWait wait = new WebDriverWait(driver,20);
			WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			String sText = element.getText();
			String comptext=sText.replaceAll("[^0-9]", "");

						if (comptext.contains(text)){
							
				reportStep("The text: "+comptext+" contains the value :"+text, "PASS");
			}else{
				reportStep("The text: "+comptext+" did not contain the value :"+text, "FAIL");
			}
		}
		
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+xpath+" could not be Matched.Because NO Such Element Exception has occured", "FAIL");
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+xpath+" could not be Matched.Because TimeOut Exception has occured", "FAIL");
		}
		
		catch (Exception e) {
			reportStep("unknown exception has occured", "FAIL");
		}
	}
	
	
	

	public String ReturnXpathtext(String xpath){
		
		try {
			readywithtime(xpath);
			readystate();
			jqueryload();
		} catch (InterruptedException e1) {
		}
		
		String sText = null;
		try{
		sText = driver.findElementByXPath(xpath).getText();
//		reportStep(sText, "PASS");

		
		reportStep("text has returned from element", "PASS");

		}
		
		catch (Exception e) {
			reportStep("Unknown exception occured while verify", "FAIL");
		}
		return sText;
	
	}
	
	
	public void ReferenceNo(String Refno,String Msg){
		
		try{
		reportStep( Msg+""+Refno, "PASS");

		}
		
		
		catch (Exception e) {
			reportStep("Unknown exception occured while verify", "FAIL");
		}
		
	}
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	public void verifyTextContainsByXpath(String xpath, String text){
		try {
			readywithtime(xpath);
			readystate();
			jqueryload();
		} catch (InterruptedException e1) {
		}
		//waitForElement(xpath,2);
		WebDriverWait wait;
		try{
			Thread.sleep(2000);
			
wait = new WebDriverWait(driver,60);
WebElement element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));

			String sText = element.getText();
			
			
			
			if (sText.contains(text)){
				reportStep("The text: "+sText+" contains the value :"+text, "PASS");
			}else{
				reportStep("The text: "+sText+" did not contain the value :"+text, "FAIL");
			}
		}
		
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+xpath+" could not be Matched.Because NO Such Element Exception has occured", "FAIL");
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+xpath+" could not be Matched.Because TimeOut Exception has occured", "FAIL");
		}
		
		catch (Exception e) {
			reportStep("Unknown exception occured while verify", "FAIL");
		}
	}
	
	
	public void verifyTextContainsByXpavalidMsg(String xpath, String text,String validmsg,String Errorvalidmsg){
		try{
			String sText = driver.findElementByXPath(xpath).getText();
			if (sText.contains(text)){
				reportStep(validmsg, "PASS");
			}else{
				reportStep(Errorvalidmsg, "FAIL");
			}
		}
		
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+xpath+" could not be Matched.Because NO Such Element Exception has occured", "FAIL");
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+xpath+" could not be Matched.Because TimeOut Exception has occured", "FAIL");
		}
		
		catch (Exception e) {
			reportStep("Unknown exception occured while verify", "FAIL");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void verifyUserdashboardPageLanding_TextContainsByXpath(String xpath, String text){
		try{
			String sText = driver.findElementByXPath(xpath).getText();
			if (sText.contains(text)){
				reportStep("The text: "+sText+" contains the value :"+text+" status in user dashboard page and its landed on userdashboard page", "PASS");
			}else{
				reportStep("The text: "+sText+" did not contain the value :"+text+" status in user dashboard page has opened and its not landed on userboard page", "FAIL");
			}
		}
		
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+xpath+" could not be Matched.Because NO Such Element Exception has occured", "FAIL");
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+xpath+" could not be Matched.Because TimeOut Exception has occured", "FAIL");
		}
		
		catch (Exception e) {
			reportStep("Unknown exception occured while verifying the title", "FAIL");
		}
	}
	
	
	
	
	
    
    public void ScrollclickByXpath(String xpath) {
    	try {
			readywithtime(xpath);
			readystate();
			jqueryload();
		} catch (InterruptedException e1) {
		}
		try{
			JavascriptExecutor JE = driver;  
		    WebElement scroll= driver.findElement(By.xpath(xpath));
		    JE.executeScript("arguments[0].scrollIntoView(true);",scroll);    
		    scroll.click();
		    reportStep("The Page has scrolled element with id: "+xpath+" is clicked.", "PASS");

		} 
		
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+xpath+" could not be clicked.Because NO Such Element Exception has occured", "FAIL");
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+xpath+" could not be clicked.Because TimeOut Exception has occured", "FAIL");
		}
		
		
		
		catch (Exception e) {
			reportStep("The element with id: "+xpath+" could not be clicked.", "FAIL");
		}
	}

    
    
    
    
	
	//WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id(xpathVal)));
			
			
			
			public void verifyUserdashboardPageLanding_TextContainsByXpathExplictiwait(String xpath, String text){
				try{
					
					
					WebDriverWait wait = new WebDriverWait(driver,30);
					
					WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
					
					
					
					String sText = element.getText();
					if (sText.contains(text)){
						reportStep("The text: "+sText+" contains the value :"+text+" status in user dashboard page and its landed on userdashboard page", "PASS");
					}else{
						reportStep("The text: "+sText+" did not contain the value :"+text+" status in user dashboard page has opened and its not landed on userboard page", "FAIL");
					}
				}
				
				catch (Exception e) {
					reportStep("The element with xpath: "+xpath+" could not be Matched.Because NO Such Element Exception has occured", "FAIL");
				}
			}
			
			
			public void verifyUserdashboardPageLanding_TextContainsORoperatorByXpathExplictiwait(String xpath, String text){
				try{
					
					
					WebDriverWait wait = new WebDriverWait(driver,30);
					
					WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
					
					
					
					String sText = element.getText();
					if (sText.contains(text)){
						reportStep("The text: "+sText+" contains the value :"+text+" status in user dashboard page and its landed on userdashboard page", "PASS");
					}else{
						reportStep("The text: "+sText+" did not contain the value :"+text+" status in user dashboard page has opened and its not landed on userboard page", "FAIL");
					}
				}
				
				catch (Exception e) {
					reportStep("The element with xpath: "+xpath+" could not be Matched.Because NO Such Element Exception has occured", "FAIL");
				}
			}
			
			
			
			
			
			
	
	
	public void verifySecondaryLCFopencontainsByXpath(String xpath, String text){
		try{
			
			
			WebDriverWait wait = new WebDriverWait(driver,30);
			
			WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			
			
			
			String sText = element.getText();
			
			
			if (sText.contains(text)){
				reportStep("The text: "+sText+" contains the value & Secondary LCF has opened:"+text, "PASS");
			}else{
				reportStep("Fail: "+sText+" Did not contain the value & Secondary LCF has not opened:"+text, "FAIL");
			}
		}
		
		//catch (NoSuchElementException e) {
		//	reportStep("The element with xpath: "+xpath+" could not be Matched.Because NO Such Element Exception has occured", "FAIL");
	//	}
		
		//catch (TimeoutException e) {
		//	reportStep("The element with xpath: "+xpath+" could not be Matched.Because TimeOut Exception has occured", "FAIL");
		//}
		
		
		catch (Exception e) {
			reportStep("The "+text+" could not be Matched.", "FAIL");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

	@Override
	public void verifyTextById(String id, String text) {
		try{
			String sText = driver.findElementById(id).getText();
			if (sText.equalsIgnoreCase(text)){
				reportStep("The text: "+sText+" matches with the value :"+text, "PASS");
			}else{
				reportStep("The text: "+sText+" did not match with the value :"+text, "FAIL");
			}
		}
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+id+" could not be Matched.Because NO Such Element Exception has occured", "FAIL");
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+id+" could not be Matched.Because TimeOut Exception has occured", "FAIL");
		}
		
		
		
		catch (Exception e) {
			reportStep("Unknown exception occured while verifying the title", "FAIL");
		}
	}

	
	public void verifyTextContainsById(String id, String text) {
		try{
			String sText = driver.findElementById(id).getText();
			if (sText.contains(text)){
				reportStep("The text: "+sText+" contains the value :"+text, "PASS");
			}else{
				reportStep("The text: "+sText+" did not contain the value :"+text, "FAIL");
			}
		}
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+id+" could not be Matched.Because NO Such Element Exception has occured", "FAIL");
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+id+" could not be Matched.Because TimeOut Exception has occured", "FAIL");
		}
		
		
		
		catch (Exception e) {
			reportStep("Unknown exception occured while verifying the title", "FAIL");
		}
	}

	
	
	
	
	
	
	
	
	public void verifyTextRadioBoxType(String id, String text) {
		try{
			

			Thread.sleep(4000);
			
			if (id.contains(text)){
				reportStep("The text: "+text+" contains the value with this :"+id+ " So it allows only single locality", "PASS");
			}else{
				reportStep("The text: "+text+" did not contain the value with this:"+id+" So it allows Multiple locality", "FAIL");
			}
		}
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+id+" could not  contain " +text+ ".Because NO Such Element Exception has occured", "FAIL");
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+id+" could not   contain "+text+".Because TimeOut Exception has occured", "FAIL");
		}
		
		
		
		catch (Exception e) {
			reportStep("Unknown exception occured while verifying the title", "FAIL");
		}
	}
	
	
	
	

	public void closeAllBrowsers() {
		try {
		driver.quit();
		} catch (Exception e) {
			reportStep("The browser could not be closed.", "FAIL");
		}

	}
	
	public void closeBrowser() {
		try {
			driver.close();
		} catch (Exception e) {
			reportStep("The browser could not be closed.", "FAIL");
		}
	}


	@Override
	public void clickById(String id) {
		try{
			driver.findElement(By.id(id)).click();
			reportStep("The element with id: "+id+" is clicked.", "PASS");

		} 
		
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+id+" could not be clicked.Because NO Such Element Exception has occured", "FAIL");
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+id+" could not be clicked.Because TimeOut Exception has occured", "FAIL");
		}
		
		
		
		catch (Exception e) {
			reportStep("The element with id: "+id+" could not be clicked.", "FAIL");
		}
	}

	
	@Override
	public void clickByClassName(String classVal) {
		try{
			driver.findElement(By.className(classVal)).click();
			reportStep("The element with class Name: "+classVal+" is clicked.", "PASS");
		}
		
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+classVal+" could not be clicked.Because NO Such Element Exception has occured", "FAIL");
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+classVal+" could not be clicked.Because TimeOut Exception has occured", "FAIL");
		}
		
		catch (Exception e) {
			reportStep("The element with class Name: "+classVal+" could not be clicked.", "FAIL");
		}
	}

	
	@Override
	public void clickByName(String name) {
		try{
			driver.findElement(By.name(name)).click();
			reportStep("The element with name: "+name+" is clicked.", "PASS");
		} 
		
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+name+" could not be clicked.Because NO Such Element Exception has occured", "FAIL");
			
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+name+" could not be clicked.Because TimeOut Exception has occured", "FAIL");
		}
		
		
		catch (Exception e) {
			reportStep("The element with name: "+name+" could not be clicked.", "FAIL");
		}
	}

	
	@Override
	public void clickByLink(String name) {
		try{
			driver.findElement(By.linkText(name)).click();
			reportStep("The element with link name: "+name+" is clicked.", "PASS");
		} 
		
		
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+name+" could not be clicked.Because NO Such Element Exception has occured", "FAIL");
			
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+name+" could not be clicked.Because TimeOut Exception has occured", "FAIL");
		}
		
		catch (Exception e) {
			reportStep("The element with link name: "+name+" could not be clicked.", "FAIL");
		}
	}

	
	
	
	
	
	
	
	
	
		

	public void clickByXpath(String xpathVal) {
		try{
			driver.findElement(By.xpath(xpathVal)).click();
			reportStep("The element : "+xpathVal+" is clicked.", "PASS");
		} 
		
		
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+xpathVal+" could not be clicked.Because NO Such Element Exception has occured", "FAIL");
			
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+xpathVal+" could not be clicked.Because TimeOut Exception has occured", "FAIL");
		}
		
		
		
		catch (Exception e) {
			reportStep("The element with xpath: "+xpathVal+" could not be clicked.", "FAIL");
		}
	}
	
	
	
	
	public void clickByXpathcontactFind(String xpathVal) {
	
			driver.findElement(By.xpath(xpathVal)).click();
			//reportStep("The element : "+xpathVal+" is clicked.", "PASS");
		
	}
	public void clickXpathFind(String xpathVal) {
		
		driver.findElement(By.xpath(xpathVal)).click();
		
		
		
		//reportStep("The element : "+xpathVal+" is clicked.", "PASS");
	
}
	
	
	public void closeSecondaryLCFclickByXpathExplcitwait(String xpathVal) {
		try{
			
			WebDriverWait wait = new WebDriverWait(driver,30);
			
			WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathVal)));
               element.click();	
			reportStep("The element : "+xpathVal+" is clicked.and secondary LCF has closed", "PASS");
		} 
		
		
		
		
		catch (Exception e) {
			reportStep("The element with xpath: "+xpathVal+" could not be clicked Because No such Element Exception has occured.and secondary LCF has closed", "FAIL");
		}
	}
	
	
	
	
	

	@Override
	public void clickByLinkNoSnap(String name) {
		try{
			driver.findElement(By.linkText(name)).click();
			reportStep("The element with link name: "+name+" is clicked.", "PASS",false);
		}
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+name+" could not be clicked.Because NO Such Element Exception has occured", "FAIL");
			
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+name+" could not be clicked.Because TimeOut Exception has occured", "FAIL");
		}
		
		
		catch (Exception e) {
			reportStep("The element with link name: "+name+" could not be clicked.", "FAIL");
		}

	}

	@Override
	public void clickByXpathNoSnap(String xpathVal) {
		try{
			driver.findElement(By.xpath(xpathVal)).click();
			reportStep("The element : "+xpathVal+" is clicked.", "PASS",false);
		
		}
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+xpathVal+" could not be clicked.Because NO Such Element Exception has occured", "FAIL");
			
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+xpathVal+" could not be clicked.Because TimeOut Exception has occured", "FAIL");
		}
		
		
		catch (Exception e) {
			reportStep("The element with xpath: "+xpathVal+" could not be clicked.", "FAIL");
		}		
	}

	
	public void mouseOverByXpath(String xpathVal) {
		try{
			new Actions(driver).moveToElement(driver.findElement(By.xpath(xpathVal))).build().perform();
			reportStep("The mouse over by xpath : "+xpathVal+" is performed.", "PASS");
		} 
		
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+xpathVal+" could not be found.Because NO Such Element Exception has occured", "FAIL");
			
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+xpathVal+" could not be found.Because TimeOut Exception has occured", "FAIL");
		}
		
		
		catch (Exception e) {
			reportStep("The mouse over by xpath : "+xpathVal+" could not be performed.", "FAIL");
		}
	}

	public void mouseOverByLinkText(String linkName) {
		try{
			new Actions(driver).moveToElement(driver.findElement(By.linkText(linkName))).build().perform();
			reportStep("The mouse over by link : "+linkName+" is performed.", "PASS");
		}
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+linkName+" could not be found.Because NO Such Element Exception has occured", "FAIL");
			
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+linkName+" could not be found.Because TimeOut Exception has occured", "FAIL");
		}
		catch (Exception e) {
			reportStep("The mouse over by link : "+linkName+" could not be performed.", "FAIL");
		}
	}

public void dropdownSelection(String xpath1,String xpath2) throws InterruptedException{ 
	clickByXpathExplict(xpath1);
Thread.sleep(1000);
	clickByXpathExplict(".//li[contains(@class,'active-result')][contains(text(),'"+xpath2+"')]");

}



public void dropdowncitySelection(String xpath1,String xpath2) throws InterruptedException{ 
	clickByXpathExplict(xpath1);
Thread.sleep(6000);
	clickByXpathExplict(".//li[contains(@class,'active-result')][contains(text(),'"+xpath2+"')]");

}


public List<WebElement> elementListReturn(String xpath1) throws InterruptedException{ 
	List<WebElement>ele = null;
	try{
	ele=driver.findElements(By.xpath(xpath1));
	}
	catch (Exception e) {
		// TODO: handle exception
	}
	return ele;
}





public void dropdownSelectionAutoComplete(String xpath1,String xpath2,String xpath3) throws InterruptedException{ 
	clickByXpathExplict(xpath1);
Thread.sleep(6000);
enterByXpathExplict(xpath2, xpath3);
Thread.sleep(1000);

	clickByXpathExplict(".//li[contains(@class,'active-result')][contains(text(),'"+xpath3+"')]");
	
}

public void dropdownSelectionindex(String xpath1,String xpath2,int i) throws InterruptedException{ 
	clickByXpathExplict(xpath1);
Thread.sleep(2000);

//(.//li[contains(@class,'active-result')][contains(text(),'SASABB242003333')])
//	clickByXpathExplict("(.//li[contains(@class,'active-result')][contains(text(),'SASABB242003333')])[10]");

	clickByXpathExplict("(.//li[contains(@class,'active-result')][contains(text(),'"+xpath2+"')])["+i+"]");


}
		





	public String getTextByXpath(String xpathVal){
		try {
			readywithtime(xpathVal);
			readystate();
			jqueryload();
		} catch (InterruptedException e1) {
		}
		String bReturn = "";
		try{
			return driver.findElement(By.xpath(xpathVal)).getText();
		}
		
		
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+xpathVal+" could not be found.Because NO Such Element Exception has occured", "FAIL");
			
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+xpathVal+" could not be found.Because TimeOut Exception has occured", "FAIL");
		}
		
		
		catch (Exception e) {
			reportStep("The element with xpath: "+xpathVal+" could not be found.", "FAIL");
		}
		return bReturn; 
	}

	
	public void comparevalues(String startbalance,String endbalance,String valmsg,String invalidmsg){
		
		
		
		try{

			//Converting String into int using Integer.parseInt()  
			int initialamount=Integer.parseInt(startbalance);  
			int endamount=Integer.parseInt(endbalance);  
			if(initialamount!=endamount){
				reportStep(valmsg , "PASS");
			}
			else {
				reportStep(invalidmsg , "FAIL");
			}
			
		}
		
		
		
		catch (Exception e) {
			reportStep(invalidmsg, "FAIL");
		}
		 
	}

	
	
	
	
	public int getSizeByXpath(String xpathVal){
		int elesize = 0 ;
		try{
		List<WebElement>ele=driver.findElements(By.xpath(xpathVal));
		elesize=ele.size();
		
		reportStep("element size is "+elesize+"", "PASS");

		}
		
		
		
		catch (Exception e) {
			reportStep("unable to get size", "FAIL");
		}
		return elesize; 
	}
	

	public String getTextById(String idVal) {
		String bReturn = "";
		try{
			return driver.findElementById(idVal).getText();
		} 
		
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+idVal+" could not be found.Because NO Such Element Exception has occured", "FAIL");
			
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+idVal+" could not be found.Because TimeOut Exception has occured", "FAIL");
		}
		
		
		catch (Exception e) {
			reportStep("The element with id: "+idVal+" could not be found.", "FAIL");
		}
		return bReturn; 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public void selectVisibileTextById(String id, String value) {
		try{
			new Select(driver.findElement(By.id(id))).selectByVisibleText(value);;
			reportStep("The element with id: "+id+" is selected with value :"+value, "PASS");
		} catch (Exception e) {
			reportStep("The value: "+value+" could not be selected.", "FAIL");
		}
	}


	public void selectVisibileTextByXPath(String xpath, String value) {
		try{
			new Select(driver.findElement(By.xpath(xpath))).selectByVisibleText(value);;
			reportStep("The element with xpath: "+xpath+" is selected with value :"+value, "PASS");
		} 
		
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+xpath+" could not be found.Because NO Such Element Exception has occured", "FAIL");
			
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+xpath+" could not be found.Because TimeOut Exception has occured", "FAIL");
		}
		
		
		catch (Exception e) {
			reportStep("The value: "+value+" could not be selected.", "FAIL");
		}
	}
	public void selectIndexByxpath(String element, int value) {
		try{
			new Select(driver.findElement(By.xpath(element))).selectByIndex(value);
			reportStep("The element with id: "+element+" is selected with index :"+value, "PASS");
		} 
		
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+element+" could not be found.Because NO Such Element Exception has occured", "FAIL");
			
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+element+" could not be found.Because TimeOut Exception has occured", "FAIL");
		}
		
		
		
		
		catch (Exception e) {
			reportStep("The index: "+value+" could not be selected.", "FAIL");
		}
	}

	

	public void selectIndexById(String id, int value) {
		try{
			new Select(driver.findElement(By.id(id))).selectByIndex(value);
			reportStep("The element with id: "+id+" is selected with index :"+value, "PASS");
		} 
		
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+id+" could not be found.Because NO Such Element Exception has occured", "FAIL");
			
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+id+" could not be found.Because TimeOut Exception has occured", "FAIL");
		}
		
		
		
		
		catch (Exception e) {
			reportStep("The index: "+value+" could not be selected.", "FAIL");
		}
	}

	

	public void switchToParentWindow() {
		try {
						driver.switchTo().window(primaryWindowHandle);
			
		} catch (Exception e) {
			reportStep("The window could not be switched to the first window.", "FAIL");
		}
	}
	
	public void switchWindow(String a) {
		try {
						driver.switchTo().window(a);
			
		} catch (Exception e) {
			reportStep("The window could not be switched to the first window.", "FAIL");
		}
	}
	public void windowclose() {
		try{
	
driver.close();
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void windowhandlesindex(int j) {
		try{
	
	
	
	
	Set<String> childwindow=driver.getWindowHandles();
	childwindow=driver.getWindowHandles();
    String[] individualHandle = new String[childwindow.size()];
    Iterator<String> it = childwindow.iterator();
    int i =0;
    while(it.hasNext())
    {
        individualHandle[i] = (String) it.next();
        i++;
    }

driver.switchTo().window(individualHandle[j]);
	
	

reportStep("New window has opened", "PASS");

	
		}
		catch (Exception e) {
			reportStep("New window has not opened", "FAIL");
		}
	}


	public void switchToLastWindow() {
		try {
			Set<String> winHandles = driver.getWindowHandles();
			for (String wHandle : winHandles) {
				driver.switchTo().window(wHandle);
			}
			
			
		} catch (Exception e) {
			reportStep("The window could not be switched to the last window.", "FAIL");
		}
	}


	public void acceptAlert() {
		try {
			driver.switchTo().alert().accept();
		} catch (NoAlertPresentException e) {
			reportStep("The alert could not be found.", "FAIL");
		} catch (Exception e) {
			reportStep("The alert could not be accepted.", "FAIL");
		}

	}

	
	@Override
	public String getAlertText() {		
		String text = null;
		try {
			driver.switchTo().alert().dismiss();
		} catch (NoAlertPresentException e) {
			reportStep("The alert could not be found.", "FAIL");
		} catch (Exception e) {
			reportStep("The alert could not be accepted.", "FAIL");
		}
		return text;

	}


	public void dismissAlert() {
		try {
			driver.switchTo().alert().dismiss();
		} catch (NoAlertPresentException e) {
			reportStep("The alert could not be found.", "FAIL");
		} catch (Exception e) {
			reportStep("The alert could not be accepted.", "FAIL");
		}

	}

	
	
	@Override
	public long takeSnap(){
		long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L; 
		try {
			FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE) , new File("./reports/images/"+number+".jpg"));
		} catch (WebDriverException e) {
			reportStep("Screenshot not Support", "INFO");
		} catch (IOException e) {
			reportStep("The snapshot could not be taken", "FAIL");
		}
		return number;
	}

	public void firstwindow(String primarywindow){
		try{
			driver.switchTo().window(primarywindow);

		}


		catch (NoSuchElementException e) {
			reportStep(" NO Such Element Exception has occured", "FAIL");
			
		}
		
		catch (TimeoutException e) {
			reportStep(" TimeOut Exception has occured", "FAIL");
		}
		

		catch(WebDriverException e){
			reportStep("The window could not be switched to the first window.", "FAIL");
		}


	}


	public void lastwindowhandle(){
		try{



			Set<String> lastWindow = driver.getWindowHandles();
			for (String allWindow : lastWindow) {
				driver.switchTo().window(allWindow);
			}

		}
		
		
		catch (NoSuchElementException e) {
			reportStep(" NO Such Element Exception has occured", "FAIL");
			
		}
		
		catch (TimeoutException e) {
			reportStep(" TimeOut Exception has occured", "FAIL");
		}
		
	
 catch (Exception e) {
		reportStep("The window could not be switched to the last window.", "FAIL");
	}
	
	}

	

	
	
	public void closeOverLCFwindow(String xpath){
		try{

			driver.findElement(By.xpath(xpath)).click();
			reportStep("The window could not be switched to the last window.", "PASS");

		}
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+xpath+" could not be found.Because NO Such Element Exception has occured", "FAIL");
			
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+xpath+" could not be found.Because TimeOut Exception has occured", "FAIL");
		}
		
	
 catch (Exception e) {
		reportStep("The window could not be switched to the last window.", "FAIL");
	}
	
	}
	public void zip() throws Exception{

	
	  String sourceFolderName =  "D:\\Automation\\LsWeb_Sanity\\reports";
      String outputFileName = "D:\\Automation\\LsWeb_Sanity\\reports\\report.zip";

      FileOutputStream fos = new FileOutputStream(outputFileName);
      ZipOutputStream zos = new ZipOutputStream(fos);
      //level - the compression level (0-9)
      zos.setLevel(9);

      addFolder(zos, sourceFolderName, sourceFolderName);

      zos.close();
  }
	
	public void selectedElementClick(String xpath,String xpathone,String text) throws Exception{

	
List<String>a1=new ArrayList<String>();
	WebDriverWait wait= new WebDriverWait(driver, 60);
	List <WebElement>  element=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
	Thread.sleep(8000);
	for (WebElement webElement : element) {
	String cate=webElement.getText();
	a1.add(cate);
	}	


	for(int i=0;i<element.size();i++){

	String refnumber=element.get(i).getText();
		if(refnumber.contains(text)){
		
	int j=i+1;
			clickByXpathExplict("("+xpathone+")["+j+"]");
			Thread.sleep(10000);

		}}


	}
	public static void addFolder(ZipOutputStream zos,String folderName,String baseFolderName)throws Exception{
    File f = new File(folderName);
    if(f.exists()){

        if(f.isDirectory()){
            //Thank to peter 
            //For pointing out missing entry for empty folder
            if(!folderName.equalsIgnoreCase(baseFolderName)){
                String entryName = folderName.substring(baseFolderName.length()+1,folderName.length()) + File.separatorChar;
                ZipEntry ze= new ZipEntry(entryName);
                zos.putNextEntry(ze);    
            }
            File f2[] = f.listFiles();
            for(int i=0;i<f2.length;i++){
                addFolder(zos,f2[i].getAbsolutePath(),baseFolderName);    
            }
        }else{
            //add file
            //extract the relative name for entry purpose
            String entryName = folderName.substring(baseFolderName.length()+1,folderName.length());
            ZipEntry ze= new ZipEntry(entryName);
            zos.putNextEntry(ze);
            FileInputStream in = new FileInputStream(folderName);
            int len;
            byte buffer[] = new byte[1024];
            while ((len = in.read(buffer)) > 0) {
                zos.write(buffer, 0, len);
            }
            in.close();
            zos.closeEntry();

        }
    }else{
    }

    
    
    
}


public void clickBuzzwps(String xpath,String auth1,String auth2) throws InterruptedException{
	try{
List<String>a1=new ArrayList<String>();
WebDriverWait wait= new WebDriverWait(driver, 60);
List <WebElement>  element=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
Thread.sleep(2000);
for (WebElement webElement : element) {
String cate=webElement.getText();
a1.add(cate);
}	
for(int i=0;i<element.size();i++){
String refnumber=element.get(i).getText();
	if(refnumber.contains(getrefnumer)){
int j=i+1;
		clickByXpathExplict("(.//a[contains(@class,'dtln-info')]//h5[@class='dtln-title'])["+j+"]");
		Thread.sleep(10000);

	}}


clickByXpathExplict(prop.getProperty("click.view.buxxhistory.xpath"));
pageScroll1400(prop.getProperty("click.view.buxxpage.xpath"));
if(VerifyElementpresentreturn(".//li[@class='list-group-item'][@title='"+auth1+"']//a")){	
	AuthUsername=auth1;
	clickByXpathExplict(".//li[@class='list-group-item'][@title='"+auth1+"']//a");
}else if (VerifyElementpresentreturn(".//li[@class='list-group-item'][@title='"+auth2+"']//a")) {

	AuthUsername=auth2;
	clickByXpathExplict(".//li[@class='list-group-item'][@title='"+auth2+"']//a");
}else{
	reportStep("Buzz value has not matched", "FAIL");
}
defaultcontent();
}
catch (Exception e) {
}
}



	public void FilterVerification(String FilterType,String FilterStatus,String refrenceNum,String ReferenceNumStatus) throws InterruptedException{
		//Thread.sleep(8000);
		readystate();
		jqueryload();
		clickByXpathExplict(prop.getProperty("click.Filter.xpath"));
		Thread.sleep(2000);
		clickByXpathExplict(prop.getProperty("Click.RequestType.Xpath"));
		clickByXpathExplict(FilterType);
		clickByXpathExplict(prop.getProperty("Click.RequestStatus.Xpath"));
		clickByXpathExplict(FilterStatus);
		clickByXpathExplict(prop.getProperty("Filter.button.xpath"));
		//List<String>refno=new ArrayList<>();
		Thread.sleep(4000);
		//Thread.sleep(2000);

//		readywithtime(xpath);
		readystate();
		jqueryload();
		//pageScroll400();
		verifyTextlistcontainXpath(prop.getProperty("Filter.DepositReferno.xpath"),refrenceNum);


		if(ReferenceNumStatus.equalsIgnoreCase("Accepted")){
//		verifyTextcontainslistByXpath(prop.getProperty("Filter.status.checkingAccepted.Status.xpath"),ReferenceNumStatus);
		
//		verifyTextcontainslistByXpath(prop.getProperty("Filter.status.checkingAccepted.Status.xpath"),ReferenceNumStatus);
			
			
		int a=getSizeByXpath(prop.getProperty("Filter.status.checkingAccepted.Status.xpath"));
			
		 verifyTextsizecontainslistByXpath(prop.getProperty("Filter.status.checkingAccepted.Status.xpath"),a);
		
		}
		}



	public void FilterSelectVerification(String RequestType,String RequestTypeValue,String RequestStatusType,String RequestStatusValue, String refrenceNum,String ReferenceNumStatus) throws InterruptedException{
		clickByXpathExplict(prop.getProperty("click.Filter.xpath"));
		
		dropdownSelection(prop.getProperty(RequestType),RequestTypeValue);
		
		//selectVisibileTextByXPath(prop.getProperty(RequestType),RequestTypeValue);
		
		dropdownSelection(prop.getProperty(RequestStatusType),RequestStatusValue);
		
//		selectVisibileTextByXPath(prop.getProperty(RequestStatusType),RequestStatusValue);
		//Thread.sleep(4000);
		clickByXpathExplict(prop.getProperty("Filter.button.xpath"));
		
		//Thread.sleep(20000);
		Thread.sleep(4000);
		
		
		//pageScroll400();
		verifyTextlistcontainXpath(prop.getProperty("Filter.DepositReferno.xpath"),refrenceNum);
		if(ReferenceNumStatus.equalsIgnoreCase("Accepted")){
//		verifyTextcontainslistByXpath(prop.getProperty("Filter.status.checkingAccepted.Status.xpath"),ReferenceNumStatus);
//		verifyTextcontainslistByXpath(prop.getProperty("Filter.status.checkingAccepted.Status.xpath"),ReferenceNumStatus);

			int a=getSizeByXpath(prop.getProperty("Filter.status.checkingAccepted.Status.xpath"));
			verifyTextsizecontainslistByXpath(prop.getProperty("Filter.status.checkingAccepted.Status.xpath"),a);
		
		}
		}	
	

public void clickBuzz(String auth1,String auth2) throws InterruptedException{
	try{
List<String>a1=new ArrayList<String>();
WebDriverWait wait= new WebDriverWait(driver, 60);
List <WebElement>  element=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//div[contains(@class,'text-right')]//span[contains(@class,'text-info')]")));
Thread.sleep(2000);
for (WebElement webElement : element) {
String cate=webElement.getText();
a1.add(cate);
}	
for(int i=0;i<element.size();i++){
String refnumber=element.get(i).getText();
	if(refnumber.contains(getrefnumer)){
int j=i+1;
		clickByXpathExplict("(.//a[contains(@class,'dtln-info')]//h5[@class='dtln-title'])["+j+"]");
		Thread.sleep(10000);

	}}


clickByXpathExplict(prop.getProperty("click.view.buxxhistory.xpath"));
pageScroll1400(prop.getProperty("click.view.buxxpage.xpath"));
if(VerifyElementpresentreturn(".//li[@class='list-group-item'][@title='"+auth1+"']//a")){	
	AuthUsername=auth1;
	clickByXpathExplict(".//li[@class='list-group-item'][@title='"+auth1+"']//a");
}else if (VerifyElementpresentreturn(".//li[@class='list-group-item'][@title='"+auth2+"']//a")) {

	AuthUsername=auth2;
	clickByXpathExplict(".//li[@class='list-group-item'][@title='"+auth2+"']//a");
}else{
	reportStep("Buzz value has not matched", "FAIL");
}
defaultcontent();
}
catch (Exception e) {
}
}



public void authorizeRequest() throws InterruptedException{
	List<String>a1=new ArrayList<String>();
	WebDriverWait wait= new WebDriverWait(driver, 80);
	Thread.sleep(4000);
	List <WebElement>  element=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//div[contains(@class,'text-right')]//span[contains(@class,'text-info')]")));
	Thread.sleep(3000);
	for (WebElement webElement : element) {
	String cate=webElement.getText();
	a1.add(cate);
	}	

	for(int i=0;i<element.size();i++){

	String refnumber=element.get(i).getText();
		if(refnumber.contains(getrefnumer)){
		
	int j=i+1;
	Thread.sleep(2000);
	clickByXpathExplict("(.//a[contains(@class,'dtln-info')]//h5[@class='dtln-title'])["+j+"]");
			Thread.sleep(2000);
//			scrolltoelementJs(".//div[@id='autorization']//a[text()='Authorize']");	
			//Thread.sleep(4000);
			clickByXpathExplict(".//div[@id='autorization']//a[text()='Authorize']");	
			Thread.sleep(2000);
pageScroll();
			enterByXpathExplict(".//textarea[@id='comment']", "testing");
		//	Thread.sleep(4000);

			enterByXpathExplict(".//input[@id='txtOTP']", "777777");
//	Thread.sleep(7000);

	clickByXpathExplict(".//button[@id='btn2FAValidate']");
	Thread.sleep(2000);


	break;
	}
		
	}
}		

public void authorizeRequest_fundTrans() throws InterruptedException{
	List<String>a1=new ArrayList<String>();
	WebDriverWait wait= new WebDriverWait(driver, 80);
	Thread.sleep(4000);
	List <WebElement>  element=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//div[contains(@class,'text-right')]//span[contains(@class,'text-info')]")));
	Thread.sleep(3000);
	for (WebElement webElement : element) {
	String cate=webElement.getText();
	a1.add(cate);
	}	

	for(int i=0;i<element.size();i++){

	String refnumber=element.get(i).getText();
		if(refnumber.contains(getrefnumer)){
		
	int j=i+1;
	Thread.sleep(4000);
	clickByXpathExplict("(.//a[contains(@class,'dtln-info')]//h5[@class='dtln-title'])["+j+"]");
		//	Thread.sleep(20000);
//			scrolltoelementJs(".//div[@id='autorization']//a[text()='Authorize']");	
			Thread.sleep(4000);
			clickByXpathExplict(".//div[@id='autorization']//a[text()='Authorize']");	
		//	Thread.sleep(2000);
pageScroll();
			enterByXpathExplict(".//textarea[@id='comment']", "testing");
		//	Thread.sleep(4000);
			
			

			enterByXpathExplict(".//input[@id='txtOTP']", "777777");
	Thread.sleep(3000);

			
			
			Boolean a=driver.getPageSource().contains("Transaction Window");
			
			if(a){
	//		clickByXpathExplict(prop.getProperty("ClicklocalTransfer.apporve.xpath"));
			
				clickJs(prop.getProperty("ClicklocalTransfer.apporve.xpath"));
			}
			
			
			
	clickByXpathExplict(".//button[@id='btn2FAValidate']");
	Thread.sleep(4000);


	break;
	}
		
	}
}		

public void authorizeRequestLocalTransfer() throws InterruptedException{
	List<String>a1=new ArrayList<String>();
	WebDriverWait wait= new WebDriverWait(driver, 80);
	Thread.sleep(4000);
	List <WebElement>  element=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//div[contains(@class,'text-right')]//span[contains(@class,'text-info')]")));
	Thread.sleep(3000);
	for (WebElement webElement : element) {
	String cate=webElement.getText();
	a1.add(cate);
	}	

	for(int i=0;i<element.size();i++){

	String refnumber=element.get(i).getText();
		if(refnumber.contains(getrefnumer)){
		
	int j=i+1;
	Thread.sleep(6000);
	clickByXpathExplict("(.//a[contains(@class,'dtln-info')]//h5[@class='dtln-title'])["+j+"]");
			Thread.sleep(10000);
			
			clickByXpathExplict(".//div[@id='autorization']//a[text()='Authorize']");	
			Thread.sleep(2000);
pageScroll();
			enterByXpathExplict(".//textarea[@id='comment']", "just testing");
		//	Thread.sleep(4000);

			enterByXpathExplict(".//input[@id='txtOTP']", "777777");
	Thread.sleep(2000);
	
	Boolean a=VerifyElementpresentreturn(prop.getProperty("ClicklocalTransfer.apporve.xpath"));
//	booleanResult(a, "Transaction cut off time has been elapsed for the day");

	if(a){
	clickByXpath(prop.getProperty("ClicklocalTransfer.apporve.xpath"));
	Thread.sleep(3000);
	}
	clickByXpathExplict(".//button[@id='btn2FAValidate']");
	Thread.sleep(15000);


	break;
	}
		
	}
}		


public void authorizefromDatelineRequest() throws InterruptedException{
	List<String>a1=new ArrayList<String>();
	WebDriverWait wait= new WebDriverWait(driver, 60);
	List <WebElement>  element=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//div[contains(@class,'text-right')]//span[contains(@class,'text-info')]")));
	Thread.sleep(8000);
	for (WebElement webElement : element) {
	String cate=webElement.getText();
	a1.add(cate);
	}	


	for(int i=0;i<element.size();i++){
		Thread.sleep(4000);		
		String refnumber=element.get(i).getText();
			if(refnumber.contains(getrefnumer)){
			
		int j=i+1;
				clickByXpathExplict("(.//a[text()='Authorize'])["+j+"]");				
				Thread.sleep(8000);
				enterByXpathExplict(".//textarea[@id='comment']", "testing");
		enterByXpathExplict(".//input[@id='txtOTP']", "777777");
		clickByXpathExplict(".//button[@id='btn2FAValidate']");				
	Thread.sleep(12000);
		
		break;
		}
			
	}
}		








/*
 
	for(int i=0;i<element.size();i++){
		Thread.sleep(4000);		
		String refnumber=element.get(i).getText();
			if(refnumber.contains(getrefnumer)){
			
		int j=i+1;
				clickByXpathExplict("(.//a[text()='Authorize'])["+j+"]");				
		enterByXpathExplict(".//textarea[@id='comment']", "just testing");
		enterByXpathExplict(".//input[@id='txtOTP']", "777777");
		clickByXpathExplict(".//button[@id='btn2FAValidate']");				
	break;
		}
	
 */

public void authorizefromDatelineRequest_admin() throws InterruptedException{
	List<String>a1=new ArrayList<String>();
	WebDriverWait wait= new WebDriverWait(driver, 60);
	List <WebElement>  element=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//div[contains(@class,'text-right')]//span[contains(@class,'text-info')]")));
	Thread.sleep(8000);
	for (WebElement webElement : element) {
	String cate=webElement.getText();
	a1.add(cate);
	}	


	for(int i=0;i<element.size();i++){
		Thread.sleep(4000);		
		String refnumber=element.get(i).getText();
			if(refnumber.contains(getrefnumer)){
			
		int j=i+1;
				clickByXpathExplict("(.//a[text()='Authorize'])["+j+"]");				
				Thread.sleep(8000);
				enterByXpathExplict(".//textarea[@id='comment']", "testing");
//		enterByXpathExplict(".//input[@id='txtOTP']", "777777");
		clickByXpathExplict(".//button[@id='confirm']");				
	Thread.sleep(12000);
		
		break;
		}
			
	}
}		





public void authorizeWPS(String xpath) throws InterruptedException{
	List<String>a1=new ArrayList<String>();
	WebDriverWait wait= new WebDriverWait(driver, 60);
	List <WebElement>  element=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
	Thread.sleep(8000);
	for (WebElement webElement : element) {
	String cate=webElement.getText();
	a1.add(cate);
	}	


	for(int i=0;i<element.size();i++){
		Thread.sleep(4000);		
		String refnumber=element.get(i).getText();
			if(refnumber.contains(getrefnumer)){
			
		int j=i+1;
				clickByXpathExplict("(.//a[text()='Authorize'])["+j+"]");				
		enterByXpathExplict(".//textarea[@id='comment']", "testing");
		enterByXpathExplict(".//input[@id='txtOTP']", "777777");
		clickByXpathExplict(".//button[@id='btn2FAValidate']");				
	break;
		}
			
	}
}		
public void authorizeWPSFILTER(String Xpath) throws InterruptedException{
	List<String>a1=new ArrayList<String>();
	WebDriverWait wait= new WebDriverWait(driver, 60);
	List <WebElement>  element=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(Xpath)));
	Thread.sleep(8000);
	for (WebElement webElement : element) {
	String cate=webElement.getText();
	a1.add(cate);
	}	

	for(int i=0;i<element.size();i++){

	String refnumber=element.get(i).getText();
		if(refnumber.contains(getrefnumer)){
		
	int j=i+1;
	Thread.sleep(8000);
	clickByXpathExplict("(.//a[contains(@class,'dtln-info')]//h5[@class='dtln-title'])["+j+"]");
			Thread.sleep(20000);
			
			clickByXpathExplict(".//div[@id='autorization']//a[text()='Authorize']");	
			Thread.sleep(15000);

			enterByXpathExplict(".//textarea[@id='comment']", "just testing");
	enterByXpathExplict(".//input[@id='txtOTP']", "777777");
	clickByXpathExplict(".//button[@id='btn2FAValidate']");
	Thread.sleep(15000);


	break;
	}
		
	}
}		




public void getnewurl(){
	try{

		geturl(sUrl);
		//		geturl("https://sabbcorpdev.sabb.com/Corporate/");
		reportStep(sUrl, "PASS");

	}
catch (Exception e) {

	reportStep("Url has not working", "FAIL");

}
}



public void getnewurl(String url){
	try{
		geturl(url);
		reportStep(url, "PASS");

	}
catch (Exception e) {

	reportStep("Url has not working", "FAIL");

}
}


public void AdminDatelinePageBuzz(String auth1,String auth2,String Datelinekeyword) throws InterruptedException{
	try{
List<String>a1=new ArrayList<String>();
WebDriverWait wait= new WebDriverWait(driver, 60);
//List <WebElement>  element=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//div[contains(@class,'text-right')]//span[contains(@class,'text-info')]")));
List <WebElement>  element=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(.//a[contains(@class,'dtln-info')]//h5[@class='dtln-title'])")));
Thread.sleep(2000);
for (WebElement webElement : element) {
String cate=webElement.getText();
a1.add(cate);
}	
for(int i=0;i<element.size();i++){
String refnumber=element.get(i).getText();
	if(refnumber.contains(Datelinekeyword)){
		//Corporate User Profile Creation Request
int j=i+1;
getrefnumer=ReturnXpathtext("(.//div[contains(@class,'text-right')]//span[contains(@class,'text-info')])["+j+"]");
/*		clickByXpathExplict("(.//a[contains(@class,'dtln-info')]//h5[@class='dtln-title'])["+j+"]");*/


Thread.sleep(10000);
break;
	}

}

/*
clickByXpathExplict(prop.getProperty("click.view.buxxhistory.xpath"));
pageScroll1400(prop.getProperty("click.view.buxxpage.xpath"));

if(VerifyElementpresentreturn(".//li[@class='list-group-item'][@title='"+auth1+"']//a")){	
	AuthUsername=auth1;
	clickByXpathExplict(".//li[@class='list-group-item'][@title='"+auth1+"']//a");
}else if (VerifyElementpresentreturn(".//li[@class='list-group-item'][@title='"+auth2+"']//a")) {

	AuthUsername=auth2;
	clickByXpathExplict(".//li[@class='list-group-item'][@title='"+auth2+"']//a");
}else{
	reportStep("Buzz value has not matched", "FAIL");
}

*/
defaultcontent();

	}
catch (Exception e) {
	reportStep(""+e+"", "FAIL");
}
}








public void CorporateAdminAuthorizeRequest() throws InterruptedException{
try{
	
	List<String>a1=new ArrayList<String>();
	WebDriverWait wait= new WebDriverWait(driver, 60);
	List <WebElement>  element=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//div[contains(@class,'text-right')]//span[contains(@class,'text-info')]")));
	Thread.sleep(15000);
	for (WebElement webElement : element) {
	String cate=webElement.getText();
	a1.add(cate);
	}	

	for(int i=0;i<element.size();i++){

	String refnumber=element.get(i).getText();
		if(refnumber.contains(getrefnumer)){
		
	int j=i+1;
	Thread.sleep(8000);
	clickByXpathExplict("(.//a[contains(@class,'dtln-info')]//h5[@class='dtln-title'])["+j+"]");
			Thread.sleep(20000);
			
			clickByXpathExplict(".//div[@id='autorization']//a[text()='Authorize']");	
			Thread.sleep(15000);

			enterByXpathExplict(".//textarea[@id='comment']", "just testing");
//	enterByXpathExplict(".//input[@id='txtOTP']", "777777");
	clickByXpathExplict(".//button[@id='confirm']");
	Thread.sleep(30000);


	break;
	}
		
	}
}
catch (Exception e) {

	reportStep("Unable to find Reference  number", "FAIL");
}



}		




public WebElement fluentwaitsClick(By locator)
{
  Wait wait = new FluentWait(driver)
      .withTimeout(60, TimeUnit.MILLISECONDS)
      .pollingEvery(4, TimeUnit.MILLISECONDS)
      .ignoring(NoSuchElementException.class);
  WebElement element = (WebElement) wait.until(new Function<WebDriver, WebElement>() 
  {

    public WebElement apply(WebDriver driver)
    {
      return driver.findElement(locator);
    }
  });
  return element;
}


}
