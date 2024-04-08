package SOGIOQUYDOI_TEST;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageSetup.Setup;
import SOGIOQUYDOI_PAGE.ThongKeSoGioQuyDoi_HocKy_BangBieu_Page;
import SOGIOQUYDOI_PAGE.TimKiemGiangVien_HocKy_BangBieu_Page;

public class TimKiemGiangVien_HocKy_BangBieu_Test {
	static WebDriver driver;

	@BeforeSuite
	public void Setup() throws InterruptedException {
		Setup setup = new Setup();
		driver = setup.setup();
		Thread.sleep(2000);
	}

	@BeforeTest
	public void Setup2() throws InterruptedException {
		TimKiemGiangVien_HocKy_BangBieu_Page Mainpage = new TimKiemGiangVien_HocKy_BangBieu_Page(driver);
		Mainpage.navigateToPage();
		Mainpage.selectTerm("789");
		Mainpage.selectMajor("Tất cả");
		Mainpage.switchToTableTab();
	}
	@Test
	public void SearchBangBieu1() throws InterruptedException, IOException {
		Thread.sleep(2000);
		System.out.println("Testcase 1:Tìm kiếm với Hiển thị 10 dữ liệu");
		FileInputStream fis = new FileInputStream("K:\\Automation\\SearchSoGioQuyDoi.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);

		StringBuilder pasStringBuilder = new StringBuilder();
		StringBuilder faildBuilder = new StringBuilder();

		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
			XSSFRow row = sheet.getRow(i);
			String id = row.getCell(0).getStringCellValue();

			Thread.sleep(500);
			WebElement searchbox = driver.findElement(By.xpath("//*[@id=\"tblStatistics_filter\"]/label/input"));
			searchbox.sendKeys(id);
			Thread.sleep(1000);
			WebElement dataTable = driver.findElement(By.xpath("//*[@id=\"tblStatistics\"]/tbody"));
			System.out.println(dataTable.getText());
			if (dataTable.getText().equalsIgnoreCase("Không tìm thấy kết quả")) {
				faildBuilder.append(id);
			} else {
				pasStringBuilder.append(id);
			}
			searchbox.clear();
		}
		String pasString = pasStringBuilder.toString();
		String faildString = faildBuilder.toString();
		System.out.println("Key word không hợp lệ " + faildString);
		System.out.println("Key Word hợp lệ " + pasString);

	}

	@Test
	public void SearchBangBieu2() throws InterruptedException, IOException {
		System.out.println("Testcase 2:Tìm kiếm với Hiển thị 25 dữ liệu");
		Thread.sleep(2000);
		WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"tblStatistics_length\"]/label/select"));
		Select select = new Select(dropdown);
		select.selectByValue("25");
		Thread.sleep(2000);

		FileInputStream fis = new FileInputStream("K:\\Automation\\SearchSoGioQuyDoi.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);

		StringBuilder pasStringBuilder = new StringBuilder();
		StringBuilder faildBuilder = new StringBuilder();

		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
			XSSFRow row = sheet.getRow(i);
			String id = row.getCell(0).getStringCellValue();

			Thread.sleep(500);
			WebElement searchbox = driver.findElement(By.xpath("//*[@id=\"tblStatistics_filter\"]/label/input"));
			searchbox.sendKeys(id);
			Thread.sleep(1000);
			WebElement dataTable = driver.findElement(By.xpath("//*[@id=\"tblStatistics\"]/tbody"));
			System.out.println(dataTable.getText());
			if (dataTable.getText().equalsIgnoreCase("Không tìm thấy kết quả")) {
				faildBuilder.append(id);
			} else {
				pasStringBuilder.append(id);
			}
			searchbox.clear();
		}
		String pasString = pasStringBuilder.toString();
		String faildString = faildBuilder.toString();
		System.out.println("Key word không hợp lệ " + faildString);
		System.out.println("Key Word hợp lệ " + pasString);

	}

	@Test
	public void SearchBangBieu3() throws InterruptedException, IOException {
		Thread.sleep(2000);
		System.out.println("Testcase 3:Tìm kiếm với Hiển thị 50 dữ liệu");
		WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"tblStatistics_length\"]/label/select"));
		Select select = new Select(dropdown);
		select.selectByValue("50");
		Thread.sleep(2000);

		FileInputStream fis = new FileInputStream("K:\\Automation\\SearchSoGioQuyDoi.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);

		StringBuilder pasStringBuilder = new StringBuilder();
		StringBuilder faildBuilder = new StringBuilder();

		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
			XSSFRow row = sheet.getRow(i);
			String id = row.getCell(0).getStringCellValue();

			Thread.sleep(500);
			WebElement searchbox = driver.findElement(By.xpath("//*[@id=\"tblStatistics_filter\"]/label/input"));
			searchbox.sendKeys(id);
			Thread.sleep(1000);
			WebElement dataTable = driver.findElement(By.xpath("//*[@id=\"tblStatistics\"]/tbody"));
			System.out.println(dataTable.getText());
			if (dataTable.getText().equalsIgnoreCase("Không tìm thấy kết quả")) {
				faildBuilder.append(id);
			} else {
				pasStringBuilder.append(id);
			}
			searchbox.clear();
		}
		String pasString = pasStringBuilder.toString();
		String faildString = faildBuilder.toString();
		System.out.println("Key word không hợp lệ " + faildString);
		System.out.println("Key Word hợp lệ " + pasString);

	}

	@Test
	public void SearchBangBieu4() throws InterruptedException, IOException {
		Thread.sleep(2000);
		System.out.println("Testcase 4:Tìm kiếm với Hiển thị tất cả dữ liệu");
		WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"tblStatistics_length\"]/label/select"));
		Select select = new Select(dropdown);
		select.selectByValue("-1");
		Thread.sleep(2000);

		FileInputStream fis = new FileInputStream("K:\\Automation\\SearchSoGioQuyDoi.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);

		StringBuilder pasStringBuilder = new StringBuilder();
		StringBuilder faildBuilder = new StringBuilder();

		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
			XSSFRow row = sheet.getRow(i);
			String id = row.getCell(0).getStringCellValue();

			Thread.sleep(500);
			WebElement searchbox = driver.findElement(By.xpath("//*[@id=\"tblStatistics_filter\"]/label/input"));
			searchbox.sendKeys(id);
			Thread.sleep(1000);
			WebElement dataTable = driver.findElement(By.xpath("//*[@id=\"tblStatistics\"]/tbody"));
			System.out.println(dataTable.getText());
			if (dataTable.getText().equalsIgnoreCase("Không tìm thấy kết quả")) {
				faildBuilder.append(id);
			} else {
				pasStringBuilder.append(id);
			}
			searchbox.clear();
		}
		String pasString = pasStringBuilder.toString();
		String faildString = faildBuilder.toString();
		System.out.println("Key word không hợp lệ " + faildString);
		System.out.println("Key Word hợp lệ " + pasString);

	}

	@Test
	public void SearchBangBieu5() throws InterruptedException, IOException {
		Thread.sleep(2000);
		System.out.println("Testcase 5:Tìm kiếm với Hiển thị 10 dữ liệu với ký tự đặc biệt");
		FileInputStream fis = new FileInputStream("K:\\Automation\\SearchSoGioQuyDoi.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);

		StringBuilder pasStringBuilder = new StringBuilder();
		StringBuilder faildBuilder = new StringBuilder();

		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
			XSSFRow row = sheet.getRow(i);
			String id = row.getCell(1).getStringCellValue();

			Thread.sleep(500);
			WebElement searchbox = driver.findElement(By.xpath("//*[@id=\"tblStatistics_filter\"]/label/input"));
			searchbox.sendKeys(id);
			Thread.sleep(1000);
			WebElement dataTable = driver.findElement(By.xpath("//*[@id=\"tblStatistics\"]/tbody"));
			System.out.println(dataTable.getText());
			if (dataTable.getText().equalsIgnoreCase("Không tìm thấy kết quả")) {
				faildBuilder.append(id);
			} else {
				pasStringBuilder.append(id);
			}
			searchbox.clear();
		}
		String pasString = pasStringBuilder.toString();
		String faildString = faildBuilder.toString();
		System.out.println("Key word không hợp lệ " + faildString);
		System.out.println("Key Word hợp lệ " + pasString);

	}

	@Test
	public void SearchBangBieu6() throws InterruptedException, IOException {

		Thread.sleep(2000);
		System.out.println("Testcase 6:Tìm kiếm với Hiển thị 25 dữ liệu với ký tự đặc biệt");
		WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"tblStatistics_length\"]/label/select"));
		Select select = new Select(dropdown);
		select.selectByValue("25");
		Thread.sleep(2000);

		FileInputStream fis = new FileInputStream("K:\\Automation\\SearchSoGioQuyDoi.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);

		StringBuilder pasStringBuilder = new StringBuilder();
		StringBuilder faildBuilder = new StringBuilder();

		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
			XSSFRow row = sheet.getRow(i);
			String id = row.getCell(1).getStringCellValue();

			Thread.sleep(500);
			WebElement searchbox = driver.findElement(By.xpath("//*[@id=\"tblStatistics_filter\"]/label/input"));
			searchbox.sendKeys(id);
			Thread.sleep(1000);
			WebElement dataTable = driver.findElement(By.xpath("//*[@id=\"tblStatistics\"]/tbody"));
			System.out.println(dataTable.getText());
			if (dataTable.getText().equalsIgnoreCase("Không tìm thấy kết quả")) {
				faildBuilder.append(id);
			} else {
				pasStringBuilder.append(id);
			}
			searchbox.clear();
		}
		String pasString = pasStringBuilder.toString();
		String faildString = faildBuilder.toString();
		System.out.println("Key word không hợp lệ " + faildString);
		System.out.println("Key Word hợp lệ " + pasString);

	}

	@Test
	public void SearchBangBieu7() throws InterruptedException, IOException {
		Thread.sleep(2000);
		System.out.println("Testcase 7:Tìm kiếm với Hiển thị 50 dữ liệu với ký tự đặc biệt");
		WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"tblStatistics_length\"]/label/select"));
		Select select = new Select(dropdown);
		select.selectByValue("50");
		Thread.sleep(2000);

		FileInputStream fis = new FileInputStream("K:\\Automation\\SearchSoGioQuyDoi.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);

		StringBuilder pasStringBuilder = new StringBuilder();
		StringBuilder faildBuilder = new StringBuilder();

		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
			XSSFRow row = sheet.getRow(i);
			String id = row.getCell(1).getStringCellValue();

			Thread.sleep(500);
			WebElement searchbox = driver.findElement(By.xpath("//*[@id=\"tblStatistics_filter\"]/label/input"));
			searchbox.sendKeys(id);
			Thread.sleep(1000);
			WebElement dataTable = driver.findElement(By.xpath("//*[@id=\"tblStatistics\"]/tbody"));
			System.out.println(dataTable.getText());
			if (dataTable.getText().equalsIgnoreCase("Không tìm thấy kết quả")) {
				faildBuilder.append(id);
			} else {
				pasStringBuilder.append(id);
			}
			searchbox.clear();
		}
		String pasString = pasStringBuilder.toString();
		String faildString = faildBuilder.toString();
		System.out.println("Key word không hợp lệ " + faildString);
		System.out.println("Key Word hợp lệ " + pasString);

	}

	@Test
	public void SearchBangBieu8() throws InterruptedException, IOException {
		Thread.sleep(2000);
		System.out.println("Testcase 8:Tìm kiếm với Hiển thị tất cả dữ liệu với ký tự đặc biệt");

		WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"tblStatistics_length\"]/label/select"));
		Select select = new Select(dropdown);
		select.selectByValue("-1");
		Thread.sleep(2000);

		FileInputStream fis = new FileInputStream("K:\\Automation\\SearchSoGioQuyDoi.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);

		StringBuilder pasStringBuilder = new StringBuilder();
		StringBuilder faildBuilder = new StringBuilder();

		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
			XSSFRow row = sheet.getRow(i);
			String id = row.getCell(1).getStringCellValue();

			Thread.sleep(500);
			WebElement searchbox = driver.findElement(By.xpath("//*[@id=\"tblStatistics_filter\"]/label/input"));
			searchbox.sendKeys(id);
			Thread.sleep(1000);
			WebElement dataTable = driver.findElement(By.xpath("//*[@id=\"tblStatistics\"]/tbody"));
			System.out.println(dataTable.getText());
			if (dataTable.getText().equalsIgnoreCase("Không tìm thấy kết quả")) {
				faildBuilder.append(id);
			} else {
				pasStringBuilder.append(id);
			}
			searchbox.clear();
		}
		String pasString = pasStringBuilder.toString();
		String faildString = faildBuilder.toString();
		System.out.println("Key word không hợp lệ " + faildString);
		System.out.println("Key Word hợp lệ " + pasString);

	}
	@AfterTest
	public void Close() {
		driver.close();
	}
	
}
