package org.example.excel_interaction;

import lombok.AccessLevel;
import lombok.Setter;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 */
public class TableContentGenerator {
    private final Map<Integer, Boolean> weekEnds;
    @Setter(AccessLevel.PUBLIC) private BiFunction<Integer, Boolean, String> producer;
    public TableContentGenerator(int year, int month) {
        weekEnds = generateWeekendsMap(
                CalendarUtils.getCalendarForMonth(year, month)
        );
    }
    private Map<Integer, Boolean> generateWeekendsMap(Calendar calendar) {
        Map<Integer, Boolean> weekEnds = new HashMap<>();
        int daysInMonth = calendar.getMaximum(Calendar.DAY_OF_MONTH);
        for (int i = 0; i < daysInMonth; i++) {
            weekEnds.put(calendar.get(Calendar.DAY_OF_MONTH), CalendarUtils.isWeekEnd(calendar));
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }
        return  weekEnds;
    }
    public String generate(int dayOfWeek) {
        if (!weekEnds.containsKey(dayOfWeek)){
            throw new IllegalArgumentException();
        }
        if (producer == null) {
            throw new IllegalStateException("producer need to be present");
        }
        return producer.apply(dayOfWeek, weekEnds.get(dayOfWeek));
    }
}
