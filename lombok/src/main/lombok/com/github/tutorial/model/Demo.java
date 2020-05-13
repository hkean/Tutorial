package com.github.tutorial.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Demo implements Comparable<Demo>, Cloneable {

	public Integer id;
	public String name;
	Boolean active;

	@Override
	public int compareTo(Demo d) {
		return this.id - d.id;
	}
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();	// return shallow copy
	}
	// a way to check all
//	@Override
//	public int compareTo(Demo d) {
//		int result = this.id.compareTo(d.id);
//		if (result == 0) {
//			result = this.name.compareTo(d.name);
//		}
//		if (result == 0) {
//			result = this.active.compareTo(d.active);
//		}
//		return result;
//	}
}