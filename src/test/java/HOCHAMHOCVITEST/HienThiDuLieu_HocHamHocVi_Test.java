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
import HOCHAMHOCVIPAGE.HienThiDuLieu_HocHamHocVi_Page;
import PageSetup.Setup;

public class HienThiDuLieu_HocHamHocVi_Test {
	static WebDriver driver;

	@BeforeSuite
	public void Main() throws IOException, InterruptedException {
		Setup setup = new Setup();
		driver = setup.setup();
		Thread.sleep(3000);
	}

	@BeforeTest
	public void Setup2() throws InterruptedException {
		HienThiDuLieu_HocHamHocVi_Page MainPage = new HienThiDuLieu_HocHamHocVi_Page(driver);
		MainPage.Menu();
		Thread.sleep(2000);

	}

	@Test
	public void Action1() throws InterruptedException {
		System.out.println("Testcase 1: CHỨC NĂNG HIỂN THỊ DỮ LIỆU CỦA HỌC HÀM HỌC VỊ KHI HIỂN THỊ 10 DỮ LIỆU");
		HienThiDuLieu_HocHamHocVi_Page MainPage = new HienThiDuLieu_HocHamHocVi_Page(driver);
		MainPage.HHHVMenu();
		Thread.sleep(2000);
		MainPage.SelectData("10");
		MainPage.PrintData();
		System.out.println("========");

	}

	@Test
	public void Action2() throws InterruptedException {
		System.out.println("Testcase 2: CHỨC NĂNG HIỂN THỊ DỮ LIỆU CỦA HỌC HÀM HỌC VỊ KHI HIỂN THỊ 25 DỮ LIỆU");
		HienThiDuLieu_HocHamHocVi_Page MainPage = new HienThiDuLieu_HocHamHocVi_Page(driver);
		MainPage.HHHVMenu();
		Thread.sleep(2000);
		MainPage.SelectData("25");
		MainPage.PrintData();
		System.out.println("========");

	}

	@Test
	public void Action3() throws InterruptedException {
		System.out.println("Testcase 3: CHỨC NĂNG HIỂN THỊ DỮ LIỆU CỦA HỌC HÀM HỌC VỊ KHI HIỂN THỊ 50 DỮ LIỆU");
		HienThiDuLieu_HocHamHocVi_Page MainPage = new HienThiDuLieu_HocHamHocVi_Page(driver);
		MainPage.HHHVMenu();
		Thread.sleep(2000);
		MainPage.SelectData("50");
		MainPage.PrintData();
		System.out.println("========");

	}

	@Test
	public void Action4() throws InterruptedException {
		System.out.println("Testcase 4: CHỨC NĂNG HIỂN THỊ DỮ LIỆU CỦA HỌC HÀM HỌC VỊ KHI HIỂN THỊ TẤT CẢ DỮ LIỆU");
		HienThiDuLieu_HocHamHocVi_Page MainPage = new HienThiDuLieu_HocHamHocVi_Page(driver);
		MainPage.HHHVMenu();
		Thread.sleep(2000);
		MainPage.SelectData("-1");
		MainPage.PrintData();
		System.out.println("========");
	}

	@Test(priority = 5)
	public void Action5() throws InterruptedException {
		System.out.println(
				"Testcase 5: CHỨC NĂNG HIỂN THỊ DỮ LIỆU CỦA HỌC HÀM HỌC VỊ KHI HIỂN THỊ 10 DỮ LIỆU VÀ ẤN VÀO MÃ HHHV SẮP XẾP");
		HienThiDuLieu_HocHamHocVi_Page MainPage = new HienThiDuLieu_HocHamHocVi_Page(driver);
		MainPage.HHHVMenu();
		Thread.sleep(2000);
		MainPage.SelectData("10");
		Thread.sleep(2000);
		WebElement clickSortElement = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/thead/tr/th[2]"));
		clickSortElement.click();
		clickSortElement.click();
		System.out.println("Dữ liệu được in từ cao đến thấp");
		WebElement prinElement = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/tbody"));
		String dataString = prinElement.getText();
		System.out.println(dataString);
		System.out.println("======");
		clickSortElement.click();
		System.out.println("Dữ liệu được in từ thấp đến cao");
		WebElement prinElement2 = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/tbody"));
		String dataString2 = prinElement2.getText();
		System.out.println(dataString2);
		System.out.println("============");
	}

	@Test(priority = 6)
	public void Action6() throws InterruptedException {
		System.out.println(
				"Testcase 6: CHỨC NĂNG HIỂN THỊ DỮ LIỆU CỦA HỌC HÀM HỌC VỊ KHI HIỂN THỊ 25 DỮ LIỆU VÀ ẤN VÀO MÃ HHHV SẮP XẾP");
		HienThiDuLieu_HocHamHocVi_Page MainPage = new HienThiDuLieu_HocHamHocVi_Page(driver);
		MainPage.HHHVMenu();
		Thread.sleep(2000);
		MainPage.SelectData("25");
		Thread.sleep(2000);
		WebElement clickSortElement = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/thead/tr/th[2]"));
		clickSortElement.click();
		clickSortElement.click();
		System.out.println("Dữ liệu được in từ cao đến thấp");
		WebElement prinElement = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/tbody"));
		String dataString = prinElement.getText();
		System.out.println(dataString);
		System.out.println("======");
		clickSortElement.click();
		System.out.println("Dữ liệu được in từ thấp đến cao");
		WebElement prinElement2 = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/tbody"));
		String dataString2 = prinElement2.getText();
		System.out.println(dataString2);
		System.out.println("============");

	}

	@Test(priority = 7)
	public void Action7() throws InterruptedException {
		System.out.println(
				"Testcase 7:  CHỨC NĂNG HIỂN THỊ DỮ LIỆU CỦA HỌC HÀM HỌC VỊ KHI HIỂN THỊ 50 DỮ LIỆU VÀ ẤN VÀO MÃ HHHV SẮP XẾPp");
		HienThiDuLieu_HocHamHocVi_Page MainPage = new HienThiDuLieu_HocHamHocVi_Page(driver);
		MainPage.HHHVMenu();
		Thread.sleep(2000);
		MainPage.SelectData("50");
		Thread.sleep(2000);
		WebElement clickSortElement = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/thead/tr/th[2]"));
		clickSortElement.click();
		clickSortElement.click();
		System.out.println("Dữ liệu được in từ cao đến thấp");
		WebElement prinElement = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/tbody"));
		String dataString = prinElement.getText();
		System.out.println(dataString);
		System.out.println("======");
		clickSortElement.click();
		System.out.println("Dữ liệu được in từ thấp đến cao");
		WebElement prinElement2 = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/tbody"));
		String dataString2 = prinElement2.getText();
		System.out.println(dataString2);
		System.out.println("============");

	}

	@Test(priority = 8)
	public void Action8() throws InterruptedException {
		System.out.println(
				"Testcase 8:  CHỨC NĂNG HIỂN THỊ DỮ LIỆU CỦA HỌC HÀM HỌC VỊ KHI HIỂN THỊ TẤT CẢ DỮ LIỆU VÀ ẤN VÀO MÃ HHHV SẮP XẾP");
		HienThiDuLieu_HocHamHocVi_Page MainPage = new HienThiDuLieu_HocHamHocVi_Page(driver);
		MainPage.HHHVMenu();
		Thread.sleep(2000);
		MainPage.SelectData("-1");
		Thread.sleep(2000);
		WebElement clickSortElement = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/thead/tr/th[2]"));
		clickSortElement.click();
		clickSortElement.click();
		System.out.println("Dữ liệu được in từ cao đến thấp");
		WebElement prinElement = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/tbody"));
		String dataString = prinElement.getText();
		System.out.println(dataString);
		System.out.println("======");
		clickSortElement.click();
		System.out.println("Dữ liệu được in từ thấp đến cao");
		WebElement prinElement2 = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/tbody"));
		String dataString2 = prinElement2.getText();
		System.out.println(dataString2);
		System.out.println("============");

	}

	@Test(priority = 9)
	public void Action9() throws InterruptedException {
		System.out.println(
				"Testcase 9: CHỨC NĂNG HIỂN THỊ DỮ LIỆU CỦA HỌC HÀM HỌC VỊ KHI HIỂN THỊ 10 DỮ LIỆU VÀ ẤN VÀO TÊN HHHV SẮP XẾP");
		HienThiDuLieu_HocHamHocVi_Page MainPage = new HienThiDuLieu_HocHamHocVi_Page(driver);
		MainPage.HHHVMenu();
		Thread.sleep(2000);
		MainPage.SelectData("10");
		Thread.sleep(2000);
		WebElement clickSortElement = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/thead/tr/th[3]"));
		clickSortElement.click();
		clickSortElement.click();
		System.out.println("Dữ liệu được in từ cao đến thấp");
		WebElement prinElement = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/tbody"));
		String dataString = prinElement.getText();
		System.out.println(dataString);
		System.out.println("======");
		clickSortElement.click();
		System.out.println("Dữ liệu được in từ thấp đến cao");
		WebElement prinElement2 = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/tbody"));
		String dataString2 = prinElement2.getText();
		System.out.println(dataString2);
		System.out.println("============");

	}

	@Test(priority = 10)
	public void Action10() throws InterruptedException {
		System.out.println(
				"Testcase 10: CHỨC NĂNG HIỂN THỊ DỮ LIỆU CỦA HỌC HÀM HỌC VỊ KHI HIỂN THỊ 25 DỮ LIỆU VÀ ẤN VÀO TÊN HHHV SẮP XẾP");
		HienThiDuLieu_HocHamHocVi_Page MainPage = new HienThiDuLieu_HocHamHocVi_Page(driver);
		MainPage.HHHVMenu();
		Thread.sleep(2000);
		MainPage.SelectData("25");
		Thread.sleep(2000);
		WebElement clickSortElement = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/thead/tr/th[3]"));
		clickSortElement.click();
		clickSortElement.click();
		System.out.println("Dữ liệu được in từ cao đến thấp");
		WebElement prinElement = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/tbody"));
		String dataString = prinElement.getText();
		System.out.println(dataString);
		System.out.println("======");
		clickSortElement.click();
		System.out.println("Dữ liệu được in từ thấp đến cao");
		WebElement prinElement2 = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/tbody"));
		String dataString2 = prinElement2.getText();
		System.out.println(dataString2);
		System.out.println("============");

	}

	@Test(priority = 11)
	public void Action11() throws InterruptedException {
		System.out.println(
				"Testcase 11:  CHỨC NĂNG HIỂN THỊ DỮ LIỆU CỦA HỌC HÀM HỌC VỊ KHI HIỂN THỊ 50 DỮ LIỆU VÀ ẤN VÀO TÊN HHHV SẮP XẾP");
		HienThiDuLieu_HocHamHocVi_Page MainPage = new HienThiDuLieu_HocHamHocVi_Page(driver);
		MainPage.HHHVMenu();
		Thread.sleep(2000);
		MainPage.SelectData("50");
		Thread.sleep(2000);
		WebElement clickSortElement = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/thead/tr/th[3]"));
		clickSortElement.click();
		clickSortElement.click();
		System.out.println("Dữ liệu được in từ cao đến thấp");
		WebElement prinElement = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/tbody"));
		String dataString = prinElement.getText();
		System.out.println(dataString);
		System.out.println("======");
		clickSortElement.click();
		System.out.println("Dữ liệu được in từ thấp đến cao");
		WebElement prinElement2 = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/tbody"));
		String dataString2 = prinElement2.getText();
		System.out.println(dataString2);
		System.out.println("============");

	}

	@Test(priority = 12)
	public void Action12() throws InterruptedException {
		System.out.println(
				"Testcase 12:  CHỨC NĂNG HIỂN THỊ DỮ LIỆU CỦA HỌC HÀM HỌC VỊ KHI HIỂN THỊ TẤT CẢ DỮ LIỆU VÀ ẤN VÀO TÊN HHHV SẮP XẾP");
		HienThiDuLieu_HocHamHocVi_Page MainPage = new HienThiDuLieu_HocHamHocVi_Page(driver);
		MainPage.HHHVMenu();
		Thread.sleep(2000);
		MainPage.SelectData("-1");
		Thread.sleep(2000);
		WebElement clickSortElement = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/thead/tr/th[3]"));
		clickSortElement.click();
		clickSortElement.click();
		System.out.println("Dữ liệu được in từ cao đến thấp");
		WebElement prinElement = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/tbody"));
		String dataString = prinElement.getText();
		System.out.println(dataString);
		System.out.println("======");
		clickSortElement.click();
		System.out.println("Dữ liệu được in từ thấp đến cao");
		WebElement prinElement2 = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/tbody"));
		String dataString2 = prinElement2.getText();
		System.out.println(dataString2);
		System.out.println("============");

	}

	@Test(priority = 13)
	public void Action13() throws InterruptedException {
		System.out.println(
				"Testcase 13: CHỨC NĂNG HIỂN THỊ DỮ LIỆU CỦA HỌC HÀM HỌC VỊ KHI HIỂN THỊ 10 DỮ LIỆU VÀ ẤN VÀO THỨ TỰ SẮP XẾP");
		HienThiDuLieu_HocHamHocVi_Page MainPage = new HienThiDuLieu_HocHamHocVi_Page(driver);
		MainPage.HHHVMenu();
		Thread.sleep(2000);
		MainPage.SelectData("10");
		Thread.sleep(2000);
		WebElement clickSortElement = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/thead/tr/th[4]"));
		clickSortElement.click();
		clickSortElement.click();
		System.out.println("Dữ liệu được in từ cao đến thấp");
		WebElement prinElement = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/tbody"));
		String dataString = prinElement.getText();
		System.out.println(dataString);
		System.out.println("======");
		clickSortElement.click();
		System.out.println("Dữ liệu được in từ thấp đến cao");
		WebElement prinElement2 = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/tbody"));
		String dataString2 = prinElement2.getText();
		System.out.println(dataString2);
		System.out.println("============");

	}

	@Test(priority = 14)
	public void Action14() throws InterruptedException {
		System.out.println(
				"Testcase 14: CHỨC NĂNG HIỂN THỊ DỮ LIỆU CỦA HỌC HÀM HỌC VỊ KHI HIỂN THỊ 25 DỮ LIỆU VÀ ẤN VÀO THỨ TỰ SẮP XẾP");
		HienThiDuLieu_HocHamHocVi_Page MainPage = new HienThiDuLieu_HocHamHocVi_Page(driver);
		MainPage.HHHVMenu();
		Thread.sleep(2000);
		MainPage.SelectData("25");
		Thread.sleep(2000);
		WebElement clickSortElement = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/thead/tr/th[4]"));
		clickSortElement.click();
		clickSortElement.click();
		System.out.println("Dữ liệu được in từ cao đến thấp");
		WebElement prinElement = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/tbody"));
		String dataString = prinElement.getText();
		System.out.println(dataString);
		System.out.println("======");
		clickSortElement.click();
		System.out.println("Dữ liệu được in từ thấp đến cao");
		WebElement prinElement2 = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/tbody"));
		String dataString2 = prinElement2.getText();
		System.out.println(dataString2);
		System.out.println("============");

	}

	@Test(priority = 15)
	public void Action15() throws InterruptedException {
		System.out.println(
				"Testcase 15:  CHỨC NĂNG HIỂN THỊ DỮ LIỆU CỦA HỌC HÀM HỌC VỊ KHI HIỂN THỊ 50 DỮ LIỆU VÀ ẤN VÀO THỨ TỰ SẮP XẾP");
		HienThiDuLieu_HocHamHocVi_Page MainPage = new HienThiDuLieu_HocHamHocVi_Page(driver);
		MainPage.HHHVMenu();
		Thread.sleep(2000);
		MainPage.SelectData("50");
		Thread.sleep(2000);
		WebElement clickSortElement = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/thead/tr/th[4]"));
		clickSortElement.click();
		clickSortElement.click();
		System.out.println("Dữ liệu được in từ cao đến thấp");
		WebElement prinElement = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/tbody"));
		String dataString = prinElement.getText();
		System.out.println(dataString);
		System.out.println("======");
		clickSortElement.click();
		System.out.println("Dữ liệu được in từ thấp đến cao");
		WebElement prinElement2 = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/tbody"));
		String dataString2 = prinElement2.getText();
		System.out.println(dataString2);
		System.out.println("============");

	}

	@Test(priority = 16)
	public void Action16() throws InterruptedException {
		System.out.println(
				"Testcase 16:  CHỨC NĂNG HIỂN THỊ DỮ LIỆU CỦA HỌC HÀM HỌC VỊ KHI HIỂN THỊ TẤT CẢ DỮ LIỆU VÀ ẤN VÀO THỨ TỰ SẮP XẾP");
		HienThiDuLieu_HocHamHocVi_Page MainPage = new HienThiDuLieu_HocHamHocVi_Page(driver);
		MainPage.HHHVMenu();
		Thread.sleep(2000);
		MainPage.SelectData("-1");
		Thread.sleep(2000);
		WebElement clickSortElement = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/thead/tr/th[4]"));
		clickSortElement.click();
		clickSortElement.click();
		System.out.println("Dữ liệu được in từ cao đến thấp");
		WebElement prinElement = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/tbody"));
		String dataString = prinElement.getText();
		System.out.println(dataString);
		System.out.println("======");
		clickSortElement.click();
		System.out.println("Dữ liệu được in từ thấp đến cao");
		WebElement prinElement2 = driver.findElement(By.xpath("//*[@id=\"tblAcademicDegree\"]/tbody"));
		String dataString2 = prinElement2.getText();
		System.out.println(dataString2);

	}

	@AfterTest
	public void Close() {
		driver.close();
	}
}
