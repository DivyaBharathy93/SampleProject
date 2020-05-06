package com.sample.ui;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UIInteractions {
	
	static WebDriverWait wait;
	
	public static void click(WebElement element) {
		try {
			wait = new WebDriverWait(WebDriverSession.getDriver(), 8);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
		} catch (Exception e) {
			System.out.println("Element has not been clickable");
		}

	}
	
	public static void sendKeys(WebElement element, String text) {
		try {
			wait = new WebDriverWait(WebDriverSession.getDriver(), 8);
			wait.until(ExpectedConditions.visibilityOf(element));
		element.clear();
		element.sendKeys(text);
		}catch (Exception e) {
			System.out.println("Element has not been visible");
		}
	}
	
	
	
	
	}

