package com.github.tutorial.time;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
import java.util.Date;
import java.util.Locale;

// https://stackoverflow.com/questions/33066904/localdate-to-java-util-date-and-vice-versa-simplest-conversion

public class Java8Time {

	String patternTime = "yyyy-MM-dd HH:mm:ss.SSSZ"; // LocalDate doesnt have time, if want, then use LocalDateTime
	DateTimeFormatter datTime = DateTimeFormatter.ofPattern(patternTime);
	String pattern = "yyyy-MM-dd";
	DateTimeFormatter dat = DateTimeFormatter.ofPattern(pattern);

	Java8Time() {
		LocalDate date1 = LocalDate.now();
		System.out.println(date1.format(dat));
		System.out.println(date1.getDayOfMonth() + " " + date1.getMonthValue() + " " + date1.getYear());

		LocalDate tomorrow = date1.plusDays(1);
		System.out.println(tomorrow.format(dat) + " : " + tomorrow);

		LocalDate date2 = LocalDate.of(2002, Month.JULY, 21);
		System.out.println(date2.format(dat));

		LocalDate todayKolkata = LocalDate.now(ZoneId.of("Asia/Kolkata")); 
		System.out.println("Current Date in IST=" + todayKolkata);

		LocalDate hundredDay2014 = LocalDate.ofYearDay(2014, 100);
		System.out.println("100th day of 2014=" + hundredDay2014);

		Date oldDate = new Date();
		LocalDate date3 = oldDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		System.out.println(date3.format(dat));

		LocalTime specificTime = LocalTime.of(12, 20, 25, 40);
		System.out.println("Specific Time of Day=" + specificTime);

		LocalDateTime date4 = LocalDateTime.of(LocalDate.now(), LocalTime.now());
		System.out.println("Current DateTime=" + date4);
		System.out.println(date4.format(DateTimeFormatter.BASIC_ISO_DATE));

		Instant timestamp = Instant.now();
		System.out.println("Current Timestamp = " + timestamp);

		LocalDate date5 = LocalDate.of(2020, Month.DECEMBER, 2);
		System.out.println("weekOfYear: " + date5.get(WeekFields.of(Locale.getDefault()).weekOfYear()));
		System.out.println("getDayOfYear: " + date5.getDayOfYear());

	}

	public int calculateYears(LocalDate birthDate, LocalDate currentDate) {
		if ((birthDate != null) && (currentDate != null)) {
			return Period.between(birthDate, currentDate).getYears();
		} else {
			return 0;
		}
	}

	public int calculateMonth(LocalDate birthDate, LocalDate currentDate) {
		if ((birthDate != null) && (currentDate != null)) {
			return Period.between(birthDate, currentDate).getMonths();
		} else {
			return 0;
		}
	}

	public int calculateDay(LocalDate birthDate, LocalDate currentDate) {
		if ((birthDate != null) && (currentDate != null)) {
			return Period.between(birthDate, currentDate).getDays();
		} else {
			return 0;
		}
	}

	public static void main(String[] args) {
		new Java8Time();
	}
}
