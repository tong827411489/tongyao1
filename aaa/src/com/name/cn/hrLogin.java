package com.name.cn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import selenium2.cn.Wait;
import selenium2.cn.parseProperties;

public class hrLogin {
	
	private WebDriver driver;
	private Wait wait;
	
	public hrLogin(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void loginHr(String account,String password){
		
		
		Browsers browser = new Browsers(BrowsersType.chrome);
		driver = browser.driver;
		wait = new Wait(driver);
		
		driver.get("http://192.168.0.186:9092");
		wait.waitForElementPresent("//div[contains(@class,'header')]/descendant::a[text()='登录']");
		driver.findElement(By.xpath("//div[contains(@class,'header')]/descendant::a[text()='登录']")).click();
		driver.findElement(By.xpath("//input[@id='txtAccount']")).clear();
		driver.findElement(By.xpath("//input[@id='txtAccount']")).sendKeys(account);
		driver.findElement(By.xpath("//input[@id='txtPassword']")).clear();
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(password);
		driver.findElement(By.xpath("//a[@id='btnLogin']")).click();
	}
	
	
}
