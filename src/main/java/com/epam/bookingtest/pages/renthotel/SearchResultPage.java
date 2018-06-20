/**
 * 
 */
package com.epam.bookingtest.pages.renthotel;

import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
public class SearchResultPage extends AbstractPage {
	private WebDriverWait wait = new WebDriverWait(driver, 10);

	@FindBy(xpath = "//a[@data-id='class-5']")
	private WebElement fiveStarsHotelsCheckBox;

	@FindBy(xpath = "//*[@id='hotellist_inner']/div/div[2]/div[2]/div/table/tfoot/tr[2]/td/div/a/span[contains(text(),'Выбрать апартаменты')]")
	private WebElement reserveHotelWithoutCard;

	public SearchResultPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public List<WebElement> getSearchResults() {
		List<WebElement> searchResults = driver.findElements(By.xpath("//*[@id='hotellist_inner']/div"));
		return searchResults;
	}

	public void selectOnlyFiveStarsHotels() {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", fiveStarsHotelsCheckBox);
		fiveStarsHotelsCheckBox.click();
	}

	public void clickOnReserveHotelWithoutCard() {
		wait.until(ExpectedConditions.elementToBeClickable(reserveHotelWithoutCard)).click();
	}

	public List<String> getStarCounts() {
		List<WebElement> starCounts = driver
				.findElements(By.xpath("//*[@id='hotellist_inner']/div/div[2]/div[1]/div[1]/i[1]/span"));
		List<String> starCountsText = new ArrayList<String>();
		for (WebElement elem : starCounts) {
			starCountsText.add(elem.getText());
		}
		return starCountsText;
	}

	@Override
	public void openPage() throws OperationNotSupportedException {
		throw new OperationNotSupportedException();
	}

}
