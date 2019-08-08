package com.challenge.sns;

import java.util.ArrayList;
import java.util.List;

import com.model.Person;

public class Util {

	public static void follow(Person owner, Person follow) {
		owner.getFollowing().add(follow.getId());
		follow.getFollowers().add(owner.getId());
	}

	public static void unfollow(Person owner, Person unfollow) {
//		if (!owner.getFollowing().contains(unfollow.getId()))
		owner.getFollowing().remove(unfollow.getId());
		unfollow.getFollowers().remove(owner.getId());
//		else System.out.println("Not exists!");
	}

	public static void getFollowers(Person owner) {
		if (owner.getFollowers().size() != 0) {
			System.out.print(owner.getName() + " followers [");
			for (Long tmp : owner.getFollowers()) {
				System.out.print(SnsMain.dataSource.get(tmp.intValue() - 1).getName() + " ");
			}
			System.out.print("]");
			System.out.println();
		}
	}

	public static void getFollowing(Person owner) {
		if (owner.getFollowing().size() != 0) {
			System.out.print(owner.getName() + " following [");
			for (Long tmp : owner.getFollowing()) {
				System.out.print(SnsMain.dataSource.get(tmp.intValue() - 1).getName() + " ");
			}
			System.out.print("]");
			System.out.println();
		}
	}

	public static List<String> getListFollowersOf(String name, List<List<String>> alist) {
		List<String> result = new ArrayList<>();
		for (int i = 0; i < alist.size(); i++) {
//			System.out.println(alist.get(i));
			if (alist.get(i).get(0).equalsIgnoreCase(name)) {
				for (int j = 1; j < alist.get(i).size(); j++) {
					result.add(alist.get(i).get(j));
				}
//				break;
				return result;
			}
		}
		return result;
	}

	public static List<String> getListOfFollowing(String name, List<List<String>> alist) {
		List<String> result = new ArrayList<>();
		for (int i = 0; i < alist.size(); i++) {
			List<String> tmp = alist.get(i);
			if (!tmp.get(0).equalsIgnoreCase(name) && tmp.contains(name)) {
				result.add(tmp.get(0));
			}
		}

		return result;
	}
}
