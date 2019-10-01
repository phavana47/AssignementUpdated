package clearTrip;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class SignInTest extends LaunchBrowser {

	@FindBy(linkText = "Your trips")
	private WebElement yourTrips;

	@FindBy(id = "SignIn")
	private WebElement signIn;

	@FindBy(id = "signInButton")
	private WebElement signInButton;

	@FindBy(id = "errors1")
	private WebElement error;

	ExcelOperations objExcel = new ExcelOperations(Constants.INPUTPATH);

	Utility objUtil = new Utility();

	public void clickYourTrips() {
		objUtil.clickElement(yourTrips);
	}

	public void clickSignIn() {
		objUtil.clickElement(signIn);
	}

	public void clickSignInButton() {
		objUtil.clickElement(signInButton);
	}

	public String getErrorMsg() {
		String errorMsg = objUtil.getText(error);
		return errorMsg;
	}

	public void verifyErrorMsg() throws IOException {
		String expected = objExcel.getCellContentRowNo("SignIn", 1, "Expected");
		String errors1 = this.getErrorMsg();
		Assert.assertTrue(errors1.contains(expected));
	}

}
