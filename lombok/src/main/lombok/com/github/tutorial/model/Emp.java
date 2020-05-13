package com.github.tutorial.model;

import java.util.Objects;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Emp {

	private Byte refPosition;
	private Integer numSalary;
	private Long empId;

	@Override
	public int hashCode() {
		if (null != this.empId)
			return Objects.hash(this.empId);

		return Objects.hash(this.empId, this.refPosition, this.numSalary);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}

		if (obj instanceof Emp) {
			Emp other = (Emp) obj;
			return Objects.equals(this.hashCode(), other.hashCode());
		}
		return false;
	}

}
