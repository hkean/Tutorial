package com.github.tutorial.challenge.sns;

import java.util.Collections;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.github.tutorial.model.Person;

public class SnsMain {

	public static List<Person> dataSource = new ArrayList<Person>();

	public static void main(String[] args) {
		new SnsMain();
	}

	public SnsMain() {
//		initialize();
//		init2();
		init3();
		init4();
	}
	
	private void init4() {
		List<String> adam = new ArrayList<>(Arrays.asList("adam", "baba", "candy", "dave"));
		List<String> baba = new ArrayList<>(Arrays.asList("baba", "candy"));
		List<String> candy = new ArrayList<>(Arrays.asList("candy", "adam", "baba"));
		List<String> dave = new ArrayList<>(Arrays.asList("dave"));
		List<List<String>> alist = Arrays.asList(adam, baba, candy, dave);
		
		Map<String, List<String>> result = new HashMap<>();
		for (int i = 0; i < alist.size(); i++) {
			result.put(alist.get(i).get(0), new ArrayList<>());
		}

		String followers = "";
		// add for all the followers
		for (int i = 0; i < alist.size(); i++) { // loop the list 
			followers = alist.get(i).get(0);
			for (int j = 1; j < alist.get(i).size(); j++) { // loop the following name
				result.get(alist.get(i).get(j)).add(followers);
			}
		}
		
		result.forEach((k,v) -> System.out.println(k+":"+v)); 
	}

	@SuppressWarnings("unused")
	private void init3() {
		List<String> adam = new ArrayList<>(Arrays.asList("adam", "baba", "candy", "dave"));
		List<String> baba = new ArrayList<>(Arrays.asList("baba", "candy"));
		List<String> candy = new ArrayList<>(Arrays.asList("candy", "adam", "baba"));
		List<String> dave = new ArrayList<>(Arrays.asList("dave"));
		List<List<String>> alist = Arrays.asList(adam, baba, candy, dave);

		List<List<String>> result = new ArrayList<>();
		List<String> tmp;
		// set all the naming first
		for (int i = 0; i < alist.size(); i++) {
			tmp = new ArrayList<>();
			tmp.add(alist.get(i).get(0));
			result.add(tmp);

		}

//		System.out.println(result.toString());

		String followers = "";
		// add for all the followers
		for (int i = 0; i < alist.size(); i++) { // loop the list 
			followers = alist.get(i).get(0);
			for (int j = 1; j < alist.get(i).size(); j++) { // loop the following name
				for (int k = 0; k < alist.size(); k++) {
						if (alist.get(i).get(j).equalsIgnoreCase(result.get(k).get(0))) {
							result.get(k).add(followers);
							break;
						}
				}
			}
		}

		System.out.println(result.toString());

	}

	@SuppressWarnings("unused")
	private void init2() {
		List<List<String>> alist = new ArrayList<>();
		alist.add(Arrays.asList("a", "b", "c", "d", "e"));
		alist.add(Arrays.asList("b", "a", "e"));
		alist.add(Arrays.asList("c", "d", "e"));
		alist.add(Arrays.asList("d", "a", "b", "e"));
		alist.add(Arrays.asList("e"));

		String name = "e";
		System.out.println(name + " has followers of " + Util.getListFollowersOf(name, alist));
		System.out.println(name + " is following " + Util.getListOfFollowing(name, alist));
	}

	private void save(List<Person> dataSource, Person... person) {
		Collections.addAll(dataSource, person);
	}

	@SuppressWarnings("unused")
	private void initialize() {

		Person a = new Person(1L, "A");
		Person b = new Person(2L, "B");
		Person c = new Person(3L, "C");

		save(dataSource, a, b, c);

		Util.follow(a, b);
		Util.follow(a, c);
		Util.follow(b, c);
//		System.out.println(dataSource);

//		Util.unfollow(a, b);
//		Util.unfollow(a, b);
//		System.out.println(dataSource);

		Util.getFollowers(a);
		Util.getFollowers(b);
		Util.getFollowers(c);

		Util.getFollowing(a);
		Util.getFollowing(b);
		Util.getFollowing(c);
	}

}
