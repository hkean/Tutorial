package com.github.tutorial.compare;

import java.util.Comparator;

import com.github.tutorial.model.Demo;

public class NameComparatorGeneric implements Comparator<Demo> {
	public int compare(Demo s1, Demo s2) {
		return s1.name.compareTo(s2.name);
	}
}
