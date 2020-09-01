package com.github.tutorial.stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

// https://www.baeldung.com/java-collection-remove-elements

public class StreamRemove {
	public static void main(String[] args) {
		new StreamRemove();
	}

	public StreamRemove() {
		List<Integer> col = new LinkedList<>(Arrays.asList(1, 2, 5, 10, 9));
		int value = 2;

//		withIterator(col, value);
//		collectionRemoveIf(col, value);
//		withStream(col, value); // not working, still need to re-set the reference
		col = (List<Integer>) withStream(col, value);
		
		System.out.println(col);
	}

	void withIterator(Collection<Integer> col, int value) {
		Iterator<Integer> i = col.iterator();

		while (i.hasNext()) {
			Integer e = i.next();
			if (e == value) {
				i.remove();
			}
		}
	}

	void collectionRemoveIf(Collection<Integer> col, int value) {
		col.removeIf(e -> e == value);
	}

	Collection<Integer> withStream(Collection<Integer> col, int value) {
		return col.stream().filter(e -> e != value).collect(Collectors.toList());
	}
}
