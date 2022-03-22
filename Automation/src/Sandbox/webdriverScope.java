package Sandbox;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class webdriverScope {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C://Users//User//Desktop//Automation//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//to get the count of links we are using tagname 
		int size= driver.findElements(By.tagName("a")).size();
		System.out.println(size);
		WebElement footerdriver= driver.findElement(By.id("gf-BIG"));
		//displaying count of links in footer 
		int footerLinks= footerdriver.findElements(By.tagName("a")).size();
		System.out.println(footerLinks);
		//displaying count of link in particular section in footer
		WebElement footerDriverPart = footerdriver.findElement(By.xpath("//table[@class='gf-t']//td[1]"));
		int cloumnLinks  = footerDriverPart.findElements(By.tagName("a")).size();
		//to click on each link
		for (int i=1; i < cloumnLinks; i++)
		{
			//inorder to open link in new tab we need to select control and then click on the link for that we are using keyboard 
			//selecting contro key and then enter 
			String newTab= Keys.chord(Keys.CONTROL, Keys.ENTER);
			
			footerDriverPart.findElements(By.tagName("a")).get(i).sendKeys(newTab);
			Thread.sleep(3000);
			//whenever we are using keyboad we need to pass those variables using sendkeys
			// inorder to get the titles of each page we need to iterate from one page to other
		}
			Set<String> move = driver.getWindowHandles();
			Iterator<String> it = move.iterator();
			//for many tabs we are looping the code using while or for loop
			while(it.hasNext())//hasnext method will verify if there is any next window 
			{
				//switching to next window
				driver.switchTo().window(it.next());
				System.out.println(driver.getTitle());
			}
		

	}

}
