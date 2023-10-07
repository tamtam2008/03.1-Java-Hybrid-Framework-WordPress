package com.wordpresspj.user;

import org.testng.annotations.Test;

import commons.BasePage;

import org.testng.annotations.BeforeClass;

import java.security.Timestamp;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Draft_User_01_Register_Apply_BasePage extends BasePage {
	WebDriver driver;
	String emailAddress;
	BasePage basePage;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {

		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		openPageUrl(driver, "https://demo.nopcommerce.com/");
		emailAddress = "tam.tam" + randomFakeNumber() + "@mailinator.com";
	}

	@Test
	public void TC_01_Register_Empty_Data() {

		waitForElementClickable(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(getElementText(driver, "//span[@id='FirstName-error']"), "First name is required.");
		Assert.assertEquals(getElementText(driver, "//span[@id='LastName-error']"), "Last name is required.");
		Assert.assertEquals(getElementText(driver, "//span[@id='Email-error']"), "Email is required.");
		Assert.assertEquals(getElementText(driver, "//span[@id='Password-error']"), "Password is required.");
		Assert.assertEquals(getElementText(driver, "//span[@id='ConfirmPassword-error']"), "Password is required.");

	}

	@Test
	public void TC_02_Register_Invalid_Email() {

		clickToElement(driver, "//a[@class='ico-register']");

		clickToElement(driver, "//input[@id='gender-female']");
		sendkeyToElement(driver, "//input[@id='FirstName']", "Tam");
		sendkeyToElement(driver, "//input[@id='LastName']", "Nguyen");
		sendkeyToElement(driver, "//input[@id='Email']", "999@789!@#$");
		sendkeyToElement(driver, "//input[@id='Password']", "12345V@t");
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "12345V@t");
		
		clickToElement(driver, "//button[@id='register-button']");
		
		Assert.assertEquals(getElementText(driver, "//span[@id='Email-error']"), "Wrong email");
	}

	@Test
	public void TC_03_Register_Success() {
		
		clickToElement(driver, "//a[@class='ico-register']");

		clickToElement(driver, "//input[@id='gender-female']");
		sendkeyToElement(driver, "//input[@id='FirstName']", "Tam");
		sendkeyToElement(driver, "//input[@id='LastName']", "Nguyen");
		sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
		sendkeyToElement(driver, "//input[@id='Password']", "12345V@t");
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "12345V@t");
		
		clickToElement(driver, "//button[@id='register-button']");
		
		waitForElementVisible(driver, "//div[@class='result']");
		Assert.assertEquals(getElementText(driver, "//div[@class='result']"), "Your registration completed");
		
	}

	@Test
	public void TC_04_Existing_Email() {
		sleepInSecond(2);
		clickToElement(driver, "//a[@class='ico-register']");

		clickToElement(driver, "//input[@id='gender-female']");
		sendkeyToElement(driver, "//input[@id='FirstName']", "Tam");
		sendkeyToElement(driver, "//input[@id='LastName']", "Nguyen");
		sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
		sendkeyToElement(driver, "//input[@id='Password']", "12345V@t");
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "12345V@t");
		
		clickToElement(driver, "//button[@id='register-button']");
		
		waitForElementVisible(driver, "//div[@class='message-error validation-summary-errors']");
		Assert.assertEquals(getElementText(driver, "//div[@class='message-error validation-summary-errors']"), "The specified email already exists");

	}

	@Test
	public void TC_05_Password_Less_Than_6Chars() {
		
		sleepInSecond(2);
		clickToElement(driver, "//a[@class='ico-register']");

		clickToElement(driver, "//input[@id='gender-female']");
		sendkeyToElement(driver, "//input[@id='FirstName']", "Tam");
		sendkeyToElement(driver, "//input[@id='LastName']", "Nguyen");
		sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
		sendkeyToElement(driver, "//input[@id='Password']", "123");
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123");
		
		clickToElement(driver, "//button[@id='register-button']");
		
		Assert.assertEquals(getElementText(driver, "//span[@id='Password-error']"), "Password must meet the following rules:\n"
				+ "must have at least 6 characters");
	}

	@Test
	public void TC_06_Invalid_Confirm_Password() {
		sleepInSecond(2);
		clickToElement(driver, "//a[@class='ico-register']");

		clickToElement(driver, "//input[@id='gender-female']");
		sendkeyToElement(driver, "//input[@id='FirstName']", "Tam");
		sendkeyToElement(driver, "//input[@id='LastName']", "Nguyen");
		sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
		sendkeyToElement(driver, "//input[@id='Password']", "12345V@t");
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "78999V@t");
		
		clickToElement(driver, "//button[@id='register-button']");
		
		Assert.assertEquals(getElementText(driver, "//span[@class='field-validation-error']"), "The password and confirmation password do not match.");
	}

	@AfterClass
	public void afterClass() {

		driver.quit();
	}

	public int randomFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

}
