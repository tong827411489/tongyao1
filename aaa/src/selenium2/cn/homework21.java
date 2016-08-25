package selenium2.cn;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.name.cn.Browsers;
import com.name.cn.BrowsersType;

public class homework21 {
	
	private WebDriver driver = null;
	private parseProperties locator;
	private parseProperties data;
	private Wait wait;
	
	@Parameters({"locator","data"})
	@BeforeClass
	public void before(@Optional("locator")String loc,@Optional("data")String da){
		locator = new parseProperties(System.getProperty("user.dir")+"/tools/"+loc+".properties");
		data = new parseProperties(System.getProperty("user.dir")+"/tools/"+da+".properties");
		
		Browsers browser = new Browsers(BrowsersType.chrome);
		driver = browser.driver;
		wait = new Wait(driver);
	}
	
	@Test
	public void test1(){
		driver.get(locator.getvalue("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().frame("x-URS-iframe");
		
		driver.findElement(By.xpath(locator.getvalue("username"))).clear();
		driver.findElement(By.xpath(locator.getvalue("username"))).sendKeys(data.getvalue("username"));
		driver.findElement(By.xpath(locator.getvalue("password"))).sendKeys(data.getvalue("password"));
		wait.waitForElementPresent(locator.getvalue("submit"));
		driver.findElement(By.xpath(locator.getvalue("submit"))).click();
		wait.waitForElementPresent(locator.getvalue("continue"));
		driver.findElement(By.xpath(locator.getvalue("continue"))).click();
		driver.switchTo().defaultContent();
		wait.waitForElementPresent(locator.getvalue("outlook"));
//		Assert.assertEquals(driver.findElement(By.xpath(locator.getvalue("lookemail"))).isDisplayed(), true);
//		driver.findElement(By.xpath(locator.getvalue("lookemail"))).click();
		
		String a = driver.findElement(By.xpath(locator.getvalue("outlook"))).getText().substring(1, 3);
		driver.findElement(By.xpath(locator.getvalue("outlook"))).click();
		//收件箱未读邮件是否显示一致
		int b = 0;
		for (int i = 0; i < 6; i++) {
			wait.waitFor(5000);
			List<WebElement> Unread = driver.findElements(By.xpath(locator.getvalue("Unread")));
			b = Unread.size()+b;
			System.out.println(b);
			wait.waitFor(5000);
			driver.findElement(By.xpath(locator.getvalue("nextpage"))).click();
		}
		String c = b+"";      //int 转化String类型做比较
		Assert.assertEquals(a.equals(c),true);
		wait.waitFor(5000);
		
	}
	
	@AfterClass
	public void end(){
		driver.quit();
	}
}