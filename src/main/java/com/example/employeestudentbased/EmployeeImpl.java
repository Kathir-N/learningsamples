package com.example.employeestudentbased;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeImpl {
public static void main(String[] args) {
    List<Employee> employees = Arrays.asList(
        new Employee(1, "Arun", "HR", 45000, 28,"Male",2010,"Chennai"),
        new Employee(2, "Bala", "IT", 70000, 32,"Male",2015,"Banglore"),
        new Employee(3, "Chitra", "Finance", 50000, 45,"FeMale",2000,"Chennai"),
        new Employee(4, "Divya", "IT", 90000, 29,"Female",2020,"Mumbai"),
        new Employee(5, "Eashwar","HR", 30000, 25,"Male",2024,"Mumbai")
    );

    System.out.println("Find Employees with the Longest Tenure:");
    Employee longestTenure = employees.stream().min(Comparator.comparingInt(Employee::getYearOfJoining)).get();
    System.out.println(longestTenure);

    System.out.println("Count Employees Per Location: Group employees by city and count how many work in each location:");
    Map<String, Long> employeeCountByCity = employees.stream()
        .collect(Collectors.groupingBy(Employee::getCity, Collectors.counting()));
    System.out.println(employeeCountByCity);

    System.out.println("Sort based on DOJ before 2017:");
    List<Employee> sortedByDOJ = employees.stream()
        .filter(e -> e.getYearOfJoining() < 2017)
        .sorted(Comparator.comparing(Employee::getYearOfJoining))
        .toList();
    System.out.println(sortedByDOJ);

    System.out.println("Sort based on IT department:");
    employees.stream().filter(e -> e.getDepartment().equals("IT")).forEach(System.out::println);

    System.out.println("Sort based on names:");
    employees.stream().map(Employee::getName).forEach(System.out::println);

    System.out.println("Sort based on department:");
    Map<String, List<Employee>> employeesByDepartment = employees.stream()
        .collect(Collectors.groupingBy(Employee::getDepartment));
    System.out.println(employeesByDepartment);

    System.out.println("Sort based on department count:");
    Map<String, Long> departmentCount = employees.stream()
        .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
    System.out.println(departmentCount);

    System.out.println("Sort based on Max salary:");
    employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).forEach(System.out::println);
    Optional<Employee> maxSalary = employees.stream().max(Comparator.comparing(Employee::getSalary));
    System.out.println(maxSalary);

    System.out.println("Sort based on Average salary for all departments:");
    Map<String, Double> averageSalaryByDept = employees.stream()
        .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
    System.out.println(averageSalaryByDept);

    System.out.println("Sort based on second largest salary:");
    List<Employee> secondHighestSalary = employees.stream()
        .sorted(Comparator.comparing(Employee::getSalary).reversed())
        .skip(1)
        .collect(Collectors.toList());
    System.out.println(secondHighestSalary);
}
}
