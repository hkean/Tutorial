package com.github.tutorial.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import com.github.tutorial.model.Demo;

public class ComparatorMain {

	List<Demo> al = new ArrayList<Demo>();

	public static void main(String[] args) {
		new ComparatorMain();
	}

	public ComparatorMain() {
		nonGeneric();

		al.add(new Demo(101, "Vijay", false));
		al.add(new Demo(106, "Ajay", false));
		al.add(new Demo(105, "Jai", false));

		generic();
		newComparator();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	void nonGeneric() {
		ArrayList al = new ArrayList();
		al.add(new Demo(101, "Vijay", false));
		al.add(new Demo(106, "Ajay", false));
		al.add(new Demo(105, "Jai", false));

		System.out.println("Sorting by Name");

		Collections.sort(al, new NameComparatorNonGeneric());
		Iterator itr = al.iterator();
		while (itr.hasNext()) {
			Demo st = (Demo) itr.next();
			System.out.println(st.name + " " + st.id);
		}

		System.out.println("Sorting by id");

		Collections.sort(al, new IdComparatorNonGeneric());
		Iterator itr2 = al.iterator();
		while (itr2.hasNext()) {
			Demo st = (Demo) itr2.next();
			System.out.println(st.name + " " + st.id);
		}
	}

	void generic() {

		System.out.println("Sorting by Name");

		Collections.sort(al, new NameComparatorGeneric());
		for (Demo st : al) {
			System.out.println(st.name + " " + st.id);
		}

		System.out.println("Sorting by id");

		Collections.sort(al, new IdComparatorGeneric());
		for (Demo st : al) {
			System.out.println(st.name + " " + st.id);
		}
	}

	void newComparator() {
		Collections.sort(al, new Comparator<Demo>() {
			@Override
			public int compare(Demo arg0, Demo arg1) {
				return arg0.getId() - arg1.getId();
			}
		});

		System.out.println("After Sorting By Id - Ascending Order");
		al.stream().forEach(System.out::println);

		Collections.sort(al, new Comparator<Demo>() {
			@Override
			public int compare(Demo arg0, Demo arg1) {
				return arg1.getId() - arg0.getId();
			}
		});

		System.out.println("After Sorting By Id - Descending Order");
		al.stream().forEach(System.out::println);
	}
}
