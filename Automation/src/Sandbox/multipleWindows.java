package Sandbox;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;

public class multipleWindows {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C://Users//User//Desktop//Automation//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		//switching or opening new window or tab
		driver.switchTo().newWindow(WindowType.TAB);
		
		driver.manage().window().maximize();
		
		// for moving courser to next tab we are using getwindowhandler method.. this method will get the index of windows/ tabs ans store in set 
		// iterator method is used to iterator to the windows
		// we are using next operator to get the next window id
		Set<String> index = driver.getWindowHandles(); 
		Iterator<String> a = index.iterator();//iterating to the windows using index variable
		String parentId= a.next();
		String childId= a.next();
		
		//switching to child window
		driver.switchTo().window(childId);
		
		driver.get("https://rahulshettyacademy.com/");
		
		String firstCourseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
		
		// switching to parent window
		
		driver.switchTo().window(parentId);
		// entering values in name field
		
		WebElement name = driver.findElement(By.xpath("//input[@name='name']"));
		name.sendKeys(firstCourseName);
		
		// to capture screenshot of webelement 
		
		File file = name.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(file, new File("C:\\Users\\User\\eclipse-workspace\\Automation\\screenshot\\webelement.jpg"));
		
		// to get height and width of webelement we are using getRect() method
		
		System.out.println(name.getRect().getDimension().getHeight());
		
		System.out.println(name.getRect().getDimension().getWidth());
		

	}

}
