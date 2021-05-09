package com.craigslist.Pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.craigslist.BaseClass.TestBase;

public class HousingPage extends TestBase {

	@FindBy(id = "chlang")
	WebElement lang;

	@FindBy(xpath = "//*[@class='search-sort']//ul[@class='dropdown-list']")
	WebElement sortingDropdown;

	@FindBy(xpath = "//ul/h4/preceding-sibling::li//*[@class='result-meta']/span[@class='result-price']")
	List<WebElement> prices;

	public HousingPage() {
		PageFactory.initElements(driver, this);
	}

	public void setOrder(String order) {
		new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(sortingDropdown));
		sortingDropdown.click();
		driver.findElement(By.linkText(order)).click();
	}

	public List<Float> getListOfPrice() {
		new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(prices.get(0)));
		return prices.stream().map(price -> Float.parseFloat(price.getText().trim().replace("€", "")))
				.collect(Collectors.toList()).subList(1, 3);
	}
}
