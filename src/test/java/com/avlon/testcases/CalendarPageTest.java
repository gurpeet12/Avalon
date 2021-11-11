package com.avlon.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.avlon.base.TestBase;
import com.avlon.pages.CalendarPage;
import com.avlon.pages.HomePage;
import com.avlon.pages.LoginPage;

public class CalendarPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	CalendarPage calendarPage;
	
	public CalendarPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException{
		initialization();
		loginPage = new LoginPage();
		calendarPage=new CalendarPage();
		homePage = loginPage.login("mt1@avalonmeta.com","pass1234");
		homePage.homePageLoading(false);
		homePage.goToHomeSideMenu();
		calendarPage=homePage.goToCalendarPage();
	}
	
	@Test(priority=1)
	public void CalenderEventCreation() throws InterruptedException{
		
		calendarPage.createCalendarEvent();		
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();;
	}
	
}
