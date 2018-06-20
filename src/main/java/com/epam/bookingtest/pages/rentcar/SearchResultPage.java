/**
 * 
 */
package com.epam.bookingtest.pages.rentcar;

import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.epam.bookingtest.pages.AbstractPage;

/**
 * @author Артем
 *
 */
public class SearchResultPage extends AbstractPage {

	public SearchResultPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public List<WebElement> getSearchResults() {
		List<WebElement> searchResults = driver.findElements(By.xpath("//div[@class='result-header cf ']"));
		return searchResults;
	}

	@Override
	public void openPage() throws OperationNotSupportedException {
		throw new OperationNotSupportedException();
	}
}
