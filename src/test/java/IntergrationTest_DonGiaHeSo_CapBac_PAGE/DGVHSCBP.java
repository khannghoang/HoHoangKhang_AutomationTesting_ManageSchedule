package IntergrationTest_DonGiaHeSo_CapBac_PAGE;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DGVHSCBP {
	static WebDriver driver;
    private By clickMenu = By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/a");
    private By clickHHHV = By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[1]");
    private By clickCapBac = By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/ul/li[2]/a");
    private By clickCapBacButton = By.xpath("//*[@id=\"tblAcademicDegreeRank_wrapper\"]/div[1]/div[2]/div/div[2]/button");
    private By clickSelect = By.xpath("//*[@id=\"academic_degree_id\"]");
    private By clickSave = By.xpath("//*[@id=\"academicdegreerank-form\"]/div[3]/button[2]");
    private By clickDGVHS = By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[2]/a");
    private By clickCloseButton = By.xpath("//*[@id=\"btnClose\"]");
    private By clickSpeacialEducationProgram = By.xpath("//*[@id=\"special-tab\"]");
    private By clickForeigner = By.xpath("//*[@id=\"foreign-tab\"]");
    private By clickDelete = By.xpath("//*[@id=\"tblAcademicDegreeRank\"]/tbody/tr[2]/td[2]/a[2]");
	private By clickSecondelete = By.xpath("/html/body/div[3]/div/div[6]/button[1]");
	private By clickCloseDeleteButton = By.xpath("/html/body/div[3]/div/div[6]/button[3]");
	private By clickChangingStandard = By.xpath("//*[@id=\"tblStandard\"]/tbody/tr[1]/td[3]/a[1]");
	private By clickChangingSpeacial = By.xpath("//*[@id=\"tblSpecial\"]/tbody/tr[1]/td[3]/a[1]");
	private By clickChangingForeigner = By.xpath("//*[@id=\"tblForeign\"]/tbody/tr[1]/td[3]/a[1]");
	private By clickSaveButtonChanging = By.xpath("//*[@id=\"unitprice-form\"]/div[3]/button[2]");
	private By clickCloseButtonChaging = By.xpath("//*[@id=\"btnClose\"]");
	private By clickDeleteStandard = By.xpath("//*[@id=\"tblStandard\"]/tbody/tr[1]/td[3]/a[1]");
	private By clickDeleteSpeacial = By.xpath("//*[@id=\"tblSpecial\"]/tbody/tr[1]/td[3]/a[1]");
	private By clickDeleteForeigner = By.xpath("//*[@id=\"tblForeign\"]/tbody/tr[1]/td[3]/a[1]");
	private By clickDeleteSecondButtonĐGHS = By.xpath("/html/body/div[3]/div/div[6]/button[1]");
	private By clickCloseButtonĐGHS = By.xpath("/html/body/div[3]/div/div[6]/button[3]");
	
	
	public DGVHSCBP(WebDriver driver) {
        this.driver = driver;
    }
	public void MenuNavigation() {
		driver.findElement(clickMenu).click();
		
	}
	public void HHHV() {
		driver.findElement(clickHHHV).click();
	}
	public void CapBac() throws InterruptedException {
		driver.findElement(clickCapBac).click();
		Thread.sleep(2000);
	}
	public void AddCapBac() throws InterruptedException, IOException {
		driver.findElement(clickCapBacButton).click();
		Thread.sleep(2000);
		WebElement dropdown = driver.findElement(clickSelect);
		Select select = new Select(dropdown);
		select.selectByValue("TestingKhang11");
		Thread.sleep(2000);
	}

	public void SaveButton() throws InterruptedException, IOException{
		WebElement clickElement =driver.findElement(clickSave);
		clickElement.click();
		if (clickElement.isEnabled()) {
		    System.out.println("Click lưu và tạo thành công tại mục Cấp Bậc");
		} else {
		    System.out.println("Click lưu và tạo thành công tại mục Cấp Bậc");
		}
	}
	public void CloseButton() throws InterruptedException, IOException {
	    WebElement clickElement = driver.findElement(clickCloseButton);
	    if (clickElement.isEnabled()) {
	        clickElement.click();
	        Thread.sleep(2000);
	        System.out.println("Click Hủy thành công tại mục Cấp Bậc");
	    } else {
	        System.out.println("Click Hủy không thành công tại mục Cấp Bậc");
	    }
	}
	public void DGVHS() throws InterruptedException, IOException {
		driver.findElement(clickDGVHS).click();
		Thread.sleep(2000);
		
	}

	public void SpeacialEducationProgram() {
		driver.findElement(clickSpeacialEducationProgram).click();
	}
	public void Foreigner() {
		driver.findElement(clickForeigner).click();
	}
	public void DeleteButton() throws InterruptedException {
	    driver.findElement(clickDelete).click();
	    Thread.sleep(5000); // Thay đổi thời gian chờ thành 5 giây
	    WebElement clickElement = driver.findElement(clickSecondelete);
	    if (clickElement.isEnabled()) {
	        clickElement.click();
	        System.out.println("Click Xóa thành công tại mục Cấp Bậc");
	    } else {
	        System.out.println("Click Xóa không thành công tại mục Cấp Bậc");
	    }
	}
	public void CloseDeleteButton() throws InterruptedException {
		driver.findElement(clickDelete).click();
		Thread.sleep(3000);
		WebElement clickElement =driver.findElement(clickCloseDeleteButton);
	    if (clickElement.isEnabled()) {
	        clickElement.click();
	        Thread.sleep(2000);
	        System.out.println("Click Hủy xóa thành công tại mục Cấp Bậc");
	    } else {
	        System.out.println("Click Hủy xóa không thành công tại mục Cấp Bậc");
	    }

	}
	public void UpdateStandard() {
		driver.findElement(clickChangingStandard).click();
	}
	public void UpdateSpeacial() {
		driver.findElement(clickChangingSpeacial).click();
	}
	public void UpdateForeigner() {
		driver.findElement(clickChangingForeigner).click();
	}
	public void SaveButtonChanging() throws InterruptedException, IOException{
		WebElement clickElement =driver.findElement(clickSaveButtonChanging);
		clickElement.click();
		if (clickElement.isEnabled()) {
		    System.out.println("Click Lưu thành công ");
		} else {
		    System.out.println("Click Lưu không thành công ");
		}
	}
	public void CloseButtonChanging() throws InterruptedException {
	    WebElement clickElement = driver.findElement(clickCloseButtonChaging);
	    if (clickElement.isEnabled()) {
	        clickElement.click();
	        Thread.sleep(5000);
	        System.out.println("Click Hủy thành công");
	    } else {
	        System.out.println("Click Hủy không thành công");
	    }
	}
	public void DeleteStandard() {
		driver.findElement(clickDeleteStandard).click();
	}
	public void DeleteSpeacial() {
		driver.findElement(clickDeleteSpeacial).click();
	}
	public void DeleteForeigner() {
		driver.findElement(clickDeleteForeigner).click();
	}
	public void DeleteButtonDGHSStandard() throws InterruptedException {
	    driver.findElement(clickDeleteStandard).click();
	    Thread.sleep(5000); // Thay đổi thời gian chờ thành 5 giây
	    WebElement clickElement = driver.findElement(clickDeleteSecondButtonĐGHS);
	    if (clickElement.isEnabled()) {
	        clickElement.click();
	        System.out.println("Click Xóa thành công tại mục Cấp Bậc");
	    } else {
	        System.out.println("Click Xóa không thành công tại mục Cấp Bậc");
	    }
	}
	public void CloseDeleteButtonDGHSStandard() throws InterruptedException {
		driver.findElement(clickDeleteStandard).click();
		Thread.sleep(3000);
		WebElement clickElement =driver.findElement(clickCloseDeleteButton);
	    if (clickElement.isEnabled()) {
	        clickElement.click();
	        Thread.sleep(2000);
	        System.out.println("Click Hủy xóa thành công");
	    } else {
	        System.out.println("Click Hủy xóa không thành công ");
	    }
	}
	public void DeleteButtonDGHSSpeacial() throws InterruptedException {
	    driver.findElement(clickDeleteSpeacial).click();
	    Thread.sleep(5000); // Thay đổi thời gian chờ thành 5 giây
	    WebElement clickElement = driver.findElement(clickDeleteSecondButtonĐGHS);
	    if (clickElement.isEnabled()) {
	        clickElement.click();
	        System.out.println("Click Xóa thành công");
	    } else {
	        System.out.println("Click Xóa không thành công");
	    }
	}
	public void CloseDeleteButtonDGHSSpeacial() throws InterruptedException {
		driver.findElement(clickDeleteSpeacial).click();
		Thread.sleep(3000);
		WebElement clickElement =driver.findElement(clickCloseDeleteButton);
	    if (clickElement.isEnabled()) {
	        clickElement.click();
	        Thread.sleep(2000);
	        System.out.println("Click Hủy xóa thành công tại");
	    } else {
	        System.out.println("Click Hủy xóa không thành công");
	    }
	}
	public void DeleteButtonDGHSForeigner() throws InterruptedException {
	    driver.findElement(clickDeleteForeigner).click();
	    Thread.sleep(5000); // Thay đổi thời gian chờ thành 5 giây
	    WebElement clickElement = driver.findElement(clickDeleteSecondButtonĐGHS);
	    if (clickElement.isEnabled()) {
	        clickElement.click();
	        System.out.println("Click Xóa thành công ");
	    } else {
	        System.out.println("Click Xóa không thành công ");
	    }
	}
	public void CloseDeleteButtonDGHSForeigner() throws InterruptedException {
		driver.findElement(clickDeleteForeigner).click();
		Thread.sleep(3000);
		WebElement clickElement =driver.findElement(clickCloseDeleteButton);
	    if (clickElement.isEnabled()) {
	        clickElement.click();
	        Thread.sleep(2000);
	        System.out.println("Click Hủy xóa thành công");
	    } else {
	        System.out.println("Click Hủy xóa không thành công ");
	    }
	}
	
}

