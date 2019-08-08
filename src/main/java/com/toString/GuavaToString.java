package com.toString;
import com.google.common.base.MoreObjects;

import lombok.Data;

@Data
public class GuavaToString {

	private Integer id;
	private String desc;
	
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("id", this.id).add("desc", this.desc).toString();
	}
}
