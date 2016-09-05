package homework1.cn;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import selenium2.cn.Wait;

import com.name.cn.Browsers;
import com.name.cn.BrowsersType;

public class homework1 {
	static WebDriver driver = null;
	private Wait wait;
	
	@BeforeClass
	public void before(){
		Browsers browser = new Browsers(BrowsersType.firefox);
		driver = browser.driver;
		wait = new Wait(driver);
		driver.get("http://www.126.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//����iframe
		driver.switchTo().frame("x-URS-iframe");
		//�ʺ�������д��¼
		driver.findElement(By.xpath("//form[@id='login-form']/descendant::input[@data-placeholder='�����ʺŻ��ֻ���']")).clear();
		driver.findElement(By.xpath("//form[@id='login-form']/descendant::input[@data-placeholder='�����ʺŻ��ֻ���']")).sendKeys("FireflyAutomation");
		driver.findElement(By.xpath("//form[@id='login-form']/descendant::input[@data-placeholder='����']")).clear();
		driver.findElement(By.xpath("//form[@id='login-form']/descendant::input[@data-placeholder='����']")).sendKeys("Firefly");
		driver.findElement(By.xpath("//a[@id='dologin']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@id='cnt-box-parent']/descendant::a[text()='������¼']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.switchTo().defaultContent();
	}
	
	//�鿴�ռ���
//	@Test
//	public void test1(){
//		
//		driver.findElement(By.xpath("//div[@id='dvNavContainer']/descendant::div[contains(@id,'_mail')and(contains(@aria-checked,'true'))]")).click();
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//			
//		}
//	}
	
	//�鿴δ��
	@Test
	public void test2(){
		wait.waitForElementPresent("//div[@id='dvNavTree']/descendant::span[text()='�ռ���']");
		Actions actions = new Actions(driver);
		actions.contextClick(driver.findElement(By.xpath("//div[@id='dvNavTree']/descendant::span[text()='�ռ���']"))).build().perform();
		
		driver.findElement(By.xpath("//div[contains(@style,'visible')]/descendant::span[text()='�鿴δ��']")).click();
		String unlook = driver.findElement(By.xpath("//div[@id='dvContainer']/descendant::h1[text()='δ��']")).getText();
		Assert.assertEquals(unlook.equals("δ��"), true);
	}
	@AfterClass
	public void end(){
		driver.quit();
	}
}
