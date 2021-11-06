package com.avlon.pages;

import org.openqa.selenium.support.PageFactory;

import com.avlon.base.TestBase;
import com.avlon.util.TestUtil;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ForumPage extends TestBase{
	
	//Page Factory - OR:
	@AndroidFindBy(accessibility = "create-forum-btn")
	MobileElement create_Forum_btn;
	
	@AndroidFindBy(accessibility = "forum-post-body")
	MobileElement write_Forum_Post_textarea;
	
	//as the accessibility Id for write forum text area not taking send keys
	@AndroidFindBy(xpath= "//android.view.ViewGroup[@content-desc=\"forum-post-body\"]/android.view.ViewGroup/android.widget.EditText")
	MobileElement write_Forum_Post_textareaXpath;	
	
	@AndroidFindBy(accessibility = "post-forum-btn")
	MobileElement post_Forum_btn;
	
	//Initializing the Page Objects:
	public ForumPage() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	//Actions:			
	public void createForumPost() throws InterruptedException{
		//TestUtil.waitForElementsToBeVisible(create_Forum_btn);
		Thread.sleep(2000);
		create_Forum_btn.click();	
		Thread.sleep(5000);
		write_Forum_Post_textareaXpath.sendKeys("Testing Forum Post with text");		
		post_Forum_btn.click();
	}
	
	
	
}
