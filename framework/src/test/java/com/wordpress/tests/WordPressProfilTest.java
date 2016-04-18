package com.wordpress.tests;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.pages.HomePage;
import com.selenium.pages.LogInPage;
import com.selenium.pages.ProfilePage;
import com.wordpress.constants.Constants;
import com.wordpress.utils.PropertyUtil;

public class WordPressProfilTest implements Constants {

	WebDriver driver;
	HomePage HomePage_Instance;
	LogInPage LogInPage_Instance;
	ProfilePage ProfilePage_Instance;

	
	@BeforeMethod
	public void setUp()
	{
		 ClassLoader classLoader = getClass().getClassLoader();
		 File file = new File(classLoader.getResource("configuration.properties").getFile());
		 PropertyUtil confPropUtil = new PropertyUtil(file.getAbsolutePath());
		System.out.println(file.getAbsolutePath());
		 driver = new FirefoxDriver();
		 driver.get(confPropUtil.getPropertyValue(url));
		 String str = confPropUtil.getPropertyValue(default_timeout);
		 driver.manage().timeouts().implicitlyWait(Integer.parseInt(str), TimeUnit.SECONDS);
	     
	     LogInPage_Instance =  new LogInPage(driver);
	     HomePage_Instance =  new HomePage(driver);
	     ProfilePage_Instance = new ProfilePage(driver);
	     
	     
	     
	}
	
	@Test
	public void ProfileLogIn()
	{
		LogInPage_Instance.logInLink();
		
		LogInPage_Instance.setUserName("sam.levi.jnr@gmail.com");
		LogInPage_Instance.setPwd("sam.levi1");
		LogInPage_Instance.clickOnlogIn();
		
		HomePage_Instance.clickOnProfilePageIcon();
		
		ProfilePage_Instance.setFirstName("Samuel");
		ProfilePage_Instance.setLastName("Levi Smith");
		ProfilePage_Instance.setPublicDisplayName("The King of Rock");
		ProfilePage_Instance.setAboutMe("Life!!!!!");
	}
	
	
	@Test
	public void setProfileLogIN()
	{
        LogInPage_Instance.logInLink();
		
		LogInPage_Instance.setUserName("sam.levi.jnr@gmail.com");
		LogInPage_Instance.setPwd("sam.levi1");
		LogInPage_Instance.clickOnlogIn();
		
		HomePage_Instance.clickOnProfilePageIcon();
		
		ProfilePage_Instance.setFirstName("123");
		ProfilePage_Instance.setLastName("456");
		ProfilePage_Instance.setPublicDisplayName("101010");
		ProfilePage_Instance.setAboutMe("123456789");
	}
	
	@AfterMethod
	public void tearDown()
	{
		//driver.manage().deleteAllCookies();
		driver.close();
	}
}
