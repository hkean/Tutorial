package com.github.tutorial.incomplete;

import java.lang.reflect.Method;

public class ClassGetMethodTest {

	public ClassGetMethodTest(Class <?> Clazz) {
		Method[] listAllMethod = Clazz.getMethods();
		
		for (Method methodName : listAllMethod) {
			System.out.println(methodName.getName());
		}
	}
}
