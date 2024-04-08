package QUANLYTHOIKHOABIEU_TEST;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageSetup.Setup;
import QUANLYTHOIKHOABIEU_PAGE.XemThoiKhoaBieuPage;

public class XemThoiKhoaBieuTest {
    static WebDriver driver;

    @BeforeTest
    public void Main() throws IOException, InterruptedException {
        Setup setup = new Setup();
        driver = setup.setup();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[4]/a")).click();
        Thread.sleep(2000);
    }

    @Test
    public void Action1() throws InterruptedException, IOException {
        System.out.println("Testcase 1: Dữ liệu thời khóa biểu của giảng viên trong Học Kỳ");
        driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[4]/ul/li[3]/a")).click();
        FileInputStream fis = new FileInputStream("K:\\Automation\\XemThoiKhoaBieu.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        XSSFRow row = sheet.getRow(0);
        String hocKy = row.getCell(0).getStringCellValue();
        String tenGiangVien = row.getCell(1).getStringCellValue();

        XemThoiKhoaBieuPage thoiKhoaBieuPage = new XemThoiKhoaBieuPage(driver);
        

        thoiKhoaBieuPage.clickHocKyDropdown();
        thoiKhoaBieuPage.inputHocKy(hocKy);
        Thread.sleep(2000);

        thoiKhoaBieuPage.clickTenGiangVienDropdown();
        thoiKhoaBieuPage.inputTenGiangVien(tenGiangVien);
        Thread.sleep(2000);

        int numberOfWeeks = thoiKhoaBieuPage.getNumberOfWeeks();
        for (int i = 2; i <= numberOfWeeks; i++) {
            thoiKhoaBieuPage.selectWeek(i);
            Thread.sleep(2000);

            String timetableData = thoiKhoaBieuPage.getTimetableData();
            System.out.println("Thời khóa biểu của giảng viên " + tenGiangVien + " tại tuần " + i + " là: ");
            System.out.println(timetableData);
            System.out.println("==========");
            Thread.sleep(2000);
        }
    }
    @Test
    public void Action2() throws InterruptedException, IOException {
        System.out.println("Testcase 2: Dữ liệu thời khóa biểu của giảng viên không có trong Học Kỳ");
        driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[4]/ul/li[3]/a")).click();
        FileInputStream fis = new FileInputStream("K:\\Automation\\XemThoiKhoaBieu.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        XSSFRow row = sheet.getRow(1);
        String hocKy = row.getCell(0).getStringCellValue();
        String tenGiangVien = row.getCell(1).getStringCellValue();

        XemThoiKhoaBieuPage thoiKhoaBieuPage = new XemThoiKhoaBieuPage(driver);
        

        thoiKhoaBieuPage.clickHocKyDropdown();
        thoiKhoaBieuPage.inputHocKy(hocKy);
        Thread.sleep(2000);

        thoiKhoaBieuPage.clickTenGiangVienDropdown();
        thoiKhoaBieuPage.inputTenGiangVien(tenGiangVien);
        Thread.sleep(2000);

		Thread.sleep(2000);
		String expectedString ="Chưa có dữ liệu phân công trong học kỳ";
		WebElement errorElement =driver.findElement(By.xpath("//*[@id=\"personalTimetableDiv\"]/h4"));
		String printString = errorElement.getText();
		System.out.println("Kết quả mong đợi "+expectedString);
		System.out.println("Kết quả thực tế: "+printString);
        
    }
}
