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
    public static Predicate<Row> topPredicate(int top) {
        return (row) -> row.getRowNum() > top;
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
