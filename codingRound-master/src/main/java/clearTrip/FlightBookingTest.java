package clearTrip;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class FlightBookingTest extends LaunchBrowser {

	@FindBy(id = "OneWay")
	private WebElement oneWay;

	@FindBy(id = "FromTag")
	private WebElement fromTag;

	@FindBy(id = "ToTag")
	private WebElement toTag;

	@FindBy(xpath = "//*[@id='ui-datepicker-div']/div[2]/table/tbody/tr[4]/td[4]/a")
	private WebElement calender;

	@FindBy(id = "SearchBtn")
	private WebElement searchButton;

	Utility objUtil = new Utility();
	
	ExcelOperations objExcel = new ExcelOperations(Constants.INPUTPATH);

	public void clickOneWay() {
		objUtil.clickElement(oneWay);
	}

	public void setFrom() throws IOException {
		String origin=objExcel.getCellContentRowNo("Flight", 1, "Origin");
		objUtil.setText(fromTag, origin);
		objUtil.waitFor(4000);
		fromTag.sendKeys(Keys.DOWN, Keys.RETURN);
	}

	public void setTo() throws IOException {
		String dest=objExcel.getCellContentRowNo("Flight", 1, "Destination");
		objUtil.setText(toTag, dest);
		objUtil.waitFor(4000);
		toTag.sendKeys(Keys.DOWN, Keys.RETURN);
	}

	public void selectCalender() {
		objUtil.clickElement(calender);
	}

	public void clickSearchButton() {
		objUtil.clickElement(searchButton);
	}

	public void verifyFlight() throws IOException
	{
		String expected=objExcel.getCellContentRowNo("Flight", 1, "Expected");
		Assert.assertTrue(objUtil.isElementPresent(By.className(expected)));
	}

}
