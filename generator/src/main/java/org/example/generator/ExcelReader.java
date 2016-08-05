package org.example.generator;

import com.sun.istack.NotNull;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by alexei on 05.08.16.
 */
public class ExcelReader {
    @NotNull
    public static List<Person> getPersons(final Sheet sheet) {
        return ExcelReader.getPersons(sheet, sheet.getFirstRowNum(), sheet.getLastRowNum());
    }
    @NotNull
    public static List<Person> getPersons(final Sheet sheet, final int top, final int bottom) {
        List<Person> result = new LinkedList<>();
        sheet.forEach(row -> {
            if (row.getRowNum() != top) {
                String surname = row.getCell(0).getStringCellValue();
                String name = row.getCell(1).getStringCellValue();
                String position = row.getCell(2).getStringCellValue();
                result.add(new Person(surname, name, position));
            }
        });
        return result;
    }
}
