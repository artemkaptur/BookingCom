/**
 * 
 */
package com.epam.bookingtest.tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.epam.bookingtest.steps.HotelRentSteps;

/**
 * @author Артем
 *
 */
public class SearchingAvalibleHotelTest {
	private HotelRentSteps steps;
	private final String DESTINATION = "Минск";
	private final int ARRIVAL_DAY = 23;

	@BeforeMethod(description = "Init browser")
	public void setUp() {
		steps = new HotelRentSteps();
		steps.initBrowser();
	}

	@Test(groups = {
			"hotelrent" }, description = "Check searching hotels according to required destination and arrival day")
	public void searchingHotelAccordingToData() {
		steps.findHotels(DESTINATION, ARRIVAL_DAY);
		assertTrue(steps.getSearchResults().size() != 0);
	}

	@AfterMethod(description = "Stop Browser")
	public void stopBrowser() {
		steps.closeDriver();
	}
}
