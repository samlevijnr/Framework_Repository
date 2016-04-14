package com.selenium.pages;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.wordpress.utils.PropertyUtil;

public class ProfilePage {

	WebDriver driver;
	PropertyUtil propUtil;
	
	public ProfilePage(WebDriver driver)
	{
		this.driver = driver;
		 ClassLoader classLoader = getClass().getClassLoader();
		 File file = new File(classLoader.getResource("object.properties").getFile());
		 propUtil = new PropertyUtil(file.getAbsolutePath());
	}
	
	
	public void setFirstName(String FirstName)
	{
		String value = propUtil.getPropertyValue("profilepage_firstname_field_id");
		WebElement fistNameTxtbx_Element = driver.findElement(By.id(value));
		fistNameTxtbx_Element.sendKeys(FirstName);
	}
	
	public void setLastName(String LastName)
	{
		String value = propUtil.getPropertyValue("profilepage_lastname_field_id");
		WebElement lastNameTxtbx_Element = driver.findElement(By.id(value));
		lastNameTxtbx_Element.sendKeys(LastName);
	}
	
	
	public void setPublicDisplayName(String PublicDisplayName )
	{
		String value = propUtil.getPropertyValue("profilepage_public_display_name_field_id");
		WebElement publicDisplayName_Element = driver.findElement(By.id(value));
		publicDisplayName_Element.sendKeys(PublicDisplayName);
	}
	
	public void setAboutMe(String AboutMe)
	{
		String value = propUtil.getPropertyValue("profilepage_aboutme_field_id");
		WebElement aboutMe_Element = driver.findElement(By.id(value));
		aboutMe_Element.sendKeys(AboutMe);
	}
	
	
	public void clickOnSignOutButton()
	{
		String value = propUtil.getPropertyValue("profilepage_signout_xpath");
		WebElement signOut = driver.findElement(By.xpath(value));
		signOut.click();
	}
	
	
}
