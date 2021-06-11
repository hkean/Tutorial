package com.github.tutorial.time;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

// https://stackoverflow.com/a/34723186/12056899

public class JavaTime {
	static SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	static DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

	public static void main(String[] args) {
//		new Java8Time();
		dateCompare();
	}

	public JavaTime() {
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

		try {
			String dateStr = "2020-06-01T03:00:00.000Z";
			Date date5 = df.parse(dateStr);
			System.out.println("date: " + date5);
			System.out.println("to String: " + df.format(date5));

			System.out.println(isInBetween(ft.parse("2020-11-18 00:00:00"), ft.parse("2020-11-25 00:00:00"),
					ft.parse("2020-11-25 00:00:00")));
			System.out.println(isInBetween(ft.parse("2020-11-18 00:00:00"), ft.parse("2020-11-25 00:00:00"),
					ft.parse("2020-11-18 00:00:00")));

		} catch (ParseException e) {
			e.printStackTrace();
		}

		Calendar calendar4 = Calendar.getInstance();
		calendar4.set(2020, 0, 3);
		System.out.println("calendar4: " + calendar4.getTime() + " : " + calendar4.get(Calendar.WEEK_OF_YEAR));
		calendar4.setMinimalDaysInFirstWeek(4); // For ISO 8601
		System.out.println("calendar4: " + calendar4.getTime() + " : " + calendar4.get(Calendar.WEEK_OF_YEAR));

		Calendar calendar5 = Calendar.getInstance();
		calendar5.add(Calendar.DATE, 1);
		System.out.println("calendar5: " + calendar5.getTime());

		Calendar calendar55 = Calendar.getInstance();
		calendar55.set(Calendar.HOUR_OF_DAY, 0);
		calendar55.set(Calendar.MINUTE, 0);
		calendar55.set(Calendar.SECOND, 0);
		calendar55.set(Calendar.MILLISECOND, 0);
		Calendar calendar56 = (Calendar) calendar55.clone();
		calendar56.add(Calendar.DATE, 7);
		calendar56.add(Calendar.MILLISECOND, -1);
		System.out.println("calendar55: " + calendar55.getTime() + " calendar56: " + calendar56.getTime());
		
		Calendar calendar6 = Calendar.getInstance();
		calendar6.set(2020, 2, 28);
		System.out.println("calendar6: " + calendar6.getActualMaximum(Calendar.DATE) + " : " + calendar6.get(Calendar.DAY_OF_MONTH));
	}
	
	@SuppressWarnings("unused")
	private static void dateCompare() {
		Calendar cal1 = Calendar.getInstance();
		Date date1 = cal1.getTime();
		Calendar cal2 = Calendar.getInstance();
		cal2.set(Calendar.SECOND, 0);
		Date date2 = cal2.getTime();
		
		System.out.println(date1.equals(date2));
		System.out.println(date1.after(date2));
		System.out.println(date1.before(date2));
		System.out.println(date1.compareTo(date2));
	}
	
	// check in between
	// https://stackoverflow.com/questions/883060/how-can-i-determine-if-a-date-is-between-two-dates-in-java
	public static Boolean isInBetween(Date min, Date max, Date d) {
		return d.compareTo(min) >= 0 && d.compareTo(max) < 0;
	}
}
