package pageUIs.wordpresspj.common;

public class BasePageUI {

	public static final String AVARTA_MENU_ADMIN = "//span[@class='display-name']/following-sibling::img";
	public static final String DYNAMIC_SUB_AVARTA_MENU_ADMIN = "//ul[@class='ab-submenu']//a[contains(text(),'%s')]";
	public static final String DYNAMIC_LEFT_MENU_ADMIN = "//ul[@id='adminmenu']//div[@class='wp-menu-name' and contains(text(),'%s')]";
	public static final String DYNAMIC_SUB_LEFT_MENU_ADMIN = "//ul[@id='adminmenu']//div[@class='wp-menu-name' and contains(text(),'%s')]/parent::a/following-sibling::ul//a[contains(text(),'%s')]";
	
	
	
}
