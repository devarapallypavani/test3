package Sandbox;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

import org.openqa.selenium.By;

public class relativeLocatore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C://Users//User//Desktop//Automation//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		//locator for name 
		// to get the locator for name 
		//first will find for text box
		
		WebElement textBox = driver.findElement(By.xpath("//input[@name='name']")); 
		
		// locator for name
		
		String relativeLocator = driver.findElement(with(By.tagName("label")).above(textBox)).getText();
		
		System.out.println(relativeLocator);
		
		// passing values using relative locators
		
		WebElement dateOfBirth = driver.findElement(By.xpath("//label[text()='Date of Birth']"));
		//using below
		driver.findElement(with(By.tagName("input")).below(dateOfBirth)).click();
		// using left
		WebElement studentButton = driver.findElement(By.xpath("//label[text()='Date of Birth']"));
	
		driver.findElement(with(By.tagName("input")).toRightOf(studentButton)).click();
		
		// using left
		WebElement radio = driver.findElement(By.id("inlineRadio2"));
			
		String student = driver.findElement(with(By.tagName("label")).toLeftOf(radio)).getText();
		
		System.out.println(student);
		
	}

}
