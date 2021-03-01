package lab_1_2;

import java.time.LocalTime;
import java.util.Date;

public class TimeVK {
    private int hours;
    private int minutes;
    private int seconds;

    public TimeVK() {
    }

    public TimeVK(int hours, int minutes, int seconds) {
        if (hours >= 0 && hours < 24 && minutes >= 0 && minutes < 60 && seconds >= 0 && seconds < 60) {
            this.hours = hours;
            this.minutes = minutes;
            this.seconds = seconds;
        } else {
            throw new IllegalArgumentException("Incorrect value");
        }
    }

    public TimeVK(Date date) {
        if (date != null) {
            this.hours = date.getHours();
            this.minutes = date.getMinutes();
            this.seconds = date.getSeconds();
        } else {
            throw new IllegalArgumentException("Date is empty");
        }
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d %s", hours%12, minutes, seconds, hours < 12 ? "AM" : "PM");
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public TimeVK plusPeriod(TimeVK timeVk) {
        LocalTime time = LocalTime.of(hours, minutes, seconds)
                .plusHours(timeVk.hours)
                .plusMinutes(timeVk.minutes)
                .plusSeconds(timeVk.seconds);
        return new TimeVK(time.getHour(), time.getMinute(), time.getSecond());
    }

    public TimeVK minusPeriod(TimeVK timeVk) {
        LocalTime time = LocalTime.of(hours, minutes, seconds)
                .minusHours(timeVk.hours)
                .minusMinutes(timeVk.minutes)
                .minusSeconds(timeVk.seconds);
        return new TimeVK(time.getHour(), time.getMinute(), time.getSecond());
    }

    public static TimeVK addPeriods(TimeVK timeOne, TimeVK timeTwo) {
        LocalTime time = LocalTime.of(timeOne.hours, timeOne.minutes, timeOne.seconds)
                .plusHours(timeTwo.hours)
                .plusMinutes(timeTwo.minutes)
                .plusSeconds(timeTwo.seconds);
        return new TimeVK(time.getHour(), time.getMinute(), time.getSecond());
    }

    public static TimeVK subtractPeriods(TimeVK timeOne, TimeVK timeTwo) {
        LocalTime time = LocalTime.of(timeOne.hours, timeOne.minutes, timeOne.seconds)
                .minusHours(timeTwo.hours)
                .minusMinutes(timeTwo.minutes)
                .minusSeconds(timeTwo.seconds);
        return new TimeVK(time.getHour(), time.getMinute(), time.getSecond());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TimeVK timeVK = (TimeVK) o;

        if (hours != timeVK.hours) return false;
        if (minutes != timeVK.minutes) return false;
        return seconds == timeVK.seconds;
    }

    @Override
    public int hashCode() {
        int result = hours;
        result = 31 * result + minutes;
        result = 31 * result + seconds;
        return result;
    }
}