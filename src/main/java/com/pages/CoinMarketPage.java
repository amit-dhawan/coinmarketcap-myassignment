package com.pages;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.util.UtilFunc;

//import net.thucydides.core.annotations.Step;

public class CoinMarketPage {

	private WebDriver driver;

	// 1. By Locators: OR
	private By totalRows = By.xpath("//tbody/tr");
	private By filterValue20 = By.xpath("//div/button[contains(text(),'20')]");
	private By filterValue50 = By.xpath("//div/button[contains(text(),'50')]");
	private By filterValue100 = By.xpath("//div/button[contains(text(),'100')]");
	private By showRowsDDL = By.xpath("//p[text()='Show rows']/following::div[1]/*[local-name()='svg']");
	private By filterbtn = By.xpath("(//button[text()='Filters'])[2]");
	private By addfilterbtn = By.xpath("//button[normalize-space()='+ Add Filter']");
	private By marketcapFilterButton = By.xpath("//button[normalize-space()='Market Cap']");
	private By priceFilterButton = By.xpath("//button[normalize-space()='Price']");
	private By minRangeValue = By.cssSelector("input[data-qa-id='range-filter-input-min']");
	private By maxRangeValue = By.cssSelector("input[data-qa-id='range-filter-input-max']");
	private By applyFilterButton = By.xpath("//button[normalize-space()='Apply Filter']");
	private By showFilterResultButton = By.xpath("//button[normalize-space()='Show results']");
	private By priceList = By.xpath("//tbody/tr/td[4]/div/a");
	private By marketpriceList = By.xpath("//tbody/tr/td[7]/p/span[2]");

	// 2. Constructor of the page class:
	public CoinMarketPage(WebDriver driver) {
		this.driver = driver;
	}

	// 3. page actions: features(behavior) of the page the form of methods:

//	@Step("Select row count from show rows dropdown")
	public void selectShowRowValue(int rowsCount) throws InterruptedException {
		driver.findElement(showRowsDDL).click();

		By dropDownElement = null;

		switch (rowsCount) {
		case 20:
			dropDownElement = filterValue20;
			break;
		case 50:
			dropDownElement = filterValue50;
			break;
		case 100:
			dropDownElement = filterValue100;
			break;
		default:
			System.out.println("passed row count i snot present on page: " + rowsCount);
		}

		driver.findElement(dropDownElement).click();
	}

//	@Step("Get Number of records ")
	public int getnumberofrows() {

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<WebElement> rows = driver.findElements(totalRows);
		int rowCount = rows.size();
		return rowCount;
	}

	public void openfilterdialog() throws InterruptedException {
		driver.findElement(filterbtn).click();
		Thread.sleep(5000);
		driver.findElement(addfilterbtn).click();
	}

//	@Step("Set Filter")
	public void applyFilters(String filterNmae, String minrange, String maxrange) throws InterruptedException {

		switch (filterNmae.trim().toLowerCase()) {
		case "price":

			driver.findElement(priceFilterButton).click();
			UtilFunc.waitAndType(driver, minRangeValue, minrange);
			UtilFunc.waitAndType(driver, maxRangeValue, maxrange);
			System.out.println("Price Filter____" + filterNmae + "___" + minrange + "___" + maxrange);

			break;
		case "marketcap":
			System.out.println("marketcarp Filter____" + filterNmae + "___" + minrange + "___" + maxrange);
			driver.findElement(marketcapFilterButton).click();
			UtilFunc.waitAndType(driver, minRangeValue, minrange);
			UtilFunc.waitAndType(driver, maxRangeValue, maxrange);

			break;

		}
		applyFilterbutton();
	}

//	@Step("Apply Filter - ")
	public void applyFilterbutton() throws InterruptedException {
		driver.findElement(applyFilterButton).click();

	}

//	@Step("Show FIlter Results")
	public void showFilterResult() throws InterruptedException {
		driver.findElement(showFilterResultButton).click();
	}

//	@Step("Check Filter : Price")
	public boolean checkprice() throws InterruptedException, ParseException {
		System.out.println("**************************************");
		List<WebElement> listitem = driver.findElements(priceList);
		listitem.size();
		boolean checkresult = true;

		Iterator<WebElement> itr = listitem.iterator();
		while (itr.hasNext()) {
			String currencywithsymbol = itr.next().getText();
			BigDecimal res = parse(currencywithsymbol, Locale.US);
			if (res.compareTo(BigDecimal.valueOf(100)) != -1 && res.compareTo(BigDecimal.valueOf(100)) != 0) {
				checkresult = false;
			}
			if (res.compareTo(BigDecimal.valueOf(1)) != 1 && res.compareTo(BigDecimal.valueOf(1)) != 0) {
				checkresult = false;
			}

		}
		return checkresult;
	}

//	@Step("Check Filter : Market Cap")
	public boolean checkmarketcap() throws InterruptedException, ParseException {
		System.out.println("**************************************");
		List<WebElement> listitem = driver.findElements(marketpriceList);
		listitem.size();
		boolean checkresult = true;
	
		Iterator<WebElement> itr = listitem.iterator();
		while (itr.hasNext()) {
			String currencywithsymbol = itr.next().getText();
			BigDecimal res = parse(currencywithsymbol, Locale.US);
			if (res.compareTo(BigDecimal.valueOf(1000000000)) != 1
					&& res.compareTo(BigDecimal.valueOf(1000000000)) != 0) {
				checkresult = false;
			}

			if (Double.valueOf(res.doubleValue()).compareTo(Double.valueOf(10000000000L)) != -1
					&& Double.valueOf(res.doubleValue()).compareTo(Double.valueOf(10000000000L)) != 0) {

				checkresult = false;
			}

		}
		return checkresult;
	}

	public static BigDecimal parse(final String amount, final Locale locale) throws ParseException {
		final NumberFormat format = NumberFormat.getNumberInstance(locale);
		if (format instanceof DecimalFormat) {
			((DecimalFormat) format).setParseBigDecimal(true);
		}
		return (BigDecimal) format.parse(amount.replaceAll("[^\\d.,]", ""));
	}

//	@Step("Get Page Title")
	public String getLoginPageTitle() {
		return driver.getTitle();
	}

}
