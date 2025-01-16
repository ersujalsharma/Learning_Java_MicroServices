package assignment5.localdate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class PracticeDates {
    public static void main(String[] args) {
        // local date
        LocalDate todayDate = LocalDate.now();
        System.out.println("Today's date: " + todayDate);
        LocalDate examDate = LocalDate.of(2014, 12, 29);
        System.out.println("Exam date: " + examDate);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy");
        // print formatted date
        System.out.println("Formatted date: " + examDate.format(formatter));
        System.out.println("Formatted date: " + formatter.format(examDate));

        LocalDate newDate = LocalDate.now();
        System.out.println("New date: " + newDate);
        // add 1 month to the date
        newDate = newDate.plusMonths(1);
        System.out.println("New date after adding 1 month: " + newDate);
        // subtract 1 month from the date
        newDate = newDate.minusMonths(1);
        System.out.println("New date after subtracting 1 month: " + newDate);
        // add 1 year to the date
        newDate = newDate.plusYears(1);
        System.out.println("New date after adding 1 year: " + newDate);
        // subtract 1 year from the date
        newDate = newDate.minusYears(1);
        System.out.println("New date after subtracting 1 year: " + newDate);
        // add 1 week to the date
        newDate = newDate.plusWeeks(1);
        System.out.println("New date after adding 1 week: " + newDate);
        // subtract 1 week from the date
        newDate = newDate.minusWeeks(1);
        System.out.println("New date after subtracting 1 week: " + newDate);
        // add 1 day to the date
        newDate = newDate.plusDays(1);
        System.out.println("New date after adding 1 day: " + newDate);
        // subtract 1 day from the date
        newDate = newDate.minusDays(1);
        System.out.println("New date after subtracting 1 day: " + newDate);
        // check if the date is before today
        System.out.println("Is the date before today? " + newDate.isBefore(todayDate));
        // check if the date is after today
        System.out.println("Is the date after today? " + newDate.isAfter(todayDate));
        // check if the date is equal to today
        System.out.println("Is the date equal to today? " + newDate.isEqual(todayDate));
        // check if the date is leap year
        System.out.println("Is the date a leap year? " + newDate.isLeapYear());
        int val = newDate.compareTo(todayDate);
        if (val > 0) {
            System.out.println("The date is after today");
        } else if (val < 0) {
            System.out.println("The date is before today");
        } else {
            System.out.println("The date is today");
        }
        // ChronoUnit
        LocalDate date1 = LocalDate.of(2014, 12, 29);
        // days between two dates
        long val2 = ChronoUnit.DAYS.between(date1, todayDate);
        long val3 = ChronoUnit.DAYS.between(todayDate, date1);

        System.out.println(val2+ " " + val3);
        // months between two dates
        long val4 = ChronoUnit.MONTHS.between(date1, todayDate);
        long val5 = ChronoUnit.MONTHS.between(todayDate, date1);
        System.out.println(val4+ " " + val5);
        // years between two dates
        long val6 = ChronoUnit.YEARS.between(date1, todayDate);
        long val7 = ChronoUnit.YEARS.between(todayDate, date1);
        System.out.println(val6+ " " + val7);
        // weeks between two dates
        long val8 = ChronoUnit.WEEKS.between(date1, todayDate);
        long val9 = ChronoUnit.WEEKS.between(todayDate, date1);
        System.out.println(val8+ " " + val9);
        // hours between two dates
        long val10 = ChronoUnit.HOURS.between(date1, todayDate);
        long val11 = ChronoUnit.HOURS.between(todayDate, date1);
        System.out.println(val10+ " " + val11);
        // minutes between two dates
//        long val12 = ChronoUnit.MINUTES.between(date1, todayDate);
//        long val13 = ChronoUnit.MINUTES.between(todayDate, date1);
//        System.out.println(val12+ " " + val13);
        // seconds between two dates
//        long val14 = ChronoUnit.SECONDS.between(date1, todayDate);
//        long val15 = ChronoUnit.SECONDS.between(todayDate, date1);
//        System.out.println(val14+ " " + val15);
        // nanoseconds between two dates
//        long val16 = ChronoUnit.NANOS.between(date1, todayDate);
//        long val17 = ChronoUnit.NANOS.between(todayDate, date1);
//        System.out.println(val16+ " " + val17);
        // adding days to the date
        long val18 = date1.plus(1, ChronoUnit.DAYS).getDayOfMonth();
        System.out.println(val18);
        // adding months to the date
        long val19 = date1.plus(1, ChronoUnit.MONTHS).getMonthValue();
        System.out.println(val19);
        // adding years to the date
        long val20 = date1.plus(1, ChronoUnit.YEARS).getYear();
        System.out.println(val20);
        // adding weeks to the date
        long val21 = date1.plus(1, ChronoUnit.WEEKS).getDayOfMonth();
        System.out.println(val21);

    }
}
