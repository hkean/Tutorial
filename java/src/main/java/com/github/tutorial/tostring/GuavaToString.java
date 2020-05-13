package com.github.tutorial.tostring;

import com.google.common.base.MoreObjects;

public class GuavaToString {
	private Integer id;
	private String desc;

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("id", this.id).add("desc", this.desc).toString();
	}
}
