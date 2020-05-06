package com.sample.webtest.Test;

import org.testng.annotations.Test;

import com.sample.steps.LoginSteps;

import junit.framework.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterMethod;

public class LoginTest extends BaseTest {
	LoginSteps login;	
	String expected,actual;
	
	@DataProvider(name="Credentials")
	public Object[][] getCredentials(){
		Object[][] data=new Object[3][2];
		
		return data;
	}
	@Test
	public void HeadlessBrowser() {
		System.out.println("Headless");
	}
	
  @Test(enabled =false)
  public void LoginWithCorrectCredentials() {
	  login.clickSigin();
	  login.EnterEmailAddress();
	  login.EnterPassword();
	  expected="Hello, divya";
	  actual=login.verifyLoginHeader();
	  Assert.assertEquals(expected, actual);
  }
  
  @Test(enabled =false)
  public void LoginWithIncorrectEmailAddress() {
	  login.clickSigin();
	  login.EnterEmailAddress();
	  login.EnterPassword();
	  expected="We cannot find an account with that email address";
	  actual=login.verifyLoginHeader();
	  Assert.assertEquals(expected, actual);
	  
  }
  
  @Test(enabled =false)
  public void LoginWithIncorrectPassword() {
	  login.clickSigin();
	  login.EnterEmailAddress();
	  login.EnterPassword();
	  expected="Your password is incorrect\n";
	  actual=login.verifyLoginHeader();
	  Assert.assertEquals(expected, actual);
  }
  
  
  @BeforeMethod
  public void beforeMethod() {
	  getDriverInstance();	
	  navigateBrowser();
	  login=new LoginSteps();
  }

  @AfterMethod
  public void afterMethod() {
	  closeBrowser();
  }

}
