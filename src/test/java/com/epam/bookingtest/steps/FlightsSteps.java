/**
 * 
 */
package com.epam.bookingtest.steps;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.epam.bookingtest.driver.DriverSingleton;
import com.epam.bookingtest.pages.flights.MainPage;
import com.epam.bookingtest.pages.flights.SearchResultPage;

/**
 * @author Артем
 *
 */
public class FlightsSteps {
	private WebDriver driver;

	private static Logger logger = LogManager.getLogger();

	public void initBrowser() {
		driver = DriverSingleton.getDriver();
	}

	public void closeDriver() {
		DriverSingleton.closeDriver();
	}

	public void findFlights(String from, String to, int departDay) {
		MainPage mainPage = new MainPage(driver);
		mainPage.openPage();
		mainPage.chooseOneWayTickets();
		mainPage.fillData(from, to, departDay);
		mainPage.findFlights();
		logger.info("Searching flights is started");
	}

	public List<String> getPrices() {
		SearchResultPage searchResultPage = new SearchResultPage(driver);
		searchResultPage.chooseSortByPrice();
		logger.info("Searched flight's prices are got");
		return searchResultPage.getSearchResults();
	}

	public String getFooterMessage(WebDriver driver) {
		MainPage mainPage = new MainPage(driver);
		return mainPage.getFooterMessage();
	}
}
