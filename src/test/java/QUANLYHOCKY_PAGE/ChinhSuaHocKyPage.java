package QUANLYHOCKY_PAGE;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class ChinhSuaHocKyPage {
    private WebDriver driver;

    // Xpaths của các phần tử trên trang
    private By startYearDropdown = By.id("start_year");
    private By endYearDropdown = By.id("end_year");
    private By startWeekInput = By.xpath("//*[@id=\"start_week\"]");
    private By maxLessonInput = By.xpath("//*[@id=\"max_lesson\"]");
    private By maxClassInput = By.xpath("//*[@id=\"max_class\"]");
    private By luuButton = By.xpath("//*[@id=\"term-form\"]/div[7]/button[2]");

    public ChinhSuaHocKyPage(WebDriver driver) {
        this.driver = driver;
    }
    public void ChooseStartyear() {
        WebElement dropdown = driver.findElement(startYearDropdown);
        Select select = new Select(dropdown);
        select.selectByValue("2025");
    }
    public void ChooseEndYear() {
        WebElement dropdown2 = driver.findElement(endYearDropdown);
        Select select2 = new Select(dropdown2);
        select2.selectByValue("2026");
    }
    public void Schedule() throws InterruptedException {
	    driver.findElement(By.xpath("//*[@id=\"term-form\"]/div[5]/input[2]")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/span[12]")).click();
    	
    }
    
    public void DeleteandInputWeek() throws InterruptedException {
        WebElement deleteoldweek = driver.findElement(startWeekInput);
        deleteoldweek.clear();
        Thread.sleep(3000);
        Random random = new Random();
	    int randomNumber = random.nextInt(52) + 1;
	    String randomString = Integer.toString(randomNumber);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].value = '" + randomString + "';", deleteoldweek);
	    Thread.sleep(2000);
    }
    public void DeleteandInputWeekWithSpeacialCharacter() throws InterruptedException {
        WebElement deleteoldweek = driver.findElement(startWeekInput);
        deleteoldweek.clear();
        Thread.sleep(3000);
        deleteoldweek.sendKeys("++");
    }
    public void DeleteoldWeek() throws InterruptedException {
        // Tạo một số ngẫu nhiên từ 1 đến 52 và nhập vào ô nhập liệu
        WebElement deleteoldweek = driver.findElement(startWeekInput);
        deleteoldweek.clear();
        Thread.sleep(3000);
    }
    public void DeleteandInputLesson() throws InterruptedException {
    	WebElement deleteoldlesson = driver.findElement(maxLessonInput);
        deleteoldlesson.clear();
        Thread.sleep(3000);

        Random random2 = new Random();
	    int randomNumber2 = random2.nextInt(3,15) + 1;
	    String randomString2 = Integer.toString(randomNumber2);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].value = '" + randomString2 + "';", deleteoldlesson);
	    Thread.sleep(2000);
    }
    public void DeleteandInputLessonWithSpeacialCharacter() throws InterruptedException {
    	WebElement deleteoldlesson = driver.findElement(maxLessonInput);
        deleteoldlesson.clear();
        Thread.sleep(3000);
        deleteoldlesson.sendKeys("++");
    }
    public void DeleteoldLesson() throws InterruptedException {
        // Tạo một số ngẫu nhiên từ 1 đến 52 và nhập vào ô nhập liệu
    	WebElement deleteoldlesson = driver.findElement(maxLessonInput);
        deleteoldlesson.clear();
        Thread.sleep(3000);
    }
    public void DeleteandInputClass() throws InterruptedException {
	    WebElement deleteoldclass = driver.findElement(maxClassInput);
	    deleteoldclass.clear();
        Thread.sleep(3000);

        // Tạo một số ngẫu nhiên từ 1 đến 52 và nhập vào ô nhập liệu
        Random random3 = new Random();
	    int randomNumber3 = random3.nextInt(30) + 1;
	    String randomString3 = Integer.toString(randomNumber3);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].value = '" + randomString3 + "';", deleteoldclass);
	    Thread.sleep(2000);
    }
    public void DeleteandInputClassWithSpeacialCharacter() throws InterruptedException {
	    WebElement deleteoldclass = driver.findElement(maxClassInput);
	    deleteoldclass.clear();
        Thread.sleep(3000);
        deleteoldclass.sendKeys("++");
        
    }
    public void DeleteoldClass() throws InterruptedException {
    	WebElement deleteoldclass = driver.findElement(maxClassInput);
	    deleteoldclass.clear();
        Thread.sleep(3000);
    }
    public void SaveButton() throws InterruptedException {
	    WebElement clickElement = driver.findElement(luuButton);
		clickElement.click();
		Thread.sleep(2000);
		try {
			clickElement.click();
			System.out.println("Cập nhật không thành công");
		}

		catch (WebDriverException e) {
			System.out.println("Kết quả thực tế: Cập nhật thành công");
		}
    }
    
    
}
