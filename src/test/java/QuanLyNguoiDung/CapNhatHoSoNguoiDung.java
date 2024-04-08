package QuanLyNguoiDung;

import java.io.FileInputStream;
import java.io.IOException;

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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CapNhatHoSoNguoiDung {
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
	public void Action() throws InterruptedException, IOException {
		// In ra thông báo bắt đầu của test case
		System.out.println("Testcase 1: Cập nhật hồ sơ người dùng với ký tự đặc biệt tại ô Mã Giảng Viên");
		
		// Mở một luồng đọc file Excel để đọc dữ liệu từ tệp "UpdateProfile.xlsx"
		FileInputStream fis = new FileInputStream("K:\\Automation\\UpdateProfile.xlsx");

		// Tạo một đối tượng XSSFWorkbook để đại diện cho toàn bộ tệp Excel
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		// Lấy ra sheet đầu tiên từ workbook
		XSSFSheet sheet = workbook.getSheetAt(0);

		// Lấy ra hàng thứ nhất (index 0) từ sheet
		XSSFRow row = sheet.getRow(0);

		// Đọc giá trị từ cột A (index 0) từ hàng đã chọn và gán vào biến idString
		String idString = row.getCell(0).getStringCellValue();

		// Đọc giá trị từ cột B (index 1) từ hàng đã chọn và gán vào biến fullnameString
		String fullnameString = row.getCell(1).getStringCellValue();

		// Đọc giá trị từ cột C (index 2) từ hàng đã chọn và gán vào biến gmailString
		// (Dòng này đã bị lỡ viết lại, có thể xóa nếu không cần)
		Thread.sleep(4000);

		// Click vào biểu tượng dropdown người dùng trên giao diện web
		driver.findElement(By.xpath("//*[@id=\"dropdown-user\"]/span")).click();
		Thread.sleep(2000);

		// Click vào nút "Cập nhật thông tin" trong dropdown menu
		driver.findElement(By.xpath("/html/body/div[2]/nav/div/ul/li[2]/div/a[1]")).click();
		Thread.sleep(4000);

		// Xóa dữ liệu cũ trong ô nhập Mã Giảng Viên
		WebElement deleteoldid = driver.findElement(By.id("staff_id"));
		deleteoldid.clear();
		Thread.sleep(2000);

		// Nhập dữ liệu Mã Giảng Viên từ file Excel vào trường nhập liệu trên giao diện web
		deleteoldid.sendKeys(idString);

		// Xóa dữ liệu cũ trong ô nhập Tên
		WebElement deleteoldname = driver.findElement(By.id("full_name"));
		deleteoldname.clear();
		Thread.sleep(2000);

		// Nhập dữ liệu Tên từ file Excel vào trường nhập liệu trên giao diện web
		deleteoldname.sendKeys(fullnameString);

		// Click vào nút "Cập nhật" để thực hiện cập nhật hồ sơ
		driver.findElement(By.xpath("//*[@id=\"profile-form\"]/button")).click();
		
		System.out.println("Dũ lieu dc input từ excel"+idString);
		// Lấy thông báo lỗi xuất hiện sau khi nhập dữ liệu không hợp lệ
		WebElement errorElement = driver.findElement(By.xpath("//*[@id=\"staff_id-error\"]"));

		// Định nghĩa chuỗi kỳ vọng thông báo lỗi
		String expected = "Chỉ được nhập số-chữ không dấu và không có khoảng trắng!";

		// In ra kết quả mong đợi và kết quả thực tế của thông báo lỗi
		System.out.println("Kết quả mong đợi: " + expected);
		System.out.println("Kết quả thực tế: " + errorElement.getText());
		Thread.sleep(2000); // Nếu cần chờ thêm thì thêm sleep ở đây
        
	}
	@Test
	public void Action2() throws InterruptedException, IOException {
		// In ra thông báo bắt đầu của test case
		System.out.println("Testcase 2: Cập nhật hồ sơ người dùng với khoảng trắng tại ô Mã Giảng Viên");

		// Mở một luồng đọc file Excel để đọc dữ liệu từ tệp "UpdateProfile.xlsx"
		FileInputStream fis = new FileInputStream("K:\\Automation\\UpdateProfile.xlsx");

		// Tạo một đối tượng XSSFWorkbook để đại diện cho toàn bộ tệp Excel
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		// Lấy ra sheet đầu tiên từ workbook
		XSSFSheet sheet = workbook.getSheetAt(0);

		// Lấy ra hàng thứ 2 (index 1) từ sheet
		XSSFRow row = sheet.getRow(1);

		// Đọc giá trị từ cột A (index 0) từ hàng đã chọn và gán vào biến idString
		String idString = row.getCell(0).getStringCellValue();

		// Đọc giá trị từ cột B (index 1) từ hàng đã chọn và gán vào biến fullnameString
		String fullnameString = row.getCell(1).getStringCellValue();

		// Đọc giá trị từ cột C (index 2) từ hàng đã chọn và gán vào biến gmailString
		// (Dòng này đã bị lỡ viết lại, có thể xóa nếu không cần)
		Thread.sleep(4000);

		// Click vào biểu tượng dropdown người dùng trên giao diện web
		driver.findElement(By.xpath("//*[@id=\"dropdown-user\"]/span")).click();
		Thread.sleep(2000);

		// Click vào nút "Cập nhật thông tin" trong dropdown menu
		driver.findElement(By.xpath("/html/body/div[2]/nav/div/ul/li[2]/div/a[1]")).click();
		Thread.sleep(4000);

		// Xóa dữ liệu cũ trong ô nhập Mã Giảng Viên
		WebElement deleteoldid = driver.findElement(By.id("staff_id"));
		deleteoldid.clear();
		Thread.sleep(2000);

		// Nhập dữ liệu Mã Giảng Viên từ file Excel vào trường nhập liệu trên giao diện web
		deleteoldid.sendKeys(idString);

		// Xóa dữ liệu cũ trong ô nhập Tên
		WebElement deleteoldname = driver.findElement(By.id("full_name"));
		deleteoldname.clear();
		Thread.sleep(2000);

		// Nhập dữ liệu Tên từ file Excel vào trường nhập liệu trên giao diện web
		deleteoldname.sendKeys(fullnameString);

		// Click vào nút "Cập nhật" để thực hiện cập nhật hồ sơ
		driver.findElement(By.xpath("//*[@id=\"profile-form\"]/button")).click();

		Thread.sleep(2000);

		// Lấy thông báo lỗi xuất hiện sau khi nhập dữ liệu không hợp lệ
		WebElement errorElement = driver.findElement(By.xpath("//*[@id=\"staff_id-error\"]"));

		// Định nghĩa chuỗi kỳ vọng thông báo lỗi
		String expected = "Chỉ được nhập số-chữ không dấu và không có khoảng trắng!";

		// In ra kết quả mong đợi và kết quả thực tế của thông báo lỗi
		System.out.println("Kết quả mong đợi: " + expected);
		System.out.println("Kết quả thực tế: " + errorElement.getText());

		Thread.sleep(2000);
        
	}
	@Test
	public void Action3() throws InterruptedException, IOException {
		// In ra thông báo bắt đầu của test case
		System.out.println("Testcase 3: Cập nhật hồ sơ người dùng với bỏ trống tại ô Mã Giảng Viên");

		// Mở một luồng đọc file Excel để đọc dữ liệu từ tệp "UpdateProfile.xlsx"
		FileInputStream fis = new FileInputStream("K:\\Automation\\UpdateProfile.xlsx");

		// Tạo một đối tượng XSSFWorkbook để đại diện cho toàn bộ tệp Excel
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		// Lấy ra sheet đầu tiên từ workbook
		XSSFSheet sheet = workbook.getSheetAt(0);

		// Lấy ra hàng thứ 4 (index 3) từ sheet
		XSSFRow row = sheet.getRow(3);

		// Đọc giá trị từ cột A (index 0) từ hàng đã chọn và gán vào biến idString
		// (Dòng này bị lỡ viết lại và không cần thiết, có thể xóa)
		// String idString = row.getCell(0).getStringCellValue();

		// Đọc giá trị từ cột B (index 1) từ hàng đã chọn và gán vào biến fullnameString
		String idString = row.getCell(0).getStringCellValue();

		// Đọc giá trị từ cột C (index 2) từ hàng đã chọn và gán vào biến gmailString
		// (Dòng này đã bị lỡ viết lại, có thể xóa nếu không cần)
		Thread.sleep(4000);

		// Click vào biểu tượng dropdown người dùng trên giao diện web
		driver.findElement(By.xpath("//*[@id=\"dropdown-user\"]/span")).click();
		Thread.sleep(2000);

		// Click vào nút "Cập nhật thông tin" trong dropdown menu
		driver.findElement(By.xpath("/html/body/div[2]/nav/div/ul/li[2]/div/a[1]")).click();
		Thread.sleep(4000);

		// Xóa dữ liệu cũ trong ô nhập Mã Giảng Viên
		WebElement deleteoldid = driver.findElement(By.id("staff_id"));
		deleteoldid.clear();
		Thread.sleep(2000);

		// Nhập dữ liệu Mã Giảng Viên từ file Excel vào trường nhập liệu trên giao diện web
		deleteoldid.sendKeys(idString);

		// Xóa dữ liệu cũ trong ô nhập Tên
		WebElement deleteoldname = driver.findElement(By.id("full_name"));
		deleteoldname.clear();
		Thread.sleep(2000);

		// Click vào nút "Cập nhật" để thực hiện cập nhật hồ sơ
		driver.findElement(By.xpath("//*[@id=\"profile-form\"]/button")).click();

		Thread.sleep(2000);

		// Lấy thông báo lỗi xuất hiện sau khi nhập dữ liệu không hợp lệ
		WebElement errorElement = driver.findElement(By.xpath("//*[@id=\"swal2-html-container\"]"));

		// Định nghĩa chuỗi kỳ vọng thông báo lỗi
		String expected = "Không được bỏ trống tên";

		// In ra kết quả mong đợi và kết quả thực tế của thông báo lỗi
		System.out.println("Kết quả mong đợi: " + expected);
		System.out.println("Kết quả thực tế: " + errorElement.getText());

		Thread.sleep(2000);

		// Đóng thông báo và chuyển sang bước tiếp theo
		driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[1]")).click();
		Thread.sleep(2000);

	}

	@Test
	public void Action4() throws InterruptedException, IOException {
		// In ra thông báo bắt đầu của test case
		System.out.println("Testcase 4: Cập nhật hồ sơ người dùng với bỏ trống tại ô Tên Giảng Viên");

		// Mở một luồng đọc file Excel để đọc dữ liệu từ tệp "UpdateProfile.xlsx"
		FileInputStream fis = new FileInputStream("K:\\Automation\\UpdateProfile.xlsx");

		// Tạo một đối tượng XSSFWorkbook để đại diện cho toàn bộ tệp Excel
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		// Lấy ra sheet đầu tiên từ workbook
		XSSFSheet sheet = workbook.getSheetAt(0);

		// Lấy ra hàng thứ 5 (index 4) từ sheet
		XSSFRow row = sheet.getRow(4);

		// Đọc giá trị từ cột A (index 0) từ hàng đã chọn và gán vào biến idString
		String idString = row.getCell(0).getStringCellValue();

		// Đọc giá trị từ cột B (index 1) từ hàng đã chọn và gán vào biến fullnameString
		String fullnameString = row.getCell(1).getStringCellValue();

		// Đọc giá trị từ cột C (index 2) từ hàng đã chọn và gán vào biến gmailString
		Thread.sleep(4000);

		// Click vào biểu tượng dropdown người dùng trên giao diện web
		driver.findElement(By.xpath("//*[@id=\"dropdown-user\"]/span")).click();
		Thread.sleep(2000);

		// Click vào nút "Cập nhật thông tin" trong dropdown menu
		driver.findElement(By.xpath("/html/body/div[2]/nav/div/ul/li[2]/div/a[1]")).click();
		Thread.sleep(4000);

		// Xóa dữ liệu cũ trong ô nhập Mã Giảng Viên
		WebElement deleteoldid = driver.findElement(By.id("staff_id"));
		deleteoldid.clear();
		Thread.sleep(2000);
		deleteoldid.sendKeys(idString);

		// Xóa dữ liệu cũ trong ô nhập Tên Giảng Viên
		WebElement deleteoldname = driver.findElement(By.id("full_name"));
		deleteoldname.clear();
		Thread.sleep(2000);
		deleteoldname.sendKeys(fullnameString);

		// Click vào nút "Cập nhật" để thực hiện cập nhật hồ sơ
		driver.findElement(By.xpath("//*[@id=\"profile-form\"]/button")).click();
		Thread.sleep(2000);

		// Lấy thông báo lỗi xuất hiện sau khi nhập dữ liệu không hợp lệ
		WebElement errorElement = driver.findElement(By.xpath("//*[@id=\"swal2-html-container\"]"));

		// Định nghĩa chuỗi kỳ vọng thông báo lỗi
		String expected = "Không được điền kí tự đặc biệt";

		// In ra kết quả mong đợi và kết quả thực tế của thông báo lỗi
		System.out.println("Kết quả mong đợi: " + expected);
		System.out.println("Kết quả thực tế: " + errorElement.getText());

		Thread.sleep(2000);

		// Đóng thông báo và chuyển sang bước tiếp theo
		driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[1]")).click();
		Thread.sleep(2000);

	}

	@Test
	public void Action5() throws InterruptedException, IOException {
		// In ra thông báo bắt đầu của test case
		System.out.println("Testcase 5: Cập nhật hồ sơ người dùng với kí tự đặc biệt tại ô Tên Giảng Viên");

		// Mở một luồng đọc file Excel để đọc dữ liệu từ tệp "UpdateProfile.xlsx"
		FileInputStream fis = new FileInputStream("K:\\Automation\\UpdateProfile.xlsx");

		// Tạo một đối tượng XSSFWorkbook để đại diện cho toàn bộ tệp Excel
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
 
		// Lấy ra sheet đầu tiên từ workbook
		XSSFSheet sheet = workbook.getSheetAt(0);

		// Lấy ra hàng thứ 6 (index 5) từ sheet
		XSSFRow row = sheet.getRow(5);

		// Đọc giá trị từ cột A (index 0) từ hàng đã chọn và gán vào biến idString
		String idString = row.getCell(0).getStringCellValue();

		// Đọc giá trị từ cột B (index 1) từ hàng đã chọn và gán vào biến fullnameString
		String fullnameString = row.getCell(1).getStringCellValue();

		// Đọc giá trị từ cột C (index 2) từ hàng đã chọn và gán vào biến gmailString
		Thread.sleep(4000);

		// Click vào biểu tượng dropdown người dùng trên giao diện web
		driver.findElement(By.xpath("//*[@id=\"dropdown-user\"]/span")).click();
		Thread.sleep(2000);

		// Click vào nút "Cập nhật thông tin" trong dropdown menu
		driver.findElement(By.xpath("/html/body/div[2]/nav/div/ul/li[2]/div/a[1]")).click();
		Thread.sleep(4000);

		// Xóa dữ liệu cũ trong ô nhập Mã Giảng Viên
		WebElement deleteoldid = driver.findElement(By.id("staff_id"));
		deleteoldid.clear();
		Thread.sleep(2000);
		deleteoldid.sendKeys(idString);

		// Xóa dữ liệu cũ trong ô nhập Tên Giảng Viên
		WebElement deleteoldname = driver.findElement(By.id("full_name"));
		deleteoldname.clear();
		Thread.sleep(2000);
		deleteoldname.sendKeys(fullnameString);

		// Click vào nút "Cập nhật" để thực hiện cập nhật hồ sơ
		driver.findElement(By.xpath("//*[@id=\"profile-form\"]/button")).click();
		Thread.sleep(2000);

		// Lấy thông báo lỗi xuất hiện sau khi nhập dữ liệu không hợp lệ
		WebElement errorElement = driver.findElement(By.xpath("//*[@id=\"swal2-html-container\"]"));

		// Định nghĩa chuỗi kỳ vọng thông báo lỗi
		String expected = "Không được nhập kí tự đặc biệt";

		// In ra kết quả mong đợi và kết quả thực tế của thông báo lỗi
		System.out.println("Kết quả mong đợi: " + expected);
		System.out.println("Kết quả thực tế: " + errorElement.getText());

		Thread.sleep(2000);

		// Đóng thông báo và chuyển sang bước tiếp theo
		driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[1]")).click();
		Thread.sleep(2000);
	}

@Test
public void Action6() throws InterruptedException, IOException {

	System.out.println("Testcase 6: Cập nhật hồ sơ người dùng với khoảng trắng tại ô Tên Giảng Viên");

	Thread.sleep(2000);

	// Click vào biểu tượng dropdown người dùng trên giao diện web
	driver.findElement(By.xpath("//*[@id=\"dropdown-user\"]/span")).click();
	Thread.sleep(2000);

	// Click vào nút "Cập nhật thông tin" trong dropdown menu
	driver.findElement(By.xpath("/html/body/div[2]/nav/div/ul/li[2]/div/a[1]")).click();
	Thread.sleep(4000);

	// Xóa dữ liệu cũ trong ô nhập Mã Giảng Viên
	WebElement deleteoldid = driver.findElement(By.id("staff_id"));
	deleteoldid.clear();
	Thread.sleep(2000);

	// Xóa dữ liệu cũ trong ô nhập Tên Giảng Viên
	WebElement deleteoldname = driver.findElement(By.id("full_name"));
	deleteoldname.clear();
	Thread.sleep(2000);

	// Click vào nút "Cập nhật" để thực hiện cập nhật hồ sơ
	driver.findElement(By.xpath("//*[@id=\"profile-form\"]/button")).click();
	Thread.sleep(2000);

	// Lấy thông báo lỗi xuất hiện sau khi nhập dữ liệu không hợp lệ
	WebElement errorElement = driver.findElement(By.xpath("//*[@id=\"swal2-html-container\"]"));

	// Định nghĩa chuỗi kỳ vọng thông báo lỗi
	String expected = "Không được bỏ trống tên và mã giảng viên";

	// In ra kết quả mong đợi và kết quả thực tế của thông báo lỗi
	System.out.println("Kết quả mong đợi: " + expected);
	System.out.println("Kết quả thực tế: " + errorElement.getText());

	Thread.sleep(2000);

	// Đóng thông báo và chuyển sang bước tiếp theo
	driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[1]")).click();
	Thread.sleep(2000);
	}
@Test
public void Action7() throws InterruptedException, IOException {
	System.out.println("Testcase 7: Cập nhật hồ sơ người dùng với số tại ô Tên Giảng Viên");

	FileInputStream fis = new FileInputStream("K:\\Automation\\UpdateProfile.xlsx");

	// Tạo một đối tượng XSSFWorkbook để đại diện cho toàn bộ tệp Excel
	XSSFWorkbook workbook = new XSSFWorkbook(fis);

	// Lấy ra sheet đầu tiên từ workbook
	XSSFSheet sheet = workbook.getSheetAt(0);

	// Lấy ra hàng thứ 8 (index bắt đầu từ 0) từ sheet
	XSSFRow row = sheet.getRow(6);

	// Đọc giá trị từ cột A (index 0) từ hàng đã chọn và gán vào biến idString
	String idString = row.getCell(0).getStringCellValue();

	// Đọc giá trị từ cột B (index 1) từ hàng đã chọn và gán vào biến fullnameString
	String fullnameString = row.getCell(1).getStringCellValue();

	// Đọc giá trị từ cột C (index 2) từ hàng đã chọn và gán vào biến gmailString
	Thread.sleep(4000);
	driver.findElement(By.xpath("//*[@id=\"dropdown-user\"]/span")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("/html/body/div[2]/nav/div/ul/li[2]/div/a[1]")).click();
	Thread.sleep(4000);

	// Xoá dữ liệu cũ trong ô nhập Mã Giảng Viên
	WebElement deleteoldid = driver.findElement(By.id("staff_id"));
	deleteoldid.clear();
	Thread.sleep(2000);
	deleteoldid.sendKeys(idString);

	// Xoá dữ liệu cũ trong ô nhập Tên Giảng Viên
	WebElement deleteoldname = driver.findElement(By.id("full_name"));
	deleteoldname.clear();
	Thread.sleep(2000);
	deleteoldname.sendKeys(fullnameString);

	// Click vào nút "Cập nhật" để thực hiện cập nhật hồ sơ
	driver.findElement(By.xpath("//*[@id=\"profile-form\"]/button")).click();
	Thread.sleep(2000);

	// Lấy thông báo lỗi xuất hiện sau khi nhập dữ liệu không hợp lệ
	WebElement errorElement = driver.findElement(By.xpath("//*[@id=\"swal2-html-container\"]"));

	// Định nghĩa chuỗi kỳ vọng thông báo lỗi
	String expected = "Không được số hoặc kí tự đặc biệt vào tên giảng viên";

	// In ra kết quả mong đợi và kết quả thực tế của thông báo lỗi
	System.out.println("Kết quả mong đợi: " + expected);
	System.out.println("Kết quả thực tế: " + errorElement.getText());

	Thread.sleep(2000);

	// Đóng thông báo và chuyển sang bước tiếp theo
	driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[1]")).click();
	Thread.sleep(2000);
}
@Test
public void Action8() throws InterruptedException, IOException {
	// In ra thông báo bắt đầu của test case
	System.out.println("Testcase 8: Cập nhật hồ sơ người dùng với đầy đủ và đúng thông tin");

	// Mở một luồng đọc file Excel để đọc dữ liệu từ tệp "UpdateProfile.xlsx"
	FileInputStream fis = new FileInputStream("K:\\Automation\\UpdateProfile.xlsx");

	// Tạo một đối tượng XSSFWorkbook để đại diện cho toàn bộ tệp Excel
	XSSFWorkbook workbook = new XSSFWorkbook(fis);

	// Lấy ra sheet đầu tiên từ workbook
	XSSFSheet sheet = workbook.getSheetAt(0);

	// Lấy ra hàng thứ 8 (index 7) từ sheet
	XSSFRow row = sheet.getRow(7);

	// Đọc giá trị từ cột A (index 0) từ hàng đã chọn và gán vào biến idString
	String idString = row.getCell(0).getStringCellValue();

	// Đọc giá trị từ cột B (index 1) từ hàng đã chọn và gán vào biến fullnameString
	String fullnameString = row.getCell(1).getStringCellValue();

	// Đọc giá trị từ cột C (index 2) từ hàng đã chọn và gán vào biến gmailString
	// (Dòng này đã bị lỡ viết lại, có thể xóa nếu không cần)
	Thread.sleep(4000);

	// Click vào biểu tượng dropdown người dùng trên giao diện web
	driver.findElement(By.xpath("//*[@id=\"dropdown-user\"]/span")).click();
	Thread.sleep(2000);

	// Click vào nút "Cập nhật thông tin" trong dropdown menu
	driver.findElement(By.xpath("/html/body/div[2]/nav/div/ul/li[2]/div/a[1]")).click();
	Thread.sleep(4000);

	// Xóa dữ liệu cũ trong ô nhập Mã Giảng Viên
	WebElement deleteoldid = driver.findElement(By.id("staff_id"));
	deleteoldid.clear();
	Thread.sleep(2000);

	// Nhập dữ liệu Mã Giảng Viên từ file Excel vào trường nhập liệu trên giao diện web
	deleteoldid.sendKeys(idString);

	// Xóa dữ liệu cũ trong ô nhập Tên
	WebElement deleteoldname = driver.findElement(By.id("full_name"));
	deleteoldname.clear();
	Thread.sleep(2000);

	// Nhập dữ liệu Tên từ file Excel vào trường nhập liệu trên giao diện web
	deleteoldname.sendKeys(fullnameString);

	// Click vào nút "Cập nhật" để thực hiện cập nhật hồ sơ
	driver.findElement(By.xpath("//*[@id=\"profile-form\"]/button")).click();

	Thread.sleep(2000);

	// Lấy thông báo kết quả cập nhật hồ sơ từ giao diện web
	WebElement errorElement = driver.findElement(By.xpath("//*[@id=\"swal2-html-container\"]"));

	// Định nghĩa chuỗi kỳ vọng thông báo kết quả cập nhật thành công
	String expected = "Cập nhật thành công";

	// In ra kết quả mong đợi và kết quả thực tế của thông báo kết quả
	System.out.println("Kết quả mong đợi: " + expected);
	System.out.println("Kết quả thực tế: " + errorElement.getText());

	Thread.sleep(2000);

	// Click vào nút "OK" trên hộp thoại thông báo
	driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[1]")).click();
	Thread.sleep(2000);
	}
@AfterTest
public void Close() {
	driver.close();
}
}
