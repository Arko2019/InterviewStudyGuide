package com.java.java8feature;

import java.util.Date;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class BuildInFunctionalInterface {

	public static void main(String[] args) {

		// Takes request and return response as boolean ex: take input as integer and
		// return boolean
		Predicate<String> p1 = a -> a != null;
		System.out.println("Predicate: " + p1.test("Hello"));

		// Takes request and return response as boolean ex: take input as integer and
		// return boolean with ! operator

		System.out.println("Predicate negate: " + p1.negate().test("Hello"));

		// Takes request and return response ex: take input as string and return boolean
		Function<String, Integer> getLength = s -> s.length();
		System.out.println("Function: " + getLength.apply("Hello"));

		Function<String, Boolean> fn = s -> s != null && s.length() > 0;
		System.out.println("Function2: " + fn.apply("Hello"));

		// Takes request in form of parameter and return nothing
		Consumer<String> printName = pN -> System.out.println("Consumer:" + pN);
		printName.accept("Hello");

		// Do not take any input but gives response
		Supplier<Date> sup = () -> new Date();
		System.out.println("Supplier:" + sup.get());

		// ==============Chaning===================================

		// Predicate Joining/Chaining we can join multiple predicate
		Predicate<String> p2 = a -> a.length() < 10;
		System.out.println("Predicate joining and: " + p1.and(p2).test("hello"));
		System.out.println("Predicate joining or: " + p1.or(p2).test("hello Welcome to future"));

		Function<Integer, Integer> fC1 = s -> s * s;
		Function<Integer, Integer> fC2 = s -> s + 2;

		System.out.println("Function Chaning: " + fC1.andThen(fC2).apply(4));

		// ==============Bi===================================
		// Predicate with 2 input
		BiPredicate<String, String> p3 = (a, b) -> a.length() < b.length();
		System.out.println("Bi Predicate:" + p3.test("Hello", "hello Hii"));

	}

}
