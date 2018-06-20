/**
 * 
 */
package com.epam.bookingtest.pages.renthotel;

import javax.naming.OperationNotSupportedException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.bookingtest.pages.AbstractPage;

/**
 * @author Артем
 *
 */
public class ReservationFinalPage extends AbstractPage {

	@FindBy(id = "phone")
	private WebElement phoneNumber;

	@FindBy(xpath = "//span[contains(text(),'Завершить бронирование')]")
	private WebElement submitButton;

	public ReservationFinalPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public void fillPhoneNumber() {
		phoneNumber.sendKeys(generatePhoneNumber());
	}

	public void finishReservation() {
		submitButton.click();
	}

	private String generatePhoneNumber() {
		StringBuilder str = new StringBuilder("29");
		for (int i = 0; i < 5; i++) {
			str.append(Math.round(Math.random() * 10));
		}
		return str.toString();
	}

	@Override
	public void openPage() throws OperationNotSupportedException {
		throw new OperationNotSupportedException();
	}
}
