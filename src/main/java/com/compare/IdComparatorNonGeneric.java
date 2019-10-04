package com.compare;

import java.util.Comparator;

import com.model.Demo;

@SuppressWarnings("rawtypes")
public class IdComparatorNonGeneric implements Comparator {
	public int compare(Object o1, Object o2) {
		Demo s1 = (Demo) o1;
		Demo s2 = (Demo) o2;

		if (s1.id == s2.id)
			return 0;
		else if (s1.id > s2.id)
			return 1;
		else
			return -1;
	}

}
