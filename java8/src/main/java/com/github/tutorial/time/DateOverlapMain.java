package com.github.tutorial.time;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

// https://stackoverflow.com/questions/17106670/how-to-check-a-timeperiod-is-overlapping-another-time-period-in-java

public class DateOverlapMain {

	public static void main(String[] args) {
		new DateOverlapMain();
	}

	private DateOverlapMain() {
		LocalTime startA = LocalTime.of(10, 0);
		LocalTime stopA = LocalTime.of(10, 30);

		LocalTime startB = LocalTime.of(11, 0);
		LocalTime stopB = LocalTime.of(12, 0);

//		System.out.println(checkOverlap(startA, stopA, startB, stopB));

		LocalTime startC = LocalTime.of(12, 30);
		LocalTime stopC = LocalTime.of(13, 30);

		LocalTime startD = LocalTime.of(8, 30);
//		LocalTime stopD = LocalTime.of(9, 30);
		LocalTime stopD = LocalTime.of(10, 00);

		List<LocalTime> dateList1 = Arrays.asList(startA, stopA);
		List<LocalTime> dateList2 = Arrays.asList(startB, stopB);
		List<LocalTime> dateList3 = Arrays.asList(startC, stopC);
		List<LocalTime> dateList4 = Arrays.asList(startD, stopD);
		List<List<LocalTime>> list = Arrays.asList(dateList1, dateList2, dateList3, dateList4);

		System.out.println("final result: " + runLogic(list));

	}

	private Boolean checkOverlap(LocalTime startA, LocalTime stopA, LocalTime startB, LocalTime stopB) {
		if ((startA.isBefore(stopB)) && (stopA.isAfter(startB))) {
			return true;
		}
		return false;
	}

//	private Boolean checkOverlap(Date startA, Date stopA, Date startB, Date stopB) {
//		if ((startA.before(stopB)) && (stopA.after(startB))) {
//			return true;
//		}
//		return false;
//	}
//
//	private Boolean checkOverlapDate(Date startA, Date stopA, Date startB, Date stopB) {
//		if ((startA.getTime() <= stopB.getTime()) && (stopA.getTime() >= startB.getTime())) {
//			return true;
//		}
//		return false;
//	}

	/*
	 * 0-1, 0-2 1-2
	 */
	private Boolean runLogic(List<List<LocalTime>> list) {
		Boolean result = false;
		if (1 < list.size()) {
			for (int i = 0; i < list.size() - 1; i++) {
				for (int j = i + 1; j < list.size(); j++) {
					LocalTime tmpStartA = list.get(i).get(0);
					LocalTime tmpStopA = list.get(i).get(1);
					LocalTime tmpStartB = list.get(j).get(0);
					LocalTime tmpStopB = list.get(j).get(1);
					result = checkOverlap(tmpStartA, tmpStopA, tmpStartB, tmpStopB);
					System.out
							.println(tmpStartA + ":" + tmpStopA + " -> " + tmpStartB + ":" + tmpStopB + " = " + result);
					if (result) {
						return true;
					}
				}
			}
		}
		return result;
	}

	// trying to generalize
	// failure
	@SuppressWarnings(value = { "unused" })
	private <T extends Date> Boolean run(List<List<T>> list) {
		Boolean result = false;
		if (1 < list.size()) {
			for (int i = 0; i < list.size() - 1; i++) {
				for (int j = i + 1; j < list.size(); j++) {
					T tmpStartA = list.get(i).get(0);
					T tmpStopA = list.get(i).get(1);
					T tmpStartB = list.get(j).get(0);
					T tmpStopB = list.get(j).get(1);
					result = checkOverlapT(tmpStartA, tmpStopA, tmpStartB, tmpStopB);
					System.out
							.println(tmpStartA + ":" + tmpStopA + " -> " + tmpStartB + ":" + tmpStopB + " = " + result);
					if (result) {
						return true;
					}
				}
			}
		}
		return false;
	}

	private <T> Boolean checkOverlapT(T startA, T stopA, T startB, T stopB) {
		if (startA instanceof Date) {
//			checkOverlapDate(startA, stopA, startB, stopB);
		}
		return null;
	}
}
