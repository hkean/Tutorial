package com.model;

public enum LookupEnum {

	DIAGNOSIS("diagnosis"),

	EDU_ACTIVITY("edu-activities"),

	RISK_HABIT("risk-habits");

	private String path;
	private boolean hasJson;

	private LookupEnum(String path) {
		this(path, false);
	}

	private LookupEnum(String path, boolean hasJson) {
		this.path = path;
		this.hasJson = hasJson;
	}

	public static LookupEnum get(String path) {
		for (LookupEnum lookup : values()) {
			if (lookup.getPath().equals(path)) {
				return lookup;
			}
		}
		return valueOf(path);
	}

	public String getPath() {
		return path;
	}

	public boolean hasJson() {
		return hasJson;
	}
}
