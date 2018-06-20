/**
 * 
 */
package com.epam.bookingtest.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.epam.bookingtest.steps.FlightsSteps;
import com.epam.bookingtest.steps.HotelRentSteps;

/**
 * @author Артем
 *
 */
public class SwitchBtwHotelRentAndFlightsTest {
	private HotelRentSteps hotelSteps;
	private FlightsSteps flightsSteps;
	private final String FLIGHT_PAGE_FOOTER = "KAYAK входит в состав холдинга Booking Holdings Inc.,"
			+ " мирового лидера в сфере онлайн-туризма и сопутствующих услуг.";

	@BeforeMethod(description = "Init browser")
	public void setUp() {
		hotelSteps = new HotelRentSteps();
		flightsSteps = new FlightsSteps();
		hotelSteps.initBrowser();
	}

	@Test(groups = {
			"hotelrent" }, description = "Check correct switching between hotel rent and searching flights pages")
	public void switchBtwHotelRentAndFlightsPages() {
		hotelSteps.openMainPage();
		hotelSteps.openFlightsPage();
		assertEquals(flightsSteps.getFooterMessage(hotelSteps.getDriver()), FLIGHT_PAGE_FOOTER);
	}

	@AfterMethod(description = "Stop Browser")
	public void stopBrowser() {
		hotelSteps.closeDriver();
	}
}
