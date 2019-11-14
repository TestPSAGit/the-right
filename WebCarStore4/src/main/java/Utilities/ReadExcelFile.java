/*
 * Creation : 14 mai 2019
 */
package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {

    static String[][] Data;

    public static String[][] GetTestData(String path, int index) throws IOException {

        File excelFile = new File(path);
        FileInputStream fis = new FileInputStream(excelFile);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(index);

        Iterator<Row> rowIt = sheet.iterator();
        Data = new String[100][100];
        int i = 0;
        int j = 0;
        while (rowIt.hasNext()) {

            Row row = rowIt.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            j = 0;
            i++;
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                Data[i][j] = cell.toString();

                j++;
            }

        }

        workbook.close();
        fis.close();
        return Data;

    }

    public static void main(String[] args) throws IOException {

        System.out.println(GetTestData("C:\\Users\\E562418\\git\\PSAWSCS\\WebCarStore\\testData.xlsx", 0)[2][0]);

    }

}
