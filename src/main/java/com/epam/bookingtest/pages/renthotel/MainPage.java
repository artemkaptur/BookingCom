/**
 * 
 */
package com.epam.bookingtest.pages.renthotel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.bookingtest.pages.AbstractPage;

/**
 * @author Артем
 *
 */
public class MainPage extends AbstractPage {
	private final String BASE_URL = "https://www.booking.com/";

	@FindBy(id = "ss")
	private WebElement destinationField;

	@FindBy(xpath = "//*[@id='frm']/div[1]/div[2]")
	private WebElement openCalendar;

	@FindBy(xpath = "//span[contains(text(),'Проверить цены')]")
	private WebElement findHotels;

	@FindBy(xpath = "//*[@id='destination__error']/div/span")
	private WebElement warningMessage;

	@FindBy(xpath = "//span[contains(text(),'Авиабилеты')]")
	private WebElement findFlightsButton;

	@FindBy(xpath = "//span[contains(text(),'Войти в аккаунт')]")
	private WebElement loginButton;

	@FindBy(name = "username")
	private WebElement username;

	@FindBy(name = "password")
	private WebElement password;

	@FindBy(xpath = "//input[@class='bootstrapped-input btn btn-primary  ']")
	private WebElement submit;

	public MainPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public void login(String login, String passw) {
		loginButton.click();
		username.sendKeys(login);
		password.sendKeys(passw);
		submit.click();
	}

	public void sendDestination(String dest) {
		destinationField.click();
		destinationField.clear();
		destinationField.sendKeys(dest);
	}

	public void pickStartDate(int day) {
		openCalendar.click();
		driver.findElement(By.xpath("//table/tbody/tr/td/span[contains(text(),'" + day + "')]")).click();
	}

	public void clickOnFindHotels() {
		findHotels.click();
	}

	public void clickOnFindFlightsButton() {
		findFlightsButton.click();
	}

	public String getWarningMessage() {
		return warningMessage.getText();
	}

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
	}

}
