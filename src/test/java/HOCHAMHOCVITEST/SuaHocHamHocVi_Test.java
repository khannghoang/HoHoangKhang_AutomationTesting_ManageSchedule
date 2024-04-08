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

import HOCHAMHOCVIPAGE.SuaDoiCapBac_Page;
import HOCHAMHOCVIPAGE.SuaHocHamHocVi_Page;
import PageSetup.Setup;

public class SuaHocHamHocVi_Test {
	 static WebDriver driver;

		@BeforeSuite
		public void Main() throws IOException, InterruptedException {
			Setup setup = new Setup();
			driver = setup.setup();
			Thread.sleep(3000);
		}
		@BeforeTest
		public void Setup2() throws InterruptedException {
			SuaHocHamHocVi_Page MainPage = new SuaHocHamHocVi_Page(driver);
			MainPage.Menu();
			Thread.sleep(2000);
		}
		@Test
		public void Action1() throws InterruptedException, IOException {
			SuaHocHamHocVi_Page MainPage = new SuaHocHamHocVi_Page(driver);
			MainPage.HHHVMenu();
			FileInputStream fis = new FileInputStream("K:\\Automation\\SuaXoaHocHamHocVi.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);
			XSSFRow row = sheet.getRow(0);
			String NAME = row.getCell(0).getStringCellValue();
			Thread.sleep(2000);
			WebElement inputElement = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_filter\"]/label/input"));
			inputElement.sendKeys(NAME);
			driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/tbody/tr[1]/td[5]/a[1]")).click();
			Thread.sleep(2000);
			XSSFRow row2 = sheet.getRow(0);
			String NAME2 = row2.getCell(1).getStringCellValue();
			WebElement inpElement = driver.findElement(By.xpath("//*[@id=\"name\"]"));
			inpElement.clear();
			Thread.sleep(2000);
			inpElement.sendKeys(NAME2);
			Thread.sleep(4000);
			MainPage.ClickSaveButton();
			Thread.sleep(2000);
			String expected = "Chỉ được nhập số-chữ không dấu và không có khoảng trắng!"; // Chuỗi kỳ vọng thông báo lỗi
			System.out.println("Kết quả mong đợi: " + expected);
			// In ra kết quả mong đợi của thông báo lỗi
			
			System.out.println("=======");
		}
		@Test(priority = 2)
		public void Actions2() throws IOException, InterruptedException {
			System.out.println("Testcase 2 :Sửa học hàm học vị với kí tự đặc biệt tại Tên HHHV");
			SuaHocHamHocVi_Page MainPage = new SuaHocHamHocVi_Page(driver);
			MainPage.HHHVMenu();
			FileInputStream fis = new FileInputStream("K:\\Automation\\SuaXoaHocHamHocVi.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);
			XSSFRow row = sheet.getRow(1);
			String NAME = row.getCell(0).getStringCellValue();
			Thread.sleep(2000);
			WebElement inputElement = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_filter\"]/label/input"));
			inputElement.sendKeys(NAME);
			driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/tbody/tr[1]/td[5]/a[1]")).click();
			Thread.sleep(2000);
			XSSFRow row2 = sheet.getRow(1);
			String NAME2 = row2.getCell(1).getStringCellValue();
			WebElement inpElement = driver.findElement(By.xpath("//*[@id=\"name\"]"));
			inpElement.clear();
			Thread.sleep(2000);
			inpElement.sendKeys(NAME2);
			Thread.sleep(4000);
			MainPage.ClickSaveButton();
			Thread.sleep(2000);
			String expected = "Chỉ được nhập số-chữ không dấu và không có khoảng trắng!"; // Chuỗi kỳ vọng thông báo lỗi
			System.out.println("Kết quả mong đợi: " + expected);
			// In ra kết quả mong đợi của thông báo lỗi
			
			System.out.println("=======");
		}
		@Test(priority = 3)
		public void Actions3() throws IOException, InterruptedException {
			System.out.println("Testcase 3 :Sửa học hàm học vị với số tại Tên HHHV");
			SuaHocHamHocVi_Page MainPage = new SuaHocHamHocVi_Page(driver);
			FileInputStream fis = new FileInputStream("K:\\Automation\\SuaXoaHocHamHocVi.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);
			XSSFRow row = sheet.getRow(2);
			String NAME = row.getCell(0).getStringCellValue();
			MainPage.HHHVMenu();
			Thread.sleep(2000);
			WebElement inputElement = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_filter\"]/label/input"));
			inputElement.sendKeys(NAME);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/tbody/tr[1]/td[5]/a[1]")).click();
			Thread.sleep(2000);
			XSSFRow row2 = sheet.getRow(2);
			String NAME2 = row2.getCell(1).getStringCellValue();
			WebElement inpElement = driver.findElement(By.xpath("//*[@id=\"name\"]"));
			inpElement.clear();
			Thread.sleep(2000);
			inpElement.sendKeys(NAME2);
			Thread.sleep(4000);
			MainPage.ClickSaveButton();
			Thread.sleep(2000);
			String expected = "Chỉ được nhập số-chữ không dấu và không có khoảng trắng!"; // Chuỗi kỳ vọng thông báo lỗi
			System.out.println("Kết quả mong đợi: " + expected);
			// In ra kết quả mong đợi của thông báo lỗi
			System.out.println("=======");
		}
		@Test(priority = 4)
		public void Actions4() throws IOException, InterruptedException {
			System.out.println("Testcase 4 :Sửa học hàm học vị với bỏ trống tại Tên HHHV");
			SuaHocHamHocVi_Page MainPage = new SuaHocHamHocVi_Page(driver);
			FileInputStream fis = new FileInputStream("K:\\Automation\\SuaXoaHocHamHocVi.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);
			XSSFRow row = sheet.getRow(3);
			String NAME = row.getCell(0).getStringCellValue();
			MainPage.HHHVMenu();
			Thread.sleep(2000);
			WebElement inputElement = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_filter\"]/label/input"));
			inputElement.sendKeys(NAME);
			driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/tbody/tr[1]/td[5]/a[1]")).click();
			Thread.sleep(2000);
			WebElement inpElement = driver.findElement(By.xpath("//*[@id=\"name\"]"));
			inpElement.clear();
			Thread.sleep(4000);
			MainPage.ClickSaveButton();
			String expected = "Bạn chưa nhập tên học hàm, học vị"; // Chuỗi kỳ vọng thông báo lỗi
			System.out.println("Kết quả mong đợi: " + expected);
			WebElement errorElement = driver.findElement(By.xpath("//*[@id=\"name-error\"]"));
			System.out.println("Kết quả thực tế: " + errorElement.getText());
			System.out.println("=======");

		}
		@Test(priority = 5)
		public void Actions5() throws IOException, InterruptedException {
			System.out.println("Testcase 5 :Sửa học hàm học vị với số âm tại Thứ Tự ");
			SuaHocHamHocVi_Page MainPage = new SuaHocHamHocVi_Page(driver);

			FileInputStream fis = new FileInputStream("K:\\Automation\\SuaXoaHocHamHocVi.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);
			XSSFRow row = sheet.getRow(0);
			String NAME = row.getCell(0).getStringCellValue();
			MainPage.HHHVMenu();
			Thread.sleep(2000);
			WebElement inputElement = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_filter\"]/label/input"));
			inputElement.sendKeys(NAME);
			driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/tbody/tr[1]/td[5]/a[1]")).click();
			Thread.sleep(4000);
			XSSFRow row3 = sheet.getRow(0);
			String NAME3 = row3.getCell(2).getStringCellValue();
			WebElement inpElement3 = driver.findElement(By.xpath("//*[@id=\"level\"]"));
			inpElement3.clear();
			Thread.sleep(2000);
			inpElement3.sendKeys(NAME3);
			Thread.sleep(4000);
			WebElement clickElement = driver.findElement(By.xpath("//*[@id=\"academicdegree-form\"]/div[4]/button[2]"));
			clickElement.click();
			Thread.sleep(3000);
			WebElement errorElement2 = driver.findElement(By.xpath("//*[@id=\"level-error\"]"));
			String expected2 = "Vui lòng nhập nhỏ hơn hoặc bằng 100"; // Chuỗi kỳ vọng thông báo lỗi
			// In ra kết quả mong đợi của thông báo lỗi
			System.out.println("Kết quả mong đợi: " + expected2);
			// In ra kết quả thực tế của thông báo lỗi trên giao diện web
			System.out.println("Kết quả thực tế: " + errorElement2.getText());
			System.out.println("=======");
			Thread.sleep(3000);


		}
		@Test(priority = 6)
		public void Actions6() throws IOException, InterruptedException {
			System.out.println("Testcase 6 :Sửa học hàm học vị với số lớn hơn 100 tại Thứ Tự ");
			SuaHocHamHocVi_Page MainPage = new SuaHocHamHocVi_Page(driver);

			FileInputStream fis = new FileInputStream("K:\\Automation\\SuaXoaHocHamHocVi.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);
			XSSFRow row = sheet.getRow(0);
			String NAME = row.getCell(0).getStringCellValue();
			MainPage.HHHVMenu();
			Thread.sleep(2000);
			WebElement inputElement = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_filter\"]/label/input"));
			inputElement.sendKeys(NAME);
			driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/tbody/tr[1]/td[5]/a[1]")).click();
			Thread.sleep(4000);
			XSSFRow row3 = sheet.getRow(1);
			String NAME3 = row3.getCell(2).getStringCellValue();
			WebElement inpElement3 = driver.findElement(By.xpath("//*[@id=\"level\"]"));
			inpElement3.clear();
			Thread.sleep(2000);
			inpElement3.sendKeys(NAME3);
			Thread.sleep(4000);
			WebElement clickElement = driver.findElement(By.xpath("//*[@id=\"academicdegree-form\"]/div[4]/button[2]"));
			clickElement.click();
			Thread.sleep(2000);
			WebElement errorElement2 = driver.findElement(By.xpath("//*[@id=\"level-error\"]"));
			String expected2 = "Vui lòng nhập nhỏ hơn hoặc bằng 100"; // Chuỗi kỳ vọng thông báo lỗi
			// In ra kết quả mong đợi của thông báo lỗi
			System.out.println("Kết quả mong đợi: " + expected2);
			// In ra kết quả thực tế của thông báo lỗi trên giao diện web
			System.out.println("Kết quả thực tế: " + errorElement2.getText());
			System.out.println("=======");
			Thread.sleep(3000);
		}

		@Test(priority = 7)
		public void Actions7() throws IOException, InterruptedException {
			System.out.println("Testcase 7 :Sửa học hàm học vị với kí tự đặc biệt tại Thứ Tự");
			SuaHocHamHocVi_Page MainPage = new SuaHocHamHocVi_Page(driver);

			FileInputStream fis = new FileInputStream("K:\\Automation\\SuaXoaHocHamHocVi.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);
			XSSFRow row = sheet.getRow(1);
			String NAME = row.getCell(0).getStringCellValue();
			MainPage.HHHVMenu();
			Thread.sleep(2000);
			WebElement inputElement = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_filter\"]/label/input"));
			inputElement.sendKeys(NAME);
			driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/tbody/tr[1]/td[5]/a[1]")).click();

			Thread.sleep(4000);
			XSSFRow row3 = sheet.getRow(2);
			String NAME3 = row3.getCell(2).getStringCellValue();
			WebElement inpElement3 = driver.findElement(By.xpath("//*[@id=\"level\"]"));
			inpElement3.clear();
			Thread.sleep(2000);
			inpElement3.sendKeys(NAME3);
			Thread.sleep(4000);
			driver.findElement(By.xpath("//*[@id=\"academicdegree-form\"]/div[4]/button[2]")).click();
			
			WebElement errorElement2 = driver.findElement(By.xpath("//*[@id=\"level-error\"]"));
			WebElement clickElement = driver.findElement(By.xpath("//*[@id=\"academicdegree-form\"]/div[4]/button[2]"));
			clickElement.click();
			Thread.sleep(2000);
			String expected2 = "Vui lòng nhập lớn hơn hoặc bằng 1"; // Chuỗi kỳ vọng thông báo lỗi
			// In ra kết quả mong đợi của thông báo lỗi
			System.out.println("Kết quả mong đợi: " + expected2);
			// In ra kết quả thực tế của thông báo lỗi trên giao diện web
			System.out.println("Kết quả thực tế: " + errorElement2.getText());
			System.out.println("=======");
			Thread.sleep(3000);

		}

		@Test(priority = 8)
		public void Actions8() throws IOException, InterruptedException {
			System.out.println("Testcase 8 :Sửa học hàm học vị với bỏ trống tại Thứ Tự ");
			SuaHocHamHocVi_Page MainPage = new SuaHocHamHocVi_Page(driver);

			FileInputStream fis = new FileInputStream("K:\\Automation\\SuaXoaHocHamHocVi.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);
			XSSFRow row = sheet.getRow(1);
			String NAME = row.getCell(0).getStringCellValue();
			MainPage.HHHVMenu();
			Thread.sleep(2000);
			WebElement inputElement = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_filter\"]/label/input"));
			inputElement.sendKeys(NAME);
			driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/tbody/tr[1]/td[5]/a[1]")).click();
			Thread.sleep(4000);
			WebElement inpElement3 = driver.findElement(By.xpath("//*[@id=\"level\"]"));
			inpElement3.clear();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"academicdegree-form\"]/div[4]/button[2]")).click();
			
			WebElement errorElement2 = driver.findElement(By.xpath("//*[@id=\"level-error\"]"));
			WebElement clickElement = driver.findElement(By.xpath("//*[@id=\"academicdegree-form\"]/div[4]/button[2]"));
			clickElement.click();
			Thread.sleep(2000);
			try {
				driver.findElement(By.xpath("//*[@id=\"level-error\"]")).getText();
				System.out.println("Lưu không thành công");
				
			} catch (Exception e) {
				System.out.println("Lưu thành công");
			}
			String expected2 = "Bạn chưa nhập thứ tự"; // Chuỗi kỳ vọng thông báo lỗi
			// In ra kết quả mong đợi của thông báo lỗi
			System.out.println("Kết quả mong đợi: " + expected2);
			// In ra kết quả thực tế của thông báo lỗi trên giao diện web
			System.out.println("Kết quả thực tế: " + errorElement2.getText());
			System.out.println("=======");
			Thread.sleep(3000);

		}
		@Test(priority = 9)
		public void Actions9() throws IOException, InterruptedException {
			System.out.println("Testcase 9 :Sửa học hàm học vị với khoảng cách tại Tên HHHV và ấn Hủy");
			SuaHocHamHocVi_Page MainPage = new SuaHocHamHocVi_Page(driver);

			FileInputStream fis = new FileInputStream("K:\\Automation\\SuaXoaHocHamHocVi.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);
			XSSFRow row = sheet.getRow(0);
			String NAME = row.getCell(0).getStringCellValue();
			MainPage.HHHVMenu();
			Thread.sleep(2000);
			WebElement inputElement = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_filter\"]/label/input"));
			inputElement.sendKeys(NAME);
			driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/tbody/tr[1]/td[5]/a[1]")).click();
			Thread.sleep(2000);
			XSSFRow row2 = sheet.getRow(0);
			String NAME2 = row2.getCell(1).getStringCellValue();
			WebElement inpElement = driver.findElement(By.xpath("//*[@id=\"name\"]"));
			inpElement.clear();
			Thread.sleep(2000);
			inpElement.sendKeys(NAME2);
			Thread.sleep(4000);
			MainPage.ClickCloseButton();
			System.out.println("=======");

		}

		@Test(priority = 10)
		public void Actions10() throws IOException, InterruptedException {
			System.out.println("Testcase 10 :Sửa học hàm học vị với kí tự đặc biệt tại Tên HHHV và ấn Hủy");
			SuaHocHamHocVi_Page MainPage = new SuaHocHamHocVi_Page(driver);

			FileInputStream fis = new FileInputStream("K:\\Automation\\SuaXoaHocHamHocVi.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);
			XSSFRow row = sheet.getRow(1);
			String NAME = row.getCell(0).getStringCellValue();
			MainPage.HHHVMenu();
			Thread.sleep(2000);
			WebElement inputElement = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_filter\"]/label/input"));
			inputElement.sendKeys(NAME);
			driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/tbody/tr[1]/td[5]/a[1]")).click();
			Thread.sleep(2000);
			XSSFRow row2 = sheet.getRow(1);
			String NAME2 = row2.getCell(1).getStringCellValue();
			WebElement inpElement = driver.findElement(By.xpath("//*[@id=\"name\"]"));
			inpElement.clear();
			Thread.sleep(2000);
			inpElement.sendKeys(NAME2);
			Thread.sleep(4000);
			MainPage.ClickCloseButton();
			System.out.println("=======");
		}

		@Test(priority = 11)
		public void Actions11() throws IOException, InterruptedException {
			System.out.println("Testcase 11 :Sửa học hàm học vị với số tại Tên HHHV và ấn Hủy");
			SuaHocHamHocVi_Page MainPage = new SuaHocHamHocVi_Page(driver);

			FileInputStream fis = new FileInputStream("K:\\Automation\\SuaXoaHocHamHocVi.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);
			XSSFRow row = sheet.getRow(2);
			String NAME = row.getCell(0).getStringCellValue();
			MainPage.HHHVMenu();
			Thread.sleep(2000);
			WebElement inputElement = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_filter\"]/label/input"));
			inputElement.sendKeys(NAME);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/tbody/tr[1]/td[5]/a[1]")).click();
			Thread.sleep(2000);
			XSSFRow row2 = sheet.getRow(2);
			String NAME2 = row2.getCell(1).getStringCellValue();
			WebElement inpElement = driver.findElement(By.xpath("//*[@id=\"name\"]"));
			inpElement.clear();
			Thread.sleep(2000);
			inpElement.sendKeys(NAME2);
			Thread.sleep(4000);
			MainPage.ClickCloseButton();
			System.out.println("=======");

		}

		@Test(priority = 12 )
		public void Actions12() throws IOException, InterruptedException {
			System.out.println("Testcase 12 :Sửa học hàm học vị với bỏ trống tại Tên HHHV và ấn Hủy");
			SuaHocHamHocVi_Page MainPage = new SuaHocHamHocVi_Page(driver);

			FileInputStream fis = new FileInputStream("K:\\Automation\\SuaXoaHocHamHocVi.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);
			XSSFRow row = sheet.getRow(3);
			String NAME = row.getCell(0).getStringCellValue();
			MainPage.HHHVMenu();
			Thread.sleep(2000);
			WebElement inputElement = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_filter\"]/label/input"));
			inputElement.sendKeys(NAME);
			driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/tbody/tr[1]/td[5]/a[1]")).click();
			Thread.sleep(2000);
			WebElement inpElement = driver.findElement(By.xpath("//*[@id=\"name\"]"));
			inpElement.clear();
			Thread.sleep(4000);
			MainPage.ClickCloseButton();
			System.out.println("=======");

		}
		@Test(priority = 13 )
		public void Actions13() throws IOException, InterruptedException {
			System.out.println("Testcase 13 :Sửa học hàm học vị với số âm tại Thứ Tự và ấn Hủy ");
			SuaHocHamHocVi_Page MainPage = new SuaHocHamHocVi_Page(driver);

			FileInputStream fis = new FileInputStream("K:\\Automation\\SuaXoaHocHamHocVi.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);
			XSSFRow row = sheet.getRow(0);
			String NAME = row.getCell(0).getStringCellValue();
			MainPage.HHHVMenu();
			Thread.sleep(2000);
			WebElement inputElement = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_filter\"]/label/input"));
			inputElement.sendKeys(NAME);
			driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/tbody/tr[1]/td[5]/a[1]")).click();
			Thread.sleep(4000);
			XSSFRow row3 = sheet.getRow(0);
			String NAME3 = row3.getCell(2).getStringCellValue();
			WebElement inpElement3 = driver.findElement(By.xpath("//*[@id=\"level\"]"));
			inpElement3.clear();
			Thread.sleep(2000);
			inpElement3.sendKeys(NAME3);
			Thread.sleep(4000);
			MainPage.ClickCloseButton();
			System.out.println("=======");

		}
		@Test(priority = 14)
		public void Actions14() throws IOException, InterruptedException {
			System.out.println("Testcase 14 :Sửa học hàm học vị với số lớn hơn 100 tại Thứ Tự và ấn Hủy ");
			SuaHocHamHocVi_Page MainPage = new SuaHocHamHocVi_Page(driver);

			FileInputStream fis = new FileInputStream("K:\\Automation\\SuaXoaHocHamHocVi.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);
			XSSFRow row = sheet.getRow(0);
			String NAME = row.getCell(0).getStringCellValue();
			MainPage.HHHVMenu();
			Thread.sleep(2000);
			WebElement inputElement = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_filter\"]/label/input"));
			inputElement.sendKeys(NAME);
			driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/tbody/tr[1]/td[5]/a[1]")).click();
			Thread.sleep(4000);
			XSSFRow row3 = sheet.getRow(1);
			String NAME3 = row3.getCell(2).getStringCellValue();
			WebElement inpElement3 = driver.findElement(By.xpath("//*[@id=\"level\"]"));
			inpElement3.clear();
			Thread.sleep(2000);
			inpElement3.sendKeys(NAME3);
			Thread.sleep(4000);
			MainPage.ClickCloseButton();
			System.out.println("=======");
		}

		@Test(priority = 15)
		public void Actions15() throws IOException, InterruptedException {
			System.out.println("Testcase 15 :Sửa học hàm học vị với kí tự đặc biệt tại Thứ Tự và ấn Hủy");
			SuaHocHamHocVi_Page MainPage = new SuaHocHamHocVi_Page(driver);

			FileInputStream fis = new FileInputStream("K:\\Automation\\SuaXoaHocHamHocVi.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);
			XSSFRow row = sheet.getRow(1);
			String NAME = row.getCell(0).getStringCellValue();
			MainPage.HHHVMenu();
			Thread.sleep(2000);
			WebElement inputElement = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_filter\"]/label/input"));
			inputElement.sendKeys(NAME);
			driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/tbody/tr[1]/td[5]/a[1]")).click();

			Thread.sleep(4000);
			XSSFRow row3 = sheet.getRow(2);
			String NAME3 = row3.getCell(2).getStringCellValue();
			WebElement inpElement3 = driver.findElement(By.xpath("//*[@id=\"level\"]"));
			inpElement3.clear();
			Thread.sleep(2000);
			inpElement3.sendKeys(NAME3);
			Thread.sleep(4000);
			MainPage.ClickCloseButton();
			System.out.println("=======");
		}

		@Test(priority = 16)
		public void Actions16() throws IOException, InterruptedException {
			System.out.println("Testcase 16 :Sửa học hàm học vị với bỏ trống tại Thứ Tự và ấn Hủy ");
			SuaHocHamHocVi_Page MainPage = new SuaHocHamHocVi_Page(driver);

			FileInputStream fis = new FileInputStream("K:\\Automation\\SuaXoaHocHamHocVi.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);
			XSSFRow row = sheet.getRow(1);
			String NAME = row.getCell(0).getStringCellValue();
			MainPage.HHHVMenu();
			Thread.sleep(2000);
			WebElement inputElement = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree_filter\"]/label/input"));
			inputElement.sendKeys(NAME);
			driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/tbody/tr[1]/td[5]/a[1]")).click();
			Thread.sleep(4000);
			WebElement inpElement3 = driver.findElement(By.xpath("//*[@id=\"level\"]"));
			inpElement3.clear();
			Thread.sleep(2000);
			MainPage.ClickCloseButton();
			System.out.println("=======");
		}
		@AfterTest
		public void Close() {
			driver.close();
		}
}
