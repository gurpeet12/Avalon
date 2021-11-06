package com.avlon.util;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormatSymbols;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.avlon.base.TestBase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class TestUtil{
	

	
	static Properties p = new Properties();
	public static final String VALUE = "value";

	public static AppiumDriver<MobileElement> driver;

	

	public static void waitForElementToBeiInVisible(WebElement element) {

		WebDriverWait wait = null;
		try {
			wait = new WebDriverWait(driver, 5);
		} catch (NumberFormatException e) {

			e.printStackTrace();
		}
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	public static void waitForElementToBeClickable(MobileElement element) {

		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}
	public static void waitForElementsToBeVisible(MobileElement element) {

		WebDriverWait wait = new WebDriverWait(driver,100);
		wait.until(ExpectedConditions.visibilityOf(element));

	}
	public static void waitForElementToBeVisible(String locator) {

		WebDriverWait wait = new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));

	}
	
	public static void waitForElementToBeVisible(MobileElement mobileElement) {

		WebDriverWait wait = new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.visibilityOf(mobileElement));

	}

	public static void javaScriptClick(MobileElement element) throws Exception {
		try {
			if (element.isEnabled() && element.isDisplayed()) {
				System.out.println("Clicking on element with using java script click");

				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			} else {
				System.out.println("Unable to click on element");
			}
		} catch (StaleElementReferenceException e) {
			System.out.println("Element is not attached to the page document " + e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element was not found in DOM " + e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Unable to click on element " + e.getStackTrace());
		}
	}

	public static void javascriptSendKeys(WebElement element, String text) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='" + text + "';", element);
	}

	public static void javascriptSendKeysJQuery(String locator, String value) {
		JavascriptExecutor javascript = (JavascriptExecutor) driver;
		javascript.executeScript(
				"var element = document.querySelector('" + locator + "'); element.value = '" + value + "';");
	}

	public static void waitForPageToLoad() {
		String pageLoadStatus;
		do {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			pageLoadStatus = (String) js.executeScript("return document.readyState");
			System.out.print(".");
		} while (!pageLoadStatus.equals("complete"));
		System.out.println();
		System.out.println("Page Loaded.");
	}

	public static void javascriptWindowFocus(WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.focus();", element);

	}

	public static boolean isStringPresentInList(By elementBy, String expectedString) {
		List<MobileElement> navBarElementsActual = driver.findElements(elementBy);
		boolean isMenuItemsPresent = false;
		for (WebElement navMenu : navBarElementsActual) {
			String test = navMenu.getAttribute("title");

			isMenuItemsPresent = test.contains(expectedString) ? true : false;
		}
		return isMenuItemsPresent;
	}

	// Desc: Method is used to send data to the element after clear the input
	// field
	public static void sendKeys(WebElement elementBy, String sendKeysValue) {
		try {
			elementBy.clear();
			elementBy.sendKeys(sendKeysValue);
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	// Desc: Method is used to click on element
	public static void click(WebElement elementBy) {
		try {
			elementBy.click();
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	// Desc: Method is used to check element displayed or not
	public static Boolean isElementDisplayed(WebElement elementBy) {
		try {
			return elementBy.isDisplayed();
		} catch (Exception ex) {
			System.out.println(ex);
			return false;
		}
	}

	// Desc: Method is used to check element enabled or not
	public static Boolean isElementEnabled(WebElement elementBy) {
		try {
			return elementBy.isEnabled();
		} catch (Exception ex) {
			System.out.println(ex);
			return false;
		}
	}

	// Desc: Method is used to clear the input field
	public static void clearInputField(WebElement elementBy) {
		try {
			elementBy.clear();
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	// Desc: Method is used to wait for particular element
	public static void wait(WebElement elementBy, int timeout) {
		try {
			elementBy.wait(timeout);
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	// Desc: Method is used to get Text
	public static String getText(WebElement elementBy) {
		String getText = "";
		try {
			getText = elementBy.getText().trim();
			return getText;
		} catch (Exception ex) {
			System.out.println(ex);
			return getText;
		}
	}

	// Desc: Method is used to clear the input
	public static void clearInput(WebElement elementBy) {
		elementBy.clear();
	}

	// Desc:AssertionEquals
	public static void assertionEquals(WebElement elementBy, String expectedResult) {
		try {
			//assertion.assertEquals((elementBy.getText()), expectedResult);
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	// Desc: Method is used to send data to the element after clear the input
	// field
	// with Enter Key
	public static void sendKeysWithEnterKey(WebElement elementBy, String sendKeysValue) {
		try {
			elementBy.clear();
			elementBy.sendKeys(sendKeysValue + Keys.ENTER);

		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	// Desc: Method is used to send data to the element after clear the input
	// field
	// with Down and Enter Key
	public static void sendKeysWithDownEnterKey(WebElement element, String sendKeysValue) {
		try {
			element.clear();
			element.sendKeys(sendKeysValue + Keys.ARROW_DOWN);
			element.sendKeys(Keys.ENTER);

		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public static boolean verifyDropdownSelectedValue(MobileElement element, String data)
			throws NumberFormatException, IOException {
		Select sel = new Select(waitForClickable(element));
		String defSelectedVal = sel.getFirstSelectedOption().getText();
		return defSelectedVal.trim().equals(data.trim());
	}


	public static WebElement waitForClickable(MobileElement locator) {
		WebDriverWait wait = new WebDriverWait(driver, 2000);
		wait.ignoring(ElementNotVisibleException.class);
		wait.ignoring(WebDriverException.class);
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	public static WebElement waitForClickable(WebElement locator) {
		WebDriverWait wait = new WebDriverWait(driver, 2000);
		wait.ignoring(ElementNotVisibleException.class);
		wait.ignoring(WebDriverException.class);
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public static String getImageTitle(MobileElement locator) throws NumberFormatException, IOException {
		WebElement elm = waitForClickable(locator);
		return elm.getAttribute("title");
	}

	// Desc: radio button is selected
	public static boolean isRadioSelected(MobileElement elementBy) throws NumberFormatException, IOException {
		WebElement element = waitForClickable(elementBy);
		return element.isSelected();
	}

	// Desc: radio button is not selected
	public static boolean isRadioNotSelected(MobileElement elementBy) throws NumberFormatException, IOException {
		boolean check = isRadioSelected(elementBy);
		return (!check);
	}

	// Desc:Verify Input text data with attribute
	public static boolean verifyInputText(MobileElement elementBy, String data) throws NumberFormatException, IOException {
		WebElement element = waitForClickable(elementBy);
		String actual = element.getAttribute(VALUE);
		return actual.equalsIgnoreCase(data);

	}

	public static boolean verifyText(MobileElement locator, String data) throws NumberFormatException, IOException {
		WebElement element = waitForClickable(locator);
		String message = String.format("Verified text expected \"%s\" actual \"%s\" ", data, element.getText());
		return element.getText().equalsIgnoreCase(data);

	}

	// Desc:Select data by Index
	public static boolean selectByIndex(WebElement locator, int index) {
		Select sel = new Select(locator);
		sel.selectByIndex(index);

		// Check whether element is selected or not
		sel = new Select(locator);
		if (sel.getFirstSelectedOption().isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	// Desc:Select data by value
	public static boolean selectByValue(MobileElement locator, String value) {
		Select sel = new Select(locator);
		sel.selectByValue(value);

		// Check whether element is selected or not
		sel = new Select(locator);
		if (sel.getFirstSelectedOption().isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public static String readConfigFile(String property) throws IOException {
		Properties p = new Properties();
		try {
			FileReader reader = new FileReader("Configs.properties");

			p.load(reader);
		} catch (Exception e) {

		}
		System.out.println(property + " = " + p.getProperty(property));
		return p.getProperty(property);
	}

	public static void setPropertyInConfigFile(String property, String value) throws IOException {
		FileOutputStream fos = new FileOutputStream("./Configs.properties");
		p.setProperty(property, value);

		p.store(fos, "Properties file in xml format generated from Java program");
		fos.close();

	}

	public static void scrollToElement(MobileElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		
	}

	
	
	
	

	public static void moveFilesToJobDir(String oldPath, String newPath) throws IOException, InterruptedException {

		Path temp = Files.move(Paths.get(oldPath), Paths.get(newPath));
		if (temp != null) {
			System.out.println("File renamed and moved successfully");
		} else {
			System.out.println("Failed to move the file");
		}

	}

	public static String getMonthForInt(int num) {
		String month = "wrong";
		DateFormatSymbols dfs = new DateFormatSymbols();
		String[] months = dfs.getMonths();
		if (num >= 0 && num <= 11) {
			month = months[num];
		}
		return month;
	}

	public static void scrollAndClick(String visibleText) {
	    ((AndroidDriver<MobileElement>) driver).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+visibleText+"\").instance(0))").click();
	        }
	    }

	
	

