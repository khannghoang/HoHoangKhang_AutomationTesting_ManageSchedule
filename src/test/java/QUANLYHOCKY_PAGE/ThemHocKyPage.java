package QUANLYHOCKY_PAGE;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.Random;

public class ThemHocKyPage {
    private WebDriver driver;

    // Xpaths của các phần tử trên trang
	private By clickHocKyPage = By.xpath("//*[@id=\"main-menu-navigation\"]/li[2]/a");
    private By clickThemHocKyButton = By.xpath("//*[@id=\"tblTerm_wrapper\"]/div[1]/div[2]/div/div[2]/button");
    private By hocKyInput = By.xpath("//*[@id=\"id\"]");
    private By startYearDropdown = By.id("start_year");
    private By endYearDropdown = By.id("end_year");
    private By startWeekInput = By.xpath("//*[@id=\"start_week\"]");
    private By maxLessonInput = By.xpath("//*[@id=\"max_lesson\"]");
    private By maxClassInput = By.xpath("//*[@id=\"max_class\"]");
    private By luuButton = By.xpath("//*[@id=\"term-form\"]/div[7]/button[2]");
    private By errorMessage = By.xpath("//*[@id=\"id-error\"]");
    private By errorMessage1 = By.xpath("//*[@id=\"start_week-error\"]");
    private By errorMessage2 = By.xpath("//*[@id=\"start_date-error\"]");
    private By errorMessage3 = By.xpath("//*[@id=\"max_lesson-error\"]");
    private By errorMessage4 = By.xpath("//*[@id=\"max_class-error\"]");
    private By huyButtonBy = By.xpath("//*[@id=\"btnClose\"]");
    public ThemHocKyPage(WebDriver driver) {
        this.driver = driver;
    }

    public void themHocKy(String HK) throws InterruptedException, IOException {
    	
    	driver.findElement(clickHocKyPage).click();

        // Click vào nút để thêm học kỳ
        driver.findElement(clickThemHocKyButton).click();
        Thread.sleep(2000);

        // Nhập dữ liệu học kỳ
        driver.findElement(hocKyInput).sendKeys(HK);
        Thread.sleep(2000);

        // Chọn năm bắt đầu và kết thúc học kỳ
        Select startYearSelect = new Select(driver.findElement(startYearDropdown));
        startYearSelect.selectByValue("2025");

        Select endYearSelect = new Select(driver.findElement(endYearDropdown));
        endYearSelect.selectByValue("2026");
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
        Thread.sleep(2000);

        // Click để lưu thông tin vừa nhập
        WebElement clickElement = driver.findElement(luuButton);
        clickElement.click();
		try {
			clickElement.click();
			System.out.println("Click Lưu không thành công");
		}

		catch (WebDriverException e) {
			System.out.println("Kết quả thực tế: Lưu thành công");
		}
		
    }
    public void themHocKy2(String HK) throws InterruptedException, IOException {
    	
    	driver.findElement(clickHocKyPage).click();

        // Click vào nút để thêm học kỳ
        driver.findElement(clickThemHocKyButton).click();
        Thread.sleep(2000);

        // Nhập dữ liệu học kỳ
        driver.findElement(hocKyInput).sendKeys(HK);
        Thread.sleep(2000);

        // Chọn năm bắt đầu và kết thúc học kỳ
        Select startYearSelect = new Select(driver.findElement(startYearDropdown));
        startYearSelect.selectByValue("2025");

        Select endYearSelect = new Select(driver.findElement(endYearDropdown));
        endYearSelect.selectByValue("2026");
        Thread.sleep(2000);
        // Nhập số tuần bắt đầu học kỳ
        WebElement startWeek = driver.findElement(startWeekInput);
        startWeek.clear();
        Thread.sleep(3000);
        
        // Nhập số buổi học tối đa trong học kỳ
        WebElement maxLesson = driver.findElement(maxLessonInput);
        maxLesson.clear();
        Thread.sleep(3000);


        // Nhập số lớp học tối đa trong học kỳ
        WebElement maxClass = driver.findElement(maxClassInput);
        maxClass.clear();
        Thread.sleep(3000);



        // Click để lưu thông tin vừa nhập
        WebElement clickElement = driver.findElement(luuButton);
        clickElement.click();
		try {
			clickElement.click();
			System.out.println("Click Lưu không thành công");
		}

		catch (WebDriverException e) {
			System.out.println("Kết quả thực tế: Lưu thành công");
		}
		
    }
    public void themHocKy3(String HK) throws InterruptedException, IOException {
    	
    	driver.findElement(clickHocKyPage).click();

        // Click vào nút để thêm học kỳ
        driver.findElement(clickThemHocKyButton).click();
        Thread.sleep(2000);

        // Nhập dữ liệu học kỳ
        driver.findElement(hocKyInput).sendKeys(HK);
        Thread.sleep(2000);

        // Chọn năm bắt đầu và kết thúc học kỳ
        Select startYearSelect = new Select(driver.findElement(startYearDropdown));
        startYearSelect.selectByValue("2025");

        Select endYearSelect = new Select(driver.findElement(endYearDropdown));
        endYearSelect.selectByValue("2026");
        Thread.sleep(2000);
        // Nhập số tuần bắt đầu học kỳ
        WebElement startWeek = driver.findElement(startWeekInput);
        startWeek.clear();
        Thread.sleep(3000);
        startWeek.sendKeys("++");
        
       
        // Nhập số buổi học tối đa trong học kỳ
        WebElement maxLesson = driver.findElement(maxLessonInput);
        maxLesson.clear();
        Thread.sleep(3000);
        maxLesson.sendKeys("++");

        // Nhập số lớp học tối đa trong học kỳ
        WebElement maxClass = driver.findElement(maxClassInput);
        maxClass.clear();
        Thread.sleep(3000);
        maxClass.sendKeys("++");
        
	    driver.findElement(By.xpath("//*[@id=\"term-form\"]/div[5]/input[2]")).click();
	    // Thực hiện click vào một phần tử trên trang web để chọn thời gian
	    driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/span[12]")).click();
      
		
    }
    public void themHocKy4(String HK) throws InterruptedException, IOException {
    	
    	driver.findElement(clickHocKyPage).click();

        // Click vào nút để thêm học kỳ
        driver.findElement(clickThemHocKyButton).click();
        Thread.sleep(2000);

        // Nhập dữ liệu học kỳ
        driver.findElement(hocKyInput).sendKeys(HK);
        Thread.sleep(2000);

        // Chọn năm bắt đầu và kết thúc học kỳ
        Select startYearSelect = new Select(driver.findElement(startYearDropdown));
        startYearSelect.selectByValue("2025");

        Select endYearSelect = new Select(driver.findElement(endYearDropdown));
        endYearSelect.selectByValue("2026");
        Thread.sleep(2000);
        // Nhập số tuần bắt đầu học kỳ
        WebElement startWeek = driver.findElement(startWeekInput);
        startWeek.clear();
        Thread.sleep(3000);
        startWeek.sendKeys("-1");
        
       
        // Nhập số buổi học tối đa trong học kỳ
        WebElement maxLesson = driver.findElement(maxLessonInput);
        maxLesson.clear();
        Thread.sleep(3000);
        maxLesson.sendKeys("-1");

        // Nhập số lớp học tối đa trong học kỳ
        WebElement maxClass = driver.findElement(maxClassInput);
        maxClass.clear();
        Thread.sleep(3000);
        maxClass.sendKeys("-1");
        
	    driver.findElement(By.xpath("//*[@id=\"term-form\"]/div[5]/input[2]")).click();
	    // Thực hiện click vào một phần tử trên trang web để chọn thời gian
	    driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/span[12]")).click();
      
		
    }
    public void themHocKy5(String HK) throws InterruptedException, IOException {
    	
    	driver.findElement(clickHocKyPage).click();

        // Click vào nút để thêm học kỳ
        driver.findElement(clickThemHocKyButton).click();
        Thread.sleep(2000);

        // Nhập dữ liệu học kỳ
//        driver.findElement(hocKyInput).sendKeys(HK);
//        Thread.sleep(2000);

        // Chọn năm bắt đầu và kết thúc học kỳ
        Select startYearSelect = new Select(driver.findElement(startYearDropdown));
        startYearSelect.selectByValue("2025");

        Select endYearSelect = new Select(driver.findElement(endYearDropdown));
        endYearSelect.selectByValue("2026");
        Thread.sleep(2000);
        // Nhập số tuần bắt đầu học kỳ
        WebElement startWeek = driver.findElement(startWeekInput);
        startWeek.clear();
        Thread.sleep(3000);
        
       
        // Nhập số buổi học tối đa trong học kỳ
        WebElement maxLesson = driver.findElement(maxLessonInput);
        maxLesson.clear();
        Thread.sleep(3000);

        // Nhập số lớp học tối đa trong học kỳ
        WebElement maxClass = driver.findElement(maxClassInput);
        maxClass.clear();
        Thread.sleep(3000);
        
        // Click để lưu thông tin vừa nhập
        WebElement clickElement = driver.findElement(luuButton);
        clickElement.click();
		try {
			clickElement.click();
			System.out.println("Click Lưu không thành công");
		}

		catch (WebDriverException e) {
			System.out.println("Kết quả thực tế: Lưu thành công");
		}
      
		
    }
    public void themHocKy6(String HK) throws InterruptedException, IOException {
    	
    	driver.findElement(clickHocKyPage).click();
    	
        // Click vào nút để thêm học kỳ
        driver.findElement(clickThemHocKyButton).click();
        Thread.sleep(2000);

        // Nhập dữ liệu học kỳ
        driver.findElement(hocKyInput).sendKeys(HK);
        Thread.sleep(2000);

        // Chọn năm bắt đầu và kết thúc học kỳ
        Select startYearSelect = new Select(driver.findElement(startYearDropdown));
        startYearSelect.selectByValue("2025");

        Select endYearSelect = new Select(driver.findElement(endYearDropdown));
        endYearSelect.selectByValue("2026");
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
        Thread.sleep(2000);

        // Click để lưu thông tin vừa nhập
        WebElement clickElement = driver.findElement(huyButtonBy);
        clickElement.click();
		try {
			clickElement.click();
			System.out.println("Click Hủy 1 lần không thành công");
		}

		catch (WebDriverException e) {
			System.out.println("Click Hủy 1 lần thành công");
		}
		
    }
  public void themHocKy7(String HK) throws InterruptedException, IOException {
    	
    	driver.findElement(clickHocKyPage).click();

        // Click vào nút để thêm học kỳ
        driver.findElement(clickThemHocKyButton).click();
        Thread.sleep(2000);

        // Nhập dữ liệu học kỳ
        driver.findElement(hocKyInput).sendKeys(HK);
        Thread.sleep(2000);

        // Chọn năm bắt đầu và kết thúc học kỳ
        Select startYearSelect = new Select(driver.findElement(startYearDropdown));
        startYearSelect.selectByValue("2025");

        Select endYearSelect = new Select(driver.findElement(endYearDropdown));
        endYearSelect.selectByValue("2026");
        Thread.sleep(2000);
        // Nhập số tuần bắt đầu học kỳ
        WebElement startWeek = driver.findElement(startWeekInput);
        startWeek.clear();
        Thread.sleep(3000);
        
        // Nhập số buổi học tối đa trong học kỳ
        WebElement maxLesson = driver.findElement(maxLessonInput);
        maxLesson.clear();
        Thread.sleep(3000);


        // Nhập số lớp học tối đa trong học kỳ
        WebElement maxClass = driver.findElement(maxClassInput);
        maxClass.clear();
        Thread.sleep(3000);


        WebElement clickElement = driver.findElement(huyButtonBy);
        clickElement.click();
		try {
			clickElement.click();
			System.out.println("Click Hủy 1 lần không thành công");
		}

		catch (WebDriverException e) {
			System.out.println("Click Hủy 1 lần thành công");
		}
		
    }
  public void themHocKy8(String HK) throws InterruptedException, IOException {
  	
  	driver.findElement(clickHocKyPage).click();

      // Click vào nút để thêm học kỳ
      driver.findElement(clickThemHocKyButton).click();
      Thread.sleep(2000);

      // Nhập dữ liệu học kỳ
      driver.findElement(hocKyInput).sendKeys(HK);
      Thread.sleep(2000);

      // Chọn năm bắt đầu và kết thúc học kỳ
      Select startYearSelect = new Select(driver.findElement(startYearDropdown));
      startYearSelect.selectByValue("2025");

      Select endYearSelect = new Select(driver.findElement(endYearDropdown));
      endYearSelect.selectByValue("2026");
      Thread.sleep(2000);
      // Nhập số tuần bắt đầu học kỳ
      WebElement startWeek = driver.findElement(startWeekInput);
      startWeek.clear();
      Thread.sleep(3000);
      startWeek.sendKeys("++");
      
     
      // Nhập số buổi học tối đa trong học kỳ
      WebElement maxLesson = driver.findElement(maxLessonInput);
      maxLesson.clear();
      Thread.sleep(3000);
      maxLesson.sendKeys("++");

      // Nhập số lớp học tối đa trong học kỳ
      WebElement maxClass = driver.findElement(maxClassInput);
      maxClass.clear();
      Thread.sleep(3000);
      maxClass.sendKeys("++");
      
	    driver.findElement(By.xpath("//*[@id=\"term-form\"]/div[5]/input[2]")).click();
	    // Thực hiện click vào một phần tử trên trang web để chọn thời gian
	    driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/span[12]")).click();

        WebElement clickElement = driver.findElement(huyButtonBy);
        clickElement.click();
		try {
			clickElement.click();
			System.out.println("Click Hủy 1 lần không thành công");
		}

		catch (WebDriverException e) {
			System.out.println("Click Hủy 1 lần thành công");
		}
		
  }
  public void themHocKy9(String HK) throws InterruptedException, IOException {
  	
  	driver.findElement(clickHocKyPage).click();

      // Click vào nút để thêm học kỳ
      driver.findElement(clickThemHocKyButton).click();
      Thread.sleep(2000);

      // Nhập dữ liệu học kỳ
      driver.findElement(hocKyInput).sendKeys(HK);
      Thread.sleep(2000);

      // Chọn năm bắt đầu và kết thúc học kỳ
      Select startYearSelect = new Select(driver.findElement(startYearDropdown));
      startYearSelect.selectByValue("2025");

      Select endYearSelect = new Select(driver.findElement(endYearDropdown));
      endYearSelect.selectByValue("2026");
      Thread.sleep(2000);
      // Nhập số tuần bắt đầu học kỳ
      WebElement startWeek = driver.findElement(startWeekInput);
      startWeek.clear();
      Thread.sleep(3000);
      startWeek.sendKeys("-1");
      
     
      // Nhập số buổi học tối đa trong học kỳ
      WebElement maxLesson = driver.findElement(maxLessonInput);
      maxLesson.clear();
      Thread.sleep(3000);
      maxLesson.sendKeys("-1");

      // Nhập số lớp học tối đa trong học kỳ
      WebElement maxClass = driver.findElement(maxClassInput);
      maxClass.clear();
      Thread.sleep(3000);
      maxClass.sendKeys("-1");
      
	    driver.findElement(By.xpath("//*[@id=\"term-form\"]/div[5]/input[2]")).click();
	    // Thực hiện click vào một phần tử trên trang web để chọn thời gian
	    driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/span[12]")).click();
        WebElement clickElement = driver.findElement(huyButtonBy);
        clickElement.click();
		try {
			clickElement.click();
			System.out.println("Click Hủy 1 lần không thành công");
		}

		catch (WebDriverException e) {
			System.out.println("Click Hủy 1 lần thành công");
		}
    
		
  }
  public void themHocKy10(String HK) throws InterruptedException, IOException {
  	
  	driver.findElement(clickHocKyPage).click();

      // Click vào nút để thêm học kỳ
      driver.findElement(clickThemHocKyButton).click();
      Thread.sleep(2000);

      // Nhập dữ liệu học kỳ
//      driver.findElement(hocKyInput).sendKeys(HK);
//      Thread.sleep(2000);

      // Chọn năm bắt đầu và kết thúc học kỳ
      Select startYearSelect = new Select(driver.findElement(startYearDropdown));
      startYearSelect.selectByValue("2025");

      Select endYearSelect = new Select(driver.findElement(endYearDropdown));
      endYearSelect.selectByValue("2026");
      Thread.sleep(2000);
      // Nhập số tuần bắt đầu học kỳ
      WebElement startWeek = driver.findElement(startWeekInput);
      startWeek.clear();
      Thread.sleep(3000);
      
     
      // Nhập số buổi học tối đa trong học kỳ
      WebElement maxLesson = driver.findElement(maxLessonInput);
      maxLesson.clear();
      Thread.sleep(3000);

      // Nhập số lớp học tối đa trong học kỳ
      WebElement maxClass = driver.findElement(maxClassInput);
      maxClass.clear();
      Thread.sleep(3000);
      
      // Click để lưu thông tin vừa nhập
      WebElement clickElement = driver.findElement(huyButtonBy);
      clickElement.click();
		try {
			clickElement.click();
			System.out.println("Click Hủy 1 lần không thành công");
		}

		catch (WebDriverException e) {
			System.out.println("Click Hủy 1 lần thành công");
		}
    
		
  }
    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
    
    public String getErrorMessage1() {
        return driver.findElement(errorMessage1).getText();
    }
    public String getErrorMessage2() {
        return driver.findElement(errorMessage2).getText();
    }
    public String getErrorMessage3() {
        return driver.findElement(errorMessage3).getText();
    }
    public String getErrorMessage4() {
        return driver.findElement(errorMessage4).getText();
    }
    
}
