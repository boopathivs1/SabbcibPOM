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

public class MailGmail2  {
	static WebDriver driver;
 @Test
 public void h() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
driver.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&osid=1&service=mail&ss=1&ltmpl=default&rm=false&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
	driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
Thread.sleep(4000);

//driver.findElement(By.xpath(".//a[contains(text(),'tpass')]")).click();
driver.findElement(By.xpath(".//input[@id='identifierId']")).sendKeys("boopathi@clayfin.com");
Thread.sleep(4000);

driver.findElement(By.xpath(".//span[text()='Next']")).click();

Thread.sleep(4000);

driver.findElement(By.xpath(".//input[@type='password']")).sendKeys("April@2020");
Thread.sleep(4000);

driver.findElement(By.xpath(".//span[text()='Next']")).click();
Thread.sleep(4000);

driver.findElement(By.xpath("(.//tbody/tr/td//span[text()='test'])[2]")).click();



Thread.sleep(4000);


WebElement e=driver.findElement(By.xpath("(.//div[@dir='ltr']//div[2])"));
System.out.println(e.getText());

//	 String s=PswdRst_Tmp("boopathi@mailinator.com");
 }


	}
