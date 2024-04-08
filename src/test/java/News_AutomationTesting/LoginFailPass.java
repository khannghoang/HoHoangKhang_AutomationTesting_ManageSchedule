package News_AutomationTesting;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginFailPass {
 public WebDriver driver;
 
 @BeforeTest // Annotation BeforeTest: được thực thi trước khi bất kỳ test nào trong lớp test được thực hiện
 public void setup() throws InterruptedException { // Phương thức setup, được thực hiện trước mỗi test
     WebDriverManager.chromedriver().setup(); // Thiết lập trình điều khiển ChromeDriver tự động với WebDriverManager
     ChromeOptions opt = new ChromeOptions(); // Tạo một đối tượng ChromeOptions để cấu hình tùy chọn trình duyệt Chrome
     opt.addExtensions(new File("C:\\Users\\AN515-45\\eclipse-workspace\\Project\\Extension\\uBlock Origin 1.56.0.0.crx")); // Thêm phần mở rộng uBlock Origin vào trình duyệt Chrome
     driver = new ChromeDriver(opt); // Khởi tạo một đối tượng ChromeDriver với tùy chọn đã thiết lập
     driver.manage().window().maximize(); // Mở cửa sổ trình duyệt lên cỡ tối đa
     driver.get("https://www.vietnamplus.vn/"); // Mở URL của trang web VietnamPlus
     Thread.sleep(2000); // Dừng 2 giây để đảm bảo trang web được tải hoàn toàn
 }
 @Test
 public void LoginFailEmail() throws InterruptedException {
	// Click Đăng nhập
     driver.findElement(By.id("userprofile")).click();
     // Tài khoản
     Thread.sleep(2000);
     driver.findElement(By.id("txtLoginEmail")).sendKeys("wkw2240@omeie.com");
     driver.findElement(By.id("txtLoginPassword")).sendKeys("wkw22403@omeie.com");
     driver.findElement(By.xpath("//*[@id=\"modal\"]/div[2]/button")).click();
     Thread.sleep(2000);
     WebElement noticeFail = driver.findElement(By.xpath("/html/body/div[12]/div[2]/p"));
     String thongbao   = noticeFail.getText();
     String chuoimongdoiString = "Email chưa được đăng ký. Hãy tạo tài khoản.";
     if (thongbao.contentEquals(chuoimongdoiString)) {
		System.out.println("Login Fail Email: Pass");
	}
     else {
		System.out.println("Fail");
	}
     driver.close();
 }
 
}
