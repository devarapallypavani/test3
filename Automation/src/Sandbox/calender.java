package Sandbox;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class calender {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C://Users//User//Desktop//Automation//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.path2usa.com/travel-companions");
		Thread.sleep(3000);
		driver.findElement(By.id("travel_date")).click();
		//selecting months 
		driver.findElement(By.cssSelector(".datepicker-switch")).click();
		Thread.sleep(3000);
		//selecting years
		driver.findElement(By.cssSelector("[class='datepicker-months'] [class='datepicker-switch']")).click();
		
		driver.findElement(By.xpath("//span[text()='2022']")).click();
		//selecting month
		driver.findElement(By.xpath("//span[text()='Mar']")).click();

		
		//finding common element for date and storing in variable
		
		List<WebElement> dates=  driver.findElements(By.cssSelector(".day"));
		
		int count = driver.findElements(By.cssSelector(".day")).size();
		
		for (int i=0; i<count; i++)
		{
			String value = dates.get(i).getText();
			if (value.equalsIgnoreCase("23"))
			{
				dates.get(i).click();
				break;
			}
		}
	}

}
