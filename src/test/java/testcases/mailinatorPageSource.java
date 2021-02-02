package testcases;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import wrappers.GenericWrappers;

public class mailinatorPageSource  {
	static WebDriver driver;
 @Test
 public void h(){
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();

	
	 String s=PswdRst_Tmp("boopathi@mailinator.com");
 }


	public static String PswdRst_Tmp(String mailid)
	{
		String pswd = null;
		try {
			Thread.sleep(3000);
			
			
			((JavascriptExecutor) driver).executeScript("window.open('about:blank','_blank');");
			
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		    String[] tmpMailValue =	mailid.split("@");
		    String mailValue = tmpMailValue[0].trim();
		    String mail_option = tmpMailValue[1].substring(0, tmpMailValue[1].length()-4);
		    
		    switch (mail_option.toUpperCase()) {
			case "MAILINATOR":
				
				driver.switchTo().window(tabs.get(1));
				driver.navigate().to("https://www.mailinator.com/v3/index.jsp?zone=public&query="+mailValue+"#/#inboxpane");
				
				for(int i=0;i<=5;i++)
				{
					driver.navigate().refresh();
					Thread.sleep(2000);
				}
				String Tmp = "";
				try {
//					Tmp = driver.findElement(By.xpath(".//*[@id='inboxpane']/div/div/div/table/tbody/tr[1]")).getAttribute("id");
					Tmp = driver.findElement(By.xpath(".//*[@id='inboxpane']//table/tbody/tr[1]")).getAttribute("id");
							
					
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			    
			    String[] tmppswd = Tmp.split("row_");
			    String value = tmppswd[1].trim();
			    driver.navigate().to("https://www.mailinator.com/fetch_email?msgid="+value+"&zone=public");

			    String pgesrc = driver.getPageSource();
			    String [] tmpMailPswd = null;
			    String []urlspit=null;
			    try {
	    	tmpMailPswd = pgesrc.split("Temporary Password: ");
//			    	tmpMailPswd = pgesrc.split("URLLink:");
			    	
			    	
			    	
	    	//pswd = tmpMailPswd[1].substring(0, 26).trim();
	    	pswd = tmpMailPswd[1].substring(0, 8).trim();

	    	System.out.println(pswd);
				    pgesrc=null;
				} catch (Exception e) {
					tmpMailPswd = pgesrc.split("Verification Code: ");
					pswd = tmpMailPswd[1].substring(0, 8).trim();
					//pswd = tmpMailPswd[1];
					
					System.out.println(pswd);
				    pgesrc=null;
				}
			   
			    driver.switchTo().window(tabs.get(0));
			    Thread.sleep(1000);
				break;
				
			case "MAILNESIA":
				
				driver.switchTo().window(tabs.get(1));
				driver.navigate().to("http://mailnesia.com/mailbox/"+mailValue+"");
				
				for(int i=0;i<=5;i++)
				{
					driver.navigate().refresh();
					Thread.sleep(5000);
				}
				String TmpR = "";
				try {
					TmpR = driver.findElement(By.xpath(".//*[@class='email']/tbody/tr[1]")).getAttribute("id");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				
			    driver.navigate().to("http://mailnesia.com/mailbox/"+mailValue+"/"+TmpR+"/raw");
			    String Tmppgesrc = driver.getPageSource();
			    
			    String [] tmpMailPsd = Tmppgesrc.split("Temporary Password: ");
			    String Tpswd = tmpMailPsd[1].substring(0, 8).trim();
			    System.out.println(Tpswd);
			    
			    driver.switchTo().window(tabs.get(0));
			    Thread.sleep(1000);
				break;

			default:
				break;
			}
		    
		} catch (Exception e) {
			System.out.println("exception @PswdRst_Tmp function: "+e.getMessage());
		}
		return pswd;
		
	}
}
