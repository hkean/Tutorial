package com.compare;

import java.util.Comparator;

import com.model.Demo;

public class IdComparatorGeneric implements Comparator<Demo> {
	public int compare(Demo s1, Demo s2) {
		if (s1.id == s2.id)
			return 0;
		else if (s1.id > s2.id)
			return 1;
		else
			return -1;
	}

}
