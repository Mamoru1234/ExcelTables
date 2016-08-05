package org.example.generator;

import com.sun.istack.NotNull;
import lombok.*;
import org.apache.poi.ss.usermodel.Row;

/**
 * Created by alexei on 05.08.16.
 */
@ToString
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Person {
    @Getter private final String name;
    @Getter private final String surname;
    @Getter private final String position;
    public static Person fromRow(Row row) {
        val surname = row.getCell(0).getStringCellValue();
        val name = row.getCell(1).getStringCellValue();
        val position = row.getCell(2).getStringCellValue();
        return new Person(surname, name, position);
    }
}
