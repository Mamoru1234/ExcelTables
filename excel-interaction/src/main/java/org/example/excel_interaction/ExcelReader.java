package org.example.excel_interaction;

import com.sun.istack.NotNull;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by alexei on 05.08.16.
 */
public class ExcelReader {
    private final Predicate<Row> predicate;
    public ExcelReader(int top, int bottom) {
        this.predicate = (row) -> {
            int rowNumber = row.getRowNum();
            return rowNumber > top && rowNumber < bottom;
        };
    }
    @NotNull
    public List<Person> getPersons(final Sheet sheet) {
        return getPersons(sheet, predicate, PersonExcelMarshal::fromRow);
    }
    @NotNull
    public static List<Person> getPersons(
            final Sheet sheet,
            Predicate<Row> predicate,
            Function<Row, Person> transformation
    ) {
        List<Person> result = new LinkedList<>();
        sheet.forEach(row -> {
            if (predicate.test(row)) {
                result.add(transformation.apply(row));
            }
        });
        return result;
    }
}
