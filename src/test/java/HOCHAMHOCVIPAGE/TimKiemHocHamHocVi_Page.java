package HOCHAMHOCVIPAGE;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TimKiemHocHamHocVi_Page {
	 private WebDriver driver;
	 private By MenuClick = By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/a");
	 private By MenuClickHHHV = By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[1]/a");
	 private By ChooseData = By.xpath("//*[@id=\"tblAcademicDegree_length\"]/label/select");

	 public TimKiemHocHamHocVi_Page(WebDriver driver) {
		 this.driver = driver;
	 }
	 public void Menu() {
		 driver.findElement(MenuClick).click();
	 }
	 public void HHHVMenu() {
		 driver.findElement(MenuClickHHHV).click();
	 }
	 public void Data(String DATA) {
			WebElement dropdown = driver.findElement(ChooseData);
			Select select = new Select(dropdown);
			select.selectByValue(DATA);
		}
}
