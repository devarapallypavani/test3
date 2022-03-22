package Sandbox;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("Hello World");
        System.setProperty("webdriver.chrome.driver","C://Users//User//Desktop//Automation//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        
        // login to url
        driver.get("https://www.spicejet.com/");
        //maximizing the browser
        driver.manage().window().maximize();
        //entering username and password
        driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-18u37iz r-1w6e6rj']/div[2]/div")).click();
        driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-13awgt0 r-18u37iz'][1]/div[1]//input")).sendKeys("BLR");
        driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-13awgt0 r-18u37iz'][1]/div[3]//input")).sendKeys("HYD");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-18u37iz r-19h5ruw r-184en5c']/div[1]/div[1]/div[1]/div[2]/div[2]")).click();
        System.out.println(driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-18u37iz r-19h5ruw r-184en5c']/div[1]/div[1]/div[1]")).getText());
        int i=1;
        while(i<5)
        {
        	driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-k8qxaj r-d9fdf6']/div[1]/div[2]/div[3]")).click();
        	i++;
        }
        
        System.out.println(driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-18u37iz r-19h5ruw r-184en5c']/div[1]/div[1]/div[1]")).getText());

	}
	
	
//	

}
