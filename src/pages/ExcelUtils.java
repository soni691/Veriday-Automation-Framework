package pages;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;

	// THIS METHOD IS TO SET THE FILE PATH AND TO OPEN THE EXCEL FILE, PASS EXCEL
	// PATH AND SHEETNAME AS ARGUMENTS TO THIS METHOD
	public static void setExcelFile(String Path, String SheetName) throws Exception {

		try {

			// OPEN THE EXCEL FILE
			FileInputStream ExcelFile = new FileInputStream(Path);
			// ACCESS THE REQUIRED TEST DATA SHEET
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);

		} catch (Exception e) {

			throw (e);
		}
	}

	// THIS METHOD IS TO READ THE TEST DATA FROM THE EXCEL CELL, IN THIS WE ARE
	// PASSING PARAMETERS AS ROW NUM AND COL NUM
	public static String getCellData(int RowNum, int ColNum) throws Exception {

		try {

			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			//String CellData = Cell.getStringCellValue();
			// return CellData;

			String CellData = null;

			if (Cell.getCellType() == CellType.STRING) {

				CellData = Cell.getStringCellValue();

				//System.out.println("String cell value: " + CellData);

			} else if (Cell.getCellType() == CellType.NUMERIC) {

				CellData = String.valueOf(Cell.getNumericCellValue());
				 //System.out.println("Numeric cell value1: " + CellData);

			}

			return CellData;

		} catch (Exception e) {

			return "";
		}

	}

	// THIS METHOD IS TO WRITE IN THE EXCEL CELL, ROW NUM AND COL NUM ARE THE
	// PARAMETERS
	public static void setCellData(String Result, int RowNum, int ColNum) throws Exception {

		try {

			Row = ExcelWSheet.getRow(RowNum);

			Cell = Row.getCell(ColNum, MissingCellPolicy.RETURN_BLANK_AS_NULL);
			// Cell = Row.getCell(ColNum, xRow.RETURN_BLANK_AS_NULL);
			// Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);

			if (Cell == null) {

				Cell = Row.createCell(ColNum);

				Cell.setCellValue(Result);

			} else {

				Cell.setCellValue(Result);
			}

			// CONSTANT VARIABLES TEST DATA PATH AND TEST DATA FILE NAME
			FileOutputStream fileOut = new FileOutputStream(ConstantInterface.Path_TestData + ConstantInterface.File_TestData);

			ExcelWBook.write(fileOut);

			fileOut.flush();

			fileOut.close();

		} catch (Exception e) {

			throw (e);

		}

	}

}
