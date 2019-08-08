package com.model;

import java.util.Objects;

import lombok.Getter;
import lombok.Setter;

import com.google.common.base.MoreObjects;

@Getter
@Setter
public class Emp {

	private Byte a;
	private Integer b;
	private Long id;

	@Override
	public int hashCode() {
		if (null != this.id)
			return Objects.hash(this.id);

		return Objects.hash(this.id, this.a, this.b);
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

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("id", this.id).add("a", this.a).add("b", this.b).toString();
	}
}
