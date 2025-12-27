package Utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class UtilExcel {

    public static String Sheet_path=System.getProperty("user.dir")+"/src/test/java/Resources/TestData.xlsx";
    static Workbook workbook;
    static Sheet sheet;

    public static Object[][] getDataFromSheet(String sheetname){
        FileInputStream fileinputstream =null;
        try{
            fileinputstream =new FileInputStream(Sheet_path);
            workbook= WorkbookFactory.create(fileinputstream);
            sheet=workbook.getSheet(sheetname);

        } catch (IOException e) {
            System.out.println("file not found");
//
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
