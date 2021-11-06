package com.avlon.pages;

import org.openqa.selenium.support.PageFactory;

import com.avlon.base.TestBase;
import com.avlon.pages.HomePage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage extends TestBase{
	//Page Factory - OR:
		@AndroidFindBy(accessibility = "email-btn")
		MobileElement emailOption;
		
		@AndroidFindBy(accessibility = "email-input")
		MobileElement email_Input;
		
		@AndroidFindBy(accessibility = "email-submit")
		MobileElement email_submit;
		
		@AndroidFindBy(accessibility = "password-input")
		MobileElement password_Input;
		
			
		
		//Initializing the Page Objects:
		public LoginPage(){
			PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		}
		
		//Actions:			
		public HomePage login(String email, String pwd) throws InterruptedException{
			Thread.sleep(10000);
			emailOption.click();
			email_Input.sendKeys(email);
			email_submit.click();
			Thread.sleep(5000);
			password_Input.sendKeys(pwd);
			email_submit.click();
						
			return new HomePage();
		}
		
	}

