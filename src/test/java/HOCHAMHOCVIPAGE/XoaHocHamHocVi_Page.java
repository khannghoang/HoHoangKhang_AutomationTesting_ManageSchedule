package HOCHAMHOCVIPAGE;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class XoaHocHamHocVi_Page {
	 private WebDriver driver;
	 private By MenuClick = By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/a");
	 private By MenuClickHHHV = By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[1]/a");

	 public XoaHocHamHocVi_Page(WebDriver driver) {
		 this.driver = driver;
	 }
	 public void Menu() {
		 driver.findElement(MenuClick).click();
	 }
	 public void HHHVMenu() {
		 driver.findElement(MenuClickHHHV).click();
	 }
}
