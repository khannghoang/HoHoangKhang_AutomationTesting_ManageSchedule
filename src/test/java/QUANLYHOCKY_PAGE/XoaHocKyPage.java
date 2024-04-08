package QUANLYHOCKY_PAGE;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XoaHocKyPage {
private WebDriver driver;
private By menuClick = By.xpath("//*[@id=\"main-menu-navigation\"]/li[2]/a");
private By input = By.xpath("//*[@id=\"tblTerm_filter\"]/label/input");
private By clickDelete = By.xpath("//*[@id=\"tblTerm\"]/tbody/tr[1]/td[9]/a[2]");
private By clickSecondDelete = By.xpath("/html/body/div[3]/div/div[6]/button[1]");
private By clickCloseDeleteButton=By.xpath("/html/body/div[3]/div/div[6]/button[3]");
    public XoaHocKyPage(WebDriver driver) {
        this.driver = driver;
    }

	public void Menu() {
		driver.findElement(menuClick).click();
	}
	public void InputTerm(String HK) {
		driver.findElement(input).sendKeys(HK);
	}
	public void Delte() throws InterruptedException {
	    driver.findElement(clickDelete).click();
	    Thread.sleep(5000); // Thay đổi thời gian chờ thành 5 giây
	    WebElement clickElement = driver.findElement(clickSecondDelete);
	    if (clickElement.isEnabled()) {
	        clickElement.click();
	        System.out.println("Click Xóa thành công ");
	    } else {
	        System.out.println("Click Xóa không thành công ");
	    }		
	}
	public void CloseDeleteButton() throws InterruptedException {
		driver.findElement(clickDelete).click();
		Thread.sleep(3000);
		WebElement clickElement = driver.findElement(clickCloseDeleteButton);
	    if (clickElement.isEnabled()) {
	        clickElement.click();
	        Thread.sleep(2000);
	        System.out.println("Click Hủy xóa thành công ");
	    } else {
	        System.out.println("Click Hủy xóa không thành công ");
	    }

	}
	

}
