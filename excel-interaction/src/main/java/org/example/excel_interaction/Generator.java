package org.example.excel_interaction;

import com.sun.istack.NotNull;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.List;

/**
 * Created by alexei on 05.08.16.
 */
public class Generator {
    private static ExcelReader reader = new ExcelReader(1, 0);
    public static Workbook generate(@NotNull final Sheet personsSheet) {
        List<Person> persons = reader.getPersons(personsSheet);
        persons.forEach(person -> System.out.println(person));
        return null;
    }
}
