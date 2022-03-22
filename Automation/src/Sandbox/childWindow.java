package Sandbox;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.chrome.ChromeDriver;

public class childWindow {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C://Users//User//Desktop//Automation//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@class='blinkingText']")).click();
		
		//get the indexes of the windows
		// it will be storing in string 
		Set<String> index = driver.getWindowHandles(); 
		Iterator<String> a = index.iterator();//iterating to the windows using index variable
		String parentId= a.next();
		String childId= a.next();
		//switching to the child window using id 
		driver.switchTo().window(childId);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
		//splitting the text using space and retrieving 5 element(4)
		String email= driver.findElement(By.cssSelector(".im-para.red")).getText().split(" ")[4];
		System.out.println(email);
		//switching to the parent window
		driver.switchTo().window(parentId);
		driver.findElement(By.id("username")).sendKeys(email);
	}

}
