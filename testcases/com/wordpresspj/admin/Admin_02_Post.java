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
import pageObjects.wordpresspj.admin.AdminNewPostPageObject;
import pageObjects.wordpresspj.admin.AdminPostPageObject;
import pageUIs.wordpresspj.admin.AdminLoginPageUI;
import reportConfig.ExtentTestManager;

public class Admin_02_Post extends BaseTest {

	private WebDriver driver;
	private AdminLoginPageObject adminLoginPage;
	private AdminDashboardPageObject adminDashboardPage;
	private AdminPostPageObject adminPostPage;
	private AdminNewPostPageObject adminNewPostPage;
	private String username, password;
	private String dataTitle, dataContent,dataTag;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
 
//		driver = getBrowserDriver(browserName);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		username = "tamtamauto";
		password = "tamtamauto";
		dataTitle = "Automation testing";
		dataContent = "Lorem ipsum is placeholder text commonly used in the graphic, print, and publishing industries for previewing layouts and visual mockups. Lorem Ipsum Generator.";
		dataTag = "Tag Draft";
		
		adminLoginPage.loginBO(username, password);
		adminDashboardPage = PageGeneratorManager.getAdminDashboard(driver);
		Assert.assertTrue(adminDashboardPage.isAdminDashboardTitleDisplay());
	}
	
	@Test
	public void Create_Post(Method method) {
		ExtentTestManager.startTest(method.getName(), "Create new post");
		
		ExtentTestManager.getTest().log(Status.INFO,"Search_Step01: Open New Post in BO");
		adminDashboardPage.openLeftMenuAdmin(driver, "Posts");
		adminPostPage = PageGeneratorManager.getAdminPostPage(driver);
		
		PageGeneratorManager.getAdminNewPostPage(driver);
		adminNewPostPage = adminPostPage.clickAddNewPostButton();
		sleepInSecond(1);
		// add plugin- classic editor (not block) for wp
		ExtentTestManager.getTest().log(Status.INFO,"Search_Step02: Fill in all info new post");
		adminNewPostPage.inputToTitle(dataTitle);
		sleepInSecond(2);
		adminNewPostPage.inputToContent(dataContent);
		
		adminNewPostPage.clickToCategoryCheckbox();
	
		adminNewPostPage.inputToTagTextbox(dataTag);
		adminNewPostPage.clickToAddTagButton();
		adminNewPostPage.clickToPublishButton();
		ExtentTestManager.getTest().log(Status.INFO,"Search_Step03: Verify post published");
		Assert.assertTrue(adminNewPostPage.isPostPublishedDisplayed());
		
		Assert.assertTrue(adminNewPostPage.isViewPostLinkDisplayed());
		
	}
	
	@Test
	public void Search_Post(Method method) {
		adminNewPostPage.openLeftMenuAdmin(driver, "Posts");
		
	}
	
	//@Test
	public void Edit_Post(Method method) {
		
	}
	
	
	//@Test
	public void Delete_Post(Method method) {
		
	}
	
	

	@AfterClass(alwaysRun = true)
	public void afterClass() {

		closeBrowserDriver();
	}
}
