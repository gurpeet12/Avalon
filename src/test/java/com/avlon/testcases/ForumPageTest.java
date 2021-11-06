package com.avlon.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.avlon.base.TestBase;
import com.avlon.pages.ForumPage;
import com.avlon.pages.HomePage;
import com.avlon.pages.LoginPage;

public class ForumPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	ForumPage forumPage;
	
	public ForumPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException{
		initialization();
		loginPage = new LoginPage();
		forumPage=new ForumPage();
		homePage = loginPage.login("mt1@avalonmeta.com","pass1234");
		homePage.homePageLoading();
		homePage.goToHomeSideMenu();
		forumPage=homePage.goToForumPage();
	}
	
	@Test(priority=1)
	public void ForumCreation() throws InterruptedException{
		
		forumPage.createForumPost();
		
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
