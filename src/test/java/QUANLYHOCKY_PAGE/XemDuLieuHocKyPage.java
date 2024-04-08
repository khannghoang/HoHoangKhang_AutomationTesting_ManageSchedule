package QUANLYHOCKY_PAGE;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class XemDuLieuHocKyPage {
    private WebDriver driver;

	private By clickHocKyPage = By.xpath("//*[@id=\"main-menu-navigation\"]/li[2]/a");
	private By clickData = By.xpath("//*[@id=\"tblTerm_length\"]/label/select");
	private By tableData = By.xpath("//*[@id=\"tblTerm\"]/tbody");
	
    public XemDuLieuHocKyPage(WebDriver driver) {
        this.driver = driver;
    }
    public void openTerm() {
    	driver.findElement(clickHocKyPage).click();
    }
    public void clickDate25() {
    	WebElement dropdown = driver.findElement(clickData);
		Select select = new Select(dropdown);
		select.selectByValue("25");
    }
    public void clickDate50() {
    	WebElement dropdown = driver.findElement(clickData);
		Select select = new Select(dropdown);
		select.selectByValue("50");
    }
    public void clickDateAll() {
    	WebElement dropdown = driver.findElement(clickData);
		Select select = new Select(dropdown);
		select.selectByValue("-1");
    }
    public void printData() {
		WebElement prinElement=driver.findElement(tableData);
		String dataString=prinElement.getText();
		System.out.println(dataString);
    }
}
