package News_AutomationTesting;

import java.io.File;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Worldnewathome {

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
		Thread.sleep(2000);
	}
    
    @Test
    public void xemtinhegioi() throws InterruptedException {
    	// Kiểm tra chế độ xem tin thế giới trên trang chủ
    	  driver.get("https://www.vietnamplus.vn/");
    	  Thread.sleep(5000);
    	  try {
  			WebElement scroll = driver
  					.findElement(By.xpath("/html/body/div[3]/div/div[8]/div[1]/div[3]/h3/a"));
  			Actions action = new Actions(driver);
  			action.moveToElement(scroll).perform();
  			Thread.sleep(4000);
  		} catch (Exception e) {
  			// TODO: handle exception
  			WebElement scroll = driver
  					.findElement(By.xpath("/html/body/div[3]/div/div[8]/div[1]/div[3]/h3/a"));
  			Actions action = new Actions(driver);
  			action.moveToElement(scroll).perform();
  			Thread.sleep(4000);
  		}
    	  
    	  Random random = new Random();
    	  int randomnews= random.nextInt(4)+1;
    	  Thread.sleep(3000);
    	  WebElement baivietElement = driver.findElement(By.xpath("/html/body/div[3]/div/div[8]/div[1]/div[3]/div/article["+randomnews+"]/h2/a"));
    	  
    	  String ketquamondoi=baivietElement.getText();
    	  baivietElement.click();
//    	  baivietElement.click();
    	  Thread.sleep(5000);
    	  WebElement baivietdangxem= driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/h1"));
    	  String ketquathucte= baivietdangxem.getText();
    	  System.out.println("Kết quả mong đợi: "+ ketquamondoi);
    	  System.out.println("Kết quả thực tế: "+ketquathucte);
    	  driver.close();
    }
}
