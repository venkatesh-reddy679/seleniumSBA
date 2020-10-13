package com.utilities;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WrapperClass {
	

	protected WebDriver driver;

	public void launchBrowser(String browser, String url) {

		if (browser.equalsIgnoreCase("chrome")) {

			// declaring and initializing
			// browser...................................................

			System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();

			// opening
			// website...............................................................
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		}
	}

	// screenshot
	// code...............................................................
	public void screenshot() throws IOException {
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("G:\\selenium\\AxisBankProject\\screenshot.PNG"));

	}

	public void quit() {
		driver.close();
	}

}
