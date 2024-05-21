package com.java.java8feature;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Java8AllInOne {

	public static void main(String[] args) {
		List<Employee> list = new ArrayList<>();

		list.add(new Employee(1, "AAAA", 35, "Marketing", 2000, Arrays.asList(1, 2, 3, 4, 5)));
		list.add(new Employee(6, "BBBB", 36, "Sales", 4000, Arrays.asList(7, 8, 9)));
		list.add(new Employee(3, "CCCC", 37, "HR", 5000, Arrays.asList(11, 21, 31, 41, 51)));
		list.add(new Employee(2, "DDDD", 38, "Development", 6000, Arrays.asList(1, 2, 3, 4, 5)));
		list.add(new Employee(4, "EEEE", 35, "Marketing", 2000, Arrays.asList(12, 23, 43, 44, 54)));
		list.add(new Employee(5, "FFFF", 35, "Sales", 9000, Arrays.asList(12, 23, 43, 44, 54)));
		list.add(new Employee(7, "GGGG", 35, "Sales", 9000, Arrays.asList(12, 23, 43, 44, 54)));

		// printEmployee(list);
		// checkSalary(list);
		// printEmployeeName(list);// who is sales
		// heighestSalary(list);
		// minimumSalary(list);
		// distinctDepartment(list);
		// sortEmployeeByName(list);
		// sortEmployeeInReverseByName(list);
		// sortEmployeeInReverseById(list);
		// sortEmployeeBaseOnSalary(list);
		// sortEmployeeBaseOnSalaryReversed(list);
		// sortEmployeeBaseOnDepartmentAndSalary(list);
		// printEmployeeBaseOnDepartment(list);
		// printEmployeeBaseOnDepartmentWithCount(list);
		// mergeAndPrintPhoneNo(list);
		// convertListToMap(list);
		// convertListToMapAndSortInAssOrder(list);
		// convertListToMapAndSortInDescOrder(list);
		// maxSalaryOfEmployeeBasedOnDepartment(list);
		convertingPrimitiveStreamsToObjectStream(list);
	}

	
	private static void convertingPrimitiveStreamsToObjectStream(List<Employee> list) {
		// TODO Auto-generated method stub
		IntStream intStream = list
                .stream()
                .mapToInt(Employee::getSalary);
        System.out.println(intStream.boxed());
	}


	private static void maxSalaryOfEmployeeBasedOnDepartment(List<Employee> list) {
		Map<String, Optional<Employee>> map=list.stream().collect(Collectors.groupingBy(Employee::getDepartment,
				Collectors.reducing(BinaryOperator.maxBy(Comparator.comparing(Employee::getSalary)))));
				System.out.println(map);
		
	}

	private static void convertListToMapAndSortInDescOrder(List<Employee> list) {
		Map<Integer, String> map = list.stream()
				.collect(Collectors.toMap(Employee::getId, Employee::getName, (oldValue, newValue) -> oldValue));
		Map<Integer, String> map2 = map.entrySet().stream()
				.sorted(Map.Entry.<Integer, String>comparingByKey().reversed()).collect(Collectors.toMap(
						Map.Entry::getKey, Map.Entry::getValue, (oldData, newData) -> oldData, LinkedHashMap::new));
		System.out.println(map2);

	}

	private static void convertListToMapAndSortInAssOrder(List<Employee> list) {
		Map<Integer, String> map = list.stream().collect(Collectors.toMap(Employee::getId, Employee::getName));
		Map<Integer, String> map2 = map.entrySet().stream()
				.sorted(Map.Entry.<Integer, String>comparingByKey())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (o, n) -> o, LinkedHashMap::new));
		System.out.println(map2);
	}

	private static void convertListToMap(List<Employee> list) {
		Map<String, Integer> map = list.stream().collect(Collectors.toMap(Employee::getName, Employee::getAge));
		System.out.println(map);

	}

	private static void mergeAndPrintPhoneNo(List<Employee> list) {
		List<Integer> listPhNo = list.stream().map(k -> k.getPhNo()).flatMap(Collection::stream).toList();
		System.out.println(listPhNo);
	}

	private static void printEmployeeBaseOnDepartmentWithCount(List<Employee> list) {
		Map<String, Long> emp = list.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
		System.out.println(emp);
	}

	private static void printEmployeeBaseOnDepartment(List<Employee> list) {
		Map<String, List<Employee>> emp = list.stream().collect(Collectors.groupingBy(Employee::getDepartment));

		System.out.println(emp);

	}

	private static void sortEmployeeBaseOnDepartmentAndSalary(List<Employee> list) {
		list.stream().sorted(Comparator.comparing(Employee::getSalary).thenComparing(Employee::getId))
				.forEach(System.out::println);

	}

	private static void sortEmployeeBaseOnSalaryReversed(List<Employee> list) {
		list.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).forEach(System.out::println);

	}

	private static void sortEmployeeBaseOnSalary(List<Employee> list) {
		list.stream().sorted(Comparator.comparing(Employee::getSalary)).forEach(System.out::println);

	}

	private static void sortEmployeeInReverseByName(List<Employee> list) {
		list.stream().sorted(Comparator.comparing(Employee::getName).reversed()).forEach(System.out::println);

	}

	private static void sortEmployeeInReverseById(List<Employee> list) {
		list.stream().sorted((f1, f2) -> Long.compare(f2.getId(), f1.getId())).forEach(System.out::println);

	}

	private static void sortEmployeeByName(List<Employee> list) {
		list.stream().sorted(Comparator.comparing(Employee::getId)).forEach(System.out::println);

	}

	private static void distinctDepartment(List<Employee> list) {
		list.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);

	}

	private static void minimumSalary(List<Employee> list) {
		Employee e = list.stream().min(Comparator.comparing(Employee::getSalary)).get();
		System.out.println(e);

	}

	private static void heighestSalary(List<Employee> list) {
		String e = list.stream().max(Comparator.comparing(Employee::getSalary)).map(Employee::getName).get();
		System.out.println(e);

	}

	private static void printEmployeeName(List<Employee> list) {
		list.stream().filter(k -> k.getDepartment() == "Sales").map(Employee::getName).forEach(System.out::println);

	}

	private static void checkSalary(List<Employee> list) {
		list.stream().filter(l -> l.salary > 4000).forEach(System.out::println);

	}

	public static void printEmployee(List<Employee> list) {
		list.stream().forEach(System.out::println);
	}
}

class Employee {
	int id;
	String name;
	int age;
	String department;
	int salary;
	List<Integer> phNo;

	public Employee(int id, String name, int age, String department, int salary, List<Integer> phNo) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.department = department;
		this.salary = salary;
		this.phNo = phNo;
	}

	public List<Integer> getPhNo() {
		return phNo;
	}

	public void setPhNo(List<Integer> phNo) {
		this.phNo = phNo;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", department=" + department + ", salary="
				+ salary + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}