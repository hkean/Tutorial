package com.github.tutorial.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
@ToString(callSuper = true)
public class SubDept extends Dept {
	
	private String subName;

}
