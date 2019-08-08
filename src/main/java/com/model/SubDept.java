package com.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
public class SubDept extends Dept {
	
	private String subName;
	
}
