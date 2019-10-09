package com.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//import java.util.Objects;

import lombok.AllArgsConstructor;
//import lombok.Data;

@EqualsAndHashCode
//@Data
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
public class Dept {

	@NonNull
	private Long id;
	
	private String desc;
	
	private Boolean alive;
	
//	@Override
//	public int hashCode() {
//		if (null != this.id)
//			return Objects.hash(this.id);
//
//		return Objects.hash(this.id, this.desc);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj) {
//			return true;
//		}
//		if (obj == null) {
//			return false;
//		}
//
//		if (obj instanceof Dept) {
//			Dept other = (Dept) obj;
//			return Objects.equals(this.hashCode(), other.hashCode());
//		}
//		return false;
//	}
}
