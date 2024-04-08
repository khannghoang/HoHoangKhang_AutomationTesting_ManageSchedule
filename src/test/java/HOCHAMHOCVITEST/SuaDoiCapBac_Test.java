package HOCHAMHOCVITEST;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import HOCHAMHOCVIPAGE.HienThiDuLieu_CapBac_Page;
import HOCHAMHOCVIPAGE.SuaDoiCapBac_Page;
import PageSetup.Setup;

public class SuaDoiCapBac_Test {
	   static WebDriver driver;

		@BeforeSuite
		public void Main() throws IOException, InterruptedException {
			Setup setup = new Setup();
			driver = setup.setup();
			Thread.sleep(3000);
		}
		@BeforeTest
		public void Setup2() throws InterruptedException {
			SuaDoiCapBac_Page MainPage = new SuaDoiCapBac_Page(driver);
			MainPage.Menu();
			Thread.sleep(2000);

		}
		@Test
		public void Action1() throws InterruptedException, IOException {
			SuaDoiCapBac_Page MainPage = new SuaDoiCapBac_Page(driver);
			MainPage.HHHVMenu();
			Thread.sleep(2000);
			MainPage.CapBac();
			Thread.sleep(2000);
			MainPage.InputName("KhangTesting");
			MainPage.ClickButton();
			Thread.sleep(2000);
			WebElement dropdown = driver.findElement(By.id("academic_degree_id"));
			Select select = new Select(dropdown);
			select.selectByValue("TestingKhang11");
			Thread.sleep(4000);
			MainPage.ClickCloseButton();
		}
		@Test
		public void Action2() throws InterruptedException, IOException {
			SuaDoiCapBac_Page MainPage = new SuaDoiCapBac_Page(driver);
			MainPage.HHHVMenu();
			Thread.sleep(2000);
			MainPage.CapBac();
			Thread.sleep(2000);
			MainPage.InputName("KhangTesting");
			MainPage.ClickButton();
			Thread.sleep(2000);
			WebElement dropdown = driver.findElement(By.id("academic_degree_id"));
			Select select = new Select(dropdown);
			select.selectByValue("TestingKhang11");
			Thread.sleep(4000);
			MainPage.ClickSaveButton();
		}
}
