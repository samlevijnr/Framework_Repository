package com.wordpress.tests;

import java.io.File;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.pages.HomePage;
import com.selenium.pages.LogInPage;
import com.selenium.pages.ProfilePage;
import com.wordpress.constants.Constants;
import com.wordpress.utils.ExcelUtil;
import com.wordpress.utils.PropertyUtil;

public class WordPressLoginTest implements Constants {

	WebDriver driver;

	LogInPage logInPageInstance;
	HomePage hPage;
	ProfilePage profilePage;
	
	
	//PropertyUtil confPropUtil = new PropertyUtil("configuration.properties");
	

	@BeforeMethod
	public void setUp() {
		 ClassLoader classLoader = getClass().getClassLoader();
		 File file = new File(classLoader.getResource("configuration.properties").getFile());
		 PropertyUtil confPropUtil = new PropertyUtil(file.getAbsolutePath());
		System.out.println(file.getAbsolutePath());
		driver = new FirefoxDriver();
		driver.get(confPropUtil.getPropertyValue(url));
		String str = confPropUtil.getPropertyValue(default_timeout);
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(str), TimeUnit.SECONDS);
		logInPageInstance = new LogInPage(driver);
		hPage = new HomePage(driver);
		profilePage  = new ProfilePage(driver);
		logInPageInstance.logInLink();
	}

	@AfterMethod
	public void tearDown() {
		// driver.manage().deleteAllCookies();
		driver.close();
	}

	// ****negative test cases
	@Test
	public void testWithInvalidCharacters() {
		
		 ClassLoader classLoader = getClass().getClassLoader();
		 File file = new File(classLoader.getResource("login.xlsx").getFile());
		 ExcelUtil eUtil = new ExcelUtil(file.getAbsolutePath(),0);
		
		int count = eUtil.getNumberOfRows();
		for (int i = 1; i <= count; i++)
		{
			logInPageInstance.setUserName(eUtil.getValue(i, 0));
			logInPageInstance.setPwd(eUtil.getValue(i, 1));
			logInPageInstance.clickOnlogIn();
			String expectedOp = eUtil.getValue(i, 2);
			if(expectedOp.equalsIgnoreCase("valid"))
			{
				hPage.clickOnProfilePageIcon();
			    profilePage.clickOnSignOutButton();
			   
			    
			}
			else
			{
				String actualOp = driver.getPageSource();
				if (actualOp.contains(expectedOp)) {
					System.out.println("Pass");
				} else {
					System.out.println("Fail");
				}
			}
			driver.get("http://wordpress.com");
			logInPageInstance.logInLink();
		}
	}

}
