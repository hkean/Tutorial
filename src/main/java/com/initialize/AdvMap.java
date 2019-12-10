package com.initialize;

import java.util.HashMap;
import java.util.Map;

import com.model.Demo;

public class AdvMap {
	public static void main(String arg[]) {
		new AdvMap();
	}

	private AdvMap() {
		Map<Object, Integer> m = new HashMap<>();
		Demo a = new Demo(1, "1", true);
		Demo b = new Demo(2, "2", true);
		Demo c = new Demo(2, "2", false);

		m.put(a, 1);
		System.out.println(m.get(new Demo(1, "1", true)));
		System.out.println(m.get(a));
		Demo d = a;
		System.out.println(m.get(d));
		m.put(b, 2);
		m.put(c, 3);

		m.forEach((k, v) -> System.out.println(k + " : " + v));

//		Map<Demo, Integer> m2 = new HashMap<>();
		m.put(Demo.class, 1);
		System.out.println(m.get(Demo.class));
		Object e = new Demo();
		System.out.println(m.get(e));
		System.out.println(m.get(e.getClass()));

	}
}
