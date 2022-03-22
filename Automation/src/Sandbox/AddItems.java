package Sandbox;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AddItems {
	
	

	public static void main(String[] args) throws InterruptedException, IOException
	{
		
		String[] requiredItems = {"Cucumber", "Tomato", "Carrot"};
		
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C://Users//User//Desktop//Automation//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		
		
		//implict wait
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		//finding elements
		System.out.println("hello");
	     Products p1 = new Products();
         p1.ItemsList(driver, requiredItems);
		
		p1.CartList(driver);
		
		//to take screenshot we need to cast driver to screenshot 
		// taking the screenshot using src object
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		// to store the screenshot in our local 
		
		FileUtils.copyFile(src, new File("C:\\Users\\User\\eclipse-workspace\\Automation\\screenshot\\screenshot.jpg"));
		
	}

	
	
}
