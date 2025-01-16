package assignment5.localdate;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Excercise_1 {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        System.out.println("Today's date: " + date);
        String input = "14/9/2000";
        LocalDate birthDate = LocalDate.parse(input, DateTimeFormatter.ofPattern("d/M/yyyy"));
        System.out.println("Birth date: " + birthDate);
//        long years = ChronoUnit.YEARS.between(birthDate, date);
//        long months = ChronoUnit.MONTHS.between(birthDate, date)%12;
//        long days = ChronoUnit.DAYS.between(birthDate, date)%30;
//        System.out.println("You are " + years + " years, " + months + " months and " + days + " days old.");
        // generate logic for age calculator from birth date
        long years = ChronoUnit.YEARS.between(birthDate, date);
        long years2 = Period.between(birthDate, date).getYears();
        long months = ChronoUnit.MONTHS.between(birthDate, date)%12;
        long months2 = Period.between(birthDate, date).getMonths();
        long days = ChronoUnit.DAYS.between(birthDate, date)%30;
        long days2 = Period.between(birthDate, date).getDays();
        System.out.println(Period.between(birthDate, date));
        System.out.println("You are " + years + " years, " + months + " months and " + days + " days old.");
        System.out.println("You are " + years2 + " years, " + months2 + " months and " + days2 + " days old.");
    }
}
