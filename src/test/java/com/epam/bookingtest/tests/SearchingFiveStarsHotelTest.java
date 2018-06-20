/**
 * 
 */
package com.epam.bookingtest.tests;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.epam.bookingtest.steps.HotelRentSteps;

/**
 * @author Артем
 *
 */
public class SearchingFiveStarsHotelTest {
	private HotelRentSteps steps;
	private final String DESTINATION = "Минск";
	private final String FIVE_STAR_COUNT_CHECK = "5-звездочный отель";

	@BeforeMethod(description = "Init browser")
	public void setUp() {
		steps = new HotelRentSteps();
		steps.initBrowser();
	}

	@Test(groups = { "hotelrent" }, description = "Check correct searching hotels only with five stars")
	public void searchingFiveStarsHotels() {
		steps.findHotels(DESTINATION);
		steps.selectOnlyFiveStarsHotels();
		assertTrue(checkFindedHotelsStarCount(steps.getStarCounts()));
	}

	private boolean checkFindedHotelsStarCount(List<String> starCounts) {
		for (String str : starCounts) {
			if (!str.equals(FIVE_STAR_COUNT_CHECK)) {
				return false;
			}
		}
		return true;
	}

	@AfterMethod(description = "Stop Browser")
	public void stopBrowser() {
		steps.closeDriver();
	}
}
