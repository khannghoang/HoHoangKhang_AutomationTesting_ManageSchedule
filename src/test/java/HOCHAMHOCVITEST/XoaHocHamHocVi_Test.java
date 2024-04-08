package HOCHAMHOCVITEST;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import HOCHAMHOCVIPAGE.HienThiDuLieu_HocHamHocVi_Page;
import HOCHAMHOCVIPAGE.XoaHocHamHocVi_Page;
import PageSetup.Setup;

public class XoaHocHamHocVi_Test {
	static WebDriver driver;

	@BeforeSuite
	public void Main() throws IOException, InterruptedException {
		Setup setup = new Setup();
		driver = setup.setup();
		Thread.sleep(3000);
	}

	@BeforeTest
	public void Setup2() throws InterruptedException {
		XoaHocHamHocVi_Page MainPage = new XoaHocHamHocVi_Page(driver);
		MainPage.Menu();
		Thread.sleep(2000);

	}
	@Test(priority = 1)
	public void Actions1() throws IOException, InterruptedException {
		System.out.println("Testcase 1 :Xóa học hàm học vị và ấn Hủy");
		XoaHocHamHocVi_Page MainPage = new XoaHocHamHocVi_Page(driver);
		FileInputStream fis = new FileInputStream("K:\\Automation\\SuaXoaHocHamHocVi.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		for (int i = 0; i < 4; i++) {
			XSSFRow row = sheet.getRow(i);
			String NAME = row.getCell(0).getStringCellValue();
			MainPage.HHHVMenu();
			Thread.sleep(2000);
			WebElement inputElement = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_filter\"]/label/input"));
			inputElement.sendKeys(NAME);
			driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/tbody/tr/td[5]/a[2]")).click();
			Thread.sleep(2000);
			WebElement clickElement = driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[3]"));
			clickElement.click();
			Thread.sleep(2000);
			try {
				driver.findElement(By.xpath("/html/body/div[3]/div/h2")).getText();
				System.out.println("Click hủy không thành công");
			} catch (WebDriverException e) {
				System.out.println("Click hủy thành công dữ liệu: "+NAME);
			}
			System.out.println("=======");
		}
	}

	@Test(priority = 2)
	public void Actions2() throws IOException, InterruptedException {
		System.out.println("Testcase 2 :Xóa học hàm học vị bị trùng dữ liệu và ấn Hủy");
		XoaHocHamHocVi_Page MainPage = new XoaHocHamHocVi_Page(driver);
		FileInputStream fis = new FileInputStream("K:\\Automation\\SuaXoaHocHamHocVi.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(1);
		XSSFRow row = sheet.getRow(0);
		String NAME = row.getCell(0).getStringCellValue();
		MainPage.HHHVMenu();
		Thread.sleep(2000);
		WebElement inputElement = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_filter\"]/label/input"));
		inputElement.sendKeys(NAME);
		driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/tbody/tr/td[5]/a[2]")).click();
		Thread.sleep(2000);
		WebElement clickElement = driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[3]"));
		clickElement.click();
		Thread.sleep(2000);
		try {
			driver.findElement(By.xpath("/html/body/div[3]/div/h2")).getText();
			System.out.println("Click hủy không thành công");
		} catch (WebDriverException e) {
			System.out.println("Click hủy thành công dữ liệu: "+NAME);
		}
		System.out.println("=======");

	}

	@Test(priority = 3)
	public void Actions3() throws IOException, InterruptedException {
		System.out.println("Testcase 3 :Xóa học hàm học vị");
		XoaHocHamHocVi_Page MainPage = new XoaHocHamHocVi_Page(driver);
		FileInputStream fis = new FileInputStream("K:\\Automation\\SuaXoaHocHamHocVi.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		for (int i = 0; i < 4; i++) {
			XSSFRow row = sheet.getRow(i);
			String NAME = row.getCell(0).getStringCellValue();
			MainPage.HHHVMenu();
			Thread.sleep(2000);
			WebElement inputElement = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_filter\"]/label/input"));
			inputElement.sendKeys(NAME);
			driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/tbody/tr/td[5]/a[2]")).click();
			Thread.sleep(2000);
			WebElement clickElement=driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[1]"));
			clickElement.click();
			Thread.sleep(2000);
			try {
				driver.findElement(By.xpath("/html/body/div[3]/div/h2")).getText();
				System.out.println("Click xóa không thành công");
			} catch (WebDriverException e) {
				System.out.println("Click xóa thành công dữ liệu" );
			}
			System.out.println("=======");
		}
	}

	@Test(priority = 4)
	public void Actions4() throws IOException, InterruptedException {
		System.out.println("Testcase 4 :Xóa học hàm học vị đã có dữ liệu");
		XoaHocHamHocVi_Page MainPage = new XoaHocHamHocVi_Page(driver);
		FileInputStream fis = new FileInputStream("K:\\Automation\\SuaXoaHocHamHocVi.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(1);
		XSSFRow row = sheet.getRow(0);
		String NAME = row.getCell(0).getStringCellValue();
		MainPage.HHHVMenu();
		Thread.sleep(2000);
		WebElement inputElement = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_filter\"]/label/input"));
		inputElement.sendKeys(NAME);
		driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/tbody/tr/td[5]/a[2]")).click();
		Thread.sleep(2000);
		WebElement clickElement=driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[1]"));
		Thread.sleep(2000);
		clickElement.click();
		Thread.sleep(2000);
		try {
			driver.findElement(By.xpath("/html/body/div[3]/div/h2")).getText();
			WebElement errorElement = driver.findElement(By.id("swal2-html-container"));
			System.out.println("Click xóa không thành công, kết quả thực tế: " + errorElement.getText());
		} catch (WebDriverException e) {
			System.out.println("Click xóa thành công");
		}
		String expected = "Không thể xoá do học hàm, học vị này đã có dữ liệu!"; // Chuỗi kỳ vọng thông báo lỗi

		// In ra kết quả mong đợi của thông báo lỗi
		System.out.println("Kết quả mong đợi: " + expected);
		driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[1]")).click();

		System.out.println("=======");

	}

	@AfterTest
	public void Close() {
		driver.close();
	}
}
