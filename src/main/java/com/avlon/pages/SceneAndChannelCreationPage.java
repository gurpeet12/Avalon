package com.avlon.pages;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;

import com.avlon.base.TestBase;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class SceneAndChannelCreationPage extends TestBase{
	
	//Page Factory - OR:
	//scene objects
	@AndroidFindBy(accessibility = "add-scene-cover")
	MobileElement add_Scene_Cover_btn;
	
	@AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
	MobileElement allow_btn;
	
	@AndroidFindBy(accessibility = "Gallery")
	MobileElement gallery_btn;
		
	@AndroidFindBy(id = "com.android.gallery3d:id/gl_root_view")
	MobileElement picture_selection;
	
	@AndroidFindBy(id = "com.avalonlabs.avalonvoices:id/crop_image_menu_crop")
	MobileElement crop_Picture;
	
	@AndroidFindBy(accessibility = "pick-scene-icon")
	MobileElement pick_Scene_Icon;	
	
	@AndroidFindBy(accessibility = "scene-name-input")
	MobileElement scene_Name_Input;
	
	@AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"scene-category-null\"])[1]")
	MobileElement choose_Category_option;	
	
	@AndroidFindBy(accessibility = "create-scene-btn")
	MobileElement create_scene_btn;
	
	//channel objects
	@AndroidFindBy(accessibility = "community-drawer-title")
	MobileElement Scene_Title_btn;
	
	@AndroidFindBy(accessibility = "community-create-channel")
	MobileElement create_Channel_btn;
	
	//for stage channel type
	@AndroidFindBy(accessibility = "create-Stage-channel")
	MobileElement create_StageChannel_option;
	
	/*@AndroidFindBy(accessibility ="new-channel-input")
	MobileElement stageChannel_name_input;
	
	@AndroidFindBy(accessibility ="new-channel-input")
	MobileElement stageChannel_name_input;
	*/
	TouchAction swipe;
	//Initializing the Page Objects:
	public SceneAndChannelCreationPage() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	//Actions:			
	public void createScene() throws InterruptedException{
		//Thread.sleep(2000);
		
		//to select cover photo
		add_Scene_Cover_btn.click();
		
	    gallery_btn.click();
	    Thread.sleep(20000);
	    
	    
	    picture_selection.click();
	    Thread.sleep(5000);
	    picture_selection.click();  // for double click	   
	    
	    allow_btn.click();
	    crop_Picture.click();
	    
	    //to select icon
	    pick_Scene_Icon.click();	
	    gallery_btn.click();
	    picture_selection.click();
	    Thread.sleep(5000);
	    picture_selection.click();  // for double click	  	   
	    crop_Picture.click();
	    
		scene_Name_Input.sendKeys("Test Scene Name");
		
		choose_Category_option.click();
		swipe = new TouchAction(driver)
	              .press(PointOption.point(540,1824))
	              .waitAction(WaitOptions.waitOptions(Duration.ofMillis(800)))
	              .moveTo(PointOption.point(540,672))
	              .release()
	              .perform();		
		create_scene_btn.click();
	}
	
	public void createChannel() throws InterruptedException{
		Thread.sleep(5000);
		Scene_Title_btn.click();
		create_Channel_btn.click();
		create_StageChannel_option.click();
		//stageChannel_name_input.sendKeys("Test Stage Channel");
		
	}
	
}
