package Sandbox;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class actionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C://Users//User//Desktop//Automation//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		//actions class
		Actions a = new Actions(driver);
		//build means that action is ready to execute and perform means that action is executed 
		a.moveToElement(driver.findElement(By.xpath("//div[@id='nav-tools']/a[2]"))).build().perform();
		WebElement text = driver.findElement(By.id("twotabsearchtextbox"));
		//writing the text
		//clicking on the search tab and holding the shift button to enter the text in caps
		a.moveToElement(text).click().keyDown(Keys.SHIFT).sendKeys("mobile").build().perform();

	}

}
