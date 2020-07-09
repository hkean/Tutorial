package com.github.tutorial.constructor;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

// https://www.geeksforgeeks.org/constructor-newinstance-method-in-java-with-examples/

public class ConstructorMain {
	public static void main(String[] args) {
		try {
			Constructor<?>[] constructor = NewConstructor.class.getConstructors();

			for (Constructor<?> cons : constructor) {
				System.out.println("parameter count: " + cons.getParameterCount());
				Class<?>[] clazz = cons.getParameterTypes();
				for (Class<?> tmp : clazz) {
					System.out.println("parameter type: " + tmp.getName());
				}
			}

			NewConstructor sampleObject0 = (NewConstructor) constructor[0].newInstance();
			System.out.println("sampleObject0: " + sampleObject0.value);

			NewConstructor sampleObject1 = (NewConstructor) constructor[1].newInstance("constructor with 1 param");
			System.out.println("sampleObject1: " + sampleObject1.value);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
