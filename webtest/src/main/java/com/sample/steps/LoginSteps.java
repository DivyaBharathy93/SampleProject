package com.sample.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.sample.pages.LoginPage;
import com.sample.ui.UIInteractions;

public class LoginSteps extends LoginPage{
	
	WebDriver driver;
	
	public LoginSteps() {
		this.driver=getDriver();
		PageFactory.initElements(driver, this);
	}

	public void clickSigin() {
		Actions a=new Actions(driver);
		a.moveToElement(account_listlink).click().perform();
	}
	
	public void EnterEmailAddress() {
		UIInteractions.sendKeys(emailtext,"divibs93@gmail.com");
//		UIInteractions.sendKeys(emailtext,"test");
		UIInteractions.click(continuebtn);	
	}
	
	public void EnterPassword() {
		UIInteractions.sendKeys(passwordtext, "Divya@1993");
		UIInteractions.click(loginbtn);
	}
	
	public String verifyLoginHeader() {
		try {
		return Username.getText();
		}
		catch(Exception e) {
			System.out.println(usernameEdit.getText());
			return usernameEdit.getText();
		}
		
		
	}
}
