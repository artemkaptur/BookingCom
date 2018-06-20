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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.epam.bookingtest.pages.AbstractPage;

/**
 * @author Артем
 *
 */
public class ReservationPage extends AbstractPage {
	private WebDriverWait wait = new WebDriverWait(driver, 10);

	@FindBy(xpath = "//select[@class='hprt-nos-select']")
	private WebElement chooseRoom;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submitReservation;

	public ReservationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public void selectOneRoom() {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", chooseRoom);
		Select selectCountry = new Select(chooseRoom);
		selectCountry.selectByValue("1");
	}

	public void clickOnSubmitReservation() {
		wait.until(ExpectedConditions.elementToBeClickable(submitReservation)).click();
	}

	@Override
	public void openPage() throws OperationNotSupportedException {
		throw new OperationNotSupportedException();
	}
}
