package selenium2.cn;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.name.cn.Browsers;
import com.name.cn.BrowsersType;

public class homework21 {
	
	private WebDriver driver = null;
	private parseProperties locator;
	private parseProperties data;
	
	@Parameters({"locator","data"})
	@BeforeClass
	public void before(String loc,String da){
		locator = new parseProperties(System.getProperty("user.dir")+loc);
		data = new parseProperties(System.getProperty("user.dir")+da);
		
		Browsers browser = new Browsers(BrowsersType.firefox);
		driver = browser.driver;
	}
	
	@Test
	public void test1(){
		
	}
}
