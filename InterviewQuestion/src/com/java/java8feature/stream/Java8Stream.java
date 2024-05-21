package com.java.java8feature.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Java8Stream {

	public static void main(String[] args) {
		// 1. Source of data
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

		// 2. Converts source into java8 stream
		Stream<Integer> stream = list.stream();

		// 3. Intermediate operation
		Stream<Integer> filter = stream.filter(k -> k > 3);

		// visited once in life time
		// stream.filter(k->k>3);// stream has already been operated upon or closed

		// 4. Intermediate operation
		Stream<Integer> map = filter.map(k -> k * k);

		// Terminal Operation
		map.forEach(k -> System.out.println(k));

	}

}
