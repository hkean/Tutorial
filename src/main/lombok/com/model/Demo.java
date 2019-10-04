package com.model;

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
public class Demo implements Comparable<Demo> {

	public Integer id;
	public String name;
	Boolean active;

	@Override
	public int compareTo(Demo d) {
		return this.id - d.id;
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
