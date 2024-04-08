package HOCHAMHOCVIPAGE;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HienThiDuLieu_HocHamHocVi_Page {
	 private WebDriver driver;
	 private By MenuClick = By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/a");
	 private By MenuClickHHHV = By.xpath("//*[@id=\"main-menu-navigation\"]/li[6]/ul/li[1]/a");
	 private By DropdownChoose =By.xpath("//*[@id=\"tblAcademicDegree_length\"]/label/select");
	 private By ChooseBody = By.xpath("//*[@id=\"tblAcademicDegree\"]/tbody");
	 public HienThiDuLieu_HocHamHocVi_Page(WebDriver driver) {
		 this.driver = driver;
	 }
	 public void Menu() {
		 driver.findElement(MenuClick).click();
	 }
	 public void HHHVMenu() {
		 driver.findElement(MenuClickHHHV).click();
	 }
	 public void SelectData(String NUM) throws InterruptedException {
			WebElement dropdown = driver.findElement(DropdownChoose);
			Select select = new Select(dropdown);
			select.selectByValue(NUM);
			Thread.sleep(2000);
	 }
	 public void PrintData() {
		WebElement prinElement=driver.findElement(ChooseBody);
		String dataString=prinElement.getText();
		System.out.println(dataString);
	 }
}
