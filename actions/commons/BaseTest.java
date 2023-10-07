package commons;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	private WebDriver driver;
	protected final Log log;

	protected BaseTest() {
		log = LogFactory.getLog(getClass());
	}

	protected WebDriver getBrowserDriver(String browserName) {

		if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

			// headless firefox
		} else if (browserName.equals("h_firefox")) {
			if (GlobalConstants.OS_NAME.contains("Mac OS")) {
				System.setProperty("webdriver.gecko.driver",
						GlobalConstants.PROJECT_PATH + "/browserDrivers/geckodriver");
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless");
				options.addArguments("window-size=1920×1080");
				driver = new FirefoxDriver(options);
			} else {
				System.setProperty("webdriver.gecko.driver",
						GlobalConstants.PROJECT_PATH + "\\browserDrivers\\geckodriver.exe");
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless");
				options.addArguments("window-size=1920×1080");
				driver = new FirefoxDriver(options);
			}

			// headless chrome
			// recheck version chrome driver before run
		} else if (browserName.equals("h-chrome")) {
			if (GlobalConstants.OS_NAME.contains("Mac OS")) {
//				System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
				WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless");
				options.addArguments("window-size=1920×1080");
				driver = new ChromeDriver(options);
			} else {
				System.setProperty("webdriver.chrome.driver",
						GlobalConstants.PROJECT_PATH + "\\browserDrivers\\\\chromedriver.exe");
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless");
				options.addArguments("window-size=1920×1080");
				driver = new ChromeDriver(options);
			}

		} else if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else {
			throw new RuntimeException("Browser name invalid");
		}
		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driver.get(GlobalConstants.ADMIN_PAGE_URL);
//		driver.get(getEnviromentUrl(enviromentName));
		return driver;
	}

//	protected WebDriver getBrowserDriver(String browserName, String appUrl) {
//
//		if (browserName.equals("firefox")) {
//			WebDriverManager.firefoxdriver().setup();
//			driver = new FirefoxDriver();
//
//		} else if (browserName.equals("chrome")) {
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
//
//		} else {
//			throw new RuntimeException("Browser name invalid");
//		}
//		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
//		driver.get(GlobalConstants.PORTAL_PAGE_URL);
//		return driver;
//	}

	public WebDriver getDriverInstance() {
		return this.driver;
	} 
	
//	private String getEnviromentUrl(String enviromentName) {
//		String url = null;
//		switch (enviromentName) {
//		case "DEV":
//			url = GlobalConstants.PORTAL_PAGE_URL;
//			break;
//		case "STG":
//			url = GlobalConstants.PORTAL_PAGE_URL;
//			break;
//		}
//		return url;
//	}

	protected boolean verifyTrue(boolean condition) {
		boolean status = true;
		try {
			Assert.assertTrue(condition);
			log.info("---------------------- Passed -----------------------");
		} catch (Throwable e) {
			status = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
			log.info("---------------------- Failed -----------------------");
		}
		return status;
	}

	protected boolean verifyFalse(boolean condition) {
		boolean status = true;
		try {
			Assert.assertFalse(condition);
			log.info("---------------------- Passed -----------------------");
		} catch (Throwable e) {
			status = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
			log.info("---------------------- Failed -----------------------");
		}
		return status;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		boolean status = true;
		try {
			Assert.assertEquals(actual, expected);
			log.info("---------------------- Passed -----------------------");
		} catch (Throwable e) {
			status = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
			log.info("---------------------- Failed -----------------------");
		}
		return status;
	}
	
	protected void closeBrowserDriver() {
		String cmd = null;
		try {
			String osName = System.getProperty("os.name").toLowerCase();
			log.info("OS name = " + osName);

			String driverInstanceName = driver.toString().toLowerCase();
			log.info("Driver instance name = " + driverInstanceName);

			String browserDriverName = null;

			if (driverInstanceName.contains("chrome")) {
				browserDriverName = "chromedriver";
			} else if (driverInstanceName.contains("internetexplorer")) {
				browserDriverName = "IEDriverServer";
			} else if (driverInstanceName.contains("firefox")) {
				browserDriverName = "geckodriver";
			} else if (driverInstanceName.contains("edge")) {
				browserDriverName = "msedgedriver";
			} else if (driverInstanceName.contains("opera")) {
				browserDriverName = "operadriver";
			} else {
				browserDriverName = "safaridriver";
			}

			if (osName.contains("window")) {
				cmd = "taskkill /F /FI \"IMAGENAME eq " + browserDriverName + "*\"";
			} else {
				cmd = "pkill " + browserDriverName;
			}

			if (driver != null) {
				driver.manage().deleteAllCookies();
				driver.quit();
			}
		} catch (Exception e) {
			log.info(e.getMessage());
		} finally {
			try {
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public int randomFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}
	
	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
