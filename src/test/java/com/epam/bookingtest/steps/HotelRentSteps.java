/**
 * 
 */
package com.epam.bookingtest.steps;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.epam.bookingtest.driver.DriverSingleton;
import com.epam.bookingtest.pages.renthotel.MainPage;
import com.epam.bookingtest.pages.renthotel.ReservationFinalPage;
import com.epam.bookingtest.pages.renthotel.ReservationPage;
import com.epam.bookingtest.pages.renthotel.ReservationSummaryPage;
import com.epam.bookingtest.pages.renthotel.SearchResultPage;
import com.epam.bookingtest.pages.renthotel.VerifiedReservationPage;

/**
 * @author Артем
 *
 */
public class HotelRentSteps {
	private WebDriver driver;

	private static Logger logger = LogManager.getLogger();

	public void initBrowser() {
		driver = DriverSingleton.getDriver();
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void closeDriver() {
		DriverSingleton.closeDriver();
	}

	public void openMainPage() {
		MainPage mainPage = new MainPage(driver);
		mainPage.openPage();
		logger.info("Main page is opened");
	}

	public void login(String login, String passw) {
		MainPage mainPage = new MainPage(driver);
		mainPage.login(login, passw);
		logger.info("Login perfomed");
	}

	public void chooseHotelWithoutCard() {
		SearchResultPage searchResultPage = new SearchResultPage(driver);
		searchResultPage.clickOnReserveHotelWithoutCard();
		switchWindow();
		logger.info("Window is switched");
	}

	public void submitReservation(String login, String passw) {
		ReservationPage reservationPage = new ReservationPage(driver);
		reservationPage.selectOneRoom();
		reservationPage.clickOnSubmitReservation();
		ReservationSummaryPage reservationSummaryPage = new ReservationSummaryPage(driver);
		reservationSummaryPage.login(login, passw);
		reservationSummaryPage.goToFinalStep();
		ReservationFinalPage reservationFinalPage = new ReservationFinalPage(driver);
		reservationFinalPage.fillPhoneNumber();
		reservationFinalPage.finishReservation();
		logger.info("Reservation is completed");
	}

	public String cancelReservation() {
		VerifiedReservationPage verifiedReservationPage = new VerifiedReservationPage(driver);
		logger.info("Reservation is canceled");
		return verifiedReservationPage.cancelReservation();
	}

	public void findHotels(String dest, int day) {
		MainPage mainPage = new MainPage(driver);
		mainPage.openPage();
		mainPage.sendDestination(dest);
		mainPage.pickStartDate(day);
		mainPage.clickOnFindHotels();
		logger.info("Searching hotels is started");
	}

	public void findHotels(String dest) {
		MainPage mainPage = new MainPage(driver);
		mainPage.openPage();
		mainPage.sendDestination(dest);
		mainPage.clickOnFindHotels();
		logger.info("Searching hotels is started");
	}

	public void clickOnFindHotels() {
		MainPage mainPage = new MainPage(driver);
		mainPage.clickOnFindHotels();
	}

	public void openFlightsPage() {
		MainPage mainPage = new MainPage(driver);
		mainPage.clickOnFindFlightsButton();
		switchWindow();
		logger.info("Flights page is opened");
	}

	private void switchWindow() {
		String currentWindow = driver.getWindowHandle();

		for (String handle : driver.getWindowHandles()) {
			if (!handle.equalsIgnoreCase(currentWindow)) {
				driver.switchTo().window(handle);
				try {
					Thread.sleep(2000, 0);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				break;
			}
		}
	}

	public void selectOnlyFiveStarsHotels() {
		SearchResultPage searchResultPage = new SearchResultPage(driver);
		searchResultPage.selectOnlyFiveStarsHotels();
		logger.info("Hotels with five stars are selected");
	}

	public List<String> getStarCounts() {
		SearchResultPage searchResultPage = new SearchResultPage(driver);
		logger.info("Star counts are got");
		return searchResultPage.getStarCounts();
	}

	public String getWarningMessage() {
		MainPage mainPage = new MainPage(driver);
		System.out.println(mainPage.getWarningMessage());
		logger.info("Warning message is got");
		return mainPage.getWarningMessage();
	}

	public List<WebElement> getSearchResults() {
		SearchResultPage searchResultPage = new SearchResultPage(driver);
		logger.info("Searched hotels are got");
		return searchResultPage.getSearchResults();
	}
}
