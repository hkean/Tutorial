package com.github.tutorial.model.builder;

import java.util.Set;

import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.ToString;

// https://www.baeldung.com/lombok-builder // basic knowledge
// https://stackoverflow.com/questions/36909672/how-to-use-lombok-builder-annotation-on-methods // how to call
// https://stackoverflow.com/questions/29885428/required-arguments-with-a-lombok-builder // required + optional
	
@Getter
@Builder(toBuilder = true, builderMethodName = "hiddenBuilder")
@ToString
public class Widget {

	private String name;
	private int id;
	@Singular private Set<String> apps;

	public static WidgetBuilder builder(String name) {
        return hiddenBuilder().name(name);
    }
	
}