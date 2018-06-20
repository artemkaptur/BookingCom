/**
 * 
 */
package com.epam.bookingtest.pages.flights;

import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

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
public class SearchResultPage extends AbstractPage {

	private WebDriverWait wait = new WebDriverWait(driver, 10);

	@FindBy(xpath = "//span[contains(text(),'Recommended')]")
	private WebElement sortType;

	@FindBy(xpath = "//ul/li[contains(text(),'Cheapest ')]")
	private WebElement fromCheapestSort;

	@FindBy(xpath = "//span[@class='price option-text']")
	private WebElement bestPrice;

	public SearchResultPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public void chooseSortByPrice() {
		wait.until(ExpectedConditions.elementToBeClickable(sortType));
		sortType.click();
		fromCheapestSort.click();
	}

	public List<String> getSearchResults() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='price option-text']")));
		List<WebElement> searchResults = driver.findElements(By.xpath("//span[@class='price option-text']"));

		List<String> prices = new ArrayList<String>();
		for (WebElement elem : searchResults) {
			try {
				prices.add(elem.getText());
			} catch (org.openqa.selenium.StaleElementReferenceException ex) {
				prices.add(elem.getText());
			}
		}
		return prices;
	}

	@Override
	public void openPage() throws OperationNotSupportedException {
		throw new OperationNotSupportedException();
	}

}
