package com.avlon.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.avlon.base.TestBase;
import com.avlon.pages.CalendarPage;
import com.avlon.pages.ForumPage;
import com.avlon.pages.HomePage;
import com.avlon.pages.LoginPage;
import com.avlon.pages.StarterStagePage;

public class StarterStagePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	CalendarPage calendarPage;
	StarterStagePage starterStagePage;
	
	public StarterStagePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException{
		initialization();
		loginPage = new LoginPage();
		starterStagePage=new StarterStagePage();
		calendarPage=new CalendarPage();
		homePage = loginPage.login("tester102@yopmail.com","pass1234");
		homePage.homePageLoading();
		homePage.goToHomeSideMenu();
		starterStagePage=homePage.goToStarterStagePage();
	}
	
	@Test(priority=1)
	public void StarterStageCreation() throws InterruptedException{
		
		starterStagePage.createStarterStage();
		calendarPage.setDataForCalendarEventAndConfirm();
		
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}

