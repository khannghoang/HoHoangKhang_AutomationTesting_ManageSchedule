package HOCHAMHOCVITEST;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import HOCHAMHOCVIPAGE.TimKiemCapBac_Page;
import PageSetup.Setup;

public class TimKiemCapBac_Test {
	   static WebDriver driver;
		@BeforeSuite
		public void Main() throws IOException, InterruptedException {
			Setup setup = new Setup();
			driver = setup.setup();
			Thread.sleep(3000);
		}
		@BeforeTest
		public void Setup2() throws InterruptedException {
			TimKiemCapBac_Page MainPage = new TimKiemCapBac_Page(driver);
			MainPage.Menu();
			Thread.sleep(2000);
		}
		@Test
		public void Action1() throws InterruptedException, IOException {
			TimKiemCapBac_Page MainPage = new TimKiemCapBac_Page(driver);
			MainPage.HHHVMenu();
			Thread.sleep(2000);
			MainPage.CapBac();
			Thread.sleep(2000);
			MainPage.Data("25");
			Thread.sleep(2000);

			FileInputStream fis = new FileInputStream("K:\\Automation\\SearchCapBac.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);

			StringBuilder pasStringBuilder = new StringBuilder();
			StringBuilder faildBuilder = new StringBuilder();

			for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
				XSSFRow row = sheet.getRow(i);
				String id = row.getCell(0).getStringCellValue();

				Thread.sleep(500);
				WebElement searchbox = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank_filter\"]/label/input"));
				searchbox.sendKeys(id);
				Thread.sleep(1000);
				WebElement dataTable = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank\"]/tbody"));
				System.out.println(dataTable.getText());
				if (dataTable.getText().equalsIgnoreCase("Không tìm thấy kết quả")) {
					faildBuilder.append(id);
				} else {
					pasStringBuilder.append(id);
				}
				searchbox.clear();
			}
			System.out.println("Testcase 1:Tìm kiếm với Hiển thị 25 dữ liệu");
			String pasString = pasStringBuilder.toString();
			String faildString = faildBuilder.toString();
			System.out.println("Key word không có kết quả " + faildString);
			System.out.println("Key Word có kết quả " + pasString);
			System.out.println("=================");
		}
		@Test
		public void SearchCapBac2() throws InterruptedException, IOException {
			TimKiemCapBac_Page MainPage = new TimKiemCapBac_Page(driver);
			MainPage.HHHVMenu();
			Thread.sleep(2000);
			MainPage.CapBac();
			Thread.sleep(2000);
			MainPage.Data("50");
			Thread.sleep(2000);
			FileInputStream fis = new FileInputStream("K:\\Automation\\SearchCapBac.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);

			StringBuilder pasStringBuilder = new StringBuilder();
			StringBuilder faildBuilder = new StringBuilder();

			for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
				XSSFRow row = sheet.getRow(i);
				String id = row.getCell(0).getStringCellValue();

				Thread.sleep(500);
				WebElement searchbox = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank_filter\"]/label/input"));
				searchbox.sendKeys(id);
				Thread.sleep(1000);
				WebElement dataTable = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank\"]/tbody"));
				System.out.println(dataTable.getText());
				if (dataTable.getText().equalsIgnoreCase("Không tìm thấy kết quả")) {
					faildBuilder.append(id);
				} else {
					pasStringBuilder.append(id);
				}
				searchbox.clear();
			}
			System.out.println("Testcase 2:Tìm kiếm với Hiển thị 50 dữ liệu");
			String pasString = pasStringBuilder.toString();
			String faildString = faildBuilder.toString();
			System.out.println("Key word không có kết quả " + faildString);
			System.out.println("Key Word có kết quả " + pasString);
			System.out.println("=================");
		}

		@Test
		public void SearchCapBac3() throws InterruptedException, IOException {
			TimKiemCapBac_Page MainPage = new TimKiemCapBac_Page(driver);
			MainPage.HHHVMenu();
			Thread.sleep(2000);
			MainPage.CapBac();
			Thread.sleep(2000);
			MainPage.Data("-1");
			Thread.sleep(2000);

			FileInputStream fis = new FileInputStream("K:\\Automation\\SearchCapBac.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);

			StringBuilder pasStringBuilder = new StringBuilder();
			StringBuilder faildBuilder = new StringBuilder();

			for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
				XSSFRow row = sheet.getRow(i);
				String id = row.getCell(0).getStringCellValue();

				Thread.sleep(500);
				WebElement searchbox = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank_filter\"]/label/input"));
				searchbox.sendKeys(id);
				Thread.sleep(1000);
				WebElement dataTable = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank\"]/tbody"));
				System.out.println(dataTable.getText());
				if (dataTable.getText().equalsIgnoreCase("Không tìm thấy kết quả")) {
					faildBuilder.append(id);
				} else {
					pasStringBuilder.append(id);
				}
				searchbox.clear();
			}
			System.out.println("Testcase 3:Tìm kiếm với Hiển thị tất cả dữ liệu");
			String pasString = pasStringBuilder.toString();
			String faildString = faildBuilder.toString();
			System.out.println("Key word không có kết quả " + faildString);
			System.out.println("Key Word có kết quả " + pasString);
			System.out.println("=================");

		}


		@Test
		public void SearchCapBac4() throws InterruptedException, IOException {
			TimKiemCapBac_Page MainPage = new TimKiemCapBac_Page(driver);
			MainPage.HHHVMenu();
			Thread.sleep(2000);
			MainPage.CapBac();
			Thread.sleep(2000);
			MainPage.Data("25");
			Thread.sleep(2000);

			FileInputStream fis = new FileInputStream("K:\\Automation\\SearchCapBac.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);

			StringBuilder pasStringBuilder = new StringBuilder();
			StringBuilder faildBuilder = new StringBuilder();

			for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
				XSSFRow row = sheet.getRow(i);
				String id = row.getCell(1).getStringCellValue();

				Thread.sleep(500);
				WebElement searchbox = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank_filter\"]/label/input"));
				searchbox.sendKeys(id);
				Thread.sleep(1000);
				WebElement dataTable = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank\"]/tbody"));
				System.out.println(dataTable.getText());
				if (dataTable.getText().equalsIgnoreCase("Không tìm thấy kết quả")) {
					faildBuilder.append(id);
				} else {
					pasStringBuilder.append(id);
				}
				searchbox.clear();
			}
			System.out.println("Testcase 4:Tìm kiếm với kí tự đặc biệt và Hiển thị 25 dữ liệu");
			String pasString = pasStringBuilder.toString();
			String faildString = faildBuilder.toString();
			System.out.println("Key word không có kết quả " + faildString);
			System.out.println("Key Word có kết quả " + pasString);
			System.out.println("=================");

		}
		@Test
		public void SearchCapBac5() throws InterruptedException, IOException {
			TimKiemCapBac_Page MainPage = new TimKiemCapBac_Page(driver);
			MainPage.HHHVMenu();
			Thread.sleep(2000);
			MainPage.CapBac();
			Thread.sleep(2000);
			MainPage.Data("50");
			Thread.sleep(2000);

			FileInputStream fis = new FileInputStream("K:\\Automation\\SearchCapBac.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);

			StringBuilder pasStringBuilder = new StringBuilder();
			StringBuilder faildBuilder = new StringBuilder();

			for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
				XSSFRow row = sheet.getRow(i);
				String id = row.getCell(1).getStringCellValue();

				Thread.sleep(500);
				WebElement searchbox = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank_filter\"]/label/input"));
				searchbox.sendKeys(id);
				Thread.sleep(1000);
				WebElement dataTable = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank\"]/tbody"));
				System.out.println(dataTable.getText());
				if (dataTable.getText().equalsIgnoreCase("Không tìm thấy kết quả")) {
					faildBuilder.append(id);
				} else {
					pasStringBuilder.append(id);
				}
				searchbox.clear();
			}
			System.out.println("Testcase 5:Tìm kiếm với kí tự đặc biệt và Hiển thị 50 dữ liệu");
			String pasString = pasStringBuilder.toString();
			String faildString = faildBuilder.toString();
			System.out.println("Key word không có kết quả " + faildString);
			System.out.println("Key Word có kết quả " + pasString);
			System.out.println("=================");

		}
		@Test
		public void SearchCapBac6() throws InterruptedException, IOException {
			TimKiemCapBac_Page MainPage = new TimKiemCapBac_Page(driver);
			MainPage.HHHVMenu();
			Thread.sleep(2000);
			MainPage.CapBac();
			Thread.sleep(2000);
			MainPage.Data("-1");
			Thread.sleep(2000);
			FileInputStream fis = new FileInputStream("K:\\Automation\\SearchCapBac.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);

			StringBuilder pasStringBuilder = new StringBuilder();
			StringBuilder faildBuilder = new StringBuilder();

			for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
				XSSFRow row = sheet.getRow(i);
				String id = row.getCell(1).getStringCellValue();

				Thread.sleep(500);
				WebElement searchbox = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank_filter\"]/label/input"));
				searchbox.sendKeys(id);
				Thread.sleep(1000);
				WebElement dataTable = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank\"]/tbody"));
				System.out.println(dataTable.getText());
				if (dataTable.getText().equalsIgnoreCase("Không tìm thấy kết quả")) {
					faildBuilder.append(id);
				} else {
					pasStringBuilder.append(id);
				}
				searchbox.clear();
			}
			System.out.println("Testcase 6:Tìm kiếm với kí tự đặc biệt và Hiển thị tất cả dữ liệu");
			String pasString = pasStringBuilder.toString();
			String faildString = faildBuilder.toString();
			System.out.println("Key word không có kết quả " + faildString);
			System.out.println("Key Word có kết quả " + pasString);
			System.out.println("=================");
		}
		@AfterTest
		public void Close() {
			driver.close();
		}
}
