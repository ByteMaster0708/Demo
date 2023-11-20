package Framework1;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class dataDrivenExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub

		
		WebDriver d=new ChromeDriver();
		FileInputStream file=new FileInputStream("src\\test\\resources\\organization.xlsx");
		
		Workbook wb=WorkbookFactory.create(file);

		//to get control of the sheet
		Sheet sh = wb.getSheet("sheet1");
		
		//to get control of the row
		 Row rw1 = sh.getRow(0);
		
		//to get the control of column
		 Cell cl = rw1.getCell(0);
		
		//to get the value of the cell
		String data1 = cl.getStringCellValue();
		System.out.println(data1);
	}

}
