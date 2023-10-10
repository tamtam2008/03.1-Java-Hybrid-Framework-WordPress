package pageObjects.wordpresspj.admin;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.wordpresspj.admin.AdminNewPostPageUI;

public class AdminNewPostPageObject extends BasePage{

	WebDriver driver;
//	Actions actions;

	public AdminNewPostPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public void inputToTitle(String dataTitle) {
		waitForElementVisible(driver, AdminNewPostPageUI.TITLE_TEXTBOX);
//		sleepInSecond(1);
//		clickToElement(driver, AdminNewPostPageUI.TITLE_TEXTBOX);
		sleepInSecond(1);
		sendkeyToElement(driver, AdminNewPostPageUI.TITLE_TEXTBOX, dataTitle);
	}

	public void inputToContent(String dataContent) {
		waitForElementClickable(driver, AdminNewPostPageUI.TEXT_TAB_CONTENT_BUTTON);
		clickToElement(driver, AdminNewPostPageUI.TEXT_TAB_CONTENT_BUTTON);
		sleepInSecond(1);
		
		waitForElementVisible(driver, AdminNewPostPageUI.CONTENT_TEXTBOX);
		sendkeyToElement(driver, AdminNewPostPageUI.CONTENT_TEXTBOX, dataContent);
		
	}

	public void clickToCategoryCheckbox() {
		waitForElementClickable(driver, AdminNewPostPageUI.CATEGORY_CHECKBOX);
		clickToElement(driver, AdminNewPostPageUI.CATEGORY_CHECKBOX);
		
	}


	public void inputToTagTextbox(String dataTag) {
		waitForElementVisible(driver, AdminNewPostPageUI.TAG_TEXTBOX);
		sendkeyToElement(driver, AdminNewPostPageUI.TAG_TEXTBOX, dataTag);
		
	}
	public void clickToAddTagButton() {
		waitForElementClickable(driver, AdminNewPostPageUI.TAG_BUTTON);
		clickToElement(driver, AdminNewPostPageUI.TAG_BUTTON);
		
	}

	public void clickToPublishButton() {
		waitForElementClickable(driver, AdminNewPostPageUI.PUBLISH_BUTTON);
		clickToElement(driver, AdminNewPostPageUI.PUBLISH_BUTTON);
		
	}

	public boolean isPostPublishedDisplayed() {
		waitForElementVisible(driver, AdminNewPostPageUI.POST_PUBLISHED_SUCCESS_MESSAGE);
		return isElementDisplayed(driver, AdminNewPostPageUI.POST_PUBLISHED_SUCCESS_MESSAGE);
	}
	
	public boolean isViewPostLinkDisplayed() {
		waitForElementClickable(driver, AdminNewPostPageUI.VIEW_POST_LINK);
		return isElementDisplayed(driver, AdminNewPostPageUI.VIEW_POST_LINK);
	}
	
}
