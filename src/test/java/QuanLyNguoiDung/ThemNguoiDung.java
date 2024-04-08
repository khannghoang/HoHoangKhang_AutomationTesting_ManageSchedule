package QuanLyNguoiDung;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.collect.Table.Cell;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ThemNguoiDung {
	static WebDriver driver;

	@BeforeTest
	public void setup() {
		String chromeProfilePath = "C:\\Users\\AN515-45\\AppData\\Local\\Google\\Chrome\\User Data";
		ChromeOptions options = new ChromeOptions();
		options.addArguments("user-data-dir=" + chromeProfilePath);
		driver = new ChromeDriver(options);
		driver.get("https://cntttest.vanlanguni.edu.vn:18081/Phancong02/");
		driver.findElement(By.id("OpenIdConnect")).click();
	}

	@Test(priority = 0)
	public void Actions() throws InterruptedException, IOException {

		System.out.println("Testcase 1: Thêm người dùng nhưng không điền mã giảng viên");
		
		FileInputStream fis = new FileInputStream("K:\\Automation\\AddUser.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		XSSFRow row = sheet.getRow(0);

		String fullname = row.getCell(1).getStringCellValue(); // Đọc giá trị của cột B (index 1) từ tệp Excel
		String email = row.getCell(2).getStringCellValue(); // Đọc giá trị của cột C (index 2) từ tệp Excel

		Thread.sleep(4000); // Dừng chương trình trong 4 giây

		// Click vào một đường dẫn trong trang web bằng xpath
		driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[3]/a")).click();
		Thread.sleep(2000); // Dừng chương trình trong 2 giây

		// Click vào một nút trên trang web bằng xpath
		driver.findElement(By.xpath("//*[@id=\"tblUser_wrapper\"]/div[1]/div[2]/div/div[2]/button")).click();
		Thread.sleep(2000); // Dừng chương trình trong 2 giây

		// Nhập giá trị fullname vào một trường input trên trang web bằng xpath
		driver.findElement(By.xpath("//*[@id=\"full_name\"]")).sendKeys(fullname);
		Thread.sleep(2000); // Dừng chương trình trong 2 giây

		// Nhập giá trị email vào một trường input trên trang web bằng xpath
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(email);

		// Tìm dropdown element và chọn giá trị "CH"
		WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"type\"]"));
		Select select = new Select(dropdown);
		select.selectByValue("CH");
		Thread.sleep(2000); // Dừng chương trình trong 2 giây

		// Tìm dropdown element khác và chọn giá trị "b8046948-0910-41f4-a79d-9474126fce12"
		WebElement dropdown2 = driver.findElement(By.xpath("//*[@id=\"role_id\"]"));
		Select select2 = new Select(dropdown2);
		select2.selectByValue("b8046948-0910-41f4-a79d-9474126fce12");
		Thread.sleep(2000); // Dừng chương trình trong 2 giây

		// Click vào một nút trên trang web bằng xpath
		driver.findElement(By.xpath("//*[@id=\"user-form\"]/div[7]/button[2]")).click();
		Thread.sleep(2000); // Dừng chương trình trong 2 giây

		// Tìm và lấy ra phần tử chứa thông báo lỗi bằng xpath
		WebElement errorElement = driver.findElement(By.xpath("//*[@id=\"staff_id-error\"]"));

		String ketquamongdoi = "Bạn chưa nhập mã giảng viên"; // Chuỗi kỳ vọng thông báo lỗi

		System.out.println("Kết quả mong đợi: " + ketquamongdoi); // In ra kết quả mong đợi
		System.out.println("Kết quả thực tế: " + errorElement.getText()); // In ra kết quả thực tế của thông báo lỗi


	}

	@Test(priority = 1)
	public void Actions2() throws InterruptedException, IOException {
		System.out.println("Testcase 2: Thêm người dùng nhưng không điền tên giảng viên");

		// Mở một FileInputStream để đọc tệp Excel từ đường dẫn đã cho
		FileInputStream fis = new FileInputStream("K:\\Automation\\AddUser.xlsx");

		// Tạo một đối tượng XSSFWorkbook để đại diện cho toàn bộ tệp Excel
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		// Lấy ra sheet đầu tiên từ workbook
		XSSFSheet sheet = workbook.getSheetAt(0);

		// Lấy ra hàng thứ 2 (index bắt đầu từ 0) từ sheet
		XSSFRow row = sheet.getRow(1);

		// Đọc giá trị từ cột A (index 0) từ hàng đã chọn và gán vào biến id
		int id = (int) row.getCell(0).getNumericCellValue();

		// Đọc giá trị từ cột C (index 2) từ hàng đã chọn và gán vào biến email
		String email = row.getCell(2).getStringCellValue();

		// Dừng chương trình trong 4 giây
		Thread.sleep(4000);

		// Click vào một đường dẫn trong trang web bằng xpath
		driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[3]/a")).click();
		Thread.sleep(2000); // Dừng chương trình trong 2 giây

		// Click vào một nút trên trang web bằng xpath
		driver.findElement(By.xpath("//*[@id=\"tblUser_wrapper\"]/div[1]/div[2]/div/div[2]/button")).click();
		Thread.sleep(2000); // Dừng chương trình trong 2 giây

		// Nhập giá trị id vào một trường input trên trang web bằng xpath
		driver.findElement(By.xpath("//*[@id=\"staff_id\"]")).sendKeys(String.valueOf(id));
		Thread.sleep(4000); // Dừng chương trình trong 4 giây

		// Nhập giá trị email vào một trường input trên trang web bằng xpath
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(email);

		// Tìm dropdown element và chọn giá trị "CH"
		WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"type\"]"));
		Select select = new Select(dropdown);
		select.selectByValue("CH");
		Thread.sleep(2000); // Dừng chương trình trong 2 giây

		// Tìm dropdown element khác và chọn giá trị "b8046948-0910-41f4-a79d-9474126fce12"
		WebElement dropdown2 = driver.findElement(By.xpath("//*[@id=\"role_id\"]"));
		Select select2 = new Select(dropdown2);
		select2.selectByValue("b8046948-0910-41f4-a79d-9474126fce12");
		Thread.sleep(2000); // Dừng chương trình trong 2 giây

		// Click vào một nút trên trang web bằng xpath
		driver.findElement(By.xpath("//*[@id=\"user-form\"]/div[7]/button[2]")).click();

		// Tìm và lấy ra phần tử chứa thông báo lỗi bằng xpath
		WebElement errorElement = driver.findElement(By.xpath("//*[@id=\"full_name-error\"]"));

		// Chuỗi kỳ vọng thông báo lỗi
		String expected = "Bạn chưa nhập tên giảng viên";

		// In ra kết quả mong đợi và kết quả thực tế của thông báo lỗi
		System.out.println("Kết quả mong đợi: " + expected);
		System.out.println("Kết quả thực tế: " + errorElement.getText());

		// Dừng chương trình trong 2 giây
		Thread.sleep(2000);
	}

	@Test(priority = 2)
	public void Actions3() throws InterruptedException, IOException {
		System.out.println("Testcase 3: Thêm người dùng nhưng email không hợp lệ");
		FileInputStream fis = new FileInputStream("K:\\Automation\\AddUser.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);

		XSSFRow row = sheet.getRow(2);

		int id = (int) row.getCell(0).getNumericCellValue(); // Đọc giá trị số nguyên từ cột A
		String fullname = row.getCell(1).getStringCellValue();
		String email = row.getCell(2).getStringCellValue();

		Thread.sleep(4000);

		// Click vào một đường dẫn trong trang web bằng xpath
		driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[3]/a")).click();
		Thread.sleep(2000);

		// Click vào một nút trên trang web bằng xpath
		driver.findElement(By.xpath("//*[@id=\"tblUser_wrapper\"]/div[1]/div[2]/div/div[2]/button")).click();
		Thread.sleep(2000);

		// Nhập giá trị id vào một trường input trên trang web bằng xpath
		driver.findElement(By.xpath("//*[@id=\"staff_id\"]"))
		      .sendKeys(String.valueOf(id)); // Chuyển số nguyên thành chuỗi
		Thread.sleep(4000);

		// Nhập giá trị fullname vào một trường input trên trang web bằng xpath
		driver.findElement(By.xpath("//*[@id=\"full_name\"]")).sendKeys(fullname);

		// Nhập giá trị email vào một trường input trên trang web bằng xpath
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(email);

		// Tìm dropdown element và chọn giá trị "CH"
		WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"type\"]"));
		Select select = new Select(dropdown);
		select.selectByValue("CH");
		Thread.sleep(2000);

		// Tìm dropdown element khác và chọn giá trị "b8046948-0910-41f4-a79d-9474126fce12"
		WebElement dropdown2 = driver.findElement(By.xpath("//*[@id=\"role_id\"]"));
		Select select2 = new Select(dropdown2);
		select2.selectByValue("b8046948-0910-41f4-a79d-9474126fce12");
		Thread.sleep(2000);

		// Click vào một nút trên trang web bằng xpath
		driver.findElement(By.xpath("//*[@id=\"user-form\"]/div[7]/button[2]")).click();
		Thread.sleep(2000);

		// Tìm và lấy ra phần tử chứa thông báo lỗi bằng xpath
		WebElement errorElement = driver.findElement(By.xpath("//*[@id=\"email-error\"]"));
		String expected = "Vui lòng nhập email Văn Lang hợp lệ!";

		System.out.println("Kết quả mong đợi: " + expected);
		System.out.println("Kết quả thực tế: " + errorElement.getText());
	}

	@Test(priority = 3)
	public void Actions4() throws InterruptedException, IOException {
		System.out.println("Testcase 4: Thêm người dùng nhưng không điền email;");

		FileInputStream fis = new FileInputStream("K:\\Automation\\AddUser.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		XSSFRow row = sheet.getRow(3);

		int id = (int) row.getCell(0).getNumericCellValue(); // Đọc giá trị số nguyên từ cột A
		String fullname = row.getCell(1).getStringCellValue();

		Thread.sleep(4000); // Dừng chương trình trong 4 giây

		// Click vào một đường dẫn trong trang web bằng xpath
		driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[3]/a")).click();
		Thread.sleep(2000); // Dừng chương trình trong 2 giây

		// Click vào một nút trên trang web bằng xpath
		driver.findElement(By.xpath("//*[@id=\"tblUser_wrapper\"]/div[1]/div[2]/div/div[2]/button")).click();
		Thread.sleep(2000); // Dừng chương trình trong 2 giây

		// Nhập giá trị id vào một trường input trên trang web bằng xpath
		driver.findElement(By.xpath("//*[@id=\"staff_id\"]"))
		      .sendKeys(String.valueOf(id)); // Chuyển số nguyên thành chuỗi
		Thread.sleep(4000); // Dừng chương trình trong 4 giây

		// Nhập giá trị fullname vào một trường input trên trang web bằng xpath
		driver.findElement(By.xpath("//*[@id=\"full_name\"]")).sendKeys(fullname);

		// Tìm dropdown element và chọn giá trị "CH"
		WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"type\"]"));
		Select select = new Select(dropdown);
		select.selectByValue("CH");
		Thread.sleep(2000); // Dừng chương trình trong 2 giây

		// Tìm dropdown element khác và chọn giá trị "b8046948-0910-41f4-a79d-9474126fce12"
		WebElement dropdown2 = driver.findElement(By.xpath("//*[@id=\"role_id\"]"));
		Select select2 = new Select(dropdown2);
		select2.selectByValue("b8046948-0910-41f4-a79d-9474126fce12");
		Thread.sleep(2000); // Dừng chương trình trong 2 giây

		// Click vào một nút trên trang web bằng xpath
		driver.findElement(By.xpath("//*[@id=\"user-form\"]/div[7]/button[2]")).click();
		Thread.sleep(2000); // Dừng chương trình trong 2 giây

		// Tìm và lấy ra phần tử chứa thông báo lỗi bằng xpath
		WebElement errorElement = driver.findElement(By.xpath("//*[@id=\"email-error\"]"));
		String expected = "Bạn chưa nhập email"; // Chuỗi kỳ vọng thông báo lỗi

		System.out.println("Kết quả mong đợi: " + expected); // In ra kết quả mong đợi
		System.out.println("Kết quả thực tế: " + errorElement.getText()); // In ra kết quả thực tế của thông báo lỗi

	}
	@Test(priority = 4)
	public void Actions5() throws InterruptedException, IOException {
		System.out.println("Testcase 5: Thêm người dùng nhưng điền ký tự đặc biệt");

		FileInputStream fis = new FileInputStream("K:\\Automation\\AddUser.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);

		XSSFRow row = sheet.getRow(4);

		String id = row.getCell(0).getStringCellValue(); // Đọc giá trị chuỗi từ cột A
		String fullname = row.getCell(1).getStringCellValue();
		String email = row.getCell(2).getStringCellValue();

		Thread.sleep(4000); // Dừng chương trình trong 4 giây

		// Click vào một đường dẫn trong trang web bằng xpath
		driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[3]/a")).click();
		Thread.sleep(2000); // Dừng chương trình trong 2 giây

		// Click vào một nút trên trang web bằng xpath
		driver.findElement(By.xpath("//*[@id=\"tblUser_wrapper\"]/div[1]/div[2]/div/div[2]/button")).click();
		Thread.sleep(2000); // Dừng chương trình trong 2 giây

		// Nhập giá trị id vào một trường input trên trang web bằng xpath
		driver.findElement(By.xpath("//*[@id=\"staff_id\"]")).sendKeys(String.valueOf(id));
		Thread.sleep(4000); // Dừng chương trình trong 4 giây

		// Nhập giá trị fullname vào một trường input trên trang web bằng xpath
		driver.findElement(By.xpath("//*[@id=\"full_name\"]")).sendKeys(fullname);

		// Nhập giá trị email vào một trường input trên trang web bằng xpath
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(email);

		// Tìm dropdown element và chọn giá trị "CH"
		WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"type\"]"));
		Select select = new Select(dropdown);
		select.selectByValue("CH");
		Thread.sleep(2000); // Dừng chương trình trong 2 giây

		// Tìm dropdown element khác và chọn giá trị "b8046948-0910-41f4-a79d-9474126fce12"
		WebElement dropdown2 = driver.findElement(By.xpath("//*[@id=\"role_id\"]"));
		Select select2 = new Select(dropdown2);
		select2.selectByValue("b8046948-0910-41f4-a79d-9474126fce12");
		Thread.sleep(2000); // Dừng chương trình trong 2 giây

		// Click vào một nút trên trang web bằng xpath
		driver.findElement(By.xpath("//*[@id=\"user-form\"]/div[7]/button[2]")).click();
		Thread.sleep(2000); // Dừng chương trình trong 2 giây

		// Tìm và lấy ra phần tử chứa thông báo lỗi bằng xpath
		WebElement errorElement = driver.findElement(By.xpath("//*[@id=\"staff_id-error\"]"));
		String expected = "Chỉ được nhập số-chữ không dấu và không có khoảng trắng!"; // Chuỗi kỳ vọng thông báo lỗi

		System.out.println("Kết quả mong đợi: " + expected); // In ra kết quả mong đợi
		System.out.println("Kết quả thực tế: " + errorElement.getText()); 
	}
	@Test(priority = 5)
	public void Actions6() throws InterruptedException, IOException {
		System.out.println("Testcase 6: Thêm người dùng đúng thông tin");
		// Mở một FileInputStream để đọc tệp Excel từ đường dẫn đã cho
		FileInputStream fis = new FileInputStream("K:\\Automation\\AddUser.xlsx");

		// Tạo một đối tượng XSSFWorkbook để đại diện cho toàn bộ tệp Excel
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		// Lấy ra sheet đầu tiên từ workbook
		XSSFSheet sheet = workbook.getSheetAt(0);

		// Lấy ra hàng thứ 9 (index bắt đầu từ 0) từ sheet
		XSSFRow row = sheet.getRow(8);

		// Đọc giá trị từ cột A (index 0) từ hàng đã chọn và gán vào biến id
		String id = row.getCell(0).getStringCellValue();

		// Đọc giá trị từ cột B (index 1) từ hàng đã chọn và gán vào biến fullname
		String fullname = row.getCell(1).getStringCellValue();

		// Đọc giá trị từ cột C (index 2) từ hàng đã chọn và gán vào biến email
		String email = row.getCell(2).getStringCellValue();

		// Dừng chương trình trong 4 giây (đang sử dụng sleep, không khuyến khích trong việc tự động hóa thực tế)
		Thread.sleep(4000);

		// Click vào một đường dẫn trong trang web bằng xpath
		driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[3]/a")).click();

		// Dừng chương trình trong 2 giây
		Thread.sleep(2000);

		// Click vào một nút trên trang web bằng xpath
		driver.findElement(By.xpath("//*[@id=\"tblUser_wrapper\"]/div[1]/div[2]/div/div[2]/button")).click();

		// Dừng chương trình trong 2 giây
		Thread.sleep(2000);

		// Nhập giá trị id vào một trường input trên trang web bằng xpath
		driver.findElement(By.xpath("//*[@id=\"staff_id\"]"))
		      .sendKeys(String.valueOf(id)); // Chuyển số nguyên thành chuỗi

		// Dừng chương trình trong 4 giây
		Thread.sleep(4000);

		// Nhập giá trị id vào một trường input trên trang web bằng id
		driver.findElement(By.id("staff_id")).sendKeys(id);

		// Dừng chương trình trong 2 giây
		Thread.sleep(2000);

		// Nhập giá trị fullname vào một trường input trên trang web bằng xpath
		driver.findElement(By.xpath("//*[@id=\"full_name\"]")).sendKeys(fullname);

		// Dừng chương trình trong 2 giây
		Thread.sleep(2000);

		// Nhập giá trị email vào một trường input trên trang web bằng xpath
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(email);

		// Tìm dropdown element và chọn giá trị "CH"
		WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"type\"]"));
		Select select = new Select(dropdown);
		select.selectByValue("CH");
		Thread.sleep(2000);

		// Tìm dropdown element khác và chọn giá trị "b8046948-0910-41f4-a79d-9474126fce12"
		WebElement dropdown2 = driver.findElement(By.xpath("//*[@id=\"role_id\"]"));
		Select select2 = new Select(dropdown2);
		select2.selectByValue("b8046948-0910-41f4-a79d-9474126fce12");
		Thread.sleep(2000);

		// Click vào một nút trên trang web bằng xpath
		driver.findElement(By.xpath("//*[@id=\"user-form\"]/div[7]/button[2]")).click();
		Thread.sleep(2000);
		
		System.out.println("Thêm Người Dùng Thành Công");
		

	}

	@AfterTest
	public void Close() {
		driver.close();
	}
}
