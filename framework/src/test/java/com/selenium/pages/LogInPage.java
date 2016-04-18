package com.selenium.pages;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.wordpress.utils.PropertyUtil;

public class LogInPage {

	WebDriver driver;
	
    PropertyUtil propUtil;
 
	
	public LogInPage(WebDriver driver)
	{
	 this.driver  = driver;
	 ClassLoader classLoader = getClass().getClassLoader();
	 File file = new File(classLoader.getResource("object.properties").getFile());
	 propUtil = new PropertyUtil(file.getAbsolutePath());
	}
	
	public void setUserName(String userName)
	{
		String value = propUtil.getPropertyValue("loginpage_username_field_id");
		WebElement unElement = driver.findElement(By.id(value));
		unElement.sendKeys(userName);
	}
	
	public void setPwd(String pwd)
	{
		String value = propUtil.getPropertyValue("loginpage_pwd_filed_id");
		WebElement pwdElement = driver.findElement(By.id(value));
		pwdElement.sendKeys(pwd);
	}
	
	public void clickOnlogIn()
	{
		String value = propUtil.getPropertyValue("loginpage_button_id");
		WebElement loginBtnElement = driver.findElement(By.id(value));
		loginBtnElement.click();
	}
	
	public void logInLink()
	{
		String value = propUtil.getPropertyValue("loginpage_login_link_id");
		WebElement loginLinkElement = driver.findElement(By.linkText(value));
		loginLinkElement.click();
	}
	
}
