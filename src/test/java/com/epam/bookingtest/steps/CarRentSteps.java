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
import com.epam.bookingtest.pages.rentcar.MainPage;
import com.epam.bookingtest.pages.rentcar.SearchResultPage;

/**
 * @author Артем
 *
 */
public class CarRentSteps {
	private WebDriver driver;

	private static Logger logger = LogManager.getLogger();

	public void initBrowser() {
		driver = DriverSingleton.getDriver();
	}

	public void closeDriver() {
		DriverSingleton.closeDriver();
	}

	public void findCars(String country, String city, int startDay, int endDay) {
		MainPage mainPage = new MainPage(driver);
		mainPage.openPage();
		mainPage.sellectSearchingDataFields(country, city, startDay, endDay);
		mainPage.clickOnFindCarsButton();
		logger.info("Searching cars is started");
	}

	public List<WebElement> getSearchResults() {
		SearchResultPage searchResultPage = new SearchResultPage(driver);
		logger.info("Searched results are got");
		return searchResultPage.getSearchResults();
	}
}
