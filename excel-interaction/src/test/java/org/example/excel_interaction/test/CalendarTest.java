package org.example.excel_interaction.test;

import org.example.excel_interaction.CalendarUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

/**
 */
public class CalendarTest {
    @Test
    public void testCalendarCreation() {
        Calendar now = GregorianCalendar.getInstance();
        Calendar calendar = CalendarUtils
                .getCalendarInstance();

        assertEquals("correct year",
                now.get(Calendar.YEAR),
                calendar.get(Calendar.YEAR)
        );
        assertEquals("correct month",
                now.get(Calendar.MONTH),
                calendar.get(Calendar.MONTH)
        );
        assertEquals("correct day", 1, calendar.get(Calendar.DAY_OF_MONTH));
    }
    @Test
    public void testWeekendCheck() {
        assertEquals("Sunday is weekend", true,
                CalendarUtils.isWeekEnd(new GregorianCalendar(2016, Calendar.OCTOBER, 8)));
        assertEquals("Monday isn't", false,
                CalendarUtils.isWeekEnd(new GregorianCalendar(2016, Calendar.OCTOBER, 3)));
    }
}
