package com.craigslist.TestCases;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

public class Interview {

	@Test
	public void testMethod() {
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\CA_Automation\\Drivers\\chromedriver.exe");
		WebDriver drivers = new ChromeDriver();
		drivers.get("https://www.google.com/");
		drivers.findElement(By.name("q")).sendKeys("Manish");
		drivers.findElement(By.name("q")).sendKeys(Keys.ENTER);
		System.out.println(drivers.getWindowHandle());
	}

	@Test
	public void JsonResponse() {
		String response = "{\"ResponseXYZ\": {" + "    \"count\": 3," + "    \"listItems\": [{"
				+ "        \"id\": \"1\"," + "        \"age\": 15," + "        \"name\": \"Ram\"" + "    }," + "    {"
				+ "        \"id\": \"2\"," + "        \"age\": 24," + "        \"name\": \"Bala\"" + "    }," + "    {"
				+ "        \"id\": \"3\"," + "        \"age\": 30," + "        \"name\": \"Raj\"" + "    }]" + " }"
				+ "}";
		JsonArray listItems = JsonParser.parseString(response).getAsJsonObject().getAsJsonObject("ResponseXYZ")
				.getAsJsonArray("listItems");

		listItems.forEach(items -> System.out.println(items.getAsJsonObject().get("name").getAsString() + "-"
				+ items.getAsJsonObject().get("age").getAsString()));
	}

	@Test
	public void StringTest() {
		String a = "Mississippi";
		ArrayList<Character> a2 = new ArrayList<Character>();
		for (int i = 0; i < a.length(); i++) {
			if (a2.contains(a.charAt(i)))
				a2.add(a.charAt(i));

		}

		System.out.println(a2);
	}

	@Test
	public void jsonTest() {
		String json = "\r\n" + "{\r\n" + "	\"employee\": [\r\n" + "		{\r\n" + "			\"id\": 1,\r\n"
				+ "			\"first_name\": \"manish\",\r\n" + "			\"last_name\": \"kumar\",\r\n"
				+ "			\"age\": 30,\r\n" + "			\"salary\": 1000\r\n" + "		},\r\n" + "		{\r\n"
				+ "			\"id\": 2,\r\n" + "			\"first_name\": \"manish\",\r\n"
				+ "			\"last_name\": \"kumar\",\r\n" + "			\"age\": 30,\r\n"
				+ "			\"salary\": 1500\r\n" + "		},\r\n" + "		{\r\n" + "			\"id\": 3,\r\n"
				+ "			\"first_name\": \"ashok\",\r\n" + "			\"last_name\": \"kumar\",\r\n"
				+ "			\"age\": 30,\r\n" + "			\"salary\": 1000\r\n" + "		},\r\n" + "		{\r\n"
				+ "			\"id\": 4,\r\n" + "			\"first_name\": \"test\",\r\n"
				+ "			\"last_name\": \"kumar\",\r\n" + "			\"age\": 30,\r\n"
				+ "			\"salary\": 2000\r\n" + "		},\r\n" + "		{\r\n" + "			\"id\": 5,\r\n"
				+ "			\"first_name\": \"saurabh\",\r\n" + "			\"last_name\": \"kumar\",\r\n"
				+ "			\"age\": 30,\r\n" + "			\"salary\": 5000\r\n" + "		}\r\n" + "	]\r\n" + "}";

		JsonParser.parseString(json.replace("\r", "")).getAsJsonObject().getAsJsonArray("employee")
				.forEach(employee -> {
					if (employee.getAsJsonObject().get("salary").getAsInt() == 1000) {
						System.out.println(employee.getAsJsonObject().get("first_name").getAsString());
					}
				});

	}
}
