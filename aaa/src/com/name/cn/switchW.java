package com.name.cn;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class switchW {
	
	private WebDriver driver;
	private String currentwindow;
	
	public switchW(WebDriver driver){
		this.driver = driver;
		currentwindow = driver.getWindowHandle();
		//PageFactory.initElements(driver,this);
	}
	
	public void toSpecificWindow(String acctualTitleName){
		Set<String> handles = driver.getWindowHandles();
		String titleName;
		for(String handle:handles){
			titleName = driver.switchTo().window(handle).getTitle();
			if (titleName.contains(acctualTitleName)) {
				break;
			}
		}
	}
	
	public void backTocurrentWindow(){
		driver.switchTo().window(currentwindow);
	}
}
