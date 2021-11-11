package com.avlon.pages;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;

import com.avlon.base.TestBase;
import com.avlon.util.TestUtil;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class CalendarPage extends TestBase{
	//Page Factory - OR:
	TestUtil testUtil;
	
	@AndroidFindBy(accessibility = "create-calendar-btn")
	MobileElement create_calendar_btn;
	
	@AndroidFindBy(accessibility = "event-name-input")
	MobileElement event_name_input_textarea;	
	
	@AndroidFindBy(xpath= "//android.view.ViewGroup[@content-desc=\"event-description\"]/android.view.ViewGroup/android.widget.EditText")
	MobileElement event_description_input_textarea;	
	
	@AndroidFindBy(accessibility = "event-start-time")
	MobileElement event_StartTime_btn;
	
	@AndroidFindBy(accessibility = "30 November 2021")
	MobileElement event_Select_date;
	
	@AndroidFindBy(id = "android:id/button1")
	MobileElement event_Ok;	
	
	@AndroidFindBy(accessibility = "10")
	MobileElement event_StartTime_Hours;
	
	@AndroidFindBy(accessibility = "30")
	MobileElement event_StartTime_minutes;
	
	//event end time
	@AndroidFindBy(accessibility = "event-end-time")
	MobileElement event_EndTime_btn;
	
	@AndroidFindBy(accessibility = "11")
	MobileElement event_EndTime_Hours;
	
	@AndroidFindBy(accessibility = "0")
	MobileElement event_EndTime_minutes;
	
	@AndroidFindBy(accessibility = "app-root")
	MobileElement container_For_scroll;

	@AndroidFindBy(accessibility = "confirm-event-btn")
	MobileElement confirm_Calendar_Event_btn;

	TouchAction swipe;
	//Initializing the Page Objects:
	public CalendarPage() {
		// TODO Auto-generated constructor stub	
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	//Actions:			
	public void createCalendarEvent() throws InterruptedException{
		
		create_calendar_btn.click();				
		setDataForCalendarEventAndConfirm();			
		}
	
	public void setDataForCalendarEventAndConfirm() throws InterruptedException{
		event_name_input_textarea.sendKeys("Testing Event Name");
		event_description_input_textarea.sendKeys("Testing Event Description");
		
		// event start time actions
				event_StartTime_btn.click();
				event_Select_date.click();
				event_Ok.click();
				event_StartTime_Hours.click();
				event_StartTime_minutes.click();
				event_Ok.click();
				
				//event end time actions
				event_EndTime_btn.click();
				event_Select_date.click();
				event_Ok.click();
				event_EndTime_Hours.click();
				event_EndTime_minutes.click();
				event_Ok.click();
				
				//for swipe
				swipe = new TouchAction(driver)
			              .press(PointOption.point(540,1824))
			              .waitAction(WaitOptions.waitOptions(Duration.ofMillis(800)))
			              .moveTo(PointOption.point(540,672))
			              .release()
			              .perform();
				
				confirm_Calendar_Event_btn.click();
	}
	
	
}
