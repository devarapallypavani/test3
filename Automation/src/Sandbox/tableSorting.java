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

public class tableSorting {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C://Users//User//Desktop//Automation//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		// in order to sort and match with the expected values in table 
		// first we need to click an the veg/fruit name
		// store the elements in a list (original list)
		// apply sort to that original list (sorted list)
		// if sorted list matches with the original list 
		// then sorting is happening when we are clicking in veg/fruit names
		
		driver.findElement(By.xpath("//a[text()='Top Deals']")).click();
		Thread.sleep(3000);
		// clicking on veg/fruit names
		
		Set<String> index = driver.getWindowHandles(); 
		Iterator<String> a = index.iterator();//iterating to the windows using index variable
		String parentId= a.next();
		String childId= a.next();
		
		driver.switchTo().window(childId);
		
		driver.findElement(By.xpath("//tr/th[1]")).click();
		Thread.sleep(3000);
		// storing the elements in a list
		
		List<WebElement> values = driver.findElements(By.xpath("//tbody/tr/td[1]"));
		
		// storing the result in originalList
		
		 List<String> originalList=  values.stream().map(s-> s.getText()).collect(Collectors.toList());
		 
		 System.out.println(originalList);
		 
		 List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		 
		 System.out.println(sortedList);
		 
		 Assert.assertTrue(originalList.equals(sortedList));
		 
		 // to get price of particular element which is on other page we need to click on the next and then we need to match 
		 // and get the price
		 // for iterating we are using do while loop because first we are searching and if we are not finding then we are moving to the next page
		 
		 List<String> price;
		 
		 do {
			 
			 List<WebElement> valuesList = driver.findElements(By.xpath("//tbody/tr/td[1]"));
			 
			 price =  valuesList.stream().filter(s-> s.getText().contains("Wheat")).map(s-> getPrice(s)).collect(Collectors.toList());
	
			 // to display price we can use foreach method from stream
		 
			 price.forEach(s-> System.out.println(s));
			 
			 // using if condition if the price.size() returns 0 if there is no match then we are clicking on next
		 
			 if (price.size()<1)
			 {
				 driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
			 }
		 
		 } while(price.size()<1);
		 
	}
// we are creating an method to get the price of beans 
	private static String getPrice(WebElement s) {
		// TODO Auto-generated method stub
		
		String price_1 = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return price_1;
	}

}
