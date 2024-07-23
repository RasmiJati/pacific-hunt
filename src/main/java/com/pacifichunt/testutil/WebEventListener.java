package com.pacifichunt.testutil;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.Reporter;

import com.pacifichunt.base.BaseClass;

public class WebEventListener extends BaseClass implements WebDriverListener {

	@Override
	public void afterQuit(WebDriver driver) {

		Reporter.log(Utilities.CLOSNG_BROWSER_SESSION, true);
	}

	@Override
	public void afterGetText(WebElement element, String result) {

		Reporter.log("After getting Text from the element:" + element.toString(), true);

	}

	@Override
	public void afterMaximize(Window window) {

		Reporter.log("After Maximizing Window", true);
	}

	public void beforeGet(WebDriver driver, String url) {

		Reporter.log("Before navigating to:" + url + "'", true);

	}

	public void afterGet(WebDriver driver, String url) {

		Reporter.log("After navigating to:" + url + "'", true);
	}

	public void beforeNavigateTo(String url, WebDriver driver) {
		Reporter.log("Before navigating to: '" + url + "'", true);
	}

	public void afterNavigateTo(String url, WebDriver driver) {
		Reporter.log("Navigated to:'" + url + "'", true);
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver) {

		Reporter.log("Value of the:" + element.toString() + " before any changes made", true);
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver) {
		Reporter.log("Element value changed to: " + element.toString(), true);
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		Reporter.log("Trying to click on: " + element.toString(), true);
	}

	public void afterClickOn(WebElement element, WebDriver driver) {

		Reporter.log("Clicked on: " + element.toString(), true);
	}

	public void beforeNavigateBack(WebDriver driver) {
		Reporter.log("Navigating back to previous page", true);
	}

	public void afterNavigateBack(WebDriver driver) {
		Reporter.log("Navigated back to previous page", true);
	}

	public void beforeNavigateForward(WebDriver driver) {
		Reporter.log("Navigating forward to next page", true);
	}

	@Override
	public void afterClick(WebElement element) {

		Reporter.log("After Clicking:" + element.toString(), true);
	}

	@Override
	public void beforeClick(WebElement element) {

		Reporter.log("Before Clicking:" + element.toString(), true);
	}

	public void afterNavigateForward(WebDriver driver) {
		Reporter.log("Navigated forward to next page", true);
	}

	/*
	 * public void onException(Throwable error, WebDriver driver) {
	 * Reporter.log("Exception occured: " + error);
	 *
	 * try { Utilities.takeScreenshotAtEndOfTest(); } catch (IOException e) {
	 * e.printStackTrace(); }
	 *
	 * }
	 */

	@Override
	public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {

		Reporter.log("Exception occured: " + target);

		try {
			Utilities.takeScreenshotAtEndOfTest();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		Reporter.log("Trying to find Element By : " + by.toString(), true);
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {

		Reporter.log("Found Element By : " + by.toString(), true);
	}

	@Override
	public void beforeFindElement(WebDriver driver, By locator) {

		Reporter.log("Before Finding Element" + locator.toString(), true);
	}

	@Override
	public void beforeFindElements(WebDriver driver, By locator) {

		Reporter.log("Before Finding List Of Elements" + locator.toString(), true);
	}

	@Override
	public void beforeSubmit(WebElement element) {

		Reporter.log("Before Submitting form fields:" + element.toString(), true);
	}

	@Override
	public void beforeSendKeys(WebElement element, CharSequence... keysToSend) {

		Reporter.log("Before sending any values to input field" + element.toString(), true);
	}

	@Override
	public void beforeFindElement(WebElement element, By locator) {

		Reporter.log("Before Finding any Element" + element.toString(), true);
	}

	@Override
	public void beforeFindElements(WebElement element, By locator) {

		Reporter.log("Before Finding any List of WebElements:" + element.toString(), true);
	}

	@Override
	public void beforeSendKeys(Alert alert, String text) {

		Reporter.log("Before Sending any alert Keys:" + alert.toString() + "Text is:" + text, true);
	}

	@Override
	public void beforeDeleteAllCookies(Options options) {

		Reporter.log("Before Deleting All Cookies", true);
	}

	@Override
	public void beforeAnyTimeoutsCall(Timeouts timeouts, Method method, Object[] args) {

		Reporter.log("Before Any Timeout Call:" + timeouts.toString(), true);
	}

}
