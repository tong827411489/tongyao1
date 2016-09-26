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
		
		Browsers browser = new Browsers(BrowsersType.firefox);
		driver = browser.driver;
		wait = new Wait(driver);
	}
	
	@Test
	public void Login(){
		driver.get(locator.getvalue("url"));
		wait.waitManage();
		driver.switchTo().frame("x-URS-iframe");
		
		driver.findElement(By.xpath(locator.getvalue("username"))).clear();
		driver.findElement(By.xpath(locator.getvalue("username"))).sendKeys(data.getvalue("username"));
		driver.findElement(By.xpath(locator.getvalue("password"))).sendKeys(data.getvalue("password"));
		wait.waitForElementPresent(locator.getvalue("submit"));
		driver.findElement(By.xpath(locator.getvalue("submit"))).click();
		wait.waitForElementPresent(locator.getvalue("continue"));
		driver.findElement(By.xpath(locator.getvalue("continue"))).click();
		driver.switchTo().defaultContent();
	}
	
	@Test
	public void restriveMailsIn(){
		wait.waitForElementPresent(locator.getvalue("outlook"));
		
		String expectedNum = driver.findElement(By.xpath(locator.getvalue("outlook"))).getText().substring(1, 3);
		driver.findElement(By.xpath(locator.getvalue("outlook"))).click();
		//收件箱未读邮件是否显示一致
		int b = 0;
		int actualNum = Integer.parseInt(driver.findElement(By.xpath(locator.getvalue("page"))).getText().substring(2, 3));
		for (int i = 0; i < actualNum-1; i++) {
			wait.waitFor(3000);
			List<WebElement> Unread = driver.findElements(By.xpath(locator.getvalue("Unread")));
			b = Unread.size()+b;
			System.out.println(b);
			driver.findElement(By.xpath(locator.getvalue("nextpage"))).click();
			
		}
		String c = b+"";      //int 转化String类型做比较
		Assert.assertEquals(expectedNum.equals(c),true);
		wait.waitFor(5000);
	}
	
	@AfterClass
	public void end(){
		driver.quit();
	}
}