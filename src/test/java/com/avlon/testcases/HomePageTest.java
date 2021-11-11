package com.avlon.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.avlon.base.TestBase;
import com.avlon.pages.CalendarPage;
import com.avlon.pages.HomePage;
import com.avlon.pages.LoginPage;


public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	ForumPageTest forumPage;
	CalendarPage calendarPage;
	
	
	
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException{
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login("mt1@avalonmeta.com","pass1234");
	}
	
	@Test(priority=1)
	public void verifyHomePageLoading() throws InterruptedException{
		
		homePage.homePageLoading(false);
	}
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
