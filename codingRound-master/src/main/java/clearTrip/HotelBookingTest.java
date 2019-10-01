package clearTrip;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HotelBookingTest extends LaunchBrowser {

	@FindBy(linkText = "Hotels")
	private WebElement hotelLink;

	@FindBy(id = "Tags")
	private WebElement localityTextBox;

	@FindBy(id = "SearchHotelsButton")
	private WebElement searchButton;

	@FindBy(id = "travellersOnhome")
	private WebElement travellerSelection;

	Utility objUtil = new Utility();
	
	ExcelOperations objExcel = new ExcelOperations(Constants.INPUTPATH);

	public void clickHotelLink() {
		objUtil.clickElement(hotelLink);
	}

	public void setLocation() throws IOException {
		String locality=objExcel.getCellContentRowNo("Hotel", 1, "Locality");
		objUtil.setText(localityTextBox, locality);
		objUtil.waitFor(4000);
		localityTextBox.sendKeys(Keys.DOWN, Keys.RETURN);
	}

	public void selectText() throws IOException {
		String locality=objExcel.getCellContentRowNo("Hotel", 1, "Options");
		objUtil.selectVisibleText(travellerSelection, locality);
	}

	public void clickSearchButton() {
		objUtil.clickElement(searchButton);
	}

}
