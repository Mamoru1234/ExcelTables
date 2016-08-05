package org.example.generator;

import com.sun.istack.NotNull;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.List;

/**
 * Created by alexei on 05.08.16.
 */
public class Generator {
    public static Workbook generate(@NotNull final Sheet personsSheet) {
        List<Person> persons = ExcelReader.getPersons(personsSheet);
        persons.forEach(person -> System.out.println(person));
        return null;
    }
}
