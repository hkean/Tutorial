package com.compare;

import java.util.Comparator;

import com.model.Demo;

@SuppressWarnings("rawtypes")
public class NameComparatorNonGeneric implements Comparator {
	public int compare(Object o1, Object o2) {
		Demo s1 = (Demo) o1;
		Demo s2 = (Demo) o2;

		return s1.name.compareTo(s2.name);
	}
}
