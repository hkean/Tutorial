package com.github.tutorial.initialize;

public enum EnumList {
	A("A", "create"), B("B", "read"), C("C", "update"), D("D", "delete");

	private String model;
	private String action;

	private EnumList(String model, String action) {
		this.model = model;
		this.action = action;
	}

	public String getModel() {
		return model;
	}

	public String getId() {
		return action;
	}

	public String toString() {
		return this.model + ":" + this.action;
	}
}
