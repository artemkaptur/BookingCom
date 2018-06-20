/**
 * 
 */
package com.epam.bookingtest.listener;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.epam.bookingtest.driver.DriverSingleton;

/**
 * @author Артем
 *
 */
public class ScreenshotOnFailListener implements ITestListener {
	private static Logger logger = LogManager.getLogger();

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailure(ITestResult result) {
		takeScreenshot();
	}

	private void takeScreenshot() {
		File screenCapture = ((TakesScreenshot) DriverSingleton.getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			File f = new File(".//target/screenshots/screenshot.png");
			FileUtils.copyFile(screenCapture, f);
			System.setProperty("org.uncommons.reportng.escape-output ", "false");
			Reporter.log("<img src=\"" + f.getAbsolutePath() + "\"/>");
			logger.info("Screenshot is made");

		} catch (IOException e) {
			System.out.println("Failed to save screenshot: " + e.getLocalizedMessage());
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}
}
