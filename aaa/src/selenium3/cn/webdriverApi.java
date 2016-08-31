package selenium3.cn;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.name.cn.Browsers;
import com.name.cn.BrowsersType;
import selenium2.cn.Wait;
import selenium2.cn.parseProperties;

public class webdriverApi {
	
	private WebDriver driver;
	private parseProperties locator;
	private parseProperties data;
	private Wait wait;
	
	@Parameters({"locator","data"})
	@BeforeClass
	public void premise(@Optional("locator")String loc,@Optional("data")String da){
		locator = new parseProperties(System.getProperty("user.dir")+"/tools/"+loc+".properties");
		data = new parseProperties(System.getProperty("user.dir")+"/tools/"+da+".properties");
		
		Browsers browser = new Browsers(BrowsersType.chrome);
		driver = browser.driver;
		wait = new Wait(driver);
	}
	
	@Test
	public void openPage(){
		driver.get("http://jqueryui.com/slider/");
		wait.waitForElementPresent(locator.getvalue("premise"));
		driver.switchTo().frame(driver.findElement(By.xpath(locator.getvalue("Silderframe"))));
		//起始坐标
		Point silder =  driver.findElement(By.xpath(locator.getvalue("PrerequisiteSlider"))).getLocation();
		Actions action = new Actions(driver);
		action.dragAndDropBy(driver.findElement(By.xpath(locator.getvalue("PrerequisiteSlider"))), silder.x+500, silder.y).perform();
		//终点坐标
		Point silder1 =  driver.findElement(By.xpath(locator.getvalue("PrerequisiteSlider"))).getLocation();
		Assert.assertEquals(silder1.x, silder.x+500);//坐标是否一致
		
	}
	
	@Test
	public void hrSelect(){
		driver.get("http://192.168.0.186:9092");
		wait.waitForElementPresent(locator.getvalue("hrregister"));
		driver.findElement(By.xpath(locator.getvalue("hrregister"))).click();
		driver.findElement(By.xpath(locator.getvalue("hrnextpage"))).click();
		driver.findElement(By.xpath(locator.getvalue("companyname"))).clear();
		driver.findElement(By.xpath(locator.getvalue("companyname"))).sendKeys("建德他");
		//选择地区
		Select province = new Select(driver.findElement(By.xpath(locator.getvalue("selectprovince"))));
		province.selectByVisibleText("浙江省");
		Select city = new Select(driver.findElement(By.xpath(locator.getvalue("selectcity"))));
		city.selectByVisibleText("杭州市");
		Select area = new Select(driver.findElement(By.xpath(locator.getvalue("selectarea"))));
		area.selectByVisibleText("上城区");
		//输入相关信息
		driver.findElement(By.xpath(locator.getvalue("requestName"))).clear();
		driver.findElement(By.xpath(locator.getvalue("requestName"))).sendKeys("风华绝他");
		driver.findElement(By.xpath(locator.getvalue("imgAuthCode"))).clear();
		driver.findElement(By.xpath(locator.getvalue("imgAuthCode"))).sendKeys("1234");
		driver.findElement(By.xpath(locator.getvalue("phone"))).clear();
		driver.findElement(By.xpath(locator.getvalue("phone"))).sendKeys("18268207221");
		driver.findElement(By.xpath(locator.getvalue("phoneAuthCode"))).clear();
		driver.findElement(By.xpath(locator.getvalue("phoneAuthCode"))).sendKeys("0987654321");
		driver.findElement(By.xpath(locator.getvalue("checkpassword"))).clear();
		driver.findElement(By.xpath(locator.getvalue("checkpassword"))).sendKeys("111111q");
		driver.findElement(By.xpath(locator.getvalue("checkpasswordAgain"))).clear();
		driver.findElement(By.xpath(locator.getvalue("checkpasswordAgain"))).sendKeys("111111q");
		driver.findElement(By.xpath(locator.getvalue("registernextpage"))).click();
		driver.findElement(By.xpath(locator.getvalue("companyLicencs"))).sendKeys("D:/11111.jpg");
		driver.findElement(By.xpath(locator.getvalue("submit"))).click();
		driver.findElement(By.xpath(locator.getvalue("Determine"))).click();
		driver.findElement(By.xpath(locator.getvalue("DetermineAgain"))).click();
	}
	
	@Test
	public void assertRegister(){
		driver.get("http://192.168.0.186:9092");
		wait.waitForElementPresent(locator.getvalue("signIn"));
		driver.findElement(By.xpath(locator.getvalue("signIn"))).click();
		driver.findElement(By.xpath(locator.getvalue("account"))).clear();
		driver.findElement(By.xpath(locator.getvalue("account"))).sendKeys(data.getvalue("account"));
		driver.findElement(By.xpath(locator.getvalue("password"))).clear();
		driver.findElement(By.xpath(locator.getvalue("password"))).sendKeys(data.getvalue("pass"));
		driver.findElement(By.xpath(locator.getvalue("login"))).click();
		wait.waitForElementPresent(locator.getvalue("Settled"));
		driver.findElement(By.xpath(locator.getvalue("Settled"))).click();
		driver.findElement(By.xpath(locator.getvalue("examine"))).click();
		driver.switchTo().frame("settledListConfig-iframe");
		String frist = driver.findElement(By.xpath(locator.getvalue("firstname"))).getText();
		driver.switchTo().defaultContent();
		//判断后台是否存在该注册信息
		Assert.assertEquals(frist.equals("建德他"), true);
	} 
	
	@AfterClass
	public void end(){
		driver.quit();
	}
}
