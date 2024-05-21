package com.java.java8feature.stream;

import java.util.Date;
import java.util.stream.Stream;

public class Java8StreamIterateGenerate {

	public static void main(String[] args) {
		
		Stream.iterate(1, n->n+1)// Infinite Stream
		.limit(10) 
		.forEach(System.out::println);

		Stream.generate(() -> new Date())// Infinite Stream
		.limit(10) 
		.forEach(System.out::println);
		
		Stream.iterate(1, n->n+1)// Infinite Stream
		.takeWhile(n->n<10) 
		.forEach(System.out::println);
		

	}

}
