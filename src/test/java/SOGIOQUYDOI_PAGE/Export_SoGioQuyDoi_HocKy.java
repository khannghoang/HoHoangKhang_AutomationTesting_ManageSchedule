package SOGIOQUYDOI_PAGE;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageSetup.Setup;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Export_SoGioQuyDoi_HocKy {
	static WebDriver driver;

	@BeforeTest
	public void Main() throws IOException, InterruptedException {

		Setup setup = new Setup(); 
		driver = setup.setup();
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[5]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[5]/ul/li[2]/a")).click();
		Thread.sleep(2000);
		
	}
	@Test(priority = 1)
	public void Export1() throws UnsupportedFlavorException, IOException, InterruptedException, AWTException {

		System.out.println("Testcase 1: Chức năng Export In ấn Số Giờ Quy Đổi theo Học Kỳ và chọn ngành Tất cả ");
		FileInputStream fis = new FileInputStream("K:\\Automation\\ExportSGQĐNH.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		XSSFRow row = sheet.getRow(0);
		// Đọc giá trị từ cột A (index 0) từ hàng đã chọn và gán vào biến idString
		String stringHK = row.getCell(0).getStringCellValue();

		// Đọc giá trị từ cột B (index 1) từ hàng đã chọn và gán vào biến fullnameString
		String stringNganh = row.getCell(1).getStringCellValue();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"termDiv\"]/div/span/span[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"termDiv\"]/div/span[2]/span/span[1]/input")).sendKeys(stringHK);
		driver.findElement(By.xpath("//*[@id=\"termDiv\"]/div/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[1]/span[1]/span"))
				.click();
		driver.findElement(By.xpath(
				"/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input"))
				.sendKeys(stringNganh);
		driver.findElement(By.xpath(
				"/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input"))
				.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"table-tab\"]")).click();

		WebElement printElement = driver
				.findElement(By.xpath("//*[@id=\"tblStatistics_wrapper\"]/div[1]/div[2]/div/div[2]/button"));
		printElement.click();
		Thread.sleep(1000);
		WebElement printOptionElement = driver.findElement(
				By.xpath("//*[@id=\"tblStatistics_wrapper\"]/div[1]/div[2]/div/div[2]/div[2]/div/button[1]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", printOptionElement);

		Robot robot = new Robot();
		WebElement confirmElement = driver.findElement(By.xpath("//*[@id=\"tblStatistics_length\"]/label"));
		if (confirmElement.getText().contains("Hiển thị")) {

			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_C);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_C);
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			// In dữ liệu từ clipboard
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			String duLieu = (String) clipboard.getData(DataFlavor.stringFlavor);

			System.out
					.println("Kết quả mong đợi: ThongKeChiTietSoGio_HK" + stringHK + "_Nganh_" + stringNganh + ".pdf");
			System.out.println("Kết quả thực tế: " + duLieu);

		} else {
			System.out.println("Xem thất bại!!");
		}
		driver.navigate().refresh();
	}
//
//	@Test (priority = 2)
//	public void Export2() throws IOException, InterruptedException, UnsupportedFlavorException {
//		System.out.println("Testcase 2: Chức năng Export Sao Chép Số Giờ Quy Đổi theo Học Kỳ và chọn ngành Tất cả");
//		FileInputStream fis = new FileInputStream("K:\\Automation\\ExportSGQĐNH.xlsx");
//		XSSFWorkbook workbook = new XSSFWorkbook(fis);
//		XSSFSheet sheet = workbook.getSheetAt(0);
//		XSSFRow row = sheet.getRow(0);
//		// Đọc giá trị từ cột A (index 0) từ hàng đã chọn và gán vào biến idString
//		String stringHK = row.getCell(0).getStringCellValue();
//		// Đọc giá trị từ cột B (index 1) từ hàng đã chọn và gán vào biến fullnameString
//		String stringNganh = row.getCell(1).getStringCellValue();
//		driver.findElement(By.xpath("//*[@id=\"termDiv\"]/div/span/span[1]")).click();
//		driver.findElement(By.xpath("//*[@id=\"termDiv\"]/div/span[2]/span/span[1]/input")).sendKeys(stringHK);
//		driver.findElement(By.xpath("//*[@id=\"termDiv\"]/div/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
//		Thread.sleep(2000);
//		driver.findElement(By.xpath(
//				"/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[1]/span[1]/span"))
//				.click();
//		driver.findElement(By.xpath(
//				"/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input"))
//				.sendKeys(stringNganh);
//		driver.findElement(By.xpath(
//				"/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input"))
//				.sendKeys(Keys.ENTER);
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"table-tab\"]")).click();
//
//		// Print
//		WebElement printElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/div[2]/div/div/div/div[1]/div[2]/div/div[2]/button"));
//		printElement.click();
//		Thread.sleep(1000);
//		WebElement printOptionElement = driver.findElement(
//				By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/div[2]/div/div/div/div[1]/div[2]/div/div[2]/div[2]/div/button[4]"));
//		Thread.sleep(2000);
//		printOptionElement.click();
//		Thread.sleep(300);
//		WebElement thongbaoElement = driver.findElement(By.xpath("/html/body/div[3]/h2"));
//		String dulieuString = thongbaoElement.getText();
//
//		// Sao chép table
//		WebElement bangdulieuElement = driver.findElement(By.xpath(
//				"//*[@id=\"tblStatistics\"]/tbody"));
//		String dulieumongdoiString = bangdulieuElement.getText();
//
//		// Xác nhận đã vào giao diện bảng biểu
//		WebElement confirmElement = driver.findElement(By.xpath("//*[@id=\"tblStatistics_length\"]/label"));
//		if (confirmElement.getText().contains("Hiển thị")) {
//			// In dữ liệu từ clipboard
//			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//			String duLieu = (String) clipboard.getData(DataFlavor.stringFlavor);
//			System.out.println(dulieuString);
//			System.out.println("Kết quả mong đợi: " + dulieumongdoiString);
//			System.out.println("Kết quả thực tế: " + duLieu);
//
//		} else {
//			System.out.println("Xem thất bại!!");
//		}
//		driver.navigate().refresh();
//	}
//	@Test (priority = 3)
//	public void Export3() throws IOException, InterruptedException, UnsupportedFlavorException {
//		System.out.println("Testcase 3: Chức năng Export Sao Chép Số Giờ Quy Đổi theo Học Kỳ và chọn 1 ngành");
//		FileInputStream fis = new FileInputStream("K:\\Automation\\ExportSGQĐNH.xlsx");
//		XSSFWorkbook workbook = new XSSFWorkbook(fis);
//		XSSFSheet sheet = workbook.getSheetAt(0);
//		XSSFRow row = sheet.getRow(1);
//		// Đọc giá trị từ cột A (index 0) từ hàng đã chọn và gán vào biến idString
//		String stringHK = row.getCell(0).getStringCellValue();
//
//		// Đọc giá trị từ cột B (index 1) từ hàng đã chọn và gán vào biến fullnameString
//		String stringNganh = row.getCell(1).getStringCellValue();
//		driver.findElement(By.xpath("//*[@id=\"termDiv\"]/div/span/span[1]")).click();
//		driver.findElement(By.xpath("//*[@id=\"termDiv\"]/div/span[2]/span/span[1]/input")).sendKeys(stringHK);
//		driver.findElement(By.xpath("//*[@id=\"termDiv\"]/div/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
//		Thread.sleep(2000);
//		driver.findElement(By.xpath(
//				"/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[1]/span[1]/span"))
//				.click();
//		driver.findElement(By.xpath(
//				"/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input"))
//				.sendKeys(stringNganh);
//		driver.findElement(By.xpath(
//				"/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input"))
//				.sendKeys(Keys.ENTER);
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"table-tab\"]")).click();
//
//		// Print
//		WebElement printElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/div[2]/div/div/div/div[1]/div[2]/div/div[2]/button"));
//		printElement.click();
//		Thread.sleep(1000);
//		WebElement printOptionElement = driver.findElement(
//				By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/div[2]/div/div/div/div[1]/div[2]/div/div[2]/div[2]/div/button[4]"));
//		Thread.sleep(2000);
//		printOptionElement.click();
//
//		Thread.sleep(300);
//		WebElement thongbaoElement = driver.findElement(By.xpath("/html/body/div[3]/h2"));
//		String dulieuString = thongbaoElement.getText();
//
//		// Sao chép table
//		WebElement bangdulieuElement = driver.findElement(By.xpath(
//				"//*[@id=\"tblStatistics\"]/tbody"));
//		String dulieumongdoiString = bangdulieuElement.getText();
//
//		// Xác nhận đã vào giao diện bảng biểu
//		WebElement confirmElement = driver.findElement(By.xpath("//*[@id=\"tblStatistics_length\"]/label"));
//		if (confirmElement.getText().contains("Hiển thị")) {
//			// In dữ liệu từ clipboard
//			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//			String duLieu = (String) clipboard.getData(DataFlavor.stringFlavor);
//			System.out.println(dulieuString);
//			System.out.println("Kết quả mong đợi: " + dulieumongdoiString);
//			System.out.println("Kết quả thực tế: " + duLieu);
//
//		} else {
//			System.out.println("Xem thất bại!!");
//		}
//		driver.navigate().refresh();
//
//	}
//	@Test (priority = 4)
//	public void Export4() throws UnsupportedFlavorException, IOException, InterruptedException, AWTException {
//
//		System.out.println("Testcase 4: Chức năng Export In ấn Số Giờ Quy Đổi theo Học Kỳ và chọn 1 ngành ");
//		FileInputStream fis = new FileInputStream("K:\\Automation\\ExportSGQĐNH.xlsx");
//		XSSFWorkbook workbook = new XSSFWorkbook(fis);
//		XSSFSheet sheet = workbook.getSheetAt(0);
//		XSSFRow row = sheet.getRow(1);
//		// Đọc giá trị từ cột A (index 0) từ hàng đã chọn và gán vào biến idString
//		String stringHK = row.getCell(0).getStringCellValue();
//
//		// Đọc giá trị từ cột B (index 1) từ hàng đã chọn và gán vào biến fullnameString
//		String stringNganh = row.getCell(1).getStringCellValue();
//		driver.findElement(By.xpath("//*[@id=\"termDiv\"]/div/span/span[1]")).click();
//		driver.findElement(By.xpath("//*[@id=\"termDiv\"]/div/span[2]/span/span[1]/input")).sendKeys(stringHK);
//		driver.findElement(By.xpath("//*[@id=\"termDiv\"]/div/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
//		Thread.sleep(2000);
//		driver.findElement(By.xpath(
//				"/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[1]/span[1]/span"))
//				.click();
//		driver.findElement(By.xpath(
//				"/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input"))
//				.sendKeys(stringNganh);
//		driver.findElement(By.xpath(
//				"/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input"))
//				.sendKeys(Keys.ENTER);
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"table-tab\"]")).click();
//
//		WebElement printElement = driver
//				.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/div[2]/div/div/div/div[1]/div[2]/div/div[2]/button"));
//		printElement.click();
//		Thread.sleep(1000);
//		WebElement printOptionElement = driver.findElement(
//				By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/div[2]/div/div/div/div[1]/div[2]/div/div[2]/div[2]/div/button[1]"));
//		printOptionElement.click();
//		Robot robot = new Robot();
//		WebElement confirmElement = driver.findElement(By.xpath("//*[@id=\"tblStatistics_length\"]/label"));
//		if (confirmElement.getText().contains("Hiển thị")) {
//
//			Thread.sleep(2000);
//			robot.keyPress(KeyEvent.VK_ENTER);
//			robot.keyRelease(KeyEvent.VK_ENTER);
//			Thread.sleep(2000);
//			robot.keyPress(KeyEvent.VK_CONTROL);
//			robot.keyPress(KeyEvent.VK_C);
//			robot.keyRelease(KeyEvent.VK_CONTROL);
//			robot.keyRelease(KeyEvent.VK_C);
//			Thread.sleep(2000);
//			robot.keyPress(KeyEvent.VK_ENTER);
//			robot.keyRelease(KeyEvent.VK_ENTER);
//			// In dữ liệu từ clipboard
//			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//			String duLieu = (String) clipboard.getData(DataFlavor.stringFlavor);
//
//			System.out
//					.println("Kết quả mong đợi: ThongKeChiTietSoGio_HK" + stringHK + "_Nganh_" + stringNganh + ".pdf");
//			System.out.println("Kết quả thực tế: " + duLieu);
//
//		} else {
//			System.out.println("Xem thất bại!!");
//		}
//		driver.navigate().refresh();
//
//
//	}
//	@Test (priority = 5)
//	public void Export5() throws UnsupportedFlavorException, IOException, InterruptedException, AWTException {
//
//		System.out.println("Testcase 5: Chức năng Export In ấn Số Giờ Quy Đổi theo Học Kỳ và chọn ngành Tất cả ");
//		FileInputStream fis = new FileInputStream("K:\\Automation\\ExportSGQĐNH.xlsx");
//		XSSFWorkbook workbook = new XSSFWorkbook(fis);
//		XSSFSheet sheet = workbook.getSheetAt(0);
//		XSSFRow row = sheet.getRow(0);
//		// Đọc giá trị từ cột A (index 0) từ hàng đã chọn và gán vào biến idString
//		String stringHK = row.getCell(0).getStringCellValue();
//
//		// Đọc giá trị từ cột B (index 1) từ hàng đã chọn và gán vào biến fullnameString
//		String stringNganh = row.getCell(1).getStringCellValue();
//		driver.findElement(By.xpath("//*[@id=\"isLesson\"]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"termDiv\"]/div/span/span[1]")).click();
//		driver.findElement(By.xpath("//*[@id=\"termDiv\"]/div/span[2]/span/span[1]/input")).sendKeys(stringHK);
//		driver.findElement(By.xpath("//*[@id=\"termDiv\"]/div/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
//		Thread.sleep(2000);
//		driver.findElement(By.xpath(
//				"/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[1]/span[1]/span"))
//				.click();
//		driver.findElement(By.xpath(
//				"/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input"))
//				.sendKeys(stringNganh);
//		driver.findElement(By.xpath(
//				"/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input"))
//				.sendKeys(Keys.ENTER);
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"table-tab\"]")).click();
//
//		WebElement printElement = driver
//				.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/div[2]/div/div/div/div[1]/div[2]/div/div[2]/button"));
//		printElement.click();
//		Thread.sleep(1000);
//		WebElement printOptionElement = driver.findElement(
//				By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/div[2]/div/div/div/div[1]/div[2]/div/div[2]/div[2]/div/button[1]"));
//		printOptionElement.click();
//
//		Robot robot = new Robot();
//		WebElement confirmElement = driver.findElement(By.xpath("//*[@id=\"tblStatistics_length\"]/label"));
//		if (confirmElement.getText().contains("Hiển thị")) {
//
//			Thread.sleep(2000);
//			robot.keyPress(KeyEvent.VK_ENTER);
//			robot.keyRelease(KeyEvent.VK_ENTER);
//			Thread.sleep(2000);
//			robot.keyPress(KeyEvent.VK_CONTROL);
//			robot.keyPress(KeyEvent.VK_C);
//			robot.keyRelease(KeyEvent.VK_CONTROL);
//			robot.keyRelease(KeyEvent.VK_C);
//			Thread.sleep(2000);
//			robot.keyPress(KeyEvent.VK_ENTER);
//			robot.keyRelease(KeyEvent.VK_ENTER);
//			// In dữ liệu từ clipboard
//			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//			String duLieu = (String) clipboard.getData(DataFlavor.stringFlavor);
//
//			System.out
//					.println("Kết quả mong đợi: ThongKeChiTietSoGio_HK" + stringHK + "_Nganh_" + stringNganh + ".pdf");
//			System.out.println("Kết quả thực tế: " + duLieu);
//
//		} else {
//			System.out.println("Xem thất bại!!");
//		}
//		driver.navigate().refresh();
//
//
//	}
//
//	@Test (priority = 6)
//	public void Export6() throws IOException, InterruptedException, UnsupportedFlavorException {
//		System.out.println("Testcase 6: Chức năng Export Sao Chép Số Giờ Quy Đổi theo Học Kỳ và chọn ngành Tất cả");
//		FileInputStream fis = new FileInputStream("K:\\Automation\\ExportSGQĐNH.xlsx");
//		XSSFWorkbook workbook = new XSSFWorkbook(fis);
//		XSSFSheet sheet = workbook.getSheetAt(0);
//		XSSFRow row = sheet.getRow(0);
//		// Đọc giá trị từ cột A (index 0) từ hàng đã chọn và gán vào biến idString
//		String stringHK = row.getCell(0).getStringCellValue();
//		// Đọc giá trị từ cột B (index 1) từ hàng đã chọn và gán vào biến fullnameString
//		String stringNganh = row.getCell(1).getStringCellValue();
//		driver.findElement(By.xpath("//*[@id=\"isLesson\"]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"termDiv\"]/div/span/span[1]")).click();
//		driver.findElement(By.xpath("//*[@id=\"termDiv\"]/div/span[2]/span/span[1]/input")).sendKeys(stringHK);
//		driver.findElement(By.xpath("//*[@id=\"termDiv\"]/div/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
//		Thread.sleep(2000);
//		driver.findElement(By.xpath(
//				"/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[1]/span[1]/span"))
//				.click();
//		driver.findElement(By.xpath(
//				"/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input"))
//				.sendKeys(stringNganh);
//		driver.findElement(By.xpath(
//				"/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input"))
//				.sendKeys(Keys.ENTER);
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"table-tab\"]")).click();
//
//		// Print
//		WebElement printElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/div[2]/div/div/div/div[1]/div[2]/div/div[2]/button"));
//		printElement.click();
//		Thread.sleep(1000);
//		WebElement printOptionElement = driver.findElement(
//				By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/div[2]/div/div/div/div[1]/div[2]/div/div[2]/div[2]/div/button[4]"));
//		Thread.sleep(2000);
//		printOptionElement.click();
//		Thread.sleep(300);
//		WebElement thongbaoElement = driver.findElement(By.xpath("/html/body/div[3]/h2"));
//		String dulieuString = thongbaoElement.getText();
//
//		// Sao chép table
//		WebElement bangdulieuElement = driver.findElement(By.xpath(
//				"//*[@id=\"tblStatistics\"]/tbody"));
//		String dulieumongdoiString = bangdulieuElement.getText();
//
//		// Xác nhận đã vào giao diện bảng biểu
//		WebElement confirmElement = driver.findElement(By.xpath("//*[@id=\"tblStatistics_length\"]/label"));
//		if (confirmElement.getText().contains("Hiển thị")) {
//			// In dữ liệu từ clipboard
//			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//			String duLieu = (String) clipboard.getData(DataFlavor.stringFlavor);
//			System.out.println(dulieuString);
//			System.out.println("Kết quả mong đợi: " + dulieumongdoiString);
//			System.out.println("Kết quả thực tế: " + duLieu);
//
//		} else {
//			System.out.println("Xem thất bại!!");
//		}
//		driver.navigate().refresh();
//	}
//	@Test (priority = 7)
//	public void Export7() throws IOException, InterruptedException, UnsupportedFlavorException {
//		System.out.println("Testcase 3: Chức năng Export Sao Chép Số Giờ Quy Đổi theo Học Kỳ và chọn 1 ngành");
//		FileInputStream fis = new FileInputStream("K:\\Automation\\ExportSGQĐNH.xlsx");
//		XSSFWorkbook workbook = new XSSFWorkbook(fis);
//		XSSFSheet sheet = workbook.getSheetAt(0);
//		XSSFRow row = sheet.getRow(1);
//		// Đọc giá trị từ cột A (index 0) từ hàng đã chọn và gán vào biến idString
//		String stringHK = row.getCell(0).getStringCellValue();
//		// Đọc giá trị từ cột B (index 1) từ hàng đã chọn và gán vào biến fullnameString
//		driver.findElement(By.xpath("//*[@id=\"isLesson\"]")).click();
//		String stringNganh = row.getCell(1).getStringCellValue();
//		driver.findElement(By.xpath("//*[@id=\"termDiv\"]/div/span/span[1]")).click();
//		driver.findElement(By.xpath("//*[@id=\"termDiv\"]/div/span[2]/span/span[1]/input")).sendKeys(stringHK);
//		driver.findElement(By.xpath("//*[@id=\"termDiv\"]/div/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
//		Thread.sleep(2000);
//		driver.findElement(By.xpath(
//				"/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[1]/span[1]/span"))
//				.click();
//		driver.findElement(By.xpath(
//				"/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input"))
//				.sendKeys(stringNganh);
//		driver.findElement(By.xpath(
//				"/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input"))
//				.sendKeys(Keys.ENTER);
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"table-tab\"]")).click();
//
//		// Print
//		WebElement printElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/div[2]/div/div/div/div[1]/div[2]/div/div[2]/button"));
//		printElement.click();
//		Thread.sleep(1000);
//		WebElement printOptionElement = driver.findElement(
//				By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/div[2]/div/div/div/div[1]/div[2]/div/div[2]/div[2]/div/button[4]"));
//		Thread.sleep(2000);
//		printOptionElement.click();
//
//		Thread.sleep(300);
//		WebElement thongbaoElement = driver.findElement(By.xpath("/html/body/div[3]/h2"));
//		String dulieuString = thongbaoElement.getText();
//
//		// Sao chép table
//		WebElement bangdulieuElement = driver.findElement(By.xpath(
//				"//*[@id=\"tblStatistics\"]/tbody"));
//		String dulieumongdoiString = bangdulieuElement.getText();
//
//		// Xác nhận đã vào giao diện bảng biểu
//		WebElement confirmElement = driver.findElement(By.xpath("//*[@id=\"tblStatistics_length\"]/label"));
//		if (confirmElement.getText().contains("Hiển thị")) {
//			// In dữ liệu từ clipboard
//			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//			String duLieu = (String) clipboard.getData(DataFlavor.stringFlavor);
//			System.out.println(dulieuString);
//			System.out.println("Kết quả mong đợi: " + dulieumongdoiString);
//			System.out.println("Kết quả thực tế: " + duLieu);
//
//		} else {
//			System.out.println("Xem thất bại!!");
//		}
//		driver.navigate().refresh();
//
//	}
//	@Test (priority = 8)
//	public void Export8() throws UnsupportedFlavorException, IOException, InterruptedException, AWTException {
//
//		System.out.println("Testcase 4: Chức năng Export In ấn Số Giờ Quy Đổi theo Học Kỳ và chọn 1 ngành ");
//		FileInputStream fis = new FileInputStream("K:\\Automation\\ExportSGQĐNH.xlsx");
//		XSSFWorkbook workbook = new XSSFWorkbook(fis);
//		XSSFSheet sheet = workbook.getSheetAt(0);
//		XSSFRow row = sheet.getRow(1);
//		// Đọc giá trị từ cột A (index 0) từ hàng đã chọn và gán vào biến idString
//		String stringHK = row.getCell(0).getStringCellValue();
//
//		// Đọc giá trị từ cột B (index 1) từ hàng đã chọn và gán vào biến fullnameString
//		String stringNganh = row.getCell(1).getStringCellValue();
//		driver.findElement(By.xpath("//*[@id=\"isLesson\"]")).click();
//		driver.findElement(By.xpath("//*[@id=\"termDiv\"]/div/span/span[1]")).click();
//		driver.findElement(By.xpath("//*[@id=\"termDiv\"]/div/span[2]/span/span[1]/input")).sendKeys(stringHK);
//		driver.findElement(By.xpath("//*[@id=\"termDiv\"]/div/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
//		Thread.sleep(2000);
//		driver.findElement(By.xpath(
//				"/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[1]/span[1]/span"))
//				.click();
//		driver.findElement(By.xpath(
//				"/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input"))
//				.sendKeys(stringNganh);
//		driver.findElement(By.xpath(
//				"/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input"))
//				.sendKeys(Keys.ENTER);
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"table-tab\"]")).click();
//
//		WebElement printElement = driver
//				.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/div[2]/div/div/div/div[1]/div[2]/div/div[2]/button"));
//		printElement.click();
//		Thread.sleep(1000);
//		WebElement printOptionElement = driver.findElement(
//				By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/div[2]/div/div/div/div[1]/div[2]/div/div[2]/div[2]/div/button[1]"));
//		printOptionElement.click();
//
//		Robot robot = new Robot();
//		WebElement confirmElement = driver.findElement(By.xpath("//*[@id=\"tblStatistics_length\"]/label"));
//		if (confirmElement.getText().contains("Hiển thị")) {
//
//			Thread.sleep(2000);
//			robot.keyPress(KeyEvent.VK_ENTER);
//			robot.keyRelease(KeyEvent.VK_ENTER);
//			Thread.sleep(2000);
//			robot.keyPress(KeyEvent.VK_CONTROL);
//			robot.keyPress(KeyEvent.VK_C);
//			robot.keyRelease(KeyEvent.VK_CONTROL);
//			robot.keyRelease(KeyEvent.VK_C);
//			Thread.sleep(2000);
//			robot.keyPress(KeyEvent.VK_ENTER);
//			robot.keyRelease(KeyEvent.VK_ENTER);
//			// In dữ liệu từ clipboard
//			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//			String duLieu = (String) clipboard.getData(DataFlavor.stringFlavor);
//
//			System.out
//					.println("Kết quả mong đợi: ThongKeChiTietSoGio_HK" + stringHK + "_Nganh_" + stringNganh + ".pdf");
//			System.out.println("Kết quả thực tế: " + duLieu);
//
//		} else {
//			System.out.println("Xem thất bại!!");
//		}
//		driver.navigate().refresh();
//
//
//	}
//	@Test(priority =9)
//	public void Export9() throws UnsupportedFlavorException, IOException, InterruptedException, AWTException {
//		System.out.println("Testcase 9: Chức năng Export In ấn Số Giờ Quy Đổi theo Học Kỳ và chọn ngành Tất Cả và chọn mục Chi Tiết");
//		FileInputStream fis = new FileInputStream("K:\\Automation\\ExportSGQĐNH.xlsx");
//		XSSFWorkbook workbook = new XSSFWorkbook(fis);
//		XSSFSheet sheet = workbook.getSheetAt(0);
//		XSSFRow row = sheet.getRow(0);
//		// Đọc giá trị từ cột A (index 0) từ hàng đã chọn và gán vào biến idString
//		String stringHK = row.getCell(0).getStringCellValue();
//
//		String stringNganh = row.getCell(1).getStringCellValue();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"termDiv\"]/div/span/span[1]")).click();
//		driver.findElement(By.xpath("//*[@id=\"termDiv\"]/div/span[2]/span/span[1]/input")).sendKeys(stringHK);
//		driver.findElement(By.xpath("//*[@id=\"termDiv\"]/div/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
//		Thread.sleep(2000);
//		driver.findElement(By.xpath(
//				"/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[1]/span[1]/span"))
//				.click();
//		driver.findElement(By.xpath(
//				"/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input"))
//				.sendKeys(stringNganh);
//		driver.findElement(By.xpath(
//				"/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input"))
//				.sendKeys(Keys.ENTER);
//		Thread.sleep(4000);
//		driver.findElement(By.xpath("//*[@id=\"details-tab\"]")).click();
//		Thread.sleep(2000);
//		WebElement printElement = driver
//				.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/div[3]/div/div/div/div[1]/div[2]/div/div[2]/button"));
//		printElement.click();
//		Thread.sleep(2000);
//		WebElement printOptionElement = driver.findElement(
//				By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/div[3]/div/div/div/div[1]/div[2]/div/div[2]/div[2]/div/button[1]"));
//		printOptionElement.click();
//		
//		
//		Robot robot = new Robot();
//		WebElement confirmElement = driver.findElement(By.xpath("//*[@id=\"tblStatisticsDetails_length\"]/label"));
//		if (confirmElement.getText().contains("Hiển thị")) {
//
//			Thread.sleep(2000);
//			robot.keyPress(KeyEvent.VK_ENTER);
//			robot.keyRelease(KeyEvent.VK_ENTER);
//			Thread.sleep(2000);
//			robot.keyPress(KeyEvent.VK_CONTROL);
//			robot.keyPress(KeyEvent.VK_C);
//			robot.keyRelease(KeyEvent.VK_CONTROL);
//			robot.keyRelease(KeyEvent.VK_C);
//			Thread.sleep(2000);
//			robot.keyPress(KeyEvent.VK_ENTER);
//			robot.keyRelease(KeyEvent.VK_ENTER);
//			// In dữ liệu từ clipboard
//			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//			String duLieu = (String) clipboard.getData(DataFlavor.stringFlavor);
//
//			System.out
//					.println("Kết quả mong đợi: ThongKeChiTietSoGio_HK" + stringHK + "_Nganh_" + stringNganh + ".pdf");
//			System.out.println("Kết quả thực tế: " + duLieu);
//
//		} else {
//			System.out.println("Xem thất bại!!");
//		}
//		driver.navigate().refresh();
//	}

//	@Test (priority =10)
//	public void Export10() throws IOException, InterruptedException, UnsupportedFlavorException {
//		System.out.println("Testcase 10: Chức năng Export Sao Chép Số Giờ Quy Đổi theo Học Kỳ và chọn ngành Tất cả và chọn mục Chi Tiết");
//		FileInputStream fis = new FileInputStream("K:\\Automation\\ExportSGQĐNH.xlsx");
//		XSSFWorkbook workbook = new XSSFWorkbook(fis);
//		XSSFSheet sheet = workbook.getSheetAt(0);
//		XSSFRow row = sheet.getRow(0);
//		// Đọc giá trị từ cột A (index 0) từ hàng đã chọn và gán vào biến idString
//		String stringHK = row.getCell(0).getStringCellValue();
//		// Đọc giá trị từ cột B (index 1) từ hàng đã chọn và gán vào biến fullnameString
//		String stringNganh = row.getCell(1).getStringCellValue();
//		
//		driver.findElement(By.xpath("//*[@id=\"termDiv\"]/div/span/span[1]")).click();
//		driver.findElement(By.xpath("//*[@id=\"termDiv\"]/div/span[2]/span/span[1]/input")).sendKeys(stringHK);
//		driver.findElement(By.xpath("//*[@id=\"termDiv\"]/div/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
//		Thread.sleep(2000);
//		driver.findElement(By.xpath(
//				"/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[1]/span[1]/span"))
//				.click();
//		driver.findElement(By.xpath(
//				"/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input"))
//				.sendKeys(stringNganh);
//		driver.findElement(By.xpath(
//				"/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input"))
//				.sendKeys(Keys.ENTER);
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"details-tab\"]")).click();
//		
//		// Print
//		WebElement printElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/div[3]/div/div/div/div[1]/div[2]/div/div[2]/button"));
//		printElement.click();
//		Thread.sleep(2000);
//		WebElement printOptionElement = driver.findElement(
//				By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/div[3]/div/div/div/div[1]/div[2]/div/div[2]/div[2]/div/button[4]"));
//		Thread.sleep(2000);
//		printOptionElement.click();
//		Thread.sleep(300);
//		WebElement thongbaoElement = driver.findElement(By.xpath("/html/body/div[3]/h2"));
//		String dulieuString = thongbaoElement.getText();
//
//		// Sao chép table
//		WebElement bangdulieuElement = driver.findElement(By.xpath(
//				"//*[@id=\"tblStatisticsDetails\"]/tbody"));
//		String dulieumongdoiString = bangdulieuElement.getText();
//
//		// Xác nhận đã vào giao diện bảng biểu
//		WebElement confirmElement = driver.findElement(By.xpath("//*[@id=\"tblStatisticsDetails_length\"]/label"));
//		if (confirmElement.getText().contains("Hiển thị")) {
//			// In dữ liệu từ clipboard
//			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//			String duLieu = (String) clipboard.getData(DataFlavor.stringFlavor);
//			System.out.println(dulieuString);
//			System.out.println("Kết quả mong đợi: " + dulieumongdoiString);
//			System.out.println("Kết quả thực tế: " + duLieu);
//
//		} else {
//			System.out.println("Xem thất bại!!");
//		}
//		driver.navigate().refresh();
//	}
//	@Test (priority =11)
//	public void Export11() throws IOException, InterruptedException, UnsupportedFlavorException {
//		System.out.println("Testcase 11: Chức năng Export Sao Chép Số Giờ Quy Đổi theo Học Kỳ và chọn 1 ngành và chọn mục Chi Tiết");
//		FileInputStream fis = new FileInputStream("K:\\Automation\\ExportSGQĐNH.xlsx");
//		XSSFWorkbook workbook = new XSSFWorkbook(fis);
//		XSSFSheet sheet = workbook.getSheetAt(0);
//		XSSFRow row = sheet.getRow(1);
//		// Đọc giá trị từ cột A (index 0) từ hàng đã chọn và gán vào biến idString
//		String stringHK = row.getCell(0).getStringCellValue();
//	
//		// Đọc giá trị từ cột B (index 1) từ hàng đã chọn và gán vào biến fullnameString
//		String stringNganh = row.getCell(1).getStringCellValue();
//		driver.findElement(By.xpath("//*[@id=\"termDiv\"]/div/span/span[1]")).click();
//		driver.findElement(By.xpath("//*[@id=\"termDiv\"]/div/span[2]/span/span[1]/input")).sendKeys(stringHK);
//		driver.findElement(By.xpath("//*[@id=\"termDiv\"]/div/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
//		Thread.sleep(2000);
//		driver.findElement(By.xpath(
//				"/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[1]/span[1]/span"))
//				.click();
//		driver.findElement(By.xpath(
//				"/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input"))
//				.sendKeys(stringNganh);
//		driver.findElement(By.xpath(
//				"/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input"))
//				.sendKeys(Keys.ENTER);
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"details-tab\"]")).click();
//
//		// Print
//		WebElement printElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/div[3]/div/div/div/div[1]/div[2]/div/div[2]/button"));
//		printElement.click();
//		Thread.sleep(2000);
//		WebElement printOptionElement = driver.findElement(
//				By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/div[3]/div/div/div/div[1]/div[2]/div/div[2]/div[2]/div/button[4]"));
//		Thread.sleep(2000);
//		printOptionElement.click();
//
//		Thread.sleep(300);
//		WebElement thongbaoElement = driver.findElement(By.xpath("/html/body/div[3]/h2"));
//		String dulieuString = thongbaoElement.getText();
//
//		// Sao chép table
//		WebElement bangdulieuElement = driver.findElement(By.xpath(
//				"//*[@id=\"tblStatisticsDetails\"]/tbody"));
//		String dulieumongdoiString = bangdulieuElement.getText();
//
//		// Xác nhận đã vào giao diện bảng biểu
//		WebElement confirmElement = driver.findElement(By.xpath("//*[@id=\"tblStatisticsDetails_length\"]/label"));
//		if (confirmElement.getText().contains("Hiển thị")) {
//			// In dữ liệu từ clipboard
//			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//			String duLieu = (String) clipboard.getData(DataFlavor.stringFlavor);
//			System.out.println(dulieuString);
//			System.out.println("Kết quả mong đợi: " + dulieumongdoiString);
//			System.out.println("Kết quả thực tế: " + duLieu);
//
//		} else {
//			System.out.println("Xem thất bại!!");
//		}
//		driver.navigate().refresh();
//
//	}
//	@Test (priority =12)
//	public void Export12() throws UnsupportedFlavorException, IOException, InterruptedException, AWTException {
//
//		System.out.println("Testcase 12: Chức năng Export In ấn Số Giờ Quy Đổi theo Học Kỳ và chọn 1 ngành và chọn mục Chi Tiết ");
//		FileInputStream fis = new FileInputStream("K:\\Automation\\ExportSGQĐNH.xlsx");
//		XSSFWorkbook workbook = new XSSFWorkbook(fis);
//		XSSFSheet sheet = workbook.getSheetAt(0);
//		XSSFRow row = sheet.getRow(1);
//		// Đọc giá trị từ cột A (index 0) từ hàng đã chọn và gán vào biến idString
//		String stringHK = row.getCell(0).getStringCellValue();
//
//		// Đọc giá trị từ cột B (index 1) từ hàng đã chọn và gán vào biến fullnameString
//		String stringNganh = row.getCell(1).getStringCellValue();
//		driver.findElement(By.xpath("//*[@id=\"termDiv\"]/div/span/span[1]")).click();
//		driver.findElement(By.xpath("//*[@id=\"termDiv\"]/div/span[2]/span/span[1]/input")).sendKeys(stringHK);
//		driver.findElement(By.xpath("//*[@id=\"termDiv\"]/div/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
//		Thread.sleep(2000);
//		driver.findElement(By.xpath(
//				"/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[1]/span[1]/span"))
//				.click();
//		driver.findElement(By.xpath(
//				"/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input"))
//				.sendKeys(stringNganh);
//		driver.findElement(By.xpath(
//				"/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input"))
//				.sendKeys(Keys.ENTER);
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"details-tab\"]")).click();
//
//		WebElement printElement = driver
//				.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/div[3]/div/div/div/div[1]/div[2]/div/div[2]/button"));
//		printElement.click();
//		Thread.sleep(2000);
//		WebElement printOptionElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/div[3]/div/div/div/div[1]/div[2]/div/div[2]/div[2]/div/button[1]"));
//		printOptionElement.click();	
//
//		Robot robot = new Robot();
//		WebElement confirmElement = driver.findElement(By.xpath("//*[@id=\"tblStatisticsDetails_length\"]/label"));
//		if (confirmElement.getText().contains("Hiển thị")) {
//
//			Thread.sleep(2000);
//			robot.keyPress(KeyEvent.VK_ENTER);
//			robot.keyRelease(KeyEvent.VK_ENTER);
//			Thread.sleep(2000);
//			robot.keyPress(KeyEvent.VK_CONTROL);
//			robot.keyPress(KeyEvent.VK_C);
//			robot.keyRelease(KeyEvent.VK_CONTROL);
//			robot.keyRelease(KeyEvent.VK_C);
//			Thread.sleep(2000);
//			robot.keyPress(KeyEvent.VK_ENTER);
//			robot.keyRelease(KeyEvent.VK_ENTER);
//			// In dữ liệu từ clipboard
//			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//			String duLieu = (String) clipboard.getData(DataFlavor.stringFlavor);
//
//			System.out
//					.println("Kết quả mong đợi: ThongKeChiTietSoGio_HK" + stringHK + "_Nganh_" + stringNganh + ".pdf");
//			System.out.println("Kết quả thực tế: " + duLieu);
//
//		} else {
//			System.out.println("Xem thất bại!!");
//		}
//		driver.navigate().refresh();
//
//
//	}
//	@Test (priority =13)
//	public void Export13() throws UnsupportedFlavorException, IOException, InterruptedException, AWTException {
//
//		System.out.println("Testcase 13: Chức năng Export In ấn Số Giờ Quy Đổi theo Học Kỳ và chọn ngành Tất cả và chọn mục Chi Tiết");
//		FileInputStream fis = new FileInputStream("K:\\Automation\\ExportSGQĐNH.xlsx");
//		XSSFWorkbook workbook = new XSSFWorkbook(fis);
//		XSSFSheet sheet = workbook.getSheetAt(0);
//		XSSFRow row = sheet.getRow(0);
//		// Đọc giá trị từ cột A (index 0) từ hàng đã chọn và gán vào biến idString
//		String stringHK = row.getCell(0).getStringCellValue();
//
//		// Đọc giá trị từ cột B (index 1) từ hàng đã chọn và gán vào biến fullnameString
//		String stringNganh = row.getCell(1).getStringCellValue();
//		driver.findElement(By.xpath("//*[@id=\"isLesson\"]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"termDiv\"]/div/span/span[1]")).click();
//		driver.findElement(By.xpath("//*[@id=\"termDiv\"]/div/span[2]/span/span[1]/input")).sendKeys(stringHK);
//		driver.findElement(By.xpath("//*[@id=\"termDiv\"]/div/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
//		Thread.sleep(2000);
//		driver.findElement(By.xpath(
//				"/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[1]/span[1]/span"))
//				.click();
//		driver.findElement(By.xpath(
//				"/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input"))
//				.sendKeys(stringNganh);
//		driver.findElement(By.xpath(
//				"/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input"))
//				.sendKeys(Keys.ENTER);
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"details-tab\"]")).click();
//
//		WebElement printElement = driver
//				.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/div[3]/div/div/div/div[1]/div[2]/div/div[2]/button"));
//		printElement.click();
//		Thread.sleep(2000);
//		WebElement printOptionElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/div[3]/div/div/div/div[1]/div[2]/div/div[2]/div[2]/div/button[1]"));
//		printOptionElement.click();	
//
//		Robot robot = new Robot();
//		WebElement confirmElement = driver.findElement(By.xpath("//*[@id=\"tblStatisticsDetails_length\"]/label"));
//		if (confirmElement.getText().contains("Hiển thị")) {
//
//			Thread.sleep(2000);
//			robot.keyPress(KeyEvent.VK_ENTER);
//			robot.keyRelease(KeyEvent.VK_ENTER);
//			Thread.sleep(2000);
//			robot.keyPress(KeyEvent.VK_CONTROL);
//			robot.keyPress(KeyEvent.VK_C);
//			robot.keyRelease(KeyEvent.VK_CONTROL);
//			robot.keyRelease(KeyEvent.VK_C);
//			Thread.sleep(2000);
//			robot.keyPress(KeyEvent.VK_ENTER);
//			robot.keyRelease(KeyEvent.VK_ENTER);
//			// In dữ liệu từ clipboard
//			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//			String duLieu = (String) clipboard.getData(DataFlavor.stringFlavor);
//
//			System.out
//					.println("Kết quả mong đợi: ThongKeChiTietSoGio_HK" + stringHK + "_Nganh_" + stringNganh + ".pdf");
//			System.out.println("Kết quả thực tế: " + duLieu);
//
//		} else {
//			System.out.println("Xem thất bại!!");
//		}
//		driver.navigate().refresh();
//
//
//	}
//
//	@Test(priority = 14)
//	public void Export14() throws IOException, InterruptedException, UnsupportedFlavorException {
//		System.out.println("Testcase 14: Chức năng Export Sao Chép Số Giờ Quy Đổi theo Học Kỳ và chọn ngành Tất cả và chọn mục Chi Tiết");
//		FileInputStream fis = new FileInputStream("K:\\Automation\\ExportSGQĐNH.xlsx");
//		XSSFWorkbook workbook = new XSSFWorkbook(fis);
//		XSSFSheet sheet = workbook.getSheetAt(0);
//		XSSFRow row = sheet.getRow(0);
//		// Đọc giá trị từ cột A (index 0) từ hàng đã chọn và gán vào biến idString
//		String stringHK = row.getCell(0).getStringCellValue();
//		// Đọc giá trị từ cột B (index 1) từ hàng đã chọn và gán vào biến fullnameString
//		String stringNganh = row.getCell(1).getStringCellValue();
//		driver.findElement(By.xpath("//*[@id=\"isLesson\"]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"termDiv\"]/div/span/span[1]")).click();
//		driver.findElement(By.xpath("//*[@id=\"termDiv\"]/div/span[2]/span/span[1]/input")).sendKeys(stringHK);
//		driver.findElement(By.xpath("//*[@id=\"termDiv\"]/div/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
//		Thread.sleep(2000);
//		driver.findElement(By.xpath(
//				"/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[1]/span[1]/span"))
//				.click();
//		driver.findElement(By.xpath(
//				"/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input"))
//				.sendKeys(stringNganh);
//		driver.findElement(By.xpath(
//				"/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input"))
//				.sendKeys(Keys.ENTER);
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"details-tab\"]")).click();
//
//		// Print
//		WebElement printElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/div[3]/div/div/div/div[1]/div[2]/div/div[2]/button"));
//		printElement.click();
//		Thread.sleep(2000);
//		WebElement printOptionElement = driver.findElement(
//				By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/div[3]/div/div/div/div[1]/div[2]/div/div[2]/div[2]/div/button[4]"));
//		Thread.sleep(2000);
//		printOptionElement.click();
//		Thread.sleep(300);
//		WebElement thongbaoElement = driver.findElement(By.xpath("/html/body/div[3]/h2"));
//		String dulieuString = thongbaoElement.getText();
//
//		// Sao chép table
//		WebElement bangdulieuElement = driver.findElement(By.xpath(
//				"//*[@id=\"tblStatisticsDetails\"]/tbody"));
//		String dulieumongdoiString = bangdulieuElement.getText();
//
//		// Xác nhận đã vào giao diện bảng biểu
//		WebElement confirmElement = driver.findElement(By.xpath("//*[@id=\"tblStatisticsDetails_length\"]/label"));
//		if (confirmElement.getText().contains("Hiển thị")) {
//			// In dữ liệu từ clipboard
//			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//			String duLieu = (String) clipboard.getData(DataFlavor.stringFlavor);
//			System.out.println(dulieuString);
//			System.out.println("Kết quả mong đợi: " + dulieumongdoiString);
//			System.out.println("Kết quả thực tế: " + duLieu);
//
//		} else {
//			System.out.println("Xem thất bại!!");
//		}
//		driver.navigate().refresh();
//	}
//	@Test (priority = 15)
//	public void Export15() throws IOException, InterruptedException, UnsupportedFlavorException {
//		System.out.println("Testcase 15: Chức năng Export Sao Chép Số Giờ Quy Đổi theo Học Kỳ và chọn 1 ngành và chọn mục Chi Tiết");
//		FileInputStream fis = new FileInputStream("K:\\Automation\\ExportSGQĐNH.xlsx");
//		XSSFWorkbook workbook = new XSSFWorkbook(fis);
//		XSSFSheet sheet = workbook.getSheetAt(0);
//		XSSFRow row = sheet.getRow(1);
//		// Đọc giá trị từ cột A (index 0) từ hàng đã chọn và gán vào biến idString
//		String stringHK = row.getCell(0).getStringCellValue();
//		// Đọc giá trị từ cột B (index 1) từ hàng đã chọn và gán vào biến fullnameString
//		driver.findElement(By.xpath("//*[@id=\"isLesson\"]")).click();
//		String stringNganh = row.getCell(1).getStringCellValue();
//		driver.findElement(By.xpath("//*[@id=\"termDiv\"]/div/span/span[1]")).click();
//		driver.findElement(By.xpath("//*[@id=\"termDiv\"]/div/span[2]/span/span[1]/input")).sendKeys(stringHK);
//		driver.findElement(By.xpath("//*[@id=\"termDiv\"]/div/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
//		Thread.sleep(2000);
//		driver.findElement(By.xpath(
//				"/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[1]/span[1]/span"))
//				.click();
//		driver.findElement(By.xpath(
//				"/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input"))
//				.sendKeys(stringNganh);
//		driver.findElement(By.xpath(
//				"/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input"))
//				.sendKeys(Keys.ENTER);
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"details-tab\"]")).click();
//
//		// Print
//		WebElement printElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/div[3]/div/div/div/div[1]/div[2]/div/div[2]/button"));
//		printElement.click();
//		Thread.sleep(2000);
//		WebElement printOptionElement = driver.findElement(
//				By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/div[3]/div/div/div/div[1]/div[2]/div/div[2]/div[2]/div/button[4]"));
//		Thread.sleep(2000);
//		printOptionElement.click();
//
//		Thread.sleep(300);
//		WebElement thongbaoElement = driver.findElement(By.xpath("/html/body/div[3]/h2"));
//		String dulieuString = thongbaoElement.getText();
//
//		// Sao chép table
//		WebElement bangdulieuElement = driver.findElement(By.xpath(
//				"//*[@id=\"tblStatisticsDetails\"]/tbody"));
//		String dulieumongdoiString = bangdulieuElement.getText();
//
//		// Xác nhận đã vào giao diện bảng biểu
//		WebElement confirmElement = driver.findElement(By.xpath("//*[@id=\"tblStatisticsDetails_length\"]/label"));
//		if (confirmElement.getText().contains("Hiển thị")) {
//			// In dữ liệu từ clipboard
//			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//			String duLieu = (String) clipboard.getData(DataFlavor.stringFlavor);
//			System.out.println(dulieuString);
//			System.out.println("Kết quả mong đợi: " + dulieumongdoiString);
//			System.out.println("Kết quả thực tế: " + duLieu);
//
//		} else {
//			System.out.println("Xem thất bại!!");
//		}
//		driver.navigate().refresh();
//
//	}
//	@Test (priority = 16)
//	public void Export16() throws UnsupportedFlavorException, IOException, InterruptedException, AWTException {
//
//		System.out.println("Testcase 16: Chức năng Export In ấn Số Giờ Quy Đổi theo Học Kỳ và chọn 1 ngành và chọn mục Chi Tiết");
//		FileInputStream fis = new FileInputStream("K:\\Automation\\ExportSGQĐNH.xlsx");
//		XSSFWorkbook workbook = new XSSFWorkbook(fis);
//		XSSFSheet sheet = workbook.getSheetAt(0);
//		XSSFRow row = sheet.getRow(1);
//		// Đọc giá trị từ cột A (index 0) từ hàng đã chọn và gán vào biến idString
//		String stringHK = row.getCell(0).getStringCellValue();
//
//		// Đọc giá trị từ cột B (index 1) từ hàng đã chọn và gán vào biến fullnameString
//		String stringNganh = row.getCell(1).getStringCellValue();
//		driver.findElement(By.xpath("//*[@id=\"isLesson\"]")).click();
//		driver.findElement(By.xpath("//*[@id=\"termDiv\"]/div/span/span[1]")).click();
//		driver.findElement(By.xpath("//*[@id=\"termDiv\"]/div/span[2]/span/span[1]/input")).sendKeys(stringHK);
//		driver.findElement(By.xpath("//*[@id=\"termDiv\"]/div/span[2]/span/span[1]/input")).sendKeys(Keys.ENTER);
//		Thread.sleep(2000);
//		driver.findElement(By.xpath(
//				"/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[1]/span[1]/span"))
//				.click();
//		driver.findElement(By.xpath(
//				"/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input"))
//				.sendKeys(stringNganh);
//		driver.findElement(By.xpath(
//				"/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input"))
//				.sendKeys(Keys.ENTER);
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"details-tab\"]")).click();
//
//		WebElement printElement = driver
//				.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/div[3]/div/div/div/div[1]/div[2]/div/div[2]/button"));
//		printElement.click();
//		Thread.sleep(2000);
//		WebElement printOptionElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/div[3]/div/div/div/div[1]/div[2]/div/div[2]/div[2]/div/button[1]"));
//		printOptionElement.click();	
//
//		Robot robot = new Robot();
//		WebElement confirmElement = driver.findElement(By.xpath("//*[@id=\"tblStatisticsDetails_length\"]/label"));
//		if (confirmElement.getText().contains("Hiển thị")) {
//
//			Thread.sleep(2000);
//			robot.keyPress(KeyEvent.VK_ENTER);
//			robot.keyRelease(KeyEvent.VK_ENTER);
//			Thread.sleep(2000);
//			robot.keyPress(KeyEvent.VK_CONTROL);
//			robot.keyPress(KeyEvent.VK_C);
//			robot.keyRelease(KeyEvent.VK_CONTROL);
//			robot.keyRelease(KeyEvent.VK_C);
//			Thread.sleep(2000);
//			robot.keyPress(KeyEvent.VK_ENTER);
//			robot.keyRelease(KeyEvent.VK_ENTER);
//			// In dữ liệu từ clipboard
//			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//			String duLieu = (String) clipboard.getData(DataFlavor.stringFlavor);
//
//			System.out
//					.println("Kết quả mong đợi: ThongKeChiTietSoGio_HK" + stringHK + "_Nganh_" + stringNganh + ".pdf");
//			System.out.println("Kết quả thực tế: " + duLieu);
//
//		} else {
//			System.out.println("Xem thất bại!!");
//		}
//		driver.navigate().refresh();
//
//
//	}
}
