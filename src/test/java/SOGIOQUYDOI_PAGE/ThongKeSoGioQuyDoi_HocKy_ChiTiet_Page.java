package SOGIOQUYDOI_PAGE;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class ThongKeSoGioQuyDoi_HocKy_ChiTiet_Page {
  private WebDriver driver;
	private By termDropdown = By.xpath("//*[@id=\"termDiv\"]/div/span/span[1]");
	private By termSearchInput = By.xpath("//*[@id=\"termDiv\"]/div/span[2]/span/span[1]/input");
	private By detailsTab = By.xpath("//*[@id=\"details-tab\"]");
	private By majorDropdown = By.xpath("//*[@id=\"select2-major-container\"]");
	private By majorSearchInput = By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input");


	public ThongKeSoGioQuyDoi_HocKy_ChiTiet_Page(WebDriver driver) {
		this.driver = driver;
	}

	public void navigateToPage() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[5]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[5]/ul/li[2]/a")).click();
		Thread.sleep(2000);
	}

	public void selectTerm(String term) throws InterruptedException {
		driver.findElement(termDropdown).click();
		driver.findElement(termSearchInput).sendKeys(term);
		driver.findElement(termSearchInput).sendKeys(Keys.ENTER);

		Thread.sleep(2000);
	}

	public void selectMajor(String major) throws InterruptedException {
		driver.findElement(majorDropdown).click();
		driver.findElement(majorSearchInput).sendKeys(major);
		driver.findElement(majorSearchInput).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	}
    public void switchToDetailsTab() {
        driver.findElement(detailsTab).click();
    }
}
