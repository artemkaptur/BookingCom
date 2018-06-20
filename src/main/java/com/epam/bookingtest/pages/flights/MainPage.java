/**
 * 
 */
package com.epam.bookingtest.pages.flights;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.epam.bookingtest.pages.AbstractPage;

/**
 * @author Артем
 *
 */
public class MainPage extends AbstractPage {
	private final String BASE_URL = "https://booking.kayak.com/";

	private WebDriverWait wait = new WebDriverWait(driver, 10);

	@FindBy(xpath = "//span[contains(text(),'One-way')]")
	private WebElement oneWayTickets;

	@FindBy(name = "origin")
	private WebElement fromField;

	@FindBy(name = "destination")
	private WebElement toField;

	@FindBy(xpath = "//div[contains(text(),'Depart')]")
	private WebElement departDay;

	@FindBy(xpath = "//button[@class='Common-Widgets-Button-ButtonDeprecated Common-Widgets-Button-Button Button-Gradient size-l searchButton']")
	private WebElement findFlights;

	@FindBy(xpath = "//button[@class='Button-Grey-Invert closeButton']")
	private WebElement warningButton;

	@FindBy(xpath = "//p[@class='pcln-group-logos__headline' and contains(text(),'KAYAK входит в состав холдинга Booking Holdings Inc., мирового лидера в сфере онлайн-туризма и сопутствующих услуг.')]")
	private WebElement footerMessage;

	public MainPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public void chooseOneWayTickets() {
		oneWayTickets.click();
	}

	public void fillData(String from, String to, int departDay) {
		fillFrom(from);
		fillTo(to);
		this.departDay.click();
		wait.until(ExpectedConditions
				.elementToBeClickable(driver.findElement(By.xpath("//div[@class='day' and contains(text(),'23')]"))))
				.click();
	}

	public void findFlights() {
		findFlights.click();
	}

	private void fillFrom(String from) {
		fromField.click();
		fromField.clear();
		fromField.sendKeys(from);
		try {
			wait.until(ExpectedConditions
					.elementToBeClickable(driver.findElement(By.xpath("//li[@data-short-name='Minsk (MSQ)']"))))
					.click();
		} catch (org.openqa.selenium.StaleElementReferenceException ex) {
			wait.until(ExpectedConditions
					.elementToBeClickable(driver.findElement(By.xpath("//li[@data-short-name='Minsk (MSQ)']"))))
					.click();
		}
	}

	private void fillTo(String to) {
		wait.until(ExpectedConditions.elementToBeClickable(toField));
		toField.click();
		toField.clear();
		toField.sendKeys(to);
		try {
			wait.until(ExpectedConditions
					.elementToBeClickable(driver.findElement(By.xpath("//li[@data-short-name='Moscow (MOW)']"))))
					.click();
		} catch (org.openqa.selenium.StaleElementReferenceException ex) {
			wait.until(ExpectedConditions
					.elementToBeClickable(driver.findElement(By.xpath("//li[@data-short-name='Moscow (MOW)']"))))
					.click();
		}
	}

	public String getFooterMessage() {
		return footerMessage.getText();
	}

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
	}

}
