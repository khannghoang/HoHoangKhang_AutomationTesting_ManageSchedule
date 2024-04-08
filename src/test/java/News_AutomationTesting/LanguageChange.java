package News_AutomationTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LanguageChange {
static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup(); // Cấu hình WebDriverManager để sử dụng trình điều khiển Chrome.
		driver = new ChromeDriver(); // Khởi tạo một đối tượng ChromeDriver để tương tác với trình duyệt Chrome.
		driver.get("https://www.vietnamplus.vn/"); // Mở trang web "https://www.vietnamplus.vn/" trong trình duyệt.
		driver.getTitle(); // Lấy tiêu đề của trang web hiện tại (tuy nhiên giá trị này không được gán vào biến nào hoặc in ra màn hình).

		// Chuyển đổi ngôn ngữ trên trang web thành Tiếng Việt và lấy tiêu đề của trang sau khi chuyển đổi.
		WebElement vietnameseLink = driver.findElement(By.linkText("Tiếng Việt")); // Tìm đối tượng link có chữ "Tiếng Việt".
		vietnameseLink.click(); // Click vào link để chuyển đổi ngôn ngữ.
		String vietnameseLanguage = driver.getTitle(); // Lấy tiêu đề của trang web sau khi đã chuyển sang ngôn ngữ Tiếng Việt.

		// Tương tự như trên, chuyển đổi ngôn ngữ thành Tiếng Anh và lấy tiêu đề của trang sau khi chuyển đổi.
		WebElement englishLink = driver.findElement(By.linkText("English"));
		englishLink.click();
		String englishLanguage = driver.getTitle();

		// Tương tự như trên, chuyển đổi ngôn ngữ thành Français và lấy tiêu đề của trang sau khi chuyển đổi.
		WebElement frenchLink = driver.findElement(By.linkText("Français"));
		frenchLink.click();
		String frenchLanguage = driver.getTitle();

		// Tương tự như trên, chuyển đổi ngôn ngữ thành Español và lấy tiêu đề của trang sau khi chuyển đổi.
		WebElement spanishLink = driver.findElement(By.linkText("Español"));
		spanishLink.click();
		String spanishLanguage = driver.getTitle();

		// Tương tự như trên, chuyển đổi ngôn ngữ thành 中文 và lấy tiêu đề của trang sau khi chuyển đổi.
		WebElement chineseLink = driver.findElement(By.linkText("中文"));
		chineseLink.click();
		String chineseLanguage = driver.getTitle();

		// Tương tự như trên, chuyển đổi ngôn ngữ thành Русский và lấy tiêu đề của trang sau khi chuyển đổi.
		WebElement russianLink = driver.findElement(By.linkText("Русский"));
		russianLink.click();
		String russianLanguage = driver.getTitle();

		// In ra tiêu đề của các trang sau khi chuyển đổi ngôn ngữ.
		System.out.println("Tiếng Việt: " + vietnameseLanguage);
		System.out.println("Français: " + frenchLanguage);
		System.out.println("Español: " + spanishLanguage);
		System.out.println("中文: " + chineseLanguage);
		System.out.println("Русский: " + russianLanguage);
		System.out.println("English: " + englishLanguage);

		Thread.sleep(3000); // Dừng chương trình trong 3 giây (3 giây = 3000 mili giây).
		driver.quit(); // Đóng trình duyệt và kết thúc quá trình thử nghiệm.

        }
    }

	


