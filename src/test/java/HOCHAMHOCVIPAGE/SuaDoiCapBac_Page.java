package HOCHAMHOCVIPAGE;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SuaDoiCapBac_Page {
	 private WebDriver driver;
	 private By MenuClick = By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/a");
	 private By MenuClickHHHV = By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[1]/a");
	 private By CapBacClick = By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/ul/li[2]/a");
	 private By findingName = By.xpath("//*[@id=\"tblAcademicDegreeRank_filter\"]/label/input");
	 private By changingButton = By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr[2]/td[2]/a[1]");
	 private By CancelButton = By.xpath("//*[@id=\"btnClose\"]");
	 private By SaveButton = By.xpath("//*[@id=\"academicdegreerank-form\"]/div[3]/button[2]");
	 public SuaDoiCapBac_Page(WebDriver driver) {
		 this.driver = driver;
	 }
	 public void Menu() {
		 driver.findElement(MenuClick).click();
	 }
	 public void HHHVMenu() {
		 driver.findElement(MenuClickHHHV).click();
	 }
	 public void CapBac() {
		 driver.findElement(CapBacClick).click();
	 }
	 public void InputName(String NAME) {
		 driver.findElement(findingName).sendKeys(NAME);
	 }
	 public void ClickButton() {
		 driver.findElement(changingButton).click();
	 }
	 public void ClickCloseButton() throws InterruptedException, IOException {
		    WebElement clickElement = driver.findElement(CancelButton);
		    if (clickElement.isEnabled()) {
		        clickElement.click();
		        Thread.sleep(2000);
		        System.out.println("Click Hủy thành công");
		    } else {
		        System.out.println("Click Hủy không thành công ");
		    }
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
}
