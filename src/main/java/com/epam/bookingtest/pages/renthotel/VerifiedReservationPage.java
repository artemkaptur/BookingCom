/**
 * 
 */
package com.epam.bookingtest.pages.renthotel;

import javax.naming.OperationNotSupportedException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.bookingtest.pages.AbstractPage;

/**
 * @author Артем
 *
 */
public class VerifiedReservationPage extends AbstractPage {
	@FindBy(xpath = "//button[@title='Закрыть')]")
	private WebElement closeSpam;

	@FindBy(xpath = "//span[contains(text(),'Варианты отмены')]")
	private WebElement cancelVariants;

	@FindBy(id = "personal_reasons")
	private WebElement personalReason;

	@FindBy(id = "cancel_sure")
	private WebElement cancelReservation;

	@FindBy(xpath = "//b[contains(text(),'Обновление: ваше бронирование отменено.')]")
	private WebElement cancelProof;

	public VerifiedReservationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public String cancelReservation() {
		if (closeSpam.isDisplayed()) {
			closeSpam.click();
		}
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cancelVariants);
		cancelVariants.click();
		personalReason.click();
		cancelReservation.click();
		return cancelProof.getText();
	}

	@Override
	public void openPage() throws OperationNotSupportedException {
		throw new OperationNotSupportedException();
	}
}
