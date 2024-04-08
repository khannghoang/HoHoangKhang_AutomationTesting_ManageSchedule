package IntergrationTest_DonGiaHeSo_CapBac_TEST;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import IntergrationTest_DonGiaHeSo_CapBac_PAGE.DGVHSCBP;
import PageSetup.Setup;

public class DGVHSCBT {
	private String savedID;
	static WebDriver driver;
	@BeforeSuite
	public void Main() throws IOException, InterruptedException {
		Setup setup = new Setup();
		driver = setup.setup();
		Thread.sleep(3000);
	}
	@BeforeTest
	public void Setup2() throws InterruptedException {
		DGVHSCBP MainPage = new DGVHSCBP(driver);
		MainPage.MenuNavigation();
		Thread.sleep(2000);
	}
	@Test(priority = 1)
	public void Action() throws InterruptedException, IOException {
		System.out.println("Testcase 1: Thêm và Lưu cấp bậc mới tại HHHV và kiểm tra có hiện thị ở Đơn Giá và Hệ Số tại mục CTĐT Tiêu Chuẩn ");
		DGVHSCBP MainPage = new DGVHSCBP(driver);
		MainPage.HHHV();
		Thread.sleep(2000);
		MainPage.CapBac();
		Thread.sleep(2000);
		MainPage.AddCapBac();
		FileInputStream fis = new FileInputStream("K:\\Automation\\CapBac.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		XSSFRow row = sheet.getRow(5);
		String ID = row.getCell(0).getStringCellValue();
		driver.findElement(By.xpath("//*[@id=\"id\"]")).sendKeys(ID);
		savedID = ID;
		MainPage.SaveButton();
		System.out.println("======");
		System.out.println("Chuyển sang Đơn giá và Hệ Số");
		Thread.sleep(2000);
		MainPage.DGVHS();
		WebElement standardElement=driver.findElement(By.xpath("//*[@id=\"standard-tab\"]"));
		String prinString = standardElement.getText();
		String pageSource = driver.getPageSource();
		  if (pageSource.contains(savedID)) {
	            System.out.println("Dữ liệu " + savedID + " đã bấm Lưu tại Cấp Bậc tồn tại ở mục "+ prinString);
	        } else {
	            System.out.println("Dữ liệu " + savedID + " đã bấm Lưu tại Cấp Bậc không tồn tại ở mục "+prinString);
	        }
		System.out.println("============");
	}
	@Test(priority = 2)
	public void Action2() throws InterruptedException, IOException {
		System.out.println("Testcase 2: Thêm và Hủy cấp bậc mới tại HHHV và kiểm tra có hiện thị ở Đơn Giá và Hệ Số tại mục CTĐT Tiêu Chuẩn");
		DGVHSCBP MainPage = new DGVHSCBP(driver);
		MainPage.HHHV();
		Thread.sleep(2000);
		MainPage.CapBac();
		Thread.sleep(2000);
		MainPage.AddCapBac();
		FileInputStream fis = new FileInputStream("K:\\Automation\\CapBac.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		XSSFRow row = sheet.getRow(6);
		String ID = row.getCell(0).getStringCellValue();
		driver.findElement(By.xpath("//*[@id=\"id\"]")).sendKeys(ID);
		savedID = ID;
		Thread.sleep(2000);
		MainPage.CloseButton();
		System.out.println("======");
		System.out.println("Chuyển sang Đơn giá và Hệ Số");
		MainPage.DGVHS();
		WebElement standardElement=driver.findElement(By.xpath("//*[@id=\"standard-tab\"]"));
		String prinString = standardElement.getText();
		String pageSource = driver.getPageSource();
		  if (pageSource.contains(savedID)) {
	            System.out.println("Dữ liệu " + savedID + " đã bấm Hủy tại Cấp Bậc tồn tại ở mục "+ prinString);
	        } else {
	            System.out.println("Dữ liệu " + savedID + " đã bấm Hủy tại Cấp Bậc không tồn tại ở mục "+prinString);
	        }
			System.out.println("============");

	}
	@Test(priority = 3)
	public void Action3() throws InterruptedException, IOException {
		System.out.println("Testcase 3: Thêm và Lưu cấp bậc mới tại HHHV và kiểm tra có hiện thị ở Đơn Giá và Hệ Số tại mục CTĐT Đặc Biệt");
		DGVHSCBP MainPage = new DGVHSCBP(driver);
		MainPage.HHHV();
		Thread.sleep(2000);
		MainPage.CapBac();
		Thread.sleep(2000);
		MainPage.AddCapBac();
		FileInputStream fis = new FileInputStream("K:\\Automation\\CapBac.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		XSSFRow row = sheet.getRow(7);
		String ID = row.getCell(0).getStringCellValue();
		driver.findElement(By.xpath("//*[@id=\"id\"]")).sendKeys(ID);
		savedID = ID;
		MainPage.SaveButton();
		System.out.println("======");
		System.out.println("Chuyển sang Đơn giá và Hệ Số");
		Thread.sleep(2000);
		MainPage.DGVHS();
		Thread.sleep(2000);
		WebElement speacialElement=driver.findElement(By.xpath("//*[@id=\"special-tab\"]"));
		String prinString = speacialElement.getText();
		String pageSource = driver.getPageSource();
		  if (pageSource.contains(savedID)) {
	            System.out.println("Dữ liệu " + savedID + " đã bấm Lưu tại Cấp Bậc tồn tại ở mục "+ prinString);
	        } else {
	            System.out.println("Dữ liệu " + savedID + " đã bấm Lưu tại Cấp Bậc không tồn tại ở mục "+prinString);
	        }
			System.out.println("============");

	}
	@Test(priority = 4)
	public void Action4() throws InterruptedException, IOException {
		System.out.println("Testcase 4: Thêm và Hủy cấp bậc mới tại HHHV và kiểm tra có hiện thị ở Đơn Giá và Hệ Số tại mục CTĐT Đặc Biệt");
		DGVHSCBP MainPage = new DGVHSCBP(driver);
		MainPage.HHHV();
		Thread.sleep(2000);
		MainPage.CapBac();
		Thread.sleep(2000);
		MainPage.AddCapBac();
		FileInputStream fis = new FileInputStream("K:\\Automation\\CapBac.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		XSSFRow row = sheet.getRow(6);
		String ID = row.getCell(0).getStringCellValue();
		driver.findElement(By.xpath("//*[@id=\"id\"]")).sendKeys(ID);
		savedID = ID;
		Thread.sleep(2000);
		MainPage.CloseButton();
		System.out.println("======");
		System.out.println("Chuyển sang Đơn giá và Hệ Số");
		MainPage.DGVHS();
		Thread.sleep(2000);
		MainPage.SpeacialEducationProgram();
		WebElement speacialElement=driver.findElement(By.xpath("//*[@id=\"special-tab\"]"));
		String prinString = speacialElement.getText();
		String pageSource = driver.getPageSource();
		  if (pageSource.contains(savedID)) {
	            System.out.println("Dữ liệu " + savedID + " đã bấm Hủy tại Cấp Bậc tồn tại ở mục "+ prinString);
	        } else {
	            System.out.println("Dữ liệu " + savedID + " đã bấm Hủy tại Cấp Bậc không tồn tại ở mục "+prinString);
	        }
			System.out.println("============");

		
	}
	@Test(priority = 5)
	public void Action5() throws InterruptedException, IOException {
		System.out.println("Testcase 5: Thêm và Lưu cấp bậc mới tại HHHV và kiểm tra có hiện thị ở Đơn Giá và Hệ Số tại mục Người Nước Ngoài");
		DGVHSCBP MainPage = new DGVHSCBP(driver);
		MainPage.HHHV();
		Thread.sleep(2000);
		MainPage.CapBac();
		Thread.sleep(2000);
		MainPage.AddCapBac();
		FileInputStream fis = new FileInputStream("K:\\Automation\\CapBac.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		XSSFRow row = sheet.getRow(8);
		String ID = row.getCell(0).getStringCellValue();
		
		driver.findElement(By.xpath("//*[@id=\"id\"]")).sendKeys(ID);
		savedID = ID;
		MainPage.SaveButton();
		System.out.println("======");
		System.out.println("Chuyển sang Đơn Giá và Hệ Số và chọn ");
		Thread.sleep(2000);
		MainPage.DGVHS();
		Thread.sleep(2000);
		MainPage.Foreigner();
		WebElement foreignerElement=driver.findElement(By.xpath("//*[@id=\"foreign-tab\"]"));
		String prinString = foreignerElement.getText();
		String pageSource = driver.getPageSource();
		  if (pageSource.contains(savedID)) {
	            System.out.println("Dữ liệu " + savedID + " đã bấm Lưu tại Cấp Bậc tồn tại ở mục "+ prinString);
	        } else {
	            System.out.println("Dữ liệu " + savedID + " đã bấm Lưu tại Cấp Bậc không tồn tại ở mục "+prinString);
	        }
			System.out.println("============");

		
	}
	@Test(priority = 6)
	public void Action6() throws InterruptedException, IOException {
		System.out.println("Testcase 6: Thêm và Hủy cấp bậc mới tại HHHV và kiểm tra có hiện thị ở Đơn Giá và Hệ Số tại mục Người Nước Ngoài");
		DGVHSCBP MainPage = new DGVHSCBP(driver);
		MainPage.HHHV();
		Thread.sleep(2000);
		MainPage.CapBac();
		Thread.sleep(2000);
		MainPage.AddCapBac();
		FileInputStream fis = new FileInputStream("K:\\Automation\\CapBac.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		XSSFRow row = sheet.getRow(6);
		String ID = row.getCell(0).getStringCellValue();
		driver.findElement(By.xpath("//*[@id=\"id\"]")).sendKeys(ID);
		savedID = ID;
		Thread.sleep(2000);
		MainPage.CloseButton();
		System.out.println("======");
		System.out.println("Chuyển sang Đơn giá và Hệ Số");
		MainPage.DGVHS();
		Thread.sleep(2000);
		MainPage.Foreigner();
		WebElement foreignerElement=driver.findElement(By.xpath("//*[@id=\"foreign-tab\"]"));
		String prinString = foreignerElement.getText();
		String pageSource = driver.getPageSource();
		  if (pageSource.contains(savedID)) {
	            System.out.println("Dữ liệu " + savedID + " đã bấm Hủy tại Cấp Bậc tồn tại ở mục "+ prinString);
	        } else {
	            System.out.println("Dữ liệu " + savedID + " đã bấm Hủy tại Cấp Bậc không tồn tại ở mục "+prinString);
	        }
			System.out.println("============");

	}
	@Test(priority = 7)
	public void Action7() throws InterruptedException, IOException {
		System.out.println("Testcase 7: Hủy xóa cấp bậc tại HHHV và kiểm tra có hiện thị ở Đơn Giá và Hệ Số tại mục CTĐT Tiêu Chuẩn ");
		DGVHSCBP MainPage = new DGVHSCBP(driver);
		MainPage.HHHV();
		Thread.sleep(2000);
		MainPage.CapBac();
		Thread.sleep(2000);
		FileInputStream fis = new FileInputStream("K:\\Automation\\CapBac.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		XSSFRow row = sheet.getRow(5);
		String ID = row.getCell(0).getStringCellValue();
		driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank_filter\"]/label/input")).sendKeys(ID);
		Thread.sleep(2000);
		savedID = ID;
		MainPage.CloseDeleteButton();
		Thread.sleep(2000);
		System.out.println("======");
		System.out.println("Chuyển sang Đơn giá và Hệ Số");
		Thread.sleep(2000);
		MainPage.DGVHS();
		WebElement standardElement=driver.findElement(By.xpath("//*[@id=\"standard-tab\"]"));
		String prinString = standardElement.getText();
		String pageSource = driver.getPageSource();
		  if (pageSource.contains(savedID)) {
	            System.out.println("Dữ liệu " + savedID + " đã Hủy xóa tại Cấp Bậc tồn tại ở mục "+ prinString);
	        } else {
	            System.out.println("Dữ liệu " + savedID + " đã Hủy xóa tại Cấp Bậc không tồn tại ở mục "+prinString);
	        }
		System.out.println("============");
	}
	@Test(priority = 8)
	public void Action8() throws InterruptedException, IOException {
		System.out.println("Testcase 8: Xóa cấp bậc tại HHHV và kiểm tra có hiện thị ở Đơn Giá và Hệ Số tại mục CTĐT Tiêu Chuẩn ");
		DGVHSCBP MainPage = new DGVHSCBP(driver);
		MainPage.HHHV();
		Thread.sleep(2000);
		MainPage.CapBac();
		Thread.sleep(2000);
		FileInputStream fis = new FileInputStream("K:\\Automation\\CapBac.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		XSSFRow row = sheet.getRow(5);
		String ID = row.getCell(0).getStringCellValue();
		driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank_filter\"]/label/input")).sendKeys(ID);
		Thread.sleep(2000);
		savedID = ID;
		MainPage.DeleteButton();
		Thread.sleep(2000);
		System.out.println("======");
		System.out.println("Chuyển sang Đơn giá và Hệ Số");
		Thread.sleep(2000);
		MainPage.DGVHS();
		WebElement standardElement=driver.findElement(By.xpath("//*[@id=\"standard-tab\"]"));
		String prinString = standardElement.getText();
		String pageSource = driver.getPageSource();
	  if (pageSource.contains(savedID)) {
          System.out.println("Dữ liệu " + savedID + " đã Xóa tại Cấp Bậc tồn tại ở mục "+ prinString);
      } else {
          System.out.println("Dữ liệu " + savedID + " đã Xóa tại Cấp Bậc không tồn tại ở mục "+prinString);
      }
		System.out.println("============");
	}
	@Test(priority = 9)
	public void Action9() throws InterruptedException, IOException {
		System.out.println("Testcase 9: Hủy xóa cấp bậc tại HHHV và kiểm tra có hiện thị ở Đơn Giá và Hệ Số tại mục CTĐT Đặc Biệt");
		DGVHSCBP MainPage = new DGVHSCBP(driver);
		MainPage.HHHV();
		Thread.sleep(2000);
		MainPage.CapBac();
		Thread.sleep(2000);
		FileInputStream fis = new FileInputStream("K:\\Automation\\CapBac.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		XSSFRow row = sheet.getRow(7);
		String ID = row.getCell(0).getStringCellValue();
		driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank_filter\"]/label/input")).sendKeys(ID);
		savedID = ID;
		MainPage.CloseDeleteButton();
		System.out.println("======");
		System.out.println("Chuyển sang Đơn giá và Hệ Số");
		Thread.sleep(2000);
		MainPage.DGVHS();
		Thread.sleep(2000);
		MainPage.SpeacialEducationProgram();
		WebElement speacialElement=driver.findElement(By.xpath("//*[@id=\"special-tab\"]"));
		String prinString = speacialElement.getText();
		String pageSource = driver.getPageSource();
		  if (pageSource.contains(savedID)) {
	            System.out.println("Dữ liệu " + savedID + " đã Hủy xóa tại Cấp Bậc tồn tại ở mục "+ prinString);
	        } else {
	            System.out.println("Dữ liệu " + savedID + " đã Hủy xóa tại Cấp Bậc không tồn tại ở mục "+prinString);
	        }
			System.out.println("============");

	}
	@Test(priority = 10)
	public void Action10() throws InterruptedException, IOException {
		System.out.println("Testcase 10: Xóa cấp bậc tại HHHV và kiểm tra có hiện thị ở Đơn Giá và Hệ Số tại mục CTĐT Đặc Biệt");
		DGVHSCBP MainPage = new DGVHSCBP(driver);
		MainPage.HHHV();
		Thread.sleep(2000);
		MainPage.CapBac();
		Thread.sleep(2000);
		FileInputStream fis = new FileInputStream("K:\\Automation\\CapBac.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		XSSFRow row = sheet.getRow(7);
		String ID = row.getCell(0).getStringCellValue();
		driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank_filter\"]/label/input")).sendKeys(ID);
		savedID = ID;
		MainPage.DeleteButton();
		System.out.println("======");
		System.out.println("Chuyển sang Đơn giá và Hệ Số");
		Thread.sleep(2000);
		MainPage.DGVHS();
		Thread.sleep(2000);
		MainPage.SpeacialEducationProgram();
		WebElement speacialElement=driver.findElement(By.xpath("//*[@id=\"special-tab\"]"));
		String prinString = speacialElement.getText();
		String pageSource = driver.getPageSource();
		  if (pageSource.contains(savedID)) {
	            System.out.println("Dữ liệu " + savedID + " đã Xóa tại Cấp Bậc tồn tại ở mục "+ prinString);
	        } else {
	            System.out.println("Dữ liệu " + savedID + " đã Xóa tại Cấp Bậc không tồn tại ở mục "+prinString);
	        }
			System.out.println("============");
	
	}
	@Test(priority = 11)
	public void Action11() throws InterruptedException, IOException {
		System.out.println("Testcase 11: Hủy xóa cấp bậc tại HHHV và kiểm tra có hiện thị ở Đơn Giá và Hệ Số tại mục Người Nước Ngoài");
		DGVHSCBP MainPage = new DGVHSCBP(driver);
		MainPage.HHHV();
		Thread.sleep(2000);
		MainPage.CapBac();
		Thread.sleep(2000);
		FileInputStream fis = new FileInputStream("K:\\Automation\\CapBac.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		XSSFRow row = sheet.getRow(8);
		String ID = row.getCell(0).getStringCellValue();
		
		driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank_filter\"]/label/input")).sendKeys(ID);
		savedID = ID;
		MainPage.CloseDeleteButton();
		System.out.println("======");
		System.out.println("Chuyển sang Đơn Giá và Hệ Số và chọn ");
		Thread.sleep(2000);
		MainPage.DGVHS();
		Thread.sleep(2000);
		MainPage.Foreigner();
		WebElement foreignerElement=driver.findElement(By.xpath("//*[@id=\"foreign-tab\"]"));
		String prinString = foreignerElement.getText();
		String pageSource = driver.getPageSource();
		  if (pageSource.contains(savedID)) {
	            System.out.println("Dữ liệu " + savedID + " đã Hủy xóa tại Cấp Bậc tồn tại ở mục "+ prinString);
	        } else {
	            System.out.println("Dữ liệu " + savedID + " đã Hủy xóa tại Cấp Bậc không tồn tại ở mục "+prinString);
	        }
			System.out.println("============");

		
	}
	@Test(priority = 12)
	public void Action12() throws InterruptedException, IOException {
		System.out.println("Testcase 12: Xóa cấp bậc tại HHHV và kiểm tra có hiện thị ở Đơn Giá và Hệ Số tại mục Người Nước Ngoài");
		DGVHSCBP MainPage = new DGVHSCBP(driver);
		MainPage.HHHV();
		Thread.sleep(2000);
		MainPage.CapBac();
		Thread.sleep(2000);
		FileInputStream fis = new FileInputStream("K:\\Automation\\CapBac.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		XSSFRow row = sheet.getRow(8);
		String ID = row.getCell(0).getStringCellValue();
		driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank_filter\"]/label/input")).sendKeys(ID);
		savedID = ID;
		Thread.sleep(2000);
		MainPage.DeleteButton();
		System.out.println("======");
		System.out.println("Chuyển sang Đơn giá và Hệ Số");
		MainPage.DGVHS();
		Thread.sleep(2000);
		MainPage.Foreigner();
		WebElement foreignerElement=driver.findElement(By.xpath("//*[@id=\"foreign-tab\"]"));
		String prinString = foreignerElement.getText();
		String pageSource = driver.getPageSource();
		  if (pageSource.contains(savedID)) {
	            System.out.println("Dữ liệu " + savedID + " đã Xóa tại Cấp Bậc tồn tại ở mục "+ prinString);
	        } else {
	            System.out.println("Dữ liệu " + savedID + " đã Xóa tại Cấp Bậc không tồn tại ở mục "+prinString);
	        }
			System.out.println("============");

	}
//	@Test(priority = 13)
//	public void Action13() throws InterruptedException, IOException {
//		System.out.println("Testcase 13: Chỉnh sửa và ấn Lưu Đơn Giá của Cấp Bậc tại Đơn giá và Hệ Số tại mục CTĐTTC");
//		DGVHSCBP MainPage = new DGVHSCBP(driver);
//		Thread.sleep(2000);
//		MainPage.DGVHS();
//		Thread.sleep(2000);
//		MainPage.UpdateStandard();
//		FileInputStream fis = new FileInputStream("K:\\Automation\\CapBac.xlsx");
//		XSSFWorkbook workbook = new XSSFWorkbook(fis);
//		XSSFSheet sheet = workbook.getSheetAt(0);
//		XSSFRow row = sheet.getRow(9);
//		String ID = row.getCell(0).getStringCellValue();
//		driver.findElement(By.xpath("//*[@id=\"price\"]")).clear();
//		driver.findElement(By.xpath("//*[@id=\"price\"]")).sendKeys(ID);
//		MainPage.SaveButtonChanging();
//		savedID = ID;
//		Thread.sleep(4000);
//		WebElement standardElement=driver.findElement(By.xpath("//*[@id=\"standard-tab\"]"));
//		String prinString = standardElement.getText();
//		String pageSource = driver.getPageSource();
//		  if (pageSource.contains(savedID)) {
//	            System.out.println("Đơn giá " + savedID + " cập nhật thành công ở mục "+ prinString);
//	        } else {
//	            System.out.println("Đơn giá " + savedID + " cập nhật không thành công ở mục "+prinString);
//	        }
//			System.out.println("============");
//		
//	}
//	@Test(priority = 14)
//	public void Action14() throws InterruptedException, IOException {
//		System.out.println("Testcase 14: Chỉnh sửa và ấn Hủy Đơn Giá của Cấp Bậc tại Đơn giá và Hệ Số tại mục CTĐTTC");
//		DGVHSCBP MainPage = new DGVHSCBP(driver);
//		Thread.sleep(2000);
//		MainPage.DGVHS();
//		Thread.sleep(2000);
//		MainPage.UpdateStandard();
//		FileInputStream fis = new FileInputStream("K:\\Automation\\CapBac.xlsx");
//		XSSFWorkbook workbook = new XSSFWorkbook(fis);
//		XSSFSheet sheet = workbook.getSheetAt(0);
//		XSSFRow row = sheet.getRow(9);
//		String ID = row.getCell(0).getStringCellValue();
//		driver.findElement(By.xpath("//*[@id=\"price\"]")).clear();
//		driver.findElement(By.xpath("//*[@id=\"price\"]")).sendKeys(ID);
//		MainPage.CloseButtonChanging();
//		savedID = ID;
//		Thread.sleep(4000);
//		WebElement foreignerElement=driver.findElement(By.xpath("//*[@id=\"standard-tab\"]"));
//		String prinString = foreignerElement.getText();
//		String pageSource = driver.getPageSource();
//		  if (pageSource.contains(savedID)) {
//	            System.out.println("Đơn giá " + savedID + " vừa ấn Hủy cập nhật vẫn tồn tại ở mục "+ prinString);
//	        } else {
//	            System.out.println("Đơn giá " + savedID + " vừa ấn Hủy cập nhật đã bị thay đổi ở mục "+prinString);
//	        }
//			System.out.println("============");
//
//		
//	}
//	@Test(priority = 15)
//	public void Action15() throws InterruptedException, IOException {
//		System.out.println("Testcase 15: Chỉnh sửa và ấn Lưu Đơn Giá của Cấp Bậc tại Đơn giá và Hệ Số tại mục CTĐTĐB");
//		DGVHSCBP MainPage = new DGVHSCBP(driver);
//		Thread.sleep(2000);
//		MainPage.DGVHS();
//		MainPage.SpeacialEducationProgram();
//		Thread.sleep(2000);
//		MainPage.UpdateSpeacial();
//		FileInputStream fis = new FileInputStream("K:\\Automation\\CapBac.xlsx");
//		XSSFWorkbook workbook = new XSSFWorkbook(fis);
//		XSSFSheet sheet = workbook.getSheetAt(0);
//		XSSFRow row = sheet.getRow(9);
//		String ID = row.getCell(0).getStringCellValue();
//		driver.findElement(By.xpath("//*[@id=\"price\"]")).clear();
//		driver.findElement(By.xpath("//*[@id=\"price\"]")).sendKeys(ID);
//		MainPage.SaveButtonChanging();
//		savedID = ID;
//		Thread.sleep(4000);
//		WebElement standardElement=driver.findElement(By.xpath("//*[@id=\"special-tab\"]"));
//		String prinString = standardElement.getText();
//		String pageSource = driver.getPageSource();
//		  if (pageSource.contains(savedID)) {
//	            System.out.println("Đơn giá " + savedID + " cập nhật thành công ở mục "+ prinString);
//	        } else {
//	            System.out.println("Đơn giá " + savedID + " cập nhật không thành công ở mục "+prinString);
//	        }
//			System.out.println("============");
//		
//	}
//	@Test(priority = 16)
//	public void Action16() throws InterruptedException, IOException {
//		System.out.println("Testcase 16: Chỉnh sửa và ấn Hủy Đơn Giá của Cấp Bậc tại Đơn giá và Hệ Số tại mục CTĐTĐB");
//		DGVHSCBP MainPage = new DGVHSCBP(driver);
//		Thread.sleep(2000);
//		MainPage.DGVHS();
//		Thread.sleep(2000);
//		MainPage.SpeacialEducationProgram();
//		Thread.sleep(2000);
//		MainPage.UpdateSpeacial();
//		FileInputStream fis = new FileInputStream("K:\\Automation\\CapBac.xlsx");
//		XSSFWorkbook workbook = new XSSFWorkbook(fis);
//		XSSFSheet sheet = workbook.getSheetAt(0);
//		XSSFRow row = sheet.getRow(9);
//		String ID = row.getCell(0).getStringCellValue();
//		driver.findElement(By.xpath("//*[@id=\"price\"]")).clear();
//		driver.findElement(By.xpath("//*[@id=\"price\"]")).sendKeys(ID);
//		MainPage.CloseButtonChanging();
//		savedID = ID;
//		Thread.sleep(4000);
//		WebElement foreignerElement=driver.findElement(By.xpath("//*[@id=\"special-tab\"]"));
//		String prinString = foreignerElement.getText();
//		String pageSource = driver.getPageSource();
//		  if (pageSource.contains(savedID)) {
//	            System.out.println("Đơn giá " + savedID + " vừa ấn Hủy cập nhật vẫn tồn tại ở mục "+ prinString);
//	        } else {
//	            System.out.println("Đơn giá " + savedID + " vừa ấn Hủy cập nhật đã bị thay đổi ở mục "+prinString);
//	        }
//			System.out.println("============");
//
//		
//	}
//	@Test(priority = 17)
//	public void Action17() throws InterruptedException, IOException {
//		System.out.println("Testcase 17: Chỉnh sửa và ấn Lưu Đơn Giá của Cấp Bậc tại Đơn giá và Hệ Số tại mục Người nước ngoài");
//		DGVHSCBP MainPage = new DGVHSCBP(driver);
//		Thread.sleep(2000);
//		MainPage.DGVHS();
//		Thread.sleep(2000);
//		MainPage.Foreigner();
//		Thread.sleep(2000);
//		MainPage.UpdateForeigner();
//		FileInputStream fis = new FileInputStream("K:\\Automation\\CapBac.xlsx");
//		XSSFWorkbook workbook = new XSSFWorkbook(fis);
//		XSSFSheet sheet = workbook.getSheetAt(0);
//		XSSFRow row = sheet.getRow(9);
//		String ID = row.getCell(0).getStringCellValue();
//		driver.findElement(By.xpath("//*[@id=\"price\"]")).clear();
//		driver.findElement(By.xpath("//*[@id=\"price\"]")).sendKeys(ID);
//		MainPage.SaveButtonChanging();
//		savedID = ID;
//		Thread.sleep(4000);
//		WebElement standardElement=driver.findElement(By.xpath("//*[@id=\"foreign-tab\"]"));
//		String prinString = standardElement.getText();
//		String pageSource = driver.getPageSource();
//		  if (pageSource.contains(savedID)) {
//	            System.out.println("Đơn giá " + savedID + " cập nhật thành công ở mục "+ prinString);
//	        } else {
//	            System.out.println("Đơn giá " + savedID + " cập nhật không thành công ở mục "+prinString);
//	        }
//			System.out.println("============");
//		
//	}
//	@Test(priority = 18)
//	public void Action18() throws InterruptedException, IOException {
//		System.out.println("Testcase 18: Chỉnh sửa và ấn Hủy Đơn Giá của Cấp Bậc tại Đơn giá và Hệ Số tại mục Người nước ngoài");
//		DGVHSCBP MainPage = new DGVHSCBP(driver);
//		Thread.sleep(2000);
//		MainPage.DGVHS();
//		Thread.sleep(2000);
//		MainPage.Foreigner();
//		Thread.sleep(2000);
//		MainPage.UpdateForeigner();
//		FileInputStream fis = new FileInputStream("K:\\Automation\\CapBac.xlsx");
//		XSSFWorkbook workbook = new XSSFWorkbook(fis);
//		XSSFSheet sheet = workbook.getSheetAt(0);
//		XSSFRow row = sheet.getRow(9);
//		String ID = row.getCell(0).getStringCellValue();
//		driver.findElement(By.xpath("//*[@id=\"price\"]")).clear();
//		driver.findElement(By.xpath("//*[@id=\"price\"]")).sendKeys(ID);
//		MainPage.CloseButtonChanging();
//		savedID = ID;
//		Thread.sleep(4000);
//		WebElement foreignerElement=driver.findElement(By.xpath("//*[@id=\"foreign-tab\"]"));
//		String prinString = foreignerElement.getText();
//		String pageSource = driver.getPageSource();
//		  if (pageSource.contains(savedID)) {
//	            System.out.println("Đơn giá " + savedID + " vừa ấn Hủy cập nhật vẫn tồn tại ở mục "+ prinString);
//	        } else {
//	            System.out.println("Đơn giá " + savedID + " vừa ấn Hủy cập nhật đã bị thay đổi ở mục "+prinString);
//	        }
//			System.out.println("============");
//	}
//	@Test(priority = 19)
//	public void Action19() throws InterruptedException, IOException {
//		System.out.println("Testcase 19: Xóa Đơn Giá của Cấp Bậc tại Đơn giá và Hệ Số tại mục CTĐTTC");
//		DGVHSCBP MainPage = new DGVHSCBP(driver);
//		Thread.sleep(2000);
//		MainPage.DGVHS();
//		Thread.sleep(2000);
//		MainPage.UpdateStandard();
//		FileInputStream fis = new FileInputStream("K:\\Automation\\CapBac.xlsx");
//		XSSFWorkbook workbook = new XSSFWorkbook(fis);
//		XSSFSheet sheet = workbook.getSheetAt(0);
//		XSSFRow row = sheet.getRow(9);
//		String ID = row.getCell(0).getStringCellValue();
//		driver.findElement(By.xpath("//*[@id=\"price\"]")).clear();
//		driver.findElement(By.xpath("//*[@id=\"price\"]")).sendKeys(ID);
//		MainPage.SaveButtonChanging();
//		savedID = ID;
//		Thread.sleep(4000);
//		WebElement standardElement=driver.findElement(By.xpath("//*[@id=\"standard-tab\"]"));
//		String prinString = standardElement.getText();
//		String pageSource = driver.getPageSource();
//		  if (pageSource.contains(savedID)) {
//	            System.out.println("Đơn giá " + savedID + " cập nhật thành công ở mục "+ prinString);
//	        } else {
//	            System.out.println("Đơn giá " + savedID + " cập nhật không thành công ở mục "+prinString);
//	        }
//			System.out.println("============");
//		
//	}
}
