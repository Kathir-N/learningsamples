package com.example.stringbased;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import io.micrometer.common.util.StringUtils;

public class StringBased {
    public static void main(String[] args) {

        String s = "Programming";

        // Count occurrences of each character
        System.out.println("Character Frequency Count:");
        Map<Character, Long> charCountMap = s.toLowerCase().chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        charCountMap.forEach((k, v) -> System.out.println(k + " : " + v));

        // Find non-repeating characters
        System.out.println("Non-Repeating Characters:");
        List<Character> nonRepeatingChars = s.toLowerCase().chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(z -> z.getValue() == 1).map(Map.Entry::getKey).collect(Collectors.toList());
        System.out.println(nonRepeatingChars);

        List<String> names = Arrays.asList("Alice", "Ecila", "Bob", "Charlie", "boB", "Charlie");

        // Find names that have a reversed equivalent
        System.out.println("Names with Reverse Matching:");
        Set<String> nameSet = new HashSet<>(names); // Optimized lookup
        List<String> reverseMatchingNames = names.stream()
                .filter(name -> nameSet.contains(new StringBuilder(name).reverse().toString()))
                .distinct()
                .collect(Collectors.toList());
        System.out.println(reverseMatchingNames);

        // Filter map entries that start with 's' ignoring blank values
        System.out.println("Filtered Map Entries (Keys start with 's'):");
        HashMap<String, String> nameMap = new HashMap<>();
        nameMap.put("Senthi", "String");
        nameMap.put("suresh", "String2");
        nameMap.put(null, "String3");
        nameMap.put("", "String5");
        nameMap.put(" ", "String6");
        nameMap.put("Kathi", "String7");

        nameMap.entrySet().stream()
                .filter(entry -> !StringUtils.isBlank(entry.getKey()) && entry.getKey().toLowerCase().startsWith("s"))
                .forEach(System.out::println);
    }
}
