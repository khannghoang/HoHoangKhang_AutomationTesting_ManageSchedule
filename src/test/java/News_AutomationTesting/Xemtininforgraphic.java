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

	public class Xemtininforgraphic {
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
		public void xem() throws InterruptedException {
			Thread.sleep(2000);
			WebElement clickElement = driver.findElement(By.xpath("//*[@id=\"sidebar-top-1\"]/div[2]/h3/a"));
			clickElement.click();
			clickElement.click();

			Thread.sleep(4000);
			Random rd = new Random();
			int randomValue = rd.nextInt(30);
			String xpathPC = "/html/body/div[2]/div/div[6]/div[1]/div/article["+randomValue+"]/h2/a";
			WebElement itemElement = driver.findElement(By.xpath(xpathPC));
			itemElement.click();
			 WebElement titlString=driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/h1"));
		        String texString = titlString.getText();
		        System.out.println("Tiêu đề Infographic lấy được là: " +texString);

			driver.close();
		}
	}
