package org.example.excel_interaction;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 */
public class CalendarUtils {
    public static Calendar getCalendarForMonth(int year, int month) {
        return new GregorianCalendar(year, month, 1);
    }
    public static Calendar getCalendarInstance() {
        Calendar now = GregorianCalendar.getInstance();
        return getCalendarForMonth(now.get(Calendar.YEAR), now.get(Calendar.MONTH));
    }
    public static boolean isWeekEnd(Calendar date) {
        int dayOfWeek = date.get(Calendar.DAY_OF_WEEK);
        return  dayOfWeek == Calendar.SATURDAY
                || dayOfWeek == Calendar.SUNDAY;
    }
}
