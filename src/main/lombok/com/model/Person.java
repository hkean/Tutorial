package com.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public class Person {

	public enum Sex {
		MALE, FEMALE
	}

	@NonNull
	private Long id;

	@NonNull
	private String name;

	LocalDate birthday;
	Sex gender;
	String emailAddress;

	public static int compareByAge(Person a, Person b) {
		return a.birthday.compareTo(b.birthday);
	}

	// used in com.sns
	private Set<Long> followers;
	private Set<Long> following;

	public Set<Long> getFollowers() {
		if (this.followers == null)
			this.followers = new HashSet<Long>();

		return this.followers;
	}

	public Set<Long> getFollowing() {
		if (this.following == null)
			this.following = new HashSet<Long>();

		return this.following;
	}

}
