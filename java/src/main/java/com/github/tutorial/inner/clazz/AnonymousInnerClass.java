package com.github.tutorial.inner.clazz;

interface AnonymousAnimal {
	void type();
}

public class AnonymousInnerClass {
	public static void main(String args[]) {
		AnonymousAnimal animal = new AnonymousAnimal() {
			public void type() {
				System.out.println("Anonymous Anteater");
				System.out.println("Anonymous Unicorn");
				System.out.println("Anonymous Capybara");
				System.out.println("Anonymous Beaver");
			}
		};
		animal.type();
	}
}
