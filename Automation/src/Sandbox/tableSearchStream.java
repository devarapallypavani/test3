package Sandbox;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class tableSearchStream {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C://Users//User//Desktop//Automation//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		
		driver.findElement(By.xpath("//a[text()='Top Deals']")).click();
		Thread.sleep(3000);
		// clicking on veg/fruit names
		
		// using switchTo method to iterate to chile window 
		Set<String> index = driver.getWindowHandles(); 
		Iterator<String> a = index.iterator();//iterating to the windows using index variable
		String parentId= a.next();
		String childId= a.next();
		
		driver.switchTo().window(childId);
		
		driver.findElement(By.id("search-field")).sendKeys("Rice");
		
		 List<WebElement> veg = driver.findElements(By.xpath("tr/td[1]"));
		 
		 //List<String> originalList=  veg.stream().map(s-> s.getText()).collect(Collectors.toList());
		 
		 //System.out.println(originalList);
		 
//		 List<WebElement> filteredResult= veg.stream().filter(veggie->veggie.getText().contains("Rice")).
//
//			        collect(Collectors.toList());
		 
		 List<WebElement> filteredResult = veg.stream().filter(s-> s.getText().contains("Rice")).collect(Collectors.toList());
		 
		 System.out.println(filteredResult);
		 
		 Assert.assertEquals(veg.size(), filteredResult.size());
		 
		 
	}

}
