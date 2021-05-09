package com.craigslist.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.craigslist.BaseClass.TestBase;
import com.craigslist.Constants.Constants;

public class Homepage extends TestBase {

	@FindBy(id = "chlang")
	WebElement lang;

	@FindBy(xpath = "//a[@class='hhh']")
	WebElement housing;

	public Homepage() {
		PageFactory.initElements(driver, this);
	}

	public void changeLanguage(String language) {
		new WebDriverWait(driver, Constants.EXPLICIT_WAIT).until(ExpectedConditions.elementToBeClickable(lang));
		Select langDropdown = new Select(lang);
		langDropdown.selectByVisibleText(language.toLowerCase());
	}

	public HousingPage navigateToHousing() {
		new WebDriverWait(driver, Constants.EXPLICIT_WAIT).until(ExpectedConditions.elementToBeClickable(housing));
		housing.click();
		return new HousingPage();
	}

}
