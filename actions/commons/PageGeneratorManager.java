package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.wordpresspj.admin.AdminDashboardPageObject;
import pageObjects.wordpresspj.admin.AdminLoginPageObject;

public class PageGeneratorManager {

	public static AdminLoginPageObject getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPageObject(driver);
	}

	public static AdminDashboardPageObject getAdminDashboard(WebDriver driver) {
		return new AdminDashboardPageObject(driver);
	} 
	
//	public static AdminDashboardPageObject getAdminDashboardPage(WebDriver driver) {
//		return new AdminDashboardPageObject(driver);
//	} 
	
}
