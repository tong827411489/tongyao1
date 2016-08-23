package com.name.cn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ceshi {
	static WebDriver driver = null;
	private FirefoxProfile frirefoxprofile;
//	private static DesiredCapabilities caps = null;
	private String projectpath = System.getProperty("user.dir"); 
	 
	@BeforeClass
	public void start(){
		//System.setProperty("webdriver.firefox.bin", projectpath+"/tools/geckodriver.exe");
		driver = new FirefoxDriver();
	}
	@Test
	public void test(){
//		driver = new FirefoxDriver();
		driver.get("http://www.baidu.com");
	}
	
	@AfterClass
	public void end(){
		driver.quit();
	}
}
