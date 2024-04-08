package QUANLYHOCKI_TEST;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import PageSetup.Setup;
import QUANLYHOCKY_PAGE.ThemHocKyPage;

import java.io.FileInputStream;
import java.io.IOException;

public class ThemHocKyTest {
	static WebDriver driver;

	@BeforeTest
	public void Main() throws IOException, InterruptedException {
		Setup setup = new Setup();
		driver = setup.setup();
		Thread.sleep(3000);
	}

    @Test
    public void Action() throws InterruptedException, IOException {
        System.out.println("Testcase 1: Thêm học kỳ nhưng nhập với 2 ký tự");

        // Mở file Excel và lấy dữ liệu từ sheet đầu tiên
        FileInputStream fis = new FileInputStream("K:\\Automation\\AddNewTerm.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);

        // Lấy dữ liệu học kỳ từ ô đầu tiên của dòng đầu tiên
        XSSFRow row = sheet.getRow(0);
        String HK = row.getCell(0).getStringCellValue();

        // Thực hiện các thao tác trên trang web
        // Click vào một phần tử để chuyển đến trang cần thao tác
        new ThemHocKyPage(driver).themHocKy(HK);
        Thread.sleep(2000);
        String expected = "Vui lòng nhập đúng 3 kí tự!";
        String actual = new ThemHocKyPage(driver).getErrorMessage();

        System.out.println("Kết quả mong đợi: " + expected);
        System.out.println("Kết quả thực tế: " + actual);
        Thread.sleep(2000);

    }
    @Test
    public void Action2() throws InterruptedException, IOException {
        System.out.println("Testcase 2: Thêm học kỳ nhưng nhập hơn 3 ký tự");

        // Mở file Excel và lấy dữ liệu từ sheet đầu tiên
        FileInputStream fis = new FileInputStream("K:\\Automation\\AddNewTerm.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);

        // Lấy dữ liệu học kỳ từ ô đầu tiên của dòng thứ hai
        String HK = sheet.getRow(1).getCell(0).getStringCellValue();

        // Thực hiện thêm học kỳ
        new ThemHocKyPage(driver).themHocKy(HK);

        // Lấy thông báo lỗi xuất hiện sau khi nhập dữ liệu không hợp lệ và in ra kết quả mong đợi và thực tế
        String expected = "Vui lòng nhập đúng 3 kí tự!";
        String actual = new ThemHocKyPage(driver).getErrorMessage();

        System.out.println("Kết quả mong đợi: " + expected);
        System.out.println("Kết quả thực tế: " + actual);
        Thread.sleep(2000);

    }
    @Test
    public void Action3() throws InterruptedException, IOException {
        System.out.println("Testcase 3: Thêm học kỳ nhưng nhập kí tự đặc biệt");

        // Mở file Excel và lấy dữ liệu từ sheet đầu tiên
        FileInputStream fis = new FileInputStream("K:\\Automation\\AddNewTerm.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);

        // Lấy dữ liệu học kỳ từ ô đầu tiên của dòng thứ ba
        String HK = sheet.getRow(2).getCell(0).getStringCellValue();

        // Thực hiện thêm học kỳ
        new ThemHocKyPage(driver).themHocKy(HK);

        // Lấy thông báo lỗi xuất hiện sau khi nhập dữ liệu không hợp lệ và in ra kết quả mong đợi và thực tế
        String expected = "Vui lòng nhập số!";
        String actual = new ThemHocKyPage(driver).getErrorMessage();

        System.out.println("Kết quả mong đợi: " + expected);
        System.out.println("Kết quả thực tế: " + actual);
        Thread.sleep(2000);
    }
    @Test
    public void Action4() throws InterruptedException, IOException {
        System.out.println("Testcase 4: Thêm học kỳ nhưng nhập kí tự đặc biệt và số");

        // Mở file Excel và lấy dữ liệu từ sheet đầu tiên
        FileInputStream fis = new FileInputStream("K:\\Automation\\AddNewTerm.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);

        // Lấy dữ liệu học kỳ từ ô đầu tiên của dòng thứ tư
        String HK = sheet.getRow(3).getCell(0).getStringCellValue();

        // Thực hiện thêm học kỳ
        new ThemHocKyPage(driver).themHocKy(HK);

        // Lấy thông báo lỗi xuất hiện sau khi nhập dữ liệu không hợp lệ và in ra kết quả mong đợi và thực tế
        String expected = "Vui lòng nhập số!";
        String actual = new ThemHocKyPage(driver).getErrorMessage();

        System.out.println("Kết quả mong đợi: " + expected);
        System.out.println("Kết quả thực tế: " + actual);
        Thread.sleep(2000);

    }
    @Test
    public void Action5() throws InterruptedException, IOException {
        System.out.println("Testcase 5: Thêm học kỳ nhưng bỏ trống ô học kỳ");

        // Thực hiện thêm học kỳ với ô học kỳ trống
        new ThemHocKyPage(driver).themHocKy("");

        // Lấy thông báo lỗi xuất hiện sau khi nhập dữ liệu không hợp lệ và in ra kết quả mong đợi và thực tế
        String expected = "Bạn chưa nhập học kỳ";
        String actual = new ThemHocKyPage(driver).getErrorMessage();

        System.out.println("Kết quả mong đợi: " + expected);
        System.out.println("Kết quả thực tế: " + actual);
        Thread.sleep(2000);

    }
    @Test
    public void Action6() throws InterruptedException, IOException {
        System.out.println("Testcase 6: Thêm học kỳ với đầy đủ thông tin");

        // Mở file Excel và lấy dữ liệu từ sheet đầu tiên
        FileInputStream fis = new FileInputStream("K:\\Automation\\AddNewTerm.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);

        // Lấy dữ liệu học kỳ từ ô đầu tiên của dòng thứ tư
        String HK = sheet.getRow(4).getCell(0).getStringCellValue();

        // Thực hiện thêm học kỳ
        new ThemHocKyPage(driver).themHocKy(HK);

        Thread.sleep(2000);
    }
    @Test
    public void Action7() throws InterruptedException, IOException {
	    System.out.println("Testcase 7:Thêm học kỳ với bỏ trống tuần bắt đầu,Ngày bắt đầu,tiết tối đa và lớp tối đa");

	    // Mở một luồng để đọc file Excel
	    FileInputStream fis = new FileInputStream("K:\\Automation\\AddNewTerm.xlsx");

	    // Tạo một đối tượng XSSFWorkbook để đại diện cho toàn bộ tệp Excel
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);

	    // Lấy ra sheet đầu tiên từ workbook
	    XSSFSheet sheet = workbook.getSheetAt(0);

	    // Lấy ra dòng thứ 5 từ sheet và lấy giá trị từ ô đầu tiên
	    XSSFRow row = sheet.getRow(4);
	    String HK = row.getCell(0).getStringCellValue();
	    
        new ThemHocKyPage(driver).themHocKy2(HK);
        
        String expected1 = "Bạn chưa nhập tuần bắt đầu"; // Chuỗi kỳ vọng thông báo lỗi
		String expected2 = "Bạn chưa chọn ngày bắt đầu"; // Chuỗi kỳ vọng thông báo lỗi
		String expected3 = "Bạn chưa nhập số tiết tối đa"; // Chuỗi kỳ vọng thông báo lỗi
		String expected4 = "Bạn chưa nhập số lớp tối đa"; // Chuỗi kỳ vọng thông báo lỗi
		
        String actual1 = new ThemHocKyPage(driver).getErrorMessage1();
        String actual2 = new ThemHocKyPage(driver).getErrorMessage2();
        String actual3 = new ThemHocKyPage(driver).getErrorMessage3();
        String actual4 = new ThemHocKyPage(driver).getErrorMessage4();
        

		// In ra kết quả mong đợi của thông báo lỗi
		System.out.println("Kết quả mong đợi 1: " + expected1);
		// In ra kết quả thực tế của thông báo lỗi trên giao diện web
		System.out.println("Kết quả thực tế 1: " + actual1);
		System.out.println("========");
		// In ra kết quả mong đợi của thông báo lỗi
		System.out.println("Kết quả mong đợi 2: " + expected2);
		// In ra kết quả thực tế của thông báo lỗi trên giao diện web
		System.out.println("Kết quả thực tế 2: " + actual2);
		System.out.println("========");
		// In ra kết quả mong đợi của thông báo lỗi
		System.out.println("Kết quả mong đợi 3: " + expected3);
		// In ra kết quả thực tế của thông báo lỗi trên giao diện web
		System.out.println("Kết quả thực tế 3: " + actual3);
		System.out.println("========");
		// In ra kết quả mong đợi của thông báo lỗi
		System.out.println("Kết quả mong đợi 4: " + expected4);
		// In ra kết quả thực tế của thông báo lỗi trên giao diện web
		System.out.println("Kết quả thực tế 4: " + actual4);
		System.out.println("===============");
		driver.navigate().refresh();
    }
    @Test
    public void Action8() throws InterruptedException, IOException {
	    System.out.println("Testcase 8:Thêm học kỳ với ký tự đặc biệt cho tuần bắt đầu,tiết tối đa và lớp tối đa");

	    FileInputStream fis = new FileInputStream("K:\\Automation\\AddNewTerm.xlsx");

	    // Tạo một đối tượng XSSFWorkbook để đại diện cho toàn bộ tệp Excel
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);

	    // Lấy ra sheet đầu tiên từ workbook
	    XSSFSheet sheet = workbook.getSheetAt(0);

	    // Lấy ra dòng thứ 5 từ sheet và lấy giá trị từ ô đầu tiên
	    XSSFRow row = sheet.getRow(4);
	    String HK = row.getCell(0).getStringCellValue();
	    
        new ThemHocKyPage(driver).themHocKy3(HK);
        
        String expected1 = "Vui lòng nhập lớn hơn hoặc bằng 1"; // Chuỗi kỳ vọng thông báo lỗi
		String expected3 = "Vui lòng nhập lớn hơn hoặc bằng 1"; // Chuỗi kỳ vọng thông báo lỗi
		String expected4 = "Vui lòng nhập lớn hơn hoặc bằng 1"; // Chuỗi kỳ vọng thông báo lỗi
		
        String actual1 = new ThemHocKyPage(driver).getErrorMessage1();
        String actual3 = new ThemHocKyPage(driver).getErrorMessage3();
        String actual4 = new ThemHocKyPage(driver).getErrorMessage4();
        

		// In ra kết quả mong đợi của thông báo lỗi
		System.out.println("Kết quả mong đợi 1: " + expected1);
		// In ra kết quả thực tế của thông báo lỗi trên giao diện web
		System.out.println("Kết quả thực tế 1: " + actual1);
		System.out.println("========");
		// In ra kết quả mong đợi của thông báo lỗi
		System.out.println("Kết quả mong đợi 2: " + expected3);
		// In ra kết quả thực tế của thông báo lỗi trên giao diện web
		System.out.println("Kết quả thực tế 2: " + actual3);
		System.out.println("========");
		// In ra kết quả mong đợi của thông báo lỗi
		System.out.println("Kết quả mong đợi 3: " + expected4);
		// In ra kết quả thực tế của thông báo lỗi trên giao diện web
		System.out.println("Kết quả thực tế 3: " + actual4);
		System.out.println("===============");

    }
    @Test
    public void Action9() throws InterruptedException, IOException {
	    System.out.println("Testcase 9:Thêm học kỳ với số âm cho tuần bắt đầu,tiết tối đa và lớp tối đa");

	    FileInputStream fis = new FileInputStream("K:\\Automation\\AddNewTerm.xlsx");

	    // Tạo một đối tượng XSSFWorkbook để đại diện cho toàn bộ tệp Excel
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);

	    // Lấy ra sheet đầu tiên từ workbook
	    XSSFSheet sheet = workbook.getSheetAt(0);

	    // Lấy ra dòng thứ 5 từ sheet và lấy giá trị từ ô đầu tiên
	    XSSFRow row = sheet.getRow(4);
	    String HK = row.getCell(0).getStringCellValue();
	    
        new ThemHocKyPage(driver).themHocKy4(HK);
        
        String expected1 = "Vui lòng nhập lớn hơn hoặc bằng 1"; // Chuỗi kỳ vọng thông báo lỗi
		String expected3 = "Vui lòng nhập lớn hơn hoặc bằng 1"; // Chuỗi kỳ vọng thông báo lỗi
		String expected4 = "Vui lòng nhập lớn hơn hoặc bằng 1"; // Chuỗi kỳ vọng thông báo lỗi
		
        String actual1 = new ThemHocKyPage(driver).getErrorMessage1();
        String actual3 = new ThemHocKyPage(driver).getErrorMessage3();
        String actual4 = new ThemHocKyPage(driver).getErrorMessage4();
        

		// In ra kết quả mong đợi của thông báo lỗi
		System.out.println("Kết quả mong đợi 1: " + expected1);
		// In ra kết quả thực tế của thông báo lỗi trên giao diện web
		System.out.println("Kết quả thực tế 1: " + actual1);
		System.out.println("========");
		// In ra kết quả mong đợi của thông báo lỗi
		System.out.println("Kết quả mong đợi 2: " + expected3);
		// In ra kết quả thực tế của thông báo lỗi trên giao diện web
		System.out.println("Kết quả thực tế 2: " + actual3);
		System.out.println("========");
		// In ra kết quả mong đợi của thông báo lỗi
		System.out.println("Kết quả mong đợi 3: " + expected4);
		// In ra kết quả thực tế của thông báo lỗi trên giao diện web
		System.out.println("Kết quả thực tế 3: " + actual4);
     }
    @Test
    public void Action10() throws InterruptedException, IOException {
	    System.out.println("Testcase 10:Thêm học kỳ với bỏ trống tất cả trường dữ liệu");

	    
        new ThemHocKyPage(driver).themHocKy5("");
        
        String expected1 = "Bạn chưa nhập tuần bắt đầu"; // Chuỗi kỳ vọng thông báo lỗi
		String expected2 = "Bạn chưa chọn ngày bắt đầu"; // Chuỗi kỳ vọng thông báo lỗi
		String expected3 = "Bạn chưa nhập số tiết tối đa"; // Chuỗi kỳ vọng thông báo lỗi
		String expected4 = "Bạn chưa nhập số lớp tối đa"; // Chuỗi kỳ vọng thông báo lỗi
		String expected5 = "Bạn chưa nhập học kỳ";
		
        String actual1 = new ThemHocKyPage(driver).getErrorMessage1();
        String actual2 = new ThemHocKyPage(driver).getErrorMessage2();
        String actual3 = new ThemHocKyPage(driver).getErrorMessage3();
        String actual4 = new ThemHocKyPage(driver).getErrorMessage4();
        String actual5 = new ThemHocKyPage(driver).getErrorMessage();

		// In ra kết quả mong đợi của thông báo lỗi
		System.out.println("Kết quả mong đợi 1: " + expected1);
		// In ra kết quả thực tế của thông báo lỗi trên giao diện web
		System.out.println("Kết quả thực tế 1: " + actual1);
		System.out.println("========");
		// In ra kết quả mong đợi của thông báo lỗi
		System.out.println("Kết quả mong đợi 2: " + expected2);
		// In ra kết quả thực tế của thông báo lỗi trên giao diện web
		System.out.println("Kết quả thực tế 2: " + actual2);
		System.out.println("========");
		// In ra kết quả mong đợi của thông báo lỗi
		System.out.println("Kết quả mong đợi 3: " + expected3);
		// In ra kết quả thực tế của thông báo lỗi trên giao diện web
		System.out.println("Kết quả thực tế 3: " + actual3);
		System.out.println("========");
		// In ra kết quả mong đợi của thông báo lỗi
		System.out.println("Kết quả mong đợi 4: " + expected4);
		// In ra kết quả thực tế của thông báo lỗi trên giao diện web
		System.out.println("Kết quả thực tế 4: " + actual4);
		System.out.println("========");
		System.out.println("Kết quả mong đợi 5: " + expected5);
		// In ra kết quả thực tế của thông báo lỗi trên giao diện web
		System.out.println("Kết quả thực tế 5: " + actual5);
		System.out.println("===============");
     }
	@Test
	public void Action11() throws InterruptedException, IOException {
	    Thread.sleep(2000);
		System.out.println("Testcase 11: Thêm học kỳ nhưng nhập với 2 ký tự và ấn Hủy");

		// Mở file Excel và lấy dữ liệu từ sheet đầu tiên
		FileInputStream fis = new FileInputStream("K:\\Automation\\AddNewTerm.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);

		// Lấy dữ liệu học kỳ từ ô đầu tiên của dòng đầu tiên
		XSSFRow row = sheet.getRow(0);
		String HK = row.getCell(0).getStringCellValue();

		// Thực hiện các thao tác trên trang web
		// Click vào một phần tử để chuyển đến trang cần thao tác
		new ThemHocKyPage(driver).themHocKy6(HK);
		Thread.sleep(2000);

	}

	@Test
	public void Action12() throws InterruptedException, IOException {
	    Thread.sleep(2000);
		System.out.println("Testcase 12: Thêm học kỳ nhưng nhập hơn 3 ký tự và ấn Hủy");

		// Mở file Excel và lấy dữ liệu từ sheet đầu tiên
		FileInputStream fis = new FileInputStream("K:\\Automation\\AddNewTerm.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);

		// Lấy dữ liệu học kỳ từ ô đầu tiên của dòng thứ hai
		String HK = sheet.getRow(1).getCell(0).getStringCellValue();

		// Thực hiện thêm học kỳ
		new ThemHocKyPage(driver).themHocKy6(HK);

		// Lấy thông báo lỗi xuất hiện sau khi nhập dữ liệu không hợp lệ và in ra kết
		// quả mong đợi và thực tế
		Thread.sleep(2000);

	}

	@Test
	public void Action13() throws InterruptedException, IOException {
	    Thread.sleep(2000);
		System.out.println("Testcase 13: Thêm học kỳ nhưng nhập kí tự đặc biệt và ấn Hủy");

		// Mở file Excel và lấy dữ liệu từ sheet đầu tiên
		FileInputStream fis = new FileInputStream("K:\\Automation\\AddNewTerm.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);

		// Lấy dữ liệu học kỳ từ ô đầu tiên của dòng thứ ba
		String HK = sheet.getRow(2).getCell(0).getStringCellValue();

		// Thực hiện thêm học kỳ
		new ThemHocKyPage(driver).themHocKy6(HK);

		Thread.sleep(2000);
	}
  @Test
  public void Action14() throws InterruptedException, IOException {
	    Thread.sleep(2000);
      System.out.println("Testcase 14: Thêm học kỳ nhưng nhập kí tự đặc biệt và số và ấn Hủy");
      
      // Mở file Excel và lấy dữ liệu từ sheet đầu tiên
      FileInputStream fis = new FileInputStream("K:\\Automation\\AddNewTerm.xlsx");
      XSSFWorkbook workbook = new XSSFWorkbook(fis);
      XSSFSheet sheet = workbook.getSheetAt(0);

      // Lấy dữ liệu học kỳ từ ô đầu tiên của dòng thứ tư
      String HK = sheet.getRow(3).getCell(0).getStringCellValue();

      // Thực hiện thêm học kỳ
      new ThemHocKyPage(driver).themHocKy6(HK);

      Thread.sleep(3000);

  }
@Test
public void Action15() throws InterruptedException, IOException {
    Thread.sleep(2000);
    System.out.println("Testcase 15: Thêm học kỳ nhưng bỏ trống ô học kỳ và ấn Hủy");

    // Thực hiện thêm học kỳ với ô học kỳ trống
    new ThemHocKyPage(driver).themHocKy6("");

    Thread.sleep(2000);

}
@Test
public void Action16() throws InterruptedException, IOException {
  System.out.println("Testcase 16: Thêm học kỳ với đầy đủ thông tin và ấn Hủy");

  // Mở file Excel và lấy dữ liệu từ sheet đầu tiên
  FileInputStream fis = new FileInputStream("K:\\Automation\\AddNewTerm.xlsx");
  XSSFWorkbook workbook = new XSSFWorkbook(fis);
  XSSFSheet sheet = workbook.getSheetAt(0);

  // Lấy dữ liệu học kỳ từ ô đầu tiên của dòng thứ tư
  String HK = sheet.getRow(4).getCell(0).getStringCellValue();

  // Thực hiện thêm học kỳ
  new ThemHocKyPage(driver).themHocKy6(HK);

  Thread.sleep(2000);
}
	@Test
	public void Action17() throws InterruptedException, IOException {
		System.out.println(
				"Testcase 17:Thêm học kỳ với bỏ trống tuần bắt đầu,Ngày bắt đầu,tiết tối đa và lớp tối đa và ấn Hủy");

		// Mở một luồng để đọc file Excel
		FileInputStream fis = new FileInputStream("K:\\Automation\\AddNewTerm.xlsx");

		// Tạo một đối tượng XSSFWorkbook để đại diện cho toàn bộ tệp Excel
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		// Lấy ra sheet đầu tiên từ workbook
		XSSFSheet sheet = workbook.getSheetAt(0);

		// Lấy ra dòng thứ 5 từ sheet và lấy giá trị từ ô đầu tiên
		XSSFRow row = sheet.getRow(4);
		String HK = row.getCell(0).getStringCellValue();

		new ThemHocKyPage(driver).themHocKy7(HK);

//	driver.navigate().refresh();
	}

	@Test
	public void Action18() throws InterruptedException, IOException {
		System.out.println(
				"Testcase 18:Thêm học kỳ với ký tự đặc biệt cho tuần bắt đầu,tiết tối đa và lớp tối đa và ấn Hủy");

		FileInputStream fis = new FileInputStream("K:\\Automation\\AddNewTerm.xlsx");

		// Tạo một đối tượng XSSFWorkbook để đại diện cho toàn bộ tệp Excel
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		// Lấy ra sheet đầu tiên từ workbook
		XSSFSheet sheet = workbook.getSheetAt(0);

		// Lấy ra dòng thứ 5 từ sheet và lấy giá trị từ ô đầu tiên
		XSSFRow row = sheet.getRow(4);
		String HK = row.getCell(0).getStringCellValue();

		new ThemHocKyPage(driver).themHocKy8(HK);

	}

	@Test
	public void Action19() throws InterruptedException, IOException {
		System.out.println("Testcase 19:Thêm học kỳ với số âm cho tuần bắt đầu,tiết tối đa và lớp tối đa và ấn Hủy");

		FileInputStream fis = new FileInputStream("K:\\Automation\\AddNewTerm.xlsx");

		// Tạo một đối tượng XSSFWorkbook để đại diện cho toàn bộ tệp Excel
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		// Lấy ra sheet đầu tiên từ workbook
		XSSFSheet sheet = workbook.getSheetAt(0);

		// Lấy ra dòng thứ 5 từ sheet và lấy giá trị từ ô đầu tiên
		XSSFRow row = sheet.getRow(4);
		String HK = row.getCell(0).getStringCellValue();

		new ThemHocKyPage(driver).themHocKy9(HK);

	}

	@Test
	public void Action20() throws InterruptedException, IOException {
		System.out.println("Testcase 20:Thêm học kỳ với bỏ trống tất cả trường dữ liệu và ấn Hủy");

		new ThemHocKyPage(driver).themHocKy10("");

	}
}
