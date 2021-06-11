package com.github.tutorial.async;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import com.github.tutorial.model.builder.Student;

// https://stackoverflow.com/a/24110327/12056899

public class AsyncMain {
	public static void main(String[] args) {
		System.out.println("outside: start " + new Date());
		new Thread(AsyncMain::method).start();
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
		Integer.parseInt("a");
		System.out.println("outside: end " + new Date());
	}

	public static void method() {
		Student s1 = Student.builder().id(1L).name("n1").build();
		Student s2 = Student.builder().id(2L).name("n2").build();
		Student s3 = Student.builder().id(3L).name("n3").build();
		Student s4 = Student.builder().id(4L).name("n4").build();
		Student s5 = Student.builder().id(5L).name("n5").build();
		Student s6 = Student.builder().id(6L).name("n6").build();

		Collection<Student> col = Arrays.asList(s1, s2, s3, s4, s5, s6);

		col.forEach(s -> {
			System.out.println(s);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
				Thread.currentThread().interrupt();
			}
			if (s.getId() == 5L)
				Integer.parseInt(s.getName());
		});
	}
}
