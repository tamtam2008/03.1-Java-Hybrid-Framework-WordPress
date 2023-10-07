package pageUIs.workpresspj.user;

import org.openqa.selenium.WebDriver;

public class UserLoginPageUI {

	private WebDriver driver;

	public UserLoginPageUI(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public static final String LOGIN_BUTTON = "//div[@class='buttons']/button[@type='submit']";
	public static final String USERNAME_TEXTBOX = "//input[@id='Email']";
	public static final String PASSWORD_TEXTBOX = "//input[@id='Password']";
	public static final String USERNAME_ERROR_MESSAGE = "//span[@id='Email-error']";
	public static final String UNSUCESS_LOGIN_ERROR_MESSAGE = "//div[@class='message-error validation-summary-errors']";
	
}
