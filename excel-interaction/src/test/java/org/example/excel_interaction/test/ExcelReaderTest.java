package org.example.excel_interaction.test;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.example.excel_interaction.ExcelReader;
import org.example.excel_interaction.Person;
import org.example.excel_interaction.PersonExcelMarshal;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 */
public class ExcelReaderTest {
    public static Sheet createSheet() {
        return new HSSFWorkbook().createSheet();
    }
    @Test(expected = NullPointerException.class)
    public void testReadingEmptyTable() {
        Sheet sheet = createSheet();
        sheet.createRow(0);
        sheet.createRow(1);
        sheet.createRow(2);
        ExcelReader.getPersons(sheet, (row) -> true, PersonExcelMarshal::fromRow);
    }
    @Test
    public void testReading() {
        Sheet sheet = createSheet();
        Person person = Person.builder()
                .surname("Crupi")
                .position("Cheaf")
                .name("John")
                .build();
        fillSheet(sheet, Arrays.asList(person, person), 0);
        List<Person> persons = ExcelReader
                .getPersons(sheet, (row) -> true, PersonExcelMarshal::fromRow);
        Assert.assertEquals(persons, Arrays.asList(person, person));
        persons = ExcelReader
                .getPersons(sheet, (row) -> row.getRowNum() > 0, PersonExcelMarshal::fromRow);
        Assert.assertEquals(persons, Arrays.asList(person));
    }
    @Test
    public void write() throws IOException {
        File file = new File("./test.txt");
        if (!file.exists()) {
            System.out.println(file.createNewFile());
        }
        FileOutputStream stream = new FileOutputStream(file);
        stream.write("fewfwef".getBytes());
        stream.close();
    }
    public static void fillSheet(Sheet sheet, List<Person> persons, int startIndex) {
        int i = 0;
        for (Person person: persons) {
            Row row = sheet.createRow(i + startIndex);
            PersonExcelMarshal.toRow(row, person);
            i++;
        }
    }
}
