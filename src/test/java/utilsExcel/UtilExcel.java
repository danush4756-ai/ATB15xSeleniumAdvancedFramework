package utilsExcel;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import java.io.FileInputStream;
import java.io.IOException;
public class UtilExcel {
    public static String SHEET_PATH = System.getProperty("user.dir") + "/src/test/resources/TestData.xlsx";
    static Workbook book;//Represents the entire Excel file
    static Sheet sheet;//Represents one sheet (tab) inside Excel
    public static Object[][] getTestDataFromExcel(String sheetName) {
        // Apache POI
        // Read the File - TestData.xlsX
        //  Workbook Create
        // Sheet
        // Row and Cell
        // 2D Object  - getData()
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(SHEET_PATH);//To read the Excel file from path
            book = WorkbookFactory.create(fileInputStream);/*Converts the raw file into an Excel object (Workbook)
            because Java cannot directly “read” Excel files unless you convert them into objects*/
            sheet = book.getSheet(sheetName);//To get a specific sheet
            /*'getSheet' belongs to the Apache POI library, which is used to work with Excel files in Java.*/
        } catch (IOException e) {
            System.out.println("File not found");
        }
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
                // First row email, password -> column name - skip - header
                data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
            }
        }
        return data;
    }
}
