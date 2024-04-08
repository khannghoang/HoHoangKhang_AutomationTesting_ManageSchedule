package QUANLYHOCKI_TEST;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageSetup.Setup;
import QUANLYHOCKY_PAGE.XemDuLieuHocKyPage;

public class XemDuLieuHocKiTest {
	static WebDriver driver;

	@BeforeTest
	public void Main() throws IOException, InterruptedException {
		Setup setup = new Setup(); 
		driver = setup.setup();
		Thread.sleep(2000);
		new XemDuLieuHocKyPage(driver).openTerm();

	}
	@Test(priority = 1)
    public void Action1() throws IOException, InterruptedException {
		System.out.println("Testcase 1:Hiển thị dữ liệu học kì với 10 dữ liệu");
		Thread.sleep(2000);
		new XemDuLieuHocKyPage(driver).printData();
		System.out.println("============");
		driver.navigate().refresh();

	}
	@Test(priority = 2)
    public void Action2() throws IOException, InterruptedException {
		System.out.println("Testcase 2:Hiển thị dữ liệu học kì với 25 dữ liệu");
//		new XemDuLieuHocKyPage(driver).openTerm();
		Thread.sleep(2000);
		new XemDuLieuHocKyPage(driver).clickDate25();
		Thread.sleep(2000);
		new XemDuLieuHocKyPage(driver).printData();
		System.out.println("============");
		driver.navigate().refresh();

	}
	@Test(priority = 3)
    public void Action3() throws IOException, InterruptedException {
		System.out.println("Testcase 3:Hiển thị dữ liệu học kì với 50 dữ liệu");
//		new XemDuLieuHocKyPage(driver).openTerm();
		Thread.sleep(2000);
		new XemDuLieuHocKyPage(driver).clickDate50();
		Thread.sleep(2000);
		new XemDuLieuHocKyPage(driver).printData();
		System.out.println("============");
		driver.navigate().refresh();

	}
	@Test(priority = 4)
    public void Action4() throws IOException, InterruptedException {
		System.out.println("Testcase 4:Hiển thị dữ liệu học kì với tất cả dữ liệu");
		new XemDuLieuHocKyPage(driver).openTerm();
		Thread.sleep(2000);
		new XemDuLieuHocKyPage(driver).clickDateAll();
		Thread.sleep(2000);
		new XemDuLieuHocKyPage(driver).printData();
		System.out.println("============");
		driver.navigate().refresh();

	}
}
