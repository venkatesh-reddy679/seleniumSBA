package com.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TestPage {

	WebDriver driver;

	public TestPage(WebDriver driver) {
		this.driver = driver;

	}

	public void Citizen(String type) throws InterruptedException {
		
		String parentWindowHandler = driver.getWindowHandle();
		String subWindowHandler = null;

		Set<String> handles = driver.getWindowHandles();
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()) {

			subWindowHandler = iterator.next();
		}
		driver.switchTo().window(subWindowHandler);
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//*[@id='nvpush_cross']"))).click().build().perform();

		driver.findElement(By.xpath("//label[contains(text(),'Senior Citizen')]")).click();

	}

	public void typeOfDeposit(String type) {
		Select select = new Select(driver.findElement(By.id("FdepType")));
		select.selectByValue(type);
	}

	public void depositAmount(String amount) throws InterruptedException {

		driver.findElement(By.id("loan_amount")).clear();
		Thread.sleep(2000);
		driver.findElement(By.id("loan_amount")).sendKeys(amount);

	}

	public void printROI() {
		String interesetAmount = driver.findElement(By.xpath("//div[@class='finalResult']/div[2]/span[2]")).getText();
		System.out.println("THE INTEREST RATE FOR THE AMOUNT OF 40,000 PER 6 MONTHS IS =====" + interesetAmount);
	}

}
