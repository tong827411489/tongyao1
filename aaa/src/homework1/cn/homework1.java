package homework1.cn;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.name.cn.Browsers;
import com.name.cn.BrowsersType;

public class homework1 {
	static WebDriver driver = null;
	
	@BeforeClass
	public void before(){
		Browsers browser = new Browsers(BrowsersType.firefox);
		driver = browser.driver;
		driver.get("http://www.126.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//进入iframe
		driver.switchTo().frame("x-URS-iframe");
		//帐号密码填写登录
		driver.findElement(By.xpath("//form[@id='login-form']/descendant::input[@data-placeholder='邮箱帐号或手机号']")).clear();
		driver.findElement(By.xpath("//form[@id='login-form']/descendant::input[@data-placeholder='邮箱帐号或手机号']")).sendKeys("FireflyAutomation");
		driver.findElement(By.xpath("//form[@id='login-form']/descendant::input[@data-placeholder='密码']")).clear();
		driver.findElement(By.xpath("//form[@id='login-form']/descendant::input[@data-placeholder='密码']")).sendKeys("Firefly");
		driver.findElement(By.xpath("//a[@id='dologin']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@id='cnt-box-parent']/descendant::a[text()='继续登录']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.switchTo().defaultContent();
	}
	
	//查看收件箱
	@Test
	public void test1(){
		
		driver.findElement(By.xpath("//div[@id='dvNavContainer']/descendant::div[contains(@id,'_mail')and(contains(@aria-checked,'true'))]")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
			e.getMessage();
		}
	}
	
	//查看发件箱
	@Test
	public void test2(){
		driver.findElement(By.xpath("//span[text()='已发送']/parent::div")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@AfterClass
	public void end(){
		driver.quit();
	}
}
