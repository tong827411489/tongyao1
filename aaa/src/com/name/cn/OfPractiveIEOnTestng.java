package com.name.cn;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OfPractiveIEOnTestng {
	
	private static WebDriver chromeweb = null;

	@BeforeClass
	public void startchrome(){
		Browsers browse = new Browsers(BrowsersType.firefox);
		chromeweb = browse.driver;
	}
	
	@Test
	public void testbaidu() throws InterruptedException{
		
		chromeweb.get("http://www.baidu.com");
		chromeweb.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	@AfterClass
	public void endchrome(){
		chromeweb.quit();
	}
}
