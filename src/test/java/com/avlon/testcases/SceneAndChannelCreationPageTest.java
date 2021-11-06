package com.avlon.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.avlon.base.TestBase;
import com.avlon.pages.SceneAndChannelCreationPage;
import com.avlon.pages.ForumPage;
import com.avlon.pages.HomePage;
import com.avlon.pages.LoginPage;

public class SceneAndChannelCreationPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	SceneAndChannelCreationPage channelCreationPage;
	
	public SceneAndChannelCreationPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException{
		initialization();
		loginPage = new LoginPage();
		channelCreationPage=new SceneAndChannelCreationPage();
		homePage = loginPage.login("tester102@yopmail.com","pass1234"); //difference user with different account
		homePage.homePageLoading();
		homePage.goToHomeSideMenu();
		channelCreationPage=homePage.goToCreateScenePage();
	}
	
	@Test(priority=1)
	public void sceneAndChannelCreation() throws InterruptedException{
		if (!homePage.is_Scene_Created)
		{
		channelCreationPage.createScene();
		}
		else 
		{
			System.out.print("Scene is already there");
		}
		channelCreationPage.createChannel();
	}	
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
