/**
 * 
 */
package com.epam.bookingtest.tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.epam.bookingtest.steps.CarRentSteps;

/**
 * @author Артем
 *
 */
public class SearchCarsAccordingToDataTest {
	private CarRentSteps steps;
	private final String COUNTRY = "Беларусь";
	private final String CITY = "Минск";
	private final int START_DAY = 23;
	private final int END_DAY = 24;

	@BeforeMethod(description = "Init browser")
	public void setUp() {
		steps = new CarRentSteps();
		steps.initBrowser();
	}

	@Test(groups = { "carrent" }, description = "Check search car working according to input data")
	public void searchCarsAccordingToData() {
		steps.findCars(COUNTRY, CITY, START_DAY, END_DAY);
		assertTrue(steps.getSearchResults().size() != 0);
	}

	@AfterMethod(description = "Stop Browser")
	public void stopBrowser() {
		steps.closeDriver();
	}
}
