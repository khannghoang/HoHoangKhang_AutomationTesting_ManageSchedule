package SOGIOQUYDOI_PAGE;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class TimKiemGiangVien_NamHoc_BangBieu_XemTheoCaGiang_Page {
	private WebDriver driver;
	   private By yearChoose = By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[1]/span[1]");
	    private By SearchInput = By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input");
	    private By yearSearchClick = By.xpath("//*[@id=\"yearDiv\"]/div/span[1]");
	    private By yearSearchInput = By.xpath("//*[@id=\"yearDiv\"]/div/span[2]/span/span[1]/input");
	    private By tableTab = By.xpath("//*[@id=\"table-tab\"]");
	    private By majorDropdown = By.xpath("//*[@id=\"select2-major-container\"]");
		private By majorSearchInput = By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input");	
	    private By lessonTypeCheckbox = By.xpath("//*[@id=\"isLesson\"]");

		public  TimKiemGiangVien_NamHoc_BangBieu_XemTheoCaGiang_Page(WebDriver driver) {
			this.driver = driver;
		}
		   public void navigateToPage() throws InterruptedException {
		        driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[5]/a")).click();
		        Thread.sleep(2000);
		        driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[5]/ul/li[2]/a")).click();
		        Thread.sleep(2000);
		    }
		    public void SearchInput(String NH) {
		    	driver.findElement(yearChoose).click();
		    	driver.findElement(SearchInput).sendKeys(NH);
		    	driver.findElement(SearchInput).sendKeys(Keys.ENTER);
		    }
		    public void ChooseYear(String year) {
		    	driver.findElement(yearSearchClick).click();
		    	driver.findElement(yearSearchInput).sendKeys(year);
		    	driver.findElement(yearSearchInput).sendKeys(Keys.ENTER);

		    }
		    public void selectMajor(String major) throws InterruptedException {
		        driver.findElement(majorDropdown).click();
		        driver.findElement(majorSearchInput).sendKeys(major);
		        driver.findElement(majorSearchInput).sendKeys(Keys.ENTER);
		        Thread.sleep(2000);

		    }
		    public void selectLessonType() throws InterruptedException {
		        driver.findElement(lessonTypeCheckbox).click();
		        Thread.sleep(2000);
			}
		    public void switchToTableTab() {
		        driver.findElement(tableTab).click();
		    }
}
