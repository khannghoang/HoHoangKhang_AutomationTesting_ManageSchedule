package QUANLYHOCKI_TEST;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageSetup.Setup;
import QUANLYHOCKY_PAGE.XemDuLieuHocKyPage;
import QUANLYHOCKY_PAGE.XoaHocKyPage;

public class XoaHocKyTest {
	static WebDriver driver;
	private String saveId;
	private By clickData = By.xpath("//*[@id=\"tblTerm_length\"]/label/select");

	@BeforeSuite
	public void Main() throws IOException, InterruptedException {
		Setup setup = new Setup(); 
		driver = setup.setup();
		Thread.sleep(2000);
	}
	@BeforeTest
	public void Setup2() {
		XoaHocKyPage MainPage = new XoaHocKyPage(driver);
		MainPage.Menu();
	}
	@Test
	public void Action1() throws IOException, InterruptedException {
		XoaHocKyPage MainPage = new XoaHocKyPage(driver);
        FileInputStream fis = new FileInputStream("K:\\Automation\\AddNewTerm.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        // Lấy dữ liệu học kỳ từ ô đầu tiên của dòng thứ tư
        String HK = sheet.getRow(4).getCell(0).getStringCellValue();
		MainPage.InputTerm(HK);
		saveId = HK;
		MainPage.CloseDeleteButton();
		driver.navigate().refresh();
		Thread.sleep(4000);
		WebElement dropdown = driver.findElement(clickData);
		Select select = new Select(dropdown);
		select.selectByValue("-1");
		String pageSource = driver.getPageSource();
		if (pageSource.contains(saveId)) {
			System.out.println("Dữ liệu " + saveId + " đã Hủy xóa tại Học Kỳ vẫn tồn tại ");
		} else {
			System.out.println("Dữ liệu " + saveId + " đã Hủy xóa tại Học Kỳ không tồn tại ");
		}
		System.out.println("============");
	}
	@Test
	public void Action2() throws IOException, InterruptedException {
		XoaHocKyPage MainPage = new XoaHocKyPage(driver);
        FileInputStream fis = new FileInputStream("K:\\Automation\\AddNewTerm.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        // Lấy dữ liệu học kỳ từ ô đầu tiên của dòng thứ tư
        String HK = sheet.getRow(4).getCell(0).getStringCellValue();
		MainPage.InputTerm(HK);
		saveId = HK;
		MainPage.Delte();
		driver.navigate().refresh();
		Thread.sleep(4000);
		WebElement dropdown = driver.findElement(clickData);
		Select select = new Select(dropdown);
		select.selectByValue("-1");
		String pageSource = driver.getPageSource();
		if (pageSource.contains(saveId)) {
			System.out.println("Dữ liệu " + saveId + " đã Xóa tại Học Kỳ vẫn tồn tại ");
		} else {
			System.out.println("Dữ liệu " + saveId + " đã Xóa tại Học Kỳ không tồn tại ");
		}
		System.out.println("============");
	}
}
