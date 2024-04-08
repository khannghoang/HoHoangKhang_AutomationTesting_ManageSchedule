package News_AutomationTesting; // Khai báo tên package

import java.io.File; // Import class File để làm việc với tệp tin
import org.openqa.selenium.By; // Import class By để tìm các phần tử trong trang web
import org.openqa.selenium.WebDriver; // Import class WebDriver để tương tác với trình duyệt web
import org.openqa.selenium.WebElement; // Import class WebElement để đại diện cho các phần tử trên trang web
import org.openqa.selenium.chrome.ChromeDriver; // Import class ChromeDriver để sử dụng trình duyệt Chrome
import org.openqa.selenium.chrome.ChromeOptions; // Import class ChromeOptions để cấu hình tùy chọn cho trình duyệt Chrome
import org.testng.annotations.BeforeTest; // Import các annotation từ TestNG để thiết lập trước test
import org.testng.annotations.Test; // Import các annotation từ TestNG cho các test

import io.github.bonigarcia.wdm.WebDriverManager; // Import WebDriverManager để quản lý phiên bản WebDriver

public class LoginFailEmail { // Khai báo lớp LoginFailEmail
    public WebDriver driver; // Khai báo biến driver để sử dụng trình duyệt Chrome

    @BeforeTest // Annotation BeforeTest: được thực thi trước khi bất kỳ test nào trong lớp test được thực hiện
    public void setup() throws InterruptedException { // Phương thức setup, được thực hiện trước mỗi test
        WebDriverManager.chromedriver().setup(); // Thiết lập trình điều khiển ChromeDriver tự động với WebDriverManager
        ChromeOptions opt = new ChromeOptions(); // Tạo một đối tượng ChromeOptions để cấu hình tùy chọn trình duyệt Chrome
        opt.addExtensions(new File("C:\\Users\\AN515-45\\eclipse-workspace\\Project\\Extension\\uBlock Origin 1.56.0.0.crx")); // Thêm phần mở rộng uBlock Origin vào trình duyệt Chrome
        driver = new ChromeDriver(opt); // Khởi tạo một đối tượng ChromeDriver với tùy chọn đã thiết lập
        driver.manage().window().maximize(); // Mở cửa sổ trình duyệt lên cỡ tối đa
        driver.navigate().to("https://www.vietnamplus.vn/"); // Mở URL của trang web VietnamPlus
        Thread.sleep(2000); // Dừng 2 giây để đảm bảo trang web được tải hoàn toàn
    }

    @Test // Annotation Test: chỉ định rằng phương thức là một test case
    public void LoginFailEmail() throws InterruptedException { // Phương thức LoginFailEmail, là một test case
        // Click Đăng nhập
        driver.findElement(By.id("userprofile")).click();
        Thread.sleep(2000); // Dừng 2 giây để đảm bảo trang web được tải hoàn toàn

        // Nhập email và mật khẩu không hợp lệ
        driver.findElement(By.id("txtLoginEmail")).sendKeys("wkw2240@omeie.com");
        driver.findElement(By.id("txtLoginPassword")).sendKeys("wkw22403@omeie.com");
        driver.findElement(By.xpath("//*[@id=\"modal\"]/div[2]/button")).click();
        Thread.sleep(2000); // Dừng 2 giây để đảm bảo trang web được tải hoàn toàn

        // Tìm phần thông báo thất bại
        WebElement noticeFail = driver.findElement(By.xpath("//*[@id=\"modal\"]/div[2]x1"));
        String thongbao = noticeFail.getText(); // Lấy nội dung thông báo

        // Kiểm tra thông báo để xác định kết quả
        String chuoimongdoiString = "Email chưa được đăng ký. Hãy tạo tài khoản.";
        if (thongbao.contentEquals(chuoimongdoiString)) {
            System.out.println("Login Fail Email: Pass"); // In ra màn hình nếu test case pass
        } else {
            System.out.println("Fail"); // In ra màn hình nếu test case fail
        }
        driver.close(); // Đóng trình duyệt sau khi test case hoàn thành
    }
}
