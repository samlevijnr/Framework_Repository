package com.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePage {

	
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
	this.driver = driver;
	}
	
	public void clickOnProfilePageIcon()
	{
		WebElement ProfileLogIn_element = driver.findElement(By.xpath("html/body/div[2]/div/header/a[4]/span/img"));
		ProfileLogIn_element.click();
	}
	
	
	

}
