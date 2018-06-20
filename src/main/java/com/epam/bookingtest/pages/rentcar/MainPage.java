/**
 * 
 */
package com.epam.bookingtest.pages.rentcar;

import org.openqa.selenium.By;
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
public class MainPage extends AbstractPage {
	private final String BASE_URL = "https://www.booking.com/cars/";

	private WebDriverWait wait = new WebDriverWait(driver, 10);

	@FindBy(id = "pu-country")
	private WebElement country;

	@FindBy(id = "pu-city")
	private WebElement city;

	@FindBy(id = "pu-location")
	private WebElement location;

	@FindBy(xpath = "//span[@class='date-panel date-panel--pu']")
	private WebElement startDay;

	@FindBy(xpath = "//*[@id='btn-fieldset']/input")
	private WebElement findCarsButton;

	public MainPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public void sellectSearchingDataFields(String country, String city, int startDay, int endDay) {
		Select selectCountry = new Select(this.country);
		selectCountry.selectByVisibleText(country);
		Select selectCity = new Select(this.city);
		selectCity.selectByVisibleText(city);
		Select selectLocation = new Select(this.location);
		selectLocation.selectByVisibleText(city + " (Все места)");
		this.startDay.click();
		wait.until(ExpectedConditions.visibilityOf(
				driver.findElement(By.xpath("//a[@class='ui-state-default' and contains(text(),'" + startDay + "')]"))))
				.click();
		driver.findElement(By.xpath("//a[@class='ui-state-default' and contains(text(),'" + endDay + "')]")).click();
	}

	public void clickOnFindCarsButton() {
		wait.until(ExpectedConditions.elementToBeClickable(findCarsButton)).click();
	}

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
	}
}
