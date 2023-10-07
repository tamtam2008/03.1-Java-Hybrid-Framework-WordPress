package com.wordpresspj.common;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.Status;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.wordpresspj.admin.AdminDashboardPageObject;
import pageObjects.wordpresspj.admin.AdminLoginPageObject;
import reportConfig.ExtentTestManager;

public class Common_01_Login_Cookie extends BaseTest {

	private WebDriver driver;
	public static String username, password;;
	private AdminLoginPageObject adminLoginPage;
	private AdminDashboardPageObject adminDashboardPage;
	public static Set<Cookie> loggedCookies;

	@Parameters("browser")
	@BeforeTest(description = "Create new common User for all Classes Test")
	public void Register(String browserName) {
	
		driver = getBrowserDriver(browserName);

		adminLoginPage =PageGeneratorManager.getAdminLoginPage(driver);
		PageGeneratorManager.getAdminDashboard(driver);

		username = "tamtamauto";
		password = "tamtamauto";
	
		log.info("login");
		adminLoginPage.loginBO(username, password);
		
		adminDashboardPage = PageGeneratorManager.getAdminDashboard(driver);
		Assert.assertTrue(adminDashboardPage.isAdminDashboardTitleDisplay());
		log.info("logout");
		adminDashboardPage.openAdminLoginPage(driver, "Log Out");
//		adminLoginPage.inputToUsername(username);
//		adminLoginPage.inputToPassword(password);
//		
//		adminDashboardPage =adminLoginPage.clickToLoginButton();
//		sleepInSecond(3);
//		Assert.assertTrue(adminDashboardPage.isAdminDashboardTitleDisplay());
//		
//		sleepInSecond(3);
//		loggedCookies = adminDashboardPage.getAllCookies(driver);
//		for (Cookie cookie : loggedCookies) {
//			System.out.println("Cookie at common Class: " + cookie);
//		}
		
		driver.quit();
	}


}
