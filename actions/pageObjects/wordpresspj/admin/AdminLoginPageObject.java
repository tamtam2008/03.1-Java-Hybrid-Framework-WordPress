package pageObjects.wordpresspj.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.wordpresspj.admin.AdminLoginPageUI;

public class AdminLoginPageObject extends BasePage{

	WebDriver driver;

	public AdminLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public AdminDashboardPageObject loginBO(String username, String password) {
		waitForElementVisible(driver, AdminLoginPageUI.USERNAME_TEXTBOX);
		sendkeyToElement(driver, AdminLoginPageUI.USERNAME_TEXTBOX, username);
		waitForElementVisible(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, password);
		waitForElementClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON); 
		return PageGeneratorManager.getAdminDashboard(driver);
		
	}

	public String getErrorTextUsername(String attribute) {
		sleepInSecond(2);
		return getElementAttribute(driver, AdminLoginPageUI.USERNAME_TEXTBOX, attribute);
	}

	public String isErrorMessageForNotExistUsername() {
		// TODO Auto-generated method stub
		return getElementText(driver, AdminLoginPageUI.ERROR_MESSAGE_INVALID_PW_OR_USERNAME);
	}
	
}
