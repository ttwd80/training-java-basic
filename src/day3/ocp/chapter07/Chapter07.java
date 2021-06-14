package day3.ocp.chapter07;

import java.time.*;

public class Chapter07 {
    public static void main(String[] args) {
        Chapter07 chapter07 = new Chapter07();
        chapter07.demo();
    }

    private void demo() {
        System.out.println("Create and manage date-based and time-based events including a combination of date and time into a single object using LocalDate, LocalTime, LocalDateTime, Instant, Period, and Duration");
        jdkDateTime();
        System.out.println();

        System.out.println("Work with dates and times across timezones and manage changes resulting from daylight savings including Format date and times values");
        dstDateTime();
        System.out.println();

        System.out.println("Define and create and manage date-based and time-based events using Instant, Period, Duration, and TemporalUnit");
        duration();
        System.out.println();
    }

    private void duration() {
        Period p1 = Period.of(0, 0, 1);
        LocalDateTime t1 = LocalDateTime.of(2020, 1, 1, 0, 2, 15);
        System.out.println("t1 = " + t1);
        LocalDateTime t2 =  t1.plus(p1);
        System.out.println("t2 = " + t2);

        Duration d1 = Duration.ofHours(3).plusMinutes(4).plusSeconds(2);
        LocalDateTime t3 =  t2.plus(d1);
        System.out.println("t3 = " + t3);
    }

    private void dstDateTime() {
        ZoneId zone = ZoneId.of("Australia/Sydney");
        LocalDate t1 = LocalDate.of(2020, 4, 5);
        LocalTime t2 = LocalTime.of(1, 0,0);
        ZonedDateTime t3 = ZonedDateTime.of(t1, t2, zone);
        for (int i = 0; i < 5; i++) {
            System.out.println(t3.plusHours(i));
        }
    }

    private void jdkDateTime() {
        LocalDate t1 = LocalDate.of(2021, Month.MAY, 1);
        LocalTime t2 = LocalTime.of(9, 0, 0);
        LocalDateTime t3 = LocalDateTime.of(2021, 5, 1, 9, 0,0);
        LocalDateTime t4 = LocalDateTime.of(t1, t2);
    }
}
