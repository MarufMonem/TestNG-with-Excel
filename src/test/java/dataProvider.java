import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class dataProvider {

//    To handle different data types
DataFormatter formatter = new DataFormatter();
    @Test(dataProvider = "driveTest")
    public void testCaseData(String greetings, String testNumber, String id){
//        this test will execute 3 times using the sent 3 arrays
        System.out.println(greetings+ " - " + testNumber + " - " + id );

    }

    @DataProvider(name="driveTest")
    public Object[][] getData() throws IOException {
//        Multi dimension object
//        Every row of excel should be sent to 1 array
        FileInputStream file = new FileInputStream("X:\\Self improvement\\Selenium Udemy\\Code\\ExcelDataProvider\\ExcelDrivenData.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(0);
//        how many rows?
        int numberOfRows = sheet.getPhysicalNumberOfRows();
        XSSFRow firstRow = sheet.getRow(0);
        int numberOfCol = firstRow.getLastCellNum(); //getting the colum count for one row
        Object [][] dataArray = new Object[numberOfRows-1][numberOfCol]; //creating the multi dimension array based on the counts. The header should not be in the array
        for(int row=0; row<numberOfRows-1; row++){ //putting values inside the array using 2 loops
            Row rowContents = sheet.getRow(row+1);
            for (int col=0; col<numberOfCol; col++){
                Cell cellVal = rowContents.getCell(col);
//                No matter what data type u have it would convert it into string
                dataArray[row][col] = formatter.formatCellValue(cellVal);
//                System.out.println(rowContents.getCell(col));
            }
        }

//        Object[][] data =  {{"hello1", "text1", 1}, {"hello2", "text2", 12}, {"hello3", "text3", 123}};

        return dataArray;
    }

}
