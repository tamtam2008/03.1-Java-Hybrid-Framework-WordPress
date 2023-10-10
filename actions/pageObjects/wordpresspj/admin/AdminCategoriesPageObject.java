package pageObjects.wordpresspj.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpresspj.admin.AdminCategoriesPageUI;

public class AdminCategoriesPageObject extends BasePage{

	WebDriver driver;

	public AdminCategoriesPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void enterToNewCategoryName(String nameCategory) {
		waitForElementVisible(driver, AdminCategoriesPageUI.NAME_NEW_CATEGORIE_STRING);
		sendkeyToElement(driver, AdminCategoriesPageUI.NAME_NEW_CATEGORIE_STRING, nameCategory);
		
	}
	
	
}
