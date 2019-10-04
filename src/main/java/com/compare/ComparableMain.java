package com.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.model.Demo;

public class ComparableMain {
	public static void main(String[] args) {
		new ComparableMain();
	}

	public ComparableMain() {
		List<Demo> al = new ArrayList<Demo>();
		al.add(new Demo(101, "Vijay", false));
		al.add(new Demo(106, "Ajay", false));
		al.add(new Demo(105, "Jai", false));

		Collections.sort(al);
		al.stream().forEach(System.out::println);
	}
}
