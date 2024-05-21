package com.java.java8feature;

public class MethodReferenceAllInOne {

	MethodReferenceAllInOne(String name) {
		System.out.println("In constuctor:" + name);
	}

	MethodReferenceAllInOne() {
	}

	public static void main(String[] args) {

		Calculator cal = (a, b) -> a + b;
		System.out.println("Using lambda::" + cal.show(1, 2));

		Calculator m = MethodReferenceAllInOne::multiply;
		System.out.println("Static::" + m.show(1, 5));

		Calculator m1 = new MethodReferenceAllInOne()::show;
		System.out.println("instance::" + m1.show(1, 5));

		// Constructor
		AbcInterface abc = MethodReferenceAllInOne::new;
		abc.show("Arko");

	}

	void printName(String name) {
		System.out.println("Name:" + name);
	}

	int show(int a, int b) {
		return a * b;
	}

	int cube(int a) {
		return a;
	}

	static int multiply(int a, int b) {
		return a * b;
	}
}

interface Calculator {
	int show(int a, int b);

	default void inDefault(int a, int b) {
		System.out.println("A:" + a + " :B: " + b);
	}
}

interface AbcInterface {
	MethodReferenceAllInOne show(String s);

	default void inDefault(int a, int b) {
		System.out.println("A:" + a + " :B: " + b);
	}
}