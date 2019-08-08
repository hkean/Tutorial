package com.toString;
import java.util.StringJoiner;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class Java8ToString {

	private Integer id;
	private String desc;

	@Override
	public String toString() {
	    return new StringJoiner(", ", Java8ToString.class.getSimpleName() + "{", "}") 
	    .add("id=" + id)
	    .add("desc=" + desc)
	    .toString();
	}
}
