package HOCHAMHOCVIPAGE;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SuaHocHamHocVi_Page {
	 private WebDriver driver;
	 private By MenuClick = By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/a");
	 private By MenuClickHHHV = By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[1]/a");
	 private By SaveButton = By.xpath("//*[@id=\"academicdegree-form\"]/div[4]/button[2]");
	 private By CloseButton = By.xpath("//*[@id=\"btnClose\"]");
	 public SuaHocHamHocVi_Page(WebDriver driver) {
		 this.driver = driver;
	 }
	 public void Menu() {
		 driver.findElement(MenuClick).click();
	 }
	 public void HHHVMenu() {
		 driver.findElement(MenuClickHHHV).click();
	 }
	 public void ClickSaveButton() {
			WebElement clickElement =driver.findElement(SaveButton);
			clickElement.click();
			if (clickElement.isEnabled()) {
			    System.out.println("Click lưu thành công ");
			} else {
			    System.out.println("Click lưu không thành công");
			}
		}
	 public void ClickCloseButton() throws InterruptedException {
		WebElement clickElement = driver.findElement(CloseButton);
	    if (clickElement.isEnabled()) {
	        clickElement.click();
	        Thread.sleep(2000);
	        System.out.println("Click Hủy thành công");
	    } else {
	        System.out.println("Click Hủy không thành công");
	    }
		System.out.println("=======");
	 }
}
