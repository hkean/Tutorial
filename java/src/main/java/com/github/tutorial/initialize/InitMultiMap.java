package com.github.tutorial.initialize;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.util.Collection;

// https://www.theserverside.com/blog/Coffee-Talk-Java-News-Stories-and-Opinions/How-to-make-multiple-values-per-key-in-a-Java-map-possible

public class InitMultiMap {
    public static void main(String[] args) {

        Multimap<String, String> map = ArrayListMultimap.create();
        map.put("ford", "Mustang Mach-E");
        map.put("ford", "Pantera");

        Collection<String> values = map.get("ford");
        System.out.println(values);
    }
}
