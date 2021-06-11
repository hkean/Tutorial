package com.github.tutorial.model;

import java.io.Serializable;
import java.util.Collection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class Demo implements Comparable<Demo>, Cloneable, Serializable {

	@NonNull
	public Integer id;
	
	@NonNull
	public String name;
	
	@NonNull
	Boolean active;

	boolean standardBoolean;
	
	public Collection<Long> childs;

	@Override
	public int compareTo(Demo d) {
		return this.id - d.id;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone(); // return shallow copy
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
