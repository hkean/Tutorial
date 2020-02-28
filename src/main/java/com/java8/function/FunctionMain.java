package com.java8.function;

import java.util.function.Function;

import com.model.Demo;

public interface FunctionMain {

	Function<Demo, String> DEMO_TO_NAME_FUNC = new Function<Demo, String>() {
		@Override
		public String apply(Demo arg0) {
			return arg0.getName();
		}
	};

}
