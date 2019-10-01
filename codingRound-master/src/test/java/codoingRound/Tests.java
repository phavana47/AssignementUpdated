package codoingRound;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import clearTrip.Constants;
import clearTrip.FlightBookingTest;
import clearTrip.HotelBookingTest;
import clearTrip.LaunchBrowser;
import clearTrip.SignInTest;

public class Tests extends LaunchBrowser {

	FlightBookingTest objFlight;
	HotelBookingTest objHotels;
	SignInTest objSignIn;

	@BeforeMethod
	public void initialization() {
		driver = setDriverPath();
	}

	@Test(priority = 0)
	public void testFlightJourney() throws IOException {
		objFlight = PageFactory.initElements(driver, FlightBookingTest.class);
		driver.get(Constants.URL);
		objFlight.clickOneWay();
		objFlight.setFrom();
		objFlight.setTo();
		objFlight.selectCalender();
		objFlight.clickSearchButton();
		objFlight.verifyFlight();
	}

	@Test(priority = 1)
	public void searchForHotels() throws IOException {
		objHotels = PageFactory.initElements(driver, HotelBookingTest.class);
		driver.get(Constants.URL);
		objHotels.clickHotelLink();
		objHotels.setLocation();
		objHotels.selectText();
		objHotels.clickSearchButton();
	}

	@Parameters({"frameName"})
	@Test(priority = 2)
	public void signInError(String frameName) throws IOException {
		objSignIn = PageFactory.initElements(driver, SignInTest.class);
		driver.get(Constants.URL);
		objSignIn.clickYourTrips();
		objSignIn.clickSignIn();
		driver.switchTo().frame(frameName);
		objSignIn.clickSignInButton();
		objSignIn.verifyErrorMsg();
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

}
