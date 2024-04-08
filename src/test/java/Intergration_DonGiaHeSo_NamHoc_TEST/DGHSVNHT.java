package Intergration_DonGiaHeSo_NamHoc_TEST;

import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import IntergrationTest_DonGiaHeSo_CapBac_PAGE.DGVHSCBP;
import IntergrationTest_DonGiaHeSo_NamHoc_PAGE.DGHSVNHP;
import PageSetup.Setup;

public class DGHSVNHT {
	static WebDriver driver;
	private By inputHK = By.xpath("//*[@id=\"id\"]");
	private By startYearDropdown = By.id("start_year");
	private By endYearDropdown = By.id("end_year");
	private By startWeekInput = By.xpath("//*[@id=\"start_week\"]");
	private By maxLessonInput = By.xpath("//*[@id=\"max_lesson\"]");
	private By maxClassInput = By.xpath("//*[@id=\"max_class\"]");
	@BeforeTest
	public void Main() throws IOException, InterruptedException {
		Setup setup = new Setup();
		driver = setup.setup();
		Thread.sleep(3000);
	}
	@Test
	public void Action() throws InterruptedException, IOException {
		System.out.println("Testcase 1:  ");
		DGHSVNHP MainPage = new DGHSVNHP(driver);
		MainPage.MenuHK();
		Thread.sleep(2000);
		MainPage.AddNewTermButton();
		Thread.sleep(2000);
		driver.findElement(inputHK).sendKeys("198");
        Select startYearSelect = new Select(driver.findElement(startYearDropdown));
        startYearSelect.selectByValue("2030");

        Select endYearSelect = new Select(driver.findElement(endYearDropdown));
        endYearSelect.selectByValue("2031");
        Thread.sleep(2000);
        // Nhập số tuần bắt đầu học kỳ
        WebElement startWeek = driver.findElement(startWeekInput);
        startWeek.clear();
        Thread.sleep(3000);

        Random random = new Random();
        int randomNumber = random.nextInt(52) + 1;
        String randomString = Integer.toString(randomNumber);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '" + randomString + "';", startWeek);
        Thread.sleep(2000);
        
		driver.findElement(By.xpath("//*[@id=\"term-form\"]/div[5]/input[2]"))
	      .click();
		Thread.sleep(2000);

	// Chọn một phần tử để xác định thời gian
		driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/span[12]"))
	      .click();
        
        // Nhập số buổi học tối đa trong học kỳ
        WebElement maxLesson = driver.findElement(maxLessonInput);
        maxLesson.clear();
        Thread.sleep(3000);

        Random random2 = new Random();
        int randomNumber2 = random2.nextInt(2, 15);
        String randomString2 = Integer.toString(randomNumber2);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '" + randomString2 + "';", maxLesson);
        Thread.sleep(2000);

        // Nhập số lớp học tối đa trong học kỳ
        WebElement maxClass = driver.findElement(maxClassInput);
        maxClass.clear();
        Thread.sleep(3000);

        Random random3 = new Random();
        int randomNumber3 = random3.nextInt(30) + 1;
        String randomString3 = Integer.toString(randomNumber3);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '" + randomString3 + "';", maxClass);
        Thread.sleep(2000);		Thread.sleep(2000);
		MainPage.SaveHKButton();
		System.out.println("=========");
		System.out.println("CHuyển sang Đơn Giá và Hệ Số");
		Thread.sleep(2000);
		MainPage.MenuNavigation();
		Thread.sleep(2000);
		MainPage.DGVHS();
		String pageSource = driver.getPageSource();
		  if (pageSource.contains("2030 - 2031")) {
	            System.out.println("Dữ liệu 2030 - 2031 đã tạo tại Học Kỳ và tồn tại trong textbox Năm Học ");
	        } else {
	            System.out.println("Dữ liệu 2030 - 2031 đã tạo tại Học Kỳ và không tồn tại trong textbox Năm Học ");
	        }
			System.out.println("============");

	}
	@Test
	public void Action2() throws InterruptedException, IOException {
		System.out.println("Testcase 2:  ");
		DGHSVNHP MainPage = new DGHSVNHP(driver);
		MainPage.MenuHK();
		Thread.sleep(2000);
		MainPage.AddNewTermButton();
		Thread.sleep(2000);
		driver.findElement(inputHK).sendKeys("199");
        Select startYearSelect = new Select(driver.findElement(startYearDropdown));
        startYearSelect.selectByValue("2014");

        Select endYearSelect = new Select(driver.findElement(endYearDropdown));
        endYearSelect.selectByValue("2015");
        Thread.sleep(2000);
        // Nhập số tuần bắt đầu học kỳ
        WebElement startWeek = driver.findElement(startWeekInput);
        startWeek.clear();
        Thread.sleep(3000);

        Random random = new Random();
        int randomNumber = random.nextInt(52) + 1;
        String randomString = Integer.toString(randomNumber);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '" + randomString + "';", startWeek);
        Thread.sleep(2000);
        
		driver.findElement(By.xpath("//*[@id=\"term-form\"]/div[5]/input[2]"))
	      .click();
		Thread.sleep(2000);

	// Chọn một phần tử để xác định thời gian
		driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/span[12]"))
	      .click();
        
        // Nhập số buổi học tối đa trong học kỳ
        WebElement maxLesson = driver.findElement(maxLessonInput);
        maxLesson.clear();
        Thread.sleep(3000);

        Random random2 = new Random();
        int randomNumber2 = random2.nextInt(2, 15);
        String randomString2 = Integer.toString(randomNumber2);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '" + randomString2 + "';", maxLesson);
        Thread.sleep(2000);

        // Nhập số lớp học tối đa trong học kỳ
        WebElement maxClass = driver.findElement(maxClassInput);
        maxClass.clear();
        Thread.sleep(3000);

        Random random3 = new Random();
        int randomNumber3 = random3.nextInt(30) + 1;
        String randomString3 = Integer.toString(randomNumber3);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '" + randomString3 + "';", maxClass);
        Thread.sleep(2000);		Thread.sleep(2000);
		MainPage.CloseHKButton();
		System.out.println("=========");
		System.out.println("CHuyển sang Đơn Giá và Hệ Số");
		Thread.sleep(2000);
		MainPage.MenuNavigation();
		Thread.sleep(2000);
		MainPage.DGVHS();
		String pageSource = driver.getPageSource();
		  if (pageSource.contains("2014 - 2015")) {
	            System.out.println("Dữ liệu 2014 - 2015 đã ấn Hủy tại Học Kỳ và tồn tại trong textbox Năm Học ");
	        } else {
	            System.out.println("Dữ liệu 2014 - 2015 đã ấn Hủy tại Học Kỳ và không tồn tại trong textbox Năm Học ");
	        }
			System.out.println("============");

	}
	@Test
	public void Action3() throws InterruptedException, IOException {
		System.out.println("Testcase 3:  ");
		DGHSVNHP MainPage = new DGHSVNHP(driver);
		MainPage.MenuHK();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"tblTerm_filter\"]/label/input")).sendKeys("198");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"tblTerm\"]/tbody/tr/td[9]/a[1]")).click();
		Thread.sleep(2000);
        Select startYearSelect = new Select(driver.findElement(startYearDropdown));
        startYearSelect.selectByValue("2029");

        Select endYearSelect = new Select(driver.findElement(endYearDropdown));
        endYearSelect.selectByValue("2030");
        Thread.sleep(2000);
        // Nhập số tuần bắt đầu học kỳ
        WebElement startWeek = driver.findElement(startWeekInput);
        startWeek.clear();
        Thread.sleep(3000);

        Random random = new Random();
        int randomNumber = random.nextInt(52) + 1;
        String randomString = Integer.toString(randomNumber);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '" + randomString + "';", startWeek);
        Thread.sleep(2000);
        
		driver.findElement(By.xpath("//*[@id=\"term-form\"]/div[5]/input[2]"))
	      .click();
		Thread.sleep(2000);

	// Chọn một phần tử để xác định thời gian
		driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/span[12]"))
	      .click();
        
        // Nhập số buổi học tối đa trong học kỳ
        WebElement maxLesson = driver.findElement(maxLessonInput);
        maxLesson.clear();
        Thread.sleep(3000);

        Random random2 = new Random();
        int randomNumber2 = random2.nextInt(2, 15);
        String randomString2 = Integer.toString(randomNumber2);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '" + randomString2 + "';", maxLesson);
        Thread.sleep(2000);

        // Nhập số lớp học tối đa trong học kỳ
        WebElement maxClass = driver.findElement(maxClassInput);
        maxClass.clear();
        Thread.sleep(3000);

        Random random3 = new Random();
        int randomNumber3 = random3.nextInt(30) + 1;
        String randomString3 = Integer.toString(randomNumber3);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '" + randomString3 + "';", maxClass);
        Thread.sleep(2000);		Thread.sleep(2000);
		MainPage.SaveHKButton();
		System.out.println("=========");
		System.out.println("CHuyển sang Đơn Giá và Hệ Số");
		Thread.sleep(2000);
		MainPage.MenuNavigation();
		Thread.sleep(2000);
		MainPage.DGVHS();
		String pageSource = driver.getPageSource();
		  if (pageSource.contains("2029 - 2030")) {
	            System.out.println("Dữ liệu 2029 - 2030 đã chỉnh sửa tại Học Kỳ và tồn tại trong textbox Năm Học ");
	        } else {
	            System.out.println("Dữ liệu 2029 - 2030 đã chỉnh sửa tại Học Kỳ và không tồn tại trong textbox Năm Học ");
	        }
			System.out.println("============");

	}

	@Test
	public void Action4() throws InterruptedException, IOException {
		System.out.println("Testcase 4:  ");
		DGHSVNHP MainPage = new DGHSVNHP(driver);
		MainPage.MenuHK();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"tblTerm_filter\"]/label/input")).sendKeys("198");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"tblTerm\"]/tbody/tr/td[9]/a[1]")).click();
		Thread.sleep(2000);
        Select startYearSelect = new Select(driver.findElement(startYearDropdown));
        startYearSelect.selectByValue("2028");

        Select endYearSelect = new Select(driver.findElement(endYearDropdown));
        endYearSelect.selectByValue("2030");
        Thread.sleep(2000);
        // Nhập số tuần bắt đầu học kỳ
        WebElement startWeek = driver.findElement(startWeekInput);
        startWeek.clear();
        Thread.sleep(3000);

        Random random = new Random();
        int randomNumber = random.nextInt(52) + 1;
        String randomString = Integer.toString(randomNumber);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '" + randomString + "';", startWeek);
        Thread.sleep(2000);
        
		driver.findElement(By.xpath("//*[@id=\"term-form\"]/div[5]/input[2]"))
	      .click();
		Thread.sleep(2000);

	// Chọn một phần tử để xác định thời gian
		driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/span[12]"))
	      .click();
        
        // Nhập số buổi học tối đa trong học kỳ
        WebElement maxLesson = driver.findElement(maxLessonInput);
        maxLesson.clear();
        Thread.sleep(3000);

        Random random2 = new Random();
        int randomNumber2 = random2.nextInt(2, 15);
        String randomString2 = Integer.toString(randomNumber2);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '" + randomString2 + "';", maxLesson);
        Thread.sleep(2000);

        // Nhập số lớp học tối đa trong học kỳ
        WebElement maxClass = driver.findElement(maxClassInput);
        maxClass.clear();
        Thread.sleep(3000);

        Random random3 = new Random();
        int randomNumber3 = random3.nextInt(30) + 1;
        String randomString3 = Integer.toString(randomNumber3);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '" + randomString3 + "';", maxClass);
        Thread.sleep(2000);		Thread.sleep(2000);
		MainPage.CloseHKButton();
		System.out.println("=========");
		System.out.println("CHuyển sang Đơn Giá và Hệ Số");
		Thread.sleep(2000);
		MainPage.MenuNavigation();
		Thread.sleep(2000);
		MainPage.DGVHS();
		String pageSource = driver.getPageSource();
		  if (pageSource.contains("2028 - 2030")) {
	            System.out.println("Dữ liệu 2028 - 2030 ấn Hủy chỉnh sửa tại Học Kỳ và tồn tại trong textbox Năm Học ");
	        } else {
	            System.out.println("Dữ liệu 2028 - 2030 ấn Hủy chỉnh sửa tại Học Kỳ và không tồn tại trong textbox Năm Học ");
	        }
			System.out.println("============");

	}

	@Test
	public void Action5() throws InterruptedException, IOException {
		System.out.println("Testcase 5:  ");
		DGHSVNHP MainPage = new DGHSVNHP(driver);
		MainPage.MenuHK();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"tblTerm_filter\"]/label/input")).sendKeys("198");
		Thread.sleep(2000);
		MainPage.CloseHKDelete();
		System.out.println("=========");
		System.out.println("Chuyển sang Đơn Giá và Hệ Số");
		Thread.sleep(2000);
		MainPage.MenuNavigation();
		Thread.sleep(2000);
		MainPage.DGVHS();
		String pageSource = driver.getPageSource();
		  if (pageSource.contains("2028 - 2030")) {
	            System.out.println("Dữ liệu 2028 - 2030 ấn Hủy xóa tại Học Kỳ và tồn tại trong textbox Năm Học ");
	        } else {
	            System.out.println("Dữ liệu 2028 - 2030 ấn Hủy xóa tại Học Kỳ và không tồn tại trong textbox Năm Học ");
	        }
			System.out.println("============");
	}
	@Test
	public void Action6() throws InterruptedException, IOException {
		System.out.println("Testcase 6:  ");
		DGHSVNHP MainPage = new DGHSVNHP(driver);
		MainPage.MenuHK();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"tblTerm_filter\"]/label/input")).sendKeys("198");
		Thread.sleep(2000);
		MainPage.DeleteHK();
		System.out.println("=========");
		System.out.println("Chuyển sang Đơn Giá và Hệ Số");
		Thread.sleep(2000);
		MainPage.MenuNavigation();
		Thread.sleep(2000);
		MainPage.DGVHS();
		String pageSource = driver.getPageSource();
		  if (pageSource.contains("2028 - 2030")) {
	            System.out.println("Dữ liệu 2028 - 2030 ấn Xóa tại Học Kỳ và tồn tại trong textbox Năm Học ");
	        } else {
	            System.out.println("Dữ liệu 2028 - 2030 ấn Xóa tại Học Kỳ và không tồn tại trong textbox Năm Học ");
	        }
			System.out.println("============");
	}

}
