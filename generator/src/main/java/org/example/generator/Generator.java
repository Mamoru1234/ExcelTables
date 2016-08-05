package org.example.generator;

import com.sun.istack.NotNull;
import lombok.val;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.nio.file.Path;

/**
 * Created by alexei on 05.08.16.
 */
public class Generator {
    public static Workbook generate(@NotNull Sheet personsSheet) {
        personsSheet.forEach(row -> {
            if (row.getRowNum()!=0) {
                Person person = Person.fromRow(row);
                System.out.println(person);
            }
        });
        return null;
    }
}
