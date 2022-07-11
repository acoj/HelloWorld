package com.example.commonclass;

import org.junit.Test;
import org.junit.jupiter.api.DynamicTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import static java.util.Calendar.DAY_OF_YEAR;

public class Test1 {
    @Test
    public void testSimpleDateFormat() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat();
        Date date = new Date();
        System.out.println(date);
        String format = sdf.format(date);
        System.out.println(format);
        // "1/7/22, 12:02 PM"
        Date parse = sdf.parse("1/7/22, 11:11 AM");
        System.out.println(parse);

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy.MM.dd GGG hh:mm:ss aaa");
        String format1 = sdf1.format(date);
        System.out.println(format1);
        System.out.println(sdf1.parse("2022.01.07 AD 12:16:47 PM"));

        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        Date date2 = sdf2.parse("2020-09-08");
        java.sql.Date date1 = new java.sql.Date(date2.getTime());
        System.out.println(date1);
    }

    @Test
    public void testCalendar(){
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getClass());
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH));
        System.out.println(calendar.get(Calendar.MONTH));

        Date date = calendar.getTime();
        System.out.println(date);
        calendar.setTime(new Date());
    }

    @Test
    public void test1(){
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        LocalDateTime localDateTime1 = LocalDateTime.of(2022, 10, 6, 13, 23, 43);
        System.out.println(localDateTime1);

        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getMonth());
        System.out.println(localDateTime.getMonthValue());
        System.out.println(localDateTime.getMinute());

        System.out.println("---------------");
        LocalDate localDate1 = localDate.withDayOfMonth(12);
        System.out.println(localDate);
        System.out.println(localDate1);

        LocalDateTime localDateTime2 = localDateTime.withHour(4);
        System.out.println(localDateTime2);
        LocalDateTime localDateTime3 = localDateTime.plusMonths(3);
        System.out.println(localDateTime3);
        LocalDateTime localDateTime4 = localDateTime.minusDays(7);
        System.out.println(localDateTime4);
    }

    @Test
    public void test2(){
        Instant instant = Instant.now();
        System.out.println(instant);
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);
        System.out.println(instant.toEpochMilli());
        System.out.println(Instant.ofEpochMilli(1641536942463L));;
    }

    @Test
    public void test3(){
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime localDateTime = LocalDateTime.now();
        String str1 = formatter.format(localDateTime);
        System.out.println(localDateTime);
        System.out.println(str1);
        TemporalAccessor parse = formatter.parse(str1);
        System.out.println(parse);
        System.out.println("-----------");
        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG).withZone(ZoneId.systemDefault());
        localDateTime = LocalDateTime.now();
        String str2 = formatter1.format(localDateTime);
        System.out.println(str2);

        System.out.println("----------------");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy:MM:dd hh:mm:ss");
        String str3 = formatter2.format(LocalDateTime.now());
        System.out.println(str3);
        System.out.println(formatter2.parse(str3));

    }
}
