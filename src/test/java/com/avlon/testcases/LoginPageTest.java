package com.avlon.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.avlon.base.TestBase;
import com.avlon.pages.HomePage;
import com.avlon.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();	
	}
	
	@Test(priority=1)
	public void loginValidEmail() throws InterruptedException{
		loginPage.login("mt1@avalonmeta.com","pass1234");		
	}
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
