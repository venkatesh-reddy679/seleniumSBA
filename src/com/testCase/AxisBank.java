package com.testCase;

import java.io.IOException;

import org.testng.annotations.Test;

import com.pages.ExcelRead;
import com.pages.ExcelWrite;
import com.pages.TestPage;
import com.utilities.WrapperClass;

public class AxisBank extends WrapperClass {
	
	String sheetName="DepositAmount";
	ExcelWrite ew = new ExcelWrite();
	
	ExcelRead er = new ExcelRead();
	@Test
	public void test() throws InterruptedException, IOException {
		
		launchBrowser("chrome", "https://www.axisbank.com/retail/calculators/fd-calculator?cta=homepage-fd-calculate-with-ease");
		TestPage page= new TestPage(driver);
		System.out.println("selecting senior citizen...............................................................");
		page.Citizen("Senior Citizen");
		ew.putCellValue(sheetName,"40000" );
		String amount = er.getCellValue(sheetName, 0, 0);
		System.out.println("entering amount as 40000...................................................................");
		page.depositAmount(amount);
		System.out.println("selecting type of deposit as monthly payout..................................................");
		page.typeOfDeposit("Monthly Payout");
        System.out.println("calculating rate of interest.................................................................");
		page.printROI();
		System.out.println("taking screenshot............................................................................");
		screenshot();
		System.out.println("closing website and browser....................................................................");
		quit();
		
		
	}

}
