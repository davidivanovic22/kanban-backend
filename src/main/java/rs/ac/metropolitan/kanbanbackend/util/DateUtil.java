package rs.ac.metropolitan.kanbanbackend.util;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Comparator;
import java.util.Date;

public class DateUtil {
    public static Date day(int day, int minus, int plus) {
        DayOfWeek dayOfWeek = DayOfWeek.of(day);
        ZoneId defaultZoneId = ZoneId.systemDefault();
        LocalDate localeDate;
        if (minus > 0 && plus <= 0)
            localeDate = LocalDate.now().with(dayOfWeek).minusDays(minus);
        else if (plus > 0 && minus <= 0)
            localeDate = LocalDate.now().with(dayOfWeek).plusDays(plus);
        else
            localeDate = LocalDate.now().with(dayOfWeek);

        return Date.from(localeDate.atStartOfDay(defaultZoneId).toInstant());
    }

    public static Date presentMonday() {
        ZoneId defaultZoneId = ZoneId.systemDefault();
        LocalDate localeDate =  LocalDate.now().with(DayOfWeek.MONDAY);
        return Date.from(localeDate.atStartOfDay(defaultZoneId).toInstant());
    }

    public static Date presentFriday() {
        ZoneId defaultZoneId = ZoneId.systemDefault();
        LocalDate localeDate =  LocalDate.now().with(DayOfWeek.FRIDAY);
        return Date.from(localeDate.atStartOfDay(defaultZoneId).toInstant());
    }


}
