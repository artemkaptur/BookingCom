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
public class IsCanselReservationAvalibleTest {
	private HotelRentSteps steps;

	private final String LOGIN = "userfortest876@gmail.com";
	private final String PASSWORD = "test1234test";
	private final String DESTINATION = "Минск";
	private final int ARRIVAL_DAY = 23;
	private final String SUCCESFUL_CANSEL_MESSAGE = "Обновление: ваше бронирование отменено.";

	@BeforeMethod(description = "Init browser")
	public void setUp() {
		steps = new HotelRentSteps();
		steps.initBrowser();
	}

	@Test(groups = { "hotelrent" }, description = "Check ability to cansel resrvation")
	public void isCanselReservationAvalibleTest() {
		steps.openMainPage();
		steps.findHotels(DESTINATION, ARRIVAL_DAY);
		steps.chooseHotelWithoutCard();
		steps.submitReservation(LOGIN, PASSWORD);
		assertEquals(steps.cancelReservation(), SUCCESFUL_CANSEL_MESSAGE);
	}

	@AfterMethod(description = "Stop Browser")
	public void stopBrowser() {
		steps.closeDriver();
	}
}
