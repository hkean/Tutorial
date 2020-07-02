package com.github.tutorial.pattern.builder;

import com.github.tutorial.model.builder.Widget;

// https://howtodoinjava.com/design-patterns/creational/builder-pattern-in-java/
	
public class BuilderMain {
	public static void main(String[] args) {
		User user1 = new User.UserBuilder("Lokesh", "Gupta")
				.age(30).phone("1234567")
				.address("Fake address 1234")
				.build();

		System.out.println(user1);

		User user2 = new User.UserBuilder("Jack", "Reacher")
				.age(40)
				.phone("5655")
				// no address
				.build();

		System.out.println(user2);

		User user3 = new User.UserBuilder("Super", "Man")
				// No age
				// No phone
				// no address
				.build();

		System.out.println(user3);
		
		Widget widget1 = Widget.builder("New Name")
				.id(1)
				.build();
		
		System.out.println(widget1);
		
		Widget widget2 = Widget.builder("with singular")
				.app("app1")
				.app("app2")
				.build();
		
		System.out.println(widget2);
	}
}
