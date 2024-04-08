package HOCHAMHOCVITEST;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import HOCHAMHOCVIPAGE.TimKiemCapBac_Page;
import HOCHAMHOCVIPAGE.XoaCapBac_Page;
import PageSetup.Setup;

public class XoaCapBac_Test {
	   static WebDriver driver;
			@BeforeSuite
			public void Main() throws IOException, InterruptedException {
				Setup setup = new Setup();
				driver = setup.setup();
				Thread.sleep(3000);
			}
			@BeforeTest
			public void Setup2() throws InterruptedException {
				XoaCapBac_Page MainPage = new XoaCapBac_Page(driver);
				MainPage.Menu();
				Thread.sleep(2000);
			}
			@Test(priority = 1)
			public void Actions1() throws IOException, InterruptedException {
				System.out.println("Testcase 1 :Xóa cấp bậc và ấn Hủy");
				XoaCapBac_Page MainPage = new XoaCapBac_Page(driver);
				MainPage.HHHVMenu();
				Thread.sleep(2000);
				MainPage.CapBac();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank_filter\"]/label/input")).sendKeys("TestingKhang13");
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank\"]/tbody/tr[2]/td[2]/a[2]")).click();
				Thread.sleep(2000);
				WebElement clikElement=driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[3]"));
				clikElement.click();
				try {
					clikElement.click();
					System.out.println("Click hủy không thành công");
				} catch (WebDriverException e) {
					System.out.println("Click hủy thành công");
				}
				System.out.println("=======");
				
			}

			@Test(priority = 2)
			public void Actions2() throws IOException, InterruptedException {
				System.out.println("Testcase 2 :Xóa cấp bậc đã có dữ liệu và ấn Hủy");
				XoaCapBac_Page MainPage = new XoaCapBac_Page(driver);
				MainPage.HHHVMenu();
				Thread.sleep(2000);
				MainPage.CapBac();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank_filter\"]/label/input")).sendKeys("TestingKhang11");
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank\"]/tbody/tr[2]/td[2]/a[2]")).click();
				Thread.sleep(2000);
				WebElement clikElement=driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[3]"));
				clikElement.click();
				try {
					clikElement.click();
					System.out.println("Click hủy không thành công");
				} catch (WebDriverException e) {
					System.out.println("Click hủy thành công");
				}
				System.out.println("=======");

			}

			@Test(priority = 3)
			public void Actions3() throws IOException, InterruptedException {
				System.out.println("Testcase 3 :");
				XoaCapBac_Page MainPage = new XoaCapBac_Page(driver);
				MainPage.HHHVMenu();
				Thread.sleep(2000);
				MainPage.CapBac();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank_filter\"]/label/input")).sendKeys("TestingKhang13");
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank\"]/tbody/tr[2]/td[2]/a[2]")).click();
				Thread.sleep(3000);
				WebElement cliElement=driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[1]"));
				cliElement.click();
				try {
					cliElement.click();
					System.out.println("Xóa không thành công");
				} catch (WebDriverException e) {
					System.out.println("Xóa thành công dữ liệu");
				}
				System.out.println("=======");
				
			}

			@Test(priority = 4)
			public void Actions4() throws IOException, InterruptedException {
				System.out.println("Testcase 4 :Xóa học hàm học vị đã có dữ liệu");
				XoaCapBac_Page MainPage = new XoaCapBac_Page(driver);
				MainPage.HHHVMenu();
				Thread.sleep(2000);
				MainPage.CapBac();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank_filter\"]/label/input")).sendKeys("TestingKhang11");
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id=\"tblAcademicDegreeRank\"]/tbody/tr[2]/td[2]/a[2]")).click();
				Thread.sleep(3000);
				WebElement cliElement=driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[1]"));
				cliElement.click();
				Thread.sleep(2000);
				try {
					driver.findElement(By.xpath("//*[@id=\"swal2-title\"]")).getText();
					System.out.println("Click xóa không thành công");
					WebElement errorElement = driver.findElement(By.xpath("//*[@id=\"swal2-html-container\"]"));
					// In ra kết quả thực tế của thông báo lỗi trên giao diện web
					System.out.println("Kết quả thực tế: " + errorElement.getText());
				} catch (WebDriverException e) {
					System.out.println("Click xóa thành công");
				}
				System.out.println("=======");

			}

			@AfterTest
			public void Close() {
				driver.close();
			}
}
