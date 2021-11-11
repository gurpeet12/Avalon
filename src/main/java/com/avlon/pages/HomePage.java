package com.avlon.pages;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.avlon.base.TestBase;
import com.avlon.util.TestUtil;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage extends TestBase{
	
	
	
	//Page Factory - OR:
		
	@AndroidFindBy(accessibility = "coin-gotit-btn")
	MobileElement gotit;
	
	@AndroidFindBy(className= "android.widget.ImageView")
	MobileElement swipe_image;
	
	//appears only once
	@AndroidFindBy(accessibility = "setup-later-btn")
	MobileElement will_do_later;
	
	@AndroidFindBy(accessibility = "community-drawer-btn")
	MobileElement drawer_btn;
	
	//Forum option
	@AndroidFindBy(accessibility = "4-channel-165")
	MobileElement starter_Forum;
	
	//Calendar Option
	@AndroidFindBy(accessibility = "4-channel-164")
	MobileElement starter_calendar;
	
	//Channel creation start scene
	@AndroidFindBy(accessibility = "start-scene-btn")
	MobileElement start_Scene;
	
	@AndroidFindBy(accessibility = "198-channel-547")
	MobileElement create_starter_stage;
	
	public boolean is_Scene_Created=true;
	public boolean is_visible_will_do_later=false;

	//Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	//Actions:
	
	//new
	public void homePageLoading(boolean isVisibleWillDoLater)throws InterruptedException{
		Thread.sleep(20000);
		swipe_image.click();
		gotit.click();		
		if(isVisibleWillDoLater)
		{
			
			will_do_later.click();
		}
	}
	
	//go to home side menu
	public void goToHomeSideMenu() throws InterruptedException{
		
		drawer_btn.click();
	}
	//go to Forum 
	public ForumPage goToForumPage() throws InterruptedException{
		
		starter_Forum.click();
		return new ForumPage();
	}
	
	//Go to Calendar
	public CalendarPage goToCalendarPage() throws InterruptedException{
		starter_calendar.click();
		return new CalendarPage();
	}
	
	//Go to Create Scene
		public SceneAndChannelCreationPage goToCreateScenePage() throws InterruptedException{
			try {		
			
			if(start_Scene!=null)
			 {
			  is_Scene_Created=false;
			  start_Scene.click();
			 }
			return new SceneAndChannelCreationPage();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.print(e.getMessage());
				is_Scene_Created=true;
				return new SceneAndChannelCreationPage();
			} 
		   }
	
		//Go to starter stage page
		public StarterStagePage goToStarterStagePage() throws InterruptedException{
					
					create_starter_stage.click();
					return new StarterStagePage();
				   }
			
}

