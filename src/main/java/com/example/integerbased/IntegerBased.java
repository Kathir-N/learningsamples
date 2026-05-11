package com.example.integerbased;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntegerBased {
    public static void main(String[] args) {
        
        // Print numbers from 1 to 10
Numbers from 1 to 10:
Array after replacing 5 with 55: [1, 98, 7, 2, 3, 4, 55, 1, 2]
Sorted Array (Ascending Order): [1, 1, 2, 2, 3, 4, 7, 55, 98]
Sorted Array (Descending Order): [98, 55, 7, 4, 3, 2, 2, 1, 1]
Sum of Array Elements: 173
Maximum Value: 98
Minimum Value: 1
Even Numbers: [98, 2, 4, 2]
Partitioned (Even Numbers): [98, 2, 4, 2]
Partitioned (Odd Numbers): [1, 7, 3, 55, 1]
Frequency Count: {1=2, 98=1, 7=1, 2=2, 3=1, 4=1, 55=1}
Repeating Numbers: [1, 2]
First Non-Repeating Number: 98
Repeating Numbers (Using TreeMap): [1, 2]
    

        
        System.out.println("Numbers from 1 to 10:");
        IntStream.range(1, 11).forEach(System.out::println);

        int a[] = {1, 98, 7, 2, 3, 4, 5, 1, 2};

        // Replace 5 with 55
        a = Arrays.stream(a).map(n -> n == 5 ? 55 : n).toArray();
        System.out.println("Array after replacing 5 with 55: " + Arrays.toString(a));

        // Sort array in ascending order
        int[] ascending = Arrays.stream(a).sorted(Comparator.naturalOrder()).toArray();
        System.out.println("Sorted Array (Ascending Order): " + Arrays.toString(ascending));

        // Sort array in descending order
        List<Integer> descending = Arrays.stream(a).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println("Sorted Array (Descending Order): " + descending);

        // Sum of array elements
        int sum = Arrays.stream(a).sum();
        System.out.println("Sum of Array Elements: " + sum);

        // Maximum value in array
        int max = Arrays.stream(a).max().orElseThrow();
        System.out.println("Maximum Value: " + max);

        // Minimum value in array (default to 10 if empty)
        int min = Arrays.stream(a).boxed().min(Comparator.naturalOrder()).orElse(10);
        System.out.println("Minimum Value: " + min);

        // Extract even numbers
        List<Integer> evenNumbers = Arrays.stream(a).boxed().filter(n -> n % 2 == 0).collect(Collectors.toList());
        System.out.println("Even Numbers: " + evenNumbers);

        // Partitioning into even and odd numbers
        Map<Boolean, List<Integer>> partitionedMap = Arrays.stream(a).boxed().collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("Partitioned (Even Numbers): " + partitionedMap.get(true));
        System.out.println("Partitioned (Odd Numbers): " + partitionedMap.get(false));

        // Count frequency of each number
        Map<Integer, Long> frequencyMap = Arrays.stream(a).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Frequency Count: " + frequencyMap);

        // Find numbers appearing more than once
        List<Integer> repeatingNumbers = frequencyMap.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();
        System.out.println("Repeating Numbers: " + repeatingNumbers);

        // First non-repeating number
        Optional<Integer> firstNonRepeating = Arrays.stream(a)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst();
        System.out.println("First Non-Repeating Number: " + firstNonRepeating.orElse(-1));

        // Find repeating numbers using TreeMap
        Map<Integer, Long> repeatMap = Arrays.stream(a).boxed()
                .collect(Collectors.groupingBy(Function.identity(), TreeMap::new, Collectors.counting()));
        List<Integer> finalRepeatingValues = repeatMap.entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();
        System.out.println("Repeating Numbers (Using TreeMap): " + finalRepeatingValues);
    }
}
