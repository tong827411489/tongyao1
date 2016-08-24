package selenium2.cn;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.name.cn.Browsers;
import com.name.cn.BrowsersType;

public class homework2 {
	
	private static WebDriver driver = null;
	private Browsers browser = null;
	
	@Parameters("platfrom")
	@BeforeMethod(groups="browsers")
	public void before(@Optional("platfrom")String platfrom){
		if (platfrom.equals("firefox")) {
			browser = new Browsers(BrowsersType.firefox);
			driver = browser.driver;
		}else if (platfrom.equals("chrome")) {
			browser = new Browsers(BrowsersType.chrome);
			driver = browser.driver;
		}else{
			browser = new Browsers(BrowsersType.ie);
			driver = browser.driver;
		}
	}
	
	@Test(groups="submit1")
	public void test1(){
		driver.get("http://www.baidu.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@Test(groups="submit2")
	public void test2(){
		driver.get("http://www.126.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@Test(groups="submit3")
	public void test3(){
		driver.get("http://www.so.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("1");
	}
	
	@Test(groups="submit4")
	public void test4(){
		driver.get("http://www.hrfax.cn");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("1");
	}
	
	@AfterMethod(groups="browsers")
	public void end(){
		driver.quit();
	}
}
