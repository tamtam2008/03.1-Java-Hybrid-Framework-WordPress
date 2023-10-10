package pageUIs.wordpresspj.admin;

public class AdminNewPostPageUI {

	public static final String TITLE_TEXTBOX = "//input[@name='post_title']";
	public static final String TEXT_TAB_CONTENT_BUTTON = "css=button#content-html";
	public static final String CONTENT_TEXTBOX = "css=textarea#content";
	public static final String CATEGORY_CHECKBOX = "//ul[@id='categorychecklist']//input[@name='post_category[]']";
	public static final String TAG_TEXTBOX = "css=input#new-tag-post_tag";
	public static final String TAG_BUTTON = "css=input.tagadd";
	public static final String PUBLISH_BUTTON = "css=input#publish";
	public static final String POST_PUBLISHED_SUCCESS_MESSAGE = "//div[@id='message']/p[contains(text(),'Post published.')]";
	public static final String VIEW_POST_LINK = "//div[@id='message']//a[contains(text(),'View post')]";
}
