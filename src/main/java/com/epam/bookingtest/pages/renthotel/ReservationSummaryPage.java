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
public class ReservationSummaryPage extends AbstractPage {

	@FindBy(xpath = "//button[contains(text(),'Далее: финальные данные')]")
	private WebElement goToFinalStep;

	@FindBy(xpath = "//span[contains(text(),'Войти в аккаунт')]")
	private WebElement loginButton;

	@FindBy(name = "username")
	private WebElement username;

	@FindBy(name = "password")
	private WebElement password;

	@FindBy(xpath = "//input[@class='bootstrapped-input btn btn-primary  ']")
	private WebElement submit;

	public ReservationSummaryPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public void login(String login, String passw) {
		loginButton.click();
		username.sendKeys(login);
		password.sendKeys(passw);
		submit.click();
	}

	public void goToFinalStep() {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", goToFinalStep);
		goToFinalStep.click();
	}

	@Override
	public void openPage() throws OperationNotSupportedException {
		throw new OperationNotSupportedException();
	}
}
