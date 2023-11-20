package Framework1;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class contactexcel {

	public static void main(String[] args) throws IOException {
		
		WebDriver d=new ChromeDriver();
		FileInputStream file=new FileInputStream("src\\test\\resources\\contactexcel.xlsx");
		
		Workbook wb=WorkbookFactory.create(file);
		Sheet sh1 = wb.getSheet("sheet1");
		Row rw1 = sh1.getRow(0);
		Cell cl1 = rw1.getCell(0);
		String data1 = cl1.getStringCellValue();
		System.out.println(data1);
		
		Sheet sh2 = wb.getSheet("sheet1");
		Row rw2 = sh2.getRow(0);
		Cell cl2 = rw1.getCell(1);
		String data2 = cl2.getStringCellValue();
		System.out.println(data2);
		
		Sheet sh3 = wb.getSheet("sheet1");
		Row rw3 = sh3.getRow(1);
		Cell cl3 = rw3.getCell(0);
		String data3 = cl3.getStringCellValue();
		System.out.println(data3);
		
		Sheet sh4 = wb.getSheet("sheet1");
		Row rw4 = sh4.getRow(1);
		Cell cl4 = rw4.getCell(1);
		String data4 = cl4.getStringCellValue();
		System.out.println(data4);
		
		Sheet sh5 = wb.getSheet("sheet1");
		Row rw5 = sh5.getRow(2);
		Cell cl5 = rw5.getCell(0);
		String data5 = cl5.getStringCellValue();
		System.out.println(data5);
		
		Sheet sh6 = wb.getSheet("sheet1");
		Row rw6 = sh6.getRow(2);
		Cell cl6 = rw6.getCell(1);
		String data6 = cl6.getStringCellValue();
		System.out.println(data6);
	}
}
