package lab_1_2;

import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TimeVKTest {

    @Test
    void create() {
        TimeVK actual = new TimeVK();

        assertEquals(0, actual.getHours());
        assertEquals(0, actual.getMinutes());
        assertEquals(0, actual.getSeconds());
    }

    @Test
    void createWithParameters() {
        TimeVK actual = new TimeVK(1, 2, 3);

        assertEquals(1, actual.getHours());
        assertEquals(2, actual.getMinutes());
        assertEquals(3, actual.getSeconds());
    }

    @Test
    void createWithInvalidParameters() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> new TimeVK(31, 2, 3));
        assertEquals(exception.getMessage(), "Incorrect value");
    }

    @Test
    void createWithDate() {
        TimeVK actual = new TimeVK(new Date(1, Calendar.MARCH, 3, 4, 5, 6));

        assertEquals(4, actual.getHours());
        assertEquals(5, actual.getMinutes());
        assertEquals(6, actual.getSeconds());
    }

    @Test
    void createWithEmptyDate() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> new TimeVK(null));
        assertEquals(exception.getMessage(), "Date is empty");
    }

    @Test
    void toStringAM() {
        String expected = "01:02:03 AM";

        TimeVK actual = new TimeVK(1, 2, 3);

        assertEquals(expected, actual.toString());
    }

    @Test
    void toStringPM() {
        String expected = "02:15:16 PM";

        TimeVK actual = new TimeVK(14, 15, 16);

        assertEquals(expected, actual.toString());
    }

    @Test
    void plusPeriod() {
        TimeVK expected = new TimeVK(5, 7, 9);
        TimeVK firstTime = new TimeVK(1, 2, 3);
        TimeVK secondTime = new TimeVK(4, 5, 6);

        TimeVK actual = firstTime.plusPeriod(secondTime);

        assertEquals(expected, actual);
    }

    @Test
    void plusBigPeriod() {
        TimeVK expected = new TimeVK(0, 57, 59);
        TimeVK firstTime = new TimeVK(1, 2, 3);
        TimeVK secondTime = new TimeVK(23, 55, 56);

        TimeVK actual = firstTime.plusPeriod(secondTime);

        assertEquals(expected, actual);
    }

    @Test
    void minusPeriod() {
        TimeVK expected = new TimeVK(1, 3, 5);
        TimeVK firstTime = new TimeVK(4, 5, 6);
        TimeVK secondTime = new TimeVK(3, 2, 1);

        TimeVK actual = firstTime.minusPeriod(secondTime);

        assertEquals(expected, actual);
    }

    @Test
    void minusBigPeriod() {
        TimeVK expected = new TimeVK(1, 6, 7);
        TimeVK firstTime = new TimeVK(1, 2, 3);
        TimeVK secondTime = new TimeVK(23, 55, 56);

        TimeVK actual = firstTime.minusPeriod(secondTime);

        assertEquals(expected, actual);
    }

    @Test
    void addPeriods() {
        TimeVK expected = new TimeVK(5, 7, 9);
        TimeVK firstTime = new TimeVK(1, 2, 3);
        TimeVK secondTime = new TimeVK(4, 5, 6);

        TimeVK actual = TimeVK.addPeriods(firstTime, secondTime);

        assertEquals(expected, actual);
    }

    @Test
    void addBigPeriods() {
        TimeVK expected = new TimeVK(15, 38, 29);
        TimeVK firstTime = new TimeVK(15, 42, 33);
        TimeVK secondTime = new TimeVK(23, 55, 56);

        TimeVK actual = TimeVK.addPeriods(firstTime, secondTime);

        assertEquals(expected, actual);
    }
    @Test
    void subtractPeriodsPeriods() {
        TimeVK expected = new TimeVK(1, 3, 5);
        TimeVK firstTime = new TimeVK(4, 5, 6);
        TimeVK secondTime = new TimeVK(3, 2, 1);

        TimeVK actual = TimeVK.subtractPeriods(firstTime, secondTime);

        assertEquals(expected, actual);
    }

    @Test
    void subtractBigPeriods() {
        TimeVK expected = new TimeVK(15, 46, 37);
        TimeVK firstTime = new TimeVK(15, 42, 33);
        TimeVK secondTime = new TimeVK(23, 55, 56);

        TimeVK actual = TimeVK.subtractPeriods(firstTime, secondTime);

        assertEquals(expected, actual);
    }
}