package pageObjects.wordpresspj.admin;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpresspj.admin.AdminDashboardPageUI;

public class AdminDashboardPageObject extends BasePage{

	WebDriver driver;
	public AdminDashboardPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public boolean isAdminDashboardTitleDisplay() {
		waitForElementVisible(driver, AdminDashboardPageUI.TITLE_DASHBOARD);
		return isElementDisplayed(driver, AdminDashboardPageUI.TITLE_DASHBOARD);
	}

}
