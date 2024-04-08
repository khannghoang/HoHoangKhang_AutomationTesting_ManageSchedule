package News_AutomationTesting;

import java.io.File;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewsInplace {
	 public WebDriver driver;

	    @BeforeTest
	   	public void setup() throws InterruptedException {
	   		WebDriverManager.chromedriver().setup();
	   		ChromeOptions options = new ChromeOptions();
	   		options.addExtensions(
	   		new File("C:\\Users\\AN515-45\\eclipse-workspace\\Project\\Extension\\uBlock Origin 1.56.0.0.crx"));
	   		driver = new ChromeDriver(options);
	   		driver.get("https://www.vietnamplus.vn/");
	   		driver.manage().window().maximize();
	   		Thread.sleep(4000);
	   	}
	    
	    @Test
	    public void xemtrangkhuvuc() throws InterruptedException {
	    	 driver.get("https://www.vietnamplus.vn/");
	    	  Thread.sleep(5000);
	    	  try {
	  			WebElement scroll = driver
	  					.findElement(By.xpath("/html/body/div[3]/div/div[8]/div[1]/div[2]/h3/a"));
	  			Actions action = new Actions(driver);
	  			action.moveToElement(scroll).perform();
	  			Thread.sleep(4000);
	  		} catch (Exception e) {
	  			// TODO: handle exception
	  			WebElement scroll = driver
	  					.findElement(By.xpath("/html/body/div[3]/div/div[8]/div[1]/div[2]/h3/a"));
	  			Actions action = new Actions(driver);
	  			action.moveToElement(scroll).perform();
	  			Thread.sleep(4000);
	  		}
	    	  
	    	  
	    	  Thread.sleep(2000);
	    	  WebElement droplist=driver.findElement(By.id("ddlProvince"));
	    	  droplist.click();
	    	  
	    	  Random random = new Random();
	    	  int chonkhuvuc= random.nextInt(2,252);
	    	  WebElement chonkhuvucElement = driver.findElement(By.xpath("/html/body/div[3]/div/div[8]/div[1]/div[1]/div[1]/div/select/option["+chonkhuvuc+"]"));
	    	  String ketquamongdoiString = chonkhuvucElement.getText();
	    	  chonkhuvucElement.click();
	    	  WebElement khuduocchon = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/h1/a"));
	    	  String ketquathucte = khuduocchon.getText();
	    	  System.out.println("Kết quả mong đợi: " + ketquamongdoiString);
	    	  System.out.println("Kết quả thực tế: "+ ketquathucte);
	    }
}
