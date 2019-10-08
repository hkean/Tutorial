package com.compare;

import java.util.Comparator;

import com.model.Demo;

// basic logic of a sort, 1, 2, 3
// return negative mean don't sort
// return positive mean sort it
// eg: o1=1, o2=2 -> 1 - 2 = -1, which mean the order is correct, no need sort, o1, o2 -> 1, 2 
// eg: o1=2, o2=1 -> 2 - 1 = 1, which mean the order is incorrect, need sort, o2, o1 -> 1, 2
// but let's say we want to make it desc
// eg: o1=1, o2=2 -> 2 - 1 = 1, which mean the order is incorrect, need sort, o2, o1 -> 2, 1 
// eg: o1=2, o2=1 -> 1 - 2 = -1, which mean the order is correct, no need sort, o1, o2 -> 2, 1

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
