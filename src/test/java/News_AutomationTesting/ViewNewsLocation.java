package News_AutomationTesting; // Khai báo tên package

import java.io.File; // Import class File để làm việc với tệp tin
import java.util.Random; // Import class Random để tạo số ngẫu nhiên
import org.openqa.selenium.By; // Import class By để tìm các phần tử trong trang web
import org.openqa.selenium.WebDriver; // Import class WebDriver để tương tác với trình duyệt web
import org.openqa.selenium.WebElement; // Import class WebElement để đại diện cho các phần tử trên trang web
import org.openqa.selenium.chrome.ChromeDriver; // Import class ChromeDriver để sử dụng trình duyệt Chrome
import org.openqa.selenium.chrome.ChromeOptions; // Import class ChromeOptions để cấu hình tùy chọn cho trình duyệt Chrome
import org.openqa.selenium.support.ui.Select; // Import class Select để làm việc với dropdown
import org.testng.annotations.BeforeTest; // Import các annotation từ TestNG để thiết lập trước test
import org.testng.annotations.Test; // Import các annotation từ TestNG cho các test

import io.github.bonigarcia.wdm.WebDriverManager; // Import WebDriverManager để quản lý phiên bản WebDriver

public class ViewNewsLocation { // Khai báo lớp ViewNewsLocation
    static WebDriver driver; // Khai báo biến driver để sử dụng trong toàn bộ lớp

    @BeforeTest // Annotation BeforeTest: được thực thi trước khi bất kỳ test nào trong lớp test được thực hiện
    public void setup() throws InterruptedException { // Phương thức setup, được thực hiện trước mỗi test
        WebDriverManager.chromedriver().setup(); // Thiết lập trình điều khiển ChromeDriver tự động với WebDriverManager
        ChromeOptions opt = new ChromeOptions(); // Tạo một đối tượng ChromeOptions để cấu hình tùy chọn trình duyệt Chrome
        opt.addExtensions(new File("C:\\Users\\AN515-45\\eclipse-workspace\\Project\\Extension\\uBlock Origin 1.56.0.0.crx")); // Thêm phần mở rộng uBlock Origin vào trình duyệt Chrome
        driver = new ChromeDriver(opt); // Khởi tạo một đối tượng ChromeDriver với tùy chọn đã thiết lập
        driver.manage().window().maximize(); // Mở cửa sổ trình duyệt lên cỡ tối đa
        Thread.sleep(5000); // Dừng 5 giây để chờ trang web được tải hoàn toàn
        driver.navigate().to("https://www.vietnamplus.vn/"); // Mở URL của trang web VietnamPlus
        Thread.sleep(2000); // Dừng 2 giây để đảm bảo trang web được tải hoàn toàn
    }

    @Test // Annotation Test: chỉ định rằng phương thức là một test case
    public void ViewNewsLocation() throws InterruptedException { // Phương thức ViewNewsLocation, là một test case
        driver.findElement(By.xpath("/html/body/header/div/div/i[1]")).click(); // Tìm phần tử bằng XPath và click vào nút để mở menu
        Random random = new Random(); // Khởi tạo một đối tượng Random để tạo số ngẫu nhiên
        int rand = random.nextInt(2) + 1; // Sinh số ngẫu nhiên từ 1 đến 2

        String RandomNews = "/html/body/div[5]/ul/li[20]/ul/li[" + rand + "]/a"; // Tạo XPath để chọn tin tức ngẫu nhiên từ menu
        WebElement ChooseRandom = driver.findElement(By.xpath(RandomNews)); // Tìm phần tử tin tức ngẫu nhiên để click
        ChooseRandom.click(); // Click vào tin tức ngẫu nhiên
        Thread.sleep(2000); // Dừng 2 giây để đảm bảo trang tin tức được tải hoàn toàn

        WebElement dropdown = driver.findElement(By.id("location-select")); // Tìm dropdown theo id
        Select select = new Select(dropdown); // Khởi tạo một đối tượng Select với dropdown đã tìm thấy
        select.selectByValue("379"); // Chọn giá trị trong dropdown có giá trị là "379" (đây là giá trị của một địa điểm cụ thể)
        Thread.sleep(2000); // Dừng 2 giây để đảm bảo dữ liệu được tải hoàn toàn

        WebElement text = driver.findElement(By.xpath("/html/body/div[2]/div/div[4]/article/h2")); // Tìm tiêu đề tin tức
        String PrintText = text.getText(); // Lấy văn bản của tiêu đề tin tức
        System.out.println(PrintText); // In tiêu đề tin tức ra màn hình
    }
}
