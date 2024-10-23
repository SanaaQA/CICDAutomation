package ProjectLibrary;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import TestComponents.Basetest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteApp {
	public class Studio  
	{
		
		
	/*@Test
	public void login() throws InterruptedException
	{l1.signin();
	P4DeleteApps l2 = new P4DeleteApps(driver);
	l2.DeleteApp();*/
		
		
		@Test

		public void login() throws MalformedURLException, IOException {

				WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--remote-allow-origins=*");
				options.addArguments("headless");

				ChromeDriver driver = new ChromeDriver(options);
				driver.get("https://rahulshettyacademy.com/AutomationPractice/");  
				driver.manage().window().maximize();
				   List<WebElement> links=   driver.findElements(By.cssSelector("li[class='gf-li'] a"));

				      SoftAssert a =new SoftAssert();

				     

				      for(WebElement link : links)

				      {

				       

				          String url= link.getAttribute("href");

				         

				          HttpURLConnection   conn= (HttpURLConnection)new URL(url).openConnection();

				          conn.setRequestMethod("HEAD");

				          conn.connect();

				          int respCode = conn.getResponseCode();

				          System.out.println(respCode);

				          //a.assertTrue(respCode<400, "The link with Text"+link.getText()+" is broken with code" +respCode);

				         

				     

				      }

				     

				    //  a.assertAll();

				   
			}

		}

	
	}

