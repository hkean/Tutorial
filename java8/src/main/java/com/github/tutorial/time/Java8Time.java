package com.github.tutorial.time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.IsoFields;
import java.time.temporal.WeekFields;
import java.util.Date;
import java.util.Locale;

// https://stackoverflow.com/questions/33066904/localdate-to-java-util-date-and-vice-versa-simplest-conversion
// read basil answer -> https://stackoverflow.com/a/40143687/12056899

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
		System.out.println("weekOfYear ISO: " + date5.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR));
		System.out.println("getDayOfYear: " + date5.getDayOfYear());

		LocalDate date6 = LocalDate.now();
		System.out.println("date6" + date6);
		System.out.println("util date6: " + Date.from(date6.atStartOfDay(ZoneId.systemDefault()).toInstant()));
		System.out.println("sql date6: " + java.sql.Date.valueOf(date6));

		LocalDate date7 = LocalDate.of(2020, Month.MARCH, 28);
		System.out.println(date7.lengthOfMonth() + " : " + date7.getDayOfMonth());

		OffsetDateTime offsetDateTime = OffsetDateTime.now();
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

	public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
		return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}

	public LocalDate convertToLocalDateViaMilisecond(Date dateToConvert) {
		return Instant.ofEpochMilli(dateToConvert.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
	}

	public LocalDate convertToLocalDateViaSqlDate(Date dateToConvert) {
		return new java.sql.Date(dateToConvert.getTime()).toLocalDate();
	}

	public LocalDateTime convertToLocalDateTimeViaSqlTimestamp(Date dateToConvert) {
		return new java.sql.Timestamp(dateToConvert.getTime()).toLocalDateTime();
	}
	
	public Date convertToDateViaSqlDate(LocalDate dateToConvert) {
	    return java.sql.Date.valueOf(dateToConvert);
	}
	
	public Date convertToDateViaInstant(LocalDate dateToConvert) {
	    return java.util.Date.from(dateToConvert.atStartOfDay()
	      .atZone(ZoneId.systemDefault())
	      .toInstant());
	}
	
	public static void main(String[] args) {
		new Java8Time();
	}

}
