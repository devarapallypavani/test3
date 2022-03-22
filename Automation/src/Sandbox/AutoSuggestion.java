package Sandbox;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestion {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("Hello World");
		System.setProperty("webdriver.chrome.driver", "C://Users//User//Desktop//Automation//chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// login to url
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		// maximizing the browser
		driver.manage().window().maximize();
		// for selecting radio button
		driver.findElement(By.xpath("//div[@id='travelOptions']/table/tbody/tr/td[2]/input")).click();
//        //for dynamic drop down
//        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
//        Thread.sleep(3000);
//        driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_originStation1_CTNR']  //a[@value='BLR']")).click();
//        Thread.sleep(3000);
//        driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR']  //a[@value='HYD']")).click();
//        // for dropdown
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(3000);
		int i = 1;
		while (i < 5) {
			driver.findElement(By.xpath("//div[@id='divpaxOptions']/div[1]/div[2]/span[3]")).click();
			i++;
		}
		// selection done button
		driver.findElement(By.id("btnclosepaxoption")).click();
		// auto suggestion
		driver.findElement(By.id("autosuggest")).sendKeys("Ind");
		// storing the webelements in results
		Thread.sleep(3000);
		List<WebElement> results = driver.findElements(By.xpath("//li[@class='ui-menu-item']/a"));
		// System.out.println(results);
		// comparing the webelement with the value what we want
		for (WebElement option : results) {
			// System.out.println(option);
			if (option.getText().equalsIgnoreCase("India")) {
				option.click();
				break;

			}
		}
		// for selecting check boxes
		driver.findElement(By.cssSelector("input[name*='friendsandfamily']")).click();
		System.out.println(driver.findElement(By.cssSelector("input[name*='friendsandfamily']")).isSelected());
		// to get count of number of check boxes in UI page
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
	}

}
