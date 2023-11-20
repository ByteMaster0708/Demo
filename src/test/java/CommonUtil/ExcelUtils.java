package CommonUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {

	public String getDatafromExcelFile(String sheetname,int rownumber,int cellnumber) throws EncryptedDocumentException, IOException
	{
		
			FileInputStream file=new FileInputStream("src\\test\\resources\\Vtigerdata.xlsx");
			Workbook wb = WorkbookFactory.create(file);
			Sheet sh = wb.getSheet(sheetname);
			Row rw = sh.getRow(rownumber);
			Cell cell = rw.getCell(cellnumber);
			String cellvalue = cell.getStringCellValue();
			return cellvalue;
}
	
	
  }