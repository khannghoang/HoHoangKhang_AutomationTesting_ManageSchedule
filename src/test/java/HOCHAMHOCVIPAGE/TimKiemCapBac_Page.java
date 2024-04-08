package HOCHAMHOCVIPAGE;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TimKiemCapBac_Page {
	private WebDriver driver;
	 private By MenuClick = By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/a");
	 private By MenuClickHHHV = By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[1]/a");
	 private By CapBacClick = By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/ul/li[2]/a");
	 private By ChooseData = By.xpath("//*[@id=\"tblAcademicDegreeRank_length\"]/label/select");
public TimKiemCapBac_Page(WebDriver driver) {
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
public void Data(String DATA) {
	WebElement dropdown = driver.findElement(ChooseData);
	Select select = new Select(dropdown);
	select.selectByValue(DATA);
}
}