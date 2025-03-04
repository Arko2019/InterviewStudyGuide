package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Java8AllInOneTest {

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
		//mergeAndPrintPhoneNo(list);
		// convertListToMap(list);
		// convertListToMapAndSortInAssOrder(list);
		// convertListToMapAndSortInDescOrder(list);
		// maxSalaryOfEmployeeBasedOnDepartment(list);
		// convertingPrimitiveStreamsToObjectStream(list);
	}

	private static void mergeAndPrintPhoneNo(List<Employee> list) {
		list.stream().map(Employee::getPhNo).flatMap(l->l.stream()).toList();

	}

	private static void printEmployeeBaseOnDepartmentWithCount(List<Employee> list) {
		Map<String, Long> map = list.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
		System.out.println(map);
	}

	private static void printEmployeeBaseOnDepartment(List<Employee> list) {
		Map<String, List<Employee>> map = list.stream().collect(Collectors.groupingBy(Employee::getDepartment));
		System.out.println(map);
	}

	private static void sortEmployeeBaseOnDepartmentAndSalary(List<Employee> list) {
		list.stream().sorted(Comparator.comparing(Employee::getDepartment).thenComparing(Employee::getSalary)).toList()
				.forEach(System.out::println);

	}

	private static void sortEmployeeInReverseByName(List<Employee> list) {
		list.stream().sorted(Comparator.comparing(Employee::getName).reversed()).toList().forEach(System.out::println);

	}

	private static void sortEmployeeByName(List<Employee> list) {
		list.stream().sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList())
				.forEach(System.out::println);

	}

	private static void distinctDepartment(List<Employee> list) {
		list.stream().map(Employee::getDepartment).distinct().forEach(k -> System.out.println(k));
	}

	private static void minimumSalary(List<Employee> list) {
		Employee min = list.stream().min(Comparator.comparing(Employee::getSalary)).get();
		System.out.println(min);
	}

	private static void heighestSalary(List<Employee> list) {
		Employee max = list.stream().max(Comparator.comparing(Employee::getSalary)).get();
		System.out.println(max);
	}

	private static void checkSalary(List<Employee> list) {
		List<Employee> filteredList = list.stream().filter(k -> k.getSalary() > 4000).collect(Collectors.toList());

		System.out.println(filteredList);
	}

}
