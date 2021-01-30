package com.iNetBanking.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.NumberToTextConverter;


public class ReadExcelData {
	public static final String TEST_DATA_PATH = "./src/test/java/com/iNetBanking/TestData/iNetBankingTestData.xlsx";
	static Workbook workBook;
	static Sheet sheet;
	
	public static String[][] getTestData(String sheetName) throws IOException {
		FileInputStream fin = new FileInputStream(TEST_DATA_PATH);
		workBook = WorkbookFactory.create(fin);
		sheet = workBook.getSheet(sheetName);
		String[][] data = new String[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
				Cell cellValue = sheet.getRow(i + 1).getCell(j);
				if(cellValue.getCellType() == CellType.STRING)
					data[i][j] = cellValue.getStringCellValue().toString();
				else if(cellValue.getCellType() == CellType.NUMERIC)
					data[i][j] = NumberToTextConverter.toText(cellValue.getNumericCellValue()).toString();	
				
			}
		}

		return data;
	}

}
