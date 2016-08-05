package org.example.polygon;

import lombok.val;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.example.generator.Generator;

import java.io.IOException;

/**
 * Created by alexei on 05.08.16.
 */
public class Polygon {
    public static void main(String[] args) throws IOException {
        val file = Polygon.class.getClassLoader().getResourceAsStream("files/Persons.xls");
        Workbook workbook = new HSSFWorkbook(file);
        Generator.generate(workbook.getSheet("test"));
    }
}
