package QuanLyNguoiDung;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

public class ChinhSuaNguoiDung {
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
		Thread.sleep(5000);
		System.out.println("Testcase 1: Chỉnh sửa người dùng nhưng không điền tên giảng viên");
		// Đọc dữ liệu từ tệp Excel
		FileInputStream fis = new FileInputStream("K:\\Automation\\UpdateUser.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		XSSFRow row = sheet.getRow(0);

		// Thực hiện các thao tác trên trang web để cập nhật người dùng
		// Bạn có thể thay đổi logic này tùy thuộc vào cách thức làm việc với trang web cụ thể
		// Trong ví dụ này, chỉ làm một số thao tác cơ bản mà không sử dụng dữ liệu từ tệp Excel

		// Click vào một liên kết trong trang web
		driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[3]/a")).click();
		Thread.sleep(2000);

		// Tìm và nhập dữ liệu vào ô tìm kiếm trên trang web
		driver.findElement(By.xpath("//*[@id=\"tblUser_filter\"]/label/input")).sendKeys("Testing Khang");
		Thread.sleep(2000);

		// Click vào một liên kết trong trang web
		driver.findElement(By.xpath("//*[@id=\"tblUser\"]/tbody/tr/td[7]/a[1]")).click();
		Thread.sleep(3000);

		// Xoá dữ liệu cũ trong ô nhập tên
		driver.findElement(By.id("full_name")).clear();

		// Chọn một giá trị trong dropdown list
		WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"type\"]"));
		Select select = new Select(dropdown);
		select.selectByValue("CH");
		Thread.sleep(2000);

		// Chọn một giá trị khác trong dropdown list
		WebElement dropdown2 = driver.findElement(By.xpath("//*[@id=\"role_id\"]"));
		Select select2 = new Select(dropdown2);
		select2.selectByValue("b8046948-0910-41f4-a79d-9474126fce12");
		Thread.sleep(2000);

		// Click vào một nút trong trang web
		driver.findElement(By.xpath("//*[@id=\"user-form\"]/div[7]/button[2]")).click();
		Thread.sleep(2000);

		// Tìm và lấy thông báo lỗi từ trang web
		WebElement errorElement = driver.findElement(By.xpath("//*[@id=\"full_name-error\"]"));
		String expected = "Bạn chưa nhập tên giảng viên";

		// In kết quả mong đợi và kết quả thực tế của thông báo lỗi
		System.out.println("Kết quả mong đợi: " + expected);
		System.out.println("Kết quả thực tế: " + errorElement.getText());

	}

	@Test(priority = 1)
	public void Actions2() throws InterruptedException, IOException {
		System.out.println("Testcase 2: Chỉnh sửa người dùng nhưng không điền mã giảng viên");
		Thread.sleep(5000);
		// Đọc dữ liệu từ tệp Excel
		FileInputStream fis = new FileInputStream("K:\\Automation\\UpdateUser.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);

		// Lấy ra hàng đầu tiên từ sheet (index bắt đầu từ 0)
		XSSFRow row = sheet.getRow(0);

		// Dừng chương trình trong 4 giây
		Thread.sleep(4000);

		// Thực hiện các thao tác trên trang web để cập nhật người dùng
		// Bạn có thể thay đổi logic này tùy thuộc vào cách thức làm việc với trang web cụ thể
		// Trong ví dụ này, chỉ làm một số thao tác cơ bản mà không sử dụng dữ liệu từ tệp Excel

		// Click vào một liên kết trong trang web
		driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[3]/a")).click();
		Thread.sleep(2000);

		// Tìm và nhập dữ liệu vào ô tìm kiếm trên trang web
		driver.findElement(By.xpath("//*[@id=\"tblUser_filter\"]/label/input")).sendKeys("Testing Khang");
		Thread.sleep(2000);

		// Click vào một liên kết trong trang web
		driver.findElement(By.xpath("//*[@id=\"tblUser\"]/tbody/tr/td[7]/a[1]")).click();
		Thread.sleep(2000);

		// Xoá dữ liệu trong ô nhập mã giảng viên
		driver.findElement(By.id("staff_id")).clear();
		Thread.sleep(2000);

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

		// Click vào một nút trong trang web
		driver.findElement(By.xpath("//*[@id=\"user-form\"]/div[7]/button[2]")).click();
		Thread.sleep(2000);

		// Tìm và lấy ra phần tử chứa thông báo lỗi từ trang web
		WebElement errorElement = driver.findElement(By.xpath("//*[@id=\"staff_id-error\"]"));
		String expected = "Bạn chưa nhập mã giảng viên";

		// In kết quả mong đợi và kết quả thực tế của thông báo lỗi
		System.out.println("Kết quả mong đợi: " + expected);
		System.out.println("Kết quả thực tế: " + errorElement.getText());

	}

	@Test(priority = 2)
	public void Actions3() throws InterruptedException, IOException {
		System.out.println("Testcase 3: Cập nhật người dùng nhưng không điền email");

		// Mở một FileInputStream để đọc tệp Excel từ đường dẫn đã cho
		FileInputStream fis = new FileInputStream("K:\\Automation\\UpdateUser.xlsx");

		// Tạo một đối tượng XSSFWorkbook để đại diện cho toàn bộ tệp Excel
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		// Lấy ra sheet đầu tiên từ workbook
		XSSFSheet sheet = workbook.getSheetAt(0);

		// Lấy ra hàng thứ 3 từ sheet (index bắt đầu từ 0)
		XSSFRow row = sheet.getRow(2);

		// Dừng chương trình trong 4 giây (đang sử dụng sleep, không khuyến khích trong việc tự động hóa thực tế)
		Thread.sleep(4000);

		// Click vào một đường dẫn trong trang web bằng xpath
		driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[3]/a")).click();
		Thread.sleep(2000);

		// Tìm và nhập dữ liệu vào ô tìm kiếm trên trang web
		driver.findElement(By.xpath("//*[@id=\"tblUser_filter\"]/label/input")).sendKeys("Testing Khang");
		Thread.sleep(2000);

		// Click vào một liên kết trong trang web bằng xpath
		driver.findElement(By.xpath("//*[@id=\"tblUser\"]/tbody/tr[1]/td[7]/a[1]")).click();
		Thread.sleep(2000);

		// Xoá dữ liệu trong ô nhập email
		driver.findElement(By.id("email")).clear();

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

		// Định nghĩa chuỗi kỳ vọng thông báo lỗi
		String expected = "Bạn chưa nhập email";

		// In ra kết quả mong đợi và kết quả thực tế của thông báo lỗi
		System.out.println("Kết quả mong đợi: " + expected);
		System.out.println("Kết quả thực tế: " + errorElement.getText());
	}

	@Test(priority = 3)
	public void Actions4() throws InterruptedException, IOException {
		System.out.println("Testcase 4: Cập nhật người dùng nhưng điền ký tự đặc biệt vào mã giảng viên");

		// Mở một FileInputStream để đọc tệp Excel từ đường dẫn đã cho
		FileInputStream fis = new FileInputStream("K:\\Automation\\AddUser.xlsx");

		// Tạo một đối tượng XSSFWorkbook để đại diện cho toàn bộ tệp Excel
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		// Lấy ra sheet đầu tiên từ workbook
		XSSFSheet sheet = workbook.getSheetAt(0);

		// Lấy ra hàng thứ 5 từ sheet (index bắt đầu từ 0)
		XSSFRow row = sheet.getRow(4);

		// Đọc giá trị từ cột A (index 0) từ hàng đã chọn và gán vào biến id
		String id = row.getCell(0).getStringCellValue();

		// Dừng chương trình trong 4 giây (đang sử dụng sleep, không khuyến khích trong việc tự động hóa thực tế)
		Thread.sleep(4000);

		// Click vào một đường dẫn trong trang web bằng xpath
		driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[3]/a")).click();
		Thread.sleep(2000);

		// Tìm và nhập dữ liệu vào ô tìm kiếm trên trang web
		driver.findElement(By.xpath("//*[@id=\"tblUser_filter\"]/label/input")).sendKeys("Testing Khang");
		Thread.sleep(2000);

		// Click vào một liên kết trong trang web bằng xpath
		driver.findElement(By.xpath("//*[@id=\"tblUser\"]/tbody/tr[1]/td[7]/a[1]")).click();
		Thread.sleep(2000);

		// Xoá dữ liệu trong ô nhập mã giảng viên
		driver.findElement(By.id("staff_id")).clear();
		Thread.sleep(2000);

		// Nhập giá trị id vào ô nhập mã giảng viên trên trang web bằng xpath
		driver.findElement(By.xpath("//*[@id=\"staff_id\"]")).sendKeys(String.valueOf(id)); // Chuyển số nguyên thành chuỗi
		Thread.sleep(4000);

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
		WebElement errorElement = driver.findElement(By.xpath("//*[@id=\"staff_id-error\"]"));

		// Định nghĩa chuỗi kỳ vọng thông báo lỗi
		String expected = "Chỉ được nhập số-chữ không dấu và không có khoảng trắng!";

		// In ra kết quả mong đợi và kết quả thực tế của thông báo lỗi
		System.out.println("Kết quả mong đợi: " + expected);
		System.out.println("Kết quả thực tế: " + errorElement.getText());
	}
	@Test(priority = 4)
	public void Actions5() throws InterruptedException, IOException {
		System.out.println("Testcase 5: Cập nhật người dùng nhưng điền email không hợp lệ");
		// Mở một FileInputStream để đọc tệp Excel từ đường dẫn đã cho
		FileInputStream fis = new FileInputStream("K:\\Automation\\AddUser.xlsx");

		// Tạo một đối tượng XSSFWorkbook để đại diện cho toàn bộ tệp Excel
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		// Lấy ra sheet đầu tiên từ workbook
		XSSFSheet sheet = workbook.getSheetAt(0);

		// Lấy ra hàng thứ 6 từ sheet (index bắt đầu từ 0)
		XSSFRow row = sheet.getRow(5);

		// Đọc giá trị từ cột C (index 2) từ hàng đã chọn và gán vào biến email
		String email = row.getCell(2).getStringCellValue();

		// Dừng chương trình trong 4 giây (đang sử dụng sleep, không khuyến khích trong việc tự động hóa thực tế)
		Thread.sleep(4000);

		// Click vào một đường dẫn trong trang web bằng xpath
		driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[3]/a")).click();
		Thread.sleep(2000);

		// Tìm và nhập dữ liệu vào ô tìm kiếm trên trang web
		driver.findElement(By.xpath("//*[@id=\"tblUser_filter\"]/label/input")).sendKeys("Testing Khang");
		Thread.sleep(2000);

		// Click vào một liên kết trong trang web bằng xpath
		driver.findElement(By.xpath("//*[@id=\"tblUser\"]/tbody/tr[1]/td[7]/a[1]")).click();
		Thread.sleep(3000);

		// Xoá dữ liệu trong ô nhập email
		driver.findElement(By.id("email")).clear();
		Thread.sleep(3000);

		// Nhập giá trị email vào ô nhập email trên trang web
		driver.findElement(By.id("email")).sendKeys(email);

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

		// Định nghĩa chuỗi kỳ vọng thông báo lỗi
		String expected = "Vui lòng nhập email Văn Lang hợp lệ!";

		// In ra kết quả mong đợi và kết quả thực tế của thông báo lỗi
		System.out.println("Kết quả mong đợi: " + expected);
		System.out.println("Kết quả thực tế: " + errorElement.getText());

	}
	@Test(priority = 5)
	public void Actions6() throws InterruptedException, IOException {
		Thread.sleep(5000);
		System.out.println("Testcase 6: Chỉnh sửa người dùng nhưng điền tên với kí tự đặc biệt");

		// Mở một FileInputStream để đọc tệp Excel từ đường dẫn đã cho
		FileInputStream fis = new FileInputStream("K:\\Automation\\AddUser.xlsx");

		// Tạo một đối tượng XSSFWorkbook để đại diện cho toàn bộ tệp Excel
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		// Lấy ra sheet đầu tiên từ workbook
		XSSFSheet sheet = workbook.getSheetAt(0);

		// Lấy ra hàng thứ 7 từ sheet (index bắt đầu từ 0)
		XSSFRow row = sheet.getRow(6);

		// Đọc giá trị từ cột B (index 1) từ hàng đã chọn và gán vào biến fullname
		String fullname = row.getCell(1).getStringCellValue();

		// Dừng chương trình trong 4 giây (đang sử dụng sleep, không khuyến khích trong việc tự động hóa thực tế)
		Thread.sleep(4000);

		// Click vào một đường dẫn trong trang web bằng xpath
		driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[3]/a")).click();
		Thread.sleep(2000);

		// Tìm và nhập dữ liệu vào ô tìm kiếm trên trang web
		driver.findElement(By.xpath("//*[@id=\"tblUser_filter\"]/label/input")).sendKeys("Testing Khang");
		Thread.sleep(2000);

		// Click vào một liên kết trong trang web bằng xpath
		driver.findElement(By.xpath("//*[@id=\"tblUser\"]/tbody/tr/td[7]/a[1]")).click();
		Thread.sleep(3000);

		// Xoá dữ liệu trong ô nhập tên
		driver.findElement(By.id("full_name")).clear();
		Thread.sleep(2000);

		// Nhập giá trị fullname vào ô nhập tên trên trang web
		driver.findElement(By.id("full_name")).sendKeys(fullname);

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

		// Dừng chương trình trong 1 giây
		Thread.sleep(1000);

		// Tìm và lấy ra phần tử chứa thông báo cập nhật thành công bằng xpath
		WebElement updateElement = driver.findElement(By.xpath("/html/body/div[3]/div/div"));
		String actualResult = updateElement.getText();
		String expectedResult = "Cập nhật thành công!";

		// In ra kết quả mong đợi và kết quả thực tế của thông báo cập nhật
		System.out.println("Kết quả mong đợi: " + expectedResult);
		System.out.println("Kết quả thực tế: " + actualResult);

	}
	@Test(priority = 6)
	public void Actions7() throws InterruptedException, IOException {
		Thread.sleep(5000);
		System.out.println("Testcase 7: Chỉnh sửa người dùng đúng thông tin");

		// Mở một FileInputStream để đọc tệp Excel từ đường dẫn đã cho
		FileInputStream fis = new FileInputStream("K:\\Automation\\AddUser.xlsx");

		// Tạo một đối tượng XSSFWorkbook để đại diện cho toàn bộ tệp Excel
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		// Lấy ra sheet đầu tiên từ workbook
		XSSFSheet sheet = workbook.getSheetAt(0);

		// Lấy ra hàng thứ 8 (index bắt đầu từ 0) từ sheet
		XSSFRow row = sheet.getRow(7);

		// Đọc giá trị từ cột A (index 0) từ hàng đã chọn và gán vào biến idString
		String idString = row.getCell(0).getStringCellValue();

		// Đọc giá trị từ cột B (index 1) từ hàng đã chọn và gán vào biến fullnameString
		String fullnameString = row.getCell(1).getStringCellValue();

		// Đọc giá trị từ cột C (index 2) từ hàng đã chọn và gán vào biến gmailString
		String gmailString = row.getCell(2).getStringCellValue();

		// Dừng chương trình trong 4 giây
		Thread.sleep(4000);

		// Click vào một đường dẫn trong trang web bằng xpath
		driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[3]/a")).click();

		// Dừng chương trình trong 2 giây
		Thread.sleep(2000);

		// Tìm trường input tìm kiếm và nhập "Testing Khang"
		driver.findElement(By.xpath("//*[@id=\"tblUser_filter\"]/label/input"))
		      .sendKeys("Testing Khang");
		Thread.sleep(2000);

		// Click vào một nút trên trang web bằng xpath
		driver.findElement(By.xpath("//*[@id=\"tblUser\"]/tbody/tr/td[7]/a[1]")).click();
		Thread.sleep(3000); // Dừng chương trình trong 3 giây

		// Xóa giá trị trong trường input "staff_id"
		driver.findElement(By.id("staff_id")).clear();
		Thread.sleep(2000);

		// Nhập giá trị idString vào trường input "staff_id"
		driver.findElement(By.id("staff_id")).sendKeys(idString);
		Thread.sleep(3000); // Dừng chương trình trong 3 giây

		// Xóa giá trị trong trường input "full_name"
		driver.findElement(By.id("full_name")).clear();
		Thread.sleep(2000);

		// Nhập giá trị fullnameString vào trường input "full_name"
		driver.findElement(By.id("full_name")).sendKeys(fullnameString);
		Thread.sleep(3000); // Dừng chương trình trong 3 giây

		// Xóa giá trị trong trường input "email"
		driver.findElement(By.id("email")).clear();
		Thread.sleep(2000);

		// Nhập giá trị gmailString vào trường input "email"
		driver.findElement(By.id("email")).sendKeys(gmailString);

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
		Thread.sleep(1000);

		// Tìm và lấy ra phần tử chứa thông báo cập nhật bằng xpath
		WebElement updateElement = driver.findElement(By.xpath("/html/body/div[3]/div/div"));

		// Lấy nội dung của phần tử và gán vào biến ketquathucte
		String ketquathucte = updateElement.getText();

		// Định nghĩa chuỗi kỳ vọng thông báo cập nhật
		String ketquamongdoi = "Cập nhật thành công!";

		// In ra kết quả mong đợi và kết quả thực tế của thông báo cập nhật
		System.out.println("Kết quả mong đợi: " + ketquamongdoi);
		System.out.println("Kết quả thực tế: " + ketquathucte);

	}
	@AfterTest
	public void Close() {
		driver.close();
	}

}
