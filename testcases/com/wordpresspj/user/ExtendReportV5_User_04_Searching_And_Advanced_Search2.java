package com.wordpresspj.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;

public class ExtendReportV5_User_04_Searching_And_Advanced_Search2 extends BaseTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {

		driver = getBrowserDriver(browserName);

	}

	@Test
	public void Search_01_Empty_Data() {
		
	}

	
	@AfterClass
	public void afterClass() {

		driver.quit();
	}

	WebDriver driver;
}
