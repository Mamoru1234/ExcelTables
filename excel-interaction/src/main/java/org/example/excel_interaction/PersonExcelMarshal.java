package org.example.excel_interaction;

import org.apache.poi.ss.usermodel.Row;

/**
 */
public class PersonExcelMarshal {
    public static Person fromRow(Row row) {
        return Person.builder()
                .surname(row.getCell(0).getStringCellValue())
                .name(row.getCell(1).getStringCellValue())
                .position(row.getCell(2).getStringCellValue())
                .build();
    }
    public static Row toRow(Row target, Person person) {
        target.createCell(0).setCellValue(person.getSurname());
        target.createCell(1).setCellValue(person.getName());
        target.createCell(2).setCellValue(person.getPosition());
        return target;
    }
}
