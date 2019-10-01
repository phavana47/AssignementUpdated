package clearTrip;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility extends LaunchBrowser {

	WebDriverWait wait = new WebDriverWait(driver, 20);

	public void clickElement(WebElement element) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			element.click();
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

	public void setText(WebElement element, String value) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			element.clear();
			element.sendKeys(value);
		} catch (Exception e) {
			
			System.out.println(e.getStackTrace());
		}
	}

	public String getText(WebElement element) {
		String text = null;
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			text=element.getText();
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		return text;
	}

	public void selectVisibleText(WebElement element, String value) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			Select select = new Select(element);
			select.selectByVisibleText(value);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

	public void waitFor(int durationInMilliSeconds) {
		try {
			Thread.sleep(durationInMilliSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace(); // To change body of catch statement use File |
									// Settings | File Templates.
		}
	}
	
	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
}
