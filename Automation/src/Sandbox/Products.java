package Sandbox;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Products {
	
	
	
	public void ItemsList(WebDriver driver, String[] requiredItems) {

		List<WebElement> products = driver.findElements(By.xpath("//h4[@class='product-name']"));
        System.out.println("hello");
		
		for (int i = 1; i < products.size(); i++) {
			int j = 0;

			// we are getting complete text and that text contains - 1kg which is not there
			// in our list
			// so we need to split the name and store the first array name and compare with
			// our requiredItems
			// we are splitting with - and left part is storing in 0 index and 1 part is
			// storing in 1 index
			// first name is having extra 0 so we are using trim() method to remove un
			// wanted 0 in left and right side
			
			
			String[] name = products.get(i).getText().split("-");
			String formattedName = name[0].trim();

			// converting array of strings to list of array
			// comparing with the product and selecting the particular itmes
			
			List itemsNeededList = Arrays.asList(requiredItems);

			if (itemsNeededList.contains(formattedName)) {
				// getting the index of cucumber and selecting that item
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if (j == requiredItems.length)
					break;
			}
		}
		

	}
	
	public void CartList(WebDriver driver)
	{
		
		driver.findElement(By.xpath("//a[@class='cart-icon']/img")).click();
		driver.findElement(By.xpath("//div[@class='action-block']/button")).click();
		driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[@class='promoBtn']")).click();
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();
	}


		

}
