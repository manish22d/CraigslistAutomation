package com.craigslist.TestCases;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.craigslist.BaseClass.TestBase;
import com.craigslist.Pages.Homepage;
import com.craigslist.Pages.HousingPage;
import com.craigslist.Utilities.TestUtility;
import com.google.common.collect.Comparators;
import com.google.common.collect.Ordering;

public class CraigslistTest extends TestBase {

	Homepage homepage;
	HousingPage housingPage;
	TestUtility testUtil;

	@BeforeClass(alwaysRun = true)
	public void setUp() {
		testUtil = new TestUtility();
		initialization();
		log.info("Application Launched Successfully");
//		driver.get(property.getProperty("URL"));
		homepage = new Homepage();
		homepage.changeLanguage("english");
		housingPage = homepage.navigateToHousing();
	}

	@Test(priority = 1, enabled = true)
	public void validatePriceIsSetInAscendingOrder(Method method) {
		extentTest = extent.startTest(method.getName());
		housingPage.setOrder("price ↑");
		System.out.println(housingPage.getListOfPrice());
		List<Float> actualPrice = housingPage.getListOfPrice();
		List<Float> expectedPrice = actualPrice.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println(actualPrice.equals(expectedPrice));
//		Collections.sort(expectedPrice, Collections.reverseOrder());
		System.out.println(actualPrice.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()).equals(actualPrice));
		System.out.println(actualPrice);
		System.out.println(expectedPrice);
		System.out.println(actualPrice.equals(expectedPrice));
		System.out.println(Ordering.natural().isOrdered(actualPrice));
		System.out.println(Ordering.natural().reverse().isOrdered(actualPrice));
		System.out.println(Comparators.isInOrder(actualPrice, Comparator.naturalOrder()));
		System.out.println(Comparators.isInOrder(actualPrice, Comparator.reverseOrder()));
		assertThat("Given List is not in ascending order ", Comparators.isInOrder(actualPrice, Comparator.reverseOrder()));
//		assertThat("expect", is(equalTo("actual")));
	}
	
	@Test(priority = 1, enabled = true)
	public void validatePriceIsSetInDecendingOrder(Method method) {
		extentTest = extent.startTest(method.getName());
		housingPage.setOrder("price ↓");
		System.out.println(housingPage.getListOfPrice());
		List<Float> actualPrice = housingPage.getListOfPrice();
		List<Float> expectedPrice = actualPrice.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println(actualPrice.equals(expectedPrice));
		System.out.println(actualPrice.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()).equals(actualPrice));
		System.out.println(actualPrice);
		System.out.println(expectedPrice);
		System.out.println(actualPrice.equals(expectedPrice));
		System.out.println(Ordering.natural().isOrdered(actualPrice));
		System.out.println(Ordering.natural().reverse().isOrdered(actualPrice));
		System.out.println(Comparators.isInOrder(actualPrice, Comparator.naturalOrder()));
		System.out.println(Comparators.isInOrder(actualPrice, Comparator.reverseOrder()));
//		assertThat("Given List is not in ascending order ", Comparators.isInOrder(actualPrice, Comparator.naturalOrder()));
	}
}
