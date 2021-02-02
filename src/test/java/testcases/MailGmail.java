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

public class MailGmail  {
	static WebDriver driver;
 @Test
 public void h() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().deleteAllCookies();

		driver.manage().window().maximize();
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


//WebElement e=driver.findElement(By.xpath("(.//div[@dir='ltr']//div[2])"));
WebElement e=driver.findElement(By.xpath("(.//div[@dir='ltr'][contains(text(),'test')])"));



System.out.println(e.getText());
Thread.sleep(4000);


WebElement eurl=driver.findElement(By.xpath(".//div[text()='url-']//a"));
System.out.println(eurl.getText());

Thread.sleep(4000);
//WebElement eiframe=driver.findElement(By.xpath(".//iframe[@role='presentation']"));
//driver.switchTo().frame(eiframe);
System.out.println("next is click delete button");
Thread.sleep(10000);
//driver.findElement(By.xpath("(.//div[@aria-label='Delete'])[1]")).click();
		driver.findElement(By.xpath("(.//div[@class='asa'])[15]")).click();

 }



}
