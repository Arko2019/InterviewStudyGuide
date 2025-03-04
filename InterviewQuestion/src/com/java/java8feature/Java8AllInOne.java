package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Java8AllInOne {

//		Counting frequency of each character
//		Return 2nd largest number
//		Make the 2nd character of every word upperCase
//		Square each number in the list and collect the result in a new list
//		group words by their lengths and collect the result into a Map.
//		find sum of all nos in a list

	public static void main(String[] args) {
		List<Employee> list = new ArrayList<>();

		list.add(new Employee(1, "AAAA", 35, "Marketing", 2000,
				Arrays.asList(11111111, 2222222, 3333333, 444444, 555555)));
		list.add(new Employee(6, "BBBB", 36, "Sales", 4000, Arrays.asList(7, 8, 9)));
		list.add(new Employee(3, "CCCC", 37, "HR", 5000, Arrays.asList(11, 21, 31, 41, 51)));
		list.add(new Employee(2, "DDDD", 38, "Development", 6000, Arrays.asList(1, 2, 3, 4, 5)));
		list.add(new Employee(4, "EEEE", 35, "Marketing", 2000, Arrays.asList(12, 23, 43, 44, 54)));
		list.add(new Employee(5, "FFFF", 35, "Sales", 9000, Arrays.asList(12, 23, 43, 44, 54)));
		list.add(new Employee(7, "GGGG", 35, "Sales", 9000, Arrays.asList(12, 23, 43, 44, 54)));
		String str = "Hello";

		List<Integer> list2 = Arrays.asList(1, 2, 1, 3, 4, 5, 1, 2, 6, 9, 7, 8);
//		int a[]={2,2,2,10,15,8,39,10,35,88,62,75};
//		List<int[]> list2 =Arrays.asList(a);
		// printEmployee(list);
		// checkSalary(list); // l.salary > 4000
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
		// convertingPrimitiveStreamsToObjectStream(list);
//				Return 2nd largest number
		// return2ndLargestNo(list);
		// findFrequencyOfCharacter(str);
		// removeDublicateAndSort(list2);
		// findDublicatesInList(list3);
		secondHeighestNo(list2);
	}
	static void reversePairs() {
		int[] arr = {10, 20, 30, 40, 50, 60, 70, 80}; 
		int[] result= IntStream.range(0, arr.length)
		 .map(i-> (i%2==0 && i+1 <arr.length) ? arr[i+1]:arr[i-1]).toArray();
		System.out.println(Arrays.toString(result));
	}
	void reverseWordInString() {
		String s = "Hello How Are you";

		// s.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		String[] s1 = s.split(" ");
		List<String> list = Arrays.asList(s1);
		List<String> words = list.stream().map(k -> new StringBuilder(k).reverse().toString()).toList();
		String result = String.join(" ", words);
		System.out.println(result);
	}

	private static void removeDublicateAndSort(List<Integer> list2) {
		list2.stream().distinct().sorted().toList();
	}

	private static void secondHeighestNo(List<Integer> list2) {
		Optional<Integer> secondLargest = list2.stream().distinct().sorted(Comparator.reverseOrder()).skip(1)
				.findFirst();
		System.out.println(secondLargest.get());

	}

	private static void findFrequencyOfCharacter(String str) {

		str.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

//		Map<Character, Long> frequency = str.chars().mapToObj(c -> (char) c)
//				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//		System.out.println(frequency);
	}

	private static void return2ndLargestNo(List<Employee> list) {
		Optional<Integer> emp = list.stream().sorted(Comparator.comparing(Employee::getSalary).reversed())
				.map(Employee::getSalary).distinct().limit(2).skip(1).findFirst();

		System.out.println(emp.get());
	}

	private static void convertingPrimitiveStreamsToObjectStream(List<Employee> list) {
		// TODO Auto-generated method stub
		IntStream intStream = list.stream().mapToInt(Employee::getSalary);
		System.out.println(intStream.boxed());
	}

	private static void maxSalaryOfEmployeeBasedOnDepartment(List<Employee> list) {
		Map<String, Optional<Employee>> map = list.stream().collect(Collectors.groupingBy(Employee::getDepartment,
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
		Map<Integer, String> map2 = map.entrySet().stream().sorted(Map.Entry.<Integer, String>comparingByKey())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (o, n) -> o, LinkedHashMap::new));
		System.out.println(map2);
	}

	private static void convertListToMap(List<Employee> list) {
		Map<String, Integer> map = list.stream().collect(Collectors.toMap(Employee::getName, Employee::getAge));
		System.out.println(map);

	}

	private static void mergeAndPrintPhoneNo(List<Employee> list) {
		List<Integer> listPhNo = list.stream().map(k -> k.getPhNo()).flatMap(l -> l.stream()).toList();
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

		// list.stream().max(Comparator.comparing(Employee::getSalary))
		// .map(Employee::getName).get();

		Employee e = list.stream().max(Comparator.comparing(Employee::getSalary)).get();
//			System.out.println(e);

	}

	private static void printEmployeeName(List<Employee> list) {

		list.stream().filter(k -> k.department == "Sales").map(l -> l.getName()).forEach(System.out::println);
		// list.stream().filter(k -> k.getDepartment() ==
		// "Sales").map(Employee::getName).forEach(System.out::println);

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