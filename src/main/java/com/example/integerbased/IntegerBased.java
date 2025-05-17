package com.example.integerbased;


import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntegerBased {
	public static void main(String[] args) {
		
		IntStream.range(1, 11).forEach(System.out::println);
		
		int a[]= {1,98,7,2,3,4,5,1,2};
		
		int[] asscedn = Arrays.stream(a).sorted().toArray();
		System.out.println(Arrays.toString(asscedn));
		
		
		List<java.lang.Integer> descending = Arrays.stream(a).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println(descending);
		
		int sumno = Arrays.stream(a).sum();
		System.out.println(sumno);
		
		 int maximumno = Arrays.stream(a).max().getAsInt();
		 System.out.println(maximumno);
		 
		  int min = Arrays.stream(a).boxed().min(Comparator.naturalOrder()).orElse(10);
		  
	      System.out.println(min);
	
	     List<java.lang.Integer> evennos = Arrays.stream(a).boxed().filter(n -> n%2==0).collect(Collectors.toList());
	     System.out.println(evennos);
		 
	     Arrays.stream(a).boxed().filter(n -> n%2==0).collect(Collectors.toList());
	     
	    Map<Boolean, List<java.lang.Integer>> map = Arrays.stream(a).boxed().collect(Collectors.partitioningBy(n -> n%2==0));
	    System.out.println(map.get(true));
	    System.out.println(map.get(false));
	    
	    
	    Map<Object, Long> countfrquency = Arrays.stream(a).boxed().collect(Collectors.groupingBy(n->n,Collectors.counting()));
	    System.out.println(countfrquency);
	    
      List<Object> freq = countfrquency.entrySet().stream().filter(n -> n.getValue() > 1).map(entry -> entry.getKey()).toList();
    	System.out.println(freq);
    	
    	Set<Integer> s=new HashSet<>();
    	
    	 
    	 Optional<java.lang.Integer> firstNonRepeating = Arrays.stream(a)
    			    .boxed()
    			    .collect(Collectors.groupingBy(n -> n, LinkedHashMap::new, Collectors.counting()))
    			    .entrySet().stream()
    			    .filter(e -> e.getValue() == 1)
    			    .map(Map.Entry::getKey)
    			    .findFirst();
    			System.out.println(firstNonRepeating.orElse(-1)); // returns first non-repeating number or -1

    	
    	 
    	
    	
	     
		
		
		
	}

}
