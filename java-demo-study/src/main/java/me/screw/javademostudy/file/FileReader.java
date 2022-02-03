package me.screw.javademostudy.file;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileReader {

    public void read(File file) {

        System.out.println(file.getAbsolutePath());
        try (FileInputStream fileInputStream = new FileInputStream(file)) {

            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
            XSSFSheet sheetAt = workbook.getSheetAt(0);
            int rows = sheetAt.getPhysicalNumberOfRows();

            for (int i = 0; i < rows; i++) {
                XSSFRow row = sheetAt.getRow(i);
                int cells = row.getPhysicalNumberOfCells();

                for (int j = 0; j < cells; j++) {
                    XSSFCell cell = row.getCell(j);
                    String value = cell.getStringCellValue();
                    System.out.println(value);
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
