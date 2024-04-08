package IntergrationsTest_MonHoc_HocKyNganh_PAGE;

import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MHVHKNP {
	private WebDriver driver;
	private By clickHocKyPage = By.xpath("//*[@id=\"main-menu-navigation\"]/li[2]/a");
    private By clickThemHocKyButton = By.xpath("//*[@id=\"tblTerm_wrapper\"]/div[1]/div[2]/div/div[2]/button");
    private By hocKyInput = By.xpath("//*[@id=\"id\"]");
    private By startYearDropdown = By.id("start_year");
    private By endYearDropdown = By.id("end_year");
    private By startWeekInput = By.xpath("//*[@id=\"start_week\"]");
    private By maxLessonInput = By.xpath("//*[@id=\"max_lesson\"]");
    private By maxClassInput = By.xpath("//*[@id=\"max_class\"]");
    private By luuButton = By.xpath("//*[@id=\"term-form\"]/div[7]/button[2]");
    private By closebutton = By.xpath("//*[@id=\"btnClose\"]");
    private By clickDelete = By.xpath("//*[@id=\"tblTerm\"]/tbody/tr/td[9]/a[2]");
    private By closeDelete = By.xpath("/html/body/div[3]/div/div[6]/button[3]");
    private By secondDelete = By.xpath("/html/body/div[3]/div/div[6]/button[1]");
    private By clickMenuThuLao = By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/a");
    private By clickMonHoc = By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[3]/a");
    private By clickNganh = By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/ul/li[2]/a");
    private By clickThemNganhButton = By.xpath("//*[@id=\"tblMajor_wrapper\"]/div[1]/div[2]/div/div[2]/button");
    private By maNganh = By.xpath("//*[@id=\"id\"]");
    private By tenNganh=By.xpath("//*[@id=\"name\"]");
    private By tenVietTat = By.xpath("//*[@id=\"abbreviation\"]");
    private By luuNganhButton = By.xpath("//*[@id=\"major-form\"]/div[5]/button[2]");
    private By closeNganh = By.xpath("//*[@id=\"btnClose\"]");
    private By closeDeleteNganh = By.xpath("/html/body/div[3]/div/div[6]/button[3]");
    private By deleteNganh = By.xpath("//*[@id=\"tblMajor\"]/tbody/tr[1]/td[6]/a[2]");
    private By secondDelelteNganh = By.xpath("/html/body/div[3]/div/div[6]/button[1]");
    private By CTDT = By.xpath("//*[@id=\"program_type\"]");
	public MHVHKNP(WebDriver driver) {
        this.driver = driver;
    }
	
	public void OpenHK() throws InterruptedException {
    	driver.findElement(clickHocKyPage).click();

        // Click vào nút để thêm học kỳ
	}
	public void AddHKButton() throws InterruptedException {
        driver.findElement(clickThemHocKyButton).click();
        Thread.sleep(2000);
	}
	 public void themHocKy(String HK) throws InterruptedException, IOException {
	    	
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
	    }
		public void SaveHKButton() throws InterruptedException, IOException{
			WebElement clickElement =driver.findElement(luuButton);
			clickElement.click();
			if (clickElement.isEnabled()) {
			    System.out.println("Click lưu và tạo thành công tại mục Học Kỳ");
			} else {
			    System.out.println("Click lưu và tạo không thành công tại mục Học Kỳ");
			}
		}
		public void CloseHKButton() throws InterruptedException, IOException{
			WebElement clickElement =driver.findElement(closebutton);
			if (clickElement.isEnabled()) {
				clickElement.click();
			    System.out.println("Click Hủy thành công tại mục Học Kỳ");
			} else {
			    System.out.println("Click Hủy không thành công tại mục Học Kỳ");
			}
		}
		public void CloseHKDelete() throws InterruptedException, IOException{
			driver.findElement(clickDelete).click();
			Thread.sleep(3000);
			WebElement clickElement =driver.findElement(closeDelete);
		    if (clickElement.isEnabled()) {
		        clickElement.click();
		        Thread.sleep(2000);
		        System.out.println("Click Hủy xóa thành công tại mục Học Kỳ");
		    } else {
		        System.out.println("Click Hủy xóa không thành công tại mục Học Kỳ ");
		    }
		}
		public void TabNganh() {
			driver.findElement(clickNganh).click();
		}
		public void AddNganhButton() {
			driver.findElement(clickThemNganhButton).click();
		}
		public void InputDataNganh(String ID, String NAME, String VIETTAT) {
			driver.findElement(maNganh).sendKeys(ID);
			driver.findElement(tenNganh).sendKeys(NAME);
			driver.findElement(tenVietTat).sendKeys(VIETTAT);
			Select CTĐT = new Select(driver.findElement(CTDT));
	        CTĐT.selectByValue("0");
		}
		public void SaveNganhButton() throws InterruptedException, IOException{
			WebElement clickElement =driver.findElement(luuNganhButton);
			clickElement.click();
			if (clickElement.isEnabled()) {
			    System.out.println("Click lưu và tạo thành công tại mục Học Kỳ");
			} else {
			    System.out.println("Click lưu và tạo không thành công tại mục Học Kỳ");
			}
		}
		public void CloseNganhButton() throws InterruptedException, IOException{
			WebElement clickElement =driver.findElement(closeNganh);
			if (clickElement.isEnabled()) {
				clickElement.click();
			    System.out.println("Click Hủy thành công tại mục Học Kỳ");
			} else {
			    System.out.println("Click Hủy không thành công tại mục Học Kỳ");
			}
		}
		public void DeleteHK() throws InterruptedException {
		    driver.findElement(clickDelete).click();
		    Thread.sleep(5000); // Thay đổi thời gian chờ thành 5 giây
		    WebElement clickElement = driver.findElement(secondDelete);
		    if (clickElement.isEnabled()) {
		        clickElement.click();
		        System.out.println("Click Xóa thành công tại mục Học Kỳ");
		    } else {
		        System.out.println("Click Xóa không thành công tại mục Học Kỳ");
		    }
		}
		public void CloseNganhDelete() throws InterruptedException, IOException{
			driver.findElement(deleteNganh).click();
			Thread.sleep(3000);
			WebElement clickElement =driver.findElement(closeDeleteNganh);
		    if (clickElement.isEnabled()) {
		        clickElement.click();
		        Thread.sleep(2000);
		        System.out.println("Click Hủy xóa thành công tại mục Ngành");
		    } else {
		        System.out.println("Click Hủy xóa không thành công tại mục Ngành");
		    }
		}
		public void DeleteNganh() throws InterruptedException {
		    driver.findElement(deleteNganh).click();
		    Thread.sleep(5000); // Thay đổi thời gian chờ thành 5 giây
		    WebElement clickElement = driver.findElement(secondDelelteNganh);
		    if (clickElement.isEnabled()) {
		        clickElement.click();
		        System.out.println("Click Xóa thành công tại mục Ngành");
		    } else {
		        System.out.println("Click Xóa không thành công tại mục Ngành");
		    }
		}
		public void MenuNavigation() {
			driver.findElement(clickMenuThuLao).click();
		}
		public void MonHoc() {
			driver.findElement(clickMonHoc).click();
		}
}
