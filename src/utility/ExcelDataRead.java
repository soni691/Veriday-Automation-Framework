package utility;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
 
public class ExcelDataRead
{
    public static FileInputStream fis = null;
    public static XSSFWorkbook workbook = null;
    public static XSSFSheet sheet = null;
    public static XSSFRow row = null;
    public static XSSFCell cell = null;
 
    public static void setExcelFile(String xlFilePath) throws Exception
    {
    	System.out.println("File path is:"+xlFilePath);
        fis = new FileInputStream(xlFilePath);
        workbook = new XSSFWorkbook(fis);
        fis.close();
    }
 
    public static String getCellData(String sheetName, String colName, int rowNum)
    {
       // try
       // {
            int col_Num = -1;
            sheet = workbook.getSheet(sheetName);
            row = sheet.getRow(0);
            for(int i = 0; i < row.getLastCellNum(); i++)
            {
                if(row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
                {
                    col_Num = i;
                    System.out.println("Found"+i);
                }
            }
            System.out.println("Column number is"+col_Num);
            row = sheet.getRow(rowNum + 1);
            cell = row.getCell(col_Num);
            String value1 = cell.getStringCellValue();
            System.out.println("Value of the Excel Cell is - "+ value1);
 
            if(cell.getCellType() == CellType.STRING)
                return cell.getStringCellValue();
            else if(cell.getCellType() == CellType.NUMERIC)
            {
                String cellValue = String.valueOf(cell.getNumericCellValue());
                return cellValue;
            }
            else if(cell.getCellType() == CellType.BLANK)
                return "";
            
            else
                return String.valueOf(cell.getBooleanCellValue());
        }
       /* catch(Exception e)
        {
            e.printStackTrace();
            return "row "+rowNum+" or column "+colName +" does not exist  in Excel";
        } */
    }
