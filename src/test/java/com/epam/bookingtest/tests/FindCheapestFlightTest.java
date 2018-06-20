/**
 * 
 */
package com.epam.bookingtest.tests;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.epam.bookingtest.steps.FlightsSteps;

/**
 * @author Артем
 *
 */
public class FindCheapestFlightTest {
	private FlightsSteps steps;
	private final String FROM = "Minsk";
	private final String TO = "Moscow";
	private final int DEPART_DAY = 23;

	@BeforeMethod(description = "Init browser")
	public void setUp() {
		steps = new FlightsSteps();
		steps.initBrowser();
	}

	@Test(groups = { "flights" }, description = "")
	public void searchingCheapestFlight() {
		steps.findFlights(FROM, TO, DEPART_DAY);
		List<String> prices = steps.getPrices();
		assertTrue(checkFindedCheapestFlight(prices));
	}

	private boolean checkFindedCheapestFlight(List<String> prices) {
		int min = Integer.parseInt(prices.get(0).substring(1));
		for (String str : prices) {
			if (str.contains("$")) {
				if (min > Integer.parseInt(str.substring(1))) {
					return false;
				}
			}
		}
		return true;
	}

	@AfterMethod(description = "Stop Browser")
	public void stopBrowser() {
		steps.closeDriver();
	}
}
