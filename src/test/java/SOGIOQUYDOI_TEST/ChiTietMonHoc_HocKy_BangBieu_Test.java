package SOGIOQUYDOI_TEST;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageSetup.Setup;
import SOGIOQUYDOI_PAGE.ChiTietMonHoc_HocKy_BangBieu_Page;

public class ChiTietMonHoc_HocKy_BangBieu_Test {
	static WebDriver driver;

	@BeforeSuite
	public void Setup() throws InterruptedException {
		Setup setup = new Setup();
		driver = setup.setup();
		Thread.sleep(2000);
	}
	
	@BeforeTest
	public void Setup2() throws InterruptedException {
		ChiTietMonHoc_HocKy_BangBieu_Page page = new ChiTietMonHoc_HocKy_BangBieu_Page(driver);
		page.navigateToPage();
		page.selectTerm("789");
		page.selectMajor("Tất cả");
		page.switchToTableTab();

	}
	@Test
	public void viewCourseDetailsWithMultipleData1() throws InterruptedException {
		System.out.println(
				"Testcase 1: Chức năng xem môn học trong danh sách thống kê số giờ quy đổi của giáo viên theo Học Kỳ với 10 dữ liệu với bảng biểu");
		Thread.sleep(2000);
		WebElement scroll = driver.findElement(By.xpath("//*[@id=\"tblStatistics_info\"]"));
		Actions action = new Actions(driver);
		action.moveToElement(scroll).perform();
		Thread.sleep(4000);

		List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"tblStatistics\"]/tbody/tr/td[2]/button"));
		int numberOfElements = elements.size();
		for (int i = 1; i <= numberOfElements; i++) {
			String xpathButton = "//*[@id=\"tblStatistics\"]/tbody/tr["+i+"]/td[2]/button";
			WebElement itemElement = driver.findElement(By.xpath(xpathButton));
			itemElement.click();
			Thread.sleep(2000);
			WebElement dataElement1 = driver
					.findElement(By.xpath("//*[@id=\"tblStatistics\"]/tbody/tr[" + i + "]/td[4]"));
			String getDatString2 = dataElement1.getText();
			System.out.println("Dữ liệu được lấy từ giáo viên:" + getDatString2);
			Thread.sleep(2000);
			WebElement dataElement = driver
					.findElement(By.xpath("//*[@id=\"tblStatistics\"]/tbody/tr[" + (i + 1) + "]/td/div/table/tbody"));
			String getDatString = dataElement.getText();
			System.out.println(getDatString);
			itemElement.click();
			System.out.println("========");
		}
		System.out.println("==========");
	}

	@Test
	public void viewCourseDetailsWithMultipleData2() throws InterruptedException {
		System.out.println("Testcase 2: Chức năng xem môn học trong danh sách thống kê số giờ quy đổi của giáo viên theo Học Kỳ  với 25 dữ liệu");
		WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"tblStatistics_length\"]/label/select"));
		Select select = new Select(dropdown);
		select.selectByValue("25");
		Thread.sleep(2000);
		WebElement scroll = driver.findElement(By.xpath("//*[@id=\"tblStatistics_info\"]"));
		Actions action = new Actions(driver);
		action.moveToElement(scroll).perform();
		Thread.sleep(4000);

		List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"tblStatistics\"]/tbody/tr/td[2]/button"));
		int numberOfElements = elements.size();
		for (int i = 1; i <= numberOfElements; i++) {
			String xpathButton = "//*[@id=\"tblStatistics\"]/tbody/tr[" + i + "]/td[2]/button";
			WebElement itemElement = driver.findElement(By.xpath(xpathButton));
			itemElement.click();
			Thread.sleep(2000);
			WebElement dataElement1 = driver
					.findElement(By.xpath("//*[@id=\"tblStatistics\"]/tbody/tr[" + i + "]/td[4]"));
			String getDatString2 = dataElement1.getText();
			System.out.println("Dữ liệu được lấy từ giáo viên:" + getDatString2);
			Thread.sleep(2000);
			WebElement dataElement = driver
					.findElement(By.xpath("//*[@id=\"tblStatistics\"]/tbody/tr[" + (i + 1) + "]/td/div/table/tbody"));
			String getDatString = dataElement.getText();
			System.out.println(getDatString);
			itemElement.click();
			System.out.println("========");
		}
		System.out.println("==========");

	}
	@Test
	public void viewCourseDetailsWithMultipleData3() throws InterruptedException {
		System.out.println("Testcase 3: Chức năng xem môn học trong danh sách thống kê số giờ quy đổi của giáo viên theo Học Kỳ  với 50 dữ liệu");
		WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"tblStatistics_length\"]/label/select"));
		Select select = new Select(dropdown);
		select.selectByValue("50");
		Thread.sleep(2000);
		WebElement scroll = driver.findElement(By.xpath("//*[@id=\"tblStatistics_info\"]"));
		Actions action = new Actions(driver);
		action.moveToElement(scroll).perform();
		Thread.sleep(4000);

		List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"tblStatistics\"]/tbody/tr/td[2]/button"));
		int numberOfElements = elements.size();
		for (int i = 1; i <= numberOfElements; i++) {
			String xpathButton = "//*[@id=\"tblStatistics\"]/tbody/tr[" + i + "]/td[2]/button";
			WebElement itemElement = driver.findElement(By.xpath(xpathButton));
			itemElement.click();
			Thread.sleep(2000);
			WebElement dataElement1 = driver
					.findElement(By.xpath("//*[@id=\"tblStatistics\"]/tbody/tr[" + i + "]/td[4]"));
			String getDatString2 = dataElement1.getText();
			System.out.println("Dữ liệu được lấy từ giáo viên:" + getDatString2);
			Thread.sleep(2000);
			WebElement dataElement = driver
					.findElement(By.xpath("//*[@id=\"tblStatistics\"]/tbody/tr[" + (i + 1) + "]/td/div/table/tbody"));
			String getDatString = dataElement.getText();
			System.out.println(getDatString);
			itemElement.click();
			System.out.println("========");
		}
		System.out.println("==========");
	}
	@Test
	public void viewCourseDetailsWithMultipleData4() throws InterruptedException {
		System.out.println("Testcase 4: Chức năng xem môn học trong danh sách thống kê số giờ quy đổi của giáo viên theo Học Kỳ với tất cả dữ liệu");
		WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"tblStatistics_length\"]/label/select"));
		Select select = new Select(dropdown);
		select.selectByValue("-1");
		Thread.sleep(2000);
		WebElement scroll = driver.findElement(By.xpath("//*[@id=\"tblStatistics_info\"]"));
		Actions action = new Actions(driver);
		action.moveToElement(scroll).perform();

		List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"tblStatistics\"]/tbody/tr/td[2]/button"));
		int numberOfElements = elements.size();
		for (int i = 1; i <= numberOfElements; i++) {
			String xpathButton = "//*[@id=\"tblStatistics\"]/tbody/tr[" + i + "]/td[2]/button";
			WebElement itemElement = driver.findElement(By.xpath(xpathButton));
			itemElement.click();
			Thread.sleep(2000);
			WebElement dataElement1 = driver
					.findElement(By.xpath("//*[@id=\"tblStatistics\"]/tbody/tr[" + i + "]/td[4]"));
			String getDatString2 = dataElement1.getText();
			System.out.println("Dữ liệu được lấy từ giáo viên:" + getDatString2);
			Thread.sleep(2000);
			WebElement dataElement = driver
					.findElement(By.xpath("//*[@id=\"tblStatistics\"]/tbody/tr[" + (i + 1) + "]/td/div/table/tbody"));
			String getDatString = dataElement.getText();
			System.out.println(getDatString);
			itemElement.click();
			System.out.println("========");
		}
		System.out.println("==========");
	}
}
