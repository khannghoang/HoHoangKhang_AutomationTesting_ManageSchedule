package HOCHAMHOCVITEST;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import HOCHAMHOCVIPAGE.HienThiDuLieu_CapBac_Page;
import PageSetup.Setup;

public class HienThiDuLieu_CapBac_Test {
    static WebDriver driver;

	@BeforeSuite
	public void Main() throws IOException, InterruptedException {
		Setup setup = new Setup();
		driver = setup.setup();
		Thread.sleep(3000);
	}
	@BeforeTest
	public void Setup2() throws InterruptedException {
		HienThiDuLieu_CapBac_Page MainPage = new HienThiDuLieu_CapBac_Page(driver);
		MainPage.Menu();
		Thread.sleep(2000);

	}
	@Test
	public void Action1() throws InterruptedException {
		System.out.println("Testcase 1: CHỨC NĂNG HIỂN THỊ DỮ LIỆU CỦA CẤP BẬC KHI HIỂN THỊ 25 DỮ LIỆU");
		HienThiDuLieu_CapBac_Page MainPage = new HienThiDuLieu_CapBac_Page(driver);
		MainPage.HHHVMenu();
		Thread.sleep(2000);
		MainPage.CapBac();
		Thread.sleep(2000);
		MainPage.SelectData("25");
		MainPage.PrintData();
		System.out.println("============");
	}
	@Test
	public void Action2() throws InterruptedException {
		System.out.println("Testcase 2: CHỨC NĂNG HIỂN THỊ DỮ LIỆU CỦA CẤP BẬC KHI HIỂN THỊ 50 DỮ LIỆU");
		HienThiDuLieu_CapBac_Page MainPage = new HienThiDuLieu_CapBac_Page(driver);
		MainPage.HHHVMenu();
		Thread.sleep(2000);
		MainPage.CapBac();
		Thread.sleep(2000);
		MainPage.SelectData("50");
		MainPage.PrintData();
		System.out.println("============");
	}
	@Test
	public void Action3() throws InterruptedException {
		System.out.println("Testcase 3: CHỨC NĂNG HIỂN THỊ DỮ LIỆU CỦA CẤP BẬC KHI HIỂN THỊ TẤT CẢ DỮ LIỆU");
		HienThiDuLieu_CapBac_Page MainPage = new HienThiDuLieu_CapBac_Page(driver);
		MainPage.HHHVMenu();
		Thread.sleep(2000);
		MainPage.CapBac();
		Thread.sleep(2000);
		MainPage.SelectData("-1");
		MainPage.PrintData();
		System.out.println("============");
	}
	@Test(priority = 4)
	public void Action4() throws InterruptedException {
		System.out.println("Testcase 4: CHỨC NĂNG HIỂN THỊ DỮ LIỆU CỦA HỌC HÀM HỌC VỊ KHI HIỂN THỊ 25 DỮ LIỆU VÀ ẤN VÀO MÃ CẤP BẬC SẮP XẾP");
		HienThiDuLieu_CapBac_Page MainPage = new HienThiDuLieu_CapBac_Page(driver);
		MainPage.HHHVMenu();
		Thread.sleep(2000);
		MainPage.CapBac();
		Thread.sleep(2000);
		MainPage.SelectData("25");
		Thread.sleep(2000);
		WebElement clickSortElement=driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank\"]/thead/tr/th[1]"));
		clickSortElement.click();
		clickSortElement.click();
		System.out.println("Dữ liệu được in từ cao đến thấp");
		WebElement prinElement=driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank\"]/tbody"));
		String dataString=prinElement.getText();
		System.out.println(dataString);
		System.out.println("======");
		clickSortElement.click();
		System.out.println("Dữ liệu được in từ thấp đến cao");
		WebElement prinElement2=driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank\"]/tbody"));
		String dataString2=prinElement2.getText();
		System.out.println(dataString2);
		System.out.println("============");
	}
	@Test(priority = 5)
	public void Action5() throws InterruptedException {
		System.out.println("Testcase 5: CHỨC NĂNG HIỂN THỊ DỮ LIỆU CỦA HỌC HÀM HỌC VỊ KHI HIỂN THỊ 50 DỮ LIỆU VÀ ẤN VÀO MÃ CẤP BẬC SẮP XẾP");
		HienThiDuLieu_CapBac_Page MainPage = new HienThiDuLieu_CapBac_Page(driver);
		MainPage.HHHVMenu();
		Thread.sleep(2000);
		MainPage.CapBac();
		Thread.sleep(2000);
		MainPage.SelectData("50");
		Thread.sleep(2000);
		WebElement clickSortElement=driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank\"]/thead/tr/th[1]"));
		clickSortElement.click();
		clickSortElement.click();
		System.out.println("Dữ liệu được in từ cao đến thấp");
		WebElement prinElement=driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank\"]/tbody"));
		String dataString=prinElement.getText();
		System.out.println(dataString);
		System.out.println("======");
		clickSortElement.click();
		System.out.println("Dữ liệu được in từ thấp đến cao");
		WebElement prinElement2=driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank\"]/tbody"));
		String dataString2=prinElement2.getText();
		System.out.println(dataString2);
		System.out.println("============");
	}
	@Test(priority = 6)
	public void Action6() throws InterruptedException {
		System.out.println("Testcase 6: CHỨC NĂNG HIỂN THỊ DỮ LIỆU CỦA HỌC HÀM HỌC VỊ KHI HIỂN THỊ TẤT CẢ DỮ LIỆU VÀ ẤN VÀO MÃ CẤP BẬC SẮP XẾP");
		HienThiDuLieu_CapBac_Page MainPage = new HienThiDuLieu_CapBac_Page(driver);
		MainPage.HHHVMenu();
		Thread.sleep(2000);
		MainPage.CapBac();
		Thread.sleep(2000);
		MainPage.SelectData("-1");
		Thread.sleep(2000);
		WebElement clickSortElement=driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank\"]/thead/tr/th[1]"));
		clickSortElement.click();
		clickSortElement.click();
		System.out.println("Dữ liệu được in từ cao đến thấp");
		WebElement prinElement=driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank\"]/tbody"));
		String dataString=prinElement.getText();
		System.out.println(dataString);
		System.out.println("======");
		clickSortElement.click();
		System.out.println("Dữ liệu được in từ thấp đến cao");
		WebElement prinElement2=driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank\"]/tbody"));
		String dataString2=prinElement2.getText();
		System.out.println(dataString2);
		System.out.println("============");
	}
	@AfterTest
	public void Close() {
		driver.close();
	}

}
