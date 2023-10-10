package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.wordpresspj.admin.AdminCategoriesPageObject;
import pageObjects.wordpresspj.admin.AdminDashboardPageObject;
import pageObjects.wordpresspj.admin.AdminLoginPageObject;
import pageObjects.wordpresspj.admin.AdminNewPostPageObject;
import pageObjects.wordpresspj.admin.AdminPostPageObject;

public class PageGeneratorManager {

	public static AdminLoginPageObject getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPageObject(driver);
	}

	public static AdminDashboardPageObject getAdminDashboard(WebDriver driver) {
		return new AdminDashboardPageObject(driver);
	} 
	
	public static AdminPostPageObject getAdminPostPage(WebDriver driver) {
		return new AdminPostPageObject(driver);
	} 
	
	public static AdminNewPostPageObject getAdminNewPostPage(WebDriver driver) {
		return new AdminNewPostPageObject(driver);
	} 
	
	public static AdminCategoriesPageObject getAdminCategoriesPage(WebDriver driver) {
		return new AdminCategoriesPageObject(driver);
	} 
	
}
