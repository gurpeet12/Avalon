package com.avlon.pages;

import org.openqa.selenium.support.PageFactory;

import com.avlon.base.TestBase;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class StarterStagePage extends TestBase{
	
	//Page Factory - OR:	
	@AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
	MobileElement popup_permission;
	
	@AndroidFindBy(accessibility = "Write your message here...")
	MobileElement Input_message;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"send\"]/android.view.ViewGroup")
	MobileElement send_message;
	
	@AndroidFindBy(accessibility = "dot-menu-btn")
	MobileElement dot_menu_btn;
	
	@AndroidFindBy(accessibility = "create-stage-event")
	MobileElement create_Stage_event_btn;
	
	//Initializing the Page Objects:
	public StarterStagePage() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	//Actions:			
	public void createStarterStage() throws InterruptedException{
		Thread.sleep(10000);
		popup_permission.click();
		popup_permission.click();
		Input_message.sendKeys("Testing starter stage with text");		
		send_message.click();
		dot_menu_btn.click();
		create_Stage_event_btn.click();
	}
	
	
	
}

