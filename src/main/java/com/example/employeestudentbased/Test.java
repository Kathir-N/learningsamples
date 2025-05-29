package com.example.employeestudentbased;

import java.awt.SystemColor;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Test {
	public static void main(String[] args) {
		
		List<Employee> emp= Arrays.asList(
			    new Employee(1, "Arun", "HR", 45000, 28,"Male",2010,"Chennai"),
			    new Employee(2, "Bala", "IT", 70000, 32,"Male",2015,"Banglore"),
			    new Employee(3, "Chitra", "Finance", 50000, 45,"FeMale",2000,"Chennai"),
			    new Employee(4, "Divya", "IT", 90000, 29,"Female",2020,"Mumbai"),
			    new Employee(5, "Arun","HR", 30000, 25,"Male",2024,"Mumbai")
			);
		
		
		List<String> dist = emp.stream().map(n -> n.getName()).distinct().toList();
		
		System.out.println(dist);

		
	 Double maxsalaaryy = emp.stream().map(n -> n.getSalary()).min(Comparator.naturalOrder()).get();
		System.out.println(maxsalaaryy);
		
		 List<Double> maxsalaary = emp.stream().map(n -> n.getSalary()).sorted(Comparator.reverseOrder()).skip(1).limit(1).toList();
		
		 System.out.println(maxsalaary);
		 
		 
		 List<Employee> deptit = emp.stream().filter(z -> z.getDepartment().equals("IT")).map(s -> s).collect(	Collectors.toList());
		 
		 System.out.println(deptit);
		 
     
		 
		 List<Employee> sortyerofjoining = emp.stream().filter(z->z.getYearOfJoining() > 2017)			 
				 .sorted(Comparator.comparing(Employee::getYearOfJoining))
		         .collect(Collectors.toList());
				 
		 
		 System.out.println(sortyerofjoining);
		 
		 

		 
		 
		 
		 
			}

}
