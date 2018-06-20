/**
 * 
 */
package com.epam.bookingtest.pages;

import javax.naming.OperationNotSupportedException;

import org.openqa.selenium.WebDriver;

/**
 * @author Артем
 *
 */
public abstract class AbstractPage {
	protected WebDriver driver;

	public abstract void openPage() throws OperationNotSupportedException;

	public AbstractPage(WebDriver driver) {
		this.driver = driver;
	}
}
