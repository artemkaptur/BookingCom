/**
 * 
 */
package com.epam.bookingtest.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.epam.bookingtest.steps.HotelRentSteps;

/**
 * @author Артем
 *
 */
public class EmptyDestinationFieldTest {
	private HotelRentSteps steps;

	@BeforeMethod(description = "Init browser")
	public void setUp() {
		steps = new HotelRentSteps();
		steps.initBrowser();
	}

	@Test(groups = { "hotelrent" }, description = "Check correct warning message due to empty destination field")
	public void emptyDestinationTest() {
		steps.openMainPage();
		steps.clickOnFindHotels();
		assertEquals(steps.getWarningMessage(), "Ошибка:");
	}

	@AfterMethod(description = "Stop Browser")
	public void stopBrowser() {
		steps.closeDriver();
	}
}
