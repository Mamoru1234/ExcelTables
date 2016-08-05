package org.example.polygon;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.example.generator.Generator;

/**
 * Created by alexei on 05.08.16.
 */
public class Polygon {
    public static void main(String[] args) {
        Workbook workbook = new HSSFWorkbook();
        workbook.createSheet("test");
        Sheet sheet = workbook.getSheet("test");
        sheet.createRow(0);
        Row row = sheet.createRow(1);
        row.createCell(0).setCellValue("My");
        row.createCell(1).setCellValue("My test");
        row.createCell(2).setCellValue("My value");
        Generator.generate(workbook.getSheet("test"));
    }
}
