package testcases;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import wrappers.GenericWrappers;

public class Maildirecturl  {
	static WebDriver driver;
 @Test
 public void h() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
driver.get("https://www.mailinator.com/v3/index.jsp?zone=public&query=boopathi#/#inboxpane");
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
Thread.sleep(4000);

//driver.findElement(By.xpath(".//a[contains(text(),'tpass')]")).click();
driver.findElement(By.xpath("(.//a[contains(text(),'tpass')])[1]")).click();


Thread.sleep(4000);

driver.switchTo().frame("msg_body");
Thread.sleep(4000);

WebElement e=driver.findElement(By.xpath(".//div[@dir='ltr']/a"));
System.out.println(e.getText());
driver.switchTo().defaultContent();

//	 String s=PswdRst_Tmp("boopathi@mailinator.com");
 }


	}
