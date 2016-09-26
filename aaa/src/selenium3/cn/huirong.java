package selenium3.cn;

import io.appium.java_client.AppiumDriver;

import java.io.File;
import java.net.URL;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class huirong {
	
	private AppiumDriver appiumDriver;
	
	@BeforeClass
	public void setUp() throws Exception{
		
		//set up appium
		File classpathRoot = new File(System.getProperty("user.dir"));
		
		//���appĿ¼��aaps
		File appDir = new File(classpathRoot,"apps");
		File app = new File(appDir,"com.huirong.lyx.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		//�ֻ�
		capabilities.setCapability("deviceName", "2a281e2");
		capabilities.setCapability(CapabilityType.BROWSER_NAME,"");
		//�ֻ�׿�汾4.4.4
		capabilities.setCapability("platformVersion", "4.4.4");
		//windows�汾
		capabilities.setCapability(CapabilityType.PLATFORM, "WINDOWS");
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("app-package", "com.tencent,reading");
		capabilities.setCapability("app-activity", "com.tencent.reading.activity.SplashActivity");
		appiumDriver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}
	@AfterClass
	public void tearDown() throws Exception{
		appiumDriver.quit();
	}
	@Test
	public void test1(){
		int width=appiumDriver.manage().window().getSize().width;
	    int height=appiumDriver.manage().window().getSize().height;
		//����ݲ���Ҫ
	    try {
			Thread.sleep(5000);
		} catch (Exception e) {
			
		}
		appiumDriver.findElementById("com.huirong.lyx:id/tv_withhold").click();
		//����½�����
		appiumDriver.findElementById("com.huirong.lyx:id/iv_new_add").click();
		
		appiumDriver.findElementById("com.huirong.lyx:id/iv_proposer_idcard_front").click();
		appiumDriver.findElement(By.id("com.huirong.lyx:id/albums")).click();
		   try {
				Thread.sleep(5000);
			} catch (Exception e) {
				// TODO: handle exception
			}
	    appiumDriver.swipe(width/2, height/3*4, width/2, height/4, 100);
	    appiumDriver.swipe(width/2, height/3*4, width/2, height/4, 100);
		//������
	    try {
	    	appiumDriver.findElementById("com.huirong.lyx:id/et_real_name").clear();
		    appiumDriver.findElementById("com.huirong.lyx:id/et_real_name").sendKeys("11");
		    appiumDriver.findElementById("com.huirong.lyx:id/et_id_crid").clear();
		    appiumDriver.findElementById("com.huirong.lyx:id/et_id_crid").sendKeys("33012219921122281X");
		    appiumDriver.findElementById("com.huirong.lyx:id/tv_save").click();
		} catch (Exception e) {
			System.out.println("��дʧ��");
		}
	    //2
	    appiumDriver.findElementById("com.huirong.lyx:id/iv_proposer_idcard_back").click();
		appiumDriver.findElementByName("�����ѡ��");
	    appiumDriver.swipe(width/2, height/3*4, width/2, height/4, 100);
	    appiumDriver.swipe(width/2, height/3*4, width/2, height/4, 100);
	    //3
	    appiumDriver.findElementById("com.huirong.lyx:id/iv_proposer_sign").click();
		appiumDriver.findElementByName("�����ѡ��");
	    appiumDriver.swipe(width/2, height/3*4, width/2, height/4, 100);
	    appiumDriver.swipe(width/2, height/3*4, width/2, height/4, 100);
	    //4
	    appiumDriver.findElementById("com.huirong.lyx:id/iv_proposer_credit_accredit").click();
		appiumDriver.findElementByName("�����ѡ��");
	    appiumDriver.swipe(width/2, height/3*4, width/2, height/4, 100);
	    appiumDriver.swipe(width/2, height/3*4, width/2, height/4, 100);
	    //�����ѯ
	    appiumDriver.findElementById("com.huirong.lyx:id/rbt_query_query").click();
	    
	}
}
