package com.example.stringbased;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class StringBased {
public static void main(String[] args) {
		
		String[] names = {"Alice", "Bob", "Charlie","Aravind","Bob","charlies"};
		
		long count =Arrays.stream(names).filter(s ->s.toLowerCase().startsWith("a")).count();
		System.out.println("Count valueis"+count);
		
		String[] substring = Arrays.stream(names).distinct().filter(s->s.contains("a")).toArray(String[]::new);
		System.out.println(Arrays.toString(substring));
		
		String[] descendingsort=Arrays.stream(names).sorted((s1,s2) -> s2.compareTo(s1)).toArray(String[]::new);
		System.out.println(Arrays.toString(descendingsort));

		String[] ascendingsort=Arrays.stream(names).sorted((s1,s2) -> s1.compareTo(s2)).toArray(String[]::new);
		System.out.println(Arrays.toString(ascendingsort));
		
		
		List<String> suppercase = Arrays.stream(names).map(String::toUpperCase).collect(Collectors.toList());
		System.out.println("Uppercases"+suppercase);
		
		String longeststring = Arrays.stream(names).max((s1,s2) ->s1.length() -s2.length()).orElse("Nos");
		System.out.println("longeststring"+longeststring);
       
		String[] sentences= {"Java is fun","Java is powerful","streams were good"};
		
		Set<String> uniquewords = Arrays.stream(sentences).flatMap(sentence-> Arrays.stream(sentence.split("\\s+")))
		.map(String::toLowerCase).collect(Collectors.toSet());
		
		System.out.println("uniquewords is"+uniquewords);
			
		Map<String, Long> senetcefrequency = Arrays.stream(sentences).flatMap(sentence -> Arrays.stream(sentence.split("\\s+"))).map(String::toLowerCase)
		.collect(Collectors.groupingBy( w -> w,Collectors.counting()));
		System.out.println(senetcefrequency);
		Optional<Object> frquentwod= senetcefrequency.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry:: getKey);
		System.out.println(frquentwod);
		
		
		 Map<Object, List<String>> mp = Arrays.stream(names).collect(Collectors.groupingBy(name -> name.charAt(0)));
		 System.out.println(mp);
		 
		 
		 Map<Object, List<String>> sentencefrequency = Arrays.stream(sentences).flatMap(s -> Arrays.stream(s.split("\\+s"))).map(String::toLowerCase).collect(Collectors.groupingBy(n-> n.charAt(0)));
		 System.out.println(sentencefrequency);
		 
}
}