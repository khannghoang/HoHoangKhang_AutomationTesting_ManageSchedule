package QUANLYTHOIKHOABIEU_PAGE;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class XemThoiKhoaBieuPage {
    private WebDriver driver;

    private By hocKyDropdown = By.xpath("//*[@id=\"select2-term-container\"]");
    private By tenGiangVienDropdown = By.xpath("//*[@id=\"select2-lecturer-container\"]");
    private By weekDropdown = By.xpath("//*[@id=\"week\"]/option");
    private By timetableTable = By.xpath("//*[@id=\"personalTimetableDiv\"]/div[3]/table/tbody");

    public XemThoiKhoaBieuPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickHocKyDropdown() {
        driver.findElement(hocKyDropdown).click();
    }

    public void inputHocKy(String hocKy) {
        WebElement input = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input"));
        input.sendKeys(hocKy);
        input.sendKeys(Keys.ENTER);
    }

    public void clickTenGiangVienDropdown() {
        driver.findElement(tenGiangVienDropdown).click();
    }

    public void inputTenGiangVien(String tenGiangVien) {
        WebElement input = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span[2]/span/span[1]/input"));
        input.sendKeys(tenGiangVien);
        input.sendKeys(Keys.ENTER);
    }

    public int getNumberOfWeeks() {
        return driver.findElements(weekDropdown).size();
    }

    public String getTimetableData() {
        WebElement timetableElement = driver.findElement(timetableTable);
        return timetableElement.getText();
    }

    public void selectWeek(int weekIndex) {
        String xpathButton = "//*[@id=\"week\"]/option[" + weekIndex + "]";
        WebElement itemElement = driver.findElement(By.xpath(xpathButton));
        itemElement.click();
    }
}
