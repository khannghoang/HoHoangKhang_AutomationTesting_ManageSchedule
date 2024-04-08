package QuanLyNguoiDung;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteUser {
	static WebDriver driver;

	@BeforeTest
	public void setup() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		String chromeProfilePath = "C:\\Users\\AN515-45\\AppData\\Local\\Google\\Chrome\\User Data";
		ChromeOptions options = new ChromeOptions();
		options.addArguments("user-data-dir=" + chromeProfilePath);
		driver = new ChromeDriver(options);
		driver.get("https://cntttest.vanlanguni.edu.vn:18081/Phancong02/");
		driver.findElement(By.id("OpenIdConnect")).click();
	}
	
	@Test
	public void Action() throws InterruptedException {
	    // Dừng chương trình trong 4 giây
	    Thread.sleep(4000);
	    
	    // Click vào một đường dẫn trong trang web bằng xpath
	    driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[3]/a")).click();
	    
	    // Dừng chương trình trong 2 giây
	    Thread.sleep(2000);
	    
	    // Tìm và nhập dữ liệu vào ô tìm kiếm trên trang web
	    driver.findElement(By.xpath("//*[@id=\"tblUser_filter\"]/label/input")).sendKeys("Random Name");
	    
	    // Dừng chương trình trong 2 giây
	    Thread.sleep(2000);
	    
	    // Click vào một liên kết trong trang web bằng xpath
	    driver.findElement(By.xpath("//*[@id=\"tblUser\"]/tbody/tr/td[7]/a[2]")).click();
	    
	    // Dừng chương trình trong 2 giây
	    Thread.sleep(2000);
	    
	    // Click vào một nút trên trang web bằng xpath
	    driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[1]")).click();
	    
	    // In ra thông báo xóa người dùng thành công
	    System.out.println("Xóa người dùng thành công");
	}
	@AfterTest
	public void Close() {
		driver.close();
	}
}
