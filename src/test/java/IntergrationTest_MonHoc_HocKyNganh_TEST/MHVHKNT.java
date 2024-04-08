package IntergrationTest_MonHoc_HocKyNganh_TEST;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.dockerjava.api.model.Driver;

import IntergrationsTest_MonHoc_HocKyNganh_PAGE.MHVHKNP;
import PageSetup.Setup;

public class MHVHKNT {
	static WebDriver driver;
	@BeforeSuite
	public void Main() throws IOException, InterruptedException {
		Setup setup = new Setup();
		driver = setup.setup();
		Thread.sleep(3000);
	}
	@BeforeTest
	public void Setup2() throws InterruptedException {
		MHVHKNP MainPage = new MHVHKNP(driver);
		MainPage.OpenHK();
	}
	@Test
	public void Action1() throws InterruptedException, IOException {
		System.out.println("Testcase 1:");
		MHVHKNP MainPage = new MHVHKNP(driver);
		MainPage.AddHKButton();
		Thread.sleep(2000);
		MainPage.themHocKy("180");
		MainPage.SaveHKButton();
		Thread.sleep(2000);
		MainPage.MenuNavigation();
		Thread.sleep(2000);
		MainPage.MonHoc();
		String pageSource = driver.getPageSource();
		  if (pageSource.contains("180")) {
	            System.out.println("Dữ liệu học kỳ 180 đã tạo tại Học Kỳ đã tồn tại trong textbox học kỳ Môn Học ");
	        } else {
	            System.out.println("Dữ liệu học kỳ 180 đã tạo tại Học Kỳ đã không tồn tại trong textbox học kỳ Môn Học ");
	        }
			System.out.println("============");
	}
	@Test
	public void Action2() throws InterruptedException, IOException {
		System.out.println("Testcase 2:");
		MHVHKNP MainPage = new MHVHKNP(driver);
		MainPage.AddHKButton();
		Thread.sleep(2000);
		MainPage.themHocKy("187");
		MainPage.CloseHKButton();
		Thread.sleep(2000);
		MainPage.MenuNavigation();
		Thread.sleep(2000);
		MainPage.MonHoc();
		String pageSource = driver.getPageSource();
		  if (pageSource.contains("187")) {
	            System.out.println("Dữ liệu 187 được tạo và ấn Hủy tại Học Kỳ đã tồn tại trong textbox học kỳ Môn Học ");
	        } else {
	            System.out.println("Dữ liệu 187 được tạo và ấn Hủy tại Học Kỳ đã không tồn tại trong textbox học kỳ Môn Học ");
	        }
			System.out.println("============");
	}
	@Test
	public void Action3() throws InterruptedException, IOException {
		System.out.println("Testcase 3:");
		MHVHKNP MainPage = new MHVHKNP(driver);
		driver.findElement(By.xpath("//*[@id=\"tblTerm_filter\"]/label/input")).sendKeys("180");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"tblTerm\"]/tbody/tr[1]/td[9]/a[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"term-form\"]/div[5]/input[2]"))
	      .click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/span[13]")).click();
		MainPage.SaveHKButton();
		Thread.sleep(2000);
		MainPage.MenuNavigation();
		Thread.sleep(2000);
		MainPage.MonHoc();
		String pageSource = driver.getPageSource();
		  if (pageSource.contains("180")) {
	            System.out.println("Dữ liệu học kỳ 180 đã chỉnh sửa tại Học Kỳ đã tồn tại trong textbox học kỳ Môn Học ");
	        } else {
	            System.out.println("Dữ liệu học kỳ 180 đã chỉnh sửa Học Kỳ đã không tồn tại trong textbox học kỳ Môn Học ");
	        }
			System.out.println("============");
	}
	@Test
	public void Action4() throws InterruptedException, IOException {
		System.out.println("Testcase 4:");
		MHVHKNP MainPage = new MHVHKNP(driver);
		driver.findElement(By.xpath("//*[@id=\"tblTerm_filter\"]/label/input")).sendKeys("180");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"tblTerm\"]/tbody/tr[1]/td[9]/a[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"term-form\"]/div[5]/input[2]"))
	      .click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/span[13]")).click();
		MainPage.CloseHKButton();
		Thread.sleep(2000);
		MainPage.MenuNavigation();
		Thread.sleep(2000);
		MainPage.MonHoc();
		String pageSource = driver.getPageSource();
		  if (pageSource.contains("180")) {
	            System.out.println("Dữ liệu học kỳ 180 đã Hủy chỉnh sửa tại Học Kỳ đã tồn tại trong textbox học kỳ Môn Học ");
	        } else {
	            System.out.println("Dữ liệu học kỳ 180 đã Hủy chỉnh sửa Học Kỳ đã không tồn tại trong textbox học kỳ Môn Học ");
	        }
			System.out.println("============");
	}
	@Test
	public void Action5() throws InterruptedException, IOException {
		System.out.println("Testcase 5:");
		MHVHKNP MainPage = new MHVHKNP(driver);
		driver.findElement(By.xpath("//*[@id=\"tblTerm_filter\"]/label/input")).sendKeys("180");
		Thread.sleep(2000);
		MainPage.CloseHKDelete();
		Thread.sleep(2000);
		MainPage.MenuNavigation();
		Thread.sleep(2000);
		MainPage.MonHoc();
		String pageSource = driver.getPageSource();
		  if (pageSource.contains("180")) {
	            System.out.println("Dữ liệu học kỳ 180 đã Hủy xóa tại Học Kỳ vẫn tồn tại trong textbox học kỳ Môn Học ");
	        } else {
	            System.out.println("Dữ liệu học kỳ 180 đã Hủy xóa tại Học Kỳ đã không tồn tại trong textbox học kỳ Môn Học ");
	        }
		  System.out.println("============");
	}
	@Test
	public void Action6() throws InterruptedException, IOException {
		System.out.println("Testcase 6:");
		MHVHKNP MainPage = new MHVHKNP(driver);
		driver.findElement(By.xpath("//*[@id=\"tblTerm_filter\"]/label/input")).sendKeys("180");
		Thread.sleep(2000);
		MainPage.DeleteHK();
		Thread.sleep(2000);
		MainPage.MenuNavigation();
		Thread.sleep(2000);
		MainPage.MonHoc();
		String pageSource = driver.getPageSource();
		  if (pageSource.contains("180")) {
	            System.out.println("Dữ liệu học kỳ 180 đã Xóa tại Học Kỳ vẫn tồn tại trong textbox học kỳ Môn Học ");
	        } else {
	            System.out.println("Dữ liệu học kỳ 180 đã Xóa tại Học Kỳ đã không tồn tại trong textbox học kỳ Môn Học ");
	        }
			System.out.println("============");
	}
	@Test
	public void Action7() throws InterruptedException, IOException {
		System.out.println("Testcase 7:");
		MHVHKNP MainPage = new MHVHKNP(driver);
		MainPage.TabNganh();
		Thread.sleep(2000);
		MainPage.AddNganhButton();
		Thread.sleep(2000);
		MainPage.InputDataNganh("14102003","KhangCNTT","KIT");
		MainPage.SaveNganhButton();
		Thread.sleep(2000);
		MainPage.MenuNavigation();
		Thread.sleep(2000);
		MainPage.MonHoc();
		String pageSource = driver.getPageSource();
		  if (pageSource.contains("KhangCNTT")) {
	            System.out.println("Dữ liệu Ngành KhangCNTT đã tạo tại Ngành đã tồn tại trong textbox ngành của Môn Học ");
	        } else {
	            System.out.println("Dữ liệu Ngành KhangCNTT đã tạo tại Ngành đã không tồn tại trong textbox ngành của Môn Học ");
	        }
			System.out.println("============");
	}
	@Test
	public void Action8() throws InterruptedException, IOException {
		System.out.println("Testcase 8:");
		MHVHKNP MainPage = new MHVHKNP(driver);
		MainPage.TabNganh();
		Thread.sleep(2000);
		MainPage.AddNganhButton();
		Thread.sleep(2000);
		MainPage.InputDataNganh("14102003","KhangCNTT01","KIT");
		MainPage.CloseNganhButton();
		Thread.sleep(2000);
		MainPage.MenuNavigation();
		Thread.sleep(2000);
		MainPage.MonHoc();
		String pageSource = driver.getPageSource();
		  if (pageSource.contains("KhangCNTT01")) {
	            System.out.println("Dữ liệu Ngành KhangCNTT01 đã Hủy tạo tại Ngành đã tồn tại trong textbox ngành của Môn Học ");
	        } else {
	            System.out.println("Dữ liệu Ngành KhangCNTT01 đã Hủy tạo tại Ngành đã không tồn tại trong textbox ngành của Môn Học ");
	        }
			System.out.println("============");
	}
	@Test
	public void Action9() throws InterruptedException, IOException {
		System.out.println("Testcase 9:");
		MHVHKNP MainPage = new MHVHKNP(driver);
		MainPage.TabNganh();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"tblMajor_filter\"]/label/input")).sendKeys("KhangCNTT");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"tblMajor\"]/tbody/tr/td[6]/a[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"name\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("KhangCNTTUpdate");
		MainPage.SaveNganhButton();
		Thread.sleep(2000);
		MainPage.MenuNavigation();
		Thread.sleep(2000);
		MainPage.MonHoc();
		String pageSource = driver.getPageSource();
		  if (pageSource.contains("KhangCNTTUpdate")) {
	            System.out.println("Dữ liệu Ngành KhangCNTTUpdate đã chỉnh sửa tại Ngành đã tồn tại trong textbox ngành của Môn Học ");
	        } else {
	            System.out.println("Dữ liệu Ngành KhangCNTTUpdate đã chỉnh sửa tại Ngành đã không tồn tại trong textbox ngành của Môn Học ");
	        }
			System.out.println("============");
	}
	@Test
	public void Action10() throws InterruptedException, IOException {
		System.out.println("Testcase 10:");
		MHVHKNP MainPage = new MHVHKNP(driver);
		MainPage.TabNganh();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"tblMajor_filter\"]/label/input")).sendKeys("KhangCNTTUpdate");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"tblMajor\"]/tbody/tr/td[6]/a[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"name\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("KhangCNTTUpdate2");
		MainPage.CloseNganhButton();
		Thread.sleep(2000);
		MainPage.MenuNavigation();
		Thread.sleep(2000);
		MainPage.MonHoc();
		String pageSource = driver.getPageSource();
		  if (pageSource.contains("KhangCNTTUpdate2")) {
	            System.out.println("Dữ liệu Ngành KhangCNTTUpdate đã Hủy chỉnh sửa tại Ngành đã tồn tại trong textbox ngành của Môn Học ");
	        } else {
	            System.out.println("Dữ liệu Ngành KhangCNTTUpdate đã Hủy chỉnh sửa tại Ngành đã không tồn tại trong textbox ngành của Môn Học ");
	        }
		
		  System.out.println("============");
	}
	@Test
	public void Action11() throws InterruptedException, IOException {
		System.out.println("Testcase 11:");
		MHVHKNP MainPage = new MHVHKNP(driver);
		MainPage.TabNganh();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"tblMajor_filter\"]/label/input")).sendKeys("KhangCNTTUpdate");
		MainPage.CloseNganhDelete();
		Thread.sleep(2000);
		MainPage.MenuNavigation();
		Thread.sleep(2000);
		MainPage.MonHoc();
		String pageSource = driver.getPageSource();
		  if (pageSource.contains("KhangCNTTUpdate")) {
	            System.out.println("Dữ liệu Ngành KhangCNTTUpdate đã Hủy xóa tại Ngành vẫn tồn tại trong textbox ngành của Môn Học ");
	        } else {
	            System.out.println("Dữ liệu Ngành KhangCNTTUpdate đã Hủy xóa tại Ngành đã không tồn tại trong textbox ngành của Môn Học ");
	        }
			System.out.println("============");
	}
	@Test
	public void Action12() throws InterruptedException, IOException {
		System.out.println("Testcase 12:");
		MHVHKNP MainPage = new MHVHKNP(driver);
		MainPage.TabNganh();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"tblMajor_filter\"]/label/input")).sendKeys("KhangCNTTUpdate");
		MainPage.DeleteNganh();
		Thread.sleep(2000);
		MainPage.MenuNavigation();
		Thread.sleep(2000);
		MainPage.MonHoc();
		String pageSource = driver.getPageSource();
		  if (pageSource.contains("KhangCNTTUpdate")) {
	            System.out.println("Dữ liệu Ngành KhangCNTTUpdate đã Xóa tại Ngành vẫn tồn tại trong textbox ngành của Môn Học ");
	        } else {
	            System.out.println("Dữ liệu Ngành KhangCNTTUpdate đã Xóa tại Ngành đã không tồn tại trong textbox ngành của Môn Học ");
	        }
			System.out.println("============");
	}
}
