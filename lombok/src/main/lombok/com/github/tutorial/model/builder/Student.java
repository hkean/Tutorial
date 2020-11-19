package com.github.tutorial.model.builder;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder(toBuilder = true)
@ToString
public class Student { // extends Person { // next time test on inheritance builder	
	private Long id;
	private String name;
}
