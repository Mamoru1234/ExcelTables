package org.example.excel_interaction.test;

import org.example.excel_interaction.TableContentGenerator;
import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;

/**
 */
public class TableContentGeneratorTest {
    @Test
    public void testGeneration() {
        TableContentGenerator generator =
                new TableContentGenerator(2016, Calendar.OCTOBER);
        final String weekEnd = "Вх";
        final String dayText = "8";
        generator.setProducer((day, isWeekend) -> {
            if (isWeekend) {
                return weekEnd;
            }
            return dayText;
        });
        assertEquals(weekEnd, generator.generate(1));
        assertEquals(weekEnd, generator.generate(2));
        assertEquals(weekEnd, generator.generate(8));
        assertEquals(weekEnd, generator.generate(9));
        assertEquals(dayText, generator.generate(5));
    }
    @Test(expected = IllegalStateException.class)
    public void withoutProducer() {
        TableContentGenerator generator =
                new TableContentGenerator(2016, Calendar.OCTOBER);
        generator.generate(3);
    }
    @Test(expected = IllegalArgumentException.class)
    public void wrongDay() {
        TableContentGenerator generator =
                new TableContentGenerator(2016, Calendar.FEBRUARY);
        generator.generate(30);
    }
}
