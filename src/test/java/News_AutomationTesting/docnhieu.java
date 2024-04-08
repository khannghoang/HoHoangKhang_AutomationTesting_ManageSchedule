package News_AutomationTesting;
import java.io.File;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class docnhieu {
	public WebDriver driver;
//	Random random = new Random();
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
	public void xem() throws InterruptedException {
		driver.get("https://www.vietnamplus.vn/");
		Thread.sleep(2000);
		WebElement clickElement = driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/div[3]/div[1]/div[3]/h3/a"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickElement); //click infographic
		WebElement clickWebElement = driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div[1]/div/article[1]/h2/a"));
		Thread.sleep(2000);
		String ketquamongString = clickWebElement.getText();
		driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div[1]/div/article[1]/h2/a")).click();
		String ketquathucteString = driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/h1")).getText();
		System.out.println("kết quả mong đợi" + ketquamongString);
		System.out.println("Kết quả thực tế" + ketquathucteString);
		driver.close();
	}
}