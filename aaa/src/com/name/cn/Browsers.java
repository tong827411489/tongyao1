package com.name.cn;

import java.io.File;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Browsers {
	public  static WebDriver driver = null;
	private FirefoxProfile frirefoxprofile = null;
	private static DesiredCapabilities caps = null;
	private String projectpath = System.getProperty("user.dir"); 
	
	public Browsers(BrowsersType browswetype){
		switch (browswetype) {
		//调用火狐
		case firefox:
			File firebug = new File(projectpath+"/tools/firebug@software.joehewitt.com.xpi");
			File fileXPath = new File(projectpath+"/tools/FireXPath@pierre.tholence.com.xpi");
			frirefoxprofile = new FirefoxProfile();
			try {
				frirefoxprofile.addExtension(firebug);
				frirefoxprofile.addExtension(fileXPath);
				frirefoxprofile.setPreference("extensions.firebug.currentVersion", "2.0.17");
				frirefoxprofile.setPreference("extensions.FirePath.currentVersion", "0.9.7.1.1-signed.1-signed"); 
				frirefoxprofile.setPreference("webdriver.accept.untrusted.certs", true);
				frirefoxprofile.setPreference("extensions.firebug.currentVersion", "1.12.1");
			} catch (Exception e) {
				e.printStackTrace();
			}
			driver = new FirefoxDriver(frirefoxprofile);
			driver.manage().window().maximize();
			break;
			//调用ie
		case ie:
			System.setProperty("webdriver.ie.driver", projectpath+"/tools/IEDriverServer641.exe");
			caps = DesiredCapabilities.internetExplorer();
			caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			caps.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, false);
			caps.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");
			caps.setCapability("ignoreZoomSetting", true);
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			break;
			//调用chrome
		case chrome:
			System.setProperty("webdriver.chrome.driver", projectpath+"/tools/chromedriver.exe");
			caps = DesiredCapabilities.chrome();
//			caps.setCapability("chrome.switches", Arrays.asList("--start-maximized"));
			driver = new ChromeDriver(caps);
			driver.manage().window().maximize();
			break;
		}
	}
}
