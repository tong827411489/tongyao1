package homework.cn;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.name.cn.Browsers;
import com.name.cn.BrowsersType;


public class homework1 {
	
	private static WebDriver driver = null;
	
	@Test(groups={"ietest"})
	public void iestart(){
		Browsers browser = new Browsers(BrowsersType.ie);
		driver = browser.driver;
		driver.get("http://www.baidu.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='kw']")).clear();
		driver.findElement(By.xpath("//input[@id='kw']")).sendKeys("街上");
		driver.findElement(By.xpath("//input[@id='su']")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}
	
	@Test(groups={"firefoxtest"})
	public void firefoxstart(){
		Browsers browser = new Browsers(BrowsersType.firefox);
		driver = browser.driver;
		driver.get("http://www.360.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@id='header-block']/ul[@id='nav']/descendant::a[text()='社区']")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}
	
	@Test(groups={"chrometest"})
	public void chromestart(){
		Browsers browser = new Browsers(BrowsersType.chrome);
		driver = browser.driver;
		driver.get("http://www.qidian.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[contains(@class,'main')]/descendant::a[text()='全部作品']")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}
	
	
	
}
