package pageObjects.wordpresspj.admin;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.wordpresspj.admin.AdminPostPageUI;

public class AdminPostPageObject extends BasePage{

	WebDriver driver;
	Actions actions;

	public AdminPostPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public AdminNewPostPageObject clickAddNewPostButton() {
		waitForElementClickable(driver, AdminPostPageUI.ADD_NEW_POST_BUTTON);
		clickToElement(driver, AdminPostPageUI.ADD_NEW_POST_BUTTON);
		return PageGeneratorManager.getAdminNewPostPage(driver);
	}


}
