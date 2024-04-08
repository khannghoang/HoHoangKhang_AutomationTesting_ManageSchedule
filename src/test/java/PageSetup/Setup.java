package PageSetup;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Setup {
	public ChromeDriver setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        String chromeProfilePath = "C:\\Users\\AN515-45\\AppData\\Local\\Google\\Chrome\\User Data";
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + chromeProfilePath);
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://cntttest.vanlanguni.edu.vn:18081/Phancong02/");
     	driver.findElement(By.id("OpenIdConnect")).click();
        driver.manage().window().maximize();
        return driver;
    }
}
