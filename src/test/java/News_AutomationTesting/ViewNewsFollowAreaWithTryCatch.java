package News_AutomationTesting;
import java.io.File; // Import thư viện để làm việc với File
import java.util.NoSuchElementException;
import java.util.Random; // Import thư viện để sử dụng lớp Random

import org.openqa.selenium.By; // Import các lớp từ gói org.openqa.selenium để tương tác với các phần tử trên trình duyệt
import org.openqa.selenium.WebDriver; // Import lớp WebDriver từ gói org.openqa.selenium để điều khiển trình duyệt
import org.openqa.selenium.WebElement; // Import lớp WebElement từ gói org.openqa.selenium để tương tác với các phần tử web
import org.openqa.selenium.chrome.ChromeDriver; // Import lớp ChromeDriver từ gói org.openqa.selenium.chrome để điều khiển trình duyệt Chrome
import org.openqa.selenium.chrome.ChromeOptions; // Import lớp ChromeOptions từ gói org.openqa.selenium.chrome để cấu hình tùy chọn cho trình duyệt Chrome
import org.testng.annotations.AfterTest; // Import annotation AfterTest từ gói org.testng.annotations để thiết lập việc thực thi sau mỗi bài kiểm tra
import org.testng.annotations.BeforeTest; // Import annotation BeforeTest từ gói org.testng.annotations để thiết lập việc thực thi trước mỗi bài kiểm tra
import org.testng.annotations.Test; // Import annotation Test từ gói org.testng.annotations để đánh dấu phương thức là một bài kiểm tra

import io.github.bonigarcia.wdm.WebDriverManager; // Import lớp WebDriverManager từ gói io.github.bonigarcia.wdm để quản lý trình điều khiển trình duyệt

public class ViewNewsFollowAreaWithTryCatch {
    public WebDriver driver; // Khai báo biến driver kiểu WebDriver để điều khiển trình duyệt

    // Phương thức thiết lập trước mỗi bài kiểm tra
    @BeforeTest
    public void setup() throws InterruptedException {
        // Thiết lập trình điều khiển Chrome
    	  WebDriverManager.chromedriver().setup(); // Thiết lập trình điều khiển ChromeDriver tự động với WebDriverManager
          ChromeOptions opt = new ChromeOptions(); // Tạo một đối tượng ChromeOptions để cấu hình tùy chọn trình duyệt Chrome
          opt.addExtensions(new File("C:\\Users\\AN515-45\\eclipse-workspace\\Project\\Extension\\uBlock Origin 1.56.0.0.crx")); // Thêm phần mở rộng uBlock Origin vào trình duyệt Chrome
          driver = new ChromeDriver(opt); // Khởi tạo một đối tượng ChromeDriver với tùy chọn đã thiết lập
          driver.manage().window().maximize(); // Mở cửa sổ trình duyệt lên cỡ tối đa
          Thread.sleep(5000); // Dừng 5 giây để chờ trang web được tải hoàn toàn
          driver.navigate().to("https://www.vietnamplus.vn/"); // Mở URL của trang web VietnamPlus
          Thread.sleep(2000); // Dừng 2 giây để đảm bảo trang web được tải hoàn toàn

        // Mở rộng cửa sổ trình duyệt
        driver.manage().window().maximize();

        // Tạm dừng chương trình trong 2 giây
        Thread.sleep(2000);

        // Mở trang web https://www.vietnamplus.vn/region/tp-ho-chi-minh/126.vnp
        driver.get("https://www.vietnamplus.vn/region/tp-ho-chi-minh/126.vnp");

        // Tạm dừng chương trình trong 2 giây
        Thread.sleep(2000);

        // Tạo một số ngẫu nhiên để chọn khu vực
        Random khuvucRandom = new Random();
        int random64TinhThanh = khuvucRandom.nextInt(64) + 1;
        String xpathKV = "/html/body/div[2]/div/div[2]/div[2]/select/option["+random64TinhThanh+"]";

        // Click vào phần tử được chọn ngẫu nhiên
        driver.findElement(By.xpath(xpathKV)).click();

        // Lấy tiêu đề của trang web
        WebElement titleWeb = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/h1/a"));
        System.out.println("Chọn khu vực để xem báo: "+ titleWeb.getText());

        // Tạm dừng chương trình trong 3 giây
        Thread.sleep(3000);
    }

    @Test
    public void TestTryCatch() {
    	try {
    	    Random random = new Random();
    	    int rand = random.nextInt(6) + 1; // Chọn một trong số 6 xpath
    	    String RandomNews;

    	    switch(rand) {
    	        case 1:
    	        case 2:
    	            RandomNews = "/html/body/div[2]/div/div[4]/div[1]/article[" + rand + "]/h2/a"; 
    	            break;
    	        case 3:
    	        case 4:
    	            RandomNews = "/html/body/div[2]/div/div[4]/div[2]/article[" + (rand - 2) + "]/h2/a"; 
    	            break;
    	        case 5:
    	        case 6:
    	            RandomNews = "/html/body/div[2]/div/div[4]/div[3]/article[" + (rand - 4) + "]/h2/a"; 
    	            break;
    	        default:
    	            RandomNews = ""; // Trường hợp không hợp lệ
    	    }

    	    WebElement ChooseRandom = driver.findElement(By.xpath(RandomNews)); 
    	    ChooseRandom.click();
    	} catch (NoSuchElementException e) {
    	    // Xử lý ngoại lệ NoSuchElementException (nếu không tìm thấy phần tử)
    	    System.out.println("Không thể chọn được phần tử!");
    	} catch (Exception e) {
    	    // Xử lý mọi ngoại lệ khác (nếu có)
    	    e.printStackTrace();
    	}
    }

    // Phương thức sau mỗi bài kiểm tra
    @AfterTest
    public void  AfterTest() {
        // Đóng trình duyệt
        driver.close();
    }
}
