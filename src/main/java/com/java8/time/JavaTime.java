package com.java8.time;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class JavaTime {

	public static void main(String[] args) {
		Date date = new Date();
		System.out.println("date: " + date);

		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("ft date: " + ft.format(date));

//		Date date2 = new Date(120, 0, 4);
//		System.out.println("date2: " + date2);

		Calendar calendar = Calendar.getInstance();
		calendar.set(2020, 0, 4, 00, 00, 00);
		Date date3 = calendar.getTime();
		System.out.println("date3: " + date3);

		LocalDate date4 = LocalDate.now();
		System.out.println("date4: " + date4);

		System.out.println("from date4: " + Date.from(date4.atStartOfDay(ZoneId.systemDefault()).toInstant()));

		System.out.println("sql date4: " + java.sql.Date.valueOf(date4));
	}

}
