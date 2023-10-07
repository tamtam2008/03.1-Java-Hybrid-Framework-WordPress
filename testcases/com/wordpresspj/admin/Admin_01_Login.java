package com.wordpresspj.admin;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;


import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.wordpresspj.admin.AdminDashboardPageObject;
import pageObjects.wordpresspj.admin.AdminLoginPageObject;
import pageUIs.wordpresspj.admin.AdminLoginPageUI;
import reportConfig.ExtentTestManager;

public class Admin_01_Login extends BaseTest {

	private WebDriver driver;
	private AdminLoginPageObject adminLoginPage;
	private AdminDashboardPageObject adminDashboardPage;
	private String username, password, invalidUsername, invalidPw;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {

		driver = getBrowserDriver(browserName);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		username = "tamtamauto";
		password = "tamtamauto";
		invalidPw = "98989abc@#";
		invalidUsername = "tamtamauto"+ randomFakeNumber();
	}
	
	@Test
	public void Login_Success(Method method) {
		ExtentTestManager.startTest(method.getName(), "Login success with admin account");
		
		ExtentTestManager.getTest().log(Status.INFO,"Search_Step01: Login admin BO successfully");
		adminLoginPage.loginBO(username, password);
		sleepInSecond(3);
		ExtentTestManager.getTest().log(Status.INFO,"Search_Step02: Verify title dashboard is displayed");
		adminDashboardPage = PageGeneratorManager.getAdminDashboard(driver);
		Assert.assertTrue(adminDashboardPage.isAdminDashboardTitleDisplay());
		ExtentTestManager.getTest().log(Status.INFO,"Search_Step03: Logout success");
		adminDashboardPage.openAdminLoginPage(driver, "Log Out");
	}
	
	@Test
	public void Login_Empty_Username(Method method) {
		ExtentTestManager.startTest(method.getName(), "Login empty username");
		
		ExtentTestManager.getTest().log(Status.INFO,"Search_Step01: Login empty username");
		adminLoginPage.loginBO("", "");
		sleepInSecond(3);
		
		ExtentTestManager.getTest().log(Status.INFO,"Search_Step02: Verify error message");
		Assert.assertEquals(adminLoginPage.getErrorTextUsername("validationMessage"), "Please fill out this field.");
	}
	
	@Test
	public void Login_Not_Exist_Username(Method method) {
		ExtentTestManager.startTest(method.getName(), "Login not exist username");
		
		ExtentTestManager.getTest().log(Status.INFO,"Search_Step01: Login not exist username");
		adminLoginPage.loginBO(invalidUsername, password);
		sleepInSecond(2);
		
		ExtentTestManager.getTest().log(Status.INFO,"Search_Step02: Verify error message");
		Assert.assertEquals(adminLoginPage.isErrorMessageForNotExistUsername(), "Error: The username "+invalidUsername+" is not registered on this site. If you are unsure of your username, try your email address instead.");
	
	}
	
	@Test
	public void Login_Invalid_Password(Method method) {
		ExtentTestManager.startTest(method.getName(), "Login invalid password");
		
		ExtentTestManager.getTest().log(Status.INFO,"Search_Step01: Login invalid password");
		adminLoginPage.loginBO(username, invalidPw);
		sleepInSecond(2);
		
		ExtentTestManager.getTest().log(Status.INFO,"Search_Step02: Verify error message");
		Assert.assertEquals(adminLoginPage.isErrorMessageForNotExistUsername(), "Error: The password you entered for the username "+username+" is incorrect. Lost your password?");
	
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {

		closeBrowserDriver();
	}
}
