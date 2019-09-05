package com.nick.jodatime;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Instant;

import java.util.Locale;

public class MainClassJodaTime {
    public static void main(String[] args) {
        DateTime dt = new DateTime(2019, 5, 26, 12, 0, 0, 0);

        System.out.println(dt);

        System.out.println(dt.toInstant());


        DateTime dt2 = new DateTime(2019, 11, 26, 12, 0, 0, 0);

        System.out.println(dt2);

        System.out.println(dt2.toInstant());

        DateTime dt3 = new DateTime(2019, 11, 26, 12, 0, 0, 0, DateTimeZone.UTC);

        System.out.println(dt3);

        System.out.println(dt3.toInstant());

        DateTime dt4 = new DateTime(2019, 11, 26, 15, 0, 0, 0, DateTimeZone.forID("Europe/Madrid"));

        System.out.println(dt4);

        System.out.println(dt4.toInstant());

        System.out.println(dt4.getDayOfWeek());

        System.out.println(DateTime.now().getDayOfWeek());

        System.out.println("--");

        System.out.println(dt4.plusYears(1));

        System.out.println(dt4.toInstant());

        System.out.println(dt4.getDayOfWeek());

        System.out.println(DateTime.now().getDayOfWeek());

        DateTime dateTime = new DateTime(Instant.now(), DateTimeZone.forID("Europe/Madrid"));

        System.out.println(dateTime);

        System.out.println("a: " + dateTime.withHourOfDay(23).withMinuteOfHour(59).withSecondOfMinute(59).withMillisOfSecond(999));


        DateTime dateTimeInicioActuacionVueltaBucle = new DateTime(DateTimeZone.forID("Europe/Madrid"))
            .plusDays(1).withHourOfDay(0).withMinuteOfHour(0).withSecondOfMinute(0).withMillisOfSecond(0);

        System.out.println(Instant.ofEpochMilli(dateTimeInicioActuacionVueltaBucle.getMillis()));
    }
}
