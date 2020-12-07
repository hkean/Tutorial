package com.github.tutorial.time;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class JavaTime {
	static SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	static DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

	public static void main(String[] args) {
		Date date = new Date();
		System.out.println("date: " + date);

		System.out.println("ft format date: " + ft.format(date));

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 999);
		System.out.println("calendar: " + df.format(calendar.getTime()));
		
//		Date date2 = new Date(120, 0, 4);
//		System.out.println("date2: " + date2);

		Calendar calendar3 = Calendar.getInstance();
		calendar3.set(2020, 0, 4, 00, 00, 00);
		Date date3 = calendar3.getTime();
		System.out.println("date3: " + date3);

		LocalDate date4 = LocalDate.now();
		System.out.println("date4: " + date4);

		System.out.println("util date4: " + Date.from(date4.atStartOfDay(ZoneId.systemDefault()).toInstant()));

		System.out.println("sql date4: " + java.sql.Date.valueOf(date4));

		try {
			String dateStr = "2020-06-01T03:00:00.000Z";
			Date date5 = df.parse(dateStr);
			System.out.println("date: " + date5);
			System.out.println("to String: " + df.format(date5));

			System.out.println(isInBetween(ft.parse("2020-11-18 00:00:00"), ft.parse("2020-11-25 00:00:00"), ft.parse("2020-11-25 00:00:00")));
			System.out.println(isInBetween(ft.parse("2020-11-18 00:00:00"), ft.parse("2020-11-25 00:00:00"), ft.parse("2020-11-18 00:00:00")));

		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	// check in between
	// https://stackoverflow.com/questions/883060/how-can-i-determine-if-a-date-is-between-two-dates-in-java
	private static Boolean isInBetween(Date min, Date max, Date d) {
		return d.compareTo(min) >= 0 && d.compareTo(max) < 0;
	}
}
