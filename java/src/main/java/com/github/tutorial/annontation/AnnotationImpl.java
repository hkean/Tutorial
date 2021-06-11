package com.github.tutorial.annontation;

import com.github.tutorial.exception.MyException;

public class AnnotationImpl {

	// "@MyAnnotation" is not available at runtime and
	// cannot be seen with reflection.
	public void check(Object object) {
		Class<?> clazz = object.getClass();
		if (!clazz.isAnnotationPresent(MyAnnotation.class)) {
			throw new MyException("Just some random exception");
		}
	}

}
