package com.example.stringbased;

import java.util.*;
import java.util.stream.Collectors;

public class StringArrayBased {
    public static void main(String[] args) {
        
        String[] names = {"Alice", "Bob", "Charlie", "Aravind", "Bob", "Charlies"};

        // Count names starting with 'A' (case-insensitive)
        long count = Arrays.stream(names)
                .filter(s -> s.toLowerCase().startsWith("a"))
                .count();
        System.out.println("Count of names starting with 'A': " + count);

        // Find distinct names containing 'a'
        String[] substring = Arrays.stream(names)
                .distinct()
                .filter(s -> s.contains("a"))
                .toArray(String[]::new);
        System.out.println("Distinct names containing 'a': " + Arrays.toString(substring));

        // Sort names in descending order
        String[] descendingSort = Arrays.stream(names)
                .sorted((s1, s2) -> s2.compareTo(s1))
                .toArray(String[]::new);
        System.out.println("Names sorted in descending order: " + Arrays.toString(descendingSort));

        // Sort names in ascending order
        String[] ascendingSort = Arrays.stream(names)
                .sorted(String::compareTo)
                .toArray(String[]::new);
        System.out.println("Names sorted in ascending order: " + Arrays.toString(ascendingSort));

        // Convert names to uppercase
        List<String> upperCaseNames = Arrays.stream(names)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("Uppercase names: " + upperCaseNames);

        // Find longest name
        String longestString = Arrays.stream(names)
                .max(Comparator.comparingInt(String::length))
                .orElse("No names found");
        System.out.println("Longest name: " + longestString);

        String[] sentences = {"Java is fun", "Java is powerful", "Streams were good"};

        // Find unique words from sentences
        Set<String> uniqueWords = Arrays.stream(sentences)
                .flatMap(sentence -> Arrays.stream(sentence.split("\\s+")))
                .map(String::toLowerCase)
                .collect(Collectors.toSet());
        System.out.println("Unique words from sentences: " + uniqueWords);

        // Count frequency of words in sentences
        Map<String, Long> sentenceFrequency = Arrays.stream(sentences)
                .flatMap(sentence -> Arrays.stream(sentence.split("\\s+")))
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));
        System.out.println("Word frequency in sentences: " + sentenceFrequency);

        // Find most frequent word
        Optional<String> mostFrequentWord = sentenceFrequency.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);
        System.out.println("Most frequent word: " + mostFrequentWord.orElse("No words found"));

        // Group names by first character
        Map<Character, List<String>> groupedNames = Arrays.stream(names)
                .collect(Collectors.groupingBy(name -> name.charAt(0)));
        System.out.println("Names grouped by first character: " + groupedNames);

        // Group words from sentences by first character
        Map<Character, List<String>> groupedWords = Arrays.stream(sentences)
                .flatMap(sentence -> Arrays.stream(sentence.split("\\s+")))
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(word -> word.charAt(0)));
        System.out.println("Words grouped by first character: " + groupedWords);
    }
}
