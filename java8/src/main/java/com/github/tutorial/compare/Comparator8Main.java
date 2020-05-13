package com.github.tutorial.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.github.tutorial.model.Demo;

public class Comparator8Main {

	List<Demo> al = new ArrayList<Demo>();

	public static void main(String[] args) {
		new Comparator8Main();
	}

	Comparator8Main() {
		basic();

		al.add(new Demo(101, "Vijay", false));
		al.add(new Demo(106, "Ajay", false));
		al.add(new Demo(105, null, false));

		nullsFirstNullsLast();
		withoutCollectionsSort();
		lambda();
		stream();
	}

	void basic() {
		ArrayList<Demo> al = new ArrayList<Demo>();
		al.add(new Demo(101, "Vijay", false));
		al.add(new Demo(106, "Ajay", false));
		al.add(new Demo(105, "Jai", false));

		// Sorting elements on the basis of name
		Comparator<Demo> cm1 = Comparator.comparing(Demo::getName);
		Collections.sort(al, cm1);
		System.out.println("Sorting by Name");
		for (Demo st : al) {
			System.out.println(st.name + " " + st.id);
		}

		// Sorting elements on the basis of age
		Comparator<Demo> cm2 = Comparator.comparing(Demo::getId);
		Collections.sort(al, cm2);
		System.out.println("Sorting by Age");
		for (Demo st : al) {
			System.out.println(st.name + " " + st.id);
		}
	}

	void nullsFirstNullsLast() {

		Comparator<Demo> cm1 = Comparator.comparing(Demo::getName, Comparator.nullsFirst(String::compareTo));
		Collections.sort(al, cm1);
		System.out.println("Considers null to be less than non-null");

		for (Demo st : al) {
			System.out.println(st.name + " " + st.id);
		}

		Comparator<Demo> cm2 = Comparator.comparing(Demo::getName, Comparator.nullsLast(String::compareTo));
		Collections.sort(al, cm2);
		System.out.println("Considers null to be greater than non-null");

		for (Demo st : al) {
			System.out.println(st.name + " " + st.id);
		}
	}

	void withoutCollectionsSort() {
		al.sort(new Comparator<Demo>() {
			@Override
			public int compare(Demo arg0, Demo arg1) {
				return arg0.getId() - arg1.getId();
			}
		});
	}

	void lambda() {
		al.sort((p1, p2) -> p1.getId() - p2.getId());

		System.out.println("After Sorting By Id - Ascending Order - Using Lambda Expression");
		al.stream().forEach(System.out::println);

		Comparator<Demo> demoSortDesc = (p1, p2) -> p2.getId() - p1.getId();
		al.sort(demoSortDesc);

		System.out.println("After Sorting By Id - Descending Order - Using Lambda Expression");
		al.stream().forEach(System.out::println);

		Comparator<Demo> demoSortDescReversed = (p1, p2) -> p1.getId() - p2.getId();
		al.sort(demoSortDescReversed.reversed());

		System.out.println("After Sorting By Id - Descending Order - Using Lambda Expression and reversed");
		al.stream().forEach(System.out::println);
	}

	void stream() {
		List<Demo> demoSort = al.stream().sorted((p1, p2) -> p1.getId() - p2.getId()).collect(Collectors.toList());

		System.out.println("After Sorting By Id");
		demoSort.stream().forEach(System.out::println);

		List<Demo> demoSortDesc = al.stream().sorted((p1, p2) -> -p1.getId() - p2.getId()).collect(Collectors.toList());

		System.out.println("After Sorting By Id - Descending");
		demoSortDesc.stream().forEach(System.out::println);

		Comparator<Demo> comparator = (p1, p2) -> p1.getName().compareTo(p2.getName());
		List<Demo> demoNameSort = al.stream().sorted(comparator.reversed()).collect(Collectors.toList());

		System.out.println("After Sorting By Name - Ascending");
		demoNameSort.stream().forEach(System.out::println);
	}
}
