package QUANLYHOCKI_TEST;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageSetup.Setup;
import QUANLYHOCKY_PAGE.ChinhSuaHocKyPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ChinhSuaHocKyTest {
    static WebDriver driver;

	@BeforeTest
	public void Main() throws IOException, InterruptedException {
		Setup setup = new Setup();
		driver = setup.setup();
		Thread.sleep(3000);
	}

    @Test
    public void Action() throws InterruptedException {
    	System.out.println("Testcase 1: Cập nhật học kỳ với đầy đủ thông tin");
        // Dừng thực thi trong 4 giây
        Thread.sleep(4000);

        // Tìm và nhấp vào phần tử được xác định bằng đường dẫn XPath
        driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[2]/a")).click();

        // Dừng thực thi trong 2 giây
        Thread.sleep(2000);

        // Tìm ô nhập liệu và nhập "423" vào đó
        driver.findElement(By.xpath("//*[@id=\"tblTerm_filter\"]/label/input")).sendKeys("423");

        // Dừng thực thi trong 2 giây
        Thread.sleep(2000);

        // Nhấp vào liên kết được xác định bằng đường dẫn XPath
        driver.findElement(By.xpath("//*[@id=\"tblTerm\"]/tbody/tr/td[9]/a[1]")).click();

        // Dừng thực thi trong 2 giây
        Thread.sleep(2000);

        // Khởi tạo một đối tượng của lớp ChinhSuaHocKyPage và thực thi phương thức chinhSuaHocKy()
        new ChinhSuaHocKyPage(driver).ChooseStartyear();
        new ChinhSuaHocKyPage(driver).ChooseEndYear();
        new ChinhSuaHocKyPage(driver).DeleteandInputWeek();
        new ChinhSuaHocKyPage(driver).Schedule();
        new ChinhSuaHocKyPage(driver).DeleteandInputLesson();
        new ChinhSuaHocKyPage(driver).DeleteandInputClass();
        new ChinhSuaHocKyPage(driver).SaveButton();
        System.out.println("============");
    }
    @Test
    public void Action2() throws InterruptedException {
	    System.out.println("Testcase 2:Cập nhật học kỳ với bỏ trống tuần bắt đầu,tiết tối đa và lớp tối đa");

        // Dừng thực thi trong 4 giây
        Thread.sleep(4000);

        // Tìm và nhấp vào phần tử được xác định bằng đường dẫn XPath
        driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[2]/a")).click();

        // Dừng thực thi trong 2 giây
        Thread.sleep(2000);

        // Tìm ô nhập liệu và nhập "423" vào đó
        driver.findElement(By.xpath("//*[@id=\"tblTerm_filter\"]/label/input")).sendKeys("423");

        // Dừng thực thi trong 2 giây
        Thread.sleep(2000);

        // Nhấp vào liên kết được xác định bằng đường dẫn XPath
        driver.findElement(By.xpath("//*[@id=\"tblTerm\"]/tbody/tr/td[9]/a[1]")).click();

        // Dừng thực thi trong 2 giây
        Thread.sleep(2000);

        new ChinhSuaHocKyPage(driver).ChooseStartyear();
        new ChinhSuaHocKyPage(driver).ChooseEndYear();
        new ChinhSuaHocKyPage(driver).DeleteoldWeek();
        new ChinhSuaHocKyPage(driver).Schedule();
        new ChinhSuaHocKyPage(driver).DeleteoldLesson();
        new ChinhSuaHocKyPage(driver).DeleteoldClass();
        new ChinhSuaHocKyPage(driver).SaveButton();
        System.out.println("============");

    }
    @Test
    public void Action3() throws InterruptedException {
	    System.out.println("Testcase 3:Cập nhật học kỳ với bỏ trống tiết tối đa và lớp tối đa");

        // Dừng thực thi trong 4 giây
        Thread.sleep(4000);

        // Tìm và nhấp vào phần tử được xác định bằng đường dẫn XPath
        driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[2]/a")).click();

        // Dừng thực thi trong 2 giây
        Thread.sleep(2000);

        // Tìm ô nhập liệu và nhập "423" vào đó
        driver.findElement(By.xpath("//*[@id=\"tblTerm_filter\"]/label/input")).sendKeys("423");

        // Dừng thực thi trong 2 giây
        Thread.sleep(2000);

        // Nhấp vào liên kết được xác định bằng đường dẫn XPath
        driver.findElement(By.xpath("//*[@id=\"tblTerm\"]/tbody/tr/td[9]/a[1]")).click();

        // Dừng thực thi trong 2 giây
        Thread.sleep(2000);

        // Khởi tạo một đối tượng của lớp ChinhSuaHocKyPage và thực thi phương thức chinhSuaHocKy()
        new ChinhSuaHocKyPage(driver).ChooseStartyear();
        new ChinhSuaHocKyPage(driver).ChooseEndYear();
        new ChinhSuaHocKyPage(driver).DeleteandInputWeek();
        new ChinhSuaHocKyPage(driver).Schedule();
        new ChinhSuaHocKyPage(driver).DeleteoldLesson();
        new ChinhSuaHocKyPage(driver).DeleteoldClass();
        new ChinhSuaHocKyPage(driver).SaveButton();   
        
		WebElement errorElement2 = driver.findElement(By.xpath("//*[@id=\"max_lesson-error\"]"));
		WebElement errorElement3 = driver.findElement(By.xpath("//*[@id=\"max_class-error\"]"));

		String expected2 = "Bạn chưa nhập số tiết tối đa"; // Chuỗi kỳ vọng thông báo lỗi
		String expected3 = "Bạn chưa nhập số lớp tối đa"; // Chuỗi kỳ vọng thông báo lỗi

		// In ra kết quả mong đợi của thông báo lỗi
		System.out.println("Kết quả mong đợi 1: " + expected2);
		// In ra kết quả thực tế của thông báo lỗi trên giao diện web
		System.out.println("Kết quả thực tế 1: " + errorElement2.getText());
		System.out.println("========");
		// In ra kết quả mong đợi của thông báo lỗi
		System.out.println("Kết quả mong đợi 2: " + expected3);
		// In ra kết quả thực tế của thông báo lỗi trên giao diện web
		System.out.println("Kết quả thực tế 2: " + errorElement3.getText());
        System.out.println("============");    
    }
    @Test
    public void Action4() throws InterruptedException {
	    System.out.println("Testcase 4:Cập nhật học kỳ với bỏ trống tuần bắt đầu và lớp tối đa");

        // Dừng thực thi trong 4 giây
        Thread.sleep(4000);

        // Tìm và nhấp vào phần tử được xác định bằng đường dẫn XPath
        driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[2]/a")).click();

        // Dừng thực thi trong 2 giây
        Thread.sleep(2000);

        // Tìm ô nhập liệu và nhập "423" vào đó
        driver.findElement(By.xpath("//*[@id=\"tblTerm_filter\"]/label/input")).sendKeys("423");

        // Dừng thực thi trong 2 giây
        Thread.sleep(2000);

        // Nhấp vào liên kết được xác định bằng đường dẫn XPath
        driver.findElement(By.xpath("//*[@id=\"tblTerm\"]/tbody/tr/td[9]/a[1]")).click();

        // Dừng thực thi trong 2 giây
        Thread.sleep(2000);

        // Khởi tạo một đối tượng của lớp ChinhSuaHocKyPage và thực thi phương thức chinhSuaHocKy()
        new ChinhSuaHocKyPage(driver).ChooseStartyear();
        new ChinhSuaHocKyPage(driver).ChooseEndYear();
        new ChinhSuaHocKyPage(driver).DeleteoldWeek();
        new ChinhSuaHocKyPage(driver).Schedule();
        new ChinhSuaHocKyPage(driver).DeleteandInputLesson();
        new ChinhSuaHocKyPage(driver).DeleteoldClass();
        new ChinhSuaHocKyPage(driver).SaveButton(); 
        
		WebElement errorElement1 = driver.findElement(By.xpath("//*[@id=\"start_week-error\"]"));
		WebElement errorElement3 = driver.findElement(By.xpath("//*[@id=\"max_class-error\"]"));

		String expected1 = "Bạn chưa nhập tuần bắt đầu"; // Chuỗi kỳ vọng thông báo lỗi
		String expected3 = "Bạn chưa nhập số lớp tối đa"; // Chuỗi kỳ vọng thông báo lỗi

		// In ra kết quả gong đợi của thông báo lỗi
		System.out.println("Kết quả mong đợi 1: " + expected1);
		// In ra kết quả thực tế của thông báo lỗi trên giao diện web
		System.out.println("Kết quả thực tế 1: " + errorElement1.getText());
		System.out.println("========");
		// In ra kết quả mong đợi của thông báo lỗi
		System.out.println("Kết quả mong đợi 2: " + expected3);
		// In ra kết quả thực tế của thông báo lỗi trên giao diện web
		System.out.println("Kết quả thực tế 2: " + errorElement3.getText());
    }
//    @Test
//    public void Action5() throws InterruptedException {
//        // Dừng thực thi trong 4 giây
//        Thread.sleep(4000);
//
//        // Tìm và nhấp vào phần tử được xác định bằng đường dẫn XPath
//        driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[2]/a")).click();
//
//        // Dừng thực thi trong 2 giây
//        Thread.sleep(2000);
//
//        // Tìm ô nhập liệu và nhập "423" vào đó
//        driver.findElement(By.xpath("//*[@id=\"tblTerm_filter\"]/label/input")).sendKeys("423");
//
//        // Dừng thực thi trong 2 giây
//        Thread.sleep(2000);
//
//        // Nhấp vào liên kết được xác định bằng đường dẫn XPath
//        driver.findElement(By.xpath("//*[@id=\"tblTerm\"]/tbody/tr/td[9]/a[1]")).click();
//
//        // Dừng thực thi trong 2 giây
//        Thread.sleep(2000);
//
//        // Khởi tạo một đối tượng của lớp ChinhSuaHocKyPage và thực thi phương thức chinhSuaHocKy()
//        new ChinhSuaHocKyPage(driver).chinhSuaHocKy5();
//    }
    @Test
    public void Action5() throws InterruptedException {
	    System.out.println("Testcase 5:Cập nhật học kỳ với bỏ trống tuần bắt đầu,tiết tối đa");

        // Dừng thực thi trong 4 giây
        Thread.sleep(4000);

        // Tìm và nhấp vào phần tử được xác định bằng đường dẫn XPath
        driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[2]/a")).click();

        // Dừng thực thi trong 2 giây
        Thread.sleep(2000);

        // Tìm ô nhập liệu và nhập "423" vào đó
        driver.findElement(By.xpath("//*[@id=\"tblTerm_filter\"]/label/input")).sendKeys("423");

        // Dừng thực thi trong 2 giây
        Thread.sleep(2000);

        // Nhấp vào liên kết được xác định bằng đường dẫn XPath
        driver.findElement(By.xpath("//*[@id=\"tblTerm\"]/tbody/tr/td[9]/a[1]")).click();

        // Dừng thực thi trong 2 giây
        Thread.sleep(2000);

        // Khởi tạo một đối tượng của lớp ChinhSuaHocKyPage và thực thi phương thức chinhSuaHocKy()
        new ChinhSuaHocKyPage(driver).ChooseStartyear();
        new ChinhSuaHocKyPage(driver).ChooseEndYear();
        new ChinhSuaHocKyPage(driver).DeleteoldWeek();
        new ChinhSuaHocKyPage(driver).Schedule();
        new ChinhSuaHocKyPage(driver).DeleteoldLesson();
        new ChinhSuaHocKyPage(driver).DeleteandInputClass();
        new ChinhSuaHocKyPage(driver).SaveButton();   
        
		WebElement errorElement1 = driver.findElement(By.xpath("//*[@id=\"start_week-error\"]"));
		WebElement errorElement2 = driver.findElement(By.xpath("//*[@id=\"max_lesson-error\"]"));

		String expected1 = "Bạn chưa nhập tuần bắt đầu"; // Chuỗi kỳ vọng thông báo lỗi
		String expected2 = "Bạn chưa nhập số tiết tối đa"; // Chuỗi kỳ vọng thông báo lỗi

		// In ra kết quả gong đợi của thông báo lỗi
		System.out.println("Kết quả mong đợi 1: " + expected1);
		// In ra kết quả thực tế của thông báo lỗi trên giao diện web
		System.out.println("Kết quả thực tế 1: " + errorElement1.getText());
		System.out.println("========");
		// In ra kết quả mong đợi của thông báo lỗi
		System.out.println("Kết quả mong đợi 2: " + expected2);
		// In ra kết quả thực tế của thông báo lỗi trên giao diện web
		System.out.println("Kết quả thực tế 2: " + errorElement2.getText());
		System.out.println("========");

    }
    @Test
    public void Action6() throws InterruptedException {
	    System.out.println("Testcase 6:Cập nhật học kỳ với bỏ trống tuần bắt đầu");
        // Dừng thực thi trong 4 giây
        Thread.sleep(4000);
        // Tìm và nhấp vào phần tử được xác định bằng đường dẫn XPath
        driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[2]/a")).click();
        // Dừng thực thi trong 2 giây
        Thread.sleep(2000);
        // Tìm ô nhập liệu và nhập "423" vào đó
        driver.findElement(By.xpath("//*[@id=\"tblTerm_filter\"]/label/input")).sendKeys("423");
        // Dừng thực thi trong 2 giây
        Thread.sleep(2000);
        // Nhấp vào liên kết được xác định bằng đường dẫn XPath
        driver.findElement(By.xpath("//*[@id=\"tblTerm\"]/tbody/tr/td[9]/a[1]")).click();
        // Dừng thực thi trong 2 giây
        Thread.sleep(2000);
        // Khởi tạo một đối tượng của lớp ChinhSuaHocKyPage và thực thi phương thức chinhSuaHocKy()
        new ChinhSuaHocKyPage(driver).ChooseStartyear();
        new ChinhSuaHocKyPage(driver).ChooseEndYear();
        new ChinhSuaHocKyPage(driver).DeleteoldWeek();
        new ChinhSuaHocKyPage(driver).DeleteandInputLesson();
        new ChinhSuaHocKyPage(driver).DeleteandInputClass();
        new ChinhSuaHocKyPage(driver).SaveButton();


		WebElement errorElement1 = driver.findElement(By.xpath("//*[@id=\"start_week-error\"]"));


		String expected1 = "Bạn chưa nhập tuần bắt đầu"; // Chuỗi kỳ vọng thông báo lỗi


		// In ra kết quả mong đợi của thông báo lỗi
		System.out.println("Kết quả mong đợi: " + expected1);
		// In ra kết quả thực tế của thông báo lỗi trên giao diện web
		System.out.println("Kết quả thực tế: " + errorElement1.getText());
		System.out.println("========");


    }
    @Test
    public void Action7() throws InterruptedException {
	    System.out.println("Testcase 7:Cập nhật học kỳ với bỏ trống tiết tối đa");
        // Dừng thực thi trong 4 giây
        Thread.sleep(4000);
        // Tìm và nhấp vào phần tử được xác định bằng đường dẫn XPath
        driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[2]/a")).click();
        // Dừng thực thi trong 2 giây
        Thread.sleep(2000);
        // Tìm ô nhập liệu và nhập "423" vào đó
        driver.findElement(By.xpath("//*[@id=\"tblTerm_filter\"]/label/input")).sendKeys("423");
        // Dừng thực thi trong 2 giây
        Thread.sleep(2000);
        // Nhấp vào liên kết được xác định bằng đường dẫn XPath
        driver.findElement(By.xpath("//*[@id=\"tblTerm\"]/tbody/tr/td[9]/a[1]")).click();
        // Dừng thực thi trong 2 giây
        Thread.sleep(2000);
        // Khởi tạo một đối tượng của lớp ChinhSuaHocKyPage và thực thi phương thức chinhSuaHocKy()
        new ChinhSuaHocKyPage(driver).ChooseStartyear();
        new ChinhSuaHocKyPage(driver).ChooseEndYear();
        new ChinhSuaHocKyPage(driver).DeleteandInputWeek();
        new ChinhSuaHocKyPage(driver).DeleteoldLesson();
        new ChinhSuaHocKyPage(driver).DeleteandInputClass();
        new ChinhSuaHocKyPage(driver).SaveButton();


		WebElement errorElement2 = driver.findElement(By.xpath("//*[@id=\"max_lesson-error\"]"));


		String expected2 = "Bạn chưa nhập số tiết tối đa"; // Chuỗi kỳ vọng thông báo lỗi

		// In ra kết quả mong đợi của thông báo lỗi
		System.out.println("Kết quả mong đợi: " + expected2);
		// In ra kết quả thực tế của thông báo lỗi trên giao diện web
		System.out.println("Kết quả thực tế: " + errorElement2.getText());
		System.out.println("========");


    }
    @Test
    public void Action8() throws InterruptedException {
	    System.out.println("Testcase 8:Cập nhật học kỳ với bỏ trống lớp tối đa");

        driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[2]/a")).click();

        // Dừng thực thi trong 4 giây
        Thread.sleep(4000);
        // Tìm và nhấp vào phần tử được xác định bằng đường dẫn XPath
        driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[2]/a")).click();
        // Dừng thực thi trong 2 giây
        Thread.sleep(2000);
        // Tìm ô nhập liệu và nhập "423" vào đó
        driver.findElement(By.xpath("//*[@id=\"tblTerm_filter\"]/label/input")).sendKeys("423");
        // Dừng thực thi trong 2 giây
        Thread.sleep(2000);
        // Nhấp vào liên kết được xác định bằng đường dẫn XPath
        driver.findElement(By.xpath("//*[@id=\"tblTerm\"]/tbody/tr/td[9]/a[1]")).click();
        // Dừng thực thi trong 2 giây
        Thread.sleep(2000);
        // Khởi tạo một đối tượng của lớp ChinhSuaHocKyPage và thực thi phương thức chinhSuaHocKy()
        new ChinhSuaHocKyPage(driver).ChooseStartyear();
        new ChinhSuaHocKyPage(driver).ChooseEndYear();
        new ChinhSuaHocKyPage(driver).DeleteandInputWeek();
        new ChinhSuaHocKyPage(driver).DeleteandInputLesson();
        new ChinhSuaHocKyPage(driver).DeleteoldClass();
        new ChinhSuaHocKyPage(driver).SaveButton();


		WebElement errorElement2 = driver.findElement(By.xpath("//*[@id=\"max_class-error\"]"));


		String expected2 = "Bạn chưa nhập số lớp tối đa"; // Chuỗi kỳ vọng thông báo lỗi

		// In ra kết quả mong đợi của thông báo lỗi
		System.out.println("Kết quả mong đợi: " + expected2);
		// In ra kết quả thực tế của thông báo lỗi trên giao diện web
		System.out.println("Kết quả thực tế: " + errorElement2.getText());
		System.out.println("========");


    }
//    @AfterTest
//    public void tearDown() {
//        // Đóng trình duyệt
//        driver.quit();
//    }
}
