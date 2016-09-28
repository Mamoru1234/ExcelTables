package org.example.polygon;

import lombok.val;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.example.excel_interaction.ExcelReader;
import org.example.excel_interaction.PersonExcelMarshal;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.function.Predicate;

/**
 * Created by alexei on 05.08.16.
 */
public class Polygon {
    public static Predicate<Row> predicate = ExcelReader.topPredicate(0);
    public static void main(String[] args) throws IOException {
        InputStream inputStream = Polygon.class.getClassLoader()
                .getResourceAsStream("files/Persons.xls");
        Workbook workbook = new HSSFWorkbook(inputStream);
        inputStream.close();
        val persons = ExcelReader.getPersons(
                workbook.getSheetAt(0),
                predicate,
                PersonExcelMarshal::fromRow);
        persons.forEach(System.out::println);
        OutputStream outputStream = OutputFileStreamUtils
                .getOutputStream("/test.xls");
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
}
