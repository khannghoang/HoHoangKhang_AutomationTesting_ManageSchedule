package News_AutomationTesting;


import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BanTinDoiSong {
	static WebDriver driver;

	@BeforeClass
	public void beforeClass() throws InterruptedException {
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
	public void TC_04_usecookies() throws InterruptedException {
		WebElement acceptButton = driver.findElement(By.xpath("/html/body/header/div/div/i[1]"));
		acceptButton.click(); // Click vào nút chấp nhận
		Thread.sleep(2000);
		WebElement DoiSongButton = driver.findElement(By.xpath("/html/body/div[5]/ul/li[6]"));
		DoiSongButton.click(); 
		DoiSongButton.click();//click vào mục đời sống
		Thread.sleep(3000);
		WebElement getElement=driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div[1]/div/article[1]/h2/a"));
		getElement.click();
		WebElement teString=driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/h1"));
		String getString = teString.getText();
		System.out.println("Kết quả trang Web lấy được là: "+getString);
		
		
		
}
}