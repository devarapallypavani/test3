package Sandbox;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class brokenUrl {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C://Users//User//Desktop//Automation//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		String url= driver.findElement(By.cssSelector("a[href*='soapui']")).getAttribute("href");
		// to call the url java already has inbuilt methods 
		
		HttpURLConnection click  =(HttpURLConnection) new URL(url).openConnection();
		//requesting for head response
		click.setRequestMethod("HEAD");
		//we are connecting to that response
		click.connect();
		// requesting to get the response code of that url
		click.getResponseCode();

	}

}
