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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Search_English {

    // Khai báo biến driver để sử dụng trong toàn bộ lớp
    public WebDriver driver;

    // Phương thức thiết lập trước mỗi bài kiểm tra
    @BeforeTest
    public void setup() throws InterruptedException {
        // Thiết lập trình điều khiển Chrome
        WebDriverManager.chromedriver().setup(); // Cài đặt WebDriver cho Chrome
        ChromeOptions opt = new ChromeOptions(); // Khởi tạo một số tùy chọn cho trình duyệt Chrome
        opt.addExtensions(new File("C:\\Users\\AN515-45\\eclipse-workspace\\Project\\Extension\\uBlock Origin 1.56.0.0.crx")); // Thêm extension cho trình duyệt Chrome
        driver = new ChromeDriver(opt); // Khởi tạo trình duyệt Chrome với các tùy chọn đã cấu hình
        driver.manage().window().maximize(); // Phóng to cửa sổ trình duyệt

        // Mở trang web https://vietnamplus.vn/
        driver.get("https://vietnamplus.vn/");

        // Mở rộng cửa sổ trình duyệt

        // Tạm dừng chương trình trong 2 giây
        Thread.sleep(2000);
    }
    @Test
    public void Search() throws InterruptedException {
        // Truy cập vào trang web En-Vie tnamPlus .
        driver.get("https://en.vietnamplus.vn/");
        
        // Tìm ô tìm kiếm có thẻ a để thực hiện tìm kiếm và click vào đó bằng JavaScript.
        WebElement clickSearch = driver.findElement(By.xpath("/html/body/div/header/div[2]/div[1]/div[2]/a"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickSearch);

        //Input để nhập từ khóa tìm kiếm "Wood".
        driver.findElement(By.xpath("/html/body/div/header/div[2]/div[1]/div[2]/input")).sendKeys("Wood");
        
        // Tìm và click vào nút tìm kiếm.
        driver.findElement(By.xpath("/html/body/div/header/div[2]/div[1]/div[2]/a/i")).click();
        // Tạm dừng chương trình trong 2 giây
        Thread.sleep(2000);
    }
    
    @AfterTest
    public void AfterTest() {
    	// Đóng chương trình
    	driver.close();
    }
}