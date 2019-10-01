package clearTrip;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.sun.javafx.PlatformUtil;

public class LaunchBrowser {
	public static WebDriver driver;

	public WebDriver setDriverPath() {
		if (PlatformUtil.isMac()) {
			System.setProperty("webdriver.chrome.driver", "chromedriver");
		}
		if (PlatformUtil.isWindows()) {
			File f = new File("\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver",
					Constants.DRIVERPATH);
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("-incognito");
			options.addArguments("start-maximized");
			options.addArguments("--disable-notifications");
			//Pass ChromeOptions instance to ChromeDriver Constructor
			driver =new ChromeDriver(options);
			//driver = new ChromeDriver();
			//driver.get("https://www.cleartrip.com/");
		}
		if (PlatformUtil.isLinux()) {
			System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
		}
		return driver;
	}

}
